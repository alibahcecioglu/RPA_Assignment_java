import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class DosyaIslemleri {
    private String adi;
    private String soyadi;
    private String dTarihi;
    private String dYeri;
    private String mail;
    private String telefon;
    private String durum;
    private String calismaDurumu;
    private String universite;
    private String check;
    public List<Employee> dosyaAl(String path)  {
        FileInputStream file=null;
        Iterator<Row> rowIterator=null;
        Sheet sheet=null;
        try {
            file = new FileInputStream(new File(path));
            Workbook wb = new XSSFWorkbook(file);
            sheet = wb.getSheetAt(0);
            rowIterator = sheet.rowIterator();
        }catch(Exception ex){
            System.out.println(ex);
        }
        List<Employee> employeeList = new ArrayList<>();
        Row row = rowIterator.next();
        check=sheet.getRow(0).getCell(3).toString();
               if (check.equals("MAİL")){
                 while (rowIterator.hasNext()) {
                    row = rowIterator.next();

                   adi = row.getCell(0).toString();
                   soyadi = row.getCell(1).toString();
                   dTarihi = row.getCell(2).toString();
                   mail = row.getCell(3).toString();
                   telefon = row.getCell(4).toString();
                   durum = row.getCell(5).toString();


                     Employee employee = new Employee();
                     employee.setAdi(adi);
                     employee.setSoyadi(soyadi);
                     employee.setdTarihi(dTarihi);
                     employee.setdYeri(dYeri);
                     employee.setMail(mail);
                     employee.setTelefon(telefon);
                     employee.setDurum(durum);
                     employee.setCalismaDurumu(calismaDurumu);
                     employee.setUniversite(universite);

                     employeeList.add(employee);

                 }
                }else {
                 while (rowIterator.hasNext()) {
                     row = rowIterator.next();
                    adi = row.getCell(0).toString();
                    soyadi = row.getCell(1).toString();
                    dTarihi = row.getCell(2).toString();
                    dYeri = row.getCell(3).toString();
                    mail = row.getCell(4).toString();
                    telefon = row.getCell(5).toString();
                    calismaDurumu = row.getCell(6).toString();
                    universite = row.getCell(7).toString();

                     Employee employee = new Employee();
                     employee.setAdi(adi);
                     employee.setSoyadi(soyadi);
                     employee.setdTarihi(dTarihi);
                     employee.setdYeri(dYeri);
                     employee.setMail(mail);
                     employee.setTelefon(telefon);
                     employee.setDurum(durum);
                     employee.setCalismaDurumu(calismaDurumu);
                     employee.setUniversite(universite);

                     employeeList.add(employee);
                 }
            }

        return employeeList;
    }
    public void listeyiYaz(List<Employee> liste){

        try
        {
            String filename = "C:\\Users\\aliba\\Desktop\\JavaP\\OutputData\\Rapor.xlsx";

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Contact");

            Row row = sheet.createRow((short)0);
            row.createCell(0).setCellValue("AD");
            row.createCell(1).setCellValue("SOYAD");
            row.createCell(2).setCellValue("DOĞUM TARİHİ");
            row.createCell(3).setCellValue("DOĞUM YERİ");
            row.createCell(4).setCellValue("MAİL");
            row.createCell(5).setCellValue("TELEFON");
            row.createCell(6).setCellValue("DURUM");
            row.createCell(7).setCellValue("ÇALIŞMA DURUMU");
            row.createCell(8).setCellValue("ÜNİVERSİTE");


            for(int i=0;i<liste.size();i++) {
                row = sheet.createRow((short)(i+1));

                row.createCell(0).setCellValue(liste.get(i).getAdi());
                row.createCell(1).setCellValue(liste.get(i).getSoyadi());
                row.createCell(2).setCellValue(liste.get(i).getdTarihi());
                row.createCell(3).setCellValue(liste.get(i).getdYeri());
                row.createCell(4).setCellValue(liste.get(i).getMail());
                row.createCell(5).setCellValue(liste.get(i).getTelefon());
                row.createCell(6).setCellValue(liste.get(i).getDurum());
                row.createCell(7).setCellValue(liste.get(i).getCalismaDurumu());
                row.createCell(8).setCellValue(liste.get(i).getUniversite());



            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

}