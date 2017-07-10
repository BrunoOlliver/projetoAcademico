package model;
import controller.SetInvalido;
import java.io.Serializable;

public class Aluno extends Universitario implements Pesquisador, Serializable
{
    private Curso curso = new Curso();
    byte situacao;
    //CONSTRUTOR ALUNO
    public Aluno(){};
    /*"Curso" eh passado pelo parametro do construtor Aluno pois o Curso
    ja deve existir como instancia de aluno.*/
    public Aluno(String nome, String matricula, String cpf,
            String situacao, Curso curso) throws SetInvalido{
        super(nome,matricula,cpf);
    };

    /*SETTERS*/
    
    public boolean setSituacao(String c){
        switch (c) {
            case "M":
                this.situacao = 1;
                return true;
            case "T":
                this.situacao = 2;
                return true;
            case "D":
                this.situacao = 3;
                return true;
            default:
                System.out.print("Digite novamente: ");
                return false;
        }
    }
    
    public boolean setCurso(Curso curso)throws SetInvalido{
        if(curso == null)
            throw new SetInvalido();
        else{
            this.curso = getCurso();
            return true;
        }
    }
    
    /*GETTERS*/
    
    @Override
    public String getNome(){
        return super.getNome();
    }
    
    @Override
    public String getTipo() {
        return this.getClass().getName();
    }
    
    public byte getSituacao(){
        return situacao;
    }
    
    public Curso getCurso(){
        return curso;
    }  

}