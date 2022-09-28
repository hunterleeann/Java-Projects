/**
 * Simulate the increase and decrease of the population of roaches based on simple mathematical operations
 *
 * @author Hunter Snyder
 */
public class RoachPopulation
{
    // instance variables - replace the example below with your own
    public static void main(String args[]){
        System.out.println("The population after doubling is " + breed(10));    //prints the population after doubling.
        System.out.println("The population after the first spray is " + spray(10,.9));    //prints the population after spray three times.

        System.out.println("The population after doubling a second time is " + breed(20));
        System.out.println("The population after the second spray is " + spray(20,.9));

        System.out.println("The population after doubling a third time is " + breed(40));
        System.out.println("The population after the third spray is " + spray(40,.9));

    }

    /**
     *
     * @param population
     * @return the population after breeding has occured
     */
    public static double breed(double population){
        population= population * 2;
        return population;
    }

    /**
     *
     * @param population
     * @param percent
     * @return the decrease in population based on the percent given as a parameter
     */
    public static double spray(double population, double percent)
    {
        population = (population*percent);
        return population;
    }


}
