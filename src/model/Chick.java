package model;

public class Chick extends NPC{

    private boolean smashOrPass;

    public Chick(String name, double money, Room location, int bodyCount, int age, boolean smashOrPass) {
        super(name,money,location,bodyCount,age);
        this.smashOrPass = smashOrPass;
    }

    @Override
    public String generateSentence() {
        String output = "ouput";

        return output;
    }
}
