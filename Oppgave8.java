import static javax.swing.JOptionPane.*;
import javax.swing.JOptionPane;

public class Oppgave8 {
    public static void main(String[] args) {
        Person per = new Person("Per", "Hansen",1973);
        ArbTaker arbeiderPer = new ArbTaker(per, 12, 2003, 30000, 26.7);

        while (true) {
            String[] options = { "Månedlig Skattetrekk", "Brutto årslønn", "Årlig skatetrekk", "Navn", "Alder", "Antall år ansatt i bedrift","Om personen har jobbet i bedriften i mer en et gitt antall år","Endre lønn", "Endre skatteprosent" ,"Avslutt programmet"};
            String result =(String) JOptionPane.showInputDialog(null, "Hva vil du gjøre", "valg",
                JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

            if(result==options[0]){
                showMessageDialog(null,arbeiderPer.MaanedligSkatt());
            }else if(result==options[1]){
                showMessageDialog(null,arbeiderPer.BruttoLoenn());
            }else if(result==options[2]){
                showMessageDialog(null,arbeiderPer.TotaltSkattetrekk());
            }else if(result==options[3]){
                showMessageDialog(null,arbeiderPer.Navn());
            }else if(result==options[4]){
                showMessageDialog(null,arbeiderPer.Alder());
            }else if(result==options[5]){
                showMessageDialog(null,arbeiderPer.AarIBedrift());
            }else if(result==options[6]){
                int input = Integer.parseInt(showInputDialog("Hvor lenge skal personen ha jobbet?"));
                if(input<=arbeiderPer.AarIBedrift()){
                    showMessageDialog(null,"" + arbeiderPer.Navn() +" Har jobbet i bedriften i " + input + " År eller mer!");
                }else{
                    showMessageDialog(null,"" + arbeiderPer.Navn() +" Har ikke jobbet i bedriften i " + input + " År eller mer!");
                }
            }else if(result==options[7]){
                int input = Integer.parseInt(showInputDialog("Hva er den nye lønnen?"));
                arbeiderPer.setMaanedsloenn(input);
                System.out.println("Ny månedslønn er " + arbeiderPer.getMaanedsloenn());
            }else if(result==options[8]){
                int input = Integer.parseInt(showInputDialog("Hva er den nye skatteprosenten?"));
                arbeiderPer.setSkatteprosent(input);
                System.out.println("Ny skatteprosent er " + arbeiderPer.getSkatteprosent());
            }else if(result==options[9]){
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