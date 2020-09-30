package PWS;
/**
 * @Applicatio Personal PWS Monitor
 * @author diego carrarini
 * @last 22/09/2020
 * @version 1.10
 * @since 20/09/2020
 */

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static PWS.DateUtil.alignTS;

public class GetObservation {

    static String ApiKey;
    static String StationID;
    static String ts;

    String stationID;
    String obsTimeUtc;
    String obsTimeLocal;
    String neighborhood;
    String softwareType;
    String country;
    String solarRadiation;
    String lon;
    String lat;
    String uv;
    String winddir;
    String humidity;
    String temp;
    String heatIndex;
    String dewpt;
    String windChill;
    String windSpeed;
    String windGust;
    String pressure;
    String pressureMax;
    String pressureMin;
    String pressureAvg;
    String pressureTrend;
    String precipRate;
    String precipTotal;
    String elev;

    public GetObservation(String apiKey, String stationID) {
        ApiKey = apiKey;
        StationID = stationID;
    }

    public GetObservation(String apiKey, String stationID, String ts) {
        ApiKey = apiKey;
        StationID = stationID;
    }

    public static String getApiKey() {
        return ApiKey;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }

    public static String getStationID() {
        return StationID;
    }

    public void setStationID(String stationID) {
        StationID = stationID;
    }

    public static String getTs() {
        return ts;
    }

    public static void setTs(String ts) {
        PWS.GetObservation.ts = ts;
    }

