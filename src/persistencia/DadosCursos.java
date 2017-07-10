package persistencia;

import model.*;
import view.*;
import java.util.ArrayList;


public class DadosCursos {
    private static ArrayList<Curso> cursos;
    
    static{
        cursos = (ArrayList<Curso>)Persist.recuperar("cursos.dat");
        if(cursos == null)
            cursos = new ArrayList<Curso>();
    }
    
    public static ArrayList<Curso> getCursos() {
        return cursos;
    }

    public static void setCursos(ArrayList<Curso> cursos) {
        DadosCursos.cursos = cursos;
    }
    
    public static void cadastrar(Curso c){
        cursos.add(c);
        boolean r = Persist.gravar(cursos, "cursos.dat");
        if(r){
            System.out.println("Total de cursos inseridos:");
            System.out.println(cursos.size());
        }else
            System.out.println("Erro na gravação.");
    }
    
    public static void listar(){
        for(Curso objeto: cursos){
            VisaoCurso.mostrarDados(objeto);
        }
    }
    
    public static Curso buscar(String nomeCurso){
        Curso c = null;
        for(Curso objeto: cursos){
            if(objeto.getNomeCurso().equals(nomeCurso))
                c = objeto;
            break;
        }
        return c;
    }
    
    public static boolean excluir(String nomeCurso){
        Curso c = buscar(nomeCurso);
        if(c != null){
            cursos.remove(c);
            return true;
        }else{
            return false;
        }
    }
}
