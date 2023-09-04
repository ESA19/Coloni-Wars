
/**
* @author ESA
* @since May,2023
* 
*/
package pdproje3;

import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;

public class Oyun {// savaslarin yapilacagi oyun sinifi tanimlaniyor.
    int round = 1;
    int fark;//Kolonilerin urettikleri degerler arasindaki fark
    int yuzdeOrani = (fark) / 1000;//yuzde hesaplmasi
    boolean bit = true;
    List<String> Kaldiranlar = new ArrayList<String>();//Olen kolonilerin tutuldugu liste
    ArrayList<Koloni> list = new ArrayList<Koloni>();//Olusan kolonilerin tutuldugu liste
    Formatter fmt1=new Formatter();//istenilen formatta ekrana yazim icin

    public void RounduGerceklestir(int[] arr) {//savslarin ve ilgili atamalarin yapilacagi fonksiyon

        for (int i = 0; i < arr.length; i++) {//girilen sayi adedi kadar kolonini olusturulmasi ve 'list' adli listeye atanmasi
            Koloni k = new Koloni(arr[i]);
            list.add(k);
        }
        do {
            for (int i = 0; i <list.size() - 1; i++) {//cift dongu yapisiyla kolonilerin birbiri ile savasmasi saglaniyor.

                for (int j = i + 1; j < list.size(); j++) {

                    if (list.get(i).taktikTuru > list.get(j).taktikTuru) {//i. elemanin kazanma senaryosunda gerekli guncellemelerin yapilmasi
                        fark = list.get(i).taktikTuru - list.get(j).taktikTuru;
                        list.get(j).populasyon -= (list.get(j).populasyon * yuzdeOrani) / 100.0;
                        list.get(i).yemekStogu += (list.get(j).yemekStogu * yuzdeOrani) / 100.0;
                        list.get(j).yemekStogu -= (list.get(j).yemekStogu * yuzdeOrani) / 100.0;
                        list.get(i).Kazanma++;
                        list.get(j).Kaybetme++;
                    } else if (list.get(i).taktikTuru == list.get(j).taktikTuru) {//i. ve j. elemanin taktiklerinin esit olmasi durumunda.

                        if (list.get(i).populasyon > list.get(j).populasyon) {//i. elemanin populasyonunun j. elemanin populasyonundan buyuk oldugu durum.
                            fark = list.get(i).populasyon - list.get(j).populasyon;
                            list.get(j).populasyon -= (list.get(j).populasyon * yuzdeOrani) / 100.0;
                            list.get(i).yemekStogu += (list.get(j).yemekStogu * yuzdeOrani) / 100.0;
                            list.get(j).yemekStogu -= (list.get(j).yemekStogu * yuzdeOrani) / 100.0;
                            list.get(i).Kazanma++;
                            list.get(j).Kaybetme++;
                        } else if (list.get(i).populasyon == list.get(j).populasyon) {//i. elemanin populasyonu ile j. elemanin populasyonun esit olmasi durumunda rastgele birisinin kazanmasi.
                            int min = 0;
                            int max = 1;
                            int rand = (int) Math.floor(Math.random() * (max - min + 1) + min);
                            if (rand == 1) {
                                list.get(i).Kazanma++;
                                list.get(j).Kaybetme++;
                            } else {
                                list.get(j).Kazanma++;
                                list.get(i).Kaybetme++;
                            }
                        } else {//j. elemanin populasyonunun i. elemanin populasyonundan buyuk olmasi durumu.

                            fark = list.get(j).populasyon - list.get(i).populasyon;
                            list.get(i).populasyon -= (list.get(i).populasyon * yuzdeOrani) / 100.0;
                            list.get(j).yemekStogu += (list.get(i).yemekStogu * yuzdeOrani) / 100.0;
                            list.get(i).yemekStogu -= (list.get(i).yemekStogu * yuzdeOrani) / 100.0;
                            list.get(j).Kazanma++;
                            list.get(i).Kaybetme++;
                        }
                    } else {//j. elemanin taktik degerinin i. elemanin taktik degerinden buyuk olmasi durumu.
                        fark = list.get(j).taktikTuru - list.get(i).taktikTuru;
                        list.get(i).populasyon -= (list.get(i).populasyon * yuzdeOrani) / 100.0;
                        list.get(j).yemekStogu += (list.get(i).yemekStogu * yuzdeOrani) / 100.0;
                        list.get(i).yemekStogu -= (list.get(i).yemekStogu * yuzdeOrani) / 100.0;
                        list.get(j).Kazanma++;
                        list.get(i).Kaybetme++;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {// tur sonunda populasyon ve yemek sayilarinin guncellenmesi.
                list.get(i).populasyon += (list.get(i).populasyon * 20.0) / 100.0;
                list.get(i).yemekStogu -= (list.get(i).populasyon * 2.0);
                if (list.get(i).yemekStogu <= 0 || list.get(i).populasyon <= 0) {//olen kolonilerin  tespitinin saglanmasi

                    fmt1.format("%1s%15s%15s%15s%13s\n",list.get(i).sembol,"-----","-----","-----","-----");
                    Kaldiranlar.add(String.valueOf(fmt1));
                    list.remove(i);//olen kolonilerin 'list' adli listeden kaldirilmasi.
                }
            }
            Ekranayaz(list,Kaldiranlar,round);// Kolonilerin guncel degerlerinin ekrana yazdirilmasi.
            if (list.size()==1) {//'list' adli listede tek bir koloni kaldiginin tespiti. Tek bir koloni kaldiysa oyunun bitirilmesi.
                bit = false;
            }
            round++;//round sayisinin arttirilmasi.
        } while (bit);

    }
    public void Ekranayaz(List<Koloni>list,List<String>Kaldirilanlar,int round)//Olusan , olen listeleri ve round sayisini paramtre olarak alan 'Ekranayaz' fonskiyonu tanimlaniyor.
    {
        Formatter fmt=new Formatter();
        Formatter fmt2=new Formatter();//istenilen sekilde ekrana basmak icin ilgili nesnelerin olusturulmasi.
        System.out.println(round+".ROUND SONU");
        fmt2.format("%1s%15s%15s%12s%13s\n","Sembol","Populasyon","Yemek Stogu","Kazanma","Kaybetme");
        for (int i=0;i< list.size();i++)
        {
            fmt.format("%1s%15s%15s%15s%13s\n",list.get(i).sembol,list.get(i).populasyon,list.get(i).yemekStogu,list.get(i).Kazanma,list.get(i).Kaybetme);
        }
        System.out.println(fmt2);
        System.out.println(fmt);
        System.out.println(fmt1);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();

    }
}



