import java.time.*;
import java.util.*;

public class Oppgave8 {
    public static void main(String[] args) {

    }
}
 
final class Person{
    private String fornavn;
    private String etternavn;
    private int foedselsaar; 

    private Person(String fornavn, String etternavn, int foedselsaar){
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
        return (skatteprosent*maanedsloenn)/100; //hvor mange kroner som månedlig må betales i skatt
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

    public boolean  ArbeidsTidSjekk(int antallArr){
        if(antallArr<AarIBedrift()){
            return true;
        }else{
            return false;
        }
    }



}