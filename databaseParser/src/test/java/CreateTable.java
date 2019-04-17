import java.sql.*;
public class CreateTable {
    public static void createTable(Connection connection, Statement statement) {
        try {
            String shoeTable = "CREATE TABLE Shoes"+
                    "(shoeID INT NOT NULL AUTO_INCREMENT,"+
                    "size INT NOT NULL,"+
                    "price DOUBLE NOT NULL,"+
                    "PRIMARY KEY (shoeID))";

            String orderTable = "CREATE TABLE Orders"+
                    "(orderID INT NOT NULL AUTO_INCREMENT,"+
                    "shoeID INT NOT NULL," +
                    "quantity INT NOT NULL,"+
                    "PRIMARY KEY (orderID),"+
                    "FOREIGN KEY (shoeID) REFERENCES Shoes(shoeID))";

            String emailTable = "CREATE TABLE Emails"+
                    "(emailID INT NOT NULL AUTO_INCREMENT,"+
                    "email VARCHAR(150) NOT NULL,"+
                    "PRIMARY KEY (emailID))";

            String addressTable = "CREATE TABLE Addresses"+
                    "(addressID INT NOT NULL AUTO_INCREMENT,"+
                    "address VARCHAR(250) NOT NULL,"+
                    "PRIMARY KEY (addressID))";


            String userTable = "CREATE TABLE Users"+
                    "(userID INT NOT NULL AUTO_INCREMENT,"+
                    "orderID INT,"+
                    "addressID INT,"+
                    "emailID INT,"+
                    "PRIMARY KEY (userID),"+
                    "FOREIGN KEY (orderID) REFERENCES Orders(orderID),"+
                    "FOREIGN KEY (addressID) REFERENCES Addresses(addressID),"+
                    "FOREIGN KEY (emailID) REFERENCES Emails(emailID))";

            statement.executeUpdate(shoeTable);
            statement.executeUpdate(orderTable);
            statement.executeUpdate(emailTable);
            statement.executeUpdate(addressTable);
            statement.executeUpdate(userTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

