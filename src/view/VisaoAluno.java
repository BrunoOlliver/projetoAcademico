package view;

import model.*;
import controller.*;
import java.util.Scanner;

public class VisaoAluno {
    /*METODOS*/
    
    public static void lerDados(Aluno a) throws SetInvalido{
        Scanner s = new Scanner(System.in);
        String situacao;
        VisaoUniversitario.lerDados(a);
        
        System.out.print("Situacao : ");
        situacao = s.nextLine();
        while(!a.setSituacao(situacao))situacao = s.nextLine();
        
        System.out.println("Dados do Curso");
        VisaoCurso.lerDados(a.getCurso());
    }
    
    public static void mostrarDados(Aluno a){
        System.out.println("\n#====================================#");
        System.out.println("\t>>Dados do Aluno<<");
        VisaoUniversitario.mostrarDados(a);
        System.out.print("Situacao: ");
        switch(a.getSituacao()){
            case 1 :System.out.println("MATRICULADO");break;
            case 2 :System.out.println("TRANCADO");break;
            case 3 :System.out.println("DESLIGADO");break;
            default: break;
        }
        VisaoCurso.mostrarDados(a.getCurso());
    }
    
}
