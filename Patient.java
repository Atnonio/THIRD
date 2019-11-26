public class Patient extends Character implements Ail, TakeMedicine {
    private boolean statement;
    private int temperature;
    private int inflammation;
    private int pain;
    private int vita;
    private Prescription prescription;


    Patient(String name, boolean statement, int temperature, int inflammation, int pain, int vita) {
        super(name);
        this.statement = statement;
        this.temperature = temperature;
        this.inflammation = inflammation;
        this.pain = pain;
        this.vita = vita;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean visit(Treat doctor) {
        this.prescription = doctor.checkup(this);
        if (prescription != null) {
            return false;//if needs treatment
        }
        return true;//if is healthy
    }

    @Override
    public Anamnesis symptoms() {
        return new Anamnesis(temperature, inflammation, pain, vita);
    }

    @Override
    public void setStatement(boolean statement) {
        if (statement == true) {
        }
        this.statement = statement;
    }

    public boolean isStatement() {
        return statement;
    }

    @Override
    public void takeMedicines() {
        Medicine[] medicines = prescription.getMedicines();
        while (prescription.getProgress() < prescription.getSpell()) {
            for (int i = 0; i < medicines.length; i++) {
                medicines[i].medicate(this);
            }
            prescription.incrementProgress();
            System.out.println(prescription.getProgress()+" день.");
        }
    }

    public void vitaCure(Vitamin vitamin) {
        System.out.print(this.getName() + " принимает ");
        System.out.print(vitamin.getName() + " ");
        switch (vitamin.getApplication()) {
            case INGEST:
                System.out.println("внутрь.");
                break;
            case INTRAMUSCULAR:
                System.out.println("внутримышечно.");
                break;
            case EXTERNAL:
                System.out.println("наружно.");
                break;
        }
        if (this.vita < 100) {
            this.vita += vitamin.getDosage();
        }
        if (this.vita > 100) {
            this.vita = 100;
        }
    }

    @Override
    public void inflammationCure(Antibiotic antibiotic) {
        System.out.print(this.getName() + " принимает ");
        System.out.print(antibiotic.getName() + " ");
        switch (antibiotic.getApplication()) {
            case INGEST:
                System.out.println("внутрь.");
                break;
            case INTRAMUSCULAR:
                System.out.println("внутримышечно.");
                break;
            case EXTERNAL:
                System.out.println("наружно.");
                break;
        }
        if (this.inflammation < 100) {
            this.inflammation += antibiotic.getDosage();
        }
        if (this.inflammation > 100) {
            this.inflammation = 100;
        }
    }

    @Override
    public void temperatureCure(Antipyretic antipyretic) {
        System.out.print(this.getName() + " принимает ");
        System.out.print(antipyretic.getName() + " ");
        switch (antipyretic.getApplication()) {
            case INGEST:
                System.out.println("внутрь.");
                break;
            case INTRAMUSCULAR:
                System.out.println("внутримышечно.");
                break;
            case EXTERNAL:
                System.out.println("наружно.");
                break;
        }
        if (this.temperature < 100) {
            this.temperature += antipyretic.getDosage();
        }
        if (this.temperature > 100) {
            this.temperature = 100;
        }
    }

    @Override
    public void painCure(Analgesic analgesic) {
        System.out.print(this.getName() + " принимает ");
        System.out.print(analgesic.getName() + " ");
        switch (analgesic.getApplication()) {
            case INGEST:
                System.out.println("внутрь.");
                break;
            case INTRAMUSCULAR:
                System.out.println("внутримышечно.");
                break;
            case EXTERNAL:
                System.out.println("наружно.");
                break;
        }
        if (this.pain < 100) {
            this.pain += analgesic.getDosage();
        }
        if (this.pain > 100) {
            this.pain = 100;
        }
    }

    public int getTemperature() {
        return temperature;
    }
}
