package global.Database;
import java.sql.*;

public class Connect {
    //Database path and login details are identified to allow connection with database

    private static String dbURL="jdbc:postgresql://localhost:5432/HotelAnglia";
    private static String userName="postgres";
    private static String passWord="database145";
    private static Connection db;

    public  Connect() {
        //Connect method is used to establish a connection with database
        //try statement is used to define this line of code and test it for any errors during its execution
        //catch statement is used to define the line of code to be executed if an error was found in the try statement
        try {
            this.db = DriverManager.getConnection(dbURL, userName, passWord);
        //prints this message if connection is successful
            System.out.println("Connection Successful");
        } catch (Exception e) {
            //prints this message if connection is unsuccessful
            System.out.println("Connection failed");
        }
    }

    public ResultSet sqlExecute(String statement) {
        //sqlExecute statement is used to execute an SQL statement
        try {

            Statement sqlStat = this.db.createStatement();

            ResultSet rs = sqlStat.executeQuery(statement);

            return rs;
            //returns the value of rs
        } catch (Exception e) {
            //prints a message if an error occurred in the try statement
            System.out.println("SQL Error..."+ e);
        }
        return null;
    }


    public void sqlUpdate(String statement, String[] mydata) {
        //sqlUpdate method is used to update information within the given database
        try {
            Statement sqlStat = this.db.createStatement();
            sqlStat.executeUpdate(statement);
            System.out.println("statement updated");
        } catch (Exception e) {
            //prints a message if an error occurred in the try statement
            System.out.println("SQL NOT UPDATED");
        }

    }


    public static void resultPrinter(ResultSet rs) {
        try {
            //the .next() method within the while loop continues to return the next token
            // as long as it matches the specified pattern which in this case is the value of rs identified previously
            while (rs.next()) {

                String row = "";
                //The getMetaData() method within the for loop is used  retrieve the ResultSetMetaData object of the current ResultSet
                // then returns a ResultSetMetaData object which holds the description of this ResultSet object's columns
                //The getColumnCount() method returns an integer representing the number of columns in the table in the current ResultSet object

                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                    row += rs.getString(i) + ", ";
                }
            }

        } catch (Exception e) {
            //prints a message if an error occurs in try statement

            System.out.println("Error !");
            e.printStackTrace();
        }
    }


}