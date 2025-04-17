package elastic.code.terrestres;

public class Gato extends AnimalTerrestreAB{

    @Override
    public String comer() {
        super.qtdComida += 8;
        return super.comer();
    }

    @Override
    public String andar() {
        super.qtdCaminhoPercorrido += 10;
        return super.andar();
    }

    @Override
    public String dormir() {
        super.qtdHorasDormidas += 12;
        return super.dormir();
    }
}
