public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        List<Character> mylist = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            mylist.add(s.charAt(i));
        }
        for (int j = 0; j < t.length(); j++) {
            char current = t.charAt(j);
            if (mylist.contains(current))
                mylist.remove(new Character(current));
            else
                return false;
        }
        return true;
    }
}