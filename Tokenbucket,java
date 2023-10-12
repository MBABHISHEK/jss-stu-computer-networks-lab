import java.util.Scanner;

public class TokenBucket {
    public static void main(String[] args) {
        int tokens = 0; // initial number of tokens in the bucket
        int rate = 10; // rate at which tokens are added to the bucket
        int capacity = 100; // maximum number of tokens the bucket can hold

        int[] request = new int[100];
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of requests: ");
        int n = scanner.nextInt();
        
        System.out.print("Enter no. of packets per request: ");
        for (int i = 0; i < n; i++) {
            request[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // add tokens to the bucket at a fixed rate
            tokens = Math.min(tokens + rate, capacity);

            try {
                // wait for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (tokens >= request[i]) {
                // remove the requested tokens from the bucket
                tokens -= request[i];
                System.out.println("Request granted, tokens remaining: " + tokens);
            } else {
                System.out.println("Request denied, not enough tokens: " + tokens);
            }
        }

        scanner.close();
    }
}
