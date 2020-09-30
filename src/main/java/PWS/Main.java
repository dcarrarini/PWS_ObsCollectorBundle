package PWS;

import dbop.MySQLConnector;
import dbop.MySQLdbopDailyObs;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import static PWS.DateUtil.getDatesBetween;

public class Main {

    public static void main(String[] args) {
        try {
            String ApiKey = "5aeeb90c49f249c1aeb90c49f289c138";
            String StationID = "ISANVI15";
            GetObservation RCO = new GetObservation(ApiKey, StationID);
            RCO.setApiKey(ApiKey);
            RCO.setStationID(StationID);
            JSONArray currentObservationArray = RCO.getCurrentObservation();
            JSONArray dailyObservationArray = RCO.getDailyObservation(PWS.DateUtil.getYesterdayDateString("yyyyMMdd"));
            System.out.println(dailyObservationArray.length());

            //get localdate per recupero storico
            LocalDate startDate = LocalDate.parse("2020-03-01");
            LocalDate endDate = LocalDate.parse("2020-09-30");

            //System.out.println(convertLocalDateToString(startDate));

            List<String> lista =  getDatesBetween(startDate,endDate);
            for(int i=0;i<lista.size();i++){
                System.out.println(lista.get(i));
            }


            //Connessione MYSQL
	          /*
	            MySQLConnector msc = new MySQLConnector();
	            Connection dcConn = MySQLConnector.getMYSQLDBConnection();
	            System.out.println(dcConn.getClass());
	           */

            //Recupero storico
            RetrieveHistoricalObservation rho = new RetrieveHistoricalObservation(startDate,endDate,ApiKey,StationID);
            rho.RetrieveHistoricalObservationFull();
            System.out.println("Recupero completato");
            /*
            //DAILY OBSERVATION
            try {
                MySQLConnector mySQLConn = new MySQLConnector();
                Connection connection = mySQLConn.getMYSQLDBConnection();
                for (int i = 0; i < dailyObservationArray.length(); i++) {
                    //DailyObservation observation = RCO.createDailyObservation(dailyObservationArray);
                    JSONObject obs = dailyObservationArray.getJSONObject(i);
                    DailyObservation observation = RCO.createDailyObservation(obs);
                    ObsExporter obsExporter = new ObsExporter(observation,PWS.DateUtil.getYesterdayDateString("yyyyMMdd"));
                    obsExporter.createCSVFile();
                    MySQLdbopDailyObs mysqldaily = new MySQLdbopDailyObs(connection, observation);
                    mysqldaily.addDailyObs();
                }
                connection.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

             */
 /*
            //CURRENT OBSERVATION
            try {
                Observation observation = RCO.createCurrentObservation(currentObservationArray);
                System.out.println(observation.getNeighborhood());
            } catch (Exception e) {
                e.printStackTrace();
            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}