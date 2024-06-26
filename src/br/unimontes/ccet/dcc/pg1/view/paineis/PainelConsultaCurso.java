/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.unimontes.ccet.dcc.pg1.view.paineis;

import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PainelInterface;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import br.unimontes.ccet.dcc.pg1.controller.ConsultarAlunoController;
import br.unimontes.ccet.dcc.pg1.controller.ConsultarCursoController;
import br.unimontes.ccet.dcc.pg1.controller.DeletarAlunoControllerTabela;
import br.unimontes.ccet.dcc.pg1.controller.DeletarAlunoCursoController;
import br.unimontes.ccet.dcc.pg1.controller.DeletarCursoControllerTabela;
import br.unimontes.ccet.dcc.pg1.model.entity.Curso;
import br.unimontes.ccet.dcc.pg1.view.componentes.TableActionCellEditor;
import br.unimontes.ccet.dcc.pg1.view.componentes.TableActionCellRender;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TableActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author m
 */
public class PainelConsultaCurso extends javax.swing.JPanel {

    /**
     * Creates new form PainelConsultaAluno
     */
    public PainelConsultaCurso() {
        initComponents();
        PreencherTabela();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                painelBase1.removeAll();
                painelBase1.repaint();
                painelBase1.revalidate();
                Curso c = new Curso();
                c.setId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                c.setNome((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
                c.setCreditos((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
                PainelUpdateCurso pCurso = new PainelUpdateCurso(c);
                pCurso.setSize(painelBase1.getWidth(), painelBase1.getHeight());
                painelBase1.add(pCurso);
                painelBase1.repaint();
                painelBase1.revalidate();
            }

            @Override
            public void onDelete(int row) {
                int confirm = JOptionPane.showConfirmDialog(painelBase1, "Deseja relamente deletar o curso?",
                        "Deletar Curso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        boolean ret = DeletarCursoControllerTabela.executaTabela(Integer.parseInt(lableAux.getText()));
                        DeletarAlunoCursoController.deleteFromId(Integer.parseInt(lableAux.getText()));
                        PreencherTabela();
                        //DeletarAlunoController.executa(painelBase1);
                        if (ret) {
                            JOptionPane.showMessageDialog(painelBase1, "Curso deletado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(painelBase1, "Curso não deletado!");
                        }
                    } catch (DAOException ex) {
                        Logger.getLogger(PainelConsultaCurso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };

        jTable1.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));

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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new br.unimontes.ccet.dcc.pg1.view.componentes.TextField();
        jButton1 = new javax.swing.JButton();
        lableAux = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));

        painelBase1.setBackground(new java.awt.Color(255, 255, 255));
        painelBase1.setMaximumSize(new java.awt.Dimension(601, 551));
        painelBase1.setMinimumSize(new java.awt.Dimension(601, 551));
        painelBase1.setPreferredSize(new java.awt.Dimension(601, 551));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Consultar Cursos");

        jScrollPane3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane3FocusGained(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Creditos", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome do Curso:");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lableAux.setBackground(new java.awt.Color(255, 255, 255));
        lableAux.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lableAux.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelBase1Layout = new javax.swing.GroupLayout(painelBase1);
        painelBase1.setLayout(painelBase1Layout);
        painelBase1Layout.setHorizontalGroup(
            painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBase1Layout.createSequentialGroup()
                .addGroup(painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBase1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1))
                    .addGroup(painelBase1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(lableAux, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(168, 168, 168))
            .addGroup(painelBase1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(painelBase1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        painelBase1Layout.setVerticalGroup(
            painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBase1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(painelBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lableAux, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String aConsulta = tfNome.getText();
        if (aConsulta == null) {
            PreencherTabela();
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        ConsultarCursoController a = new ConsultarCursoController();

        ArrayList<Curso> cursos = ConsultarCursoController.consulta(aConsulta);
        ;
        cursos.forEach((Curso curso) -> {
            model.addRow(new Object[]{curso.getId(), curso.getNome(), curso.getCreditos()});
        });
        jTable1.setModel(tableModel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jScrollPane3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3FocusGained

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        lableAux.setText("" + d1.getValueAt(jTable1.getSelectedRow(), 0));
    }//GEN-LAST:event_jTable1FocusGained
    private void PreencherTabela() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        ArrayList<Curso> cursos = ConsultarCursoController.executa(painelBase1);
        cursos.forEach((Curso curso) -> {
            model.addRow(new Object[]{curso.getId(), curso.getNome(), curso.getCreditos()});
        });
        jTable1.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lableAux;
    private br.unimontes.ccet.dcc.pg1.view.paineis.PainelBase painelBase1;
    private br.unimontes.ccet.dcc.pg1.view.componentes.TextField tfNome;
    // End of variables declaration//GEN-END:variables
}
