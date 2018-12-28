import java.util.*;
import java.util.Map.Entry;
public class Audible2 {

	List<List<Integer>> forwardRoute;
	public List<List<Integer>> getForwardRoute() {
		return forwardRoute;
	}
	public List<List<Integer>> getReturnRoute() {
		return returnRoute;
	}
	List<List<Integer>> returnRoute;
	int maxTravelDist; 
	Audible2(int dist){
		System.out.println("Constructor called..");
		maxTravelDist = dist;
		forwardRoute = new ArrayList<List<Integer>>();
		returnRoute = new ArrayList<List<Integer>>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Audible2 obj = new Audible2(10000);
		obj.initForwardRoute();
		obj.initReturnRoute();
		obj.printList(obj.getForwardRoute());
		obj.printList(obj.getReturnRoute());
		obj.printList(obj.bookNearestFlight());
	}
	public void initForwardRoute() {
		List<Integer> flist = new ArrayList<>();
		flist.add(1);flist.add(3000);
		forwardRoute.add(flist);
		flist = new ArrayList<>();
		flist.add(2);flist.add(6000);
		forwardRoute.add(flist);
		flist = new ArrayList<>();
		flist.add(3);flist.add(10000);
		forwardRoute.add(flist);
		flist = new ArrayList<>();
		flist.add(4);flist.add(9000);
		forwardRoute.add(flist);
	}
	public  void initReturnRoute() {
		List<Integer> rlist = new ArrayList<>();
		rlist.add(1);rlist.add(2000);
		returnRoute.add(rlist);
		rlist = new ArrayList<>();
		rlist.add(2);rlist.add(9000);
		returnRoute.add(rlist);
		/*rlist = new ArrayList<>();
		rlist.add(3);rlist.add(2000);
		returnRoute.add(rlist); */
		rlist = new ArrayList<>();
		rlist.add(4);rlist.add(5000);
		returnRoute.add(rlist);
	}
	public void printList(List<List<Integer>> list) {
		for(List<Integer> l : list) {
			for(Integer i : l) {
				System.out.print(""+i +", ");
			}
			System.out.println();
		}
		
	}
	public void printMap (Map<Integer,List<Integer>> myMap) {
		for(Entry<Integer, List<Integer>> keySet : myMap.entrySet()) {
			System.out.print("For key " +keySet.getKey() +" : ");
			for(Integer i : keySet.getValue()) {
				System.out.print(" "+i);
			}
			System.out.println();
		}
	}
	public List<List<Integer>> bookNearestFlight() {
			List<List<Integer>>[] storage = new ArrayList[maxTravelDist+1];
			Collections.sort(forwardRoute, new Comparator<List<Integer>>(){
				@Override
				public int compare(final List<Integer> i1 , final List<Integer> i2) {
						return i1.get(1) - i2.get(1);
					}
				});
			Collections.sort(returnRoute, new Comparator<List<Integer>>(){
				@Override
				public int compare(final List<Integer> i1 , final List<Integer> i2) {
						return i1.get(1) - i2.get(1);
					}
				});
			int fp = 0 , rp = returnRoute.size()-1;
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			int maxValue = Integer.MIN_VALUE;
			while(fp < forwardRoute.size() && rp >-1) {
				List<Integer> list1 = forwardRoute.get(fp);
				List<Integer> list2 = returnRoute.get(rp);
				int sum = list1.get(1) + list2.get(1);
				if(sum <= maxTravelDist) {
					if(storage[sum] == null)
						storage[sum] = new ArrayList();
					storage[sum].add(Arrays.asList(new Integer[]{list1.get(0), list2.get(0)}));
					fp++;
				}
				else {
					rp--;
				}
			}
			while(fp< forwardRoute.size()) {
				List<Integer> list1 = forwardRoute.get(fp);
				int sum = list1.get(1) + returnRoute.get(0).get(1);
				if(sum <= maxTravelDist) {
					if(storage[sum] == null)
						storage[sum] = new ArrayList();
					storage[sum].add(Arrays.asList(new Integer[]{list1.get(0), returnRoute.get(0).get(0)}));
				}
				fp++;
			}
			while(rp>-1) {
				List<Integer> list1 = returnRoute.get(rp);
				int sum = list1.get(1) + forwardRoute.get(forwardRoute.size()-1).get(1);
				if(sum <= maxTravelDist) {
					if(storage[sum] == null)
						storage[sum] = new ArrayList();
					storage[sum].add(Arrays.asList(new Integer[]{forwardRoute.get(forwardRoute.size()-1).get(0),list1.get(0)}));
					rp--;
				}
			}
			for(int k = maxTravelDist; k>=0 ; k--) {
				if(storage[k]!=null ) {
					ans.addAll(storage[k]);
					break;
				}
			}
			return ans;
	}

}
