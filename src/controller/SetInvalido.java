package controller;

public class SetInvalido extends Exception{
    public SetInvalido(){
        super();
    }
    @Override
    public String toString(){
        return "Informação Inválida!";
    }
}
