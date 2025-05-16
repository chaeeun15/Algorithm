class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] stack = new int[ingredient.length];
        int index = 0;
        for (int num : ingredient) {
            stack[index++] = num;
            if (index >= 4 && stack[index-1] == 1 && stack[index-2] == 3 && stack[index-3] == 2 && stack[index-4] == 1) {
                answer++;
                index -= 4;
            }
        }
        return answer;
    }
}