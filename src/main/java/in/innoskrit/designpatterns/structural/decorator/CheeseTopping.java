package in.innoskrit.designpatterns.structural.decorator;

public class CheeseTopping implements PizzaDecorator {

    Pizza pizza;

    public CheeseTopping(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 20;
    }
}
