package securityservices.core.components.shared.products;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import securityservices.core.components.shared.check.Check;

/*
 * AC5
 * Set && Usage (?)
 */
public class Stock {

		protected Map <String, Integer> stock = new HashMap();
		
		public int updateStock(String ref, int amount) 
		{
			int error = -1;
			
			if(Check.checkBlankOrNull(ref) == 0 && stock.containsKey(ref))
			{
				stock.put(ref, stock.get(ref) + amount);
				error = 0;
			}
			
			return error;
		}
		
		public int getAmount(String ref) 
		{	
			int error = -1;
			
			if(Check.checkBlankOrNull(ref) == 0 && stock.containsKey(ref))
			{
				error = stock.get(ref);
			}
			
			return error;
		}
		
		public int delStock(String ref) 
		{
			int error = -1;
			
			if(Check.checkBlankOrNull(ref) == 0 && stock.containsKey(ref))
			{
				stock.remove(ref);
				
				if(!stock.containsKey(ref)) error = 0;
			}
			
			return error;
		}
		
		public String[] getLines() 
		{
			String [] lines = {};
			
			Iterator iterator = stock.entrySet().iterator();
			
			while(iterator.hasNext())
			{
				for(int i = 0; iterator.hasNext(); i++)
				{
					Map.Entry pairs = (Map.Entry) iterator.next();
					lines[i] =  "{ " + pairs.getKey() + " : " + pairs.getValue() + " }";					
				}
			}			
			
			return lines;
		}
		
		public int getNumLines() 
		{
			return stock.size();
		}
}
