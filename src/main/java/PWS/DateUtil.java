package PWS;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateUtil {

    static String date;

    public static String getSysdate(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(new Date());
        return date;
    }

    private static Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static String getYesterdayDateString(String pattern) {
        SimpleDateFormat simpleDateFormatt = new SimpleDateFormat(pattern);
        date = simpleDateFormatt.format(yesterday());
        return date;
    }

    public static String alignTS(String sDate) {
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(sDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = simpleDateFormat.format(DateUtils.addMinutes(date1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String convertLocalDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }

    public static List<String> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {
        List<LocalDate> listDateTS = getDatesBetweenDates(startDate, endDate);
        List<String> listTS = new ArrayList<String>();
        for (int i = 0; i < listDateTS.size(); i++) {
            listTS.add(i, convertLocalDateToString(listDateTS.get(i)));
        }
        return listTS;
    }

    public static List<LocalDate> getDatesBetweenDates(
            LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }
}
