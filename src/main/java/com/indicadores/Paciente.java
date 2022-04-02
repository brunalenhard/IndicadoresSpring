package com.indicadores;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("paciente")
public class Paciente {
    @Id
    private Integer id;
    private String nome;
    //lembrar de mais pra frente adicionar data da compra
    @Column("tipo_cliente")
    private String tipoDeCliente;
    private BigDecimal valor;
    public ConclusaoVenda conclusaoVenda;
    public FormaCaptacao formaCaptacao;
    @Column("forma_pagamento")
    public FormaDePagamento formaDePagamento;

    public Paciente(Integer id, String nome, String tipoDeCliente, BigDecimal valor, ConclusaoVenda conclusaoVenda, FormaCaptacao formaCaptacao, FormaDePagamento formaDePagamento) {
        this.id = id;
        this.nome = nome;
        this.tipoDeCliente = tipoDeCliente;
        this.valor = valor;
        this.conclusaoVenda = conclusaoVenda;
        this.formaCaptacao = formaCaptacao;
        this.formaDePagamento = formaDePagamento;
    }

    public Paciente (){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ConclusaoVenda getConclusaoVenda() {
        return conclusaoVenda;
    }

    public void setConclusaoVenda(ConclusaoVenda conclusaoVenda) {
        this.conclusaoVenda = conclusaoVenda;
    }

    public FormaCaptacao getFormaCaptacao() {
        return formaCaptacao;
    }

    public void setFormaCaptacao(FormaCaptacao formaCaptacao) {
        this.formaCaptacao = formaCaptacao;
    }
    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", tipoDeCliente='" + tipoDeCliente + '\'' +
                ", valor=" + valor +
                ", conclusaoVenda=" + conclusaoVenda +
                ", formaCaptacao=" + formaCaptacao +
                ", formaDePagamento=" + formaDePagamento +
                '}';
    }
}
