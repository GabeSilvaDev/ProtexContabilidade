package Principal.DAO;

import Principal.conexao.Conexao;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginUsuarioDAO {
    Conexao conexao = new Conexao();
    
    public boolean LoginSenha(String login){
        String sql = "Select id from login where login =?";
        String sql2 = "Insert into loginusuario(login)"
                +"values (?)";
        
        
            try{
                PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
                PreparedStatement psmt2 = conexao.conectar().prepareStatement(sql2);
                psmt.setString(1,login);
                
                ResultSet rs = psmt.executeQuery();
                if(rs.next()){
                    psmt2.setInt(1, rs.getInt("id"));
                    psmt2.executeUpdate();
                }
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro LoginSenha LoginUsuarioDAO: "+e);
                return false;
            }
            return true;
    }
}