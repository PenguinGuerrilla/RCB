package br.unimontes.ccet.dcc.pg1.controller;
import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.entity.Curso;
import java.sql.SQLException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.awt.Component;
import java.util.HashMap;

public class DeletarCursoControllerTabela {
    public static boolean executaTabela(Integer idCurso){
        //HashMap<String, Component> mapa = view.getMapComponentes();
        
//        TextFieldInterface tfNome = (TextFieldInterface) mapa.get("tfNome");
//        TextFieldInterface tfCpf = (TextFieldInterface) mapa.get("tfCpf");
//        TextFieldInterface tfAno = (TextFieldInterface)  mapa.get("tfAnoNascimento");
        
        try{
           Curso curso = new Curso(idCurso);
            
            CursoDao cDao = new CursoDao();
            int ret = cDao.delete(curso);
            if(ret >= 1) return true;
        }
        catch(DAOException e){ 
            System.err.println("Erro ao tentar deletar aluno: " + e.getMessage());
        }
        catch(SQLException e2){ 
            System.err.println("Erro ao tentar deletar aluno: " + e2.getMessage()+ "SQL state: " + e2.getSQLState());
        }
        return false;
    }
    
}
