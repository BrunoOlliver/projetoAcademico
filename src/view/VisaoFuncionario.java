package view;

import controller.*;
import model.*;
import java.util.Scanner;


public class VisaoFuncionario {
/*METODOS*/
    
    public static void lerDados(Funcionario f) throws SetInvalido{
        Scanner s = new Scanner(System.in);
        
        System.out.print("Nome: ");
        f.setNome(EntradaDeDados.lerString(s.next()));

        System.out.print("Endereco: ");
        f.setEndereco(EntradaDeDados.lerString(s.next()));

        System.out.print("Telefone: ");
        f.setTelefone(EntradaDeDados.lerString(s.next()));

        System.out.print("CPF: ");
        f.setCpf(EntradaDeDados.lerString(s.next()));

        System.out.print("CTPS: ");
        f.setCtps(EntradaDeDados.lerString(s.next()));

        System.out.print("Piso Salarial: ");
        f.setPisoSalarial(EntradaDeDados.lerDouble(s.nextDouble()));
        
        System.out.print("Salario: ");
        f.setSalario(EntradaDeDados.lerDouble(s.nextDouble()));
        
        System.out.print("Auxilio Transporte: ");
        f.setAuxTransporte(EntradaDeDados.lerDouble(s.nextDouble()));
        
        System.out.print("Auxilio Alimentacao: ");
        f.setAuxAlimentacao(EntradaDeDados.lerDouble(s.nextDouble()));
        
    }

    public static void mostrarDados(Funcionario f){
        System.out.println("\nNome: "+f.getNome());
        System.out.println("Endereco: "+f.getEndereco());
        System.out.println("Telefone: "+f.getTelefone());
        System.out.println("CPF: "+f.getCpf());
        System.out.println("CTPS: "+f.getCtps());
        System.out.println("Piso Salarial: "+f.getPisoSalarial());
        System.out.println("Salario: "+f.getSalario());
        System.out.println("Auxilio Transporte: "+f.getAuxTransporte());
        System.out.println("Auxilio Alimentacao: "+f.getAuxAlimentacao());
    }    
}
