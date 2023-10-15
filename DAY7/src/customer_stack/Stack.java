package customer_stack;
/*
 * push & pop functionality for Customer refs. 
 * & declare STACK_SIZE as a constant. 
 */
public interface Stack {
	int STACK_SIZE = 5;
	void push(Customer c) throws StackException;
	Customer pop()throws StackException;
}
