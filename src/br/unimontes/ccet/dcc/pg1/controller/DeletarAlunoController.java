package br.unimontes.ccet.dcc.pg1.controller;
import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import java.sql.SQLException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.awt.Component;
import java.util.HashMap;

public class DeletarAlunoController {
    public static boolean executa(PainelInterface view){
        HashMap<String, Component> mapa = view.getMapComponentes();
        
        TextFieldInterface tfNome = (TextFieldInterface) mapa.get("tfNome");
        TextFieldInterface tfCpf = (TextFieldInterface) mapa.get("tfCpf");
        TextFieldInterface tfAno = (TextFieldInterface)  mapa.get("tfAnoNascimento");
        
        try{
            Aluno aluno = new Aluno(tfCpf.getText()/*, 
                    tfNome.getText(),
                    Integer.parseInt(tfAno.getText())*/);
            
            AlunoDao aDao = new AlunoDao();
            int ret = aDao.delete(aluno);
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
