package linklist;

/**
 * 链表接口
 * @param <E> 链表内元素
 * @author shovelshit
 */
public interface List<E> {

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(E e);

    boolean get(E e);

    String print();
}
