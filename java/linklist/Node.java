package linklist;

/**
 * 链表节点
 * @param <E> 元素
 * @author shovelshit
 */
public class Node<E> {

    E item;

    Node<E> prev;

    Node<E> next;

    public Node(Node<E> prev, E item, Node<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

}
