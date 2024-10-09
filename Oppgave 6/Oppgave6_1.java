import java.util.Random;
import javax.swing.*;
public class Oppgave6_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Random random = new Random();
        int[] antallSiffer = new int[10];
        String[] stjerneListe = new String[10];

        for(int i = 0;i<1000; i++){
            antallSiffer[random.nextInt(10)]++;
        }

        for(int i = 0;i<antallSiffer.length;i++){
            int tall = Math.round(antallSiffer[i]/10);
            String stjerner="";
            for(int k=0; k<tall;k++){
                stjerner+="*";
            }
            stjerneListe[i]=stjerner;
        }

        String[] kolonneTitler = {"Siffer", "Antall"};
        Object[][] fancyArray = {
            {"0", antallSiffer[0]},
            {"1", antallSiffer[1]},
            {"2", antallSiffer[2]},
            {"3", antallSiffer[3]},
            {"4", antallSiffer[4]},
            {"5", antallSiffer[5]},
            {"6", antallSiffer[6]},
            {"7", antallSiffer[7]},
            {"8", antallSiffer[8]},
            {"9", antallSiffer[9]},
        };

        Object[][] stjerneArray = {
            {"0", stjerneListe[0]},
            {"1", stjerneListe[1]},
            {"2", stjerneListe[2]},
            {"3", stjerneListe[3]},
            {"4", stjerneListe[4]},
            {"5", stjerneListe[5]},
            {"6", stjerneListe[6]},
            {"7", stjerneListe[7]},
            {"8", stjerneListe[8]},
            {"9", stjerneListe[9]},
        };

        JTable table = new JTable(stjerneArray, kolonneTitler);
        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,197);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
    }
}
