package model;

import controller.*;
import java.io.Serializable;

public abstract class Funcionario implements Serializable{
    
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private String ctps;
    private double salario;
    private double auxTransporte;
    private double auxAlimentacao;
    private static double pisoSalarial;
    private static double percentBonificacao;
    
    //CONSTRUTOR FUNCIONARIO
    public Funcionario(){};
    public Funcionario(String nome, String endereco, String telefone, String cpf, String ctps,
            double salario, double auxTransporte, double auxAlimentacao){
    };

    /*METODOS ABSTRATOS*/
    
    public abstract double calcSalario();
    
    public abstract double calcSalario(double valorHoras, double quantHoras);
    
    public double calculaBonificacao(){
        return (getSalario() *  getPercentBonificacao());
    }
    
    /*SETTERS*/
    //Setter recebe valor apenas entre 0 e 1
    public static boolean setPercentBonificacao(double percent) throws SetInvalido{
        if(percent > 0 && percent <  1){
            percentBonificacao = percent;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setNome(String nome){
        if (nome.length() > 0){
            this.nome = nome;
            return true;
        }else{
            System.out.println("Nome invalido!");
            return false;
        }
    }
    
    public boolean setEndereco(String endereco){
        if (nome.length() > 0){
            this.endereco = endereco;
            return true;
        }else{
            System.out.println("Endereco invalido!");
            return false;
        }
    }
    
    public boolean setTelefone(String telefone){
        if (nome.length() > 0){
            this.telefone = telefone;
            return true;
        }else{
            System.out.println("Telefone invalido!");
            return false;
        }
    }
    
    public boolean setCpf(String cpf){
        if (EntradaDeDados.validaCPF(cpf)){
            this.cpf = cpf;
            return true;
        }else{
            System.out.println("CPF invalido!\nCPF: ");
            return false;
        }
    }
    
    public boolean setCtps(String ctps){
        if (nome.length() > 0){
            this.ctps = ctps;
            return true;
        }else{
            System.out.println("CTPS invalido!");
            return false;
        }
    }
    
    //Utiliza PisoSalarial como condicao
    public boolean setSalario(double salario){
        if (salario > getPisoSalarial()){
            this.salario = salario;
            return true;
        }else{
            System.out.println("Salario invalido!");
            return false;
        }
    }
    
    public void setAuxTransporte(double auxTransporte) {
        this.auxTransporte = auxTransporte;
    }

    public void setAuxAlimentacao(double auxAlimentacao) {
        this.auxAlimentacao = auxAlimentacao;
    }
    
    public static boolean setPisoSalarial(double piso) throws SetInvalido{
        pisoSalarial = piso;
        return true;
    }
    
    /*GETTERS*/    
    public static double getPercentBonificacao(){
        return percentBonificacao;
    }
    
    public static double getPisoSalarial(){
        return pisoSalarial;
    }
    
    public double getAuxTransporte() {
        return auxTransporte;
    }

    public double getAuxAlimentacao() {
        return auxAlimentacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCtps() {
        return ctps;
    }

    public double getSalario() {
        return salario;
    }
    
    public String getNome() {
        return nome;
    }
    
    

}
