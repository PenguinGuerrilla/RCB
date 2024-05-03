package br.unimontes.ccet.dcc.pg1.view.componentes;

import javax.swing.JTextField;

import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;

public class TextField extends JTextField implements TextFieldInterface {
    @Override
    public void setText(String text){
        super.setText(text);
    }
    
    @Override
    public String getText(){
        return super.getText();
    }
}
