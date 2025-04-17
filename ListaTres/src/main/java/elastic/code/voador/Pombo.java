package elastic.code.voador;

public class Pombo extends AnimalVoadorAB{
    @Override
    String voar() {
        super.qtdCaminhoPercorrido += 20;
        return super.voar();
    }

    @Override
    public String comer() {
        super.qtdComida += 2;
        return super.comer();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 6;
        return super.dormir();
    }
}
