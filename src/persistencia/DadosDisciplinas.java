package persistencia;

import model.*;
import view.*;
import java.util.ArrayList;

public class DadosDisciplinas {
    private static ArrayList<Disciplina> disciplinas;
    
    static {
        disciplinas = (ArrayList<Disciplina>)Persist.recuperar("disciplinas.dat");
        if(disciplinas == null)
            disciplinas = new ArrayList<Disciplina>();
    }
    
    public static ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public static void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        DadosDisciplinas.disciplinas = disciplinas;
    }
    
    public static void cadastrar(Disciplina d){
        disciplinas.add(d);
        boolean r = Persist.gravar(disciplinas,"disciplinas.dat");
        if(r){
            System.out.println("Total de disciplinas inseridas:");
            System.out.println(disciplinas.size());
        }else
            System.out.println("Erro na gravação.");
    }
    
    public static void listar(){
        for(Disciplina objeto: disciplinas){
            VisaoDisciplina.mostrarDados(objeto);
        }
    }
    
    public static Disciplina buscar(int codigo){
        Disciplina d = null;
        for(Disciplina objeto: disciplinas){
            if(objeto.getCodigoDisciplina() == codigo)
                d = objeto;
            break;
        }
        return d;
    }
    
    public static boolean excluir(int codigo){
        Disciplina d = buscar(codigo);
        if(d != null){
            disciplinas.remove(d);
            return true;
        }else{
            return false;
        }
    }
}
