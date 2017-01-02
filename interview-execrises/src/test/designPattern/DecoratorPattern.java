package test.designPattern;

public class DecoratorPattern {

	public static void main(String[] args) {
		// without adding decorators
		Currency curr = new Dollar();
		System.out.println(curr.getDescription());

		// adding decorators
		Currency curr2 = new USDDecorator(new Dollar());
		System.out.println(curr2.getDescription());
	}
}

abstract class Currency {
	String description = "Unknown currency";
	public String getDescription() {
		return description;
	}
}

// Concrete Component
class Dollar extends Currency {
	double value;

	public Dollar() {
		description = "Default Dollar Description";
	}
}

// Decorator
abstract class Decorator extends Currency {
	public abstract String getDescription();

}

// Concrete Decorator
class USDDecorator extends Decorator {
	Currency currency;

	public USDDecorator(Currency currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return currency.getDescription() + "-(add your decoration here)";
	}
}
