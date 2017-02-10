public class Solution {
    private Map<String, List<Integer>> algebra;
    private String[][] myequations;
    private double[] myvalues;
    private List<String> running;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        myequations = equations;
        myvalues = values;
        algebra = new HashMap<String, List<Integer>>();
        running = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            putIntoAlgebra(equations[i][0], i);
            putIntoAlgebra(equations[i][1], i);
        }
        
        double[] result = new double[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = divid(queries[j][0], queries[j][1]);
            running.clear();
            //System.out.println("result = " + result[j]);
        }
        return result;
    }
    
    private void putIntoAlgebra(String key, int index) {
        //System.out.println("key " + key + " add: " + index);
        if (algebra.containsKey(key)) {
            algebra.get(key).add(index);
        } else {
            List<Integer> indexes = new ArrayList<Integer>();
            indexes.add(index);
            algebra.put(key, indexes);
        }
    }
    
    private double divid(String divident, String divisor) {
        //System.out.println("divident = " + divident + " divisor = " + divisor);
        if (running.contains(divident+divisor)) {
            running.remove(divident+divisor);
            return -1.0;
        } else {
            running.add(divident+divisor);
        }
       
        if (!algebra.containsKey(divident) || !algebra.containsKey(divisor)) {
            //System.out.println("no related fomulas");
            return -1.0;
        } else if (divident.equals(divisor)) {
            return 1.0;
        } else {
            List<Integer> indexes = algebra.get(divident);
            for (int i = 0; i < indexes.size(); i++) {
                //System.out.println("use : " + myequations[indexes.get(i)][0] + " / " + myequations[indexes.get(i)][1] + " = " + myvalues[indexes.get(i)]);
                if (myequations[indexes.get(i)][0].equals(divident)) {
                    if (myequations[indexes.get(i)][1].equals(divisor)) {
                        return myvalues[indexes.get(i)];
                    }
                    double ans = divid(myequations[indexes.get(i)][1], divisor);
                    if (ans != -1.0) {
                        return myvalues[indexes.get(i)] * ans;
                    }
                } else {
                    if (myequations[indexes.get(i)][0].equals(divisor)) {
                        return 1 / myvalues[indexes.get(i)];
                    }
                    double ans = divid(myequations[indexes.get(i)][0], divisor);
                    if (ans != -1.0) {
                        return (1 / myvalues[indexes.get(i)]) * ans;
                    }
                }
            }
            return -1.0;
        }
    }
}