package view;

import model.*;
import controller.*;
import java.util.Scanner;

public class VisaoAlunoPosGraduacao {
/*METODOS*/
    
    public static void lerDados(AlunoPosGraduacao a) throws SetInvalido{
        Scanner s = new Scanner(System.in);
        String situacao;

        System.out.println("Dados do Aluno de Pos-Graduacao");
        VisaoUniversitario.lerDados(a);
        
        System.out.print("Situacao : ");
        situacao = s.nextLine();
        while(!a.setSituacao(situacao))situacao = s.nextLine();
                
        System.out.print("Graducao do Aluno: ");
        a.setGraduacao(EntradaDeDados.lerString(s.nextLine()));
        
        System.out.print("Instituicao do Aluno: ");
        a.setInstituicao(EntradaDeDados.lerString(s.nextLine()));
        
        System.out.print("Ano de Inicio da Pos Graduacao: ");
        a.setAnoDeInicio(EntradaDeDados.lerInteiro(s.nextInt()));
        
        System.out.print("Ano de Conclusao: ");
        a.setAnoDeConclusao(EntradaDeDados.lerInteiro(s.nextInt()));
        
        System.out.println("Dados do Curso");
        VisaoCurso.lerDados(a.getCurso());
    }

    public static void mostrarDados(AlunoPosGraduacao a){
        System.out.println("#====================================#");
        System.out.println("\t>>Dados do Aluno<<");
        VisaoUniversitario.mostrarDados(a);
        System.out.print("Instituicao do Aluno: "+a.getInstituicao());
        System.out.print("Ano de Inicio da Pos Graducao: "+a.getAnoDeInicio());
        System.out.print("Ano de Conclusao: "+a.getAnoDeConclusao());
        VisaoCurso.mostrarDados(a.getCurso());
    }    
}
