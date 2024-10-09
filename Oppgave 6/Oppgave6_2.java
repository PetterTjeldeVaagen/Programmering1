import static javax.swing.JOptionPane.*;
import javax.swing.*;

public class Oppgave6_2 {
    int antallUnike;
    int antallBokstaver;
    int antallAvBokstav;
    double prosentIkkeBokstav;
    int[] antallTegn = new int[30];
    char[] alfabetArray = new char[30];
    String mestBrukteBokstaver = ""; 

    public Oppgave6_2(String inputTekst){
        this.alfabetArray[26]='æ';
        this.alfabetArray[27]='ø';
        this.alfabetArray[29]='å';
        for(char ch = 'a'; ch <= 'z'; ++ch)
        {
            this.alfabetArray[ch-'a']=ch;
        } 
        
        for(int i=0;i<inputTekst.length();i++){
            for(int k=0;k<this.alfabetArray.length;k++){
                if(inputTekst.charAt(i)==this.alfabetArray[k]){
                    if(inputTekst.charAt(i)== 'å'){
                        this.antallTegn[k-1]+=1;
                        break;
                    }else{
                        this.antallTegn[k]+=1;
                        break;
                    }
                }else if(k==29){
                    this.antallTegn[29]+=1;
                    break;
                }
            }
        }  
    }

    public void antallUnikeTegn(){
        //Finner antall unike bokstaver og totalt antall
        this.antallUnike =0;
        for(int i=0;i<this.antallTegn.length-1;i++){
            if(this.antallTegn[i]>0){
                this.antallUnike++;
                this.antallBokstaver+=this.antallTegn[i];
            }
        }

        System.out.println("Det er " + this.antallUnike + " unike bokstaver i teksten og " + this.antallBokstaver + " bokstaver totalt");
    }

    public void getBokstav(char input){
        for(int i = 0;i<29;i++){
            if(this.alfabetArray[i]==input){
                this.antallAvBokstav=this.antallTegn[i];
            }
        }
        if(this.antallAvBokstav == 0){
            System.out.println("Bokstaven " + input +" ble ikke brukt i teksten din");
        }else if(this.antallAvBokstav == 1){
            System.out.println("Bokstaven " + input +" ble brukt " + this.antallAvBokstav + " gang i teksten");
        }else{
            System.out.println("Bokstaven " + input +" ble brukt " + this.antallAvBokstav + " ganger i teksten");
        }
        
    }

    public void mestBruktBokstav(){
        //finne hvilken eller hvilken som forekommer flest ganger
        int stoerstAntall=0;
        for(int i = 0;i<antallTegn.length-1;i++){
            if(stoerstAntall<antallTegn[i]){
                stoerstAntall=antallTegn[i];
            }
        }
        for(int i = 0;i<alfabetArray.length-1;i++){
            if(antallTegn[i]==stoerstAntall){
                this.mestBrukteBokstaver=this.mestBrukteBokstaver + " "+alfabetArray[i]  + ", ";
            }
        }

        if(this.mestBrukteBokstaver.length()==1){
            System.out.println("Den mest brukte bokstaven i teksten er " + this.mestBrukteBokstaver);
        }else{
            System.out.println("De mest brukte bokstavene i teksten er " + this.mestBrukteBokstaver);
        }
        
    }

    public void prosentIkkeBokstaver(){
        //regner ut prosent som ikke er bokstav
        double ikkeBokstav = this.antallTegn[29];
        double antallTegnD =this.antallBokstaver+this.antallTegn[29];

        if(ikkeBokstav==0){
            System.out.println("0% av teksten er ikke bokstaver");
        }else{
            this.prosentIkkeBokstav=(ikkeBokstav/antallTegnD)*100;
            System.out.println(this.prosentIkkeBokstav + "% av teksten er ikke bokstaver");
        }  
    }

    public void tabell(){
        String[] kolonneTitler = {"Tegn","Antall"};
        Object[][] tallArray = {
            {"A", this.antallTegn[0]},
            {"B", this.antallTegn[1]},
            {"C", this.antallTegn[2]},
            {"D", this.antallTegn[3]},
            {"E", this.antallTegn[4]},
            {"F", this.antallTegn[5]},
            {"G", this.antallTegn[6]},
            {"H", this.antallTegn[7]},
            {"I", this.antallTegn[8]},
            {"J", this.antallTegn[9]},
            {"K", this.antallTegn[10]},
            {"L", this.antallTegn[11]},
            {"M", this.antallTegn[12]},
            {"N", this.antallTegn[13]},
            {"O", this.antallTegn[14]},
            {"P", this.antallTegn[15]},
            {"Q", this.antallTegn[16]},
            {"R", this.antallTegn[17]},
            {"S", this.antallTegn[18]},
            {"T", this.antallTegn[19]},
            {"U", this.antallTegn[20]},
            {"V", this.antallTegn[21]},
            {"W", this.antallTegn[22]},
            {"X", this.antallTegn[23]},
            {"Y", this.antallTegn[24]},
            {"Z", this.antallTegn[25]},
            {"Æ", this.antallTegn[26]},
            {"Ø", this.antallTegn[27]},
            {"Å", this.antallTegn[28]},
            {"Andre tegn", this.antallTegn[29]},
        };
        JFrame frame = new JFrame();
        JTable table = new JTable(tallArray, kolonneTitler);
        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,500);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        String input = showInputDialog("Hvilke tekst skal analyseres?").toLowerCase();
        Oppgave6_2 tekst = new Oppgave6_2(input);
        tekst.antallUnikeTegn();
        tekst.getBokstav('a');
        tekst.mestBruktBokstav();
        tekst.prosentIkkeBokstaver();
        tekst.tabell();
    }
}
