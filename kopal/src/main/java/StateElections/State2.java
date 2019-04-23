package StateElections;

import java.util.Map;

public class State2 {
    private String name;
    private String abbr;
    private Map<PoliticalParty, Long> partyToVoteMap;
    private int N;//max number of politicalParties per state

    public State2(String name, String abbr, Map<PoliticalParty, Long> partyToVoteMap, int n) throws Exception {
        this.name = name;
        this.abbr = abbr;
        N = n;
        if (partyToVoteMap != null || partyToVoteMap.keySet().size() > n)
            throw new Exception("Exceeded limit " + N + " for number of parties in the state");
        this.partyToVoteMap = partyToVoteMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public Map<PoliticalParty, Long> getPartyToVoteMap() {
        return partyToVoteMap;
    }

    public void setPartyToVoteMap(Map<PoliticalParty, Long> partyToVoteMap) {
        this.partyToVoteMap = partyToVoteMap;
    }

    public void addVotes(PoliticalParty party, Long add) {
        updateVotes(party, partyToVoteMap.get(party) + add);
    }

    public void subVotes(PoliticalParty party, Long sub) {
        updateVotes(party, partyToVoteMap.get(party) - sub);
    }

    public boolean updateVotes(PoliticalParty party, Long newVoteCount) {
        if (null != partyToVoteMap) {
            if (partyToVoteMap.containsKey(party)) {
                partyToVoteMap.put(party, newVoteCount);
            } else {
                if (partyToVoteMap.keySet().size() == N) {
                    //skip addition
                    System.out.println("Exceeded limit " + N + " for number of parties in the state");
                    return false;
                } else {
                    partyToVoteMap.put(party, newVoteCount);
                }
            }
        }
        return true;
    }


}

