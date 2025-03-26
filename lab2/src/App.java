//Ejmplos observable
import io.reactivex.Observable;
public class App {
    public static void main(String[] args) throws Exception {
        Observable<String>oStr = Observable.just("Hola", "Mundo");
        oStr.subscribe(patito->System.out.println(patito));
        Observable<Integer> oInt= Observable.just(0,1,10,100,1001);
        oInt.subscribe(x->System.out.println(x));
    }
}
