package dao;

import dao.connector.Connector;
import model.Empregado;
import model.Restaurante;

import java.beans.PropertyEditorSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestauranteDao {
    Connector con = new Connector();

    public void insertRestaurante(Restaurante restaurante){
        String query = "insert into restaurantes (codigo) values (?);";
        try {
            Connection conn = con.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);
            ppst.setInt(1, restaurante.getCodigo());
            ppst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Restaurante> geRestaurantes(){
        String query = "select * from restaurantes;";
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        try {
            Connection conn = con.connectar();

            PreparedStatement ppst = conn.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                Integer codigo = rs.getInt("codigo");
                restaurantes.add(new Restaurante(codigo));
            }
            conn.close();
            return restaurantes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }

    }

    public Restaurante getRestauranteByCod(Integer cod){
        String query = "select * from restaurantes e where e.codigo = ?;";
        try{
            Connection conn = con.connectar();;

            PreparedStatement ppst = conn.prepareStatement(query);
            ppst.setInt(1, cod);

            ResultSet rs = ppst.executeQuery();
            Restaurante restaurante = new Restaurante();
            if(rs.next()) {
                restaurante.setCodigo(rs.getInt(1));
            }

            conn.close();
            return restaurante;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteRestaurante(Integer cod){
        String query = "delete from restaurantes e where e.codigo = ?;";
        try {
            Connection conn = con.connectar();

            PreparedStatement ppst = conn.prepareStatement(query);

            ppst.setInt(1, cod);

            ppst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
