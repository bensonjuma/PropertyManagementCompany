package pms;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        // Create properties
        Property property1 = new Property(1, "Studio", 15);
        Property property2 = new Property(2, "Apartment", 100);
        Property property3 = new Property(3, "House", 70);
        property3.setId(2);
        property3.setType("Apartment");
        property3.setSize(80.0);

        int id = property3.getId();
        String type = property3.getType();
        double size = property3.getSize();
        System.out.println("Id: " + id);
        System.out.println("Type: " + type);
        System.out.println("Size: " + size);

        // Create market properties
        MarketProperty marketProperty1 = new MarketProperty(4, "Apartment", 80, 200000);
        MarketProperty marketProperty2 = new MarketProperty(5, "House", 150, 500000);
        
        int idMarket = marketProperty2.getId();
        String typeMarket = marketProperty2.getType();
        double sizeMarket = marketProperty2.getSize();
        double initialPrice = marketProperty2.getInitialPrice();
        
        marketProperty2.updateValuation(0.05, 0.1);
        // Create property management company
        PropertyManagementCompany company = new PropertyManagementCompany("ABC Property Management");

        // Add properties to the company's portfolio
        company.buyProperty(marketProperty1, 200000);
        company.buyProperty(marketProperty2, 500000);

        // Print portfolio details
        System.out.println("Company Name: " + company.getName());
        System.out.println("Liquidity: $" + company.getLiquidity());
        System.out.println("Portfolio Size: " + company.countProperties());

        System.out.println("\nProperties in Portfolio:");
        List<MarketProperty> portfolio = company.getPortfolio();
        for (MarketProperty property : portfolio) {
            System.out.println("Property ID: " + property.getId());
            System.out.println("Type: " + property.getType());
            System.out.println("Size: " + property.getSize() + " sqm");
            System.out.println("Initial Price: $" + property.getInitialPrice());
            System.out.println("Current Valuation: $" + property.getCurrentValuation());
            System.out.println();
        }

        // Update valuations
        company.updateAllValuations(0.05, 0.1);

        System.out.println("Updated Portfolio Valuations:");
        for (MarketProperty property : portfolio) {
            System.out.println("Property ID: " + property.getId());
            System.out.println("Current Valuation: $" + property.getCurrentValuation());
            System.out.println();
        }

        // Sell a property and calculate potential profit
        if (!portfolio.isEmpty()) {
            MarketProperty propertyToSell = portfolio.get(0);
            double potentialProfit = company.getPotentialProfit(propertyToSell);

            System.out.println("Potential Profit from Selling Property ID " + propertyToSell.getId() + ": $" + potentialProfit);

            // Sell the property
            company.sellProperty(propertyToSell);

            // Print updated portfolio details
            System.out.println("\nUpdated Portfolio Size: " + company.countProperties());
            System.out.println("Updated Liquidity: $" + company.getLiquidity());
        } else {
            System.out.println("Portfolio is empty. No properties to sell.");
        }
    }
}
