package dao;

import dao.connector.Connector;
import model.Livro;
import model.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Receitas_LivrosDao {
    Connector connector = new Connector();

    public void insertReceitaLivros(Receita receita, Livro livro){
        String query = "insert into receitas_livros (receita, livro) values (?, ?);";
        try {
            Connection con = connector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setInt(1, receita.getCodigo());
            ppst.setString(2, livro.getTitulo());
            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //TODO: Verificar quais selects serao feitos

    public void deleteReceitaLivro(Receita receita, Livro livro){
        String query = "delete from receitas_livros where receita = ? AND livro = ?;";
        try{
            Connection connection = connector.connectar();
            PreparedStatement ppst = connection.prepareStatement(query);
            ppst.setInt(1,receita.getCodCozinheiro());
            ppst.setString(2,livro.getTitulo());
            ppst.executeQuery();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
