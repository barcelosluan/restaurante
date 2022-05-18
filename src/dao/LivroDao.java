package dao;

import dao.connector.Connector;
import model.Degustador;
import model.Editor;
import model.Empregado;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LivroDao extends EditorDao {
    Connector connector = new Connector();

    public void insertLivro(Livro livro, Editor editord){
        String query = "insert into livros (titulo, isbn, editor) values (?,?,?);";
        try {
            Connection con = connector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);

            Editor editor = getEditorByCod(editord.getCodEmpregado());
            ppst.setString(1, livro.getTitulo());
            ppst.setString(2, livro.getIsbn());
            ppst.setInt(3, editor.getCodEmpregado());

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Livro getLivroByTitulo(String titulo){
        String query = "select * from livros where titulo LIKE ?; ";
        try{
            Connection con = conector.connectar();;

            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setString(1, titulo);

            ResultSet rs = ppst.executeQuery();
            Livro livro = new Livro();
            if(rs.next()) {
                livro.setTitulo(rs.getString(1));
                livro.setIsbn(rs.getString(2));
                livro.setCodEditor(rs.getInt(3));
            }

            con.close();
            return livro;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Livro> getLivros(){
        String query = "select * from livros;";
        ArrayList<Livro> livros = new ArrayList<>();
        try {
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                String titulo = rs.getString("titulo");
                String isbn = rs.getString("isbn");
                Integer editor = rs.getInt("editor");

                livros.add(new Livro(titulo,isbn,editor));
            }
            con.close();
            return livros;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }

    }

    public void deleteLivro(String titulo){
        String query = "delete from livros where titulo LIKE ?;";
        try{
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ppst.setString(1,titulo);

            ppst.executeQuery();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
