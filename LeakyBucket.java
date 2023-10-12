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
            System.out.print("Input Packet Size: ");
            inputPacketSize = scanner.nextInt();

            sizeLeft = bucketSize - storedBufferSize;

            if (inputPacketSize <= sizeLeft) {
                storedBufferSize += inputPacketSize;
            } else {
                System.out.println("Packet Dropped");
            }

            System.out.println("Stored Buffer Size: " + storedBufferSize);
            storedBufferSize -= outputPacketSize;
        }

        scanner.close();
    }
}
