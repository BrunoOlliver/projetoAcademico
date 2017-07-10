package persistencia;
import model.*;
import java.util.ArrayList;
import view.VisaoAlunoPosGraduacao;

public class DadosAlunosPosGraduacao {
    private static ArrayList<AlunoPosGraduacao> alunosPos;
    
    static{
        alunosPos = (ArrayList<AlunoPosGraduacao>)Persist.recuperar("alunos_pos_graduacao.dat");
        if(alunosPos == null)
            alunosPos = new ArrayList<AlunoPosGraduacao>();
    }

    public static ArrayList<AlunoPosGraduacao> getAlunosPos() {
        return alunosPos;
    }

    public static void setAlunosPos(ArrayList<AlunoPosGraduacao> alunosPos) {
        DadosAlunosPosGraduacao.alunosPos = alunosPos;
    }
    
    public static void cadastrar(AlunoPosGraduacao a){
        alunosPos.add(a);
        boolean r = Persist.gravar(alunosPos, "alunos_por_graduacao.dat");
        if(r){
            System.out.println("Total de alunos inseridos:");
            System.out.println(alunosPos.size());
        }else
            System.out.println("Erro na gravação.");
    }
    
    public static void listar(){
        for(AlunoPosGraduacao objeto: alunosPos){
            VisaoAlunoPosGraduacao.mostrarDados(objeto);
        }
    }
    
    public static AlunoPosGraduacao buscar(String matricula){
        AlunoPosGraduacao a = null;
        for(AlunoPosGraduacao objeto: alunosPos){
            if(objeto.getMatricula().equals(matricula))
                a = objeto;
            break;
        }
        return a;
    }
    
    public static boolean excluir(String matricula){
        AlunoPosGraduacao a = buscar(matricula);
        if(a != null){
            alunosPos.remove(a);
            return true;
        }else{
            return false;
        }
    }
}
