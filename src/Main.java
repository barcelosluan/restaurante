import dao.CozinheiroDao;
import dao.EmpregadoDao;
import model.Cozinheiro;
import model.Empregado;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Empregado empregado = new Empregado(2,"marcos",date, "chefe");
        Cozinheiro cozinheiro = new Cozinheiro(2,"chefe");
        List<Cozinheiro> cozinheiros = new ArrayList<>();
        CozinheiroDao cozinheiroDao = new CozinheiroDao();
        EmpregadoDao dao = new EmpregadoDao();
        cozinheiroDao.deleteCozinheiro(2);

    }
}