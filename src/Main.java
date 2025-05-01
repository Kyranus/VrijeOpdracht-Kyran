import java.util.ArrayList;
import java.util.List;

class Taak {
    private String naam;
    private boolean isGroot;
    private Gebruiker toegewezenAan;

    public Taak(String naam, boolean isGroot) {
        this.naam = naam;
        this.isGroot = isGroot;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isGroteTaak() {
        return isGroot;
    }

    public void setGroot(boolean groot) {
        this.isGroot = groot;
    }

    public void getGrootteTaak() {
        if (isGroot) {
            System.out.println(naam + " is een grote taak.");
        } else {
            System.out.println(naam + " is geen grote taak.");
        }
    }

    public Gebruiker getToegewezenAan() {
        return toegewezenAan;
    }

    public void setToegewezenAan(Gebruiker gebruiker) {
        this.toegewezenAan = gebruiker;
    }
}
//Nieuwe klassen waar inheritance wordt gebruikt
abstract class Gebruiker {
    protected String naam;

    public Gebruiker(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public abstract void getBeschrijving();
}

class Gezinslid extends Gebruiker {
    public Gezinslid(String naam) {
        super(naam);
    }

    @Override
    public void getBeschrijving() {
        String beschrijving = naam + " is een gezinslid";
        System.out.println(beschrijving);
    }
}

class Manager extends Gebruiker {
    public Manager(String naam) {
        super(naam);
    }

    @Override
    public void getBeschrijving() {
        String beschrijving = naam + " is een manager";
        System.out.println(beschrijving);
    }

    public void wijzigTaak(Taak taak, boolean isGroot) {
        taak.setGroot(isGroot);
    }
}

class Dag {
    private String datum;
    private List<Taak> taken;

    public Dag(String datum) {
        this.datum = datum;
        this.taken = new ArrayList<>();
    }

    public void voegTaakToe(Taak taak) {
        taken.add(taak);
    }

    public List<Taak> getTaken() {
        return taken;
    }

    public String getDatum() {
        return datum;
    }
}

class WeekSchema {
    private List<Dag> dagen;

    public WeekSchema() {
        this.dagen = new ArrayList<>();
    }

    public void voegDagToe(Dag dag) {
        dagen.add(dag);
    }

    public void printOverzicht() {
        for (Dag dag : dagen) {
            System.out.println("Dag: " + dag.getDatum());
            for (Taak taak : dag.getTaken()) {
                String info = "- " + taak.getNaam();
                if (taak.getToegewezenAan() != null) {
                    info += " (toegewezen aan: " + taak.getToegewezenAan().getNaam() + ")";
                }
                System.out.println(info);
            }
        }
    }
}

    public class Main {
        public static void main(String[] args) {
            //Polymorfisme
            Gebruiker Irma = new Manager("Irma");
            Gebruiker Kyran = new Gezinslid("Kyran");
            Irma.getBeschrijving();
            Kyran.getBeschrijving();

            Taak afwas = new Taak("Afwas", false);
            afwas.setToegewezenAan(Kyran);
            Taak stofzuigen = new Taak("Stofzuigen", true);
            stofzuigen.setToegewezenAan(Irma);
            Dag maandag = new Dag("Maandag");
            maandag.voegTaakToe(afwas);
            maandag.voegTaakToe(stofzuigen);
            WeekSchema schema = new WeekSchema();
            schema.voegDagToe(maandag);
            schema.printOverzicht();

            //Nieuwe tests
            ((Manager) Irma).wijzigTaak(afwas, true);
            afwas.getGrootteTaak();

        }
    }

