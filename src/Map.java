import java.util.ArrayList;

class Map<K, V>
{
	private ArrayList<HashMap<K, V>> array;
	
	private int count;
	
	private int size;
	
	public Map()
	{
		array = new ArrayList<>();
		count = 10;
		size = 0;

		for (int i = 0; i < count; i++)
		{
			array.add(null);
		}
	}
	
	public int size() 
	{
		return size; 
	}
	
	public boolean isEmpty() 
	{
		return size() == 0; 
	}

	private int getIndex(K key)
	{
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % count;
		return index;
	}

	public V remove(K key)
	{
		int index = getIndex(key);
		HashMap<K, V> head = array.get(index);
		HashMap<K, V> prev = null;
		while (head != null)
		{
			if (head.key.equals(key))
				break;
			
			prev = head;
			head = head.next;
		}
		
		if (head == null)
			return null;
		
		size--;
		
		if (prev != null)
			prev.next = head.next;
		
		else
		array.set(index, head.next);
		return head.value;
	}
	
	public V get(K key)
	{
		int index = getIndex(key);
		HashMap<K, V> head = array.get(index);
		
		while (head != null)
		{
			if (head.key.equals(key))
			{
				return head.value;
			}
			
			head = head.next;
		}
		return (null);
	}
	
	public void add(K key, V value)
	{
		int index = getIndex(key);
		HashMap<K, V> head = array.get(index);
		
		while (head != null)
		{
			if (head.key.equals(key))
			{
				head.value = value;
				return;
			}
			
			head = head.next;
		}
		
		size++;
		head = array.get(index);
		HashMap<K, V> newNode = new HashMap<K, V>(key, value);
		newNode.next = head;
		array.set(index, newNode);
		
		if ((1.0*size)/count >= 0.7)
		{
			ArrayList<HashMap<K, V>> temp = array;
			array = new ArrayList<>();
			count = 2 * count;
			size = 0;
			
			for (int i = 0; i < count; i++)
			{
				array.add(null);
			}
			
			for (HashMap<K, V> headNode : temp)
			{
				while (headNode != null)
				{
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}
}