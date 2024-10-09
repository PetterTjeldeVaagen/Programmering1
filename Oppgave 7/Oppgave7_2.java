import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Oppgave7_2 {
    int[] antallTegn = new int[31];
    char[] alfabetArray = new char[31];
    String inputTekst="";
    public Oppgave7_2(String inputTekst){
        this.inputTekst=inputTekst;
        this.alfabetArray[26]='æ';
        this.alfabetArray[27]='ø';
        this.alfabetArray[28]='å';
        this.alfabetArray[29]=' ';
        for(char ch = 'a'; ch <= 'z'; ++ch)
        {
            this.alfabetArray[ch-'a']=ch;
        } 
        
        for(int i=0;i<this.inputTekst.length();i++){
            for(int k=0;k<this.alfabetArray.length;k++){
                if(inputTekst.charAt(i)==this.alfabetArray[k]){
                    this.antallTegn[k]++;
                    break;
                }else if(inputTekst.charAt(i)=='!' || inputTekst.charAt(i)=='?' || inputTekst.charAt(i)==':' || inputTekst.charAt(i)=='.'){
                    this.antallTegn[30]++;
                    break;
                }
            }
        }  
    }

    public int antallOrd(){
        int antallOrd = 1;
        for(int i =0;i<this.inputTekst.length();i++){
            if(this.inputTekst.charAt(i)==' ' && this.inputTekst.charAt(i-1)!=' '){
                antallOrd++;
            }
        }
        return antallOrd;
    }

    public double ordLengde(){
        double ordLengdeSnitt = 0.0;
        int antallBokstaver = 0;
        for(int i =0; i<29;i++){
            antallBokstaver+=this.antallTegn[i];
        }
        ordLengdeSnitt = ((double)antallBokstaver)/antallOrd();
        return ordLengdeSnitt;
    }

    public double ordPerPeriode(){
        int antallPerioder = this.antallTegn[30];
        double ordPerPer = 0.0;
        ordPerPer=((double)antallOrd()/antallPerioder);
        return ordPerPer;
    }
    
    public String skiftOrd(String ord2Skift, String ord2Skift2){
        String nyTekst = "";
        String splitting = "[:\\?\\!\\.\\s]";
        String[] splittetTekst = this.inputTekst.split(splitting);
        for(int i=0; i<splittetTekst.length;i++) {
            if(splittetTekst[i].equals(ord2Skift)){
                splittetTekst[i]=ord2Skift2;
            }
            nyTekst+= splittetTekst[i]+ " ";
        }

        return nyTekst;
    }
    
    public String storeBokstaver(){
        String storeBokstaver = this.inputTekst.toUpperCase();
        return storeBokstaver;
    }

    public String vanlig(){
        return this.inputTekst;
    }

    public static void main(String[] args) {
        String input = showInputDialog("Hvilken tekst skal analyseres?").toLowerCase();
        Oppgave7_2 tekst = new Oppgave7_2(input);
        showMessageDialog(null,"Det er " + tekst.antallOrd() + " ord i teksten");
        showMessageDialog(null,"Gjennomsnitsslengden på ordene er "+tekst.ordLengde() + " bokstaver per ord");
        showMessageDialog(null,"Det er i snitt " + tekst.ordPerPeriode() + " ord per periode");

        //ord bytte
        String skalByttesUt = showInputDialog("Hvilket ord skal byttes ut?").toLowerCase();
        String skalByttesUtMed = showInputDialog("Hva skal det byttes ut med?").toLowerCase();
        showMessageDialog(null,tekst.skiftOrd(skalByttesUt, skalByttesUtMed));

        showMessageDialog(null,tekst.vanlig());
        showMessageDialog(null,tekst.storeBokstaver());
    }
}
