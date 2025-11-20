Ad Soyad:Sami Yusuf Yıldız
Öğrenci No:250541081
public class SinemaBileti {

    // 1. Hafta sonu kontrolü
    public static boolean isWeekend(int gun) {
        return (gun == 6 || gun == 7); // 6=Cmt, 7=Paz
    }

    // 2. Matine kontrolü
    public static boolean isMatinee(int saat) {
        return saat < 12;
    }

    // 3. Temel fiyat hesapla
    public static double calculateBasePrice(int gun, int saat) {
        if (isWeekend(gun)) {
            if (isMatinee(saat)) return 55;
            else return 85;
        } else {
            if (isMatinee(saat)) return 45;
            else return 65;
        }
    }

    // 4. İndirim hesapla
    public static double calculateDiscount(int yas, int meslek, int gun) {
        double discount = 0;

        // 65+ yaş indirimi
        if (yas >= 65) discount = 0.30;

        // 12 yaş altı indirimi
        else if (yas < 12) discount = 0.25;

        else {
            switch (meslek) {
                case 1: // Öğrenci
                    if (gun >= 1 && gun <= 4) discount = 0.20; // Pzt-Per
                    else discount = 0.15; // Cuma-Paz
                    break;
                case 2: // Öğretmen
                    if (gun == 3) discount = 0.35; // Çarşamba
                    break;
                default:
                    discount = 0;
            }
        }
        return discount;
    }

    // 5. Film türü ekstra ücreti
    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 2: return 25; // 3D
            case 3: return 35; // IMAX
            case 4: return 50; // 4DX
            default: return 0; // 2D
        }
    }

    // 6. Toplam fiyat hesapla
    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
        double basePrice = calculateBasePrice(gun, saat);
        double discount = calculateDiscount(yas, meslek, gun);
        double formatExtra = getFormatExtra(filmTuru);

        double discountedPrice = basePrice * (1 - discount);
        return discountedPrice + formatExtra;
    }

    // 7. Bilet bilgisi oluştur
    public static String generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {
        double basePrice = calculateBasePrice(gun, saat);
        double discount = calculateDiscount(yas, meslek, gun);
        double discountedPrice = basePrice * (1 - discount);
        double extra = getFormatExtra(filmTuru);
        double total = discountedPrice + extra;

        return "=== Bilet Bilgisi ===\n" +
                "Gün: " + gun + "\n" +
                "Saat: " + saat + "\n" +
                "Yaş: " + yas + "\n" +
                "Meslek: " + (meslek==1?"Öğrenci": meslek==2?"Öğretmen":"Diğer") + "\n" +
                "Film Türü: " + (filmTuru==1?"2D": filmTuru==2?"3D": filmTuru==3?"IMAX":"4DX") + "\n" +
                "Temel Fiyat: " + basePrice + " TL\n" +
                "İndirim: %" + (discount*100) + " → " + (basePrice*discount) + " TL\n" +
                "İndirimli Fiyat: " + discountedPrice + " TL\n" +
                "Film Ekstra: +" + extra + " TL\n" +
                "Toplam: " + total + " TL";
    }

    public static void main(String[] args) {
        // Örnek girdi: Perşembe, 10:00, 22 yaş, öğrenci, 3D
        int gun = 4;       // Perşembe
        int saat = 10;     
        int yas = 22;
        int meslek = 1;    // Öğrenci
        int filmTuru = 2;  // 3D

        System.out.println(generateTicketInfo(gun, saat, yas, meslek, filmTuru));
    }
  }
=== Bilet Bilgisi ===
Gün: 4
Saat: 10
Yaş: 22
Meslek: Öğrenci
Film Türü: 3D
Temel Fiyat: 45 TL
İndirim: %20.0 → 9.0 TL
İndirimli Fiyat: 36.0 TL
Film Ekstra: +25 TL
Toplam: 61.0 TL
