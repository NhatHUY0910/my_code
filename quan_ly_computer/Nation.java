package quan_ly_computer;

public class Nation {
    private String nationPass, nationName;

    public Nation(String nationPass, String nationName) {
        this.nationPass = nationPass;
        this.nationName = nationName;
    }

    public String getNationPass() {
        return nationPass;
    }

    public void setNationPass(String nationPass) {
        this.nationPass = nationPass;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
