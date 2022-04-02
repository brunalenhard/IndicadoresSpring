package com.indicadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PacienteDao {

    @Autowired
    Conexao conexao;


    public Paciente inserirPaciente(Paciente paciente) {
        try {
            String insertSql = "INSERT INTO paciente(nome, tipo_cliente, conclusao_venda, forma_captacao) VALUES (?,?,?,?)";
            Connection conexao= this.conexao.getConexao();
            PreparedStatement preparedStatement = preparedStatement = conexao.prepareStatement(insertSql);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getTipoDeCliente());
            preparedStatement.setString(3, paciente.getConclusaoVenda().name());
            preparedStatement.setString(4, paciente.getFormaCaptacao().name());
            preparedStatement.execute();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public List<Paciente> buscarTodos(){
        try {
            String insertSql = "SELECT * FROM paciente";
            Connection conexao= this.conexao.getConexao();
            List<Paciente> pacientes = new ArrayList<>();
            PreparedStatement preparedStatement = preparedStatement = conexao.prepareStatement(insertSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FormaDePagamento forma_de_pagamento = Optional.ofNullable(resultSet.getString("forma_pagamento")).map(FormaDePagamento::valueOf).orElse(null);
                FormaCaptacao forma_captacao = Optional.ofNullable(resultSet.getString("forma_captacao")).map(FormaCaptacao::valueOf).orElse(null);
                ConclusaoVenda conclusao_venda = Optional.ofNullable(resultSet.getString("conclusao_venda")).map(ConclusaoVenda::valueOf).orElse(null);
                pacientes.add(new Paciente(resultSet.getInt("id"), resultSet.getString("nome"),resultSet.getString("tipo_cliente"), resultSet.getBigDecimal("valor"), conclusao_venda, forma_captacao, forma_de_pagamento));
            }
            conexao.close();
            return pacientes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Paciente> buscarPaciente (){
        return null;
    }
}
