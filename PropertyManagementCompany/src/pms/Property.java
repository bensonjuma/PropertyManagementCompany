package pms;

/**
 * The Property class represents a basic building block of the property portfolio management system.
 * It contains information about a property, including its unique identifier, type or category, and size.
 */
public class Property {
    private int id;          // Unique identifier for the property
    private String type;     // Type or category of the property
    private double size;     // Size of the property in square meters

    /**
     * Constructs a Property object with the specified id, type, and size.
     *
     * @param id   The unique identifier of the property.
     * @param type The type or category of the property.
     * @param size The size of the property in square meters.
     */
    public Property(int id, String type, double size) {
        this.id = id;
        this.type = type;
        this.size = size;
    }

    /**
     * Returns the unique identifier of the property.
     *
     * @return The id of the property.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the type or category of the property.
     *
     * @return The type of the property.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the size of the property in square meters.
     *
     * @return The size of the property.
     */
    public double getSize() {
        return size;
    }

    /**
     * Sets the unique identifier of the property.
     *
     * @param id The id to set for the property.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the type or category of the property.
     *
     * @param type The type to set for the property.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the size of the property in square meters.
     *
     * @param size The size to set for the property.
     */
    public void setSize(double size) {
        this.size = size;
    }
}
