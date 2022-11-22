package in.innoskrit.designpatterns.structural.decorator;

public class DecoratorDriver {
    public static void main(String[] args) {
        Pizza pizza = new VegTopping(new CheeseTopping(new Farmhouse()));
        System.out.println(pizza.cost());
    }
}
