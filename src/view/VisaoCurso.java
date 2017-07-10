package view;

import controller.*;
import model.*;
import java.util.Scanner;


public class VisaoCurso {
    /*METODOS*/
    
    public static void lerDados(Curso c) throws SetInvalido{
        Scanner s = new Scanner(System.in);
        System.out.print("Codigo: ");
        c.setCodigo(EntradaDeDados.lerInteiro(s.nextInt()));
        
        System.out.print("Nome: ");
        c.setNomeCurso(EntradaDeDados.lerString(s.next()));
        
        System.out.print("Duracao: ");
        c.setDuracaoCurso(EntradaDeDados.lerInteiro(s.nextInt()));
        
        VisaoDisciplina.lerDados(c.getDisciplina());
    }
    
    public static void mostrarDados(Curso c){
        System.out.println("\n#====================================#");
        System.out.println("\t>>Dados do Curso<<");
        System.out.println("Codigo: "+c.getCodigo());
        System.out.println("Nome do Curso: "+c.getNomeCurso());
        System.out.println("Duracao do Curso: "+c.getDuracaoCurso());
        VisaoDisciplina.mostrarDados(c.getDisciplina());
    }    
}
