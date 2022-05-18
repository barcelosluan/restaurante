package dao;

import dao.connector.Connector;
import model.Cozinheiro;
import model.Restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Cozinheiro_RestauranteDao {
    Connector connector = new Connector();

    public void insertCozinheiroRestaurante(Cozinheiro cozinheiro, Restaurante restaurante){
        String query = "insert into cozinheiros_restaurantes (cozinheiro, restaurante) values (?, ?);";
        try {
            Connection con = connector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1, cozinheiro.getCodEmpregado());
            ppst.setInt(2, restaurante.getCodigo());
            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //TODO: Verificar quais selects serao feitos

    public void deleteCozinheiroRestaurante(Cozinheiro cozinheiro, Restaurante restaurante){
        String query = "delete from cozinheiros_restaurantes where cozinheiro = ? AND restaurante = ?;";
        try{
            Connection connection = connector.connectar();
            PreparedStatement ppst = connection.prepareStatement(query);
            ppst.setInt(1,cozinheiro.getCodEmpregado());
            ppst.setInt(2,restaurante.getCodigo());
            ppst.executeQuery();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
