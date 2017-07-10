package persistencia;

import controller.EntradaDeDados;
import controller.SetInvalido;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Iterator;

public class ProjetoPesquisa {
    private String nome;
    private String tipo;
    private int codigo;
    private String titulo;
    private Date dataInicio;
    private Date dataFim;
    private Pesquisador pesquisador;
    private static ArrayList<Pesquisador> equipe;
    
    static{
        equipe = (ArrayList<Pesquisador>)Persist.recuperar("equipe.dat");
        if(equipe == null)
            equipe = new ArrayList<Pesquisador>();
    }
    
    ProjetoPesquisa(String nome, String tipo, int cod, String titulo, 
            Date dataI, Date dataF,ArrayList<Pesquisador> equipe){
    }
    /**Metodo Adicionar Pesquisador
     * procura um Pesquisador dentro da lista de Equipes
     * se houver um Professor ou Aluno ainda nao adicionado
     * ele sera adicionado.
     */
    public void adicionarPesquisador(){
        Scanner s = new Scanner(System.in);
        String obj1, obj2;
        
        System.out.println("Nome: ");
        obj1 = s.next();
        
        System.out.println("Tipo: ");
        obj2 = s.next();
        
        for(Pesquisador obj : getEquipe()){
            if(obj.getNome().equals(obj1) && obj.getTipo().equals(obj2)){
                System.out.println("Pesquisador ja adicionado.");
                break;
            }else{
                setPesquisador(obj);
                getEquipe().add(getPesquisador());
                boolean r = Persist.gravar(equipe,"equipe.dat");
                if(r)
                    System.out.println("Pesquisador adicionado.");
                else
                    System.out.println("Erro na gravação.");
            }
        }
        
    }
    
    public static void listarPesquisadores(){
        for (Iterator<Pesquisador> it = equipe.iterator(); it.hasNext();) {
            Pesquisador objeto = it.next();
            System.out.println("Nome: "+objeto.getNome());
            System.out.println("Tipo: "+objeto.getTipo());
        }
    }
    
    public void novaPesquisa() throws SetInvalido{
        Scanner s = new Scanner(System.in);
        
        System.out.print("Codigo: ");
        setCodigo(EntradaDeDados.lerInteiro(s.nextInt()));
        
        System.out.print("Titulo: ");
        setTitulo(s.next());
        
        System.out.print("Data de Inicio: ");
        setDataInicio(EntradaDeDados.lerData(s.next()));
        
        System.out.print("Data de Fim: ");
        setDataFim(EntradaDeDados.lerData(s.next()));
        
        System.out.println("Adicionar Pesquisador:");
        adicionarPesquisador();
        
    }
    
    public void verPesquisa(){
        System.out.println("Pesquisadores.");
        ProjetoPesquisa.listarPesquisadores();
        System.out.println("Codigo: "+getCodigo());
        System.out.println("Titulo: "+getTitulo());
        System.out.println("Data Inicio: "+getDataInicio());
        System.out.println("Data Fim: "+getDataFim());
    };
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public ArrayList<Pesquisador> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<Pesquisador> equipe) {
        this.equipe = equipe;
    }

    public Pesquisador getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(Pesquisador pesquisador) {
        this.pesquisador = pesquisador;
    }
    
}
