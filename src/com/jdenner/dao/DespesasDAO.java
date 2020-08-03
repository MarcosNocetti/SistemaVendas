package com.jdenner.dao;

import com.jdenner.to.Compra;
import com.jdenner.to.Despesas;
import com.jdenner.to.ItemCompra;
import com.jdenner.to.enums.Situacao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe de acesso a dados da desp
 *
 * @author Marcos Nocetti
 */
public class DespesasDAO implements IDAO<Despesas> {

    @Override
    public void inserir(Despesas desp) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBDESPESAS (NOME, DATAPAGAMENTO, VALOR, SITUACAO) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, desp.getNome());
        ps.setDate(2, new Date(desp.getData().getTime()));
        ps.setDouble(3, desp.getValor());
        ps.setInt(4, desp.getSituacao().getId());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        c.confirmar();
    }

    @Override
    public void alterar(Despesas desp) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBDESPESAS SET NOME=?, DATAPAGAMENTO=?, VALOR=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, desp.getNome());
        ps.setDate(2, new Date(desp.getData().getTime()));
        ps.setDouble(3, desp.getValor());
        ps.setInt(4, desp.getSituacao().getId());
        ps.setInt(5, desp.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Despesas desp) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBDESPESAS SET NOME=?, DATAPAGAMENTO=?, VALOR=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, desp.getNome());
        ps.setDate(2, new Date(desp.getData().getTime()));
        ps.setDouble(3, desp.getValor());
        ps.setInt(4, Situacao.CANCELADA.getId());
        ps.setInt(5, desp.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Despesas> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBDESPESAS ORDER BY DATAPAGAMENTO DESC";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaDespesas = new ArrayList();
        while (rs.next()) {
            Despesas despesas = new Despesas();
            despesas.setCodigo(rs.getInt("CODIGO"));
            despesas.setNome(rs.getString("NOME"));
            despesas.setData(rs.getDate("DATAPAGAMENTO"));
            despesas.setValor(rs.getDouble("VALOR"));
            despesas.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBDESPESAS WHERE CODIGO=?";
            PreparedStatement psItem = c.getConexao().prepareStatement(sqlItem);
            psItem.setInt(1, despesas.getCodigo());
            listaDespesas.add(despesas);
        }

        return listaDespesas;
    }

    @Override
    public Despesas recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBDESPESAS ORDER BY DATAPAGAMENTO DESC";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Despesas desp = new Despesas();
        if (rs.next()) {
            desp.setCodigo(rs.getInt("CODIGO"));
            desp.setNome(rs.getString("NOME"));
            desp.setData(rs.getDate("DATAPAGAMENTO"));
            desp.setValor(rs.getDouble("VALOR"));

            desp.setSituacao(rs.getInt("SITUACAO"));
        }

        return desp;
    }
}
