/**
 * Created by jch66 on 2/20/2016.
 */
class BeerProblem {
    final public static int DOLLAR_PER_BEER = 2;
    final public static int BOTTLE_PER_BEER = 2;
    final public static int CAP_PER_BEER = 4;

    int currentBeer, currentBottle, currentCap;
    int totalBeer;
    int iteration;

    public int solve(final int dollar, boolean debug=false) {
        totalBeer = 0;
        iteration  = 0;

        currentBeer = dollar / DOLLAR_PER_BEER;
        currentBottle = currentBeer;
        currentCap = currentBeer;
        totalBeer += currentBeer;

        while (currentBottle >= BOTTLE_PER_BEER || currentCap >= CAP_PER_BEER) {
            iteration++;
            if (debug) println "${iteration}: Total Bear=${totalBeer}, Current Beer=${currentBeer}, Current Bottle=${currentBottle}, Current Cap=${currentCap}"

            currentBeer = (int) (currentBottle / BOTTLE_PER_BEER) + (int) (currentCap / CAP_PER_BEER);
            currentBottle = currentBeer + currentBottle % BOTTLE_PER_BEER;
            currentCap = currentBeer + currentCap % CAP_PER_BEER;
            totalBeer += currentBeer;
        }

        iteration++;
        if (debug) println "${iteration}: Total Bear=${totalBeer}, Current Beer=${currentBeer}, Current Bottle=${currentBottle}, Current Cap=${currentCap}"

        return totalBeer;
    }

    public static void main(String[] args) {
        BeerProblem problem = new BeerProblem();
        for(int dollar=2;dollar<=1000;dollar+=2) {
            int totalBeer = problem.solve(dollar);
            int remainingBottle = problem.getCurrentBottle();
            int remainingCap = problem.getCurrentCap();
            println "Money=${dollar}: Total Bear=${totalBeer}, Remaining Bottle=${remainingBottle}, Remaining Cap=${remainingCap}"
        }
    }
}
