
package huffmanodev;

import static huffmanodev.Huffman.printCode;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Sennur
 */
public class HuffmanOdev {

    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // number of characters.
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

          
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

           
            q.add(hn);
        }

       
        HuffmanNode root = null;

      
        while (q.size() > 1) {

            
            HuffmanNode x = q.peek();
            q.poll();

            
            HuffmanNode y = q.peek();
            q.poll();

           
            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            f.c = '-';

       
            f.left = x;

            f.right = y;

            root = f;

           
            q.add(f);
        }

        printCode(root, "");
    }
}



