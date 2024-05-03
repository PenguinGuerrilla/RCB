package br.unimontes.ccet.dcc.pg1.view.componentes;

import br.unimontes.ccet.dcc.pg1.controller.ConsultarCursoController;
import javax.swing.JComboBox;

import br.unimontes.ccet.dcc.pg1.view.interfaces.ComboBoxInterface;
import br.unimontes.ccet.dcc.pg1.model.entity.Curso;
import br.unimontes.ccet.dcc.pg1.view.interfaces.ComboBoxInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ComboBoxCursos extends JComboBox implements ComboBoxInterface {
    
    private int loaded = 0;
    
    public ComboBoxCursos() {
        
        this.setForeground(Color.WHITE);
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        this.setFont(font);
        this.addItem(" ");
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                load();
                loaded = 1;
            }
        });
    }
    
    public void load() {
        if (loaded == 0) {
            ArrayList<Curso> cursos = ConsultarCursoController.executa();
            if (cursos != null) {
                setEnabled(true);
                for (Curso curso : cursos) {                    
                    addItem(curso.getNome());
                }
                removeItemAt(0);
            } else {
                setEnabled(false);
            }
        }
    }
    
    public void removeSelecionado() {
        if (this.getItemCount() == 1) {
            this.addItem(" ");
            this.removeItemAt(this.getSelectedIndex());
        } else {
            this.removeItemAt(this.getSelectedIndex());
        }
    }
    
    public int getLoaded() {
        return loaded;
    }
    
    public void setLoaded(int loaded) {
        this.loaded = loaded;
    }
    
    @Override
    public Object getSelectedItem() {
        return super.getSelectedItem().toString();
    }
    
    @Override
    public void addItem(String item) {
        super.addItem(item);
    }
    
    @Override
    public void removeAllItems() {
        super.removeAllItems();
        this.addItem(" ");
    }
}
