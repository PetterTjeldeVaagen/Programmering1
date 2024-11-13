import static javax.swing.JOptionPane.showInputDialog;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class oving10opg1 {
    public static void main(String[] args) {
        while (true) { 
        String[] options = {"Legg til nytt arrangement", "Søk etter arrangement", "Avslutt programmet"};
        int result =JOptionPane.showOptionDialog(null, "Hva vil du gjøre?", null,
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        switch(result){
            case 0:
                arrangementer.NyttArrangement();
                break;
            case 1:
                ArrangementSoek();
                break;
            case 2:
                System.exit(0);
        }
    }
    }

    static ArrangementRegister arrangementer = new ArrangementRegister();
    public static void PrintArrangement(ArrayList<Arrangement> arrIn){
        ArrayList<Arrangement> arrMellomDato = arrIn;
        for (int i = 0; i < arrMellomDato.size(); i++){
            System.out.println("Det er " + arrMellomDato.get(i).arrangementType + " som blir arrangert av " + arrMellomDato.get(i).arrangoer + " Det skjer på/med/i " +  arrMellomDato.get(i).sted + " tidspunktet er " +  arrMellomDato.get(i).dato + " Det er arrangement nummer "+  arrMellomDato.get(i).nummer);
        }     
    }

    public static void ArrangementSoek(){
        while (true) { 
        String[] options = {"Finn arrangement på et sted", "Finn arrangement på en dag" ,"Finn arrangement i løpet av tidsrom","Sorter arrangement", "Avslutt programmet"};
        int result =JOptionPane.showOptionDialog(null, "Hva vil du gjøre?", null,
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
    switch (result) {
        case 0:
            String input = showInputDialog("Hvor ønsker du å finne et arrangement");
            PrintArrangement(arrangementer.alleArrangementSted(input));
            break;
        case 1:
            JPanel arrangementDato = new JPanel();
            JTextField yearInput = new JTextField(4);
            JTextField monthInput = new JTextField(2);
            JTextField dayInput = new JTextField(2);
            arrangementDato.add(new JLabel("År:"));
            arrangementDato.add(yearInput);
            arrangementDato.add(new JLabel("Måned:"));
            arrangementDato.add(monthInput);
            arrangementDato.add(new JLabel("Dag:"));
            arrangementDato.add(dayInput);
            int resultDato = JOptionPane.showConfirmDialog(null, arrangementDato,"Hvilken dag skal sjekkes", JOptionPane.OK_CANCEL_OPTION);
            if (resultDato == JOptionPane.OK_OPTION) {
                String dato=yearInput.getText()+monthInput.getText()+dayInput.getText();
                PrintArrangement(arrangementer.alleArrangementDato(Long.parseLong(dato)));
            }
            break;
        case 2:
            String startDato;
            String sluttDato;
            JPanel startDatoIn = new JPanel();
            JTextField yearInputStart = new JTextField(4);
            JTextField monthInputStart = new JTextField(2);
            JTextField dayInputStart = new JTextField(2);
            startDatoIn.add(new JLabel("Legg inn start dato"));
            startDatoIn.add(new JLabel("År:"));
            startDatoIn.add(yearInputStart);
            startDatoIn.add(new JLabel("Måned:"));
            startDatoIn.add(monthInputStart);
            startDatoIn.add(new JLabel("Dag:"));
            startDatoIn.add(dayInputStart);
            int resultStart = JOptionPane.showConfirmDialog(null, startDatoIn,"Fyll inn start dato", JOptionPane.OK_CANCEL_OPTION);
            if (resultStart == JOptionPane.OK_OPTION) {
                startDato=yearInputStart.getText()+""+monthInputStart.getText()+""+dayInputStart.getText();
                JPanel sluttDatoIn = new JPanel();
                JTextField yearInputslutt = new JTextField(4);
                JTextField monthInputslutt = new JTextField(2);
                JTextField dayInputslutt = new JTextField(2);
                sluttDatoIn.add(new JLabel("Legg inn slutt dato"));
                sluttDatoIn.add(new JLabel("År:"));
                sluttDatoIn.add(yearInputslutt);
                sluttDatoIn.add(new JLabel("Måned:"));
                sluttDatoIn.add(monthInputslutt);
                sluttDatoIn.add(new JLabel("Dag:"));
                sluttDatoIn.add(dayInputslutt);
                int resultSlutt = JOptionPane.showConfirmDialog(null, sluttDatoIn,"Fyll inn sluttdato", JOptionPane.OK_CANCEL_OPTION);
                if (resultSlutt == JOptionPane.OK_OPTION) {
                    sluttDato=yearInputslutt.getText()+""+monthInputslutt.getText()+""+dayInputslutt.getText();
                    PrintArrangement(arrangementer.alleArrangementToTid(Long.parseLong(startDato), Long.parseLong(sluttDato)));

                }
            }
            break;
            
        case 3:
            String[] optionsSort = {"Sorter sted alfabetisk", "Sorter etter dato" ,"Sorter typer alfabetisk"};
            int resultSort =JOptionPane.showOptionDialog(null, "Hvordan vil du sortere listen?", null,
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, optionsSort, null);
            PrintArrangement(arrangementer.sorterArrangement(resultSort));
            break;
        case 4:
            System.exit(0);

    }
    }
}
}

class Arrangement{
    public String arrangementType; 
    public String arrangoer;
    public String sted;
    public long dato;
    public int nummer;

    public Arrangement(long datoIn, String arrangoerIn, String arrangementIn, String stedIn, int nummerIn){
        this.dato=datoIn;
        this.arrangoer=arrangementIn;
        this.arrangementType=arrangementIn;
        this.nummer = nummerIn;
        this.sted = stedIn;
    }

}

class ArrangementRegister{
    public ArrayList<Arrangement> arrangementListe = new ArrayList<Arrangement>();
    int antallArrangement=0;

    public void NyttArrangement(){
        this.antallArrangement++;
        JPanel nyttArrangement = new JPanel();
        JTextField arrangoerInput = new JTextField(15);
        JTextField yearInput = new JTextField(4);
        JTextField monthInput = new JTextField(2);
        JTextField dayInput = new JTextField(2);
        JTextField timeInput = new JTextField(4);
        JTextField typeInput = new JTextField(10);
        JTextField stedInput = new JTextField(10);
        nyttArrangement.add(new JLabel("Arrangør:"));
        nyttArrangement.add(arrangoerInput);
        nyttArrangement.add(new JLabel("År:"));
        nyttArrangement.add(yearInput);
        nyttArrangement.add(new JLabel("Måned:"));
        nyttArrangement.add(monthInput);
        nyttArrangement.add(new JLabel("Dag:"));
        nyttArrangement.add(dayInput);
        nyttArrangement.add(new JLabel("Klokkeslett:"));
        nyttArrangement.add(timeInput);
        nyttArrangement.add(new JLabel("Arrangement Type:"));
        nyttArrangement.add(typeInput);
        nyttArrangement.add(new JLabel("Sted for arrangement:"));
        nyttArrangement.add(stedInput);
        int result = JOptionPane.showConfirmDialog(null, nyttArrangement,"Fyll inn informasjon for arrangementet ditt", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
        String tidString = yearInput.getText()+ monthInput.getText()+dayInput.getText()+timeInput.getText();
        long tid = Long.parseLong(tidString);
        arrangementListe.add(new Arrangement(tid, arrangoerInput.getText(), typeInput.getText(), stedInput.getText(), antallArrangement));
        }
    }   

    public ArrayList<Arrangement> alleArrangementSted(String stedIn){
        ArrayList<Arrangement> arrangementListeForSted = new ArrayList<>();
        for(int i = 0; i < arrangementListe.size(); i++){
            if(arrangementListe.get(i).sted.toLowerCase().equals(stedIn.toLowerCase())){
                arrangementListeForSted.add(arrangementListe.get(i));
            }
        }
        return arrangementListeForSted;
    }

    public ArrayList<Arrangement> sorterArrangement(int input){
        ArrayList<Arrangement> sortertListe = new ArrayList<>();
        if(input==0){ //sorter listen alfabetisk etter sted
            String[] sortertListeSted = new String[arrangementListe.size()];
            for(int i = 0; i < arrangementListe.size(); i++){
                sortertListeSted[i]=arrangementListe.get(i).sted;
            }
            Arrays.sort(sortertListeSted);
            for(int k=0; k<arrangementListe.size();k++){
                for(int b=0; b<sortertListeSted.length; b++){
                    if(sortertListeSted[k].equals(arrangementListe.get(b).sted)){
                        sortertListe.add(arrangementListe.get(b));
                    }
                }
            }

        }else if(input ==1){//sorter etter arrangement som er nærmest og skje
            long[] sortertListeTid = new long[arrangementListe.size()]; 
            for(int i = 0; i < arrangementListe.size(); i++){
                sortertListeTid[i]=arrangementListe.get(i).dato;
            }
            Arrays.sort(sortertListeTid);
            for(int k=0; k<arrangementListe.size();k++){
                for(int b=0; b<sortertListeTid.length; b++){
                    if(sortertListeTid[k]==arrangementListe.get(b).dato){
                        sortertListe.add(arrangementListe.get(b));
                    }
                }
            }
        }else{//sorter alfabetisk etter type arrangement
            String[] sortertListeType = new String[arrangementListe.size()]; 
            for(int i = 0; i < arrangementListe.size(); i++){
                sortertListeType[i]=arrangementListe.get(i).arrangementType;
            }
            Arrays.sort(sortertListeType);
            for(int k=0; k<arrangementListe.size();k++){
                for(int b=0; b<sortertListeType.length; b++){
                    if(sortertListeType[k].equals(arrangementListe.get(b).arrangementType)){
                        sortertListe.add(arrangementListe.get(b));
                    }
                }
            }
        }

        return sortertListe;
    }

    public ArrayList<Arrangement> alleArrangementDato(long datoIn){
        ArrayList<Arrangement> arrangementListeForDato = new ArrayList<>();
        for(int i = 0; i < arrangementListe.size(); i++){
            String datoString =Long.toString(arrangementListe.get(i).dato);
            long dato = Long.parseLong(datoString.substring(0, 8));
            if(dato == datoIn){
                arrangementListeForDato.add(arrangementListe.get(i));
            }
        }
        
        return arrangementListeForDato;
    }

    public ArrayList<Arrangement> alleArrangementToTid(long startTid, long sluttTid){
        ArrayList<Arrangement> arrangementListeForToDato = new ArrayList<>();
        String datoStringStart =Long.toString(startTid); //Gjør starttid til 3 variabler
        int yearStart = Integer.parseInt(datoStringStart.substring(0, 4));
        int monthStart = Integer.parseInt(datoStringStart.substring(4, 6));
        int dayStart= Integer.parseInt(datoStringStart.substring(6, 8));

        String datoStringslutt =Long.toString(sluttTid); //Gjør slutttid til 3 variabler
        int yearSlutt = Integer.parseInt(datoStringslutt.substring(0, 4));
        int monthSlutt = Integer.parseInt(datoStringslutt.substring(4, 6));
        int daySlutt= Integer.parseInt(datoStringslutt.substring(6, 8));

        for(int i = 0; i < arrangementListe.size(); i++){
            String datoString =Long.toString(arrangementListe.get(i).dato); //Gjør input til 3 variabler
            
            int year = Integer.parseInt(datoString.substring(0, 4));
            int month = Integer.parseInt(datoString.substring(4, 6));
            int day= Integer.parseInt(datoString.substring(6, 8));
            
            if(year<= yearSlutt && year>=yearStart){
                if(month<monthSlutt && month>monthStart){
                    arrangementListeForToDato.add(arrangementListe.get(i));
                }else if (month==monthSlutt){
                    if(day<=daySlutt){
                        arrangementListeForToDato.add(arrangementListe.get(i));
                    }
                }else if (month==monthStart){
                    if(day>=dayStart){
                        arrangementListeForToDato.add(arrangementListe.get(i));
                    }
                }
            }
        }
        return arrangementListeForToDato;
    }
}
