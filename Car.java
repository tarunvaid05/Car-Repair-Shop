/*
Tarun Vaidhyanathan
115510562
Homework#2
 */
/**
 * This class represents a car that has a make and owner
 *
 * @author Tarun Vaidhyanathan
 */
public class Car {
    private Make make;
    public String owner;
    /**
     * Represents the make of the car.
     */
    public enum Make{
        FORD,GMC,CHEVY,JEEP,DODGE,CHRYSLER,LINCOLN
    }

    /**
     * Default Constructor.
     */
    public Car(){
    }
/**
 * This is a Constructor used to create a new Car object
 *
 * @param make
 * The make of a car
 * @param owner
 * The owner of a car
 **/
    public Car(Make make, String owner){
        this.make = make;
        this.owner = owner;
    }
    /**
     * This method retrieves the make of the car.
     *
     * @return The make of the car
     */
    public Make getMake(){
        return this.make;
    }
    /**
     * This method sets the make of the car.
     *
     * @param make
     *        The make of the car to be set
     */
    public void setMake(Make make){
        this.make = make;
    }
    /**
     * This method retrieves the owner of the car.
     *
     * @return The owner of the car
     */
    public String getOwner(){
        return this.owner;
    }
    /**
     * This method sets the owner of the car.
     *
     * @param owner
     *        The owner of the car to be set
     */
    public void setOwner(String owner){
        this.owner = owner;
    }
    /**
     * Overrides the toString method to provide a string representation of the Car object.
     *
     * @return A string representation of the Car object, including the owner and make of the car
     */
    @Override
    public String toString(){
        return this.getOwner() + "'s " + this.getMake();
    }
}