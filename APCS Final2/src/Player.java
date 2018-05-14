import processing.event.KeyEvent;
/**
 * 
 * 	This class models the behavior of the player character from movement, to their health. The core aspects of a player such as level and weapons they have are stored in this class
 * 
 * @author David Dominique, Evan Su
 * @version 5/9/18
 *
 */
public class Player 
{
	char key;
	
	private Grid playerGrid;
	private int health=90;
	
	public boolean inCombat;
	
	public Player(Grid grid) {
		playerGrid = grid;
	}
	
	
	
	//use get Grid cord method to return player square, use it again to check the state of the square on top (via numbers), if 0, then it can move
	public boolean canMoveUp(int x, int y)
	{
//		System.out.println("can move up");
		
		int[][] moveIndex = {{x-1, y-1},{x-1, y},{x-1, y+1},
	            {x, y-1},/*(Cell @ x,y)*/{x, y+1},
	            {x+1, y-1},{x+1, y},{x+1, y+1}};
		
		if (y - 1 < 0) {
			return false;
		}
		
		if (playerGrid.getCords(x, y-1) == 0)
		{
//			System.out.println("true");
			return true;
		}
		
		else 
		{
//			System.out.println("false");
			return false;
		}
		
	}
		
			
		

	public boolean canMoveDown(int x, int y)
	{
		int[][] moveIndex = {{x-1, y-1},{x-1, y},{x-1, y+1},
	            {x, y-1},/*(Cell @ x,y)*/{x, y+1},
	            {x+1, y-1},{x+1, y},{x+1, y+1}};
		
		if (y+1 > (playerGrid.getDim() - 1)) {
			return false;
		}
		
		if (playerGrid.getCords(x, y + 1)==0)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
		
			
		}

	public boolean canMoveRight(int x, int y)
	{
		int[][] moveIndex = {{x-1, y-1},{x-1, y},{x-1, y+1},
	            			{x, y-1},/*(Cell @ x,y)*/{x, y+1},
	            			{x+1, y-1},{x+1, y},{x+1, y+1}};
		
		
		
		if (x + 1 > (playerGrid.getDim() - 1)) {
			return false;
		}
		
		
		else if (playerGrid.getCords(x + 1, y)==0)
		{
			return true;
		}
		
	
		
		else 
		{
			return false;
		}
		
		
		}




	public boolean canMoveLeft(int x, int y)
	{
		int[][] moveIndex = {{x-1, y-1},{x-1, y},{x-1, y+1},
	            {x, y-1},/*(Cell @ x,y)*/{x, y+1},
	            {x+1, y-1},{x+1, y},{x+1, y+1}};
		
		if (x - 1 < 0) {
			return false;
		}
		
		if (playerGrid.getCords(x - 1, y) == 0)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
		
		
			
		}

	public void moveUp (int x, int y)
	{
		
		if (canMoveUp(x,y) == true)
		{
			playerGrid.setState(x, y, 0);
			playerGrid.setState(x, y-1, 3);
			
		}
		

	}
	public void moveDown (int x, int y)
	{
		
		if (canMoveDown(x,y) == true)
		{
			playerGrid.setState(x, y, 0);
			playerGrid.setState(x, y+1, 3);
			
		}

	}
	public void moveRight (int x, int y)
	{
		if (canMoveRight(x,y) == true)
		{

				playerGrid.setState(x, y, 0);
				playerGrid.setState(x+1, y, 3);
				
			
		}

	}
	public void moveLeft (int x, int y)
	{

			if (canMoveLeft(x,y) == true)
			{
				playerGrid.setState(x, y, 0);
				playerGrid.setState(x-1, y, 3);
				
		}
		

	}
	
	public void setGrid(Grid g) {
		this.playerGrid =g;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth (int health)
	{
		this.health=health;
	}
	
	public void increaseHealth()
	{
		health+=5;
	}
	
	public void decreaseHealth()
	{
		health-=5;
	}
	
	public String healthToString()
	{
		String x = "Player Health:"+health;
		
		return x;
	}
	
	public String maxHealth()
	{
		return "Max health"; 
	}
	
	public boolean isAlive()
	{
		if (health>0)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	
	
	
	
}
