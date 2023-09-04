
/**
* @author ESA
* @since May,2023
*/

package pdproje3;


import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
     Oyun oyun=new Oyun();//Oyun sinifinin nesnesi olusturuluyor.
     

     System.out.println("Lutfen Sayilari Tek Satirda Bosluk Birakarak Giriniz!");
     Scanner sc=new Scanner(System.in);//Kullanicidan degerleri almak icin scanner sinifinin nesnesi olusturuluyor.
     String str=sc.nextLine();
     String srtArr[]=str.split(" ");//alinan degerlerin bosluklara gore ayrılıp diziye aktarilmasi
     int []arr=new int[srtArr.length];//integer dizi tanimlanmasi
     for (int i=0;i< srtArr.length;i++)
     {
         arr[i]=Integer.parseInt(srtArr[i]);//'srtArr' dizisi icerisindeki degerlerin int degerleri donusturulmesi
     }
     oyun.RounduGerceklestir(arr);// olusan integer dizisinin 'oyun' nesnesinin 'RounduGerceklestir' fonksiyonuna parametre olarak gonderilmesi.
    }
}
