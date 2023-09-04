/**
* @author ESA
* @since May,2023
*/
package pdproje3;
import java.lang.Math;

public class bUretim extends Uretim{ //B uretim sinifinin tanimlanmasi
    @Override
    public int Uret() {//Uretim sinifinin uret fonksiyonunun tanimlanmasi
        int min=3;
        int max=10;
        int rand=(int)Math.floor(Math.random()*(max-min+1)+min);//%30 daha sansli random fonksiyonunun tanimlanmasi
        return rand;//atanimlanan fonskiyonun dondurulmesi
    }
}


