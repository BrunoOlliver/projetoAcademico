package model;
import controller.*;
import java.util.Scanner;
import java.io.Serializable;


public class Disciplina implements Serializable
{
    Scanner s = new Scanner(System.in);
    private int codigoDisciplina = 0;
    private String nomeDisciplina;
    private int cargaHoraria = 0;
    private Professor professor = new Professor();
    
    //COSNTRUTOR DISCIPLINA
    public Disciplina(){};
    /*"Curso" eh passado pelo parametro do construtor Disciplina pois o Curso
    ja deve existir na instanciacao da disciplina.*/
    public Disciplina(int codDisciplina, String nomeDisciplina, int cargaHoraria,
            Professor professor) throws SetInvalido{
    };

    /*SETTERS*/
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public boolean setCodigoDisciplina(int codigoDisciplina){
        if(codigoDisciplina != 0){
            this.codigoDisciplina = codigoDisciplina;
            return true;
        }else{
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setNomeDisciplina(String nomeDisciplina)throws SetInvalido{
        if(nomeDisciplina.length() > 0){
            this.nomeDisciplina = nomeDisciplina;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setCargaHoraria(int cargaHoraria){
        if(cargaHoraria != 0){
            this.cargaHoraria = cargaHoraria;
            return true;
        }else{
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    /*GETTERS*/
    
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    
    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }
    
    public Professor getProfessor(){
        return professor;
    }
    
    

}
