package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.entity.Curso;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import br.unimontes.ccet.dcc.pg1.view.paineis.PainelBase;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarCursoController {

    public static ArrayList executa(PainelInterface view) {
        try {
            HashMap<String, Component> mapa = view.getMapComponentes();
            CursoDao cDao = new CursoDao();
            ArrayList<Curso> cursos = (ArrayList<Curso>) cDao.findAll();
            return cursos;

        } catch (DAOException e) {
            System.out.println("Erro ao tentar consultar alunos: " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("Erro ao tentar consultar alunos: " + e2.getMessage() + " SQL state: " + e2.getSQLState());
        }
        return null;
    }

    public static ArrayList<Curso> executa() {
        ArrayList<Curso> cursos = new ArrayList();
        try {
            CursoDao cdao = new CursoDao();
            cursos = cdao.findAll();
            if (cursos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NENHUM CURSO REGISTRADO!", null, JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (DAOException | SQLException ex) {
        }
        return cursos;
    }

    public static ArrayList<Curso> consulta(String nome) {
        try {
            Curso a = new Curso();
            a.setNome(nome);
            ArrayList<Curso> a2 = new ArrayList<Curso>();
            CursoDao cDao = new CursoDao();
            a2 = cDao.Consulta(a);
            return a2;
        } catch (SQLException e) {
            System.err.println("Erro ao tentar consultar alunos: " + e.getMessage() + " SQL state: " + e.getSQLState());
        } catch (DAOException e2) {
            System.out.println("Erro ao tentar consultar alunos: " + e2.getMessage());
        }
        return null;
    }

    public static Integer findId(PainelBase view) {
        HashMap<String, Component> mapa = view.getMapComponentes();
        Curso temp = new Curso();
        TextFieldInterface tfNomeCurso = (TextFieldInterface) mapa.get("tfNomeCurso");
        temp.setNome(tfNomeCurso.getText());
        try {
            CursoDao cDao = new CursoDao();
            return cDao.findId(temp).getId();
        } catch (DAOException e) {
            System.err.println("DAOException : " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception: " + e2.getMessage() + "SQL state: " + e2.getSQLState());
        }
        return null;
    }
}
