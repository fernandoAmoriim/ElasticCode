package elastic.code;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new DataSource();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do aluno que deseja pesquisar: ");
        String nomeAluno = scanner.nextLine();
        System.out.println(ds.getDadosAlunoPorNome(nomeAluno));

        System.out.println("Digite a disciplina do professor que deseja pesquisar: ");
        String disciplinaProfessor = scanner.nextLine();
        System.out.println(ds.getDadosProfessorPorDisciplina(disciplinaProfessor));


    }
}