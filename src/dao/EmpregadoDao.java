package dao;

import dao.connector.Connector;
import model.Empregado;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpregadoDao {
    Connector conector = new Connector();

    public void insertEmpregado(Empregado empregado){
        String query = "insert into empregados (codigo , nome , data_contrato , rg) values ( ? , ? , ? , ?);";
        try {
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            java.sql.Date dataSql = new java.sql.Date(empregado.getDataContrato().getTime());
            ppst.setInt(1, empregado.getCodigo());
            ppst.setString(2, empregado.getNome());
            ppst.setDate(3, dataSql);
            ppst.setString(4, empregado.getRg());

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public List<Empregado> getEmpregados(){
        String query = "select * from empregados;";
        ArrayList<Empregado> empregados = new ArrayList<>();
        try {
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                Integer codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date contrato = rs.getDate("data_contrato");
                String rg = rs.getString("rg");

                empregados.add(new Empregado(codigo,nome,contrato,rg));
            }
            con.close();
            return empregados;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }

    }

    public Empregado getEmpregadoByCod(Integer cod){
        String query = "select * from empregados e where e.codigo = ?;";
        try{
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setInt(1, cod);

            ResultSet rs = ppst.executeQuery();
            Empregado empregado = new Empregado();
            if(rs.next()) {
                empregado.setCodigo(rs.getInt(1));
                empregado.setNome(rs.getString(2));
                empregado.setDataContrato(rs.getDate(3));
                empregado.setRg(rs.getString(4));
            }

            con.close();
            return empregado;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void deleteEmpregado(Integer cod){
        String query = "delete from empregados e where e.codigo = ?;";
        try {
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1, cod);

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean updateEmpregado(Empregado novEmpregado){
        String query = "update empregados set nome = ?  where codigo = ?;";
        try {
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1,novEmpregado.getNome());

            ppst.setInt(2, novEmpregado.getCodigo());

            ppst.executeQuery();

            con.close();

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
