import static javax.swing.JOptionPane.*;
import javax.swing.JOptionPane;

public class Oppgave8 {
    public static void main(String[] args) {
        Person per = new Person("Per", "Hansen",1974);
        ArbTaker arbeiderPer = new ArbTaker(per, 12, 2004, 10000, 25.0);

        while (true) {
            System.out.println("Vedkommende betaler " + arbeiderPer.MaanedligSkatt()+ "kr i skatt i måneden");
            System.out.println("Vedkommende har en bruttolønn på " + arbeiderPer.BruttoLoenn()+" kr i året");
            System.out.println("Vedkommende blir trekt "+arbeiderPer.TotaltSkattetrekk()+" i skatt i året");
            System.out.println("Vedkommende heter "+arbeiderPer.Navn());
            System.out.println("Vedkommende er "+arbeiderPer.Alder()+" år gammel");
            System.out.println("Vedkommende har jobbet i bedriften i " + arbeiderPer.AarIBedrift()+" år");

            String[] options = {"Endre lønn", "Endre skatteprosent" ,"Arbeidslengde krav","Avslutt programmet"};
            int result =JOptionPane.showOptionDialog(null, "Hva vil du gjøre?", null,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, null);
            
            if(result==0){
                int inputLoenn = Integer.parseInt(showInputDialog("Hva er den nye lønnen?"));
                arbeiderPer.setMaanedsloenn(inputLoenn);
                System.out.println("Ny månedslønn er " + arbeiderPer.getMaanedsloenn());
            }else if(result==1){
                int inputSkatt = Integer.parseInt(showInputDialog("Hva er den nye skatteprosenten?"));
                arbeiderPer.setSkatteprosent(inputSkatt);
                System.out.println("Ny skatteprosent er " + arbeiderPer.getSkatteprosent());
            }else if(result==2){
                int input = Integer.parseInt(showInputDialog("Hvor lenge skal personen ha jobbet?"));
                if(input<=arbeiderPer.AarIBedrift()){
                    showMessageDialog(null,"" + arbeiderPer.Navn() +" Har jobbet i bedriften i " + input + " År eller mer!");
                }else{
                    showMessageDialog(null,"" + arbeiderPer.Navn() +" Har ikke jobbet i bedriften i " + input + " År eller mer!");
                }
            }else if(result==3){
                break;
            }
        }
    }
}
 
final class Person{
    private String fornavn;
    private String etternavn;
    private int foedselsaar; 

    public Person(String fornavn, String etternavn, int foedselsaar){
        this.fornavn=fornavn;
        this.etternavn=etternavn;
        this.foedselsaar=foedselsaar;
    } 

    public String getFornavn(){
        return this.fornavn;
    }

    public String getEtternavn(){
        return this.etternavn;
    }

    public int getFoedselsaar(){
        return this.foedselsaar;
    }
}

class ArbTaker{
    Person personalia;
    int arbtakernr;
    int ansettelsesaar;
    int maanedsloenn;
    double skatteprosent;
    public java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
    
    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesaar,int maanedsloenn, double skatteprosent){
        this.personalia =personalia;
        this.arbtakernr=arbtakernr;
        this.ansettelsesaar=ansettelsesaar;
        this.maanedsloenn=maanedsloenn;
        this.skatteprosent=skatteprosent;
    } 

    public Person getPersonalia(){
        return this.personalia;
    }

    public int getArbtakernr(){
        return this.arbtakernr;
    }

    public int getAnsettelsesaar(){
        return this.ansettelsesaar;
    }
    
    public int getMaanedsloenn(){
        return this.maanedsloenn;
    }
    
    public double getSkatteprosent(){
        return this.skatteprosent;
    }

    public void setMaanedsloenn(int nyLoenn){
        this.maanedsloenn=nyLoenn;
    }

    public void setSkatteprosent(double nySkatt){
        this.skatteprosent=nySkatt;
    }
    
    public double MaanedligSkatt(){
        return (skatteprosent*maanedsloenn)/100;
    }

    public int BruttoLoenn(){
        return maanedsloenn*12;
    }

    public double TotaltSkattetrekk(){
        return MaanedligSkatt()*10.5; //total trekk med skattefri juni og halv skatt i desember 
    }

    public String Navn(){
        return personalia.getEtternavn()+","+personalia.getFornavn(); //navn på formen etternavn, fornavn
    }

    public int Alder(){
        return kalender.get(java.util.Calendar.YEAR)-personalia.getFoedselsaar();
    }

    public int AarIBedrift(){
        return kalender.get(java.util.Calendar.YEAR)-this.ansettelsesaar;
    }
}