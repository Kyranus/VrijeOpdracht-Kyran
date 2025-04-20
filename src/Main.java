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

    public Gebruiker getToegewezenAan() {
        return toegewezenAan;
    }

    public void setToegewezenAan(Gebruiker gebruiker) {
        this.toegewezenAan = gebruiker;
    }
}

class Gebruiker {
    private String naam;

    public Gebruiker(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return "Gebruiker: " + naam;
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
        Gebruiker Irma = new Gebruiker("Irma");
        Gebruiker Kyran = new Gebruiker("Kyran");
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
    }
}
