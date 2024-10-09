import static javax.swing.JOptionPane.*;

class oving5 {
    public static void main(String[] args) {
        int tellerInput = Integer.parseInt(showInputDialog("Hva skal telleren være?"));
        int nevnerInput = Integer.parseInt(showInputDialog("Hva skal nevneren være?"));
        broek broekMedBegge = new broek(tellerInput,nevnerInput);
        broek broekMedTeller = new broek(tellerInput);
        broekMedBegge.Multiplikasjon(1,3);
        showMessageDialog(null,"Svaret er: " + (broekMedBegge.getsvarTeller()) + "/"  + (broekMedBegge.getsvarNevner()));
        broekMedBegge.Divisjon(1,3);
        showMessageDialog(null,"Svaret er: " + (broekMedBegge.getsvarTeller()) + "/"  + (broekMedBegge.getsvarNevner()));
        broekMedBegge.Subtraksjon(1,3);
        showMessageDialog(null,"Svaret er: " + (broekMedBegge.getsvarTeller()) + "/"  + (broekMedBegge.getsvarNevner()));
        broekMedTeller.Addisjon(1,3);
        showMessageDialog(null,"Svaret er: " + (broekMedTeller.getsvarTeller()) + "/"  + (broekMedTeller.getsvarNevner()));
    } 
}

public class broek{
    private int svarTeller;
    private int svarNevner;
    int teller;
    int nevner;

    public broek(int tellerIn, int nevnerIn){
            this.teller = tellerIn;
            this.nevner = nevnerIn;
        if(this.nevner == 0){
            throw new IllegalArgumentException("Kan ikke dele på 0");
        }else{
            this.nevner = nevnerIn;
        }
    }

    public broek(int tellerIn){
        this.teller=tellerIn;
        this.nevner=1;
    }

    public void Multiplikasjon(int tellerIn, int nevnerIn){
        this.svarNevner = this.nevner*nevnerIn;
        this.svarTeller = this.teller*tellerIn;
        forkort();
    }

    public void Divisjon(int tellerIn, int nevnerIn){
        this.svarNevner=this.nevner*tellerIn;
        this.svarTeller=this.teller*nevnerIn;
        forkort();
    }

    public void Addisjon(int tellerIn, int nevnerIn){
        this.svarNevner=this.nevner*nevnerIn;
        this.svarTeller=this.teller*nevnerIn+tellerIn*this.nevner;
        forkort();
    }

    public void Subtraksjon(int tellerIn, int nevnerIn){
        this.svarNevner=this.nevner*nevnerIn;
        this.svarTeller=this.teller*nevnerIn-tellerIn*this.nevner;
        forkort();
    }

    public void forkort(){
        for(int i = 2; i<this.svarNevner;i++){
            if(this.svarNevner%i==0){
                if(this.svarTeller%i==0){
                    this.svarNevner=this.svarNevner/i;
                    this.svarTeller=this.svarTeller/i;
                    break;
                }
            }
        }

    }

    public int getsvarNevner(){
        return this.svarNevner;
    }

    public int getsvarTeller(){
        return this.svarTeller;
    }
}
