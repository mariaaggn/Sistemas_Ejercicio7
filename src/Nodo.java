import java.util.ArrayList;
import java.util.List;

public class Nodo extends Thread {

    private List<Integer> lista;

    public Nodo(List<Integer> lista) {
        this.lista = lista;
    }

    public void anhade(List<Integer> l, int desde, int hasta) {
        l.addAll(lista.subList(desde, hasta));
    }

    public void mezcla(List<Integer> l1, List<Integer> l2) {
        lista.clear();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                lista.add(l1.get(i++));
            } else {
                lista.add(l2.get(j++));
            }
        }
        while (i < l1.size()) lista.add(l1.get(i++));
        while (j < l2.size()) lista.add(l2.get(j++));
    }

    @Override
    public void run() {

        if (lista.size() > 1) {
            List<Integer> lista1 = new ArrayList<>();
            List<Integer> lista2 = new ArrayList<>();

            anhade(lista1, 0, lista.size() / 2);
            anhade(lista2, lista.size() / 2, lista.size());


            Nodo nodo1 = new Nodo(lista1);
            Nodo nodo2 = new Nodo(lista2);
            nodo1.start();
            nodo2.start();
            try{
                nodo1.join();
                nodo2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mezcla(nodo1.getLista(),nodo2.getLista());
        }


    }

    public List<Integer> getLista() {
        return lista;
    }

    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }
}