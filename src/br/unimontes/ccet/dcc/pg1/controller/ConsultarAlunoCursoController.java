package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoCursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.AlunoCurso;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class ConsultarAlunoCursoController {

    public static ArrayList addRowToJTable(PainelInterface view) {
        try {
            HashMap<String, Component> mapa = view.getMapComponentes();
            AlunoCursoDao acDao = new AlunoCursoDao();
            ArrayList<AlunoCurso> aCursos = (ArrayList<AlunoCurso>) acDao.findAll();
            return aCursos;

        } catch (DAOException e) {
            System.out.println("Erro ao tentar consultar matrículas: " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("Erro ao tentar consultar matrículas: " + e2.getMessage() + " SQL state: " + e2.getSQLState());
        }
        return null;
    }

    public static ArrayList<AlunoCurso> consulta(Object dado) {
        try {
            if (dado instanceof String) {
                AlunoCurso a = new AlunoCurso();
                a.setCpf((String) dado);
                ArrayList<AlunoCurso> a2 = new ArrayList<AlunoCurso>();
                AlunoCursoDao acDao = new AlunoCursoDao();
                a2 = acDao.ConsultaCpf(a);
                return a2;
            }
            else/*dado eh um id*/{
                System.out.println("id");
                AlunoCurso a = new AlunoCurso();
                AlunoCursoDao acDao = new AlunoCursoDao();
                a.setIdCurso((Integer) dado);
                System.out.println("dado = "+dado);
                //a.setCpf(acDao.findCpf((Integer)dado));
                ArrayList<AlunoCurso> a2 = new ArrayList<AlunoCurso>();
                a2 = acDao.ConsultaId(a);
                return a2;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao tentar consultar alunos: " + e.getMessage() + " SQL state: " + e.getSQLState());
        } catch (DAOException e2) {
            System.out.println("Erro ao tentar consultar alunos: " + e2.getMessage());
        }
        return null;
    }
}
