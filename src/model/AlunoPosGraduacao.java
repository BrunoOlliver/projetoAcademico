package model;
import controller.*;
import java.io.Serializable;


public class AlunoPosGraduacao extends Universitario implements Serializable
{
    Curso curso = new Curso();
    private String graduacao;
    private String instituicao;
    private int anoDeInicio;
    private int anoDeConclusao;
    byte situacao;
    
    //CONSTRUTOR ALUNOPOS
    public AlunoPosGraduacao(){};
    public AlunoPosGraduacao (String nome, String matricula,  String cpf,
            String situacao, String graduacao, String instituicao,
            int anoDeInicio,int anoDeConclusao,Curso curso) throws SetInvalido{
        super(nome,matricula,cpf);
    }
    
    /*SETTERS*/
    public boolean setGraduacao(String graduacao)throws SetInvalido{
        if (graduacao.length() > 0){
            this.graduacao = graduacao;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setInstituicao(String instituicao)throws SetInvalido{
        if (instituicao.length() > 0){
            this.instituicao = instituicao;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setAnoDeInicio(int anoDeInicio)throws SetInvalido{
        if (anoDeInicio != 0){
            this.anoDeInicio = anoDeInicio;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setAnoDeConclusao(int anoDeConclusao)throws SetInvalido{
        if (anoDeConclusao != 0){
            this.anoDeConclusao = anoDeConclusao;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
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
                return false;
        }
    }
    
    public boolean setCurso(Curso curso)throws SetInvalido{
        if(curso.equals(""))
            throw new SetInvalido();
        else{
            this.curso = getCurso();
            return true;
        }
    }
    
    /*GETTERS*/
    
    public byte getSituacao(){
        return situacao;
    }

    public Curso getCurso(){
        return curso;
    }
    
    public String getGraduacao() {
        return graduacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public int getAnoDeInicio() {
        return anoDeInicio;
    }

    public int getAnoDeConclusao() {
        return anoDeConclusao;
    }
    
}
