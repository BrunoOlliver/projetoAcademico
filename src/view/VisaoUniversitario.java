package view;

import controller.*;
import java.util.Scanner;
import model.*;

public class VisaoUniversitario {
/*METODOS*/
    
    public static void lerDados(Universitario u) throws SetInvalido{
        Scanner s = new Scanner(System.in);
         
        System.out.print("Nome: ");
        while(!u.setNome(EntradaDeDados.lerString(s.next())));
       
        System.out.print("Matricula: ");
        while(!u.setMatricula(EntradaDeDados.lerString(s.next())));
        
        System.out.print("CPF: ");
        while(!u.setCpf(EntradaDeDados.lerString(s.next())));
        
    }
    
    public static void mostrarDados(Universitario u){
        System.out.println("Nome: "+u.getNome());
        System.out.println("Matricula: "+u.getMatricula());
        System.out.println("CPF: "+u.getCpf());
        
    }    
}
