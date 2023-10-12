package customer_stack;

public class FixedStack implements Stack {
	private Customer[] fs;
	private int top;
	public FixedStack() {
		fs = new Customer[STACK_SIZE];
		top = -1;
		System.out.println("You can enter only "+ STACK_SIZE +" elements:");
	}
	public boolean isFull() {
		return (top + 1) == STACK_SIZE;
	}
	@Override
	public void push(Customer c) {
		if(isFull())
			throw new RuntimeException("Stack Overflow...");
		fs[++top] = c;
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	@Override
	public Customer pop() {
		if(isEmpty()){
			throw new RuntimeException("Stack Underflow...");
		}
		return fs[top--];
	}

}
