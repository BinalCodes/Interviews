/*
 * Implement min stack with O(1) as the time
 * 
 */
public class PaperLessPost1 {
	static class Node{
		Node next;
		int val;
		int min;
		Node(int val, int min){
			this.val = val;
			this.min = min;
		}
	}
	Node top;
	public void push(int v) {
		if(top == null) {
			Node n = new Node(v,v);
			top = n;
		}
		else {
			Node n = new Node(v, Math.min(v, top.min));
			n.next = top;
			top =n;
		}
		System.out.println("Pushed "+v +" to the top of stack with min "+top.min);
	}
	public int pop() {
		if(top ==null)
			return -1;
		Node tmp = top;
		top = tmp.next;
		tmp.next = null;
		return tmp.val;
	}
	public int getMin() {
		if(top ==null)
			return -1;
		return top.min;
	}
	public static void main(String[] args) {
		PaperLessPost1 stack = new PaperLessPost1();
		stack.push(12);
		stack.push(31);
		stack.push(10);
		stack.push(1);
		stack.push(5);
		stack.push(14);
		System.out.println("Popped "+stack.pop());
		System.out.println("Popped "+stack.pop());
		System.out.println("Popped "+stack.pop());
		stack.push(4);
		System.out.println("Popped "+stack.pop());
		System.out.println("Minimum element is "+stack.getMin());
		stack.push(1);
		stack.push(114);

	}

}
