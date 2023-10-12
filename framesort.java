import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Frame {
    int seqNo;
    String data;

    public Frame(int seqNo) {
        this.seqNo = seqNo;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Size of the data: ");
        int total = scanner.nextInt();

        System.out.print("Enter the Size of each data packet: ");
        int size= scanner.nextInt();

        int n=total/size;

        List<Integer> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(i);
        }


        List<Frame> frames = new ArrayList<>();
        for (int seqNo : seqList) {
            frames.add(new Frame(seqNo));
        }

        for (Frame frame : frames) {
            System.out.print("Enter data for frame " + frame.seqNo + ": ");
            frame.data = scanner.next();
        }
        Collections.shuffle(frames);
        System.out.print("Before Sorting\n");

        for (Frame frame : frames) {
            System.out.println("Frame " + frame.seqNo + " : " + frame.data);
        }
        Collections.sort(frames, (f1, f2) -> Integer.compare(f1.seqNo, f2.seqNo));

        System.out.print("After Sorting\n");
        for (Frame frame : frames) {
            System.out.println("Frame " + frame.seqNo + " : " + frame.data);
        }
    }
}
