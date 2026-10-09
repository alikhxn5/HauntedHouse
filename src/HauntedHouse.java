public class HauntedHouse {
    private boolean ghostPresent;
    private int candyCount;

    public HauntedHouse() {
        ghostPresent = true;
        candyCount = 10;
    }

    public boolean isGhostPresent() {
        return ghostPresent;
    }

    public void scareAwayGhost() {
        ghostPresent = false;
    }

    public void hauntThem(){
        ghostPresent = true;
        System.out.print("You are haunted once more.");
    }

    public void refillCandyBowl(int amount) {
        if (amount > 0) {
            candyCount += amount;
        }
    }

    public int trickOrTreat(int people){
        candyCount = candyCount - people;
        return people;
    }

    public int getCandyCount() {
        return candyCount;
    }

    public String spookySound() {
        return "Boo!";
    }



    @Override
    public String toString() {
        String result = "The house ";

        if(isGhostPresent()) {
            result += "is haunted by a Ghost and ";
        }
        result += "has " + candyCount + " candy.";
        return result;
    }

    public void RunningLow(){
        if (candyCount <= 0){
            candyCount = candyCount + 10;
            System.out.println("Candy is empty! 10 more have been granted.");
        }
    }
}

