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

    /**
     * 检查是否越界
     * @param index
     */
    public void checkIndexOutOf(int index) {
        if (index >=0 && index < size) {
            throw  new IndexOutOfBoundsException();
        }
    }

    Node<E> node(int index){

        if (index < (size>>1)) {
            Node<E> x =first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }else {
            Node<E> x = last;
            for (long i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return  x;
        }
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
    public E remove(int index) {
        checkIndexOutOf(index);
        Node<E> removeNode = node(index);
        final  E removeElement = removeNode.item;
        //解绑删除节点左链和右链 重新绑定
        Node<E> prevNode = removeNode.prev;
        Node<E> nextNode = removeNode.next;
        if (prevNode == null) {
            first = nextNode;
        } else  {
            prevNode.next = nextNode;
            removeNode.prev = null;
        }
        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
            removeNode.next = null;
        }

        removeNode.item = null;
        size --;
        return removeElement;
    }

    @Override
    public E get(int index) {
        checkIndexOutOf(index);
        return node(index).item;
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
