package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Carro;
import model.ConnectionFactory;

public class CarroDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insert(Carro carro) {
        
        Connection con = ConnectionFactory.getConnectin();
        PreparedStatement pstm = null;

        try {
            String sql = "insert into carro(codigo, modelo, marca, valor) values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, carro.getCodigo());
            pstm.setString(2, carro.getModelo());
            pstm.setString(3, carro.getMarca());
            pstm.setDouble(4, carro.getValor());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "OK");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
    
    public void alterar(Carro carro){
        
        Connection con = ConnectionFactory.getConnectin();
        PreparedStatement pstm = null;
        
        try {
            String sql = "update carro  set modelo = ?, marca = ?, valor = ? where codigo = ?";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, carro.getModelo());
            pstm.setString(2, carro.getMarca());
            pstm.setDouble(3, carro.getValor());
            pstm.setInt(4, carro.getCodigo());
            
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "Update concluida");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update fail ");
        }
        
    }
    
    
    public void excluir(int id){
        
        Connection con = ConnectionFactory.getConnectin();
        PreparedStatement pstm = null;
        
        try {
            
            String sql = "delete from carro where codigo = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Delete concluida");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete fail ");
        }
    }
     

    public List<Carro> pesquisar(int codigo) {
        ArrayList<Carro> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnectin();
        PreparedStatement pstm = null;

        try {
            String sql = "select * from carro where codigo =  " + codigo + " ";
            Carro carro = new Carro();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                carro.setModelo(rs.getString("modelo"));
                carro.setMarca(rs.getString("marca"));
                carro.setValor(rs.getDouble("valor"));
                carro.setCodigo(rs.getInt("codigo"));
                lista.add(carro);
            }
            
            System.out.println("ID: "+carro.getMarca());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta ->" + e.getMessage());
        }

        return lista;
    }

}
