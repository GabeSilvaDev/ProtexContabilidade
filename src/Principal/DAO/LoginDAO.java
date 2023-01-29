package Principal.DAO;

import Principal.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginDAO {
    Conexao conexao = new Conexao();
    
    public boolean checklogin(String login, String senha){
        String sql="Select * from login where login=? and senha=md5(?)";
            boolean check = false;
            try{
            PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
            psmt.setString(1,login);
            psmt.setString(2,senha);
            
            ResultSet rs = psmt.executeQuery();
            if(rs.next()){
                check = true;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro checklogin LoginDAO: "+e);
        }
            return check;
    }
}