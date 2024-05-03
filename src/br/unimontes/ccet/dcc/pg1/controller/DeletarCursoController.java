package br.unimontes.ccet.dcc.pg1.controller;
import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Curso;
import java.sql.SQLException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.awt.Component;
import java.util.HashMap;

public class DeletarCursoController {
    public static boolean executa(PainelInterface view){
        HashMap<String, Component> mapa = view.getMapComponentes();
        
        TextFieldInterface tfId = (TextFieldInterface) mapa.get("tfId");
        TextFieldInterface tfNome = (TextFieldInterface) mapa.get("tfNome");
        TextFieldInterface tfCreditos = (TextFieldInterface)  mapa.get("tfCreditos");
        
        try{
            Curso curso = new Curso(Integer.parseInt(tfId.getText())/*,tfNome.getText(),Integer.parseInt(tfCreditos.getText())*/);
            
            CursoDao cDao = new CursoDao();
            int ret = cDao.delete(curso);
            if(ret >= 1) return true;
        }
        catch(DAOException e){ 
            System.err.println("Erro ao tentar deletar curso: " + e.getMessage());
        }
        catch(SQLException e2){ 
            System.err.println("Erro ao tentar deletar curso: " + e2.getMessage()+ "SQL state: " + e2.getSQLState());
        }
        return false;
    }
    
}
