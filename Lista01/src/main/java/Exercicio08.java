import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra: ");
        String palavra = scanner.nextLine();
        palavra = palavra.replace(" ", "");
        String palavraInvertida = "";
        for (int i = palavra.length() - 1; i >= 0; i--){
            palavraInvertida += palavra.charAt(i);
        }
        if (palavra.equalsIgnoreCase(palavraInvertida)){
            System.out.println("É palindromo!");
        }else {
            System.out.println("Não é palindromo.");
        }
        System.out.println(palavra);
        System.out.println(palavraInvertida);
    }
}
