package MaximizeMoney;
//https://www.hackerearth.com/challenges/hiring/ather-energy-hiring-challenge/algorithm/cowboyz-64c6e752/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Coin {
        int shopNo;
        String type;

        public Coin(int shopNo, String type) {
            this.shopNo = shopNo;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String xyz[] = br.readLine().split(" ");
        Integer X = Integer.parseInt(xyz[0]);
        Integer Y = Integer.parseInt(xyz[1]);
        Integer Z = Integer.parseInt(xyz[2]);
        Map<Double, List<Coin>> valueToCoinMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            String coins[] = br.readLine().split(" ");
            for (int j = 0; j < coins.length; j++) {
                addValueToMap(i, j, coins[j], valueToCoinMap);
            }
        }
        Set<Integer> unProcessedShops = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            unProcessedShops.add(i);
        }
        int i = 1;
        Iterator<Map.Entry<Double, List<Coin>>> iterator = valueToCoinMap.entrySet().iterator();
        Double totalValue = 0d;
        while (i <= N) {
            if (iterator.hasNext()) {
                Map.Entry<Double, List<Coin>> entry = iterator.next();
                List<Coin> value = entry.getValue();
                Double key = entry.getKey();
                if (value.size() > 1) {
                    for (int j = 0; j < value.size(); j++) {
                        Coin coin = value.get(j);
                        Integer shopNo = coin.shopNo;
                        String type = coin.type;
                        if (unProcessedShops.contains(shopNo)) {
                            if (type.equals("X") && X > 0) {
                                totalValue += key;
                                X--;
                                unProcessedShops.remove(shopNo);
                                i++;
                            } else if (type.equals("Y") && Y > 0) {
                                totalValue += key;
                                Y--;
                                unProcessedShops.remove(shopNo);
                                i++;
                            } else if (type.equals("Z") && Z > 0) {
                                totalValue += key;
                                Z--;
                                unProcessedShops.remove(shopNo);
                                i++;
                            }
                        }
                    }
                } else {
                    Coin coin = value.get(0);
                    int shopNo = coin.shopNo;
                    String type = coin.type;
                    if (unProcessedShops.contains(shopNo)) {
                        if (type.equals("X") && X > 0) {
                            totalValue += key;
                            X--;
                            unProcessedShops.remove(shopNo);
                            i++;
                        } else if (type.equals("Y") && Y > 0) {
                            totalValue += key;
                            Y--;
                            unProcessedShops.remove(shopNo);
                            i++;
                        } else if (type.equals("Z") && Z > 0) {
                            totalValue += key;
                            Z--;
                            unProcessedShops.remove(shopNo);
                            i++;
                        }
                    }
                }
            }
        }
        System.out.printf("%.0f", totalValue);
    }

    private static void addValueToMap(int shopNo, int j, String value, Map<Double, List<Coin>> valueToCoinMap) {
        Double val = Double.parseDouble(value);
        String type = "";
        if (j == 0) {
            type = "X";
        } else if (j == 1) {
            type = "Y";
        } else if (j == 2) {
            type = "Z";
        }
        if (valueToCoinMap.containsKey(val)) {
            List<Coin> coins = valueToCoinMap.get(val);
            coins.add(new Coin(shopNo, type));
            valueToCoinMap.put(val, coins);
        } else {
            List<Coin> coins = new ArrayList<>();
            coins.add(new Coin(shopNo, type));
            valueToCoinMap.put(val, coins);
        }
    }

}
