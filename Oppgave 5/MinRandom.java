import java.util.Random;
public class MinRandom {
    private Random random = new Random();
    public int nesteHeltall(int nedre, int ovre){
        return nedre + random.nextInt(ovre-nedre);
    }

    public double nesteDesimaltall(double nedre, double ovre){
        return nedre + random.nextDouble()*(ovre-nedre);
    }
}

class Main{
    public static void main(String[] args) {
        MinRandom tilfeldig = new MinRandom();
        for(int i = 0;i<100;i++){
            //System.out.println(tilfeldig.nesteDesimaltall(1.0, 3.0));
            System.out.println(tilfeldig.nesteHeltall(5, 50));
        }
    }
}
