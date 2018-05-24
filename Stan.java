
public class Stan {

    public int iloscOsobWBudynku = 0;

    public int iloscWlaman = 0;

    // true - właczone/otwarta       false - wyłaczone/zamkniete
    public boolean stDrzwi = false, stTylnichDrzwi = false, stZasilanie = false, stOgrzewanie = false, stKlimatyzacja = false;
    // TODO ustawic swiatla domyslnie na false!
    
    
    
    // 0 - zewnętrzne; 1 - kuchnia; 2 - korytarz; 3 - pokoj dziecka; 4 - sypialnia; 5 - salon
    public boolean[] stSwiatlo = new boolean[6];


    public int tempPowietrza = 22;

    public int zuzycieEnergi = 0;

    public void Stan() {
        // - Konstruktor pobiera obiekt z pliku stan.bin i podmienia wartosci ww. zmiennych
        // - jesli plik stan.bin nie istnieje to zostawia nie robi nic

        // TODO
    } //todo

    public void zapiszStan() {
        // TODO
    } //todo

    public void wlamanie() {
        // Po wywolaniu gasi swiatla i zamyka drzwi.
        // sprawdzic jak wplywa na przyciski
        iloscWlaman++;
        for (int i = 0; i < 6; i++) {
            stSwiatlo[i] = false;
        }
        stDrzwi = false;
        stTylnichDrzwi = false;

    }

    public void ustawTemp(int temp) {
        // ustawia temperature potwietrza tworzac nowy obiekt klimy/ogrzewania i zmieniajac jego status w obiekcie stan

        //usawienie stanu temperatury z parametru
        this.tempPowietrza=temp;
        
        
        if (temp == this.tempPowietrza) {

            stOgrzewanie = false;
            stKlimatyzacja = false;

        }
        Klimatyzacja klima = new Klimatyzacja();
        Grzejnik grzejnik = new Grzejnik();
        
        if (temp < this.tempPowietrza) {
            //wlącza klimatyzacje jesli jest wyłączona
            //wyłącza grzejnik jesli jest włączony
            if (!this.stKlimatyzacja) {
                klima.on(this);
            }

            if (this.stOgrzewanie) {
                grzejnik.off(this);
            }
        }
        
        if (temp > this.tempPowietrza) {
            // odwrotnie niz wyzej
            //
            if (!this.stOgrzewanie) {
                grzejnik.on(this);
            }

            if (this.stKlimatyzacja) {
                klima.off(this);
            }
        }
        
        
    }
    
    
    

}
