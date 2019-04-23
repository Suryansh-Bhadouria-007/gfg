package mock1.accounts;

import java.util.*;

/*
* Given a list accounts,
* each element accounts[i] is a list of strings,
* where the first element accounts[i][0] is a name,
* and the rest of the elements are emails representing emails of the account.

Now,
we would like to merge these accounts.
Two accounts definitely belong to the same person
if there is some email that is common to both accounts.
Note that even if two accounts have the same name,
they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format:
the first element of each account is the name,
and the rest of the elements are emails in sorted order.
The accounts themselves can be returned in any order.*/

public class Solution {
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
        List<List<String>> result = new ArrayList<>();
        Map<String, String> emailToNameMap = new HashMap<>();
        Map<String, String> auxMap = new HashMap<>();
        Set<String> names = new HashSet<>();
        List<Set<String>> sameNames = new ArrayList<>();
        Set<String> sameNamesSet = new TreeSet<>();
        for (List<String> account : accounts) {
            List<String> emailList = account.subList(1, account.size());
            String name = account.get(0);
            boolean alreadyAppeared = false;
            List<String> emailNotFound = new ArrayList<>();
            for (String email : emailList) {
                if (emailToNameMap.containsKey(email)) {
                    name = emailToNameMap.get(email);
                    alreadyAppeared = true;
                } else {
                    emailNotFound.add(email);
                }
            }
            if (alreadyAppeared) {
                if (emailNotFound.size() == 0 && emailList.size() > 1) {
                    Set<String> localNames = new TreeSet<>();
                    for (String email : emailList) {
                        localNames.add(emailToNameMap.get(email));
                    }
                    sameNames.add(localNames);
                    sameNamesSet.addAll(localNames);
                }
                for (String email : emailNotFound) {
                    emailToNameMap.put(email, name);
                }
            } else {
                String alternativeName = name;
                int i = 0;
                while (names.contains(alternativeName)) {
                    alternativeName = name + "_" + i;
                    i++;
                }
                for (String email : emailNotFound)
                    emailToNameMap.put(email, alternativeName);
                names.add(alternativeName);
            }
            names.add(name);
        }
        for (Map.Entry<String, String> entry : emailToNameMap.entrySet()) {
            if (sameNamesSet.contains(entry.getValue())) {
                String newName = getSet(entry.getValue(), sameNames);
                auxMap.put(entry.getKey(), newName);
            }
        }
        emailToNameMap.putAll(auxMap);
        Map<String, Set<String>> nameToEmailMap = new HashMap<>();
        for (Map.Entry<String, String> entry : emailToNameMap.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if (nameToEmailMap.containsKey(value)) {
                Set<String> emails = nameToEmailMap.get(value);
                emails.add(key);
                nameToEmailMap.put(value, emails);
            } else {
                Set<String> emails = new TreeSet<>();
                emails.add(key);
                nameToEmailMap.put(value, emails);
            }
        }
        for (Map.Entry<String, Set<String>> entry : nameToEmailMap.entrySet()) {
            String key = entry.getKey().split("_")[0];
            Set<String> value = entry.getValue();
            List<String> res = new ArrayList<>();
            res.add(key);
            res.addAll(new ArrayList(value));
            result.add(res);
        }
        return result;
    }

    private static String getSet(String value, List<Set<String>> sameNames) {
        for (Set<String> set : sameNames) {
            if (set.contains(value)) {
                List<String> l = new ArrayList<>(set);
                return l.get(0);
            }
        }
        return null;
    }
}
