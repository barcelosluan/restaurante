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

    public boolean insertReceita(Receita receita){
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
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
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

    public List<Receita> getReceitaCategoria(int cod_categoria) {
        String query = "SELECT r.codigo,\n" +
                "    r.nome as receita,\n" +
                "    e.nome AS cozinheiro\n" +
                "FROM receitas r\n" +
                "INNER JOIN cozinheiros c ON r.cozinheiro = c.cod_empregado\n" +
                "INNER JOIN empregados e ON c.cod_empregado = e.codigo\n" +
                "WHERE r.categoria = ?";
        ArrayList<Receita> receitas = new ArrayList<>();
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setInt(1, cod_categoria);
            ResultSet rs = ppst.executeQuery();


            while (rs.next()){
                Integer codigo = rs.getInt("codigo");
                String nome = rs.getString("receita");
                String nome_cheff = rs.getString("cozinheiro");

                receitas.add(new Receita(codigo,nome,nome_cheff));
            }
            con.close();
            return receitas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }
    }

    public List<Receita> getReceitasIngredientes(){
        String query = "SELECT --DISTINCT\n" +
                "    r.codigo AS cod_receita,\n" +
                "    r.nome AS nome_receita,\n" +
                "    r.data_criacao,\n" +
                "    e.nome AS nome_cheff,\n" +
                "    ca.descricao AS descricao_categoria\n" +
                "FROM ingredientes_receitas ir\n" +
                "INNER JOIN receitas r ON ir.receita = r.codigo\n" +
                "LEFT JOIN categorias ca ON r.categoria = ca.codigo\n" +
                "LEFT JOIN cozinheiros co ON r.cozinheiro = co.cod_empregado\n" +
                "INNER JOIN empregados e ON co.cod_empregado = e.codigo\n" +
                "ORDER BY 1";
        ArrayList<Receita> receitas = new ArrayList<>();
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                Integer codigo = rs.getInt("cod_receita");
                String nome = rs.getString("nome_receita");
                Date contrato = rs.getDate("data_criacao");
                String nome_cheff = rs.getString("nome_cheff");
                String descricao_categoria = rs.getString("descricao_categoria");

                receitas.add(new Receita(codigo,nome,contrato,nome_cheff,descricao_categoria));
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

    public boolean deleteReceita(Integer cod){
        String query = "delete from receitas e where e.codigo = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1, cod);

            ppst.executeQuery();
            con.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateReceita(Receita novReceita){
        String query = "update receitas set nome = ?  where codigo = ?;";
        try {
            Connection con = connector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1,novReceita.getNome());

            ppst.setInt(2, novReceita.getCodigo());

            ppst.executeQuery();

            con.close();

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
