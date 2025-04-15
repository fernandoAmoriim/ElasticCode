import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro valor: ");
        Integer valor1 = scanner.nextInt();

        System.out.println("Digite o segunda valor: ");
        Integer valor2 = scanner.nextInt();

        if (valor1 > valor2){
            System.out.println("O valor 1 é o maior: " + valor1);
        } else if (valor1 == valor2) {
            System.out.println("Os valores são iguais: " + valor1 + valor2);
        }else {
            System.out.println("O vallor 2 é o maior: " + valor2);
        }

    }
}
