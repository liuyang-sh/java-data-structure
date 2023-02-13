package linklist;

/**
 * 链表接口
 * @param <E> 链表内元素
 * @author shovelshit
 */
public interface List<E> {

    boolean addFirst(E e);

    boolean addLast(E e);

    E remove(int index);

    E get(int index);

    String print();
}
