/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.unimontes.ccet.dcc.pg1.view.paineis;

import br.unimontes.ccet.dcc.pg1.view.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author m
 */
public class PainelTempMenu extends javax.swing.JPanel {

    /**
     * Creates new form PainelTempMenu
     */
    public PainelTempMenu() {
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

        CadastrarButton = new javax.swing.JButton();
        DeletarAlunoButton = new javax.swing.JButton();
        ConsultarButton = new javax.swing.JButton();
        CadastrarCursoButton = new javax.swing.JButton();
        DeletarCursoButton = new javax.swing.JButton();
        ConsultarCursoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MatricularAlunoButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        DeletarMatriculaButton = new javax.swing.JButton();
        ConsultarMatriculaButton = new javax.swing.JButton();

        CadastrarButton.setText("Cadastrar");
        CadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarButtonActionPerformed(evt);
            }
        });

        DeletarAlunoButton.setText("Deletar");
        DeletarAlunoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarAlunoButtonActionPerformed(evt);
            }
        });

        ConsultarButton.setText("Consultar");
        ConsultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarButtonActionPerformed(evt);
            }
        });

        CadastrarCursoButton.setText("Cadastrar");
        CadastrarCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarCursoButtonActionPerformed(evt);
            }
        });

        DeletarCursoButton.setText("Deletar");
        DeletarCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarCursoButtonActionPerformed(evt);
            }
        });

        ConsultarCursoButton.setText("Consultar");
        ConsultarCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarCursoButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Cursos");

        jLabel2.setText("Alunos");

        MatricularAlunoButton.setText("Cadastrar");
        MatricularAlunoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatricularAlunoButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Matricula");

        DeletarMatriculaButton.setText("Deletar");
        DeletarMatriculaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarMatriculaButtonActionPerformed(evt);
            }
        });

        ConsultarMatriculaButton.setText("Consultar");
        ConsultarMatriculaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarMatriculaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ConsultarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ConsultarCursoButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CadastrarButton)
                                    .addComponent(DeletarAlunoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(DeletarCursoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CadastrarCursoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DeletarMatriculaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MatricularAlunoButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ConsultarMatriculaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadastrarButton)
                    .addComponent(CadastrarCursoButton)
                    .addComponent(MatricularAlunoButton))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeletarAlunoButton)
                    .addComponent(DeletarCursoButton)
                    .addComponent(DeletarMatriculaButton))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConsultarButton)
                    .addComponent(ConsultarCursoButton)
                    .addComponent(ConsultarMatriculaButton))
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaCadastrarAluno().setVisible(true);
    }//GEN-LAST:event_CadastrarButtonActionPerformed

    private void DeletarAlunoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarAlunoButtonActionPerformed
        // TODO add your handling code here:
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaDeletarAluno().setVisible(true);
    }//GEN-LAST:event_DeletarAlunoButtonActionPerformed

    private void ConsultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaConsultaAluno().setVisible(true);
    }//GEN-LAST:event_ConsultarButtonActionPerformed

    private void CadastrarCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarCursoButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaCadastrarCurso().setVisible(true);
    }//GEN-LAST:event_CadastrarCursoButtonActionPerformed

    private void DeletarCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarCursoButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaDeletarCurso().setVisible(true);
    }//GEN-LAST:event_DeletarCursoButtonActionPerformed

    private void MatricularAlunoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatricularAlunoButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaCadastrarMatricula().setVisible(true);
    }//GEN-LAST:event_MatricularAlunoButtonActionPerformed

    private void ConsultarCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarCursoButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaConsultaCurso().setVisible(true);
    }//GEN-LAST:event_ConsultarCursoButtonActionPerformed

    private void DeletarMatriculaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarMatriculaButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaDeletarMatricula().setVisible(true);
    }//GEN-LAST:event_DeletarMatriculaButtonActionPerformed

    private void ConsultarMatriculaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarMatriculaButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        new TelaConsultaMatricula().setVisible(true);
    }//GEN-LAST:event_ConsultarMatriculaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarButton;
    private javax.swing.JButton CadastrarCursoButton;
    private javax.swing.JButton ConsultarButton;
    private javax.swing.JButton ConsultarCursoButton;
    private javax.swing.JButton ConsultarMatriculaButton;
    private javax.swing.JButton DeletarAlunoButton;
    private javax.swing.JButton DeletarCursoButton;
    private javax.swing.JButton DeletarMatriculaButton;
    private javax.swing.JButton MatricularAlunoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}