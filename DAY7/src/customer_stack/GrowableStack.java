package customer_stack;

public class GrowableStack implements Stack {

	private Customer[] gs;
	private int top;
	public GrowableStack() {
		gs = new Customer[STACK_SIZE];
		top = -1;
	}
	public boolean isFull() {
		return (top + 1) == STACK_SIZE;
	}
	public void growArray() {
		Customer[] tmpArray = new Customer[STACK_SIZE * 2];
		for(int i = 0; i < gs.length; i++) {
			tmpArray[i] = gs[i];
		}
		gs = tmpArray;
	}
	@Override
	public void push(Customer c) {
		if(isFull()) {
			growArray();
		}
		gs[++top] = c;
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	@Override
	public Customer pop() {
		if(isEmpty()){
			throw new RuntimeException("Stack Underflow...");
		}
		return gs[top--];
	}

}
