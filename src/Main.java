void main() {

    Validator val = new Validator();
    List<Agresor> agr = new ArrayList<>();
    Path agresori = Path.of("data", "data.txt");
    List<Agresor> validni = new ArrayList<>();

    try {
        try (BufferedReader agresoriReader = Files.newBufferedReader(agresori))
        {
            String[] radkyAgresori = agresoriReader.readAllLines().toArray(String[]::new);
            for (int i = 0; i < radkyAgresori.length; i++) {

                String[] radka = radkyAgresori[i].split(";");
                agr.add(new Agresor(radka[0],radka[1],radka[2],radka[3],Integer.parseInt(radka[4])));

                if(val.jePlatnyRadek(radkyAgresori[i])){
                    System.out.println("Žádost postavy "+agr.get(i).getJmeno()+" je validní");
                    validni.add(agr.get(i));
                } else {
                    val.jePlatnyRadek(radkyAgresori[i]);
                }
            }

        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    //tady vypisuju jméno a zbraň postavy s nejvyšším levelem
    int level = 0;
    Agresor ag = null;
    for (Agresor a : agr) {
        if (a.getLevel() > level) {
            ag = a;
        }
    }
    System.out.println("Nejvyšší level má postava: "+ag.getJmeno()+" se zbraní: "+ag.getTypZbrane());



}








































