package PWS;
import org.apache.commons.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;
import org.json.JSONArray;


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
        try (
                FileWriter fw = new FileWriter("C:\\Dropbox\\PWS_DATA\\"+sTS+".csv", true);
                BufferedWriter writer = new BufferedWriter(fw);
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
               // CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
               //         .withHeader("ID", "Name", "Designation", "Company"));
        ) {
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
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
