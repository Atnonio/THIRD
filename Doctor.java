public class Doctor extends Character implements Treat {
    @Override
    public String toString() {
        return "Doctor" + " " + getName();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Doctor(String name) {
        super(name);
    }

    @Override
    public Prescription checkup(Ail patient) {
        return this.prescription(patient.symptoms());
    }

    @Override
    public Prescription prescription(Anamnesis anamnesis) {
        int quantity = 0;
        Medicine[] medicines = new Medicine[1];
        if (anamnesis.getVita() < 100) {
            Medicine[] pills = new Medicine[quantity + 2];
            for (int i = 0; i < quantity; i++) {
                pills[i] = medicines[i];
            }
            pills[quantity] = new Vitamin("VitaminC", Type.VITAMIN, Application.INGEST, 3);
            pills[quantity + 1] = new Vitamin("VitaminD", Type.VITAMIN, Application.INGEST, 3);
            quantity += 2;
            medicines = pills;
        }
        if (anamnesis.getPain() < 100) {
            Medicine[] pills = new Medicine[quantity + 1];
            for (int i = 0; i < quantity; i++) {
                pills[i] = medicines[i];
            }
            pills[quantity] = new Analgesic("Novocain", Type.ANALGESIC, Application.INTRAMUSCULAR, 5);
            quantity += 1;
            medicines = pills;
        }
        if (anamnesis.getTemperature() < 100) {
            Medicine[] pills = new Medicine[quantity + 1];
            for (int i = 0; i < quantity; i++) {
                pills[i] = medicines[i];
            }
            pills[quantity] = new Antipyretic("Pyramidon", Type.ANTIPYRETIC, Application.INGEST, 5);
            quantity += 1;
            medicines = pills;
        }
        if (anamnesis.getInflammation() < 100) {
            Medicine[] pills = new Medicine[quantity + 3];
            for (int i = 0; i < quantity; i++) {
                pills[i] = medicines[i];
            }
            pills[quantity] = new Antibiotic("Sintomicine Liniment", Type.ANTIBIOTIC, Application.EXTERNAL, 2);
            pills[quantity + 1] = new Antibiotic("Streptocid", Type.ANTIBIOTIC, Application.INGEST, 2);
            pills[quantity + 2] = new Antibiotic("Antibiotics", Type.ANTIBIOTIC, Application.INTRAMUSCULAR, 2);
            quantity += 3;
            medicines = pills;
        }

        if (quantity != 0) {
            int spell = 0;
            int p, i, t, v;
            p = i = t = v = 0;
            for (int j = 0; j < medicines.length; j++) {
                switch (medicines[j].getType()) {
                    case ANALGESIC:
                        p += medicines[j].getDosage();
                        break;
                    case ANTIBIOTIC:
                        i += medicines[j].getDosage();
                        break;
                    case ANTIPYRETIC:
                        t += medicines[j].getDosage();
                        break;
                    case VITAMIN:
                        v += medicines[j].getDosage();
                        break;
                }
            }
            while (Math.min(Math.min(t, i), Math.min(p, v)) * spell < (100 - anamnesis.getMin()) / 2) {
                spell += 7;
            }
            if (spell != 7) {
                System.out.println("Доктор выписал целую кучу рецептов.");
            }
            if (spell == 7) {
                System.out.println("Козлик уже может вставать!");
            }
            return new Prescription(medicines, spell, 0);
        }
        System.out.println("Больной окончательно выздоровел; ему необходимо лишь получше питаться, чтоб восстановить силы.");
        return null;
    }
}
