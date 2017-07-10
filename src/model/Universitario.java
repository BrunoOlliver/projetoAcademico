package model;
import controller.*;
import java.io.Serializable;

public abstract class Universitario implements Serializable{
    private String nome;
    private String matricula;
    private String cpf;
    
    //CONSTRUTOR ALUNO
    Universitario(){};
    
    Universitario(String nome, String matricula, String cpf) throws SetInvalido{};
    
    /*SETTERS*/
    
    public boolean setNome(String nomeAluno) throws SetInvalido{
        if (nomeAluno.length() > 0){
            this.nome = nomeAluno;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    public boolean setMatricula(String matricula) throws SetInvalido{
        if (matricula.length() > 0){
            this.matricula = matricula;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
            
        }
    }
    
    public boolean setCpf(String cpf) throws SetInvalido{
        if (EntradaDeDados.validaCPF(cpf)){
            this.cpf = cpf;
            return true;
        }else{
            //throw new SetInvalido();
            System.out.print("Digite novamente: ");
            return false;
        }
    }
    
    /*GETTERS*/
    
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTipo(){
        return this.getClass().getName();
    }
    
    

}
