import java.util.ArrayList;

class HashMap<K, V>
{
	K key;
	V value;
	
	HashMap<K, V> next;
	
	public HashMap(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
}
