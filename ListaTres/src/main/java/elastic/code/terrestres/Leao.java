package elastic.code.terrestres;

public class Leao extends AnimalTerrestreAB{

    @Override
    public String comer() {
        super.qtdComida += 70;
        return super.comer();
    }

    @Override
    public String andar() {
        super.qtdCaminhoPercorrido += 30;
        return super.andar();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 10;
        return super.dormir();
    }
}
