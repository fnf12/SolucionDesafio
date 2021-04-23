import java.math.BigInteger;
import java.util.ArrayList;


//Para encontrar esta solucion me imagine las divisiones normales de primaria en las que para encontrar el resto se va dividiendo poco a poco
//Tambien me di cuenta que el resto no puede superar al divisor entonces:

class SolucionPuzzle {

    final static BigInteger M = new BigInteger("2021");
    
    private static BigInteger compute(long n) {

        if ( new BigInteger(n+"").mod(M) != new BigInteger(0+"")) { //Evaludo si el n.mod(M) es distito de 0 en caso contario voy por el else

            ArrayList<String> restos = new ArrayList<String>(); //creo un lista que guardara los restos que vaya encontrando, por que en caso de que algun resto se repita, habré encontrado un patron
            int index; // guardara el valor del indice de la lista donde se encuetra el resto que quiero mostrar
            String s; // sumara los restos encontrados con n
            String restoencontrado = "";
            

            s = new BigInteger(n+"").mod(M)+""; //realizo un primera iteracion para iniciar valores

            restos.add(s); //agrego a la lista el primer resto encontrado

            s = s + n ; //concateno con n

            while ( !restos.contains(new BigInteger(s).mod(M)+"") && restos.size() < n  ) { //aqui evaluo que el resto no este repetido en la lista, y que la cantidad de restos no supere "n" por que para valores menores a "M" las iteraciones se pueden desfasar.

                restoencontrado =  new BigInteger(s).mod(M)+""; //como en las divisiones normales voy sacando restos y concatenando el siguiente valor
                
                s = restoencontrado + n ;
                
                restos.add(restoencontrado); //agrego un resto encontrado a la lista
            }

           //una vez salido del ciclo significa que encontre un patron que se repite

           index = (int)n % restos.size(); // el patron se repite una cantidad de veces y con el modulo saco la posicion donde guardo el resto que quiero mostrar

            if (index != 0) { // evaluo que sea distinto de 0 en caso contario voy por el else

                return new BigInteger(restos.get(index-1)+"");  // retorno el resto encontrado restando 1 al indice por que las posiciones de una lista iniciar en 0
            }
            else{
                return new BigInteger(restos.get(restos.size()-1)+"");//si el index me da 0 significa que es resto a mostrar el el ultimo encontrado
            }
           
        }
        else{
            return new BigInteger(n+"").mod(M); // si el modulo es 0 no es necesario seguir concatenado valores por que todos daran como modulo 0
        }


    }
        public static void main(String args[]) {

        for (long n : new long[] { 1L, 2L, 5L, 10L,67489454811002199L}) {
        System.out.println("" + n + ": " + compute(n));
        }

    }

}