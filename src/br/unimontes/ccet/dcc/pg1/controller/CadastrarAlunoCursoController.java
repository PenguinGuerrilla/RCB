package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoCursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.entity.AlunoCurso;
import br.unimontes.ccet.dcc.pg1.model.entity.Curso;
import br.unimontes.ccet.dcc.pg1.view.interfaces.ComboBoxInterface;
import java.sql.SQLException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class CadastrarAlunoCursoController {

    public static boolean executa(PainelInterface view) {
        HashMap<String, Component> mapa = view.getMapComponentes();
        int result = 0;
        Curso temp = new Curso(0);
        Curso temp2 = new Curso();
        ComboBoxInterface selectCurso = (ComboBoxInterface) mapa.get("selectCurso");
        TextFieldInterface tfCpfAluno = (TextFieldInterface) mapa.get("tfCpfAluno");
        TextFieldInterface tfIdCurso = (TextFieldInterface) mapa.get("tfIdCurso");
        TextFieldInterface tfCreditos = (TextFieldInterface) mapa.get("tfCreditos");
        try {

            temp2.setNome(selectCurso.getSelectedItem().toString());
            CursoDao tempdao = new CursoDao();
            temp = tempdao.findOne(temp2);
        } catch (DAOException | SQLException ex) {
            System.out.println(ex);
        }
        try {
            AlunoDao aDao = new AlunoDao();
            if(aDao.findOne(new Aluno(tfCpfAluno.getText())) == null){
                return false;
            }
            AlunoCurso alunocurso = new AlunoCurso(tfCpfAluno.getText(), temp.getId(), temp.getCreditos());
            AlunoCursoDao acdao = new AlunoCursoDao();
            result = acdao.save(alunocurso);
            if (result == 2) {
                return false;
            }
            alunocurso.setCreditos(temp.getCreditos());
        } catch (DAOException | SQLException ex) {
            System.out.println(ex);
        }

        return true;
    }

}
