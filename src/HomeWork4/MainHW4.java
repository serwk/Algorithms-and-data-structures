package HomeWork4;

public class MainHW4 {

    public static void main(String[] args) {
        testSimpleLinkedList();

        //Не успел разобраться, почему не работает
        //testTwoSideLinkedList();
    }

    private static void testSimpleLinkedList() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(6);

        System.out.println("Size = " + linkedList.getSize());

        linkedList.display();

        linkedList.remove();
        linkedList.remove(3);

        linkedList.display();
    }
    private static void testTwoSideLinkedList() {
        TwoSideLinkedList linkedList = new TwoSideLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addLast(4);
        linkedList.addLast(6);

        System.out.println("Size = " + linkedList.getSize());

        linkedList.display();

        linkedList.remove();
        linkedList.remove(6);

        linkedList.display();
    }

}
