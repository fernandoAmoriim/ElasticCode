import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero para dia da seman: ");
        Integer diaNum = scanner.nextInt();

        String[] diaExtenso = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        switch (diaNum){
            case 1 -> System.out.println(diaExtenso[0]);
            case 2 -> System.out.println(diaExtenso[1]);
            case 3 -> System.out.println(diaExtenso[2]);
            case 4 -> System.out.println(diaExtenso[3]);
            case 5 -> System.out.println(diaExtenso[4]);
            case 6 -> System.out.println(diaExtenso[5]);
            case 7 -> System.out.println(diaExtenso[6]);
        }

    }
}
