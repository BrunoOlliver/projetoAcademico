package persistencia;

import view.*;
import model.*;
import java.util.ArrayList;

public class DadosProfessores extends DadosFuncionarios{
    
    private static ArrayList<Professor> professores;
    
    static{
        professores = (ArrayList<Professor>)Persist.recuperar("professores.dat");
        if(professores == null)
            professores = new ArrayList<Professor>();
    }
    
    public static void cadastrar(Professor p){
        professores.add(p);
        boolean r = Persist.gravar(professores, "professores.dat");
        if(r == true){
            System.out.println("Total de professores inseridos:");
            System.out.println(professores.size());
        }else
            System.out.println("Erro na gravação.");
    }
    
    public static void listar(){
        for(Professor objeto: professores){
            VisaoProfessor.mostrarDados(objeto);
        }
    }
    
    public static Professor buscar(String nome){
        Professor p = null;
        for(Funcionario objeto: professores){
            if(objeto.getNome().equals(nome))
                p = (Professor) objeto;
            break;
        }
        return p;
    }
    
    public static boolean excluir(String nome){
        Professor p = buscar(nome);
        if(p != null){
            professores.remove(p);
            return true;
        }else{
            return false;
        }
    }

    public static ArrayList<Professor> getProfessores() {
        return professores;
    }
}
