/*
 * Learning LinkedList Singular
 * head -> |10|o->|20|o->|30| <-o tail
 * 
 * @author: Lely Hiryanto
 */

/*
* class untuk mendefinisikan satu node di linkedlist 
* [info | next]   
* info = bagian node yang berisi informasi (teks, bilangan, object of a class)
* next = bagian node yang berisi alamat (pointer) ke node lainnya
*/

class Node {
    int info;
    Node next;

    // constructor
    public Node(int data) {
        this.info = data;
        this.next = null;
    }
}



public class SingularList {
    Node head = null; // pointer ke node pertama
    Node tail = null; // pointer ke node terakhir

    /*
     * Setiap node baru yang dibuat diletakkan di akhir list
     * (queue)
     */
    public void pushQ(int data) {
        // buat node baru
        Node newNode = new Node(data);
        // jika list kosong, head dan tail sama-sama menunjuk ke node pertama
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        // jika tidak kosong, tail diupdate untuk menunjuk ke node baru
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Mencetak bagian informasi dari setiap node di linkedlist
    public void printList() {
        // set pointer curr untuk menunjuk ke node pertama
        // (node pertama yang ditunjuk oleh head)
        Node curr = head;
        // jika list kosong, tampilkan pesan list kosong
        if (curr == null)
            System.out.println("List kosong!");
        /*
         * jika list tidak kosong, maka cetak bagian informasi
         * dari setiap node yang dikunjungi.
         */
        else {
            System.out.print("[");
            while (curr != null) {
                if (curr.next != null){System.out.print(curr.info + ", ");}
                else {System.out.print(curr.info);}
                /*
                 * curr diupdate untuk menunjuk ke node selanjutnya
                 * sampai curr null, dimana curr diset ke bagian 'next'
                 * dari node terakhir yang bernilai null. Artinya,
                 * pointer curr sudah ada di akhir node.
                 */
                curr = curr.next;
            }
        }
        System.out.println("]");
    }

    public int countElements() {
        Node current;
        current = head;
        int count = 0;
        while (current != null) {
            count += 1;
            current = current.next;
        }
        return count;
    }

    public SplittedList splitList() {
        SingularList newList = new SingularList();
        SingularList newListOtherHalf = new SingularList();
        int elementCount = this.countElements();
        int count = 0;
        Node current = head;
        while (current != null) {
            if (count < elementCount / 2) {
                newList.pushQ(current.info);
                current = current.next;
                count += 1;
            } else {
                newListOtherHalf.pushQ(current.info);
                current = current.next;
                count += 1;
            }
            

        }
        SplittedList newSplitList = new SplittedList(newList, newListOtherHalf);
        return newSplitList;

    }

    // pop, mengambil node pertama dan menghapusnya dari list
    Node pop() {
        Node n;
        if (head == null)
            return head;
        else {
            n = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
        return n;
    }
    public void searchANumberAndChangeTheValue(int index, int value){
        int counter = 0; 
        Node current = head;
        
        while (counter < index && current != null) {
            current = current.next;
            counter += 1;
        }
        if (current == null) {
            System.out.println("Angka tidak ketemu");
            return;
        }
        else if (counter == index){
            current.info = value;
        }
    }
    public static void main(String[] args) {
        // buat object 'List' dari class SingleList
        SingularList List = new SingularList();
        // mulai menyisipkan node per node ke list
        List.pushQ(10);
        List.pushQ(20);
        List.pushQ(30);
        // mencetak isi dari list (bagian informasi dari setiap node)
        List.printList();
        Node n = List.pop();
        if (n != null)
            System.out.println("Remove node " + n.info);
        List.printList();
    }
}

class SplittedList {
    private SingularList theFirstHalf;
    private SingularList theOtherHalf;

    public SplittedList(SingularList firstHalf, SingularList otherHalf) {
        this.setTheFirstHalf(firstHalf);
        this.setTheSecondHalf(otherHalf);
    }

    public void setTheFirstHalf(SingularList firstHalf){
        this.theFirstHalf = firstHalf;
    }

    public void setTheSecondHalf(SingularList secondHalf){
        this.theOtherHalf = secondHalf;
    }

    public SingularList getTheFirstHalf(){
        return this.theFirstHalf;
    }

    public SingularList getTheSecondHalf(){
        return this.theOtherHalf;
    }
}