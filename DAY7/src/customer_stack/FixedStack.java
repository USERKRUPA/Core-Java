package customer_stack;

public class FixedStack implements Stack {
	protected Customer[] st;
	protected int top;
	public FixedStack() {
		st = new Customer[STACK_SIZE];
		top = -1;
		System.out.println("You can enter only "+ STACK_SIZE +" elements:");
	}
	public boolean isFull() {
		return (top + 1) == STACK_SIZE;
	}
	@Override
	public void push(Customer c) throws StackException {
		if(isFull())
			throw new StackException("Stack Overflow...");
		st[++top] = c;
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	@Override
	public Customer pop() throws StackException {
		if(isEmpty()){
			throw new RuntimeException("Stack Underflow...");
		}
		return st[top--];
	}

}
