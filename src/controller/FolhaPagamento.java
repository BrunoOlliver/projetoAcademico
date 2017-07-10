package controller;

import persistencia.DadosFuncionarios;
import view.*;
import model.*;
import java.util.ArrayList;

public abstract class FolhaPagamento extends DadosFuncionarios{
/*
    SomaFolha recebe um ArrayList de qualquer tipo que estenda de Funcionario,
    ou seja, ArrayList<? extends Funcionario>
    
    getClass(), getName() pega o nome da classe a qual o objeto pertence ao qual:
    getClass() retorna a classe do objeto.
    getName() retorna o nome da classe.
    Ex.: func.getClass().getName() retorna o nome da classe a qual o objeto func
    pertence,utilizado em codigo generico que aceita qualquer subtipo de Funcionario.
*/
    
    private static double totalFolha = 0;
    
    
    public static void somaFolha(ArrayList<? extends Funcionario> funcionarios){
        
        for(Funcionario func : funcionarios){
            totalFolha += func.calcSalario();
            System.out.println("\nNome:"+func.getNome()+"\nSalario: R$ "+func.getSalario()+"\nCategoria: "+func.getClass().getName());
        }
    }
    
    public static double calcIRRF(Funcionario f){
        if(f.calcSalario() >  3000)return f.calcSalario()*0.275;
        else if (f.calcSalario() > 1500)return f.calcSalario()*0.15;
        else return 0;
    }
    
    public static double calcINSS(Funcionario f){
        return f.calcSalario()-(f.calcSalario()*0.11);
    }
    
    public static void relatorioFolhaPagamento(ArrayList<? extends Funcionario> lista){
        for(Funcionario objeto : lista){
            System.out.println("\nRelatorio do funcionario:\n");
            VisaoFuncionario.mostrarDados(objeto);
            System.out.println("Salario Bruto: "+objeto.calcSalario());
            System.out.println("IRRF a ser pago: "+FolhaPagamento.calcIRRF(objeto));
            System.out.println("INSS a ser pago: "+FolhaPagamento.calcINSS(objeto));
            System.out.println("Salario Liquido: "+(objeto.calcSalario()
                                                    -FolhaPagamento.calcINSS(objeto)
                                                    -FolhaPagamento.calcIRRF(objeto)));
        }
    }
    
    public static double getTotalFolha(){
        return totalFolha;
    }
    
    public static double getTotalEncargos(){
        //total de encargos eh 33.78% sobre salario de cada funcionario
        return (totalFolha * 0.3378);
    }

}
