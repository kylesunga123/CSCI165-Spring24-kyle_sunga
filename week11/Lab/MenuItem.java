/**
 * Kyle Sunga
 * March 9, 2024
 * CSCI165
 */

public class MenuItem {
    private String name;
    private double price = 1;
    private int calories = 0;
   /*
    * public MenuItem() {
        this(MenuItem.class.getName(), 0, 0);
    }
    */
   public MenuItem(){}
    
    /**
     * 
     * @param name     The name of item
     * @param price    THe price of item
     * @param calories the calories of item
     */
    public MenuItem(String name, double price, int calories) {
        setName(name);
        setPrice(price);
        setCalories(calories);
    }

   

    // GETTERS & SETTERS
   

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
   
    public void setPrice(double price) {
        this.price = (price > 0) ? price : this.price; //ensure price is greater than 0 default price is $1
    }
    public double getPrice() {
        return this.price;
    }
   
    public void setCalories(int calories){
        this.calories = (calories >= 0) ? calories : this.calories; //ensure cal is greater than or equal to 0. default is 0
    }
    public int getCalories() {
        return this.calories;
    }

    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                '}';
    }
    /** CHAT GPT GAVE ME THIS . NOT GOING TO USE IT
     * public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(menuItem.price, price) == 0 &&
                calories == menuItem.calories &&
                name.equals(menuItem.name);
    }
    */
    public boolean equals(MenuItem menuItem){
        return getName().equals(menuItem.getName())//name equals name of item in menu. 
        && (getPrice() == menuItem.getPrice()) //price equals price from menu item
        && (getCalories() == menuItem.getCalories()); // calories equal cals from item in menu
    }
    public int compareTo(MenuItem i){
        int thisCalorieValue = this.calories;
        int otherCalorieValue = i.calories;

        // if "this" menu item has less calories than the comparison, return 1
        if (thisCalorieValue < otherCalorieValue){
            return 1;
        }
        // if "this" menu item has more calories, return -1
        else if (thisCalorieValue > otherCalorieValue){
            return -1;
        }
        // if they have the same number of calories, return 0
        else{
            return 0;
        }
    }
     public String toReceiptString(){
        return String.format("%-32s $%.2f %10d", name, price, calories);
    }

    
}
