public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        int index = 0;
        result = getIp(s, 1);
        return result;
    }
    
    private List<String> getIp(String s, int index) {
        //System.out.println("index: " + index);
        List<String> result = new ArrayList<String>();
        if (index == 4 && IsValidNumber(s)) {
            //System.out.println(s);
            result.add(s);
        } else {
            for (int i = 1; i < 4; i++) {
                if (s.length() > i) {
                    String ip = s.substring(0, i);
                    //System.out.println("ip: " + ip);
                    if (IsValidNumber(ip)) {
                        List<String> base = getIp(s.substring(i), index + 1);
                        for (int j = 0; j < base.size(); j++) {
                            //System.out.println(ip + "." + base.get(j));
                            result.add(ip + "." + base.get(j));
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean IsValidNumber(String ip) {
        if (ip.length() > 1 && ip.charAt(0) == '0') {
            //System.out.println("false 1");
            return false;
        }
        int number = Integer.parseInt(ip);
        if (number >= 0 && number <= 255) {
            //System.out.println("true 1");
            return true;
        }
        //System.out.println("false 2");
        return false;
    }
}