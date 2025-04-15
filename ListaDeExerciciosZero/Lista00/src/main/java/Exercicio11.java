import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o códig do produto: ");
        Integer codigo = scanner.nextInt();

        if (codigo == 001) System.out.println("Parafuso");
        else if(codigo == 002) System.out.println("Porca");
        else if (codigo == 003) System.out.println("Prego");
        else System.out.println("Diversos");

    }
}
