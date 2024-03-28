/*
Tarun Vaidhyanathan
115510562
Homework#2
 */

/**
 * This class represents a CarListNode that has data, next, and prev
 *
 * @author Tarun Vaidhyanathan
 */
public class CarListNode {
    private Car data;
    private CarListNode next;
    private CarListNode prev;
    /**
     * Constructs a new CarListNode with the provided initial data.
     *
     * @param initData
     *        The initial data for the CarListNode
     */
    public CarListNode(Car initData){
        this.data = initData;
        this.next = null;
        this.prev = null;
    }
    /**
     * Retrieves the data stored in the CarListNode.
     *
     * @return The data stored in the CarListNode
     */
    public Car getData(){
        return this.data;
    }
    /**
     * Sets the data for the CarListNode.
     *
     * @param data
     *        The data to be set for the CarListNode
     */
    public void setData(Car data){
        this.data = data;
    }
    /**
     * Retrieves the next CarListNode in the sequence.
     *
     * @return The next CarListNode
     */
    public CarListNode getNext(){
        return this.next;
    }
    /**
     * Sets the next CarListNode in the sequence.
     *
     * @param next
     *        The next CarListNode to be set
     */
    public void setNext(CarListNode next){
        this.next = next;
    }
    /**
     * Retrieves the previous CarListNode in the sequence.
     *
     * @return The previous CarListNode
     */
    public CarListNode getPrev(){
        return this.prev;
    }
    /**
     * Sets the previous CarListNode in the sequence.
     *
     * @param prev
     *        The previous CarListNode to be set
     */
    public void setPrev(CarListNode prev){
        this.prev = prev;
    }

}
