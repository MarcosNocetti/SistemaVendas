package com.jdenner.gui;

import com.jdenner.dao.FuncionarioDAO;
import com.jdenner.gui.tm.FuncionarioTableModel;
import com.jdenner.to.Funcionario;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/**
 * Janela de cadastro de Funcionario
 *
 */
public class CadastroFuncionario extends javax.swing.JInternalFrame {

    private Funcionario funcionario = null;
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public CadastroFuncionario() {
        initComponents();
        habilitarFormulario(false);
        carregarGrade();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBarraFerramentas = new javax.swing.JPanel();
        barraFerramentas = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pnForm = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        lbCpf = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        ftfDataNascimento = new javax.swing.JFormattedTextField();
        ftfCpf = new javax.swing.JFormattedTextField();
        ftfSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ftfNivel = new javax.swing.JFormattedTextField();
        ftfNome = new javax.swing.JFormattedTextField();
        spGrade = new javax.swing.JScrollPane();
        tbGrade = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de funcionario");
        getContentPane().setLayout(null);

        pnBarraFerramentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
        pnBarraFerramentas.setOpaque(false);
        pnBarraFerramentas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        barraFerramentas.setFloatable(false);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/novo.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setFocusable(false);
        btNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btNovo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/novo-foco.png"))); // NOI18N
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        barraFerramentas.add(btNovo);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btSalvar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/salvar-foco.png"))); // NOI18N
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        barraFerramentas.add(btSalvar);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setFocusable(false);
        btExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btExcluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/excluir-foco.png"))); // NOI18N
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        barraFerramentas.add(btExcluir);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/cancelar-foco.png"))); // NOI18N
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        barraFerramentas.add(btCancelar);

        pnBarraFerramentas.add(barraFerramentas);

        getContentPane().add(pnBarraFerramentas);
        pnBarraFerramentas.setBounds(180, 20, 340, 55);

        pnForm.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0), javax.swing.BorderFactory.createTitledBorder(null, "Formulário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 153, 255)))); // NOI18N
        pnForm.setOpaque(false);
        pnForm.setLayout(null);

        lbNome.setText("Nome:");
        pnForm.add(lbNome);
        lbNome.setBounds(96, 26, 31, 14);

        lbCpf.setText("CPF:");
        pnForm.add(lbCpf);
        lbCpf.setBounds(104, 50, 23, 14);

        lbDataNascimento.setText("Data Nascimento:");
        pnForm.add(lbDataNascimento);
        lbDataNascimento.setBounds(42, 74, 85, 14);

        ftfDataNascimento.setColumns(25);
        pnForm.add(ftfDataNascimento);
        ftfDataNascimento.setBounds(130, 70, 90, 20);

        ftfCpf.setColumns(10);
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setValue(new String());
        pnForm.add(ftfCpf);
        ftfCpf.setBounds(131, 47, 86, 20);
        pnForm.add(ftfSenha);
        ftfSenha.setBounds(130, 100, 90, 20);

        jLabel1.setText("Senha:");
        pnForm.add(jLabel1);
        jLabel1.setBounds(80, 100, 34, 14);

        jLabel2.setText("Nivel:");
        pnForm.add(jLabel2);
        jLabel2.setBounds(90, 130, 27, 14);

        ftfNivel.setToolTipText("");
        pnForm.add(ftfNivel);
        ftfNivel.setBounds(130, 130, 30, 20);

        ftfNome.setColumns(25);
        ftfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftfNomeKeyReleased(evt);
            }
        });
        pnForm.add(ftfNome);
        ftfNome.setBounds(131, 23, 206, 20);

        getContentPane().add(pnForm);
        pnForm.setBounds(130, 80, 440, 180);

        tbGrade.setAutoCreateRowSorter(true);
        tbGrade.setModel(new FuncionarioTableModel());
        tbGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGradeMouseClicked(evt);
            }
        });
        spGrade.setViewportView(tbGrade);

        getContentPane().add(spGrade);
        spGrade.setBounds(10, 260, 670, 220);

        setBounds(10, 10, 705, 533);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        funcionario = new Funcionario();
        habilitarFormulario(true);
        ftfNome.setEnabled(true);
        ftfCpf.setEnabled(true);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validarFormulario()) {
            funcionario.setNome(ftfNome.getText().trim());
            funcionario.setCpf((String) ftfCpf.getValue());
            funcionario.setDataNascimento((String) ftfDataNascimento.getValue());
            funcionario.setSenha((String) ftfSenha.getText());
            funcionario.setNivel(ftfNivel.getText());



            if (funcionario.getCodigo() == 0) {
                try {
                    funcionarioDAO.inserir(funcionario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir o funcionario.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                try {
                    funcionarioDAO.alterar(funcionario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar o funcionario.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o funcionario " + funcionario + "?");
        if (opcao == 0) {
            try {
                funcionarioDAO.excluir(funcionario);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o funcionario.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tbGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGradeMouseClicked
        if (evt.getClickCount() == 2) {
            FuncionarioTableModel tm = (FuncionarioTableModel) tbGrade.getModel();
            funcionario = tm.getRowValue(tbGrade.getRowSorter().convertRowIndexToModel(tbGrade.getSelectedRow()));

            ftfNome.setValue(funcionario.getNome());
            ftfCpf.setValue(funcionario.getCpf());
            ftfDataNascimento.setValue(funcionario.getDataNascimento());

            habilitarFormulario(true);
        }
    }//GEN-LAST:event_tbGradeMouseClicked

    private void ftfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfNomeKeyReleased
        TableRowSorter rs = (TableRowSorter) tbGrade.getRowSorter();
        rs.setRowFilter(RowFilter.regexFilter("(?i)" + ftfNome.getText(), 0, 1));        // TODO add your handling code here:
    }//GEN-LAST:event_ftfNomeKeyReleased

    private void habilitarFormulario(boolean ativo) {
        btNovo.setEnabled(!ativo);
        btSalvar.setEnabled(ativo);
        btExcluir.setEnabled(ativo);
        btCancelar.setEnabled(ativo);
        ftfNome.setEnabled(!ativo);
        ftfCpf.setEnabled(!ativo);
        ftfDataNascimento.setEnabled(ativo);
        tbGrade.setEnabled(!ativo);
        ftfSenha.setEnabled(ativo);

        if (!ativo) {
            limpaFormulario();
        }
    }

    private void limpaFormulario() {
        funcionario = null;
        ftfNome.setValue("");
        ftfCpf.setValue("");
        ftfDataNascimento.setValue("");
    }

    private boolean validarFormulario() {
        if (ftfNome.getText().trim().length() < 2) {
            JOptionPane.showMessageDialog(this, "Nome inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfNome.requestFocus();
            return false;
        }
        if (ftfCpf.getText().trim().length() != 14) {
            JOptionPane.showMessageDialog(this, "CPF inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfCpf.requestFocus();
            return false;
        }
       if (ftfDataNascimento.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfDataNascimento.requestFocus();
            return false;
        }
        return true;
    }

    private void carregarGrade() {
        FuncionarioTableModel tm = (FuncionarioTableModel) tbGrade.getModel();
        try {
            tm.setDados(funcionarioDAO.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraFerramentas;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfDataNascimento;
    private javax.swing.JFormattedTextField ftfNivel;
    private javax.swing.JFormattedTextField ftfNome;
    private javax.swing.JTextField ftfSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbNome;
    private javax.swing.JPanel pnBarraFerramentas;
    private javax.swing.JPanel pnForm;
    private javax.swing.JScrollPane spGrade;
    private javax.swing.JTable tbGrade;
    // End of variables declaration//GEN-END:variables
}
