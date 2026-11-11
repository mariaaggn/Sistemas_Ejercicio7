import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int min=5;
        int max=100;

        int numAleatorio = (int) (Math.random()*(max-min+1)+min);
        int posicionAleatoria;
        List<Integer> lista = new ArrayList<>(numAleatorio);
        for(int i=0;i<numAleatorio;i++){
            posicionAleatoria=(int) (Math.random()*max)+1;
            lista.add(posicionAleatoria);
        }

        System.out.println("===Ordenación por mezcla concurrente===");
        System.out.println("Lista original (" + lista.size() + " elementos):");
        System.out.println(lista);

        Nodo raiz = new Nodo(lista);
        raiz.start();
        raiz.join();

        System.out.println("Lista ordenada: ");
        System.out.println(raiz.getLista());

    }
}

