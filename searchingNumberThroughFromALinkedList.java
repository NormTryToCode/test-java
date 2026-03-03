public class searchingNumberThroughFromALinkedList {
    public static void main(String[] args) {
        SingularList newLinkedList = new SingularList();
        SingularList secondLinkedList = new SingularList();
        newLinkedList.pushQ(3);
        newLinkedList.pushQ(2);
        newLinkedList.pushQ(1);
        newLinkedList.pushQ(0);
        newLinkedList.printList();

        newLinkedList.searchANumberAndChangeTheValue(5, 0);
        newLinkedList.printList();
        newLinkedList.append(2);
        
        secondLinkedList.printList();
        secondLinkedList.append(0);
        secondLinkedList.append(1);
        secondLinkedList.printList();
        newLinkedList.printList();
    }
}
