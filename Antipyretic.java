public class Antipyretic extends Medicine {
    Antipyretic(String name, Type type, Application application, int dosage) {
        super(name, type, application, dosage);
    }

    @Override
    public void medicate(TakeMedicine recipient) {
        recipient.temperatureCure(this);
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