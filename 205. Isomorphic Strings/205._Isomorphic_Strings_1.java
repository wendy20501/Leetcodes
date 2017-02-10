public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mymap = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char current_s = s.charAt(i);
            char current_t = t.charAt(i);
            if (mymap.containsKey(current_s)) {
                if (mymap.get(current_s).equals(current_t))
                    continue;
                return false;
            } else if (mymap.containsValue(current_t)) {
                return false;
            } else {
                mymap.put(current_s, current_t);
            }
        }
        return true;
    }
}