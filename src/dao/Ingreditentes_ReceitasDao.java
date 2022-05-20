package dao;

import dao.connector.Connector;
import model.Cozinheiro;
import model.Ingrediente;
import model.Ingredientes_Receitas;
import model.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ingreditentes_ReceitasDao {
    Connector connector = new Connector();

    public boolean insertIngrediente_Receita(Ingredientes_Receitas ing){
        String query = "insert into ingredientes_receitas (receita, cozinheiro, ingrediente, quantidade, medida, descricao, rendimento)" +
                "values (?,?,?,?,?,?,?);";
        try {
            Connection conn = connector.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);

            ppst.setInt(1, Integer.parseInt(ing.getReceita()));
            ppst.setInt(2,ing.getCodCozinheiro());
            ppst.setInt(3, ing.getCodIngrediente());
            ppst.setDouble(4, ing.getQuantidade());
            ppst.setString(5,ing.getMedida());
            ppst.setString(6,ing.getDescricao());
            ppst.setInt(7,Integer.parseInt(ing.getRendimento()));

            ppst.executeQuery();
            conn.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
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
