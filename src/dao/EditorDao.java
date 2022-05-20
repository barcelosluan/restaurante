package dao;

import model.Editor;
import model.Empregado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditorDao extends EmpregadoDao{

    public boolean insertEditor(Editor editor){
        String query = "insert into degustadores (cod_empregado) values (?);";
        try {
            Connection con = conector.connectar();
            PreparedStatement ppst = con.prepareStatement(query);

            Empregado empregado = getEmpregadoByCod(editor.getCodEmpregado());
            ppst.setInt(1, empregado.getCodigo());

            ppst.executeQuery();
            con.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Editor getEditorByCod(Integer cod){
        String query = "select d.cod_empregado, nome, data_contrato, rg " +
                "from editores d  " +
                "left join empregados e on d.cod_empregado = e.codigo  " +
                "Where d.cod_empregado = ?;";
        try{
            Connection con = conector.connectar();;

            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setInt(1, cod);

            ResultSet rs = ppst.executeQuery();
            Editor editor = new Editor();
            if(rs.next()) {
                editor.setCodigo(rs.getInt(1));
                editor.setNome(rs.getString(2));
                editor.setDataContrato(rs.getDate(3));
                editor.setRg(rs.getString(4));
            }

            con.close();
            return editor;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Editor> getEditores(){
        String query = "select * from editores;";
        ArrayList<Editor> editores = new ArrayList<>();
        try {
            Connection con = conector.connectar();

            PreparedStatement ppst = con.prepareStatement(query);

            ResultSet rs = ppst.executeQuery();

            while (rs.next()){
                Integer codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date contrato = rs.getDate("data_contrato");
                String rg = rs.getString("rg");

                editores.add(new Editor(codigo,nome,contrato,rg));
            }
            con.close();
            return editores;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }

    }

    public boolean deleteEditor(Integer cod){
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
