import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o raio do circulo: ");
        Double raio = scanner.nextDouble();

        System.out.println("A área de circulo é: %.2f".formatted(Math.PI * Math.pow(raio, 2)));
    }
}
