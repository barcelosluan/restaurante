package dao;

import dao.connector.Connector;
import model.Empregado;
import model.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceitaDao {
    Connector connector = new Connector();

    public void insertReceita(Receita receita){
        String query = "insert into receitas (codigo, nome, data_criacao, cozinheiro, categoria) values (?, ? , ? , ? , ?);";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            java.sql.Date dataSql = new java.sql.Date(receita.getDataCriacao().getTime());
            ppst.setInt(1, receita.getCodigo());
            ppst.setString(2, receita.getNome());
            ppst.setDate(3, dataSql);
            ppst.setInt(4, receita.getCodCozinheiro());
            ppst.setInt(5, receita.getCodCategoria());

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Receita> getReceitas(){
        String query = "select * from receitas;";
        ArrayList<Receita> receitas = new ArrayList<>();
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                Integer codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date contrato = rs.getDate("data_criacao");
                Integer codCoz = rs.getInt("cozinheiro");
                Integer codcat = rs.getInt("categoria");

                receitas.add(new Receita(codigo,nome,contrato,codCoz,codcat));
            }
            con.close();
            return receitas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }

    }

    public Receita getReceitaByCod(Integer cod){
        String query = "select * from receitas e where e.codigo = ?;";
        try{
            Connection con = connector.connectar();;

            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setInt(1, cod);

            ResultSet rs = ppst.executeQuery();
            Receita receita = new Receita();
            if(rs.next()) {
                receita.setCodigo(rs.getInt(1));
                receita.setNome(rs.getString(2));
                receita.setDataCriacao(rs.getDate(3));
                receita.setCodCozinheiro(rs.getInt(4));
                receita.setCodCategoria(rs.getInt(5));
            }

            con.close();
            return receita;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteReceita(Integer cod){
        String query = "delete from receitas e where e.codigo = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1, cod);

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Receita updateReceita(Receita novReceita){
        String query = "update receitas set nome = ?  where codigo = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1,novReceita.getNome());

            ppst.setInt(2, novReceita.getCodigo());

            ppst.executeQuery();

            con.close();

            return getReceitaByCod(novReceita.getCodigo());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
