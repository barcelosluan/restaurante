package dao;

import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Empregado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DegustadorDao extends EmpregadoDao{

    public void insereDegustador(Degustador degustador){
        String query = "insert into degustadores (cod_empregado) values ( ?)";
        try {
            Connection con = conector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);

            Empregado empregado = getEmpregadoByCod(degustador.getCodEmpregado());
            ppst.setInt(1, empregado.getCodigo());

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Degustador getDegustadorByCod(Integer cod){
        String query = "select d.cod_empregado, nome, data_contrato, rg " +
                "from degustadores d  " +
                "left join empregados e on d.cod_empregado = e.codigo  " +
                "Where d.cod_empregado = ?;";
        try{
            Connection con = conector.connectar();;

            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setInt(1, cod);

            ResultSet rs = ppst.executeQuery();
            Degustador degustador = new Degustador();
            if(rs.next()) {
                degustador.setCodigo(rs.getInt(1));
                degustador.setNome(rs.getString(2));
                degustador.setDataContrato(rs.getDate(3));
                degustador.setRg(rs.getString(4));
            }

            con.close();
            return degustador;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Degustador> getCozinheiros(){
        String query = "select d.cod_empregado, nome, data_contrato, rg " +
                "from degustadores d  " +
                "left join empregados e on d.cod_empregado = e.codigo ;";
        ArrayList<Degustador> degustadores = new ArrayList<>();
        try {
            Connection con = conector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()){
                Integer codigo = rs.getInt("cod_empregado");
                String nome = rs.getString("nome");
                String rg = rs.getString("rg");
                Date data = rs.getDate("data_contrato");

                degustadores.add(new Degustador(codigo,nome,data,rg));
            }
            con.close();
            return degustadores;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void deleteDegustador(Integer cod){
        String query = "delete from degustadores e where e.cod_empregado = ?;";
        try{
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1,cod);

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
