import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        Double num = scanner.nextDouble();

        System.out.println("Numeros primos: ");
        for (double i = num; i > 1; i--){
            if ((i == 3 || i == 5) || (i % 2 != 0 && i % 3 != 0 && i % 5 != 0)){
                System.out.println(i);
            }
        }

    }
}
