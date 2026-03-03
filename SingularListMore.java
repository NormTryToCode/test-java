
class Node<T> {
    T info;
    Node<T> next;

    // constructor
    public Node(T data) {
        this.info = data;
        this.next = null;
    }
}




class SplittedList<T> {
    private SingularListMore<T> theFirstHalf;
    private SingularListMore<T> theOtherHalf;

    public SplittedList(SingularListMore<T> firstHalf, SingularListMore<T> otherHalf) {
        this.setTheFirstHalf(firstHalf);
        this.setTheSecondHalf(otherHalf);
    }

    public void setTheFirstHalf(SingularListMore<T> firstHalf){
        this.theFirstHalf = firstHalf;
    }

    public void setTheSecondHalf(SingularListMore<T> secondHalf){
        this.theOtherHalf = secondHalf;
    }

    public SingularListMore<T> getTheFirstHalf(){
        return this.theFirstHalf;
    }

    public SingularListMore<T> getTheSecondHalf(){
        return this.theOtherHalf;
    }
}
public class SingularListMore<T> {
    Node<T> head = null; // pointer ke node pertama
    Node<T> tail = null; // pointer ke node terakhir

    /*
     * Setiap node baru yang dibuat diletakkan di akhir list
     * (queue)
     */
    public void pushQ(T data) {
        // buat node baru
        Node<T> newNode = new Node<>(data);
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
        Node<T> curr = head;
        // jika list kosong, tampilkan pesan list kosong
        if (curr == null){
            System.out.println("[]");
            return;
        }
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
        Node<T> current;
        current = head;
        int count = 0;
        while (current != null) {
            count += 1;
            current = current.next;
        }
        return count;
    }

    public SplittedList<T> splitList() {
        SingularListMore<T> newList = new SingularListMore<>();
        SingularListMore<T> newListOtherHalf = new SingularListMore<>();
        int elementCount = this.countElements();
        int count = 0;
        Node<T> current = head;
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
        SplittedList<T> newSplitList = new SplittedList<>(newList, newListOtherHalf);
        return newSplitList;

    }

    // pop, mengambil node pertama dan menghapusnya dari list
    Node<T> pop() {
        Node<T> n;
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
    public void searchANumberAndChangeTheValue(int index, T value){
        int counter = 0; 
        Node<T> current = head;
        
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
        SingularListMore<Integer> List = new SingularListMore<>();
        // mulai menyisipkan node per node ke list
        List.pushQ(10);
        List.pushQ(20);
        List.pushQ(30);
        // mencetak isi dari list (bagian informasi dari setiap node)
        List.printList();
        Node<Integer> n = List.pop();
        if (n != null)
            System.out.println("Remove node " + n.info);
        List.printList();
    }
}
