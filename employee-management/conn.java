package Employee;

import java.sql.*;

public class conn {         //connecting java project with sql database
    
    public Connection c;    //setup connection with mysql
    public Statement s;     //execute queries of mysql
    
    public conn(){         //register the drivers of mysql
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///d1","root","");  //setup connection
            s = c.createStatement();     //query execution
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
