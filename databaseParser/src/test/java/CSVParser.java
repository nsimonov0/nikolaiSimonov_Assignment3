import java.sql.Connection;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CSVParser {
    private String myfilePath;
    private Connection myConnection;

    public CSVParser() {
        myfilePath = null;
        myConnection = null;
    }

    public CSVParser(String filePath, Connection connection) {
        myfilePath = filePath;
        myConnection = connection;
    }

    public String getFilePath() {
        return myfilePath;
    }

    public void setFilePath(String filePath) {
        this.myfilePath = filePath;
    }

    public void parseCSV(){
        try{
            String filePath = getFilePath();

            Reader in = new FileReader(filePath);
            Iterable<CSVRecord> myRecords = CSVFormat.EXCEL.parse(in);

            for (CSVRecord myRecord : myRecords){
                String address = myRecord.get(0);
                String email = myRecord.get(1);
                String quantity = myRecord.get(2);
                String price = myRecord.get(3);
                String size = myRecord.get(4);

                //Shoes Table
                PreparedStatement statement = myConnection.prepareStatement("" +
                        "INSERT INTO Shoes(size, price) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, size);
                statement.setString(2, price);
                statement.executeUpdate();

                ResultSet rsKey = statement.getGeneratedKeys(); //Get primary keys

                int sID = 0;
                if (rsKey.next()){
                    sID = rsKey.getInt(1); //Set each primary key
                }
                //Orders Table
                PreparedStatement statement2 = myConnection.prepareStatement(""+
                        "INSERT INTO Orders(shoeID, quantity) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                statement2.setInt(1, sID); //Use primary key from Shoes as foreign key for Orders
                statement2.setString(2, quantity);
                statement2.executeUpdate();
                ResultSet rsKey2 = statement2.getGeneratedKeys();
                int oID = 0;
                if (rsKey2.next()){
                    oID = rsKey2.getInt(1);
                }
                //Emails Table
                PreparedStatement statement3 = myConnection.prepareStatement(""+
                        "INSERT INTO Emails(email) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                statement3.setString(1, email);
                statement3.executeUpdate();
                ResultSet rsKey3 = statement3.getGeneratedKeys();
                int eID = 0;
                if (rsKey3.next()){
                    eID = rsKey3.getInt(1);
                }
                //Addresses Table
                PreparedStatement statement4 = myConnection.prepareStatement(""+
                        "INSERT INTO Addresses(address) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                statement4.setString(1, address);
                statement4.executeUpdate();
                ResultSet rsKey4 = statement4.getGeneratedKeys();
                int aID = 0;
                if(rsKey4.next()){
                    aID = rsKey4.getInt(1);
                }

                //Users Table
                PreparedStatement statement5 = myConnection.prepareStatement(""+
                        "INSERT INTO Users(orderID, addressID, emailID) VALUES (?,?,?)");
                statement5.setInt(1, oID);
                statement5.setInt(2, aID);
                statement5.setInt(3, eID);
                statement5.executeUpdate();
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
