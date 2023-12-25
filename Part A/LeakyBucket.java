import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        int noOfQueries = 4;
        int bucketSize = 10;
        int inputPacketSize;
        int outputPacketSize = 1;
        int storedBufferSize = 0;
        int sizeLeft;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < noOfQueries; i++) {
            System.out.print("ENTER THE NUMBER OF PACKETS ");
            inputPacketSize = scanner.nextInt();

            sizeLeft = bucketSize - storedBufferSize;

            if (inputPacketSize <= sizeLeft) {
                storedBufferSize += inputPacketSize;
            }
             else {
                System.out.println("Number of Packets Dropped " + (storedBufferSize+inputPacketSize-bucketSize));
                storedBufferSize=bucketSize;
            }

            System.out.println("Stored Buffer Size: " + storedBufferSize);
            storedBufferSize -= outputPacketSize;
        }

        scanner.close();
    }
}
