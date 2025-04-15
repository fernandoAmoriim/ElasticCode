import java.util.Scanner;

public class Exercicio04
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a distância em milhas: ");
        Double milhas = scanner.nextDouble();

        Double quilometros = milhas * 1.609;

        System.out.println("Em quilômetros : " + quilometros);
    }
}
