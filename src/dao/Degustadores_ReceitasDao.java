package dao;

import dao.connector.Connector;
import model.Degustador;
import model.Degustador_Receita;
import model.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Degustadores_ReceitasDao {
    Connector connector = new Connector();

    public boolean insertDegustadorReceita(Degustador_Receita degustador ){
        String query = "insert into degustadores_receitas (degustador, receita, data_degustacao, nota) values (?,?,?,?);";
        try {
            Connection conn = connector.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);

            java.sql.Date dataSql = new java.sql.Date(new Date().getTime());
            ppst.setInt(1, degustador.getCodDegustador());
            ppst.setInt(2, degustador.getCodReceita());
            ppst.setDate(3,dataSql);
            ppst.setDouble(4, degustador.getNota());
            ppst.executeQuery();
            conn.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    //TODO: Verificar quais selects serao feitos

    public void updateDegustadorReceita(Degustador degustador, Receita receita, Double nota){
        String query = "update degustadores_receitas set nota = ? WHERE degustador=? and receita=?;";
        try {
            Connection conn = connector.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);

            ppst.setDouble(1, nota);
            ppst.setInt(2, degustador.getCodEmpregado());
            ppst.setInt(3, receita.getCodigo());
            ppst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteDegustadorReceita(Degustador degustador, Receita receita){
        String query = "delete from degustadores_receitas WHERE degustador=? and receita=?;";
        try {
            Connection conn = connector.connectar();
            PreparedStatement ppst = conn.prepareStatement(query);

            ppst.setInt(1, degustador.getCodEmpregado());
            ppst.setInt(2, receita.getCodigo());
            ppst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
