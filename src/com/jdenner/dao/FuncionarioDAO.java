/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdenner.dao;
import com.jdenner.to.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author gabri
 */
public class FuncionarioDAO implements IDAO<Funcionario> {
    
    @Override
    public void inserir(Funcionario funcionario) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBfuncionario (nome, cpf, dataNascimento, senha, nivel) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCpf());
        ps.setString(3, funcionario.getDataNascimento());
        ps.setString(4, funcionario.getSenha());
        ps.setString(5, funcionario.getNivel());


        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Funcionario funcionario) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBfuncionario SET NOME=?, CPF=?, DATANASCIMENTO=?, senha=? WHERE idFuncionario=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCpf());
        ps.setString(3, funcionario.getDataNascimento());
        ps.setInt(4, funcionario.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Funcionario funcionario) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM TBfuncionario WHERE idFuncionario=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, funcionario.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Funcionario> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBfuncionario ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listafuncionarios = new ArrayList();
        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigo(rs.getInt("idFuncionario"));
            funcionario.setNome(rs.getString("NOME"));
            funcionario.setCpf(rs.getString("CPF"));
            funcionario.setDataNascimento(rs.getString("DATANASCIMENTO"));
            funcionario.setSenha(rs.getString("senha"));
            funcionario.setNivel(rs.getString("Nivel"));


            listafuncionarios.add(funcionario);
        }

        return listafuncionarios;
    }

    @Override
    public Funcionario recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBfuncionario WHERE idFuncionario=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Funcionario funcionario = new Funcionario();
        if (rs.next()) {
            funcionario.setCodigo(rs.getInt("idFuncionario"));
            funcionario.setNome(rs.getString("NOME"));
            funcionario.setCpf(rs.getString("CPF"));
            funcionario.setDataNascimento(rs.getString("DATANASCIMENTO"));
        }

        return funcionario;
    }
}
