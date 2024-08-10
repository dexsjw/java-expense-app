import java.util.ArrayList;
import java.util.List;

public class ExpenseApp {
    public static void main(String[] args) {
        boolean isAppRunning = true;
        List<Float> expenseList = new ArrayList<>();

        do {
            String userInput = showMenu();
            int option = checkUserInputForInt(userInput);
            // int option = checkUserInput(userInput);
            
            switch (option) {
                case 1:{
                    addExpense(expenseList);
                    break;
                }
                case 2:{
                    displayExpenseList(expenseList);
                    break;
                }
                case 3:{
                    calculateTotalExpenses(expenseList);
                    break;
                }
                case 4:{
                    calculateAverageExpense(expenseList);
                    break;
                }
                case 5:{
                    clearAllExpenses(expenseList);
                    break;
                }
                case 6:{
                    System.out.println("Thank you for choosing our service, goodbye!");
                    isAppRunning = false;
                    break;
                }
                default: {
                    System.out.println("Invalid Input! Please enter a number between 1 to 6.\n");
                    break;
                }
            }

        } while (isAppRunning);
    }

    private static String showMenu() {
        System.out.println("===== Expense App =====");
        System.out.println("1. Add an expense");
        System.out.println("2. List all expenses");
        System.out.println("3. Calculate total expenses");
        System.out.println("4. Calculate average expense");
        System.out.println("5. Clear all expense");
        System.out.println("6. Exit");
        return System.console().readLine("Select an option: ");
    }

    // private static T checkUserInput(String userInput) {
    //     T number = 0;
    //     try {
    //         if (number instanceof int) {
    //             number = Integer.parseInt(userInput);
    //         } else if (number instanceof float) {
    //             number = Float.parseFloat(userInput);
    //         }
    //     } catch (NumberFormatException nfe) {
    //         System.out.println("Option selected is not a number, please try again using a number.");
    //         return number;
    //     }
    //     return number;
    // }

    private static int checkUserInputForInt(String userInput) {
        int option = 0;
        try {
            option = Integer.parseInt(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("Option selected is not an integer, please try again using an integer.");
            return option;
        }
        return option;
    }

    private static float checkUserInputForFloat(String userInput) {
        float expense = 0f;
        try {
            expense = Float.parseFloat(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("Expense is not a number, please try again.");
            return expense;
        }
        return expense;
    }

    private static void addExpense(List<Float> expenseList) {
        float expense = checkUserInputForFloat(System.console().readLine("Expense to add: "));
        boolean isAddExpenseSuccessful = expenseList.add(expense);
        String message = isAddExpenseSuccessful ? "Expense added successfully!\n" : "Expense added unsuccessfully, please try again\n";
        System.out.println("Current list of expenses: \n" + expenseList + "\n");
        System.out.println(message);
    }

    private static void displayExpenseList(List<Float> expenseList) {
        System.out.println("Current list of expenses: \n" + expenseList + "\n");
    }

    private static float calculateTotalExpenses(List<Float> expenseList) {
        float totalExpense = 0;
        for (float expense : expenseList) {
            totalExpense += expense;
        }
        System.out.println("Total Expenses: " + totalExpense + "\n");
        return totalExpense;
    }

    private static void calculateAverageExpense(List<Float> expenseList) {
        float totalExpense = calculateTotalExpenses(expenseList);
        System.out.println("Average Expense: " + (totalExpense / expenseList.size()) + "\n");
    }

    private static void clearAllExpenses(List<Float> expenseList) {
        expenseList.clear();
        System.out.println("All expenses cleared!");
        System.out.println("Current list of expenses: \n" + expenseList + "\n");
    }
}