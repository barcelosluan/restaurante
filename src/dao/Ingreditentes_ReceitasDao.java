package dao;

import dao.connector.Connector;
import model.Cozinheiro;
import model.Ingrediente;
import model.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ingreditentes_ReceitasDao {
    Connector connector = new Connector();

    public void insertIngrediente_Receita(Ingrediente ingrediente, Cozinheiro cozinheiro,
                                          Receita receita, Double quantidade, String medida,
                                          String descricao, Integer rendimento){
        String query = "insert into ingredientes_receitas (receita, cozinheiro, ingrediente, quantidade, medida, descricao, rendimento)" +
                "values (?,?,?,?,?,?,?);";
        try {
            Connection conn = connector.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);

            ppst.setInt(1, receita.getCodigo());
            ppst.setInt(2,cozinheiro.getCodEmpregado());
            ppst.setString(3, ingrediente.getDescricao());
            ppst.setDouble(4, quantidade);
            ppst.setString(5,medida);
            ppst.setString(6,descricao);
            ppst.setInt(7,rendimento);

            ppst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    //TODO: Verificar selects

    public void updateIngredienteReceita(Receita receita, Double quantidade, String medida, String descricao, Integer rendimento, Cozinheiro cozinheiro){
        String query = "update ingredientes_receitas set quantidade=?, medida=?,descricao=?,rendimento=? where receita =? and cozinheiro = ?;";
        try {
            Connection conn = connector.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);

            ppst.setDouble(1,quantidade);
            ppst.setString(2,medida);
            ppst.setString(3,descricao);
            ppst.setInt(4,rendimento);
            ppst.setInt(5, receita.getCodigo());
            ppst.setInt(6, cozinheiro.getCodEmpregado());
            ppst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteIngredienteReceita(Receita receita, Cozinheiro cozinheiro){
        String query = "delete from ingredientes_receitas where receita =? and cozinheiro=?;";
        try {
            Connection conn = connector.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);

            ppst.setInt(1, receita.getCodigo());
            ppst.setInt(2, cozinheiro.getCodEmpregado());
            ppst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
