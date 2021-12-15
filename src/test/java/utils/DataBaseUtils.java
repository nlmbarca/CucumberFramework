package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtils {

    static Connection connection;
    static ResultSet resultSet;

    /**
     * This method create a connection to the database
     *
     * @return Connection
     */
    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(ConfigReader.getPropertyValue("dbUrl"),
                    ConfigReader.getPropertyValue("dbUsername"),
                    ConfigReader.getPropertyValue("dbPassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * This method gets Result Object from specified sql query
     *
     * @param sqlQuery
     * @return
     */
    public static ResultSet getResultSet(String sqlQuery) {

        try {
            resultSet = getConnection().createStatement().executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * This method returns data from ResultSet object
     *
     * @param sqlQuery
     * @return List<Map < K, V>>>
     */
    public static List<Map<String, String>> listOfMapsFromDb(String sqlQuery) {

        List<Map<String, String>> listOfRowMaps = new ArrayList<>();
        Map<String, String> rowMap;

        try {

            resultSet = getResultSet(sqlQuery);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();

            while (resultSet.next()) {

                rowMap = new LinkedHashMap<>();

                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {

                    rowMap.put(rsMetaData.getColumnName(i), resultSet.getString(i));
                }
                listOfRowMaps.add(rowMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfRowMaps;
    }

    /**
     * This method returns data from ResultSet object in a form of single Map
     * @param sqlQuery
     * @return Map<K, V>
     */
    public static Map<String, String> mapFromDataBase(String sqlQuery) {

        Map<String, String> rowMap = new LinkedHashMap<>();

        try {
            resultSet = getResultSet(sqlQuery);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            resultSet.next();

            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {

                rowMap.put(rsMetaData.getColumnName(i), resultSet.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowMap;
    }

}
