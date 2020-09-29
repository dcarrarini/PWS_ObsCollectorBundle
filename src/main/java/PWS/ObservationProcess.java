package PWS;
/**
 * @Applicatio Personal PWS Monitor
 * @author diego carrarini
 * @since 20/09/2020
 * @version 1.00
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ObservationProcess {
    JSONArray observation;

    public ObservationProcess(JSONArray observation) {
        this.observation = observation;
    }

    public JSONArray getObservation() {
        return observation;
    }

    public void setObservation(JSONArray observation) {
        this.observation = observation;
    }

    public String getObservationAsString() {
        JSONArray observation = getObservation();
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < observation.length(); i++) {
                JSONObject obs = observation.getJSONObject(i);
                JSONObject ObservationMetric = obs.getJSONObject("metric");
                sb.append("stationID:").append(observation.getJSONObject(i).getString("stationID")).append("||");
                sb.append("obsTimeUtc:").append(observation.getJSONObject(i).getString("obsTimeUtc")).append("||");
                sb.append("obsTimeLocal:").append(observation.getJSONObject(i).getString("obsTimeLocal")).append("||");
                sb.append("neighborhood:").append(observation.getJSONObject(i).getString("neighborhood")).append("||");
                sb.append("softwareType:").append(observation.getJSONObject(i).getString("softwareType")).append("||");
                sb.append("country:").append(observation.getJSONObject(i).getString("country")).append("||");
                sb.append("solarRadiation:").append(observation.getJSONObject(i).getDouble("solarRadiation")).append("||");
                sb.append("lon:").append(observation.getJSONObject(i).getDouble("lon")).append("||");
                sb.append("lat:").append(observation.getJSONObject(i).getDouble("lat")).append("||");
                sb.append("uv:").append(observation.getJSONObject(i).getDouble("uv")).append("||");
                sb.append("winddir:").append(observation.getJSONObject(i).getDouble("winddir")).append("||");
                sb.append("humidity:").append(observation.getJSONObject(i).getDouble("humidity")).append("||");
                sb.append("temp:").append(ObservationMetric.getDouble("temp")).append("||");
                sb.append("heatIndex:").append(ObservationMetric.getDouble("heatIndex")).append("||");
                sb.append("dewpt:").append(ObservationMetric.getDouble("dewpt")).append("||");
                sb.append("windChill:").append(ObservationMetric.getDouble("windChill")).append("||");
                sb.append("windSpeed:").append(ObservationMetric.getDouble("windSpeed")).append("||");
                sb.append("windGust:").append(ObservationMetric.getDouble("windGust")).append("||");
                sb.append("pressure:").append(ObservationMetric.getDouble("pressure")).append("||");
                sb.append("precipRate:").append(ObservationMetric.getDouble("precipRate")).append("||");
                sb.append("precipTotal:").append(ObservationMetric.getDouble("precipTotal")).append("||");
                sb.append("elev:").append(ObservationMetric.getDouble("elev"));
            }
        } catch (
                JSONException e1) {
            e1.printStackTrace();
        }
        return sb.toString();
    }
}