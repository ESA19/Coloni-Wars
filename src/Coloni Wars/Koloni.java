/**
* @author ESA
* @since May,2023
*/

package pdproje3;

import java.lang.Math;

public class Koloni {
    public int populasyon;
    public int yemekStogu;
    public int Kazanma;
    public int Kaybetme ;
    public  char sembol;
    public  int uretimTuru;
    public  int taktikTuru;

    public Koloni(int sayi){//Koloni sinifinin kurucusunun ve diger degiskenlerin atanmasi
        sembol=SembolBul();
        Kazanma=0;
        Kaybetme=0;
        populasyon=sayi;
        yemekStogu=sayi*sayi;
        taktikTuru=savasTaktikleriniAta();
        uretimTuru=uretimTaktikleriniAta();
    }
    public char SembolBul(){// Koloni sinifinin sembol bul fonksiyonu tanimlaniyor.
        char []symbolArray={'\u2022','\u2023','\u00B0','\u221E','\u0024','\u20AC','\u00A3','\u00A2','\u20B1','\u20A9','\u20AA','\u00A9','\u00AE','\u2117',
                '\u25A0','\u25A1','\u25A2','\u25A3','\u25A4','\u25A5','\u25A6','\u25A7','\u25A8','\u25A9','\u25AA','\u25AB','\u25AC','\u25AD','\u25AE','\u25AF',
                '\u25B0','\u25B1','\u25B2','\u25B3','\u25B4','\u25B5','\u25B6','\u25B7','\u25B8','\u25B9','\u25BA','\u25BB','\u25BC','\u25BD','\u25BE','\u25BF',
                '\u25C0','\u25C1','\u25C2','\u25C3','\u25C4','\u25C5','\u25C6','\u25C7','\u25C8','\u25C9','\u25CA','\u25CB','\u25CC','\u25CD','\u25CE','\u25CF',};//sembollerin unicodunu iceren sembol arrayin tanimlanmasi
        int min=0;
        int max=60;
        int rand=(int)Math.floor(Math.random()*(max-min+1)+min);//'symbolArray' dizisinden rastgele bir eleman secmek icin 0-60 arasinda random sayi uretiliyor.
        sembol=symbolArray[rand];
        return sembol;//rastgele sembol donduruluyor.
    }
    public int savasTaktikleriniAta(){//olusan kolonilerin rastgele savas taktigi ataniyor.

        aTaktik ataktik=new aTaktik();//  a taktiginin nesnesi olusturluyor.
        bTaktik btaktik=new bTaktik();// b taktiginin nesnesi olusturuluyor.

        int b;
        int min=0;
        int max=1;
        int random=(int)Math.floor(Math.random()*(max-min+1)+min);

        if (random==0)
        {
            b=btaktik.Savas();
        }
        else{
            b=ataktik.Savas();
        }
        return b;//secilen taktik degeri donduruluyor.
    }
    public int uretimTaktikleriniAta(){//Olusan kolonilere rastgele uretim teknigi ataniyor.
        aUretim uretA=new aUretim();// a uretim tekniginin nesnesi olusturuluyor.
        bUretim uretb=new bUretim();// b uretim tekniginin nesnesi olusturuluyor.
        int a;
        int min=0;
        int max=1;
        int random=(int)Math.floor(Math.random()*(max-min+1)+min);
        if (random==0)
        {
            a=uretA.Uret();
        }
        else{
            a=uretb.Uret();
        }
        return a;//secilen uretim degeri donduruluyor.
    }
}
