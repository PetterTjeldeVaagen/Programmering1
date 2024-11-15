public class Property {
    int countyNumber;
    String countyName;
    int lotNumber;
    int sectionNumber;
    String name;
    String ownerName;
    double area;
    
    //Konstruktør med alle parameterne for en eiendom
    public Property(int countyNumberIn, String countyNameIn, int lotNumberIn, int sectionNumberIn, String nameIn, String ownerNameIn, double areaIn){
        this.countyNumber=countyNumberIn;
        this.countyName=countyNameIn;
        this.lotNumber=lotNumberIn;
        this.sectionNumber=sectionNumberIn;
        this.name=nameIn;
        this.ownerName=ownerNameIn;
        this.area=areaIn;
    }

    //Gettere for samtlige variabler
    public int getCountyNumber() {
        return countyNumber;
    }

    public String getCountyName() {
        return countyName;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getArea() {
        return area;
    }

    //Settere for navn, eiernavn og areal
    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public void setOwnerName(String ownerNameIn) {
        this.ownerName = ownerNameIn;
    }

    public void setArea(double areaIn) {
        this.area = areaIn;
    }

    public String getPropertyId(){
        return this.countyNumber+"-"+this.lotNumber+"/"+this.sectionNumber;
    }
}
