package hashmapimplementation;

public class HashMap {

	int capacity=16;
	Node [] hashmapArray= new Node[capacity];
	Node node;
	public  HashMap(int capacity)
	{
		this.capacity=capacity;
		hashmapArray= new Node[capacity];
	}
	
	public Object put(Object key, Object value)
	{
		int index=0;

		if(key==null)
		{
			index=0;
		}else
		{
			index=key.hashCode()&hashmapArray.length-1;
		}
		Object oldValue= null;
		if(hashmapArray[index]==null)
		{
			node=new Node(key,value,null,key.hashCode());
			hashmapArray[index]=node;
		}else
		{
			node=hashmapArray[index];
			
			while(node.next!=null)
			{
				if( node.getKey()==key && node.getHash()==key.hashCode())
				{
					oldValue=node.getValue();
					node.setValue(value);
					break;
				}
				node=node.next;
			}
			if(oldValue==null)
			{
				Node newNode=new Node(key,value,null,key!=null?key.hashCode():0);
				node.next=newNode;
			}
		}
		return oldValue;
	}
	
	public Object get(Object key)
	{
		Object value=null;
		if(key==null && hashmapArray[0] !=null)
		{
			return hashmapArray[0].getValue();
		}
		int index=key.hashCode()&hashmapArray.length-1;
		Object oldValue= null;
		if(hashmapArray[index]==null)
		{
			return value;
		}else
		{
			node=hashmapArray[index];
			
			while(node!=null)
			{
				if( node.getKey()==key && node.getHash()==key.hashCode())
				{
					value=node.getValue();
					break;
				}
				node= node.next;
			}
			
		}
		return value;
	}
	
	public Boolean contains(Object key)
	{
		Boolean keyExist=false;
		if(key==null && hashmapArray[0] !=null)
		{
			return keyExist=true;
		}
		int index=key.hashCode()&hashmapArray.length-1;
		Object oldValue= null;
		if(hashmapArray[index]==null)
		{
			return keyExist=false;
		}else
		{
			node=hashmapArray[index];
			
			while(node!=null)
			{
				if( node.getKey()==key && node.getHash()==key.hashCode())
				{
					return keyExist=true;
				}
				node= node.next;
			}
			
		}
		return keyExist;
	}
	
}
