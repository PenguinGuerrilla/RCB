package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class ConsultarAlunoController {

    public static ArrayList addRowToJTable(PainelInterface view) {
        try {
            HashMap<String, Component> mapa = view.getMapComponentes();
            AlunoDao aDao = new AlunoDao();
            ArrayList<Aluno> alunos = (ArrayList<Aluno>) aDao.findAll();
            return alunos;

        } catch (DAOException e) {
            System.out.println("Erro ao tentar consultar alunos: " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("Erro ao tentar consultar alunos: " + e2.getMessage() + " SQL state: " + e2.getSQLState());
        }
        return null;
    }

    public static ArrayList<Aluno> consulta(String nome) {
        try {
            Aluno a = new Aluno();
            a.setNome(nome);
            ArrayList<Aluno> a2 = new ArrayList<Aluno>();
            AlunoDao aDao = new AlunoDao();
            a2 = aDao.Consulta(a);
            return a2;
        } catch (SQLException e) {
            System.err.println("Erro ao tentar consultar alunos: " + e.getMessage() + " SQL state: " + e.getSQLState());
        } catch (DAOException e2) {
            System.out.println("Erro ao tentar consultar alunos: " + e2.getMessage());
        }
        return null;
    }

    public static String findNome(PainelInterface view) {
        HashMap<String, Component> mapa = view.getMapComponentes();
        Aluno temp = new Aluno();
        TextFieldInterface tfCpfAluno = (TextFieldInterface) mapa.get("tfCpfAluno");
        temp.setCpf(tfCpfAluno.getText());
        try {
            AlunoDao aDao = new AlunoDao();
            return aDao.findOne(temp).getNome();
        } catch (DAOException e) {
            System.err.println("DAOException : " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception: " + e2.getMessage() + "SQL state: " + e2.getSQLState());
        }
        return null;
    }

    public static String findCpf(PainelInterface view) {
        HashMap<String, Component> mapa = view.getMapComponentes();
        Aluno temp = new Aluno();
        TextFieldInterface tfNome = (TextFieldInterface) mapa.get("tfNome");
        temp.setNome(tfNome.getText());
        try {
            AlunoDao aDao = new AlunoDao();
            return aDao.findCpf(temp).getCpf();
        } catch (DAOException e) {
            System.err.println("DAOException : " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception: " + e2.getMessage() + "SQL state: " + e2.getSQLState());
        }
        return null;
    }
        public static String findCpf(String nome) {
        //HashMap<String, Component> mapa = view.getMapComponentes();
        Aluno temp = new Aluno();
        //TextFieldInterface tfNome = (TextFieldInterface) mapa.get("tfNome");
        temp.setNome(nome);
        try {
            AlunoDao aDao = new AlunoDao();
            return aDao.findCpf(temp).getCpf();
        } catch (DAOException e) {
            System.err.println("DAOException : " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception: " + e2.getMessage() + "SQL state: " + e2.getSQLState());
        }
        return null;
    }
}
