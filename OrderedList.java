import java.util.ArrayList;
public class OrderedList<T extends Comparable<T>>
{
	private ArrayList<T> elements;
	private int cursor;
	
	public OrderedList(int cap)
	{
		elements = new ArrayList<T>(cap);
		cursor=-1;
	}
	public OrderedList()
	{
		elements = new ArrayList<T>();
		cursor=-1;
	}
	public int size()
	{
		return elements.size();
	}
	public boolean isEmpty()
	{
		return elements.isEmpty();
	}
	public void clear()
	{
		elements.clear();
	}
	public T get(int pos)
	{
		if (pos<0||pos>=elements.size())
		{
			System.out.println("Index out of bounds");
			//System.exit(0);
			return null;
		}
		return elements.get(pos);
	}
	public T first()
	{
		if (elements.size()==0)
			return null;
		cursor=0;
		return elements.get(cursor);
	}
	public T next()
	{
		if (cursor<0||cursor==(elements.size()-1))
			return null;
		cursor++;
		return elements.get(cursor);
	}
	
	public void enumerate()
	{
		System.out.println(elements);
	}
	
	public int binarySearch(T item)
	{
		if (elements.size()==0)
			return -1;
			
		int lo=0, hi=elements.size()-1, mid=0;
		
		while (lo<=hi)
		{
			mid = (lo+hi)/2;
			int c = item.compareTo(elements.get(mid));
			if (c==0) return mid;
			if (c<0) hi = mid-1;
			if (c>0) lo = mid+1;
		}
		
		if (item.compareTo(elements.get(mid))<0)
			return (-(mid+1));
		else
			return (-(mid+2));
	}
	//add an item to the end of the ordered list
	//useful method for the two-finger walking algorithm
	public void add(T item)
	{
		elements.add(item);
		
	}
	
	public void insert(T item)
	{
		if (elements.size()==0)
		{
			elements.add(item);
			return;
		}
		int pos = binarySearch(item);
		if (pos>=0)
		{
			System.out.println("Item " + item + " already present");
			return;
		}
		else
			elements.add(-pos-1, item);
	}
	public void remove(T item)
	{
		int pos = binarySearch(item);
		if (pos<0)
		{
			System.out.println("No such element");
			//System.exit(0);
			return;
		}
		else
			elements.remove(pos);
			
	}
	public T remove(int pos)
	{
		return elements.remove(pos);
	}

	public static <T extends Comparable<T>> OrderedList<T> mergeLists(OrderedList<T> list1, OrderedList<T> list2){
		OrderedList<T> resultList = new OrderedList<T>();
		int f1=0;
		int f2=0;
		while((f1<list1.size()) && (f2<list2.size())){
		    if(list1.get(f1).compareTo(list2.get(f2))<0){
		        resultList.add(list1.get(f1));
		        f1++;
            }else if(list2.get(f2).compareTo(list1.get(f1))<0){
		        resultList.add(list2.get(f2));
		        f2++;
            }else{
		        resultList.add(list2.get(f2));
		        f1++;
		        f2++;
            }
        }
        if(f1==list1.size()){
            while(f2<list2.size()){
                resultList.add(list2.get(f2));
                f2++;
            }
        }
        if(f2==list2.size()){
            while(f1<list1.size()){
                resultList.add(list1.get(f1));
                f1++;
            }
        }
        return resultList;


	}
	
}
