import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor da variável A:");
        var variavelA = scanner.nextLine();


        System.out.println("Digite o valor da variável B:");
        var variavelB = scanner.nextLine();

        System.out.println("A: " + variavelA + " B: " + variavelB);

        variavelA = variavelB;
        variavelB = variavelA;

        System.out.println("A: " + variavelA + " B: " + variavelB);
    }
}
