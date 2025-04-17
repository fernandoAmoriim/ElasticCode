package marinho;

public class Peixe extends AnimalMarinhoAB {
    @Override
    String nadar() {
        super.qtdCaminhoPercorrido += 10;
        return super.nadar();
    }

    @Override
    public String comer() {
        super.qtdComida += 2;
        return super.comer();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 1;
        return super.dormir();
    }
}
