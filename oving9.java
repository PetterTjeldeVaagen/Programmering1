
import java.awt.im.InputContext;
import jdk.jshell.VarSnippet;

public class oving9{
    public static void main(String[] args) {
        Oppgaveoversikt oppgaver = new Oppgaveoversikt();
    }
}

class Student{
    private String navn;
    private int antOppg;

    public Student(String navnIn){
        this.navn=navnIn;
    }

    public String getNavn(){
        return this.navn;
    }

    public int getAntOppg(){
        return this.antOppg;
    }

    public void økAntOppg(int økning){
        this.antOppg+=økning;
    }

    public String toString(input){
        return input.toString(); //finn ut om missforståelse
    }
}

class Oppgaveoversikt{
    private Student studenter;
    private int antStud=0;
    public Oppgaveoversikt(Student studentIn){
        studenter=new Student[];

    }

    public int getAntStud(){
        return this.antStud;
    }

    public int oppgaverLøst(Student studetIn){
        return studetIn.getAntOppg();
    }

    public void økAntStud(){
        //legg til student i tabellen studenter
        this.antStud++;
    }

    public void økAntOppgForStudent(Student studentIn, int økning){
        studentIn.økAntOppg(økning);
    }
}