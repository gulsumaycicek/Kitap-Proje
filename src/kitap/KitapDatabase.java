package kitap;

import java.util.ArrayList;
import java.util.List;

public class KitapDatabase {


    static List<Kitap> tumKitaplar = new ArrayList<Kitap>();
    static List<Kitap> klasikler = new ArrayList<Kitap>();
    static List<Kitap> gerilim = new ArrayList<Kitap>();
    static List<Kitap> siir = new ArrayList<Kitap>();
    static List<Kitap> psikoloji = new ArrayList<Kitap>();
    static List<Kitap> felsefe = new ArrayList<Kitap>();

    static List<Kitap> eklenenKitaplar = new ArrayList<>();
    static List<Kitap> satılanKitaplar = new ArrayList<>();



    void kitapOlustur() {
        Kitap k1= new Kitap("Faust", "J.W. Goethe", "İletişim Yayınevi", "Roman", 1001, 35.25);
        Kitap k2= new Kitap("Suç ve Ceza", "Dostoyevski","İletişim Yayınevi", "Roman", 1002, 75.23 );
        Kitap k3= new Kitap("Anna Karenina", "Lev Tolstoy", "YKY", "Roman", 1003, 56.13);
        Kitap k4= new Kitap("Hamlet", "Shakespeare", "İş Bankası Yayınları", "Tiyatro", 1004, 27.95);
        Kitap k5= new Kitap("Ana", "M. Gorki", "Can Yayınevi", "Roman", 1005, 46.85);
        Kitap k6= new Kitap("Yabancı", "St. King", "Can Yayınevi", "Gerilim", 1006, 25.61);
        Kitap k7= new Kitap("Hedef", "A.Christie", "İletişim Yayınevi", "Gerilim", 1007, 58.74);
        Kitap k8= new Kitap("Doğu Ekspresi Cinayeti", "A.Christie", "İletişim Yayınevi", "Gerilim", 1008, 36.58);
        Kitap k9= new Kitap("Küllerin Günü", "J.C.Grange", "İş Bankası Yayınları", "Gerilim", 1009, 25.45);
        Kitap k10= new Kitap("Kaiken", "J.C.Grange", "İş Bankası Yayınları", "Gerilim", 1010,41.26);
        Kitap k11= new Kitap("Reading Zindanı Baladı", "Oscar Wild", "İş Bankası Yayınları", "Şiir", 1011, 25.48);
        Kitap k12= new Kitap("Bütün Şiirleri", "E. A. Poe", "İletişim Yayınevi", "Şiir", 1012, 27.45 );
        Kitap k13= new Kitap("Kötülük Çiçekleri", "Baudelaire", "Can Yayınevi", "Şiir", 1013,36.45 );
        Kitap k14= new Kitap("Mutlu Aşk Yoktur", "L.Aragon", "Can Yayınevi", "Şiir", 1014, 32.48);
        Kitap k15= new Kitap("Obras", "P.Neruda", "İletişim Yayınevi","Şiir", 1015, 85.47);
        Kitap k16= new Kitap("Devlet", "Platon", "İletişim Yayınevi", "Felsefe", 1016, 75.46);
        Kitap k17= new Kitap("Aforizmalar",  "Nietzsche", "İletişim Yayınevi", "Felsefe", 1017, 65.48 );
        Kitap k18= new Kitap("Eşzamanlılık", "C.G.Jung", "Can Yayınevi", "Psikoloji", 1018, 25.47);
        Kitap k19= new Kitap("İçimizdeki Çocuk", "D.Cüceoğlu", "Can Yayınevi", "Psikoloji", 1019, 47.36);
        Kitap k20= new Kitap("Bilinçaltı", "S. Freud","Can Yayınevi", "Psikoloji", 1020, 85.69);

    }
}
