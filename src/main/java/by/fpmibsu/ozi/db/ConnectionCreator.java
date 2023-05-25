package by.fpmibsu.ozi.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator
{
    public static final Properties PROPERTIES = new Properties();
    private static final String DATABASE_URL;

    static
    {
        try
        {
            PROPERTIES.load(new FileReader("dbProps/dbtest.properties"));
            String driverName = (String) PROPERTIES.get("db.driver");
            Class.forName(driverName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        DATABASE_URL = (String) PROPERTIES.get("db.url");
    }
    private ConnectionCreator() {}
    public static Connection createConnection() throws SQLException
    {
        return DriverManager.getConnection(DATABASE_URL, PROPERTIES);
    }
}
