package terrestres;

public class Cachorro extends AnimalAB {

    @Override
    public String comer() {
        super.qtdComida += 10;
        return super.comer();
    }

    @Override
    public String moverse() {
        super.qtdCaminhoPercorrido += 5;
        return super.moverse();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 8;
        return super.dormir();
    }
}
