import static javax.swing.JOptionPane.*;

public class oving3 {
    public static void main(String[] args) {
      oppgave1();
      oppgave2();
    }
    public static void oppgave1(){
      int startVerdi;
      int sluttVerdi;
      do{
        startVerdi = Integer.parseInt(showInputDialog("hvilket tall skal tabellen begynne med"));
        sluttVerdi= Integer.parseInt(showInputDialog("hvilket tall skal tabellen slutte med"));
      if(sluttVerdi<=startVerdi){
        showMessageDialog(null,"Velg en størr sluttverdi enn startverdi");
        startVerdi = Integer.parseInt(showInputDialog("hvilket tall skal tabellen begynne med"));
        sluttVerdi= Integer.parseInt(showInputDialog("hvilket tall skal tabellen slutte med"));
      }
      }while(sluttVerdi<=startVerdi);

      for(int i = startVerdi; i<=sluttVerdi;i++){
        System.out.println(i+" Gangen:");
        for(int k = 1; k<=10;k++){
          System.out.println(i+ "x"+k+"="+(k*i));
        }
        System.out.println();
      }
      
    }
    public static void oppgave2(){
      String primIn = showInputDialog("hvilket tall skal sjekkes om er et primtall");
      int primSjekk = Integer.parseInt(primIn);
      boolean ikkePrim = false;
      
      if(primSjekk%2==0){
        ikkePrim = true;
      }else{
        for(int i = 3; i<primSjekk;i+=2){
          if(primSjekk%i==0){
            ikkePrim = true;
          }
        }
      }

      if(ikkePrim == false){
        showMessageDialog(null,"Tallet er et primtall");
      }else{
        showMessageDialog(null,"Tallet er ikke et primtall");
      }
    }
}