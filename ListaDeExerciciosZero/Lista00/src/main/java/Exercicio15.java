import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double resultado = 0.0;
        Integer contador = 0;

        do {
            System.out.println("Digite um numero: ");
            Integer num = scanner.nextInt();
            resultado += num;
        }while (contador < 50);

    }
}
