/**
* @author ESA
* @since May,2023
*/
package pdproje3;
import java.lang.Math;

public class aUretim extends Uretim{// A uretim sinifinin tanimlanmasi
    @Override
    public int Uret() {// Uretim sinifinin uret fonksiyonu tanimlaniyor
        int min=2;
        int max=10;
        int rand=(int)Math.floor(Math.random()*(max-min+1)+min);//%20 daha fazla sansli olarak 2-10 arasinda random sayi olusuyor.
        return rand;//olusan random sayi donduruluyor.
    }
}