import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión exitosa!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
