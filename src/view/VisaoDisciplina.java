package view;
import controller.*;
import model.*;
import java.util.Scanner;

public class VisaoDisciplina {
    /*METODOS*/
    
    public static void lerDados(Disciplina d)throws SetInvalido{
        Scanner s = new Scanner(System.in);
        
        System.out.print("Codigo: ");
        d.setCodigoDisciplina(EntradaDeDados.lerInteiro(s.nextInt()));

        System.out.print("Disciplina: ");
        d.setNomeDisciplina(EntradaDeDados.lerString(s.next()));

        System.out.print("Carga horaria: ");
        d.setCargaHoraria(EntradaDeDados.lerInteiro(s.nextInt()));

        System.out.println("Dados do Professor");
        VisaoProfessor.lerDados(d.getProfessor());
    }

    public static  void mostrarDados(Disciplina d){
        System.out.println("\n#====================================#");
        System.out.println("\t>>Dados da Disciplina<<");
        System.out.print("\nCodigo da disciplina: "+d.getCodigoDisciplina());
        System.out.print("\nNome da disciplina: "+d.getNomeDisciplina());
        System.out.print("\nCarga horaria: "+d.getCargaHoraria());
        VisaoProfessor.mostrarDados(d.getProfessor());
    }
}
