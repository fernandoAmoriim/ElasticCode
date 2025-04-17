package elastic.code.terrestres;

public class Elefante extends AnimalTerrestreAB{

    @Override
    public String comer() {
        super.qtdComida += 50;
        return super.comer();
    }

    @Override
    public String andar() {
        super.qtdCaminhoPercorrido += 10;
        return super.andar();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 8;
        return super.dormir();
    }
}
