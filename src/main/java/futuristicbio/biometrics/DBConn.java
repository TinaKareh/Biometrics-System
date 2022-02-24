
package futuristicbio.biometrics;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {    
    
    public DBConn() {
    }
    
    
    /*private static final String username = "kaadbremoteuser";
    private static final String password = "Ct@2021*!";
    private static final String dataCOnn = "jdbc:mysql://192.168.100.139:3306/idms_isiolo";*/
    private static final String username = "root";
    private static final String password = "";
    private static final String dataCOnn = "jdbc:mysql://127.0.0.1/kaadbremotusr";
    private Connection sqlConn = null;
    public Connection Conn(){
        
        try {
            sqlConn = (Connection)DriverManager.getConnection(dataCOnn, username, password);
        } catch (SQLException e) {
            return sqlConn;
        }
        return sqlConn;
    }
    
    public void closeDB() throws SQLException{
        sqlConn.close();
    }
    
}
