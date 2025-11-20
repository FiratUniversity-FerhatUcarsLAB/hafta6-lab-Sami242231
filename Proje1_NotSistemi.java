Adı Soyadı:Sami Yusuf Yıldız
Öğrenci No:250541081
public class NotDegerlendirme {

    public static double calculateAverage(double vize, double finalNot, double odev) {
        return vize * 0.30 + finalNot * 0.40 + odev * 0.30;
    }

    public static boolean isPassingGrade(double ortalama) {
        return ortalama >= 50;
    }

    public static String getLetterGrade(double ortalama) {
        if (ortalama >= 90) return "A";
        else if (ortalama >= 80) return "B";
        else if (ortalama >= 70) return "C";
        else if (ortalama >= 60) return "D";
        else return "F";
    }

    public static boolean isHonorList(double ortalama, double vize, double finalNot, double odev) {
        return ortalama >= 85 && vize >= 70 && finalNot >= 70 && odev >= 70;
    }

    public static boolean hasRetakeRight(double ortalama) {
        return ortalama >= 40 && ortalama < 50;
    }

    public static void main(String[] args) {
        double vize = 80;
        double finalNot = 90;
        double odev = 95;

        double ortalama = calculateAverage(vize, finalNot, odev);

        System.out.println("=== DETAYLI NOT RAPORU ===");
        System.out.println("Vize: " + vize);
        System.out.println("Final: " + finalNot);
        System.out.println("Ödev: " + odev);
        System.out.println("Ortalama: " + ortalama);

        System.out.println("Durum: " + (isPassingGrade(ortalama) ? "GEÇTİ" : "KALDI"));
        System.out.println("Harf Notu: " + getLetterGrade(ortalama));
        System.out.println("Onur Listesi: " + (isHonorList(ortalama, vize, finalNot, odev) ? "EVET" : "HAYIR"));
        System.out.println("Bütünleme Hakkı: " + (hasRetakeRight(ortalama) ? "VAR" : "YOK"));
    }
}
=== DETAYLI NOT RAPORU ===
Vize: 80
Final: 90
Ödev: 95

Ortalama: 88.5
Durum: GEÇTİ
Harf Notu: B
Onur Listesi: EVET
Bütünleme Hakkı: YOK
