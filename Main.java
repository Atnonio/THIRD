public class Main {

    public static void main(String[] args) {
        Doctor doctor=new Doctor("Доктор");
        Patient kozlik=new Patient("Козлик",false,0,0,0,0);
        kozlik.setStatement(kozlik.visit(doctor));
        while (!kozlik.isStatement()){
            kozlik.takeMedicines();
            kozlik.setStatement(kozlik.visit(doctor));
        }
        return;
    }
}
