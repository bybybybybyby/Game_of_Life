package life;

public class Universe {

    private String[][] currentGen;
//    private String[][] nextGen;

//    public void setNextGen(String[][] nextGen) {
//        this.nextGen = nextGen;
//    }

    public void setCurrentGen(String[][] currentGen) {
        this.currentGen = currentGen;
    }

    public String[][] getCurrentGen() {
        return currentGen;
    }

    public void printUniverse() {

        for (int i = 0; i < currentGen.length; i++) {
            for (int j = 0; j < currentGen.length; j++) {
                System.out.print(currentGen[i][j]);
            }
            System.out.println();
        }
    }

}
