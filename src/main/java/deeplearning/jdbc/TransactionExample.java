package deeplearning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/sandeep";
    static final String USER = "nallas";
    static final String PASS = "test";
    static final String QUERY = "select * from sandeep_test1";
    static final String INSERT_QUERY = "insert into sandeep_test1 values (7, 'dude', 232, 'nalla')";
    static final String INSERT_QUERY_2 = "insert into sandeep_test1 values (8, 'dude', 232, 'nalla')";

    public static void printResultSet(ResultSet rs) throws SQLException{
        // Ensure we start with first row
        rs.beforeFirst();
        while(rs.next()){
            // Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", Salary: " + rs.getInt("salary"));
            System.out.println(", Department: " + rs.getString("dept"));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try{
            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // Set auto commit as false.
            conn.setAutoCommit(false);

            // Execute a query to create statment with
            // required arguments for RS example.
            System.out.println("Creating statement...");
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            // INSERT a row into table
            System.out.println("Inserting rows....");
            stmt.executeUpdate(INSERT_QUERY);

            // INSERT one more row into table
            stmt.executeUpdate(INSERT_QUERY_2);

            // Commit data here.
            System.out.println("Committing data here....");
            conn.commit();

            // Now list all the available records.
            String sql = "select * from sandeep_test1";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("List result set for reference....");
            printResultSet(rs);

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
            // If there is an error then rollback the changes.
            System.out.println("Rolling back data here....");
            try{
                if(conn!=null)
                    conn.rollback();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
