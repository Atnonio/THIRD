public class Prescription {
    private Medicine[] medicines;
    private int spell;
    private int progress;

    Prescription(Medicine[] medicines, int spell, int progress) {
        this.medicines = medicines;
        this.spell = spell;
        this.progress = progress;
    }


    public int getSpell() {
        return spell;
    }

    public int getProgress() {
        return progress;
    }

    public void incrementProgress() {
        this.progress++;
    }

    public Medicine[] getMedicines() {
        return medicines;
    }


}
