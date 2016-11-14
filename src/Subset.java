import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by slazakovich on 9/13/2016.
 */
public class Subset {

    public static void main(String[] args) {
        int k = Integer.valueOf(args[0]);

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        for (int i = 1; i < args.length; i++) {
            randomizedQueue.enqueue(args[i]);
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
