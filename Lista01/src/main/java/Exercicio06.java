public class Exercicio06 {
    public static void main(String[] args) {
        Integer produtoInt = 15;
        Float produtoFloat = 15.0F;
        for (int i = 17; i <= 30; i += 2){
                produtoInt *=  i;
                produtoFloat *= i;
        }
        System.out.println(produtoInt);
        System.out.println(produtoFloat);
    }
}
