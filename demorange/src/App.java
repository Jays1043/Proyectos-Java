//Josue Alejandro Yaquian Sarceño   3190-22-7332

import io.reactivex.rxjava3.core.Observable;
public class App {
    public static void main(String[] args) throws Exception {
        //Observable just emite un elemento.
        //En este caso se podria utilizar como un dato predeterminado en un programa.
        Observable<Integer> ObsInt= Observable.just(30);
        ObsInt.subscribe(n->System.out.println(n));

        //Observable fromArray convierte un array en un flujo de datos observable.
        //Podria servir para integrarlo con un codigo ya existente con arrays y hacerlo reactivo.
        String[] colors = {"Rojo", "Verde", "Azul", "Amarillo", "Blanco"};
        Observable<String> colorsObservable = Observable.fromArray(colors);
        colorsObservable.subscribe(
            color -> System.out.println("Color: " + color),
            error -> System.err.println("Error: " + error),
            () -> System.out.println("Fin del flujo fromArray.")
        );
        
        //Observable range nos crea un flujo de una secuecia de enteros a partir de un rango espeficico.
        //Se puede utilizar para controlar un flujo de datos con un temporizador.
        Observable<Integer> rangeObservable = Observable.range(1, 10);
        rangeObservable.subscribe(
            number -> System.out.println("Numero: " + number),
            error -> System.err.println("Error: " + error),
            () -> System.out.println("Fin del flujo range.")
        );

        //Observable create sirve para hacer una emision personalizada.
        //Se utiliza para tener un control total sobre los elementos por ejemplo de los elementos de una lista diferida.
        Observable<Integer> evenNumbersObservable = Observable.create(emitter -> {
            try {
                int number = 0;
                int count = 0;
                while (count < 10) {
                    emitter.onNext(number);
                    number += 2;
                    count++;
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
        evenNumbersObservable.subscribe(
            number -> System.out.println("Numero par: " + number),
            error -> System.err.println("Error: " + error),
            () -> System.out.println("Fin del flujo de datos create.")
        );
    }
}
