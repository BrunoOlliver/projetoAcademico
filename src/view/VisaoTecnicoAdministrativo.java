package view;
import controller.*;
import java.util.Scanner;
import model.*;

public class VisaoTecnicoAdministrativo {
    
    public static void lerDados(TecnicoAdministrativo t) throws SetInvalido{
        Scanner s = new Scanner(System.in);
        
        System.out.println("Dados do Tecnico");
        VisaoFuncionario.lerDados(t);       //chama o metodo "lerDados" de funcionario
        
        System.out.print("Cargo: ");
        t.setCargo(EntradaDeDados.lerString(s.nextLine()));
        
        System.out.print("Departamento: ");
        t.setDepartamento(EntradaDeDados.lerString(s.nextLine()));
        
        System.out.println("Valor Hora Extra: ");
        t.setValorHoraExtra(EntradaDeDados.lerDouble(s.nextDouble()));
        
        System.out.println("Quantidade de Horas Extra: ");
        t.setQuantHoras(EntradaDeDados.lerDouble(s.nextDouble()));
    }

    public static void mostrarDados(TecnicoAdministrativo t){
        System.out.println("\n#====================================#");
        System.out.println("\t>>Dados do Tecnico<<");
        VisaoFuncionario.mostrarDados(t);
        System.out.println("Cargo:" +t.getCargo());
        System.out.println("Departamento do Tecnico: "+t.getDepartamento());
        System.out.println("Valor Hora Extra: "+t.getValorHoraExtra());
        System.out.println("Quantia de Horas: "+t.getQuantHoras());
        System.out.println("Calculo do Salario: "+t.calcSalario(t.getValorHoraExtra(),t.getQuantHoras()));
    }    
}
