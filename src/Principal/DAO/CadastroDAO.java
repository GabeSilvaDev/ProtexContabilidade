package Principal.DAO;

import Principal.DTO.LoginDTO;
import Principal.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroDAO {
    
    Conexao conexao = new Conexao();
    
    
    public boolean cadastrar(LoginDTO login) {
        String sql="Insert into tbusuarios(id_usuario, nome, email, documento, telefone, endereco, tipo_documento)"
                +"values(null,?,?,?,?,?,?)";
        String sql2="Insert into login(id, login, senha)"
                +"values(null,?,md5(?))";
        try{
            PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
            PreparedStatement psmt2 = conexao.conectar().prepareStatement(sql2);
            
            psmt.setString(1, login.getNome());
            psmt.setString(2, login.getEmail());
            psmt.setString(3, login.getDocumento());
            psmt.setString(4, login.getTelefone());
            psmt.setString(5, login.getEndereco());
            psmt.setString(6, login.getTipoDocumento());
            
            psmt2.setString(1, login.getLogin());
            psmt2.setString(2, login.getSenha());
           
            
            psmt.executeUpdate();
            psmt2.executeUpdate();
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro Cadastrar CadastroDAO: "+ ex);
            return false;
        }
    }

}
