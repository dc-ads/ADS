package main.ficharios;

import main.modelos.*;

import java.util.Scanner;
import java.util.ArrayList;

public class FicharioTurma {
    private Scanner entrada;

    private ArrayList<Turma> turmas;
    private ArrayList<Aluno> alunos;

    public FicharioTurma(
        ArrayList<Turma> turmas,
        ArrayList<Aluno> alunos
    ) {
        this.turmas = turmas;
        this.alunos = alunos;
        this.entrada = new Scanner(System.in);
    }

    public void cadastrar() {
        String nome;

        System.out.println("\n ------------- CADASTRO TURMA ------------- ");
        System.out.print("Nome: ");
        nome = entrada.nextLine();

        Turma turma = new Turma(nome);
        
        if (this.turmas.contains(turma)){
            System.out.println("\n> Error: Não foi possivel cadastrar a turma");
            System.out.println("> warning: Já existe uma turma com o mesmo código,\npor favor tente novamenete :)");
        } else {
            this.turmas.add(turma);
            System.out.println("\n> Success: Turma registrada com sucesso!");
            System.out.println("O Código gerado para a turma "+turma.getNome()+" e: "+turma.getCodigo());
        }
    }

    public void alterar() {
        System.out.print("Numero do código da turma: ");
        String codigo = entrada.nextLine();

        Turma turmaaSerAlterada = this.turmas.stream()
            .filter(turma -> turma.getCodigo()
                .equals(codigo)
            ).findAny().orElse(null);

        if(turmaaSerAlterada != null) {
            System.out.printf("Nome: ");
            System.out.printf("\n> Success: O nome da turma %s foi alterado para '%s'!\n", turmaaSerAlterada.getNome(), turmaaSerAlterada.setNome(entrada.nextLine()));
        } else {
            System.out.println("> Error: Número do código de turma não encontrado!");
        }
    }

    public void excluir() {
        System.out.print("Numero do código da turma: ");
        String codigo = entrada.nextLine();

        Turma turmaaSerExcluida = this.turmas.stream()
            .filter(turma -> turma.getCodigo()
                .equals(codigo)
            ).findAny().orElse(null);
       
        if(turmaaSerExcluida.getAlunos().size() != 0 && 
            turmaaSerExcluida.getProfs().size() != 0 && 
            turmaaSerExcluida != null
        ) {
            System.out.print("Você realmente deseja excluir esta turma? (yes/no): ");
            String option = entrada.nextLine();

            switch(option) {
                case "y", "Y", "YES", "yes" -> {
                    if(this.turmas.remove(turmaaSerExcluida)) {
                        System.out.println("\n> Success: turma removido com sucesso!");
                    }
                }
                case "n", "N", "NO", "no" -> { return; }
                default -> {
                    System.out.println("\n> Error: opção invalida!");
                }
            }
        } else {
            System.out.println("\n> Error: Houve um erro ao remover turma!");
            System.out.println("\t> warning: Talvez você esteja tentando excluir uma turma com alunos e/ou professores matriculados,\n\tdesvincule-os da turma antes de excluí-la!");
        }
    }

