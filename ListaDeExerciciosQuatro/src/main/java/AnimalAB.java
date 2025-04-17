public abstract class AnimalAB implements AnimalF {
    protected int qtdComida;
    protected int qtdCaminhoPercorrido;
    protected int qtdHorasDormidas;
    @Override
    public String comer() {
        return "snack snack snack";
    }

    @Override
    public String dormir() {
        return "Zzz";
    }
}
