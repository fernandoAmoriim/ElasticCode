package terrestres;

public class Elefante extends AnimalAB {

    @Override
    public String comer() {
        super.qtdComida += 50;
        return super.comer();
    }

    @Override
    public String moverse() {
        super.qtdCaminhoPercorrido += 10;
        return super.moverse();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 8;
        return super.dormir();
    }
}
