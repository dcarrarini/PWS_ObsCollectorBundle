package PWS;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;


public class ObsExporter {

    DailyObservation obs;
    String sTS;

    public ObsExporter(DailyObservation obs, String sTS) {
        this.obs = obs;
        this.sTS = sTS;
    }

    public DailyObservation getObs() {
        return obs;
    }

    public void setObs(DailyObservation obs) {
        this.obs = obs;
    }

    public String getsTS() {
        return sTS;
    }

    public void setsTS(String sTS) {
        this.sTS = sTS;
    }

    public void createCSVFile() throws IOException {
        try{
        File file = new File("C:\\Dropbox\\PWS_DATA\\" + sTS + ".csv");
         FileWriter fw = new FileWriter(file, true);
            //FileWriter fw = new FileWriter("C:\\Dropbox\\PWS_DATA\\" + sTS + ".csv", true);
                BufferedWriter writer = new BufferedWriter(fw);
                //CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            CSVPrinter csvPrinter;
                if (!file.exists()){
                    csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                            .withHeader("StationID",
                                    "ObsTimeLocal",
                                    "SolarRadiationHigh",
                                    "Lon",
                                    "Lat",
                                    "UvHigh",
                                    "WinddirAvg",
                                    "HumidityAvg",
                                    "TempAvg",
                                    "HeatIndexAvg",
                                    "DewptAvg",
                                    "WindchillAvg",
                                    "WindspeedAvg",
                                    "WindgustAvg",
                                    "PressureMax",
                                    "PressureMin",
                                    "PressureTrend",
                                    "PrecipRate",
                                    "PrecipTotal"));
                }else{
                    csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
                }


            csvPrinter.printRecord(obs.getStationID(),
                    obs.getObsTimeLocal(),
                    obs.getSolarRadiationHigh(),
                    obs.getLon(),
                    obs.getLat(),
                    obs.getUvHigh(),
                    obs.getWinddirAvg(),
                    obs.getHumidityAvg(),
                    obs.getTempAvg(),
                    obs.getHeatIndexAvg(),
                    obs.getDewptAvg(),
                    obs.getWindchillAvg(),
                    obs.getWindspeedAvg(),
                    obs.getWindgustAvg(),
                    obs.getPressureMax(),
                    obs.getPressureMin(),
                    obs.getPressureTrend(),
                    obs.getPrecipRate(),
                    obs.getPrecipTotal());
            csvPrinter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
