package Estructuras;

/**
 *
 * @author Kevin Zhang
 * @param <E>
 */
public interface List<E> {
    
    /**
     *
     * @param e
     * @return
     */
    public boolean addFirst(E e); // inserta el elemento e al inicio

    /**
     *
     * @param e
     * @return
     */
    public boolean addLast(E e); // inserta el elemento e al final

    /**
     *
     * @return
     */
    public E removeFirst(); // remueve el elemento al inicio de la lista

    /**
     *
     * @return
     */
    public E removeLast(); // remueve el elemento al final de la lista

    /**
     *
     * @return
     */
    public int size();

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     */
    public void clear();
    
    /**
     *
     * @param index
     * @param element
     */
    public void add(int index, E element); // inserta element en la posición index

    /**
     *
     * @param index
     * @return
     */
    public E remove(int index); // remueve y retorna el elemento en la posición index

    /**
     *
     * @param index
     * @return
     */
    public E get(int index); // retorna el elemento ubicado en la posición index

    /**
     *
     * @param index
     * @param element
     * @return
     */
    public boolean set(int index, E element); // setea el element en la posición index

}
