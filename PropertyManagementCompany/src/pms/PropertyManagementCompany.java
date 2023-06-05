package pms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The PropertyManagementCompany class represents a company responsible for managing a property portfolio.
 */
public class PropertyManagementCompany {
    private String name;                        // Name of the property management company
    private double liquidity;                    // Amount of money currently held by the company
    private List<MarketProperty> portfolio;    // Portfolio of MarketProperty objects

    /**
     * Constructs a PropertyManagementCompany object with the specified name and an empty portfolio.
     *
     * @param name The name of the property management company.
     */
    public PropertyManagementCompany(String name) {
        this.name = name;
        this.liquidity = 0.0;
        this.portfolio = new ArrayList<>();
    }

    /**
     * Constructs a PropertyManagementCompany object with the specified name and portfolio.
     *
     * @param name     The name of the property management company.
     * @param portfolio The initial portfolio of MarketProperty objects.
     */
    public PropertyManagementCompany(String name, List<MarketProperty> portfolio) {
        this.name = name;
        this.liquidity = 0.0;
        this.portfolio = new ArrayList<>(portfolio);
    }

    /**
     * Returns the name of the property management company.
     *
     * @return The name of the company.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the liquidity (amount of money currently held) of the company.
     *
     * @return The liquidity of the company.
     */
    public double getLiquidity() {
        return liquidity;
    }

    /**
     * Returns the portfolio of MarketProperty objects managed by the company.
     *
     * @return The portfolio of properties.
     */
    public List<MarketProperty> getPortfolio() {
        return portfolio;
    }

    /**
     * Buys a property at the specified price and adds it to the company's portfolio.
     * The price is deducted from the company's liquidity.
     *
     * @param property The property to be bought.
     * @param price    The price at which the property is bought.
     */
    public void buyProperty(MarketProperty property, double price) {
        if (liquidity >= price) {
            property.setId(generateUniqueId());
            MarketProperty marketProperty = new MarketProperty(property.getId(), property.getType(), property.getSize(), price);
            portfolio.add(marketProperty);
            liquidity -= price;
            sortPortfolioByValuation();
        }
    }

    /**
     * Sells a property and adds the proceeds to the company's liquidity.
     *
     * @param property The property to be sold.
     */
    public void sellProperty(MarketProperty property) {
        if (portfolio.contains(property)) {
            double saleProceeds = property.getCurrentValuation();
            portfolio.remove(property);
            liquidity += saleProceeds;
        }
    }

    /**
     * Calculates the potential profit that would be made from selling a given property in the company's portfolio.
     *
     * @param property The property to calculate the potential profit for.
     * @return The potential profit from selling the property.
     */
    public double getPotentialProfit(MarketProperty property) {
        return property.calculateTotalProfit();
    }

    /**
     * Counts the total number of properties in the company's portfolio.
     *
     * @return The total number of properties in the portfolio.
     */
    public int countProperties() {
        return portfolio.size();
    }

    /**
     * Counts the number of properties in the company's portfolio whose current valuation is within a specified range.
     *
     * @param lowerBound The lower bound of the valuation range.
     * @param upperBound The upper bound of the valuation range.
     * @return The number of properties within the specified range.
     */
    public int countPropertiesWithinRange(double lowerBound, double upperBound) {
        int count = 0;
        for (MarketProperty property : portfolio) {
            double currentValuation = property.getCurrentValuation();
            if (currentValuation >= lowerBound && currentValuation <= upperBound) {
                count++;
            }
        }
        return count;
    }

    /**
     * Updates the valuations of all properties in the company's portfolio based on the given inflation rate and volatility coefficient.
     *
     * @param inflationRate         The inflation rate affecting property valuations.
     * @param volatilityCoefficient The coefficient representing market volatility.
     */
    public void updateAllValuations(double inflationRate, double volatilityCoefficient) {
        for (MarketProperty property : portfolio) {
            property.updateValuation(inflationRate, volatilityCoefficient);
        }
        sortPortfolioByValuation();
    }

    /**
     * Generates a unique ID for a property based on the current timestamp or any other desired mechanism.
     *
     * @return A unique ID for a property.
     */
    private int generateUniqueId() {
        return (int) System.currentTimeMillis();
    }

    /**
     * Sorts the company's portfolio of properties by their current valuation in descending order.
     */
    private void sortPortfolioByValuation() {
        Collections.sort(portfolio, (p1, p2) -> Double.compare(p2.getCurrentValuation(), p1.getCurrentValuation()));
    }
}
