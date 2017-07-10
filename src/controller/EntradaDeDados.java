package controller;
import controller.*;
import model.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public abstract class EntradaDeDados{
    private static Date data;
    private static int valorInt;
    private static double valorDouble;
    private static String valorString;
    private static final int[] pesoCPF = {11,10,9,8,7,6,5,4,3,2};
    static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    
    /*SETTERS*/
    
    public static boolean setValorInt(int valor){
        valorInt = valor;
        return true;
    }
    
    public static void setData(Date data) {
        EntradaDeDados.data = data;
    }
    
    public static boolean setValorDouble(double valor){
        valorDouble = valor;
        return true;
    }
    
    public static void setValorString(String aValorString) {
        valorString = aValorString;
    }

    /*GETTERS*/
    
    public static Date getData() {
        return data;
    }

    public static int[] getPesoCPF() {
        return pesoCPF;
    }
    
    public static int getValorInt(){
        return valorInt;
    }    
    
    public static double getValorDouble(){
        return valorDouble;
    }
    
    public static String getValorString() {
        return valorString;
    }

    
    /*METODOS*/
    
    //Faz leitura de uma String, converte em formato Date e retorna Date
    public static Date lerData(String txt) throws SetInvalido{
        while(true){
            try{
                setValorString(txt);
                setData(EntradaDeDados.formatDate.parse(EntradaDeDados.getValorString()));
                break;
            }catch(ParseException e){
                System.out.println("Erro: "+e.toString());
                System.out.println("Digite novamente: ");
            }
        }
        return EntradaDeDados.getData();
    }
    
    public static void verData(Date data){
        System.out.println(EntradaDeDados.formatDate.format(data));
    }
    
    public static int lerInteiro(int dado){
        while(true){
            try{
                setValorInt(dado);
                System.out.println("OK!");
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Erro: "+e.toString());
                System.out.println("Digite novamente.");
            }
        }
        return getValorInt();
        
    }
    
    public static double lerDouble(double dado){
        while(true){
            try{
                setValorDouble(dado);
                System.out.println("OK!");
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Erro: "+e.toString());
                System.out.println("Digite novamente.");
            }
        }
        return getValorDouble();
    }
    
    public static String lerString(String dado){
        while(true){
            try{
                setValorString(dado);
                System.out.println("OK!");
                break;
            }catch(NullPointerException e){
                System.out.println("Erro: "+e.toString());
                System.out.println("Digite novamente.");
            }
        }
        return getValorString();
    }
    
    private static int calcularDigito(String str, int[] peso) {
       int soma = 0;
       for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
          digito = Integer.parseInt(str.substring(indice,indice+1));
          soma += digito*peso[peso.length-str.length()+indice];
       }
       soma = 11 - soma % 11;
       return soma > 9 ? 0 : soma;
    }

    public static boolean validaCPF(String cpf) {
       if ((cpf==null) || (cpf.length()!=11)) return false;

       Integer digito1 = calcularDigito(cpf.substring(0,9), getPesoCPF());
       Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, getPesoCPF());
       return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }
    
}
