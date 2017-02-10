public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            if (groups.isEmpty()) {
                List<String> ans = new ArrayList<String>();
                ans.add(strs[i]);
                groups.put(getKey(strs[i]), ans);
                //System.out.println("empty add : " + strs[i]);
            } else {
                String key = getKey(strs[i]);
                if (groups.containsKey(key)) {
                    groups.get(key).add(strs[i]);
                } else {
                    List<String> ans = new ArrayList<String>();
                    ans.add(strs[i]);
                    groups.put(key, ans);
                }
            }
        }
        List<List<String>> result = new ArrayList<List<String>>(groups.values());
        return result;
    }
    
    private String getKey(String a) {
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            //System.out.println(a.charAt(i) - 'a');
            count[(int)(a.charAt(i) - 'a')]++;
        }
        
        String key = "";
        for (int j = 0; j < count.length; j++) {
            //System.out.println("count[" + j + "] = " + count[j]);
            if (count[j] != 0) {
                //System.out.println(count[j] + (char)('a' + count[j]));
                key += count[j];
                //System.out.println(key);
                key += (char)('a' + j);
                //System.out.println(key);
            }
        }
        //System.out.println(a + " : " + key);
        return key;
    }
}