import java.util.*;
class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        boolean groupA = true;
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                groupA = false;
                break;
            }
        }
        if (groupA) {
            answer = gcdA;
        }
        
        boolean groupB = true;
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                groupB = false;
                break;
            }
        }
        if (groupB) {
            answer = Math.max(gcdB, answer);
        }
        return answer;
    }
}