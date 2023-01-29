package Principal.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private String url =
            "jdbc:mysql://localhost/bdContabilidade?useTimezone=true"
            + "&serverTimezone=UTC";
    private String usuario = "root";
    private String senha = "";
    
    public Connection conectar() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        return conexao;
} catch(SQLException sqle){
    System.out.println("SQLException: "+ sqle.getMessage());
    return null;
}catch(Exception e) {
    System.out.println("Exception: "+ e.getMessage());
    return null;
}
}
}
