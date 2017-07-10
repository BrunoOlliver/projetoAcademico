package model;

import controller.*;
import java.util.Scanner;
import java.io.Serializable;

public class Professor extends Funcionario implements Pesquisador, Serializable
{
    private Scanner s = new Scanner(System.in);
    private String titulacao;
    private String areaPesquisa;
    private static double valorHoraAula;
    private double valorDedicacaoExclusiva;
    private double retribTitulacao;
    
    
    //COSTRUTOR PROFESSOR
    public Professor(){};
    public Professor(String nome, String endereco, String telefone, String cpf, String ctps,
            double salario, double auxTransporte, double auxAlimentacao,
            String titulacao, String areaPesquisa, double valorDedicacaoExclusiva,
            double retribTitulacao) throws SetInvalido{
        super(nome,endereco, telefone, cpf, ctps, salario,
                auxTransporte, auxAlimentacao);
    };
    
    public static boolean setValorHoraAula(double hraAula){
        valorHoraAula = hraAula;
        return true;
    }
    
    public static double getValorHoraAula(){
        return valorHoraAula;
    } 
    
    public boolean setValorDedicacaoExclusiva(double valorDedicacaoExclusiva) {
        this.valorDedicacaoExclusiva = valorDedicacaoExclusiva;
        return true;
    }

    public boolean setRetribTitulacao(double retribTitulacao) {
        this.retribTitulacao = retribTitulacao;
        return true;
    }
    
    public boolean setTitulacao(String titulacao) throws SetInvalido{
        if (titulacao.length() > 0){
            this.titulacao = titulacao;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setAreaPesquisa(String areaPesquisa) throws SetInvalido{
        if (areaPesquisa.length() > 0){
           this.areaPesquisa = areaPesquisa;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }

    public String getTitulacao() {
        return titulacao;
    }

    public String getAreaPesquisa() {
        return areaPesquisa;
    }

    public double getValorDedicacaoExclusiva() {
        return valorDedicacaoExclusiva;
    }

    public double getRetribTitulacao() {
        return retribTitulacao;
    }
    
    @Override
    public String getNome(){
        return super.getNome();
    }
    
    @Override
    public String getTipo() {
        return this.getClass().getName();
    }
    
    @Override
    public double calcSalario() {
        return (getSalario() + getValorDedicacaoExclusiva() + getRetribTitulacao());
    }

    @Override
    public double calcSalario(double valorHoras, double quantHoras) {
        return (calcSalario() + (valorHoras * quantHoras));
    }    
    
}
