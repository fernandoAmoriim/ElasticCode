import terrestres.Cachorro;
import terrestres.Elefante;

public class Main {
    public static void main(String[] args) {
        Elefante elefante = new Elefante();
        Cachorro cachorro = new Cachorro();

        elefante.comer();
        elefante.comer();

        System.out.println(elefante.qtdComida);
        System.out.println(cachorro.qtdComida);

        cachorro.comer();

        System.out.println(elefante.qtdComida);
        System.out.println(cachorro.qtdComida);
    }
}
