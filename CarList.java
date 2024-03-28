/*
Tarun Vaidhyanathan
115510562
Homework#2
 */
/**
 * This class represents a doubly linked list of cars.
 * It has a head, tail, and cursor.
 * @author Tarun Vaidhyanathan
 */
public class CarList {
    private CarListNode head;
    private CarListNode tail;
    private CarListNode cursor;
    /**
     * Constructs a new CarList with no elements.
     * The head, tail, and cursor are set to null.
     */
    public CarList(){
        this.head = null;
        this.tail = null;
        this.cursor = null;
    }
    /**
     * Retrieves the number of cars in the list.
     *
     * @return The number of cars in the list
     * @throws EndOfListException If the cursor is at the tail of the list
     */
    public int numCars() throws EndOfListException{
        int count = 0;
        resetCursorToHead();
        while(cursor != null){
            count++;
            cursorForward();
        }
        return count;
    }
    /**
     * Retrieves the car at the current cursor position.
     *
     * @return The car at the cursor position, or null if the cursor is null
     */
    public Car getCursorCar(){
        if(cursor != null){
            return cursor.getData();
        }
        else{
            return null;
        }
    }
    /**
     * Moves the cursor to the head of the list.
     */
    public void resetCursorToHead(){
        if(head != null){
            cursor = head;
        }
        else{
            cursor = null;
        }
    }
    /**
     * Moves the cursor to the tail of the list.
     */
    public void resetCursorToTail(){
        if (tail != null){
            cursor = tail;
        }
        else{
            cursor = null;
        }
    }
    /**
     * Moves the cursor forward one position.
     *
     * @throws EndOfListException If the cursor is at the tail of the list
     */
    public void cursorForward() throws EndOfListException{
        if(cursor != null){
            cursor = cursor.getNext();
        }
        else{
            throw new EndOfListException("The cursor is at the tail of the list");
        }
    }
    /**
     * Retrieves the data of the next car after the cursor.
     *
     * @return The data of the next car after the cursor, or null if the next node is null
     */
    public Car getNextCursorData(){
        if(cursor.getNext() != null){
            return cursor.getNext().getData();
        }
        else{
            return null;
        }
    }
    /**
     * Moves the cursor backward one position.
     *
     * @throws EndOfListException If the cursor is at the tail of the list
     */
    public void cursorBackward() throws EndOfListException{
        if(cursor != null){
            cursor = cursor.getPrev();
        }
        else{
            throw new EndOfListException("The cursor is at the tail of the list!");
        }
    }
    /**
     * Inserts a new car before the cursor position.
     *
     * @param newCar The car to be inserted
     */
    public void insertBeforeCursor(Car newCar){
        CarListNode newNode = new CarListNode(newCar);
        if (cursor == null){
            head = newNode;
            cursor = newNode;
        }
        else if(cursor == head){
            newNode.setNext(head);
            head = newNode;
        }
        else{
            CarListNode temp = head;
            while(temp.getNext() != cursor){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(cursor);
        }
    }
    /**
     * Appends a new car to the tail of the list.
     *
     * @param newCar The car to be appended
     */
    public void appendToTail(Car newCar){
        CarListNode newNode = new CarListNode(newCar);
        if(tail == null){
            head = newNode;
        }
        else{
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        if(cursor == null){
            cursor = newNode;
        }
    }
    /**
     * Removes the car at the cursor position from the list.
     *Logic was done well just lacks the correct parameters for getPrev.
     * @return The removed car
     * @throws EndOfListException If the cursor is null
     */
    public Car removeCursor() throws EndOfListException {
        Car removedCar = this.getCursorCar();
        if (cursor == null) {
            throw new EndOfListException("");
        } else {
            if (cursor == head) {
                cursor = cursor.getNext();
                cursor.setPrev(null);
                head = cursor;
            }
            else if (cursor == tail) {
                tail = cursor.getPrev();
                cursor = cursor.getPrev();
                cursor.setNext(null);
                tail = cursor;
            }
            else {
                cursor.getPrev().setNext(cursor.getNext());
                cursor.getNext().setPrev(cursor.getPrev());
                cursor = cursor.getPrev();
            }
        }
        return removedCar;
    }
}





