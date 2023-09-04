/**
* @author ESA
* @since May,2023
*/
package pdproje3;
import java.lang.Math;

public class bTaktik extends Taktik{//B taktik sinifinin tanimlanmasi
    @Override
    public int Savas() {// Taktik sinifinin savas fonskiyonunun tanimlanmasi
        int min=200;
        int max=1000;
        int rand=(int)Math.floor(Math.random()*(max-min+1)+min);//%20 sansli olarak 200-1000 arasinda random sayi uretiliyor
        return rand; //uretilen random sayinin dondurulmesi
    }
}
