import java.util.LinkedList;

/*
 * Find moving average from the data stream in java
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

	Example:
	
	MovingAverage m = new MovingAverage(3);
	m.next(1) = 1
	m.next(10) = (1 + 10) / 2
	m.next(3) = (1 + 10 + 3) / 3
	m.next(5) = (10 + 3 + 5) / 3
 * 
 */
public class JetInterview3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
		
	}
	static class MovingAverage {
	    LinkedList<Integer> queue;
	    int windowSize;
	    long sum;
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        this.queue = new LinkedList<Integer>();
	        this.windowSize = size;
	        this.sum = 0;
	    }
	    
	    public double next(int val) {
	        queue.offer(val);
	        sum +=val;
	        if(queue.size() > windowSize){
	            sum -= queue.poll();
	        }
	        return (double)sum/queue.size();
	    }
	}

	/**
	 * Your MovingAverage object will be instantiated and called as such:
	 * MovingAverage obj = new MovingAverage(size);
	 * double param_1 = obj.next(val);
	 */

}
