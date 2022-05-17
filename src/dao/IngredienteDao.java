package dao;

import dao.connector.Connector;
import model.Ingrediente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDao {
    Connector connector;

    public void insertIngrediente(Ingrediente Ingrediente){
        String query = "insert into ingredientes (nome, descricao) values (?,?);";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1, String.valueOf(Ingrediente.getNome()));
            ppst.setString(2, Ingrediente.getDescricao());

            ppst.executeQuery();

            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public List<Ingrediente> getAllingredientes(){
        List<Ingrediente> ingredientes = new ArrayList<>();
        String query = "select * from ingredientes;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while(rs.next()){
                String nome = rs.getString("nome");
                String des = rs.getString("descricao");

                ingredientes.add(new Ingrediente(nome, des));
            }
            con.close();
            return ingredientes;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Ingrediente getIngredienteByID(String codigo){
        String query = "select * from ingredientes i where i.nome = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1, String.valueOf(codigo));

            ResultSet rs = ppst.executeQuery();

            String nome = rs.getString("nome");
            String desc = rs.getString("descricao");

            return new Ingrediente(nome, desc);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Ingrediente updateCategria(String nome, String novDes){
        String query = "update ingredientes set descricao = ? where nome = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1,novDes);

            ppst.setString(2, nome);

            ppst.executeQuery();

            con.close();

            return getIngredienteByID(nome);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteIngrediente(Integer codigo){
        String query = "delete from ingredientes where nome = ?;";
        try{
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1, String.valueOf(codigo));

            ppst.executeQuery();

            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
