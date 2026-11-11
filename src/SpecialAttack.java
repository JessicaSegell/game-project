public enum SpecialAttack {
    HAMMER_OF_JUSTICE("Hammer of Justice"),
    DEMONIC_EMBRACE("Demonic Embrace");

    private final String specialAttack;

    SpecialAttack(String specialAttack) {
        this.specialAttack = specialAttack;
    }

    public String getSpecialAttack(){
        return this.specialAttack;
    }
}
