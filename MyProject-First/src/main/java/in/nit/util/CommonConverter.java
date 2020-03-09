package in.nit.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonConverter {
	public static Map<Integer,String> convert(List<Object[]> list){
		
		Map<Integer,String> map=new HashMap<Integer, String>();
		
		for(Object[] ob:list) {
			map.put(Integer.valueOf(ob[0].toString()), ob[1].toString());
		}
		return map;
		
	}

}
