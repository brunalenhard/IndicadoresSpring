package com.indicadores;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Conexao {

    public Connection getConexao(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?user=root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
