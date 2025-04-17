package elastic.code.terrestres;

import elastic.code.AnimalAB;
import elastic.code.interfaces.AnimalF;

public class AnimalTerrestreAB extends AnimalAB {

    @Override
    public String comer() {
        return "";
    }

    @Override
    public String dormir() {
        return "";
    }

    protected Integer kmPercorridos;
    public String andar() {
        return "Andadndo...";
    }
}
