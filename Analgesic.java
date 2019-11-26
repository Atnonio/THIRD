public class Analgesic extends Medicine {
    Analgesic(String name, Type type, Application application, int dosage) {
        super(name, type, application, dosage);
    }

    public void medicate(TakeMedicine recipient) {
        recipient.painCure(this);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}