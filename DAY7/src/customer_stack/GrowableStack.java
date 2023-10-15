package customer_stack;

public class GrowableStack extends FixedStack {
	public GrowableStack() {
		super();
	}
	public boolean isFull() {
		return (top + 1) == STACK_SIZE;
	}
	public void growArray() {
		Customer[] tmpArray = new Customer[STACK_SIZE * 2];
		for(int i = 0; i < st.length; i++) {
			tmpArray[i] = st[i];
		}
		st = tmpArray;
	}
	@Override
	public void push(Customer c) {
		if(isFull()) {
			growArray();
		}
		st[++top] = c;
	}
}
