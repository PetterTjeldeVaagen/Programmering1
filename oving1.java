import static javax.swing.JOptionPane.*;

public class oving1 {
    public static void main(String[] args) {
      oppgave1("5");
      oppgave2("1","1","1");
      oppgave3();
    }

    public static void oppgave1(String tommer){
      double centimeter= Double.parseDouble(tommer)*2.54;
      showMessageDialog(null, "lengden i centimeter er " + centimeter + " cm");
    }

    public static void oppgave2(String timer, String minutter, String sekunder){
      double totalAntallSekunder= (Double.parseDouble(timer)*60*60)+(Double.parseDouble(minutter)*60)+(Double.parseDouble(sekunder));
      showMessageDialog(null, "Det er " + totalAntallSekunder + " sekunder");
    }

    public static void oppgave3(){
      String sekunderIn = showInputDialog("Antall sekunder?");
      int totalSekunder = Integer.parseInt(sekunderIn);
      int timer=totalSekunder/3600;
      int minutter=(totalSekunder%3600)/60;
      int sekunder=totalSekunder%60;
      showMessageDialog(null, "Det er " + timer + " Timer, " + minutter +" minutter og " + sekunder + " sekunder");
    }
    
}