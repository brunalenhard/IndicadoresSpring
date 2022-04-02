package com.indicadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class PacienteService {


    @Autowired
    PacienteRepository pacienteRepository;


    public void start() {

        List<Paciente> pacientes = new ArrayList();
        exibeMenu();
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                adicionarPaciente(pacientes);
                break;
            case 2:
                exibeListaPacientes();
                break;
            case 3:
                buscaPorNome();
                break;
        }
    }

    private void buscaPorNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        List<Paciente> byNome = pacienteRepository.findByNome(nome);
        printPacientes(byNome);
    }

    private void adicionarPaciente(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = new Paciente();
        System.out.println("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        paciente.setNome(nome);

        System.out.println("Qual a forma de captação do cliente (INSTAGRAM, FACEBOOK, GOOGLE, INDICACAO");
        FormaCaptacao formaCaptacao = FormaCaptacao.valueOf(scanner.nextLine());
        paciente.setFormaCaptacao(formaCaptacao);

        System.out.println("O cliente fechou (VENDIDO ou PENDENTE)");
        ConclusaoVenda conclusaoVenda = ConclusaoVenda.valueOf(scanner.nextLine());
        paciente.setConclusaoVenda(conclusaoVenda);
        if (conclusaoVenda.equals(ConclusaoVenda.VENDIDO)) {
            setaValorCompra(paciente);
            setaFormaDePagamento(paciente);
            System.out.println("Cadastro concluído");
        } else {
            System.out.println("Cadastro concluído");
        }
        pacienteRepository.save(paciente);
    }

    private void exibeListaPacientes() {
        Iterable<Paciente> pacientes = pacienteRepository.findAll();
        printPacientes(pacientes);
    }

    private void printPacientes(Iterable<Paciente> pacientes) {
        pacientes.forEach(p -> {
            System.out.println(p.toString());
        });
    }


    private void exibeMenu() {
        System.out.println("MENU:");
        System.out.println("1. Adicionar novo cliente");
        System.out.println("2.Exibe lista de pacientes registrados");
        System.out.println("3.Busca paciente por nome");
    }

    private void setaValorCompra(Paciente paciente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o valor da compra");
        BigDecimal valorDaCompra = new BigDecimal(scanner.nextLine());
        paciente.setValor(valorDaCompra);
    }

    private void setaFormaDePagamento(Paciente paciente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual será a forma de pagamento (DINHEIRO, PIX, DEBITO, CREDITO");
        FormaDePagamento formaDePagamento = FormaDePagamento.valueOf(scanner.nextLine());
        paciente.setFormaDePagamento(formaDePagamento);
        System.out.println("Pagamento em "+ formaDePagamento.name() +" registrado.");

    }
}




