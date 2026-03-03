public class splitLinkedList {
    public static void main(String[] args) {
        SingularList myNewLinkedList = new SingularList();
        myNewLinkedList.pushQ(10);
        myNewLinkedList.pushQ(20);
        myNewLinkedList.pushQ(30);
        myNewLinkedList.pushQ(40);
        myNewLinkedList.printList();
        
        System.out.println(myNewLinkedList.countElements());
        SplittedList splittedList = myNewLinkedList.splitList();
        SingularList theFirstHalfOfTheList = splittedList.getTheFirstHalf();
        SingularList theSecondHalfOfTheList = splittedList.getTheSecondHalf();
        theFirstHalfOfTheList.printList();
        theSecondHalfOfTheList.printList();
    }
    
}