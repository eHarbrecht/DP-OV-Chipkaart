import java.sql.*;
import java.util.Properties;

public class main {

    public static void main(String args[]) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/ovchip";
        Properties prop = new Properties();

        prop.setProperty("user", "postgres");
        prop.setProperty("password", "MarsMannetjes2");

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String q = "SELECT * FROM reiziger";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(q);

        System.out.println("Alle reizigers:");
        while (rs.next()) {
            String txt = "";

            if (rs.getString(3) != null) {
                txt = rs.getString(3) + " ";
            }

            System.out.println("    #" + rs.getString(1) + ": " + rs.getString(2) + ". " + txt + rs.getString(4) + " (" + rs.getString(5) + ")");
        }
    }

}
