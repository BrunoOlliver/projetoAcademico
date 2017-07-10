package view;

import persistencia.DadosProfessores;
import controller.*;
import model.*;
import java.util.Scanner;

public class VisaoProfessor {
    public static void lerDados(Professor p) throws SetInvalido{
        Scanner s = new Scanner(System.in);
        VisaoFuncionario.lerDados(p);
        
        System.out.print("Titulacao: ");
        p.setTitulacao(EntradaDeDados.lerString(s.next()));
        
        System.out.print("Area de pesquisa: ");
        p.setAreaPesquisa(EntradaDeDados.lerString(s.next()));
        
        System.out.print("Valor de Dedicação Exclusiva: ");
        p.setValorDedicacaoExclusiva(EntradaDeDados.lerDouble(s.nextDouble()));
        
        System.out.print("Valor Hora Aula: ");
        p.setValorHoraAula(EntradaDeDados.lerDouble(s.nextDouble()));
        
        System.out.print("Valor de Retribuicao Titulacao: ");
        p.setRetribTitulacao(EntradaDeDados.lerDouble(s.nextDouble()));
       
    }
    
    public static void mostrarDados(Professor p){
        System.out.println("\n#====================================#");
        System.out.println("\t>>Dados do Professor<<");
        VisaoFuncionario.mostrarDados(p);
        System.out.println("Titulacao: "+p.getTitulacao());
        System.out.println("Area de Pesquisa: "+p.getAreaPesquisa());
        System.out.println("Valor Hora Aula: "+p.getValorHoraAula());
        System.out.println("Valor da Dedicação Exclusiva: "+p.getValorDedicacaoExclusiva());
        System.out.println("Calculo do Salario: "+p.calcSalario());
        FolhaPagamento.somaFolha(DadosProfessores.getProfessores());
    }
    
}
