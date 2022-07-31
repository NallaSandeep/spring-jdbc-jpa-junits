package deeplearning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
class BatchExample {
    public static void main(String args[])throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","nallas","test");

        con.setAutoCommit(false);

        Statement stmt=con.createStatement();
        stmt.addBatch("insert into sandeep_test1 values (5, 'dude', 232, 'nalla')");
        stmt.addBatch("insert into sandeep_test1 values (6, 'dude', 232, 'nalla')");

        stmt.executeBatch();//executing the batch

        con.commit();
        con.close();
    }}