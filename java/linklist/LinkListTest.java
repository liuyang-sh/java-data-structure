package linklist;

class LinkListTest {

    private List<Object> objectLinkList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        objectLinkList = new LinkList<>();
    }

    @org.junit.jupiter.api.Test
    void linkFirst() {
        objectLinkList.addFirst(2);
        objectLinkList.addFirst(1);
        System.out.println("objectLinkList.toString() = " + objectLinkList.print());
    }
}