package persistencia;

import model.*;
import view.*;
import java.util.ArrayList;

public class DadosAlunos {
    private static ArrayList<Aluno> alunos;
    
    static{
         alunos = (ArrayList<Aluno>)Persist.recuperar("alunos.dat");
         if(alunos == null)
             alunos = new ArrayList<Aluno>();
    }
    
    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public static void setAlunos(ArrayList<Aluno> aluno) {
        DadosAlunos.alunos = aluno;
    }
    
    public static void cadastrar(Aluno a){
        alunos.add(a);
        boolean r = Persist.gravar(alunos, "alunos.dat");
        if(r == true){
            System.out.println("Total de alunos inseridos:");
            System.out.println(alunos.size());
        }else
            System.out.println("Erro na gravação.");
    }
    
    public static void listar(){
        for(Aluno objeto: alunos){
            VisaoAluno.mostrarDados(objeto);
        }
    }
    
    public static Aluno buscar(String matricula){
        Aluno a = null;
        for(Aluno objeto: alunos){
            if(objeto.getMatricula().equals(matricula))
                a = objeto;
            break;
        }
        return a;
    }
    
    public static boolean excluir(String matricula){
        Aluno a = buscar(matricula);
        if(a != null){
            alunos.remove(a);
            return true;
        }else{
            return false;
        }
    }
}
