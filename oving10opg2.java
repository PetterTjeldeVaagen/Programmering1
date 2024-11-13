import java.util.ArrayList;

public class oving10opg2 {
    public static void main(String[] args){
        MenyRegister Menyer = new MenyRegister();

        Menyer.RegistrerRett("Pizza", "Hovedrett", 100, "ost og saus på deig, stek!");
        Menyer.RegistrerRett("Pasta", "Hovedrett", 90, "Kok pasta og sånn!");
        Menyer.RegistrerRett("Iskrem", "Dessert", 1000, "Ut av fryser inn i kjeften");
        Menyer.RegistrerRett("Ost", "Forrett", 10, "Ut av kjøleskap inn i kjeften");
        System.out.println(Menyer.FinnRett("Pizza").oppskrift);
        System.out.println(Menyer.FinnRett("Fisk").navn);

        String typeRett="Hovedrett";
        for (int i = 0; i <Menyer.FinnRettEtterType(typeRett).size(); i++) {
            System.out.println(Menyer.FinnRettEtterType(typeRett).get(i).navn);
        }

        String[] Meny1Navn = {"Pizza", "Pasta", "Iskrem"};
        String[] Meny2Navn = {"Ost"};
        Menyer.RegistrerMeny(Meny1Navn, "Meny 1");
        Menyer.RegistrerMeny(Meny2Navn, "Meny 2");

        System.out.println(Menyer.FinnMenyerInnenPris(10000).get(0).menyNavn);            
    }
}

class MenyRegister{
    public ArrayList<Rett> registrerteRetter = new ArrayList<Rett>();
    public ArrayList<Meny> registrerteMenyer = new ArrayList<Meny>();
    
    public void RegistrerRett(String rettNavn, String rettType, double rettPris, String rettOppskrift){
        this.registrerteRetter.add(new Rett(rettNavn, rettType, rettPris, rettOppskrift));
    }

    public Rett FinnRett(String soekRettNavn){
        Rett riktigRett=new Rett("Rett ikke funnet","Rett ikke funnet",-1,"Rett ikke funnet"); 
        for(int i =0; i<registrerteRetter.size();i++){
            if(registrerteRetter.get(i).navn.toLowerCase().equals(soekRettNavn.toLowerCase())){
                riktigRett=registrerteRetter.get(i);
            }
        }
        return riktigRett;
    }

    public ArrayList<Rett> FinnRettEtterType(String SoekeTypeIn){
        ArrayList<Rett> retterEtterType = new ArrayList<Rett>();
        for(int i = 0; i < registrerteRetter.size(); i++){
            if(registrerteRetter.get(i).type.toLowerCase().equals(SoekeTypeIn.toLowerCase())){
                retterEtterType.add(registrerteRetter.get(i));
            }
        }
        return retterEtterType;
    }

    public void RegistrerMeny(String[] retterTilMenyNavn, String menyNavn){
        ArrayList<Rett> retterTilMeny = new ArrayList<Rett>();
        for (int i = 0; i < this.registrerteRetter.size(); i++) {
            for (int k = 0; k < retterTilMenyNavn.length ; k++) {
                if(this.registrerteRetter.get(i).navn.toLowerCase().equals(retterTilMenyNavn[k].toLowerCase())){
                    retterTilMeny.add(this.registrerteRetter.get(i));
                }
            }
        }
        this.registrerteMenyer.add(new Meny(retterTilMeny, menyNavn));
    }

    public ArrayList<Meny> FinnMenyerInnenPris(double maksPris){
        ArrayList<Meny> menyUnderPris = new ArrayList<Meny>();
        for (int i = 0; i <this.registrerteMenyer.size(); i++){
            if(this.registrerteMenyer.get(i).TotalMenyPris()<maksPris){
                menyUnderPris.add(this.registrerteMenyer.get(i));
            }
        }
        return  menyUnderPris;
    }
}

class Rett{
    String navn;
    String type;
    String oppskrift;
    double pris;
    public Rett(String navnIn, String typeIn, double prisIn, String oppskriftIn){
        this.navn = navnIn;
        this.type = typeIn;
        this.pris = prisIn;
        this.oppskrift=oppskriftIn;
    }
}

class Meny{
    public ArrayList<Rett> Retter = new ArrayList<Rett>();
    public String menyNavn;

    public Meny(ArrayList<Rett> retterIn, String menyNavnIn){
        this.Retter=retterIn;
        this.menyNavn = menyNavnIn;
    }
    
    public double TotalMenyPris(){
        double sumAvRetter=0;
        for (int i = 0; i < this.Retter.size(); i++) {
            sumAvRetter+=this.Retter.get(i).pris;
        }
        return sumAvRetter;
    }
}
