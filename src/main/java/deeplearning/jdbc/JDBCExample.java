package deeplearning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBCExample {
    public static void main(String args[]){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","nallas","test");

            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into sandeep_test1 values (4, 'dude', 232, 'nalla')");
            statement.executeUpdate("update sandeep_test1 set name='Sandeep' where id=4");
            ResultSet resultSet = statement.executeQuery("select * from sandeep_test1");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) + " " +
                        resultSet.getInt(3) + " "+ resultSet.getString(4));

            }
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
