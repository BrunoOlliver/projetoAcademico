package persistencia;

import controller.FolhaPagamento;
import view.*;
import model.*;
import java.util.ArrayList;

public abstract class DadosFuncionarios {
    public static ArrayList<Funcionario> funcionarios;
    
    static{
        funcionarios = (ArrayList<Funcionario>)Persist.recuperar("funcionarios.dat");
        if(funcionarios == null)
            funcionarios = new ArrayList<Funcionario>();
    }
    
    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public static void cadastrar(Funcionario f){
        FolhaPagamento.somaFolha(funcionarios);
        funcionarios.add(f);
        boolean r = Persist.gravar(funcionarios, "funcionarios.dat");
        if(r){
            System.out.println("Total de funcionarios inseridos:");
            System.out.println(funcionarios.size());
        }else
            System.out.println("Erro de gravação.");
    }
    
    public static void listar(Funcionario obj1){
        for(Funcionario obj2: funcionarios){
            if(obj1.getClass().getName().equals(obj2.getClass().getName()))
                VisaoFuncionario.mostrarDados(obj2);
        }
    }
//    
//    public static void listar(){
//        for(Funcionario objeto: funcionarios){
//            VisaoFuncionario.mostrarDados(objeto);
//        }
//    }
    
    public static Funcionario buscar(String nome){
        Funcionario f = null;
        for(Funcionario objeto: funcionarios){
            if(objeto.getNome().equals(nome))
                f = objeto;
            break;
        }
        return f;
    }
    
    public static boolean excluir(String nome){
        Funcionario f = buscar(nome);
        if(f != null){
            funcionarios.remove(f);
            return true;
        }else{
            return false;
        }
    }
}
