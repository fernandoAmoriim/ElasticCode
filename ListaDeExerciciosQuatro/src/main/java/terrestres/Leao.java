package terrestres;

public class Leao extends AnimalAB {

    @Override
    public String comer() {
        super.qtdComida += 70;
        return super.comer();
    }

    @Override
    public String moverse() {
        super.qtdCaminhoPercorrido += 30;
        return super.moverse();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 10;
        return super.dormir();
    }
}
