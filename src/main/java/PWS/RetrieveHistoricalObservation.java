package PWS;
import org.json.JSONArray;

import java.time.LocalDate;
import java.util.List;

import static PWS.DateUtil.getDatesBetween;

public class RetrieveHistoricalObservation {
    LocalDate startDate;
    LocalDate endDate;
    String ApiKey;
    String StationID;

    public RetrieveHistoricalObservation(LocalDate startDate, LocalDate endDate, String apiKey, String stationID) {
        this.startDate = startDate;
        this.endDate = endDate;
        ApiKey = apiKey;
        StationID = stationID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getApiKey() {
        return ApiKey;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }

    public String getStationID() {
        return StationID;
    }

    public void setStationID(String stationID) {
        StationID = stationID;
    }

    public void RetrieveHistoricalObservationFull (){
        List<String> listTS =  getDatesBetween(startDate,endDate);
        for(int i=0;i<listTS.size();i++){
            System.out.println(listTS.get(i));
            GetObservation RCO = new GetObservation(ApiKey, StationID);
            JSONArray dailyObservationArray = RCO.getDailyObservation(PWS.DateUtil.getYesterdayDateString("yyyyMMdd"));
        }

    }



}
