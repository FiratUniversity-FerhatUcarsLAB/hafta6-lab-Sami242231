Ad Soyad:Sami Yusuf Yıldız
Öğrenci No:250541081
public class SiparisSistemi {

    // 1. Ana yemek fiyatı
    public static double getMainDishPrice(int secim) {
        switch(secim) {
            case 1: return 85; // Izgara Tavuk
            case 2: return 120; // Adana Kebap
            case 3: return 110; // Levrek
            case 4: return 65; // Mantı
            default: return 0;
        }
    }

    // 2. Başlangıç fiyatı
    public static double getAppetizerPrice(int secim) {
        switch(secim) {
            case 1: return 25; // Çorba
            case 2: return 45; // Humus
            case 3: return 55; // Sigara Böreği
            default: return 0; // Seçim yok
        }
    }

    // 3. İçecek fiyatı
    public static double getDrinkPrice(int secim) {
        switch(secim) {
            case 1: return 15; // Kola
            case 2: return 12; // Ayran
            case 3: return 35; // Meyve Suyu
            case 4: return 25; // Limonata
            default: return 0; // Seçim yok
        }
    }

    // 4. Tatlı fiyatı
    public static double getDessertPrice(int secim) {
        switch(secim) {
            case 1: return 65; // Künefe
            case 2: return 55; // Baklava
            case 3: return 35; // Sütlaç
            default: return 0; // Seçim yok
        }
    }

    // 5. Combo kontrolü
    public static boolean isComboOrder(double ana, double icecek, double tatli) {
        return ana > 0 && icecek > 0 && tatli > 0;
    }

    // 6. Happy Hour kontrolü
    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    // 7. İndirim hesapla
    public static double calculateDiscount(double araToplam, boolean combo, boolean ogrenci, int saat, double icecek) {
        double indirim = 0;

        if(combo) {
            indirim += araToplam * 0.15; // %15 combo
        }

        if(isHappyHour(saat)) {
            indirim += icecek * 0.20; // İçecek %20
        }

        if(ogrenci) {
            indirim += (araToplam - indirim) * 0.10; // %10 öğrenci
        }

        if(araToplam >= 200) {
            indirim += (araToplam - indirim) * 0.10; // %10 üst limit
        }

        return indirim;
    }

    // 8. Bahşiş önerisi
    public static double calculateServiceTip(double toplam) {
        return toplam * 0.10; // %10 öneri
    }

    public static void main(String[] args) {
        // Örnek girdi:
        int anaSecim = 2;       // Adana Kebap - 120 TL
        int basSecim = 2;       // Humus - 45 TL
        int icecekSecim = 3;    // Meyve Suyu - 35 TL
        int tatliSecim = 1;     // Künefe - 65 TL
        int saat = 15;           // Happy Hour
        boolean ogrenci = true;  // Öğrenci mi?
        int gun = 3;             // Çarşamba

        double ana = getMainDishPrice(anaSecim);
        double bas = getAppetizerPrice(basSecim);
        double icecek = getDrinkPrice(icecekSecim);
        double tatli = getDessertPrice(tatliSecim);

        double araToplam = ana + bas + icecek + tatli;
        boolean combo = isComboOrder(ana, icecek, tatli);

        double indirim = calculateDiscount(araToplam, combo, ogrenci, saat, icecek);
        double toplam = araToplam - indirim;
        double bahsis = calculateServiceTip(toplam);

        System.out.println("=== Sipariş Detayları ===");
        System.out.println("Ara Toplam: " + araToplam + " TL");
        System.out.println("Combo indirimi: " + (combo ? "%15" : "%0") + " → -" + (combo ? araToplam*0.15 : 0));
        System.out.println("Happy Hour (içecek) indirimi: %20 → -" + (isHappyHour(saat) ? icecek*0.20 : 0));
        System.out.println("Öğrenci indirimi: %10 → -" + (ogrenci ? (araToplam - (combo?araToplam*0.15:0) - (isHappyHour(saat)?icecek*0.20:0))*0.10 : 0));
        System.out.println("Toplam: " + String.format("%.2f", toplam) + " TL");
        System.out.println("Bahşiş önerisi: " + String.format("%.2f", bahsis) + " TL (%10)");
    }
    }
=== Sipariş Detayları ===
Ara Toplam: 265.0 TL
Combo indirimi: %15 → -39.75
Happy Hour (içecek) indirimi: %20 → -7.0
Öğrenci indirimi: %10 → -21.83
Toplam: 196.42 TL
Bahşiş önerisi: 19.64 TL (%10)
