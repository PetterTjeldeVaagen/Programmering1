final class Matrise{
    private final int[][] startMatrise = {{1,1,1},{2,2,2},{3,3,3}};
    private final int[][] andreMatrise = {{1,1,1},{2,2,2},{3,3,3}};
    private  int[][] svarMatrise={{0,0,0},{0,0,0},{0,0,0}};

    public void setAddition(){
        for(int i=0; i<startMatrise.length; i++){
            for(int k=0;k<startMatrise[i].length;k++){
                this.svarMatrise[i][k]=startMatrise[i][k]+andreMatrise[i][k];
            }
        }
    }

    
    public int[][] getAddition(){
        if(startMatrise.length!=andreMatrise.length && startMatrise[0].length!=andreMatrise[0].length){
            return null;
        }else{
            return svarMatrise;
        }

    }

    public void setMultipliaction(){
        for(int i = 0; i<startMatrise.length; i++){
            for(int k =0;k<startMatrise[i].length;k++){
                this.svarMatrise[i][k]=0;
                for(int b=0;b<startMatrise.length;b++){
                    int delSum=startMatrise[i][b]*andreMatrise[b][k];
                    this.svarMatrise[i][k]+=delSum;
                }
            }
        }    
    }

    public int[][] getMultiplication(){
        if(startMatrise.length!=3 || andreMatrise.length!= 3 || startMatrise[0].length != 3 || andreMatrise[0].length != 3){
            return null;
        }else{
            return svarMatrise;
        }
    }

    public void setTransposition(){
        for(int i = 0;i<startMatrise.length;i++){
            for(int k=0;k<startMatrise.length;k++){
                this.svarMatrise[i][k]=startMatrise[k][i];
            }
        }
    }

    public int[][] getTransposition(){
        if(startMatrise.length!=andreMatrise.length && startMatrise[0].length!=andreMatrise[0].length){
            return null;
        }else{
            return svarMatrise;
        }
    }
}

public class Oppgave6_3{
    public static void main(String[] args) {
        Matrise minMatrise = new Matrise();
        minMatrise.setAddition();
        for(int i=0;i<minMatrise.getAddition().length;i++){
            System.out.println(minMatrise.getAddition()[i][0]+" "+minMatrise.getAddition()[i][1]+" "+ minMatrise.getAddition()[i][2]);
        }
        System.out.println();
        minMatrise.setMultipliaction();
        for(int i=0;i<minMatrise.getMultiplication().length;i++){
            System.out.println(minMatrise.getMultiplication()[i][0]+" "+minMatrise.getMultiplication()[i][1]+" "+ minMatrise.getMultiplication()[i][2]);
        }
        System.out.println();
        minMatrise.setTransposition();
        for(int i=0;i<minMatrise.getTransposition().length;i++){
            System.out.println(minMatrise.getTransposition()[i][0]+" "+minMatrise.getTransposition()[i][1]+" "+ minMatrise.getTransposition()[i][2]);
        }
    }
}


