abstract class Beverage {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    void boilWater() {
        System.out.println("Boiling water");
    }
    abstract void brew();
    void pourInCup() {
        System.out.println("Pouring into cup");
    }
    abstract void addCondiments();
}

class Tea extends Beverage {
    void brew() {
        System.out.println("Steeping the tea");
    }
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends Beverage {
    void brew() {
        System.out.println("Brewing the coffee");
    }
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}