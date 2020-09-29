package dbop;
import PWS.DailyObservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MySQLdbopDailyObs {

    Connection connection;
    DailyObservation obs;
    public MySQLdbopDailyObs(Connection connection, DailyObservation obs) {
        super();
        this.connection = connection;
        this.obs = obs;
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public DailyObservation getObs() {
        return obs;
    }
    public void setObs(DailyObservation obs) {
        this.obs = obs;
    }


    public int addDailyObs() {
        String sSQL="INSERT INTO PWS_DAILY_OBS"
                + "(STATION_ID"
                + ",OBS_TIME_LOCAL"
                + ",LATITUDE"
                + ",LONGITUDE"
                + ",SOLAR_RADIATION_HIGH"
                + ",UV_HIGH"
                + ",WIND_DIR_AVG"
                + ",HUMIDITY_AVG"
                + ",TEMP_AVG"
                + ",HEAT_INDEX_AVG"
                + ",DEWPT_AVG"
                + ",WIND_CHILL_AVG"
                + ",WIND_SPEED_AVG"
                + ",WIND_GUST_AVG"
                + ",PRESSURE_MAX"
                + ",PRESSURE_MIN"
                + ",PRESSURE_AVG"
                + ",PRESSURE_TREND"
                + ",PRECIP_RATE"
                + ",PRECIP_TOTAL)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sSQL);
            ps.setString(1, obs.getStationID());
            ps.setString(2, obs.getObsTimeLocal());
            ps.setString(3, obs.getLat());
            ps.setString(4, obs.getLon());
            ps.setString(5, obs.getSolarRadiationHigh());
            ps.setString(6, obs.getUvHigh());
            ps.setString(7, obs.getWinddirAvg());
            ps.setString(8, obs.getHumidityAvg());
            ps.setString(9, obs.getTempAvg());
            ps.setString(10, obs.getHeatIndexAvg());
            ps.setString(11, obs.getDewptAvg());
            ps.setString(12, obs.getWindchillAvg());
            ps.setString(13, obs.getWindspeedAvg());
            ps.setString(14, obs.getWindgustAvg());
            ps.setString(15, obs.getPressureMax());
            ps.setString(16, obs.getPressureMin());
            ps.setString(17, obs.getPressureMin());
            ps.setString(18, obs.getPressureTrend());
            ps.setString(19, obs.getPrecipRate());
            ps.setString(20, obs.getPrecipTotal());
            ps.execute();
            System.out.println("Obs inserita");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}