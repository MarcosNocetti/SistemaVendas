package com.jdenner.to;



/**
 * Classe contendo os dados do Funcionario
 *
 * @author Juliano
 */
public class Funcionario {

;

    private int codigo;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String senha;
    private String nivel;


    public Funcionario() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = "";
        this.senha = "";
        this.nivel = "";

    }

    public Funcionario(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = "";
        this.senha = "";
        this.nivel = "";


    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Funcionario) {
            Funcionario c = (Funcionario) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
