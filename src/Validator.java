import java.util.Date;
import java.util.regex.Pattern;

public class Validator {

    private Pattern patternJmeno = Pattern.compile("^[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-záčďéěíňóřšťúůýž]{2,29}$");
    private Pattern patternRasa = Pattern.compile("^(Elf|Trpaslík|Člověk|Ork|Hobit)$");
    private Pattern patternDatum = Pattern.compile("^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$");
    private Pattern patternZbrane = Pattern.compile("^(Meč|Kuše|Hůl|Sekera|Dýka)$");

    boolean jePlatnyRadek(String radek) {
        if (radek == null || radek.trim().isEmpty()) {
            System.out.println("Chyba: Prázdný řádek!");
            return false;
        }

        String[] udaje = radek.split(";", -1);


        boolean jeVseOk = true;

        String jmeno = udaje[0].trim();
        String rasa = udaje[1].trim();
        String datum = udaje[2].trim();
        String zbran = udaje[3].trim();
        String level = udaje[4].trim();

        int fails = 0;
        if (!patternJmeno.matcher(jmeno).matches()) {
            fails++;
            if(fails==1) {
                System.out.println("Žádost není validní:");
                System.out.println("");
            }
            System.out.println("- Neplatné jméno");
            jeVseOk = false;
        }

        if (!patternRasa.matcher(rasa).matches()) {
            fails++;
            if(fails==1) {
                System.out.println("Žádost není validní:");
                System.out.println("");
            }
            System.out.println("- Neplatná(Špatná) rasa");
            jeVseOk = false;
        }
        if (!patternDatum.matcher(datum).matches()) {
            fails++;
            if(fails==1) {
                System.out.println("Žádost není validní:");
                System.out.println("");
            }
            System.out.println("- Neplatné datum narození");
            jeVseOk = false;
        }
        if (!patternZbrane.matcher(zbran).matches()) {
            fails++;
            if(fails==1) {
                System.out.println("Žádost není validní:");
                System.out.println("");
            }
            System.out.println("- Neplatný typ zbraně");
            jeVseOk = false;
        }
        if (Integer.parseInt(level) < 1 && Integer.parseInt(level) > 100) {
            fails++;
            if(fails==1) {
                System.out.println("Žádost není validní:");
                System.out.println("");
            }
            System.out.println("- Level mimo dosah");
            jeVseOk = false;
        }
        if (udaje.length < 5) {
            fails++;
            if(fails==1) {
                System.out.println("Žádost není validní:");
                System.out.println("");
            }
            System.out.println("-  Chybějcící údaj");
            jeVseOk = false;
        }

        return jeVseOk;


    }
}
