package PWS;
/**
 * @Applicatio Personal PWS Monitor
 * @author diego carrarini
 * @since 20/09/2020
 * @version 1.00
 */
public class Observation {
    static String stationID;
    static String obsTimeUtc;
    static String obsTimeLocal;
    static String neighborhood;
    static String softwareType;
    static String country;
    static String solarRadiation;
    static String lon;
    static String lat;
    static String uv;
    static String winddir;
    static String humidity;
    static String temp;
    static String heatIndex;
    static String dewpt;
    static String windChill;
    static String windSpeed;
    static String windGust;
    static String pressure;
    static String precipRate;
    static String precipTotal;
    static String elev;

    public Observation(String stationID, String obsTimeUtc, String obsTimeLocal, String neighborhood, String softwareType, String country, String solarRadiation, String lon, String lat, String uv, String winddir, String humidity, String temp, String heatIndex, String dewpt, String windChill, String windSpeed, String windGust, String pressure, String precipRate, String precipTotal, String elev) {
        this.stationID=stationID;
        this.obsTimeUtc=obsTimeUtc;
        this.obsTimeLocal=obsTimeLocal;
        this.neighborhood=neighborhood;
        this.softwareType=softwareType;
        this.country=country;
        this.solarRadiation=solarRadiation;
        this.lon=lon;
        this.lat=lat;
        this.uv=uv;
        this.winddir=winddir;
        this.humidity=humidity;
        this.temp=temp;
        this.heatIndex=heatIndex;
        this.dewpt=dewpt;
        this.windChill=windChill;
        this.windSpeed=windSpeed;
        this.windGust=windGust;
        this.pressure=pressure;
        this.precipRate=precipRate;
        this.precipTotal=precipTotal;
        this.elev=elev;
    }

    public static String getStationID() {
        return stationID;
    }

    public static void setStationID(String stationID) {
        PWS.Observation.stationID = stationID;
    }

    public static String getObsTimeUtc() {
        return obsTimeUtc;
    }

    public static void setObsTimeUtc(String obsTimeUtc) {
        PWS.Observation.obsTimeUtc = obsTimeUtc;
    }

    public static String getObsTimeLocal() {
        return obsTimeLocal;
    }

    public static void setObsTimeLocal(String obsTimeLocal) {
        PWS.Observation.obsTimeLocal = obsTimeLocal;
    }

    public static String getNeighborhood() {
        return neighborhood;
    }

    public static void setNeighborhood(String neighborhood) {
        PWS.Observation.neighborhood = neighborhood;
    }

    public static String getSoftwareType() {
        return softwareType;
    }

    public static void setSoftwareType(String softwareType) {
        PWS.Observation.softwareType = softwareType;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        PWS.Observation.country = country;
    }

    public static String getSolarRadiation() {
        return solarRadiation;
    }

    public static void setSolarRadiation(String solarRadiation) {
        PWS.Observation.solarRadiation = solarRadiation;
    }

    public static String getLon() {
        return lon;
    }

    public static void setLon(String lon) {
        PWS.Observation.lon = lon;
    }

    public static String getLat() {
        return lat;
    }

    public static void setLat(String lat) {
        PWS.Observation.lat = lat;
    }

    public static String getUv() {
        return uv;
    }

    public static void setUv(String uv) {
        PWS.Observation.uv = uv;
    }

    public static String getWinddir() {
        return winddir;
    }

    public static void setWinddir(String winddir) {
        PWS.Observation.winddir = winddir;
    }

    public static String getHumidity() {
        return humidity;
    }

    public static void setHumidity(String humidity) {
        PWS.Observation.humidity = humidity;
    }

    public static String getTemp() {
        return temp;
    }

    public static void setTemp(String temp) {
        PWS.Observation.temp = temp;
    }

    public static String getHeatIndex() {
        return heatIndex;
    }

    public static void setHeatIndex(String heatIndex) {
        PWS.Observation.heatIndex = heatIndex;
    }

    public static String getDewpt() {
        return dewpt;
    }

    public static void setDewpt(String dewpt) {
        PWS.Observation.dewpt = dewpt;
    }

    public static String getWindChill() {
        return windChill;
    }

    public static void setWindChill(String windChill) {
        PWS.Observation.windChill = windChill;
    }

    public static String getWindSpeed() {
        return windSpeed;
    }

    public static void setWindSpeed(String windSpeed) {
        PWS.Observation.windSpeed = windSpeed;
    }

    public static String getWindGust() {
        return windGust;
    }

    public static void setWindGust(String windGust) {
        PWS.Observation.windGust = windGust;
    }

    public static String getPressure() {
        return pressure;
    }

    public static void setPressure(String pressure) {
        PWS.Observation.pressure = pressure;
    }

    public static String getPrecipRate() {
        return precipRate;
    }

    public static void setPrecipRate(String precipRate) {
        PWS.Observation.precipRate = precipRate;
    }

    public static String getPrecipTotal() {
        return precipTotal;
    }

    public static void setPrecipTotal(String precipTotal) {
        PWS.Observation.precipTotal = precipTotal;
    }

    public static String getElev() {
        return elev;
    }

    public static void setElev(String elev) {
        PWS.Observation.elev = elev;
    }
}