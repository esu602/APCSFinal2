
//a representation of a single Grid, kind of like a board in a game.
//This class contains constructors for generating new Grids and has an internal array
public class Grid {

	private int board[][];
	
	public Grid() { //Creates an empty grid, good for testing
		//for now it'll just create an empty board
		board = new int[GridView.GRIDSIZE][GridView.GRIDSIZE];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = 0;
			}
				
		}
		
	}
	
	public int getCell(int i, int j) {
		return board[i][j];
	}
}
