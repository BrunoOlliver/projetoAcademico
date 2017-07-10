package model;

import java.util.Scanner;
import java.io.Serializable;

public class TecnicoAdministrativo extends Funcionario implements Serializable
{
    Scanner s = new Scanner(System.in);
    private String cargo;
    private String departamento;
    private static double valorHoraExtra;
    private static double quantHoras;

    
    

    //CONSTRUTOR  TECNICO
    public TecnicoAdministrativo(){}; 
    public TecnicoAdministrativo(String nome, String endereco, String telefone, String cpf,
            String ctps,double salario, double auxTransporte, 
            double auxAlimentacao,String cargo, String departamento){
            super(nome,endereco, telefone, cpf, ctps, salario,
                    auxTransporte, auxAlimentacao);
    };

    /*SETTERS*/
    
    public static boolean setValorHoraExtra(double hraExtra){
        valorHoraExtra = hraExtra;
        return true;
    }
    
    public boolean setCargo(String cargo){
        if (cargo.length() > 0){
            this.cargo = cargo;
            return true;
        }else{
            System.out.println("Cargo invalido!");
            return false;
        }
    }
    
    public boolean setDepartamento(String departamento){
        if (departamento.length() > 0){
            this.departamento = departamento;
            return true;
        }else{
            System.out.println("Departamento invalido!");
            return false;
        }
    }
    
    public static void setQuantHoras(double quantHoras) {
        TecnicoAdministrativo.quantHoras = quantHoras;
    }
    /*GETTERS*/
    
    public static double getValorHoraExtra(){
        return valorHoraExtra;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public static double getQuantHoras() {
        return quantHoras;
    }

    public String getDepartamento() {
        return departamento;
    }

    /*METODOS*/
    
    @Override
    public double calcSalario(double valorHoras, double quantHoras) {
        return (calcSalario() + (valorHoras * quantHoras));
    }

    @Override
    public double calcSalario() {
        return (getSalario() +getAuxTransporte() + getAuxAlimentacao());
    }
    
    
}