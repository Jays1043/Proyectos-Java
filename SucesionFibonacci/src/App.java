import javax.swing.JOptionPane;
import io.reactivex.rxjava3.core.Observable;
public class App {
public static void main(String[] args) throws Exception {
Double doubleCantidad=
Double.parseDouble(JOptionPane.showInputDialog("Ingrese Limite de la sucesión de Fibonacci"));
Observable <Double> obsFibonacci = Observable.create(emitter->{
try
{ Double f1=(double) 0; Double f2=(double) 1; Double f=(double) 1;
for (double i = 0; i <= doubleCantidad; i++) {
if (i>0)
{
emitter.onNext(f);
f = f1+f2;
f1 = f2;
f2 = f;}
else
{
emitter.onNext((double) 0);
}
};
emitter.onComplete();}
catch(Exception e)
{
emitter.onError(e);
}
});
System.out.println("Resultados de la sucesión de Fibonacci hastan="+doubleCantidad);
obsFibonacci.subscribe(x->System.out.println(x), e->
System.out.println("Se ha producido una excepción en la emisión:"+e.getLocalizedMessage()));
}
}