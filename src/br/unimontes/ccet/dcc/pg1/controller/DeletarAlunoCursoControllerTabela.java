package br.unimontes.ccet.dcc.pg1.controller;
import br.unimontes.ccet.dcc.pg1.model.dao.AlunoCursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.AlunoCurso;
import java.sql.SQLException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.awt.Component;
import java.util.HashMap;

public class DeletarAlunoCursoControllerTabela {
    public static boolean executaTabela(String cpfAluno,Integer idCurso){
       
        try{
            AlunoCurso aCurso = new AlunoCurso(cpfAluno,idCurso);
            AlunoCursoDao aCursoDao = new AlunoCursoDao();
            int ret = aCursoDao.delete(aCurso);
            if(ret >= 1) return true;
        }
        catch(DAOException e){
            System.err.println("Erro ao tentar cadstrar aluno: " + e.getMessage());
            return false;
        }
        catch(SQLException e2){ 
            System.err.println("Erro ao tentar cadastrar aluno: " + e2.getMessage() + "SQL state: " + e2.getSQLState());
            return false;}
        return false;
    }
}
