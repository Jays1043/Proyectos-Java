//===============================================================
/*
Josue Alejandro Yaquian Sarceño     3190-22-7332

PREGUNTAS:
1. ¿Cuál operación compararía con el de una atención de clientes en un supermercado con varias cajas?
    Zip 
2. ¿Cuál operación compararía con el mismo supermercado con una única caja?
    Merge
3. ¿Existe diferencia entre aplicar primero un take y después un map o entre hacer primero un map y luego un take?
    No existe diferencia, los datos se muestran de la misma manera
*/
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
public class App {
    public static void main(String[] args)  throws Exception {      
        Observable<String> obsNombres=  Observable.interval(500,TimeUnit.MILLISECONDS).map(x ->"Nombre "+x).take(5);
        Observable<String> obsApellidos=  Observable.interval(1,TimeUnit.SECONDS).map(x ->"Apellido "+x).take(5);     
        //Observable <String> obsMerge =(Observable<String>) Observable.merge(obsNombres,obsApellidos);
        //obsMerge.subscribe(x->System.out.println("Merge: "+x));
        //Observable <String> obsConcat =(Observable<String>) Observable.concat(obsNombres,obsApellidos);
        //obsConcat.subscribe(x->System.out.println("Concat: "+x));       
        Observable <String> obsZip =(Observable<String>) Observable.zip(obsNombres,obsApellidos,(a,b)->a+" "+b);
        obsZip.subscribe(x->System.out.println(x));      
       contador(8000); 
    }
    private static void contador(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

