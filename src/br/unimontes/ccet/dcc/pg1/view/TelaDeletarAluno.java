/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.unimontes.ccet.dcc.pg1.view;
import br.unimontes.ccet.dcc.pg1.controller.DeletarAlunoController;
import javax.swing.JOptionPane;
/**
 *
 * @author m
 */
public class TelaDeletarAluno extends javax.swing.JFrame {

    /**
     * Creates new form TelaDeletarAluno
     */
    public TelaDeletarAluno() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBase1 = new br.unimontes.ccet.dcc.pg1.view.paineis.PainelBase();
        jLabel1 = new javax.swing.JLabel();
        DeletarButton = new javax.swing.JButton();
        tfCpf = new br.unimontes.ccet.dcc.pg1.view.componentes.TextField();
        VoltarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CPF:");

        DeletarButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        DeletarButton.setText("Deletar");
        DeletarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarButtonActionPerformed(evt);
            }
        });

        tfCpf.setName("tfCpf"); // NOI18N

        VoltarButton.setText("Voltar");
        VoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("Deletar Aluno");

        javax.swing.GroupLayout painelBase1Layout = new javax.swing.GroupLayout(painelBase1);
        painelBase1.setLayout(painelBase1Layout);
        painelBase1Layout.setHorizontalGroup(
            painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBase1Layout.createSequentialGroup()
                .addComponent(VoltarButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBase1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(DeletarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(painelBase1Layout.createSequentialGroup()
                .addGroup(painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBase1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelBase1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel4)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        painelBase1Layout.setVerticalGroup(
            painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBase1Layout.createSequentialGroup()
                .addComponent(VoltarButton)
                .addGap(61, 61, 61)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(DeletarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelBase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelBase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DeletarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarButtonActionPerformed
        //if(painelBase1.getComponents() == null) System.out.println("NADA!!!");
        boolean ret = DeletarAlunoController.executa(painelBase1);
        if(ret == true){
            JOptionPane.showMessageDialog(this, "Aluno deletado com sucesso!");
        }
        else JOptionPane.showMessageDialog(this, "Aluno não deletado!");
    }//GEN-LAST:event_DeletarButtonActionPerformed

    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        this.dispose();
        new TempMenu().setVisible(true);
    }//GEN-LAST:event_VoltarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeletarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeletarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeletarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeletarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeletarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeletarButton;
    private javax.swing.JButton VoltarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private br.unimontes.ccet.dcc.pg1.view.paineis.PainelBase painelBase1;
    private br.unimontes.ccet.dcc.pg1.view.componentes.TextField tfCpf;
    // End of variables declaration//GEN-END:variables
}
