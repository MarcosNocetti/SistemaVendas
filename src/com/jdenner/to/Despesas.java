package com.jdenner.to;

import com.jdenner.to.enums.Situacao;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 * Classe contendo os dados do fornecedor
 *
 * @author Juliano
 */
public class Despesas {

    public Despesas() {
        this.codigo = 0;
        this.nome = "";
        this.data = new Date();
        this.valor = 0.0;
    }


    public Despesas(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.data = new Date();
        this.valor = 0.0;
    }

    private int codigo;
    private String nome;
    private Date data;
    private Double valor;
    private Situacao situacao;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

 


    
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public void setSituacao(int situacao) {
        if (situacao == Situacao.ABERTA.getId()) {
            setSituacao(Situacao.ABERTA);
        } else if (situacao == Situacao.FINALIZADA.getId()) {
            setSituacao(Situacao.FINALIZADA);
        } else if (situacao == Situacao.CANCELADA.getId()) {
            setSituacao(Situacao.CANCELADA);
        }
    }

    

    
}
