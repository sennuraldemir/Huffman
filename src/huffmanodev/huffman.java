
package huffmanodev;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

class Huffman {

   
    public static void printCode(HuffmanNode root, String s) {

        
        if (root.left
                == null
                && root.right
                == null
                && Character.isLetter(root.c)) {

            
            System.out.print(root.c + " : "  +  s);

            return;
        }

        // özyinelemeli olarak çağırılır ve gidiş yönüne göre 0 veya 1 değerini alır
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    
    }
}
