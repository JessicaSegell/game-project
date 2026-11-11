public enum FighterType {
    HERO("Hero"),
    ENEMY("Enemy");

    private final String fighterType;

    FighterType(String fighterType){
        this.fighterType = fighterType;
    }

    public String getFighterType() {
        return fighterType;
    }
}
