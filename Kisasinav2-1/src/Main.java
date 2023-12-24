// Konutu tanımladığımız sınıf
class Konut {

    private EvSahibi evSahibi;
    private String adres;

    public Konut(EvSahibi evSahibi, String adres) {
        this.adres = adres;
        this.evSahibi = evSahibi;
    }

    public void displayInfo() {
        System.out.println("Konutun Adresi: " + adres);
        evSahibi.displayInfo();
    }
}


// Daireyi tanımladığımız sınıf
class Daire extends Konut { //Konuttan türettik
         private int daireNumarasi;

         public Daire(int daireNumarasi, EvSahibi evSahibi, String adres) {
        super(evSahibi, adres);
        this.daireNumarasi = daireNumarasi;
         }

    @Override
        public void displayInfo() {
        super.displayInfo();
        System.out.println("Daire Numarası: " + daireNumarasi);
        }
    }


    // Binayı tanımladığımız sınıf
    class Bina extends Konut {  //Konuttan türettik
         private int numberOfFloors;

        public Bina(String adres, EvSahibi evSahibi, int numberOfFloors) {
        super(evSahibi, adres);
        this.numberOfFloors = numberOfFloors;
        }

    @Override
        public void displayInfo() {
        super.displayInfo();
        System.out.println("Kat numarası: " + numberOfFloors);
        }
    }



// EvSahibini tanımladığımız sınıf
class EvSahibi {

    private Kiraci kiraci;
    private String ad;
    private String soyad;

    public void setKiraci(Kiraci kiraci) {
        this.kiraci = kiraci;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public EvSahibi(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public void displayInfo() {
        System.out.println("Ev Sahibinin adı " + ad + " soyadı " + soyad);
        if (kiraci != null) {
            System.out.println("Kiracının adı " + kiraci.getAd() + " soyadı " + kiraci.getSoyad());
        }
    }
}


// Kiracıyı tanımladığımız sınıf
class Kiraci {

    private EvSahibi evSahibi;
    private String ad;
    private String soyad;


    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }
    public Kiraci(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public void setEvSahibi(EvSahibi evSahibi) {
        this.evSahibi = evSahibi;
    }

    public void displayInfo() {
        System.out.println("Kiracının adı " + ad + " soyadı " + soyad);
        if (evSahibi != null) {
            System.out.println("Ev Sahibinin adı " + evSahibi.getAd() + " soyadı " + evSahibi.getSoyad());
        }
    }
}



//Bütün tanımlamaları birleştirdiğimiz ve fonksiyonlarını kullandığımız Ana sınıf
public class Main {
    public static void main(String[] args) {

        //Ev sahibi ve kiracının isimlerini yazdık
        EvSahibi evSahibi1 = new EvSahibi("Martha Louise", "HUDSON");
        Kiraci kiraci = new Kiraci("Sherlock", "HOLMES");

        evSahibi1.setKiraci(kiraci);
        kiraci.setEvSahibi(evSahibi1);

        Konut konut = new Konut(evSahibi1, "221 B Baker Street");
        konut.displayInfo();

        Bina bina = new Bina("221 B Baker Street",evSahibi1,2);
        bina.displayInfo();

        Daire daire = new Daire(221, evSahibi1,"221 B Baker Street");
        daire.displayInfo();

    }
}