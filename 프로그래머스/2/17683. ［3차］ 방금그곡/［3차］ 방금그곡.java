import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String[][] sheet = new String[musicinfos.length][2];
        int[] minutes = new int[musicinfos.length];
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            minutes[i] = minute(st.nextToken(), st.nextToken());
            String title = st.nextToken();
            String part = replaceSharpNotes(st.nextToken());
            
            int share = minutes[i] / part.length();
            int remainder = minutes[i] % part.length();
            sheet[i][0] = title;
            sheet[i][1] = part.repeat(share) + part.substring(0, remainder);
        }
        
        int timeMax = 0;
        String find = replaceSharpNotes(m);
        for (int i = 0; i < sheet.length; i++) {
            if (sheet[i][1].contains(find)) {
                if (minutes[i] > timeMax) {
                    answer = sheet[i][0];
                    timeMax = minutes[i];
                }
            }
        }
        return answer;
    }
    
    private int minute(String start, String end) {
        int startMinute = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
        int endMinute = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3, 5));
        return endMinute - startMinute;
    }
    
    private String replaceSharpNotes(String melody) {
        melody = melody.replace("C#", "H");
        melody = melody.replace("D#", "I");
        melody = melody.replace("F#", "J");
        melody = melody.replace("G#", "K");
        melody = melody.replace("A#", "L");
        melody = melody.replace("B#", "M");
        return melody;
    }
}