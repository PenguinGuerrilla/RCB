package br.unimontes.ccet.dcc.pg1.view.paineis;

import javax.swing.JPanel;

import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import java.awt.Component;
import java.util.HashMap;

public class PainelBase extends JPanel implements PainelInterface {

    @Override
    public HashMap<String, Component> getMapComponentes() {
        Component[] componentes = this.getComponents();
        HashMap<String, Component> mapa = new HashMap<>();
        
        for(Component comp: componentes){
            mapa.put(comp.getName(), comp);
        }
        
        //for(int i=0; i<componentes.length; i++){
        //    mapa.put(componentes[i].getName(), componentes[i]);
        //}
            
        return mapa;
    }
    
}
