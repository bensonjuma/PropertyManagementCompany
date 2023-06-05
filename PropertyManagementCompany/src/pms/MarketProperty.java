package pms;

import java.util.Random;

/**
 * The MarketProperty class represents a property that is currently on the market.
 * It extends the Property class and includes additional information such as initial price and current valuation.
 */
public class MarketProperty extends Property {
    private double initialPrice;        // Initial pricing of the property
    private double currentValuation;    // Current valuation of the property

    /**
     * Constructs a MarketProperty object with the specified id, type, size, and initial price.
     *
     * @param id            The unique identifier of the property.
     * @param type          The type or category of the property.
     * @param size          The size of the property in square meters.
     * @param initialPrice  The initial pricing of the property.
     */
    public MarketProperty(int id, String type, double size, double initialPrice) {
        super(id, type, size);
        this.initialPrice = initialPrice;
        this.currentValuation = initialPrice;
    }

    /**
     * Returns the initial pricing of the property.
     *
     * @return The initial price of the property.
     */
    public double getInitialPrice() {
        return initialPrice;
    }

    /**
     * Returns the current valuation of the property.
     *
     * @return The current valuation of the property.
     */
    public double getCurrentValuation() {
        return currentValuation;
    }

    /**
     * Updates the valuation of the property based on the given inflation rate and volatility coefficient.
     *
     * @param inflationRate          The current market inflation rate.
     * @param volatilityCoefficient  The volatility coefficient describing the market conditions.
     */
    public void updateValuation(double inflationRate, double volatilityCoefficient) {
        Random random = new Random();
        double gaussianRandom = random.nextGaussian() * Math.sqrt(volatilityCoefficient);
        currentValuation = currentValuation * (1 + inflationRate + gaussianRandom);
    }

    /**
     * Calculates the total profit that would be made if the property were sold at its current valuation.
     *
     * @return The total profit from selling the property.
     */
    public double calculateTotalProfit() {
        return currentValuation - initialPrice;
    }

    /**
     * Calculates the relative profit that would be made if the property were sold at its current valuation.
     *
     * @return The relative profit from selling the property.
     */
    public double calculateRelativeProfit() {
        return calculateTotalProfit() / initialPrice;
    }
}
