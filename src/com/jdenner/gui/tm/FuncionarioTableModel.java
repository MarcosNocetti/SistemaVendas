package com.jdenner.gui.tm;

import com.jdenner.to.Funcionario;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Classe que define o modelo para tabela contendo dados do Funcionario
 *
 */
public class FuncionarioTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome", "CPF", "Nascimento","Senha","Nivel"};
    private List<Funcionario> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Funcionario funcionario = dados.get(l);
        switch (c) {
            case 0:
                return funcionario.getNome();
            case 1:
                return funcionario.getCpf();
            case 2:
                return funcionario.getDataNascimento();
            case 3:
                return funcionario.getSenha();                
            case 4:
                return funcionario.getNivel();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Funcionario> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Funcionario getRowValue(int l) {
        return dados.get(l);
    }
}
