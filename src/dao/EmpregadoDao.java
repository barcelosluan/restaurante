package dao;

import dao.connector.Connector;
import model.Empregado;

import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpregadoDao {
    Connector conector;

    public void insertEmpregado(Empregado empregado){
        String query = "insert into empregados (codigo, nome, data_contrato, rg) values (?,?,?,?);";
        try {
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1, String.valueOf(empregado.getCodigo()));
            ppst.setString(2, empregado.getNome());
            ppst.setString(3, String.valueOf(empregado.getDataContrato()));
            ppst.setString(4, empregado.getRg());

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public List<Empregado> getEmpregados(){
        String query = "select * from empregados;";
        ArrayList<Empregado> empregados = null;
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
            Connection con = conector.connectar();;

            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setString(1, String.valueOf(cod));

            ResultSet rs = ppst.executeQuery();

            Integer codigo = rs.getInt("codigo");
            String nome = rs.getString("nome");
            Date contrato = rs.getDate("data_contrato");
            String rg = rs.getString("rg");

            con.close();
            return new Empregado(codigo, nome, contrato,rg);
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

            ppst.setString(1, String.valueOf(cod));

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
