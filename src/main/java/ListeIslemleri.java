import java.util.ArrayList;
import java.util.List;

class ListeIslemleri{

    public List compareList(List<Employee> list1,List<Employee> list2){

        List<Employee> contactList = new ArrayList<>();

        for (int row=0;list1.size()>row;row++) {

            if ("".equals(list1.get(row).getTelefon()) || "".equals(list1.get(row).getMail())){
                System.out.println("Telefon ve Mail alanı boş oldugu icin karsilastirma yapilmadi");
            }else {
                Boolean areNamesMatch=compareField(list1.get(row).getAdi(),list2.get(row).getAdi());
                Boolean areSurnameMatch=compareField(list1.get(row).getSoyadi(),list1.get(row).getSoyadi());
                Boolean areMailMatch=compareField(list1.get(row).getMail(),list1.get(row).getMail());
                Boolean areTelMatch= compareField(list1.get(row).getTelefon(),list1.get(row).getTelefon());

                if (areNamesMatch && areSurnameMatch && (areMailMatch || areTelMatch))
                {
                    Employee employee = new Employee();
                    employee.setAdi(list1.get(row).getAdi());
                    employee.setSoyadi(list1.get(row).getSoyadi());
                    employee.setdTarihi(list1.get(row).getdTarihi());
                    employee.setdYeri(list2.get(row).getdYeri());
                    employee.setMail(list1.get(row).getMail());
                    employee.setTelefon(list1.get(row).getTelefon());
                    employee.setDurum(list1.get(row).getDurum());
                    employee.setCalismaDurumu(list2.get(row).getCalismaDurumu());
                    employee.setUniversite(list2.get(row).getUniversite());

                    contactList.add(employee);

                }else{
                    if (!areNamesMatch){
                        System.out.println("İsimler aynı değil : "+ list1.get(row).getAdi() + ","+list2.get(row).getAdi());
                    }
                    if (!areSurnameMatch){
                        System.out.println("Soyisimler aynı değil"+ list1.get(row).getSoyadi() + ","+list2.get(row).getSoyadi());
                    }
                    if (!areMailMatch){
                        System.out.println("Mailler aynı değil"+ list1.get(row).getMail() + ","+list2.get(row).getMail());
                    }
                    if (!areTelMatch){
                        System.out.println("Telefon aynı değil"+ list1.get(row).getTelefon() + ","+list2.get(row).getTelefon());
                    }

                }

            }

        }
        return contactList;
    }
    public boolean compareField(String field1,String field2){

        if (field1.equals(field2))
            return true;
        else {
            return false;
        }
    }
}
