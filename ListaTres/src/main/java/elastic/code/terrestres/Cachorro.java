package elastic.code.terrestres;

public class Cachorro extends AnimalTerrestreAB{

    @Override
    public String comer() {
        super.qtdComida += 10;
        return super.comer();
    }

    @Override
    public String andar() {
        super.qtdCaminhoPercorrido += 5;
        return super.andar();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 8;
        return super.dormir();
    }
}
