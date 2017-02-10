public class Solution {
    public String simplifyPath(String path) {
        int size = path.length();
        if (size <= 1) {
            return path;
        } else {
            StringBuilder sb = new StringBuilder();
            List<String> mypath = new ArrayList<String>();
            int count = 0;
            String[] folders = path.split("/");
            for (int i = 0; i < folders.length; i++) {
                //System.out.println(folders[i]);
                if (folders[i].equals(".")) {
                    
                } else if (folders[i].equals("..")) {
                    if (count != 0) {
                        mypath.remove(count - 1);
                        count--;
                    }
                } else if (!folders[i].equals("")) {
                    mypath.add(folders[i]);
                    count++;
                }
            }
            for (int j = 0; j < mypath.size(); j++) {
                sb.append("/");
                sb.append(mypath.get(j));
            }
            if (sb.length() == 0) {
                sb.append("/");
            }
            return sb.toString();
        }
    }
}