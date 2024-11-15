import java.util.Scanner;

public class Main { 
    public static void main(String[] args){
        PropertyRegister properties = new PropertyRegister();
        properties.RegisterProperty(1445, "Gloppen", 77, 631, "", "Jens Olsen", 1017.6);
        properties.RegisterProperty(1445, "Gloppen", 77, 131, "Syningom", "Nicolay Madsen", 661.3);
        properties.RegisterProperty(1445, "Gloppen", 75, 19, "Fugletun", "Evilyn Jensen", 650.6);
        properties.RegisterProperty(1445, "Gloppen", 74, 188, "", "Karl Ove Bråten", 1457.2);
        properties.RegisterProperty(1445, "Gloppen", 69, 47, "Høiberg", "Elsa Indregård", 1339.4);
        
        while(true){
            //hovedmeny
            int menuChoice = 0;
            System.out.println("\n***** Eiendomsregister *****\n");
            System.out.println("1. Legg til ny eiendom");
            System.out.println("2. Slett en eiendom");
            System.out.println("3. Søk etter eiendom");
            System.out.println("4. Finn gjennomsnittsarealet");
            System.out.println("5. Finn antall eiendommer");
            System.out.println("6. Søk med gårdnummer");
            System.out.println("7. Skriv ut alle eiendommer");
            System.out.println("8. Quit");
            System.out.println("\n Velg et tall mellom 1 og 8.\n");
            Scanner sc = new Scanner(System.in);
            menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("Hva er kommunenummeret?");
                    int countyNumber = sc.nextInt();
                    System.out.println("Hva er navnet til kommunen?");
                    String countyName = sc.next();
                    System.out.println("Hva er gårdsnummeret?");
                    int lotNumber = sc.nextInt();
                    System.out.println("Hva er bruksnummeret?");
                    int sectionNumber = sc.nextInt();
                    System.out.println("Hva er bruksnavnet til eiendommen?");
                    String name = sc.next();
                    System.out.println("Hva er navnet til eieren?");
                    String ownerName = sc.next();
                    System.out.println("Hva er arealet til eiendommen(m^2)?");
                    double area = sc.nextDouble();
                    properties.RegisterProperty(countyNumber, countyName, lotNumber, sectionNumber, name, ownerName, area);
                    break;
                case 2:
                    properties.DeleteProperty();
                    break;
                case 3:
                    properties.SearchForProperty();
                    break;
                case 4:
                    System.out.println("Gjennomsnitts arealet er: "+properties.FindAverageArea() + "m^2");
                    break;
                case 5:
                    System.out.println("Det er totalt: " + properties.PrintPropertyAmount()+" eiendommer");
                    break;
                case 6:
                    properties.SearchByLotNumber();
                    break;
                case 7:
                    properties.PrintAllProperties();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}
