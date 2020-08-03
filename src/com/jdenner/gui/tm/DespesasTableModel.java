package com.jdenner.gui.tm;

import com.jdenner.to.Despesas;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que define o modelo para tabela contendo dados da compra
 *
 * @author Juliano
 */
public class DespesasTableModel extends AbstractTableModel {

    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private String colunas[] = {"Nome", "Data", "Valor", "Situação"};
    private List<Despesas> dados;

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
        Despesas desp = dados.get(l);
        switch (c) {
            case 0:
                return desp.getNome();
            case 1:
                return SDF.format(desp.getData());
            case 2:
                return NFC.format(desp.getValor());
            case 3:
                return desp.getSituacao();
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

    public void setDados(List<Despesas> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Despesas getRowValue(int l) {
        return dados.get(l);
    }
}
