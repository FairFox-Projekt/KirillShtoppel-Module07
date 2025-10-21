abstract class Beverage {
    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    private void boilWater() {
        System.out.println("Boiling water.");
    }
    private void pourInCup() {
        System.out.println("Pouring into cup.");
    }
    protected abstract void brew();
    protected abstract void addCondiments();
}

class Tea extends Beverage {
    protected void brew() {
        System.out.println("Steeping the tea.");
    }
    protected void addCondiments() {
        System.out.println("Adding lemon.");
    }
}
class Coffee extends Beverage {
    protected void brew() {
        System.out.println("Brewing the coffee.");
    }
    protected void addCondiments() {
        System.out.println("Adding sugar and milk.");
    }
}