import java.util.List;

public class Main {

    public static void main(String[] args) {

        String adayDosyasi="C:\\Users\\aliba\\Desktop\\JavaP\\InputData\\Excel1.xlsx";
        String adayDosyasi2="C:\\Users\\aliba\\Desktop\\JavaP\\InputData\\Excel2.xlsx";

        DosyaIslemleri dosyaIslemleri=new DosyaIslemleri();

        List<Employee> adayListe=null;
        List<Employee> adayListe2=null;
        List<Employee> contactListe=null;

        adayListe=dosyaIslemleri.dosyaAl(adayDosyasi);
        adayListe2=dosyaIslemleri.dosyaAl(adayDosyasi2);
        ListeIslemleri listeIslemleri=new ListeIslemleri();
        contactListe=listeIslemleri.compareList(adayListe,adayListe2);

        dosyaIslemleri.listeyiYaz(contactListe);
        System.out.println("karsilastirma excelle rapor edildi.");
    }
}
