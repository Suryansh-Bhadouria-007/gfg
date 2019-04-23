package mock1.accounts;

import java.util.*;

class Solution2 {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List l1 = new ArrayList();
        l1.addAll(Arrays.asList(new String[]{"David", "David0@m.co", "David1@m.co"}));
        accounts.add(l1);
        l1 = new ArrayList();
        l1.addAll(Arrays.asList(new String[]{"David", "David3@m.co", "David4@m.co"}));
        accounts.add(l1);
        l1 = new ArrayList();
        l1.addAll(Arrays.asList(new String[]{"David", "David4@m.co", "David5@m.co"}));
        accounts.add(l1);
        l1 = new ArrayList();
        l1.addAll(Arrays.asList(new String[]{"David", "David2@m.co", "David3@m.co"}));
        accounts.add(l1);
        l1 = new ArrayList();
        l1.addAll(Arrays.asList(new String[]{"David", "David1@m.co", "David2@m.co"}));
        accounts.add(l1);
        List<List<String>> lists = accountsMerge(accounts);
        for (List<String> l : lists) {
            System.out.println(l.toString());
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> nameToEmailMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            List<String> emails = account.subList(1, account.size());
            index++;
            if (nameToEmailMap.keySet().contains(name)) {
                boolean flag = true;
                for (Map.Entry<String, Set<String>> entry : nameToEmailMap.entrySet()) {
                    String key = entry.getKey();
                    if (key.contains(name) && flag) {
                        if (intersection(nameToEmailMap.get(key), emails)) {
                            Set<String> prevEmails = nameToEmailMap.get(key);
                            prevEmails.addAll(emails);
                            nameToEmailMap.put(name, prevEmails);
                            flag = false;
                        }
                    }
                }
                if (!flag) {
                    nameToEmailMap.put(name + "_" + index, new TreeSet<>(emails));
                }
            } else {
                nameToEmailMap.put(name, new TreeSet<>(emails));
            }

        }
        for (Map.Entry<String, Set<String>> entry : nameToEmailMap.entrySet()) {
            List<String> res = new ArrayList<>();
            res.add(entry.getKey().split("_")[0]);
            res.addAll(entry.getValue());
            result.add(res);
        }
        return result;
    }


    private static boolean intersection(Set<String> prevEmails, List<String> currentEmails) {
        for (String email : currentEmails) {
            if (prevEmails.contains(email))
                return true;
        }
        for (String email : prevEmails) {
            if (currentEmails.contains(email))
                return true;
        }
        return false;
    }
}