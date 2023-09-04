/**
* @author ESA
* @since May,2023
*/
package pdproje3;
import java.lang.Math;

public class aTaktik extends Taktik{// A Taktik Sinifinin tanimlanmasi
    @Override
    public int Savas() {// Taktik sinifinin savas fonksiyonun tanimlanmasi.
       int min=150;
       int max=1000;
       int rand=(int)Math.floor(Math.random()*(max-min+1)+min);//%15 sansli olarak 150-1000 arasinda random sayi uretiyor
    return rand;//random uretilen sayinin dondurulmesi
    }
}