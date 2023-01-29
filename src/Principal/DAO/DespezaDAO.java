package Principal.DAO;

import Principal.DTO.DespezaDTO;
import Principal.conexao.Conexao;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DespezaDAO{
    Conexao conexao = new Conexao();
    
    public boolean registrar(DespezaDTO despeza) {
        String sql="Insert into tbdespeza(id_despeza, despeza, valor_gasto, descricao, id_feito, cod_usuario)"
                +"values(null, ?,?,?,?,?)";
        String sql2="SELECT LOGIN FROM loginusuario WHERE ID = (SELECT MAX(ID) FROM loginusuario)";
        
        try{
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        PreparedStatement psmt2 = conexao.conectar().prepareStatement(sql2);
        
        psmt.setString(1, despeza.getDespeza());
        psmt.setDouble(2, despeza.getValorGasto());
        psmt.setString(3, despeza.getDescricao());
        
        ResultSet rs = psmt2.executeQuery();
        
        if(rs.first()){
            int codigo = rs.getInt("login");
            psmt.setInt(4, codigo);
            psmt.setInt(5, codigo);
            despeza.setIdFeito(codigo);
            psmt.executeUpdate();
        }
        
        return true;
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro Registar DespezaDAO"+ ex);
            return false;
        }
    }
    
    public boolean editar(DespezaDTO despeza) {
        String sql="Update tbdespeza set despeza=?,valor_gasto=?,descricao=? where id_despeza = ?";
        try{
            
            
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        psmt.setString(1, despeza.getDespeza());
        psmt.setDouble(2, despeza.getValorGasto());
        psmt.setString(3, despeza.getDescricao());
        psmt.setInt(4, despeza.getId());
        
        psmt.executeUpdate();
        return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro Editar DespezaDAO: "+ ex);
            return false;
        }
    }
    public boolean deletar(DespezaDTO despeza) {
        String sql="delete from tbdespeza where id_despeza = ?"; 
        try{
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        psmt.setInt(1, despeza.getId());
        
        psmt.executeUpdate();
        return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro Deletar DespezaDAO: "+ ex);
            return false;
        }
    }
    
    public boolean calcular(DespezaDTO despeza) {
        String sql="Select sum(valor_gasto) as valortotal from tbdespeza where id_feito = (SELECT LOGIN FROM loginusuario WHERE ID = (SELECT MAX(ID) FROM loginusuario))";
        try{
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        
        if(rs.next()){
            double valordasoma = rs.getDouble("valortotal");
            despeza.setValorTotal(valordasoma);
        }
        
        return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro Calcular DespezaDAO: "+ ex);
            return false;
        }
    }
    
    public List<DespezaDTO> Pesquisar(){
        List<DespezaDTO> despezas = new ArrayList<>();
        
        try{
            String sql="Select * from tbdespeza where id_feito = (SELECT LOGIN FROM loginusuario WHERE ID = (SELECT MAX(ID) FROM loginusuario))";
            PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
              
            while(rs.next()){
                DespezaDTO despeza = new DespezaDTO();   
                
                despeza.setId(rs.getInt("id_despeza"));
                
                despeza.setDespeza(rs.getString("Despeza"));
                despeza.setDescricao(rs.getString("Descricao"));
                despeza.setValorGasto(rs.getDouble("Valor_Gasto"));
                despezas.add(despeza);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro Pesquisar DespezaDAO:: "+ex);
        }
        
        return despezas;
    }
    
    public List<DespezaDTO> PesquisarDesc(String desc){
        
        List<DespezaDTO> despezas = new ArrayList<>();
        
        try{
            
            String sql="Select * from tbdespeza where despeza LIKE ? AND id_feito = (SELECT LOGIN FROM loginusuario WHERE ID = (SELECT MAX(ID) FROM loginusuario))";
            PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
            psmt.setString(1, "%"+desc+"%");
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                
                DespezaDTO despeza = new DespezaDTO();
              
                despeza.setId(rs.getInt("id_despeza"));
                
                despeza.setDespeza(rs.getString("Despeza"));
                despeza.setDescricao(rs.getString("Descricao"));
                despeza.setValorGasto(rs.getDouble("Valor_Gasto"));
                despezas.add(despeza);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro PesquisarDesc DespezaDAO:: "+ex);
        }
        
        return despezas;
    }
}
