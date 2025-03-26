//===============================================================
/*
Laboratorio: Semana 4
Ejemplo operaciones First, Last, elementAt, Take , Skip
*/
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
public class App {
public static void main(String[] args) throws Exception {
String [] nombres ={"Silvio","Neyen","Rocío","Fernando","Katia","Amaury","Amaya","Auba","Casian","Teresa"};
Single<String> singleNameFirst=
Observable.fromArray(nombres).first("vacío");
Single<String> singleNameLast=
Observable.fromArray(nombres).last("vacío");
Single<String> singleElementAt=
Observable.fromArray(nombres).elementAt(3, "ninguno");
singleNameFirst.subscribe(x->System.out.println("First: "+x));
singleNameLast.subscribe(x->System.out.println("Last: "+x));
singleElementAt.subscribe(x->System.out.println("Element At :"+x));
Observable <String> obsTakeName=
Observable.fromArray(nombres).take(3);
obsTakeName.subscribe(x->System.out.println("Take: "+x));
Observable <String> obsSkipName=
Observable.fromArray(nombres).skip(4);
obsSkipName.subscribe(x->System.out.println("Skip: "+x));
}
}
