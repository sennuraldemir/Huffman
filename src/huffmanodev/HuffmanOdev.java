
package huffmanodev;

import static huffmanodev.Huffman.printCode;
import java.util.PriorityQueue; // bunu kullanacağız çünkü huffman kodlaması için min sayılar önceliklidir.
import java.util.Scanner;

/**
 *
 * @author Sennur
 */
public class HuffmanOdev {

    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // burada karakter ve onların frekanslarını belirliyoruz ayriyeten eleman sayısını da veriyoruz (n)
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};

        //bu kısımda öncelikli kuyruğu implement ediyoruz
        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

            // huffman için yeni veri atıyoruz
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

           
            q.add(hn);
        }

        
        HuffmanNode root = null;

      
        while (q.size() > 1) {    // Burada, kuyruğun boyutu 1'e düşene kadar her seferinde kuyruktan iki minimum değeri çıkaracağız ve
                                  // tüm düğümler için bunu devam ettireceğiz.

            
            HuffmanNode x = q.peek();
            q.poll();   // ilk çıkan öğe kuyruğun başındadır; remove() ya da poll()metodu ile alınır. 

            
            HuffmanNode y = q.peek();
            q.poll();

           
            HuffmanNode f = new HuffmanNode();

            // burada kuyruktan aldığımız iki min değerin frekanslarını topluyoruz
            f.data = x.data + y.data;
            f.c = '-';

       
            f.left = x;

            f.right = y;

            root = f;

            // bu yeni oluşan değeri öncelikli kuyruğa ekliyoruz.
            q.add(f);
        }

        printCode(root, "");
    }
}



