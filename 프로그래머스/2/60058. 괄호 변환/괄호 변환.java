import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        if (correctStr(p)) {
            return p;
        } else {
            answer = recursive(p);
        }
        return answer;
    }
    
    private int uvSeparate(String p) {
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                return i + 1;
            }
        }
        return 0;
    }
    
    private boolean correctStr(String p) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        // correct가 true면 올바른 괄호 문자열, false면 그냥 균형잡힌 괄호 문자열 
        boolean correct = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                stack.push(p.charAt(i));
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                correct = false;
            }
        }
        if (!stack.isEmpty()) {
            correct = false;
        }
        return correct;
    }
    
    private String reverse(String u) {
        String temp = "";
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                temp += ')';
            } else {
                temp += '(';
            }
        }
        return temp;
    }
    
    private String recursive(String w) {
        // 1. w가 빈 문자열인 경우 빈 문자열 반환
        if (w.equals("")) {
            return "";
        }
        
        // 2. 문자열 w를 u, v로 분리
        String u = w.substring(0, uvSeparate(w));
        String v = w.substring(uvSeparate(w));
        
        // 3. u가 올바른 괄호 문자열이라면
        if (correctStr(u)) {
            u += recursive(v);
            return u;
        } else { // u가 올바른 괄호 문자열이 아니라면
            String temp = "(" + recursive(v) + ")" + reverse(u);
            return temp;
        }
    }
}