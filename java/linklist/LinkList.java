package linklist;

/**
 * 双向列表实现
 * @param <E> 链表内元素
 * @author shovelshit
 */
public class LinkList<E> implements List<E> {
    transient Node<E> first;

    transient Node<E> last;

    transient long size;

    private void linkFirst(E e) {
        // 原始首节点
        final Node<E> f = first;
        // 初始化新首节点
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        // 如果原始首节点为null,说明第一次添加,赋值尾节点
        // 否则将新首节点赋值给原始首节点的prev节点上
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private void linkLast(E e) {
        // 原理同linkFirst
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }


    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean get(E e) {
        return false;
    }

    @Override
    public String print() {
        if (size == 0) {
            return null;
        }
        Node<E> temp = first;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.item).append(" -> ");
            temp = temp.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
