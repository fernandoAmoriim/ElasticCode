import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva uma frase: ");
        String frase = scanner.nextLine();

        int vogais = 0;
        int consoantes = 0;
        int emBranco = 0;
        for (int i = 0; i < frase.length(); i++){
            String letraDaVez = String.valueOf(frase.charAt(i));
            if (letraDaVez.equalsIgnoreCase("a") || letraDaVez.equalsIgnoreCase("e") ||
                    letraDaVez.equalsIgnoreCase("i") || letraDaVez.equalsIgnoreCase("o") || letraDaVez.equalsIgnoreCase("u") ){
            vogais++;
            }else if (letraDaVez.equals(" ")){
                emBranco++;
            }else {
                consoantes++;
            }
        }
        System.out.println("Vogais: %d Consoantes: %d Espaços em Branco: %d".formatted(vogais, consoantes, emBranco));
    }
}
