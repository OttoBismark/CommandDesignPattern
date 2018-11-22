public class Stock
{
	private String name = "ABC";
	private int quantity = 10;
	
	public void buy()
	{
		System.out.println("Stock [name :" +name+ ", quantity"+ quantity +"] bouqht");
	}
	
	public void sell()
	{
		System.out.println("Stock [name :" +name+ ", quantity"+ quantity +"] sold");
	}
}
