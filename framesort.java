import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Frame {
    int seqNo;
    int data;

    public Frame(int seqNo) {
        this.seqNo = seqNo;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of frames: ");
        int n = scanner.nextInt();

        List<Integer> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * (n * 100)) + 1;
            while (seqList.contains(x)) {
                x = (int) (Math.random() * (n * 100)) + 1;
            }
            seqList.add(x);
        }

        List<Frame> frames = new ArrayList<>();
        for (int seqNo : seqList) {
            frames.add(new Frame(seqNo));
        }

        for (Frame frame : frames) {
            System.out.print("Enter data for frame " + frame.seqNo + ": ");
            frame.data = scanner.nextInt();
        }

        Collections.sort(frames, (f1, f2) -> Integer.compare(f1.seqNo, f2.seqNo));

        for (Frame frame : frames) {
            System.out.println("Frame " + frame.seqNo + " : " + frame.data);
        }
    }
}
