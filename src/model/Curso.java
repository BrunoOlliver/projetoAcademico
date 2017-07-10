package model;
import controller.*;
import java.util.Scanner;
import java.io.Serializable;


public class Curso implements Serializable
{
    Scanner s = new Scanner(System.in);
    private int codigo = 0;
    private String nomeCurso;
    private int duracaoCurso = 0;
    private Disciplina disciplina = new Disciplina();
    
    //CONSTRUTOR CURSO
    public Curso(){};
    public Curso(int codigo, String nomeCurso, int duracaoCurso,
            Disciplina disciplina)throws SetInvalido{
    }
    
    /*SETTERS*/
    
    public boolean setCodigo(int cod) throws SetInvalido{
        if(cod != 0){
            this.codigo = cod;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setNomeCurso(String nomeCurso) throws SetInvalido{
        if(nomeCurso.length() > 0){
            this.nomeCurso = nomeCurso;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setDuracaoCurso(int duracaoCurso) throws SetInvalido{
        if(duracaoCurso != 0){
            this.duracaoCurso = duracaoCurso;
            return true;
        }else
            throw new SetInvalido();
    }

    public boolean setDisciplina(Disciplina disciplina) throws SetInvalido{
        if(disciplina.equals("")){
            this.disciplina = disciplina;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    /*GETTERS*/
    
    public Disciplina getDisciplina(){
        return disciplina;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getNomeCurso() {
        return nomeCurso;
    }
    
    public int getDuracaoCurso() {
        return duracaoCurso;
    }
    
   

}
