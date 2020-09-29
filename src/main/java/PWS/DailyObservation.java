package PWS;
/**
 * @Applicatio Personal PWS Monitor
 * @author diego carrarini
 * @since 22/09/2020
 * @version 1.00
 */

public class DailyObservation {

    String stationID;
    String obsTimeUtc;
    String obsTimeLocal;
    String solarRadiationHigh;
    String lon;
    String lat;
    String uvHigh;
    String winddirAvg;
    String humidityAvg;
    String tempAvg;
    String heatIndexAvg;
    String dewptAvg;
    String windchillAvg;
    String windspeedAvg;
    String windgustAvg;
    String pressureMax;
    String pressureMin;
    String pressureTrend;
    String precipRate;
    String precipTotal;

    public DailyObservation(String stationID, String obsTimeUtc, String obsTimeLocal, String solarRadiationHigh,
                            String lon, String lat, String uvHigh, String winddirAvg, String humidityAvg, String tempAvg,
                            String heatIndexAvg, String dewptAvg, String windchillAvg, String windspeedAvg, String windgustAvg,
                            String pressureMax, String pressureMin, String pressureTrend, String precipRate,
                            String precipTotal) {
        super();
        this.stationID = stationID;
        this.obsTimeUtc = obsTimeUtc;
        this.obsTimeLocal = obsTimeLocal;
        this.solarRadiationHigh = solarRadiationHigh;
        this.lon = lon;
        this.lat = lat;
        this.uvHigh = uvHigh;
        this.winddirAvg = winddirAvg;
        this.humidityAvg = humidityAvg;
        this.tempAvg = tempAvg;
        this.heatIndexAvg = heatIndexAvg;
        this.dewptAvg = dewptAvg;
        this.windchillAvg = windchillAvg;
        this.windspeedAvg = windspeedAvg;
        this.windgustAvg = windgustAvg;
        this.pressureMax = pressureMax;
        this.pressureMin = pressureMin;
        this.pressureTrend = pressureTrend;
        this.precipRate = precipRate;
        this.precipTotal = precipTotal;
    }
    public String getStationID() {
        return stationID;
    }
    public void setStationID(String stationID) {
        this.stationID = stationID;
    }
    public String getObsTimeUtc() {
        return obsTimeUtc;
    }
    public void setObsTimeUtc(String obsTimeUtc) {
        this.obsTimeUtc = obsTimeUtc;
    }
    public String getObsTimeLocal() {
        return obsTimeLocal;
    }
    public void setObsTimeLocal(String obsTimeLocal) {
        this.obsTimeLocal = obsTimeLocal;
    }
    public String getSolarRadiationHigh() {
        return solarRadiationHigh;
    }
    public void setSolarRadiationHigh(String solarRadiationHigh) {
        this.solarRadiationHigh = solarRadiationHigh;
    }
    public String getLon() {
        return lon;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getUvHigh() {
        return uvHigh;
    }
    public void setUvHigh(String uvHigh) {
        this.uvHigh = uvHigh;
    }
    public String getWinddirAvg() {
        return winddirAvg;
    }
    public void setWinddirAvg(String winddirAvg) {
        this.winddirAvg = winddirAvg;
    }
    public String getHumidityAvg() {
        return humidityAvg;
    }
    public void setHumidityAvg(String humidityAvg) {
        this.humidityAvg = humidityAvg;
    }
    public String getTempAvg() {
        return tempAvg;
    }
    public void setTempAvg(String tempAvg) {
        this.tempAvg = tempAvg;
    }
    public String getHeatIndexAvg() {
        return heatIndexAvg;
    }
    public void setHeatIndexAvg(String heatIndexAvg) {
        this.heatIndexAvg = heatIndexAvg;
    }
    public String getDewptAvg() {
        return dewptAvg;
    }
    public void setDewptAvg(String dewptAvg) {
        this.dewptAvg = dewptAvg;
    }
    public String getWindchillAvg() {
        return windchillAvg;
    }
    public void setWindchillAvg(String windchillAvg) {
        this.windchillAvg = windchillAvg;
    }
    public String getWindspeedAvg() {
        return windspeedAvg;
    }
    public void setWindspeedAvg(String windspeedAvg) {
        this.windspeedAvg = windspeedAvg;
    }
    public String getWindgustAvg() {
        return windgustAvg;
    }
    public void setWindgustAvg(String windgustAvg) {
        this.windgustAvg = windgustAvg;
    }
    public String getPressureMax() {
        return pressureMax;
    }
    public void setPressureMax(String pressureMax) {
        this.pressureMax = pressureMax;
    }
    public String getPressureMin() {
        return pressureMin;
    }
    public void setPressureMin(String pressureMin) {
        this.pressureMin = pressureMin;
    }
    public String getPressureTrend() {
        return pressureTrend;
    }
    public void setPressureTrend(String pressureTrend) {
        this.pressureTrend = pressureTrend;
    }
    public String getPrecipRate() {
        return precipRate;
    }
    public void setPrecipRate(String precipRate) {
        this.precipRate = precipRate;
    }
    public String getPrecipTotal() {
        return precipTotal;
    }
    public void setPrecipTotal(String precipTotal) {
        this.precipTotal = precipTotal;
    }
}