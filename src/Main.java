import java.sql.*;

public class Main {
    private final static String url = "jdbc:postgresql://localhost:5432/2019-05-20_AM_CW";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
//            ex1(conn);
//            ex2(conn);
            ex3(conn);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

//    1. Create a new Los Angeles entry for Papers with any code that cost 90.1.
    public static void ex1(Connection conn){
        try {
//            String SQL = "INSERT INTO Boxes(Code,Contents,Value,Warehouse) VALUES('4J2G','Papers',90.1,4)";
//            String SQL = "INSERT INTO Warehouses(Code,Location,Capacity) VALUES(6,'Los Angeles',3)";
            String SQL = "SELECT * FROM boxes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.print(rs.getString(1)+", ");
                System.out.print(rs.getString(2)+", ");
                System.out.print(rs.getString(3)+", ");
                System.out.print(rs.getString(4)+"\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

//    2.Select the warehouse code and the average value of the boxes in each warehouse.
    public static void ex2(Connection conn){
        try {
            String SQL = "SELECT avg(value) as AVG, warehouse FROM boxes GROUP BY warehouse";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                System.out.print(rs.getString("warehouse")+"' ");
                System.out.print(rs.getString("AVG")+"\n");
            }
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

//    3.Select the warehouse code and the average value of the boxes in each warehouse, but select only those warehouses where the average value of the boxes is greater than 150.
    public static void ex3(Connection conn){
        try {
            String SQL = "SELECT avg(value) as AVG, warehouse FROM boxes Where value > 150 GROUP BY warehouse";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                System.out.print(rs.getString("warehouse")+"' ");
                System.out.print(rs.getString("AVG")+"\n");
            }
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        connect();
    }
}
