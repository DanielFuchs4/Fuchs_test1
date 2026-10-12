import java.util.Date;

public class Agresor {

    private String jmeno;
    private String rasa;
    private String datumNarozeni;
    private String typZbrane;
    private int level;

    public Agresor(String jmeno, String rasa, String datumNarozeni, String typZbrane, int level) {
        this.jmeno = jmeno;
        this.rasa = rasa;
        this.datumNarozeni = datumNarozeni;
        this.typZbrane = typZbrane;
        this.level = level;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getRasa() {
        return rasa;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public String getTypZbrane() {
        return typZbrane;
    }

    public int getLevel() {
        return level;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public void setTypZbrane(String typZbrane) {
        this.typZbrane = typZbrane;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Jmeno: "+jmeno+" Rasa: "+rasa+" Datum narození: "+datumNarozeni+" Zbraň: "+typZbrane+" Level: "+level;
    }
}
