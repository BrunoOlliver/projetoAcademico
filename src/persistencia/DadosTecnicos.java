package persistencia;

import view.*;
import model.*;
import java.util.ArrayList;

public class DadosTecnicos extends DadosFuncionarios{
    private static ArrayList<TecnicoAdministrativo> tecnicos;
    
    static {
        tecnicos = (ArrayList<TecnicoAdministrativo>)Persist.recuperar("tecnicos.dat");
        if(tecnicos == null)
            tecnicos = new ArrayList<TecnicoAdministrativo>();
    }
    
    public static void setTecnicos(ArrayList<TecnicoAdministrativo> tecnicos) {
        DadosTecnicos.tecnicos = tecnicos;
    }
    
    public static void cadastrar(TecnicoAdministrativo t){
        tecnicos.add(t);
        boolean r = Persist.gravar(tecnicos, "tecnicos.dat");
        if(r == true){
            System.out.println("Total de tecnicos inseridos:");
            System.out.println(tecnicos.size());
        }else
            System.out.println("Erro na gravação.");
    }
    
    public static void listar(){
        for(TecnicoAdministrativo objeto: tecnicos){
            VisaoTecnicoAdministrativo.mostrarDados(objeto);
        }
    }
    
    public static TecnicoAdministrativo buscar(String nome){
        TecnicoAdministrativo t = null;
        for(Funcionario objeto: tecnicos){
            if(objeto.getNome().equals(nome))
                t = (TecnicoAdministrativo) objeto;
            break;
        }
        return t;
    }
    
    public static boolean excluir(String nome){
        TecnicoAdministrativo t = buscar(nome);
        if(t != null){
            tecnicos.remove(t);
            return true;
        }else{
            return false;
        }
    }

    public static ArrayList<TecnicoAdministrativo> getTecnicos() {
        return tecnicos;
    }
}
