import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int continuar = 0;

        List<Integer> quilometros = new ArrayList<>();
        List<Integer> gasolina = new ArrayList<>();

        Integer contador = 0;

        while (continuar != 1){
            contador++;
            System.out.println("Digite os quilômetros dirigidos do %d tanque: ".formatted(contador));
            quilometros.add(scanner.nextInt());

            System.out.println("Digite a galosina consumida do %d tanque: ".formatted(contador));
            gasolina.add(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Deseja inserir um novo tanque? (0: continuar. 1: sair)");
            continuar = scanner.nextInt();
        }
        Float mediaKmRodados = Float.valueOf(gasolina.stream().mapToInt(Integer::intValue).sum()) / Float.valueOf(quilometros.stream().mapToInt(Integer::intValue).sum());

        for (int i = 0; i < quilometros.size(); i++) {
            System.out.println("Litro por quilômetro por tanque: " + Float.valueOf(gasolina.get(i)) / Float.valueOf(quilometros.get(i)));
        }

        System.out.println("Média Km por Litro: " + mediaKmRodados);

        System.out.println("Litros consumidos: " + gasolina.stream().mapToInt(Integer::intValue).sum());

        System.out.println("Quilometros consumidos: " + quilometros.stream().mapToInt(Integer::intValue).sum());
    }
}
