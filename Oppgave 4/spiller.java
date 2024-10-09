import java.util.Random;

public class spiller {
    int sumPoeng;
    int runder;
    int fortegn;
    String navn;
    public spiller(String nameIn){
        this.navn=nameIn;
        this.sumPoeng = 0;
        this.runder = 0;
    }
    
    public void getSumPoeng(int poeng){
        if(poeng==1){
            this.sumPoeng = 0;
        }else{
            this.sumPoeng += poeng;  
        }   
        erFerdig();
    }

    public void kastTerning(){
        Random terning= new Random();
        int terningkast = (terning.nextInt(6)+1)*this.fortegn;
        getSumPoeng(terningkast);
    } 

    public void erFerdig(){
        this.runder++;
        if(this.sumPoeng==100){
            System.out.println(this.navn + " Vant spillet på " + this.runder + " antall runder");
            spill.winner = true;
        }else if(this.sumPoeng>100){
            this.fortegn = -1;
        }else{
            this.fortegn = 1;
        }
    }
}

class spill{
    public static boolean winner=false;
    public static void main(String[] args) {
        spiller spiller1 = new spiller("spiller1");
        spiller spiller2 = new spiller("spiller2");
        while (winner==false) {
            spiller1.kastTerning();
            spiller2.kastTerning();
        }
    } 
}
