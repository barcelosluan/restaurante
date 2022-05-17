package dao;

import dao.connector.Connector;
import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class categoriaDao {
    Connector connector;

    public void insertCategoria(Categoria categoria){
        String query = "insert into categorias (codigo, descricao) values (?,?);";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1, String.valueOf(categoria.getCodigo()));
            ppst.setString(2, categoria.getDescricao());

            ppst.executeQuery();

            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public List<Categoria> getAllCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        String query = "select * from categorias;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while(rs.next()){
               Integer cod = Integer.valueOf(rs.getString("codigo"));
               String des = rs.getString("descricao");

               categorias.add(new Categoria(cod, des));
            }
            con.close();
            return categorias;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Categoria getCategoriaByID(Integer codigo){
        String query = "select * from categorias c where c.codigo = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1, String.valueOf(codigo));

            ResultSet rs = ppst.executeQuery();

            String cod = rs.getString("codigo");
            String desc = rs.getString("descricao");

            return new Categoria(Integer.valueOf(cod), desc);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Categoria updateCategria(Integer codigo, String novDes){
        String query = "update categorias set descricao = ? where codigo = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1,novDes);

            ppst.setString(2, String.valueOf(codigo));

            ppst.executeQuery();

            con.close();

            return getCategoriaByID(codigo);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteCategoria(Integer codigo){
        String query = "delete from categorias where codigo = ?;";
        try {
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
