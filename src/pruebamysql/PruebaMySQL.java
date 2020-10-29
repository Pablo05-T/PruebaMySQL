package pruebamysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author Pablo
 */
public class PruebaMySQL {
    public static void main(String[] args) {
        
        //Conexiones
        Connection conexion1 = null;
        Connection conexion2 = null;
        Connection conexion3 = null;
        
        //Usuario y Clave
        String user = "root";
        String password = "";
        
        try{
            //Una sola Cadena de conexion, en un solo parametro se concatena el Usuario y el Password
            String urll = "jdbc:mysql://localhost:3306/mibase?user="+user+"&password="+password;
            conexion1 = DriverManager.getConnection(urll);
            
            if(conexion1 != null){
                System.out.println("Conexion 1: Conexion a mi base satisfactoria");
            }
            // Se envia la Cadena, el usuario y el password por separado
            Properties datos = new Properties();
            datos.put("User", user);
            datos.put("Password", password);
            String url2 = "jdbc:mysql://localhost:3306/mibase";
            conexion2 = DriverManager.getConnection(url2,datos);
            
            if (conexion2 != null){
                System.out.println("Conexion 2: Conexion a mi base satisfactoria");
            }
            // Se envia la cadena, el usuario y el password por separado
            String url3 = "jdbc:mysql://localhost:3306/mibase";
            conexion3 = DriverManager.getConnection(url3,user,password);
            
            if (conexion3 != null){
                System.out.println("Conexion 3: Conexion a mi base satisfactoria");
            }
        } catch(SQLException e){
            System.out.println("Error, verifique su usuario o password o nombre de la base de datos");
            e.printStackTrace();
        }
    }
}
