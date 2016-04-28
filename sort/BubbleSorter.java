package sort;

/**
 * Created by kouyang on 2/29/2016.
 */
public class BubbleSorter {
    public static void main(String[] args) {
        int[] s = {5,4,2,1,6,10,0,-1,4,4,4};
        sort(s);
        for (int i : s) {
            System.out.println(i);
        }
        
    }

    public static void sort(int[] s) {
        if (s.length <= 1) return;
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < s.length - i; j++) {
                if (s[j] > s[j + 1]) {
                    int t = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = t;
                }
            }
        }
    }
}
