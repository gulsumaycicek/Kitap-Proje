package kitap;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;




    public class Kitap extends KitapDatabase {


        static Scanner sc = new Scanner(System.in);
        private static final DecimalFormat df = new DecimalFormat("0.00");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");
        Date date = new Date();
        /*
         * ==================== PROJE==============================
         * bir kitapci icin program yazalim kitap no 1000'den baslayacak sirali no olsun program
         * baslayinca menu isminde bir method calissin
         * 1-kitap ekle
         * 2-numara ile kitap goruntule
         * 3-bilgi ile kitap goruntule
         * 4-numara ile kitap sil
         * 5-tum kitaplari listele
         * 6-cikis
         ************************************
         * 1.olarak her kitaba ait kitap no olacak, sonra kitap adi olacak, buna ait
         * yazar adi olacak ve kitap fiyati olacak bu bilgilerin tutulacagi bir yer
         * olmali yani bir list'te tutmamiz gerek
         * 2-kitap numarasi 1000'den
         * baslamali,her kitap eklendiginde bir artacagi icin sayac gibi dusunulebilinir
         * count=1000; menu isminde bir method olusturmaliyim,
         * 3-kitap ekle diye bir
         * method olusturmliyim,bu method farkli bir classda
         * 4-kullanicidn kitap adi
         * yazar adi ve fiyat bilgileri istenmeli
         */
        // Kitapcı_KitapEkle kitap = new Kitapcı_KitapEkle();

        String yazar, kitapAdi, yayınevi, turu;
        int kitapNo;
        double fiyat;
        static double tutar;

        Kitap() {
        }

        Kitap(String yazar, String kitapAdi, double fiyat) {
            this.yazar = yazar;
            this.kitapAdi = kitapAdi;
            this.fiyat = fiyat;
        }

        Kitap(String kitapAdi, String yazar) {
            this.yazar = yazar;
            this.kitapAdi = kitapAdi;
        }

        Kitap(String kitapAdi, String yazar, String yayınevi, String turu, int kitapNo, double fiyat) {
            this.yazar = yazar;
            this.kitapAdi = kitapAdi;
            this.yayınevi = yayınevi;
            this.turu = turu;
            this.kitapNo = kitapNo;
            this.fiyat = fiyat;
            tumKitaplar.add(this);

            if (kitapNo > 1000 && kitapNo < 1006) {
                klasikler.add(this);
            } else if (kitapNo > 1005 && kitapNo < 1011) {
                gerilim.add(this);
            } else if (kitapNo > 1010 && kitapNo < 1016) {
                siir.add(this);
            } else if (kitapNo > 1015 && kitapNo < 1018) {
                felsefe.add(this);
            } else if (kitapNo > 1017 && kitapNo < 1021) {
                psikoloji.add(this);
            }
        }

        void kitapMenu() {
            System.out.println("========================\tJava Yayınevi\t==========================\nLütfen Yapmak İstediğiniz İşlemi Seçiniz.");
            System.out.println("Kitap Satın Almak İçin\t\t\t\t\t1\nKitap Eklemek İçin\t\t\t\t\t\t2\nMevcut Kitapları Listelemek İçin\t\t3\n");
            try {//Bu try-catch-finally block öğrenme amaçlı yapıldı.
                try {
                    switch (sc.nextInt()) {
                        case 1:
                            kitapSat();
                            break;
                        case 2:
                            kitapEkle();
                            break;
                        case 3:
                            kitapList();
                            break;
                        default:
                            System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                            kitapMenu();
                    }
                } catch (InputMismatchException e) {
                    String hata = sc.next();
                    throw new InputMismatchException();
                }
            } catch (Exception e) {
                System.out.println("Lütfen Rakam Giriniz");
                kitapMenu();
            }
        }

        private void kitapSat() {
            System.out.println("====================================================================");
            System.out.println("Satın Almak İstediğiniz Kitabın No'sunu Giriniz.[1000 ila 1020 Arasında No Girilebilir.]");
            int satKitNo = sc.nextInt();
            if (satKitNo < 1000 || satKitNo > 1020) {
                System.out.println("Lütfen 1000 ila 1020 Arasında No Giriniz.");
                kitapSat();
            } else {
                for (Kitap w : tumKitaplar) {
                    if (w.kitapNo == satKitNo) {
                        satılanKitaplar.add(new Kitap(w.kitapAdi, w.yazar, w.fiyat));
                        tutar += w.fiyat;
                        System.out.println("Satılan Kitaplar:\t" + w.kitapAdi + "\tYazarı :\t" + w.yazar);
                        tumKitaplar.remove(w);//Satılan kitap silindi.
                        break;
                    }
                }
                baskaIslemSor();
            }
        }

        void kitapEkle() {
            System.out.println("Kaç kitap eklemek istiyorsunuz?");
            int eklKitSayi = sc.nextInt();

            for (int i = 0; i < eklKitSayi; i++) {
                System.out.println("Lütfen " + (i + 1) + ". kitabın !!!SIRASIYLA!!! kitap adını ve yazarını giriniz.");
                eklenenKitaplar.add(new Kitap(sc.next(), sc.next()));
            }
            for (Kitap w : eklenenKitaplar) {
                System.out.println("Eklenen Kitap Adı : " + w.kitapAdi + "\t-\tYazarı : " + w.yazar);
            }
            baskaIslemSor();
        }

        private void kitapList() {
            System.out.println("Listelemek istediğiniz kategoriyi seçiniz.\nTüm Kitaplar\t1\nKlasikler\t\t2\nGerilim\t\t\t3\nŞiir\t\t\t4\nFelsefe\t\t\t5\nPsikoloji\t\t6\n");
            try {
                int sec = sc.nextInt();
                if (sec == 1) {
                    for (Kitap w : tumKitaplar) {
                        System.out.println(w.kitapNo + "\t\t" + w.fiyat + " TL" + "\t\t" + w.yazar + "\t\t\t\t\t" + w.kitapAdi);
                    }
                    baskaIslemSor();
                } else if (sec == 2) {
                    for (Kitap w : klasikler) {
                        System.out.println(w.kitapNo + "\t\t" + w.fiyat + " TL" + "\t\t" + w.yazar + "\t\t\t\t\t" + w.kitapAdi);
                    }
                    baskaIslemSor();
                } else if (sec == 3) {
                    for (Kitap w : gerilim) {
                        System.out.println(w.kitapNo + "\t\t" + w.fiyat + " TL" + "\t\t" + w.yazar + "\t\t\t\t\t" + w.kitapAdi);
                    }
                    baskaIslemSor();
                } else if (sec == 4) {
                    for (Kitap w : siir) {
                        System.out.println(w.kitapNo + "\t\t" + w.fiyat + " TL" + "\t\t" + w.yazar + "\t\t\t\t\t" + w.kitapAdi);
                    }
                    baskaIslemSor();
                } else if (sec == 5) {
                    for (Kitap w : felsefe) {
                        System.out.println(w.kitapNo + "\t\t" + w.fiyat + " TL" + "\t\t" + w.yazar + "\t\t\t\t\t" + w.kitapAdi);
                    }
                    baskaIslemSor();
                } else if (sec == 6) {
                    for (Kitap w : psikoloji) {
                        System.out.println(w.kitapNo + "\t\t" + w.fiyat + " TL" + "\t\t" + w.yazar + "\t\t\t\t\t" + w.kitapAdi);
                    }
                    baskaIslemSor();
                }
            } catch (InputMismatchException e) {
                String ht = sc.next();
                System.out.println("Lütfen Rakam Giriniz.");
                kitapList();
            }
        }

        private void baskaIslemSor() {
            System.out.println("Başka bir işlem yapmak istiyor musunuz?");
            System.out.print("Devam etmek için 1,\t çıkış yapmak için 2 ye basınız. ");
            try {
                int secim = sc.nextInt();
                if (secim == 1) {
                    kitapMenu();
                } else if (secim == 2) {
                    cıkıs();
                } else {
                    System.out.println("Hatalı giriş yaptınız tekrar deneyiniz : ");
                    baskaIslemSor();
                }
            } catch (InputMismatchException e) {
                String h2 = sc.nextLine();
                System.out.println("Lütfen Rakam Giriniz");
                baskaIslemSor();
            }
        }

        private void cıkıs() {
            System.out.println("========================\tJava Yayınevi\t==========================");
            System.out.println("Tarih ve Saat :\t\t\t\t\t\t" + dateFormat.format(date));
            System.out.println("\t\t\t\tYaptığınız İşlemler");
            System.out.println("\t\t\t  ========================");
            if (eklenenKitaplar.size() > 0) {
                System.out.println("\t\t\t\tEklenen Kitaplar");
                for (Kitap w : eklenenKitaplar)
                    System.out.println("Eklediğiniz Kitap :\t" + w.kitapAdi + "\tYazarı :\t" + w.yazar);
            }
            if (satılanKitaplar.size() > 0) {
                System.out.println("\t\t\t\tSatılan Kitaplar");
                for (Kitap w : satılanKitaplar) {
                    System.out.println("Satış Fiyatı :\t" + w.fiyat + "\tKitap :\t" + w.kitapAdi + "\t-\t" + w.yazar);
                }
                System.out.println("\t\t\t\tÖdeme Bilgileri");
                System.out.println("Toplam Tutar :\t" + df.format(tutar) + " TL");
            }
            System.out.println("====================================================================");
        }

    }

