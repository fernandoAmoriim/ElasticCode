package terrestres;

public abstract class AnimalTerrestreAB extends Ania {

    protected Integer kmPercorridos;
    @Override
    public String andar() {
        return super.moverse();
    }
}
