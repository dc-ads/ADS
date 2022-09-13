package main.ficharios;

import main.modelos.Aluno;

import java.util.Scanner;
import java.util.ArrayList;

public class FicharioAluno {
    private ArrayList<Aluno> alunos;
    private Scanner entrada;

    public FicharioAluno(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
        this.entrada = new Scanner(System.in);
    }

    // Getts e Setts
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void cadastrar() {
        String nome, telefone, cpf, email;

        System.out.println("\n ------------- CADASTRO ALUNO ------------- ");
        System.out.print("Nome: ");
        nome = entrada.nextLine();

        System.out.print("CPF: ");
        cpf = entrada.nextLine();

        System.out.print("E-mail: ");
        email = entrada.nextLine();
        
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
        
        Aluno aluno = new Aluno(nome, cpf, telefone, email);
        
        if (this.alunos.contains(aluno)){
            System.out.println("\n> Error: Não foi possivel cadastrar o aluno");
            System.out.println("> warning: Já existe um aluno com esse número de cpf cadastrado no sistem");
        } else {
            this.alunos.add(aluno);
            System.out.println("\n> Success: Aluno cadastrado com sucesso!");
        }
    }

    public void alterar() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        Aluno alunoaSerAlterado = this.alunos.stream()
            .filter(aluno -> aluno.getMatricula()
                .equals(matricula)
            ).findAny().orElse(null);

        if(alunoaSerAlterado != null) {
            System.out.printf("Nome: ");
            alunoaSerAlterado.setNome(entrada.nextLine());

            System.out.printf("Telefone: ");
            alunoaSerAlterado.setTelefone(entrada.nextLine());

            System.out.printf("Email: ");
            alunoaSerAlterado.setEmail(entrada.nextLine());

            System.out.printf("\n> Success: Dados do(a) aluno(a) %s, atualizado com sucesso!\n", alunoaSerAlterado.getNome());
        } else {
            System.out.println("> Error: Número de matricula não encontrado!");
        }
    }

    public void excluir() {
        System.out.print("Numero da matricula do aluno a ser excluido: ");
        String matricula = entrada.nextLine();

        Aluno alunoaSerAlterado = this.alunos.stream()
            .filter(aluno -> aluno.getMatricula()
                .equals(matricula)
       
            ).findAny().orElse(null);
        // A TRATAR: não permitir exclusão de alunos vinculados a turmas
        if(alunoaSerAlterado != null) {
            //this.consultar();
            System.out.print("Você realmente deseja excluir este aluno? (yes/no): ");
            String option = entrada.nextLine();

            switch(option) {
                case "y", "Y", "YES", "yes" -> {
                    if(this.alunos.remove(alunoaSerAlterado)) {
                        System.out.println("\n> Success: aluno(a) removido com sucesso!");
                    } else {
                        System.out.println("> warnin: houve algum erro ao remover o aluno!");
                        return;
                    }
                }
                case "n", "N", "NO", "no" -> { return; }
                default -> {
                    System.out.println("\n> Error: opção invalida!");
                }
            }
        }
    }

    public void consultar() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        Aluno alunoaSerAlterado = this.alunos.stream()
            .filter(aluno -> aluno.getMatricula()
                .equals(matricula)
            ).findAny().orElse(null);
        
        if(alunoaSerAlterado != null) {
            System.out.printf("\n[RELATÓRIO DO(A) ALUNO(A) %s]\n", alunoaSerAlterado.getNome().toUpperCase());
            System.out.println("------------------------------------------");
            System.out.printf("| Número de matricula: %s\n", alunoaSerAlterado.getMatricula());
            System.out.println("------------------------------------------");
            System.out.printf("| Telefone: %s\n", alunoaSerAlterado.getTelefone());
            System.out.println("------------------------------------------");
            System.out.printf("| E-mail: %s\n", alunoaSerAlterado.getEmail());
            System.out.println("------------------------------------------");
            System.out.printf("| Turma: \n");
            System.out.println("------------------------------------------");
            System.out.printf("| Disciplinas: \n");
            System.out.println("------------------------------------------");
        } else {
            System.out.println("\nError: Numero de matricula não encontrado! :(");
        }
    }

    public void relatorio() {
        System.out.println("\n[RELATÓRIO DE ALUNOS]");
        System.out.println("------------------------------------------");
        this.alunos.stream()
            .forEach(aluno -> {
                System.out.println(aluno);
                System.out.println("------------------------------------------");
        });
    }
}