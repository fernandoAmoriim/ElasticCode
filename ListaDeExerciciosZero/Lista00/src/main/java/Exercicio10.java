public class Exercicio10 {
    public static void main(String[] args) {
        Integer var1 = 6;
        Integer var2 = 4;
        Integer var3 = var1 / var2;
        System.out.println(var3);

        Double var4 = 6.0;
        Double var5 = 4.0;
        Double var6 = 0.1 + var4 / var5;
        System.out.println(var6);

        System.out.println("Pelo fato do tipo Integer não possui casas decimais ele arredonda o valor decimal para cima ou para baixo. \n" +
                "Até 0.5 o valor é arredondado para baixo e apartir de 0.51 é arredondado para cima.");
    }
}
