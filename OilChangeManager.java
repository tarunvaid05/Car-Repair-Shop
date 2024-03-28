/*
Tarun Vaidhyanathan
115510562
Homework#2
 */
import java.util.*;
/**
 * This class represents an Oil Change Manager that manages Joe and Donny,
 * There is a menu for all operations
 */
public class OilChangeManager {
    /**
     * Main method to run the Oil Change Manager program.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args){
        CarList joe = new CarList();
        CarList donny = new CarList();
        CarList finishedList = new CarList();
        Car cutCar = null;

        System.out.println("Welcome to Tony's Discount Oil Change Computer Management System! It's way better than a rolodex, cork board, post-its, and pre-chewed bubblegum!\n");
        System.out.println("Menu:");
        System.out.println("\tL) Edit Job Lists for Joe and Donny");
        System.out.println("\tM) Merge Job Lists");
        System.out.println("\tP) Print Job Lists");
        System.out.println("\tF) Paste car to end of finished car list");
        System.out.println("\tS) Sort Job Lists");
        System.out.println("\tQ) Quit");

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("Please select an option: ");
            String choice = input.nextLine().trim().toUpperCase();
            switch (choice) {
                case "L":
                    System.out.print("Please select a list - Joe(J) or Donny (D): ");
                    String choiceL = input.nextLine().trim().toUpperCase();
                    switch (choiceL){
                        case "J":
                            System.out.println("Options:");
                            System.out.println("\tA) Add a car to the end of the list");
                            System.out.println("\tF) Cursor Forward");
                            System.out.println("\tH) Cursor to Head");
                            System.out.println("\tT) Cursor to Tail");
                            System.out.println("\tB) Cursor Backward");
                            System.out.println("\tI) Insert car before cursor");
                            System.out.println("\tX) Cut car at cursor");
                            System.out.println("\tV) Paste before cursor");
                            System.out.println("\tR) Remove cursor");
                            System.out.print("Please select an option: ");
                            String choiceLJ = input.nextLine().trim().toUpperCase();
                            switch(choiceLJ){
                                case "A":
                                    System.out.print("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                    String make = input.nextLine().trim().toUpperCase();

                                    if(make.equalsIgnoreCase("FORD")|| make.equalsIgnoreCase("GMC")||make.equalsIgnoreCase("CHEVY")||make.equalsIgnoreCase("JEEP")||
                                            make.equalsIgnoreCase("DODGE")||make.equalsIgnoreCase("CHRYSLER")||make.equalsIgnoreCase("LINCOLN")){
                                        System.out.print("Please enter owner's name: ");
                                        String owner = input.nextLine().trim();
                                        Car newCar = new Car(Car.Make.valueOf(make), owner);
                                        joe.appendToTail(newCar);
                                        System.out.println(newCar.toString() + " has been scheduled for an oil change with Joe and has been added to his list.");
                                    }
                                    else{
                                        System.out.println("We don't service " + make + "!");
                                    }
                                    break;
                                case "F":
                                    try{
                                        joe.cursorForward();
                                        System.out.println("Cursor Moved Forward in Joe's List.");
                                    }
                                    catch(EndOfListException e){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case "H":
                                    joe.resetCursorToHead();
                                    System.out.println("Cursor Moved To Head in Joe's List.");
                                    break;
                                case "T":
                                    joe.resetCursorToTail();
                                    System.out.println("Cursor Moved To Tail in Joe's List.");
                                    break;
                                case "B":
                                    try{
                                        joe.cursorBackward();
                                        System.out.println("Cursor Moved Backward in Joe's List.");
                                    }
                                    catch(EndOfListException e){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case "I":
                                    System.out.print("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                    String make2 = input.nextLine().trim().toUpperCase();

                                    if(make2.equalsIgnoreCase("FORD")|| make2.equalsIgnoreCase("GMC")||make2.equalsIgnoreCase("CHEVY")||make2.equalsIgnoreCase("JEEP")||
                                            make2.equalsIgnoreCase("DODGE")||make2.equalsIgnoreCase("CHRYSLER")||make2.equalsIgnoreCase("LINCOLN")){
                                        System.out.print("Please enter owner's name: ");
                                        String owner = input.nextLine().trim();
                                        Car newCar = new Car(Car.Make.valueOf(make2), owner);
                                        joe.insertBeforeCursor(newCar);
                                        System.out.println(newCar.toString() + " has been scheduled for an oil change with Joe and has been added to his list before the cursor.");

                                    }
                                    else{
                                        System.out.println("We don't service " + make2);
                                    }
                                    break;
                                case "X":
                                    try{
                                        cutCar = joe.getCursorCar();
                                        joe.removeCursor();
                                        System.out.println("Cursor cut in Joe's List.");
                                    }
                                    catch(EndOfListException e){
                                        System.out.println("The cursor is at the tail of the list!");
                                    }

                                    break;
                                case "V":
                                    if(cutCar != null){
                                        joe.insertBeforeCursor(cutCar);
                                        System.out.println("Cursor pasted in Joe's List.");
                                        cutCar = null;
                                    }
                                    else{
                                        System.out.println("Nothing to paste.");
                                    }
                                    break;
                                case "R":
                                    try{
                                        joe.removeCursor();
                                        System.out.println("Cursor removed in Joe's List.");
                                    }
                                    catch(EndOfListException e){
                                        System.out.println("The cursor is at the tail of the list!");
                                    }
                                    break;
                            }
                            break;

                        case "D":
                            System.out.println("Options:");
                            System.out.println("\tA) Add a car to the end of the list");
                            System.out.println("\tF) Cursor Forward");
                            System.out.println("\tH) Cursor to Head");
                            System.out.println("\tT) Cursor to Tail");
                            System.out.println("\tB) Cursor Backward");
                            System.out.println("\tI) Insert car before cursor");
                            System.out.println("\tX) Cut car at cursor");
                            System.out.println("\tV) Paste before cursor");
                            System.out.println("\tR) Remove cursor");
                            System.out.print("Please select an option: ");
                            String choiceLD = input.nextLine().trim().toUpperCase();
                            switch(choiceLD){
                                case "A":
                                    System.out.print("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                    String make = input.nextLine().trim().toUpperCase();

                                    if(make.equalsIgnoreCase("FORD")|| make.equalsIgnoreCase("GMC")||make.equalsIgnoreCase("CHEVY")||make.equalsIgnoreCase("JEEP")||
                                            make.equalsIgnoreCase("DODGE")||make.equalsIgnoreCase("CHRYSLER")||make.equalsIgnoreCase("LINCOLN")){
                                        System.out.print("Please enter owner's name: ");
                                        String owner = input.nextLine().trim();
                                        Car newCar = new Car(Car.Make.valueOf(make), owner);
                                        donny.appendToTail(newCar);
                                        System.out.println(newCar.toString() + " has been scheduled for an oil change with Donnie and has been added to his list.");
                                    }
                                    else{
                                        System.out.println("We don't service " + make + "!");
                                    }
                                    break;
                                case "F":
                                    try{
                                        if(donny.getNextCursorData() != null){
                                            donny.cursorForward();
                                            System.out.println("Cursor Moved Forward in Donny's List.");
                                        }
                                        else{
                                            System.out.println("The cursor is at the tail of the list");
                                        }
                                    }
                                    catch(EndOfListException e){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case "H":
                                    donny.resetCursorToHead();
                                    System.out.println("Cursor Moved To Head in Donny's List.");
                                    break;
                                case "T":
                                    donny.resetCursorToTail();
                                    System.out.println("Cursor Moved To Tail in Donny's List.");
                                    break;
                                case "B":
                                    try{
                                        donny.cursorBackward();
                                        System.out.println("Cursor Moved Backward in Donny's List.");
                                    }
                                    catch(EndOfListException e){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case "I":
                                    System.out.print("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                    String make2 = input.nextLine().trim().toUpperCase();

                                    if(make2.equalsIgnoreCase("FORD")|| make2.equalsIgnoreCase("GMC")||make2.equalsIgnoreCase("CHEVY")||make2.equalsIgnoreCase("JEEP")||
                                            make2.equalsIgnoreCase("DODGE")||make2.equalsIgnoreCase("CHRYSLER")||make2.equalsIgnoreCase("LINCOLN")){
                                        System.out.print("Please enter owner's name: ");
                                        String owner = input.nextLine().trim();
                                        Car newCar = new Car(Car.Make.valueOf(make2), owner);
                                        donny.insertBeforeCursor(newCar);
                                        System.out.println(newCar.toString() + " has been scheduled for an oil change with Donny and has been added to his list before the cursor.");

                                    }
                                    else{
                                        System.out.println("We don't service " + make2);
                                    }
                                    break;
                                case "X":
                                    try{
                                        cutCar = donny.getCursorCar();
                                        donny.removeCursor();
                                        System.out.println("Cursor cut in Donny's List.");
                                    }
                                    catch(EndOfListException e){
                                        System.out.println("The cursor is at the tail of the list!");
                                    }
                                    break;
                                case "V":
                                    if(cutCar != null){
                                        donny.insertBeforeCursor(cutCar);
                                        System.out.println("Cursor pasted in Donny's List.");
                                        cutCar = null;
                                    }
                                    else{
                                        System.out.println("Nothing to paste.");
                                    }

                                    break;
                                case "R":
                                    try{
                                        donny.removeCursor();
                                        System.out.println("Cursor removed in Donny's List.");
                                    }
                                    catch(EndOfListException e){
                                        System.out.println("The cursor is at the tail of the list!");
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
                case "M":
                    /**
                     * Wrote this code, but it messes up another field in code grade.
                     * Tried to have a base Merge method made and feel like I got the logic behind it.
                     */
//                    System.out.print("Please select a destination list - Joe (J) or Donny (D): ");
//                    String choiceM = input.nextLine().trim().toUpperCase();
//                    switch (choiceM){
//                        case "J":
//                            try{
//                                CarList merge = new CarList();
//                                joe.resetCursorToHead();
//                                donny.resetCursorToHead();
//                                int length = joe.numCars() + donny.numCars();
//                                for(int i = 0; i < length; i++){
//                                    merge.appendToTail(joe.getCursorCar());
//                                    joe.cursorForward();
//                                    merge.appendToTail(donny.getCursorCar());
//                                    donny.cursorForward();
//                                }
//                                System.out.println("Donny's list merged into Joe's");
//                            }
//                            catch(EndOfListException e){
//                                System.out.println("The cursor is at the tail of the list!");
//                            }
//                            break;
//                        case "D":
//                            try{
//                                CarList merge = new CarList();
//                                joe.resetCursorToHead();
//                                donny.resetCursorToHead();
//                                int length = joe.numCars() + donny.numCars();
//                                for(int i = 0; i < length; i++){
//                                    merge.appendToTail(donny.getCursorCar());
//                                    donny.cursorForward();
//                                    merge.appendToTail(joe.getCursorCar());
//                                    joe.cursorForward();
//                                }
//                                System.out.println("Donny's list merged into Joe's");
//                            }
//                            catch(EndOfListException e){
//                                System.out.println("The cursor is at the tail of the list!");
//                            }
//                            System.out.println("Joe's list merged into Donny's");
//                            break;
//                    }
                    break;
                case "P":
                    try{
                        System.out.println("Joe's List:");
                        System.out.println("Make        Owner");
                        System.out.println("----------------------");
                        Car joeCursorCar = joe.getCursorCar();
                        joe.resetCursorToHead();
                        if(joe.getCursorCar() == null){
                            System.out.println("[empty]");
                        }
                        else{
                            int count = 0;
                            while (joe.getCursorCar() != null){
                                if((joe.getCursorCar().getOwner().equals(joeCursorCar.getOwner())) && (joe.getCursorCar().getMake().equals(joeCursorCar.getMake()))){
                                    System.out.println("->" + joe.getCursorCar().getMake() + "      " + joe.getCursorCar().getOwner());
                                    joe.cursorForward();
                                    count++;
                                }
                                else{
                                    System.out.println(joe.getCursorCar().getMake() + "      " + joe.getCursorCar().getOwner());
                                    joe.cursorForward();
                                }
                            }
                            joe.resetCursorToHead();
                            while(count > 0){
                                joe.cursorForward();
                                count--;
                            }
                        }

                        System.out.println("Donny's List:");
                        System.out.println("Make        Owner");
                        System.out.println("----------------------");
                        Car donnyCursorCar = donny.getCursorCar();
                        donny.resetCursorToHead();
                        if(donny.getCursorCar() == null){
                            System.out.println("[empty]");
                        }
                        else{
                            int count2 = 0;
                            while (donny.getCursorCar() != null){
                                if((donny.getCursorCar().getOwner().equals(donnyCursorCar.getOwner())) && (donny.getCursorCar().getMake().equals(donnyCursorCar.getMake()))){
                                    System.out.println("->" + donny.getCursorCar().getMake() + "      " + donny.getCursorCar().getOwner());
                                    donny.cursorForward();
                                    count2++;
                                }
                                else{
                                    System.out.println(donny.getCursorCar().getMake() + "      " + donny.getCursorCar().getOwner());
                                    donny.cursorForward();
                                }
                            }
                            donny.resetCursorToHead();
                            while(count2 > 0){
                                donny.cursorForward();
                                count2--;
                            }
                        }

                        System.out.println("Finished List:");
                        System.out.println("Make        Owner");
                        System.out.println("----------------------");
                        if(finishedList.getCursorCar() == null){
                            System.out.println("[empty]");
                        }
                        else{
                            while (finishedList.getCursorCar() != null){
                                System.out.println(finishedList.getCursorCar().getMake() + "      " + finishedList.getCursorCar().getOwner());
                                finishedList.cursorForward();
                            }
                        }
                    }
                    catch(EndOfListException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "F":
                    if(cutCar != null){
                        finishedList.appendToTail(cutCar);
                        System.out.println("Car pasted in finished list.");
                        cutCar = null;
                    }
                    else{
                        System.out.println("Nothing to paste");
                    }
                    break;
                case "S":
                    break;
                case "Q":
                    System.out.println("Enjoy your retirement!");
                    System.exit(0);
                    break;
            }
        }

    }
}
