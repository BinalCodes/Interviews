import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given points find the k closet points to the origin
 * 
 */
public class Audible1 {

	public static void main(String[] args) {
		int numDestinations = 3;
		List<Integer> location = new ArrayList<Integer>();
		location.add(11);location.add(3);
		List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		allLocations.add(location);
		location = new ArrayList<Integer>();
		location.add(-1);location.add(2);
		allLocations.add(location);
		location = new ArrayList<Integer>();
		location.add(-2);location.add(5);
		allLocations.add(location);
		location = new ArrayList<Integer>();
		location.add(-1);location.add(4);
		allLocations.add(location);
		Audible1 aud = new Audible1();
		aud.printList(aud.ClosestXdestinations(numDestinations,allLocations, 1));
	}
	public List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
			int numDeliveries) {
		PriorityQueue<List<Integer>> q = 
				new PriorityQueue<List<Integer>>(numDeliveries, new Comparator<List<Integer>>() {
					@Override
					public int compare(List<Integer> o1, List<Integer> o2) {
						double i1 = getDistance(o1.get(0), o1.get(1));
						double i2 =  getDistance(o2.get(0), o2.get(1));
						return i2>i1? 1:-1;
					}
			
		});
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int count=0;
		for(List<Integer> loc : allLocations) {
			q.offer(loc);
			if(count > numDeliveries)
				q.poll();
			count++;
		}
 		for(List<Integer> l : q) {
 			ans.add(l);
 		}
 		return ans;
	}
	
	public Double getDistance(int x, int y) {
		return (Math.sqrt(x*x + y*y));
	}
	
	public void printList(List<List<Integer>> list) {
		for(List<Integer> l : list) {
			System.out.println("Points are "+l.get(0) +" "+l.get(1));
		}
	}
}
