//ejemplo contains
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.Observable;
public class App {
public static void main(String[] args) throws Exception {
    Single<Boolean> oInt= Observable.just(1,4,7,1,3,15,4,14).contains(15);
    oInt.subscribe(x->System.out.println(x));
}
}