    public JSONArray getCurrentObservation() {
        JSONObject obj;
        JSONArray observation = null;
        try {
            String sURL = "https://api.weather.com/v2/pws/observations/current?stationId=" + this.getStationID()
                    + "&format=json&units=m&numericPrecision=decimal&apiKey=" + this.getApiKey();
            URL url = new URL(sURL);
            // Gestione della risposta
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = StringEscapeUtils.unescapeJava(br.readLine());
            obj = new JSONObject(output);
            observation = obj.getJSONArray("observations");
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return observation;
    }

    public JSONArray getDailyObservation(String sTS) {
        JSONObject obj;
        JSONArray observation = null;
        try {
            String sURL = "https://api.weather.com/v2/pws/history/all?stationId=" + this.getStationID()
                    + "&format=json&units=m&date=" + sTS + "&apiKey=" + this.getApiKey();
            URL url = new URL(sURL);
            // Gestione della risposta
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = StringEscapeUtils.unescapeJava(br.readLine());
            obj = new JSONObject(output);
            observation = obj.getJSONArray("observations");
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return observation;
    }

    public PWS.Observation createCurrentObservation(JSONArray observation) {

        PWS.Observation CurrentObservation = null;
        try {
            for (int i = 0; i < observation.length(); i++) {
                JSONObject obs = observation.getJSONObject(i);
                JSONObject ObservationMetric = obs.getJSONObject("metric");
                stationID = observation.getJSONObject(i).getString("stationID");
                obsTimeUtc = observation.getJSONObject(i).getString("obsTimeUtc");
                obsTimeLocal = observation.getJSONObject(i).getString("obsTimeLocal");
                neighborhood = observation.getJSONObject(i).getString("neighborhood");
                softwareType = observation.getJSONObject(i).getString("softwareType");
                country = observation.getJSONObject(i).getString("country");
                solarRadiation = String.valueOf(observation.getJSONObject(i).getDouble("solarRadiation"));
                lon = String.valueOf(observation.getJSONObject(i).getDouble("lon"));
                lat = String.valueOf(observation.getJSONObject(i).getDouble("lat"));
                uv = String.valueOf(observation.getJSONObject(i).getDouble("uv"));
                winddir = String.valueOf(observation.getJSONObject(i).getDouble("winddir"));
                humidity = String.valueOf(observation.getJSONObject(i).getDouble("humidity"));
                temp = String.valueOf(ObservationMetric.getDouble("temp"));
                heatIndex = String.valueOf(ObservationMetric.getDouble("heatIndex"));
                dewpt = String.valueOf(ObservationMetric.getDouble("dewpt"));
                windChill = String.valueOf(ObservationMetric.getDouble("windChill"));
                windSpeed = String.valueOf(ObservationMetric.getDouble("windSpeed"));
                windGust = String.valueOf(ObservationMetric.getDouble("windGust"));
                pressure = String.valueOf(ObservationMetric.getDouble("pressure"));
                precipRate = String.valueOf(ObservationMetric.getDouble("precipRate"));
                precipTotal = String.valueOf(ObservationMetric.getDouble("precipTotal"));
                elev = String.valueOf(ObservationMetric.getDouble("elev"));
                CurrentObservation = new PWS.Observation(stationID, obsTimeUtc, obsTimeLocal, neighborhood, softwareType,
                        country, solarRadiation, lon, lat, uv, winddir, humidity, temp, heatIndex, dewpt, windChill,
                        windSpeed, windGust, pressure, precipRate, precipTotal, elev);

            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return CurrentObservation;
    }

    public PWS.DailyObservation createDailyObservation(JSONObject obs) {

        PWS.DailyObservation dailyObservation = null;
        try {
            //for (int i = 0; i < observation.length(); i++) {
            //JSONObject obs = observation.getJSONObject(i);
            JSONObject ObservationMetric = obs.getJSONObject("metric");
            stationID = obs.getString("stationID");
            obsTimeUtc = obs.getString("obsTimeUtc");
            obsTimeLocal = alignTS(obs.getString("obsTimeLocal"));
            try {
                solarRadiation = String.valueOf(obs.getDouble("solarRadiationHigh"));
            } catch (Exception e) {
                solarRadiation = null;
            }

            try {
                lon = String.valueOf(obs.getDouble("lon"));
            } catch (Exception e) {
                lon = null;
            }

            //solarRadiation = obs.getString("solarRadiationHigh");


            try {
                lat = String.valueOf(obs.getDouble("lat"));
            } catch (Exception e) {
                lat = null;
            }

            try {
                uv = String.valueOf(obs.getDouble("uvHigh"));
            } catch (Exception e) {
                uv = null;
            }

            try {
                winddir = String.valueOf(obs.getDouble("winddirAvg"));
            } catch (Exception e) {
                winddir = null;
            }

            try {
                humidity = String.valueOf(obs.getDouble("humidityAvg"));
            } catch (Exception e) {
                humidity = null;
            }

            try {
                temp = String.valueOf(ObservationMetric.getDouble("tempAvg"));
            } catch (Exception e) {
                temp = null;
            }

            try {
                heatIndex = String.valueOf(ObservationMetric.getDouble("heatindexAvg"));
            } catch (Exception e) {
                heatIndex = null;
            }

            try {
                dewpt = String.valueOf(ObservationMetric.getDouble("dewptAvg"));
            } catch (Exception e) {
                dewpt = null;
            }

            try {
                windChill = String.valueOf(ObservationMetric.getDouble("windchillAvg"));
            } catch (Exception e) {
                windChill = null;
            }

            try {
                windSpeed = String.valueOf(ObservationMetric.getDouble("windspeedAvg"));
            } catch (Exception e) {
                windSpeed = null;
            }

            try {
                windGust = String.valueOf(ObservationMetric.getDouble("windgustAvg"));
            } catch (Exception e) {
                windGust = null;
            }

            try {
                pressureMax = String.valueOf(ObservationMetric.getDouble("pressureMax"));
            } catch (Exception e) {
                pressureMax = null;
            }

            try {
                pressureMin = String.valueOf(ObservationMetric.getDouble("pressureMin"));
            } catch (Exception e) {
                pressureMin = null;
            }

            try {
                pressureTrend = String.valueOf(ObservationMetric.getDouble("pressureTrend"));
            } catch (Exception e) {
                pressureTrend = null;
            }

            try {
                precipRate = String.valueOf(ObservationMetric.getDouble("precipRate"));
            } catch (Exception e) {
                precipRate = null;
            }
            ;
            try {
                precipTotal = String.valueOf(ObservationMetric.getDouble("precipTotal"));
            } catch (Exception e) {
                precipTotal = null;
            }
            elev = "";
            dailyObservation = new PWS.DailyObservation(stationID, obsTimeUtc, obsTimeLocal, solarRadiation, lon, lat,
                    uv, winddir, humidity, temp, heatIndex, dewpt, windChill, windSpeed, windGust, pressureMax,
                    pressureMin, pressureTrend, precipRate, precipTotal);

            //	}
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return dailyObservation;
    }
}
