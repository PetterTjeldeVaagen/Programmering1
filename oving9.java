import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public class oving9{
    public static void main(String[] args) {
        Oppgaveoversikt oppgaver = new Oppgaveoversikt();

        while (true) { 
            String[] options = {"Legg til student", "Antall studenter" ,"Antall oppgaver for student", "Øk antall oppgaver for student","toString() fancy deluxe","Avslutt programmet"};
            int result =JOptionPane.showOptionDialog(null, "Hva vil du gjøre?", null,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, null);

            System.out.println(result);
            
                if(result==0){
                    String navnInput = showInputDialog("Hva heter studenten?").toLowerCase();
                    int oppgaveinput = Integer.parseInt(showInputDialog("Hvor mange oppgaver har studenten gjort?"));
                    oppgaver.økAntStud(new Student(navnInput,oppgaveinput));
                }else if(result==1){
                    JOptionPane.showMessageDialog(null, "Det er: "+ oppgaver.getAntStud() + " studenter");
                }else if (result==2){
                    String[] studentNavn=oppgaver.getStudentnavn();
                    int studentResult = JOptionPane.showOptionDialog(null, "Hvilken student vil finne antall oppgaver til", null,
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, studentNavn, null);

                    Student stud = oppgaver.getStudenter()[studentResult];
                    JOptionPane.showMessageDialog(null, stud.getNavn()+  " har gjort "+ oppgaver.oppgaverLøst(stud) + " Oppgaver");
                }else if (result == 3) {
                    String[] studentNavn=oppgaver.getStudentnavn();
                    int studentResult = JOptionPane.showOptionDialog(null, "Hvilken student vil du legge til flere opppgave på", null,
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, studentNavn, null);

                    Student stud = oppgaver.getStudenter()[studentResult];
                    int økning =Integer.parseInt(JOptionPane.showInputDialog(null, "Hvor mange oppgaver vil du legge til for " + stud.getNavn()+ "?" ));
                    oppgaver.økAntOppgForStudent(stud, økning);
                }else if (result==4) {
                    String[] studentNavn=oppgaver.getStudentnavn();
                    int studentResult = JOptionPane.showOptionDialog(null, "Hvilken student student skal toStringifiseres", null,
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, studentNavn, null);

                    Student stud = oppgaver.getStudenter()[studentResult];
                    showMessageDialog(null, stud.toString());
                }else{
                    System. exit(0);
                }
            }
        }
    }

class Student{
    private String navn;
    private int antOppg;

    public Student(String navnIn, int oppgIn){
        this.navn=navnIn;
        this.antOppg = oppgIn;
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
    

    @Override
    public String toString() {
        String tekst = this.navn + ", " + this.antOppg + " opgaver løst";
        return tekst;
    }
}


class Oppgaveoversikt{
    private Student[] studenter;
    private int antStud =0;
    public Oppgaveoversikt(){
        this.studenter = new Student[100];
    }

    public int getAntStud(){
        return antStud;
    }

    public Student[] getStudenter(){
        return this.studenter;
    }

    public String[] getStudentnavn(){
        String[] studentNavn = new String[antStud];
        for (int i = 0; i < antStud; i++) {
            studentNavn[i]=studenter[i].getNavn();
        }
        return studentNavn;
    }

    public int oppgaverLøst(Student studentIn){
        return studentIn.getAntOppg();
    }

    public void økAntStud(Student studentIn){
        this.studenter[antStud]=studentIn;
        antStud++;
    }

    public void økAntOppgForStudent(Student studentIn, int økning){
        studentIn.økAntOppg(økning);
    }
}