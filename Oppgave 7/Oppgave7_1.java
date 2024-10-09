import static javax.swing.JOptionPane.*;
import javax.swing.JOptionPane;

public class Oppgave7_1 {
    public static void main(String[] args) {
        String input = showInputDialog("Hvilke tekst skal analyseres?").toLowerCase();
        Object[] options1 = { "Fjern bokstav", "Forkort teksten"};
        int result = JOptionPane.showOptionDialog(null, "Hva vil du gjøre med teksten?", null,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        NyString tekst = new NyString(input);

        if(result==0){
            String inputCharTekst = showInputDialog("Hvilke bokstav skal fjernes?").toLowerCase();
            char inputChar = inputCharTekst.charAt(0);
            System.out.println("Teksten din uten bokstaven "+ inputChar +" er: " + tekst.getFjernet(inputChar));
        }else if(result==1){
            System.out.println( "den forkortede teksten er: " + tekst.getForkort());
        }
        
    }
    
}

final class NyString {
    private String inputTekst="";

    public NyString(String in){
        this.inputTekst =in;
    }

    private String FjernTegn(char inputChar){
        char tegn=inputChar;
        String tegnFjernet="";
        for(int i = 0;i<this.inputTekst.length();i++){
            if(this.inputTekst.charAt(i)!=tegn){
                tegnFjernet= tegnFjernet + this.inputTekst.charAt(i);
            }
        }
        return tegnFjernet;
    }

    private String Forkort(){
        String forkortet="";
        forkortet+=this.inputTekst.charAt(0);
        for(int i=1;i<this.inputTekst.length();i++){
            if(this.inputTekst.charAt(i-1)==' '){
                forkortet+=this.inputTekst.charAt(i);
            }
        }
        return forkortet;
    }

    public String getForkort(){
        return Forkort();
    }

    public String getFjernet(char inputChar){
        return FjernTegn(inputChar);
    }
}

