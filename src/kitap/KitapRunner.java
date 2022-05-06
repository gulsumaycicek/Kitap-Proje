package kitap;

public class KitapRunner {

    public static void main(String[] args) {
        KitapDatabase d = new KitapDatabase();
        d.kitapOlustur();
        Kitap k = new Kitap();
        k.kitapMenu();
    }
}
