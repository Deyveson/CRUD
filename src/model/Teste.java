package model;

import dao.CarroDAO;
import java.sql.Connection;

public class Teste {

    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnectin();
        Carro carro = new Carro();
        CarroDAO carroDAO = new CarroDAO();
        carro.setCodigo(Integer.valueOf(190));
        carro.setModelo("jjf");
        carro.setMarca("jnfj");
        carro.setValor(Double.valueOf(58));
        carroDAO.insert(carro);
    }
}
