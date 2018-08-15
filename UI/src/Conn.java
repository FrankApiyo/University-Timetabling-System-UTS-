import java.sql.*;

public class Conn {
    public void logon(String stmnt){  
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ttproj","root","");
            
            Statement stnt = (Statement) con.createStatement();
            stnt.executeUpdate(stmnt);
                       
        }catch(SQLException e){
            System.out.println(e);
        }
    }  
}
