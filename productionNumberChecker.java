import java.util.Scanner;
public class productionNumberChecker {
    
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean found = false;
        String[] jakartaNumbers = new String[25];
        String[] bandungNumbers = new String[25];
        System.out.print("Masukkan jumlah produk di jakarta: ");
        int jakartaProductAmount = myScanner.nextInt();
        System.out.print("Masukkan jumlah produk di Bandung: ");
        int bandungProductAmount = myScanner.nextInt();
        System.out.println("");
        for (int jakartaIndex = 0; jakartaIndex < jakartaProductAmount; jakartaIndex++){
            int currentNumber = jakartaIndex + 1;
            String currentProductionNumber = myScanner.nextLine();
            System.out.print("Masukkan angka ke-" + currentNumber + " dari product number: ");
            System.out.println("");
            jakartaNumbers[jakartaIndex] = currentProductionNumber;
        }

        for (int bandungIndex = 0; bandungIndex < bandungProductAmount; bandungIndex++){
            int currentNumber = bandungIndex + 1;
            String currentProductionNumber = myScanner.nextLine();
            System.out.print("Masukkan angka ke-" + currentNumber + " dari product number: ");
            System.out.println("");
            bandungNumbers[bandungIndex] = currentProductionNumber;
        }

        for (int jakartaCurrentIndex = 0; jakartaCurrentIndex < jakartaProductAmount; jakartaCurrentIndex++){
            for (int bandungCurrentIndex = 0; bandungCurrentIndex < bandungProductAmount; bandungCurrentIndex++){
                if (jakartaNumbers[jakartaCurrentIndex].equals(bandungNumbers[bandungCurrentIndex])){
                    System.out.println("Kode produksi yang sama: " + jakartaNumbers[jakartaCurrentIndex]);
                    found = true;
                }
            }
        }
        if (!found){
            System.out.println("Tidak ada yang sama");
        }
        myScanner.close();
    }
}
