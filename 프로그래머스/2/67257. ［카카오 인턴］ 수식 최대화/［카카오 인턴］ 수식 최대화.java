import java.util.*;
class Solution {
    HashSet<String> operations = new HashSet<>();
    ArrayList<ArrayList<String>> permutations = new ArrayList<>();
    
    // 연산자 우선순위 6가지(3!) 생성
    public void perm(int length, ArrayList<String> current) {
        if (length == 3) {
            permutations.add(new ArrayList<>(current));
            return;
        }
        
        for (String op: operations) {
            if (!current.contains(op)) {
                current.add(op);
                perm(length + 1, current);
                current.remove(length);
            }
        }
    }
    
    public long solution(String expression) {
        operations.add("+");
        operations.add("-");
        operations.add("*");
        perm(0, new ArrayList<>());
        
        // expression에서 숫자와 연산자 분리
        String temp;
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        ArrayList<Long> numbers = new ArrayList<>(); // 숫자만 보관
        ArrayList<String> ops = new ArrayList<>(); // 연산자만 보관
        while (st.hasMoreTokens()) {
            String input = st.nextToken();
            if (Character.isDigit(input.charAt(0))) {
                numbers.add(Long.parseLong(input));
            } else {
                ops.add(input);
            }
        }
        
        long answer = 0;
        // permlist에는 각각의 연산자 우선순위 배열이 저장되어 있음 ex) * -> + -> -
        for (ArrayList<String> permlist : permutations) {
            ArrayList<Long> copyNumbers = new ArrayList<>(numbers); // numbers 복사본
            ArrayList<String> copyOps = new ArrayList<>(ops); // ops 복사본
            
            for (String opPerm : permlist) {
                // expression안의 연산자들을 확인하면서 우선순위가 높은 연산자부터 계산함
                while (copyOps.contains(opPerm)) {
                    int i = copyOps.indexOf(opPerm);
                    if (opPerm.equals(copyOps.get(i))) {
                        if (opPerm.equals("*")) {
                            copyNumbers.set(i, copyNumbers.get(i) * copyNumbers.get(i + 1));
                        } else if (opPerm.equals("+")) {
                            copyNumbers.set(i, copyNumbers.get(i) + copyNumbers.get(i + 1));
                        } else if (opPerm.equals("-")) {
                            copyNumbers.set(i, copyNumbers.get(i) - copyNumbers.get(i + 1));
                        }
                        copyNumbers.remove(i + 1);
                        copyOps.remove(i);
                    }
                }
            }
            // 절댓값이 가장 큰 수 구하기
            answer = Math.max(answer, Math.abs(copyNumbers.get(0)));
        }
        return answer;
    }
}