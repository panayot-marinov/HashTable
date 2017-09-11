import java.util.*;

class Main
{
	public static void main(String[] args)
	{
		Map<String, Integer> map = new Map<>();
		map.add("I",1 );
		map.add("will",2 );
		map.add("be", 3);
		map.add("try",4 );
		map.add("stupid",5 );
		map.add("map",6 );
		System.out.println(map.size());
		System.out.println("Removed at index: " + map.remove("be"));
		System.out.println(map.size());
		System.out.println("Removed at index: " + map.remove("stupid"));
		System.out.println(map.size());
		System.out.println(map.isEmpty());
	}
}
