public class testSingularMore {
    public static void main(String[] args) {
        SingularListMore<Integer> integerLinkedList = new SingularListMore<>();
        integerLinkedList.pushQ(1);
        integerLinkedList.pushQ(2);
        integerLinkedList.pushQ(3);
        integerLinkedList.printList();

        SingularListMore<String> stringLinkedList = new SingularListMore<>();
        stringLinkedList.pushQ("Hello");
        stringLinkedList.pushQ("my name is");
        stringLinkedList.pushQ("Chandra");
        stringLinkedList.printList();
    }
}
