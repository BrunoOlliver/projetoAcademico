package view;

import persistencia.ProjetoPesquisa;
import persistencia.DadosCursos;
import persistencia.DadosAlunos;
import persistencia.DadosDisciplinas;
import persistencia.DadosTecnicos;
import persistencia.DadosProfessores;
import persistencia.DadosAlunosPosGraduacao;
import persistencia.DadosFuncionarios;
import java.util.Scanner;
import controller.*;
import model.*;

public class Principal
{
    public static void main(String args[]) throws SetInvalido{
        //Instanciando Objetos de Base de Dados
        DadosAlunos alunos = new DadosAlunos();
        DadosAlunosPosGraduacao alunosPos = new DadosAlunosPosGraduacao();
        DadosCursos cursos = new DadosCursos();
        DadosDisciplinas disciplinas = new DadosDisciplinas();
        DadosFuncionarios professores = new DadosProfessores();
        DadosFuncionarios tecnicos = new DadosTecnicos();
        
        //Instanciando Objetos
        Aluno a;
        AlunoPosGraduacao ap;
        Funcionario p;
        Funcionario t;
        Curso c;
        Disciplina d;
        ProjetoPesquisa projeto = null;
        
        /*
        Temos Objetos de dois pacotes: BaseDeDados e GestaoAcademica
        Pegando como exemplo DadosAlunos e Alunos:
        
        >   Para DadosAlunos, "alunos" é um objeto lista de alunos
        e é atribuido a variavel "alunos".
        
        >   Para Alunos, "a" é um objeto do tipo aluno e é atribuido
        a variavel "a".
        */
        //Objeto de leitura
        Scanner s = new Scanner(System.in);
        int op = 0, sair = 0;
        do{
            while(op == 0){
                System.out.println("\nGestao Academica:\n");
                System.out.println("1 :Dados do Aluno.");
                System.out.println("2 :Dados do Aluno de Pos-Graduacao.");
                System.out.println("3 :Dados do Professor.");
                System.out.println("4 :Dados do Tecnico.");
                System.out.println("5 :Dados do Curso.");
                System.out.println("6 :Dados da Disciplina.");
                System.out.println("7 :Folha de Pagamento dos  Professores e Tecnicos.");
                System.out.println("8 :Projeto de Pesquisa.");
                System.out.println("9 :Sair");
                System.out.print("Opcao? ");
                op = s.nextInt();
                if(op == 9) sair = 1;
                if(op < 1 || op > 9) op = 0;
            }   
            switch(op){
                /*Faz leitura e mostra os dados do Aluno*/
                case 1:
                a = new Aluno();
                VisaoAluno.lerDados(a);
                alunos.cadastrar(a);
                alunos.listar();

                break;

                /*Faz leitura e mostra os dados do Aluno de Pos Graduacao*/
                case 2:
                ap = new AlunoPosGraduacao();
                VisaoAlunoPosGraduacao.lerDados(ap);
                alunosPos.cadastrar(ap);
                alunosPos.listar();
                break;

                /*Faz leitura e mostra os dados do Professor*/
                case 3:
                p = new Professor();
                VisaoProfessor.lerDados((Professor)p);
                professores.cadastrar(p);
                professores.listar(p);
                break;

                /*Faz leitura e mostra os dados do TecnicoAdministrativo*/
                case 4:
                t = new TecnicoAdministrativo();
                VisaoTecnicoAdministrativo.lerDados((TecnicoAdministrativo)t);
                tecnicos.cadastrar(t);
                tecnicos.listar(t);
                break;

                /*Faz leitura e mostra os dados do Curso*/
                case 5:
                c = new Curso();
                VisaoCurso.lerDados(c);
                cursos.cadastrar(c);
                cursos.listar();
                break;

                /*Faz leitura e mostra os dados das Disciplinas*/
                case 6:
                d = new Disciplina();
                VisaoDisciplina.lerDados(d);
                disciplinas.cadastrar(d);
                disciplinas.listar();
                break;

                case 7:
                FolhaPagamento.somaFolha(DadosProfessores.getProfessores());
                FolhaPagamento.somaFolha(DadosTecnicos.getTecnicos());
                System.out.println("\nTotal da folha de pagamento eh: "+FolhaPagamento.getTotalFolha());
                System.out.println("Total de encargos eh: "+FolhaPagamento.getTotalEncargos());
                break;
                
                case 8:
                System.out.println("\nNovo projeto de Pesquisa:");
                projeto.novaPesquisa();
                projeto.verPesquisa();
                break;
            }
            op=0;
        }while(sair == 0);
    }
}