    public void consultar() {
        System.out.print("\nNumero do código da turma: ");
        String codigo = entrada.nextLine();

        Turma turmaaSerConsultada = this.turmas.stream()
            .filter(turma -> turma.getCodigo()
                .equals(codigo)
            ).findAny().orElse(null);
        
        if(turmaaSerConsultada != null) {
            System.out.printf("\n[RELATÓRIO DA TURMA '%s']\n", turmaaSerConsultada.getNome().toUpperCase());
            System.out.println("-------------------------------------------------------------------------");
            System.out.printf("| Nome: %s\t\t| Código: %s\n", turmaaSerConsultada.getNome(), turmaaSerConsultada.getCodigo());
            System.out.println("--- ALUNOS --------------------------------------------------------------");
            if(turmaaSerConsultada.getAlunos().size() != 0) {
                turmaaSerConsultada.getAlunos().stream()
                    .forEach(aluno -> System.out.printf("%s\t\t%s\t%s\t%s\n", aluno.getNome(), aluno.getMatricula(), aluno.getEmail(),  aluno.getTelefone()));
                System.out.println("-------------------------------------------------------------------------");
            } else {
                System.out.println("> Nenhum aluno matriculado nessa turma!");
            }

            System.out.println("\n--- PROFESSORES ---------------------------------------------------------");
            if(turmaaSerConsultada.getProfs().size() != 0) {
                turmaaSerConsultada.getProfs().stream()
                    .forEach(prof -> System.out.printf("%s\t\t%s\t%s\t%s\n", prof.getNome(), prof.getRegistro(), prof.getEmail(), prof.getTelefone()));
                System.out.println("-------------------------------------------------------------------------");
            } else {
                System.out.println("> Nenhum professor matriculado nessa turma!");
            }
        } else {
            System.out.println("\nError: Código não encontrado! :(");
        }
    }

    public void matricularAluno() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        System.out.print("Numero do código da turma: ");
        String codigo = entrada.nextLine();

        Aluno alunoaSerMatriculado = this.alunos.stream()
            .filter(aluno -> aluno.getMatricula()
                .equals(matricula)
            ).findAny().orElse(null);

        Turma turmaaSeMatricular = this.turmas.stream()
            .filter(turma -> turma.getCodigo()
                .equals(codigo)
            ).findAny().orElse(null);

        if((alunoaSerMatriculado != null) && (turmaaSeMatricular != null)) {
            if(turmaaSeMatricular.getAlunos().contains(alunoaSerMatriculado)) {
                System.out.println("\n> warning: Aluno(a) já está mtriculado(a) nessa turma!");
                return;
            } else if(alunoaSerMatriculado.getTurma() != null) {
                System.out.println("\n> warning: Este aluno(a) já está matriculado(a) na turma "+alunoaSerMatriculado.getTurma().getNome());
                return;
            } else {
                alunoaSerMatriculado.receberTurma(turmaaSeMatricular);
                System.out.println("\n> Sucess: aluno(a) "+alunoaSerMatriculado.getNome()+" matriculado(a) com suceso na turma "+turmaaSeMatricular.getNome());
            }
        } else {
            System.out.println("\n> Error: Numero de matricula do aluno e/ou código da turma não encontrado!");
        }
    }

    public void desmatricularAluno() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        System.out.print("Número do código da turma: ");
        String codigo = entrada.nextLine();

        Aluno alunoaSerMatriculado = this.alunos.stream()
            .filter(aluno -> aluno.getMatricula()
                .equals(matricula)
            ).findAny().orElse(null);

        Turma turmaaSeMatricular = this.turmas.stream()
        .filter(turma -> turma.getCodigo()
            .equals(codigo)
        ).findAny().orElse(null);

        if((alunoaSerMatriculado != null) && (turmaaSeMatricular != null)) {
            if(turmaaSeMatricular.getAlunos().contains(alunoaSerMatriculado)) {
                turmaaSeMatricular.getAlunos().remove(alunoaSerMatriculado);
                alunoaSerMatriculado.setTurma(null);
                System.out.println("\n> Sucess: Aluno(a) "+alunoaSerMatriculado.getNome()+" foi desmatriculado(a) com sucesso da turma "+turmaaSeMatricular.getNome());
            } else {
                System.out.println("\n> Warning: Este aluno não consta na lista de matriculados da turma!");
            }
        } else {
            System.out.println("\n> Error: Numero de matricula e/ou código da turma não encontrado!");
        }
    }

    public void relatorio() {
        System.out.println("\n[RELATÓRIO DE TURMAS]");
        System.out.println("------------------------------------------");
        this.turmas.stream()
            .forEach(turma -> {
                System.out.println(turma);
                System.out.println("------------------------------------------");
        });
    }
}