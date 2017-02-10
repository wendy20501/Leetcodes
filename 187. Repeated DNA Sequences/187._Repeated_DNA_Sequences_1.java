public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        
        int length = s.length();
        if (length < 10) {
            return result;
        }
        
        Map<Character, Integer> mymap = new HashMap<Character, Integer>();
        //use only 2 bits to save the data
        mymap.put('A', 0);
        mymap.put('C', 1);
        mymap.put('G', 2);
        mymap.put('T', 3);
        
        Set<Integer> temp = new HashSet<Integer>();
        Set<Integer> added = new HashSet<Integer>();
        
        int hash = 0;
        for (int i = 0; i < length; i++) {
            //shift 2 bits to the left to add new data
            hash = (hash << 2) + mymap.get(s.charAt(i));
            if (i >= 9) {
                //capture previous 20 bits data (= 10 characters) started from i 
                hash = hash & (1 << 20) - 1;
                if (temp.contains(hash) && !added.contains(hash)) {
                    result.add(s.substring(i - 9, i + 1));
                    added.add(hash);
                } else {
                    temp.add(hash);
                }
            }
        }
        
        return result;
    }
}