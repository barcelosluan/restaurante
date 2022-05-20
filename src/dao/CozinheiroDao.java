package dao;

import model.Cozinheiro;
import model.Empregado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CozinheiroDao extends EmpregadoDao {


    public boolean insereCozinheiro(Cozinheiro cozinheiro){
        String query = "insert into cozinheiros (cod_empregado , fantasia) values ( ?, ?)";
        try {
            Connection con = conector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);

            Empregado empregado = getEmpregadoByCod(cozinheiro.getCodEmpregado());
            ppst.setInt(1, empregado.getCodigo());
            ppst.setString(2, cozinheiro.getFantasia());

            ppst.executeQuery();
            con.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public Cozinheiro getCozinheiroByCod(Integer cod){
        String query = "select c.cod_empregado, fantasia, nome, data_contrato, rg " +
                "from cozinheiros c  " +
                "left join empregados e on c.cod_empregado = e.codigo  " +
                "Where c.cod_empregado = ?;";
        try {
            Connection con = conector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1, cod);

            ResultSet rs = ppst.executeQuery();

            Cozinheiro cozinheiro = new Cozinheiro();
            if(rs.next()) {
                cozinheiro.setCodigo(rs.getInt("cod_empregado"));
                cozinheiro.setNome(rs.getString("nome"));
                cozinheiro.setFantasia(rs.getString("fantasia"));
                cozinheiro.setRg(rs.getString("rg"));
                cozinheiro.setDataContrato(rs.getDate("data_contrato"));
            }
            con.close();
            return cozinheiro;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Cozinheiro> getCozinheiros(){
        String query = "select c.cod_empregado, fantasia, nome, data_contrato, rg " +
                "from cozinheiros c  " +
                "left join empregados e on c.cod_empregado = e.codigo ;";
        ArrayList<Cozinheiro> cozinheiros = new ArrayList<>();
        try {
            Connection con = conector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()){
                Integer codigo = rs.getInt("cod_empregado");
                String nome = rs.getString("nome");
                String fantasia = rs.getString("fantasia");
                String rg = rs.getString("rg");
                Date data = rs.getDate("data_contrato");

                cozinheiros.add(new Cozinheiro(codigo,nome,data,rg,fantasia));
            }
            con.close();
            return cozinheiros;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public boolean updateCozinheiro(Cozinheiro cozinheiro){
        String query = "update cozinheiros set fantasia = ? where cod_empregado = ?;";
        try {
            Connection con = conector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);
            Empregado coz = getEmpregadoByCod(cozinheiro.getCodEmpregado());

            ppst.setInt(2, coz.getCodigo());
            ppst.setString(1, cozinheiro.getFantasia());

            ppst.executeQuery();

            con.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteCozinheiro(Integer cod){
        String query = "delete from cozinheiros e where e.cod_empregado = ?;";
        try{
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1,cod);

            ppst.executeQuery();
            con.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

}
