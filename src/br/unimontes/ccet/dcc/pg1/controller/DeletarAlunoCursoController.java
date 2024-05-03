package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoCursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.AlunoCurso;
import java.sql.SQLException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.awt.Component;
import java.util.HashMap;

public class DeletarAlunoCursoController {

    public static boolean executa(PainelInterface view) {
        HashMap<String, Component> mapa = view.getMapComponentes();

        TextFieldInterface tfCpfAluno = (TextFieldInterface) mapa.get("tfCpfAluno");
        TextFieldInterface tfIdCurso = (TextFieldInterface) mapa.get("tfIdCurso");

        try {
            AlunoCurso aCurso = new AlunoCurso(tfCpfAluno.getText(),
                    Integer.parseInt(tfIdCurso.getText())
            );

            AlunoCursoDao aCursoDao = new AlunoCursoDao();
            int ret = aCursoDao.delete(aCurso);
            if (ret >= 1) {
                return true;
            }
        } catch (DAOException e) {
            System.err.println("Erro ao tentar cadstrar aluno: " + e.getMessage());
            return false;
        } catch (SQLException e2) {
            System.err.println("Erro ao tentar cadastrar aluno: " + e2.getMessage() + "SQL state: " + e2.getSQLState());
            return false;
        }
        return false;
    }

    public static int deleteFromCpf(String cpf) throws DAOException {
        int ret;
        try {
            AlunoCursoDao acDao = new AlunoCursoDao();
            ret = acDao.deleteFromCpf(cpf);
        } catch (SQLException e) {
            throw new DAOException("Erro ao tentar deletar entidade AlunoCurso. SQLSTATE: " + e.getSQLState());
        }
        return ret;
    }

    public static int deleteFromId(Integer id) throws DAOException {
        int ret;
        try {
            AlunoCursoDao acDao = new AlunoCursoDao();
            ret = acDao.deleteFromId(id);
        } catch (SQLException e) {
            throw new DAOException("Erro ao tentar deletar entidade AlunoCurso. SQLSTATE: " + e.getSQLState());
        }
        return ret;
    }
}
