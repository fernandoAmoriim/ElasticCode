public class Exercicio09 {
    public static void main(String[] args) {
        String resposta = "";
        System.out.println("Números: ");
        for (int i = 0; i <= 10; i++){
            resposta += Math.pow(i, 2) + " ";
            System.out.print(i + " ");
        }
        System.out.println("\nElevados ao quadrado :");
        System.out.println(resposta);
    }
}
