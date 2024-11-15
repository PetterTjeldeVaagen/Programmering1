import java.util.ArrayList;
import java.util.Scanner;

public class PropertyRegister {
    public ArrayList<Property> registeredProperties = new ArrayList<Property>();

    public void SearchForProperty(){
        Scanner scannerSearchAll = new Scanner(System.in);
        System.out.println("Hva er kommunenummeret?");
        int countyNumber = scannerSearchAll.nextInt(); 
        System.out.println("Hva er gårdsnummeret?");
        int lotNumber = scannerSearchAll.nextInt();
        System.out.println("Hva er bruksnummeret?");
        int sectionNumber = scannerSearchAll.nextInt();
        String searchID = countyNumber+"-"+lotNumber+"/"+sectionNumber;

        //sjekker om id verdiene i listen er like id-en som brukeren lager så printer den ut info om den gården
        for(int i = 0; i<registeredProperties.size();i++){
            String checkID = registeredProperties.get(i).getPropertyId();
            if(searchID.equals(checkID)){
                System.out.println("Bruksnummer: " + registeredProperties.get(i).getLotNumber() + " som er eid av "+ registeredProperties.get(i).getOwnerName() + " har likt nummer");
            }
        }
    }

    public void RegisterProperty(int countyNumber, String countyName, int lotNumber, int sectionNumber, String name, String ownerName, double area){
        registeredProperties.add(new Property(countyNumber, countyName, lotNumber, sectionNumber, name, ownerName, area));
    }

    public void DeleteProperty(){
        int propertyIndex = 0;

        //skriver ut alle eiendomer
        System.out.println("Hvilken eiendom skal slettes?");
        for(int i = 0; i<this.registeredProperties.size();i++){
            System.out.println(i+". Bruksnummer: " + registeredProperties.get(i).getSectionNumber());
        }

        //sletter index som bruker velger
        System.out.println("\n Velg et tall mellom 0 og " + (this.registeredProperties.size()-1)+".\n");
        Scanner sc = new Scanner(System.in);
        propertyIndex = sc.nextInt();
        this.registeredProperties.remove(propertyIndex);
    }

    public int PrintPropertyAmount(){
        return registeredProperties.size();
    }

    public double FindAverageArea(){
        double totalArea = 0;
        //regner ut det totale areal og deler så det på antall eiendommer
        for(int i=0;i<this.registeredProperties.size();i++){
            totalArea+=this.registeredProperties.get(i).getArea();
        }
        return (totalArea/this.registeredProperties.size());
    }

    public void SearchByLotNumber(){
        System.out.println("\n Søk i eiendommer med gårdsnummer \n");
        Scanner scannerSearch = new Scanner(System.in);
        int lotNumberSearch = scannerSearch.nextInt();

        //sjekker gjennom alle eiendomer og skriver ut Bruksnummer og eiernavn for de med riktig gårdsnummer
        for(int i = 0; i<this.registeredProperties.size();i++){
            if(this.registeredProperties.get(i).lotNumber==lotNumberSearch){
                System.out.println("Bruksnummer: " + this.registeredProperties.get(i).getSectionNumber() + " som er eid av " + this.registeredProperties.get(i).getOwnerName());
            }
        }
    }

    public void PrintAllProperties(){
        for(int i = 0;i<this.registeredProperties.size();i++){
            Property currentProperty = this.registeredProperties.get(i);
            System.out.println(" Kommunenummer: " + currentProperty.getCountyNumber() + 
                                " | Kommunenavn: " + currentProperty.getCountyName() + 
                                " | Gårdsnummer: " + currentProperty.getLotNumber() + 
                                " | Bruksnummer: " +currentProperty.getSectionNumber() + 
                                " | Bruksnavn: " +currentProperty.getName() + 
                                " | Areal: " + currentProperty.getArea() + 
                                " | Eier navn: " + currentProperty.getOwnerName());
        }
    }
}

