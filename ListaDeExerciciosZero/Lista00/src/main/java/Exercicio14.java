import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double resultado = 0.0;
        Integer contador = 0;

        while (contador < 50){
            System.out.println("Digite um numero: ");
            Integer num = scanner.nextInt();
            resultado += num;
        }
        System.out.println(resultado / 50);
    }
}
