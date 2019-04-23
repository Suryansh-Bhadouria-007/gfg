package StateElections;

import java.util.Objects;

public class PoliticalParty {
    private String symbol;
    private String name;
    private String partyPresident;

    public PoliticalParty(String symbol, String name, String partyPresident) {
        this.symbol = symbol;
        this.name = name;
        this.partyPresident = partyPresident;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyPresident() {
        return partyPresident;
    }

    public void setPartyPresident(String partyPresident) {
        this.partyPresident = partyPresident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliticalParty that = (PoliticalParty) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(name, that.name) &&
                Objects.equals(partyPresident, that.partyPresident);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, name, partyPresident);
    }
}
