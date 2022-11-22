package in.innoskrit.designpatterns.structural.decorator;

public class VegTopping implements PizzaDecorator {

    Pizza pizza;

    public VegTopping(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 15;
    }
}
