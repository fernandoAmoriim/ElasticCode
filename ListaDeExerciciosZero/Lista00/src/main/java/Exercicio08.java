import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro: ");
        Integer num = scanner.nextInt();

        if (num % 2 == 0){
            System.out.println("É par.");
        }else {
            System.out.println("É impar.");
        }
    }
}
