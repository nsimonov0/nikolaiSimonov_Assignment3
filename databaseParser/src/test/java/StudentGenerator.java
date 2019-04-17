import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class StudentGenerator {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://35.230.69.151:3306/myDatabase";
    static final String USER = "myUser";
    static final String PASS = "Chapman12";

    public static void main(String[] args) {
        Connection myConnection = null;
        Statement myStatement = null;

        //If you would like to generate fake data uncomment the following two lines (18-19)
        //fakerGeneration myFaker = new fakerGeneration();
        //myFaker.generate();

        try{
            Class.forName(JDBC_DRIVER);
            myConnection = DriverManager.getConnection(DB_URL, USER, PASS);
            myStatement = myConnection.createStatement();

            //The following four lines of code (27-31) will print existing tables in the db.
            //DatabaseMetaData md = myConnection.getMetaData();
            //ResultSet rs = md.getTables(null, null, "%", null);
            //while (rs.next()) {
            //    System.out.println(rs.getString(3));
           // }

            //If you would like to create the tables uncomment the following two lines (34-35)
            //CreateTable myTable = new CreateTable();
            //myTable.createTable(myConnection,myStatement);

            //If you would like to parse the CSV file uncomment the following two lines (38-39)
           // CSVParser myParser = new CSVParser("/Users/nikolai/DataGenerator/test.csv", myConnection);
           // myParser.parseCSV();
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}








