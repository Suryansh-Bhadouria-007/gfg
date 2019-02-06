import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedCities {
    private static Map<String, String> directlyConnectedCities = new HashMap<>();
    private static Map<String, Integer> cityToParentMap = new HashMap<>();
    static String cities[] = {"A", "B", "C", "D"};
    static List<String> cityList = Arrays.asList(cities);

    static {
        directlyConnectedCities.put("A", "B");
        directlyConnectedCities.put("B", "C");
        directlyConnectedCities.put("B", "D");
    }

    private static boolean isDirectlyConnected(String a, String b) {
        for (Map.Entry<String, String> entry : directlyConnectedCities.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if ((a.equalsIgnoreCase(key) && b.equalsIgnoreCase(value))
                    || (a.equalsIgnoreCase(value) && b.equalsIgnoreCase(key)))
                return true;
        }
        return false;
    }


    // A utility function to find the subset of an element i
    static int find(String i) {
        if (cityToParentMap.get(i) == -1)
            return cityList.indexOf(i);
        return find(cityList.get(cityToParentMap.get(i)));
    }

    // A utility function to do union of two subsets
    static void Union(int x, int y) {
        int xset = find(cityList.get(x));
        int yset = find(cityList.get(y));
        cityToParentMap.put(cityList.get(xset), yset);
    }

    public static void main(String[] args) {
        for (String city : cities) {
            cityToParentMap.put(city, -1);
        }
        for (int i = 0; i < cities.length; i++) {
            for (int j = i + 1; j < cities.length; j++) {
                if (isDirectlyConnected(cities[i], cities[j])) {
                    //found an edge
                    int x = find(cities[i]);
                    int y = find(cities[j]);
                    if (x != y)
                        Union(x, y);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : cityToParentMap.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    /*    System.out.println("A->B:" + isConnected("A", "B"));
        System.out.println("A->F:" + isConnected("A", "F"));
        System.out.println("C->D:" + isConnected("C", "D"));
        System.out.println("F->D:" + isConnected("F", "D"));
        System.out.println("I->J:" + isConnected("I", "J"));
        System.out.println("E->J:" + isConnected("E", "J"));
        System.out.println("A->F:" + isConnected("A", "F"));
        System.out.println("H->G:" + isConnected("H", "G"));
        System.out.println("B->B:" + isConnected("B", "B"));
        System.out.println("A->C:" + isConnected("A", "C"));
        System.out.println("A->G:" + isConnected("A", "G"));*/

    }

    private static boolean isConnected(String a, String b) {
        int i1 = find(a);
        int i2 = find(b);
        if (i1 == i2)
            return true;
        return false;
    }


}
