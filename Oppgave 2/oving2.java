import static javax.swing.JOptionPane.*;
import java.util.*;

public class oving2 {
    public static void main(String[] args) {
      oppgave1();
      oppgave2();
    }

    public static void oppgave1(){
    String aarIn = showInputDialog("Hvilket år?");
    int aarstall = Integer.parseInt(aarIn);
      if(aarstall%400==0){
        showMessageDialog(null,"Det er skuddår og et hundreår!");
      }else if(aarstall%4==0 && aarstall%100!=0){
        showMessageDialog(null,"Det er skuddår!");
      }else{
        showMessageDialog(null,"Det er ikke skuddår:(");
      }
    }

    public static void oppgave2(){
    double vektA = 450;
    double prisA = 35.90;
    double prisPerGA=Math.round(prisA/vektA * 100_000d) / 1000d;
    double vektB = 500;
    double prisB =39.50;
    double prisPerGB=Math.round(prisB/vektB * 100_000d) / 1000d;
        if(prisPerGA>prisPerGB){
            showMessageDialog(null,"Kjøttdeig B er billigst med en pris på " + prisPerGB + " kr per hektogram, kjøttdeig A koster " + prisPerGA +" kr per gram");
        }else if(prisPerGB>prisPerGA){
            showMessageDialog(null,"Kjøttdeig A er billigst med en pris på " + prisPerGA + " kr per hektogram, kjøttdeig B koster " + prisPerGB +" kr per gram");
        }else if(prisPerGB==prisPerGA){
            showMessageDialog(null,"De koster like mye " + prisPerGA + "kr per hektogram");
        }
    }

}