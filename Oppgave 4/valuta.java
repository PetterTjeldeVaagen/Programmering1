import static javax.swing.JOptionPane.*;

public class valuta{
  double kronerPerValuta;
  String navn;
  int antallValuta;

  public valuta(double valutaVerdi, String valutaNavn){
    this.kronerPerValuta = valutaVerdi;
    this.navn=valutaNavn;
  }
  public void tilKroner(){
    antallValuta = Integer.parseInt(showInputDialog("Hvor mange "+ this.navn +" vil du vite verdien av i norske kroner"));
    showMessageDialog(null,"Det blir " + (antallValuta*this.kronerPerValuta) +" nok");
  }
}

class oving4 {
    public static void main(String[] args) {
      oppgave1();
    } 

    public static void oppgave1(){
      valuta dollar = new valuta(10.51,"Dollar");
      valuta euro = new valuta(11.66,"Euro");
      valuta svenske_kroner = new valuta(1.03,"Svenske Kroner");

      int startIn = Integer.parseInt(showInputDialog("Velg en valuta ved å skrive inn tallet tilhørende valutaen du ønsker \n Dollar=1, Euro=2, Svenske Kroner=3 , Avslutt Programmet = 4"));
        switch (startIn) {
          case 1:
            dollar.tilKroner();
            break;
          case 2:
            euro.tilKroner();
            break;
          case 3:
              svenske_kroner.tilKroner();
            break;
          case 4:
            System. exit(0);
            break;
        }
    }

}