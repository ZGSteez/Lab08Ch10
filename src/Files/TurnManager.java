package Files;

public class TurnManager {
	
	private boolean turn;
	
	public static class Item {
		
		public boolean active;
		public boolean turn;
		Item() {
			active = false;
			turn = false;
		}
	}
	
	TurnManager() {
		turn = false;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public void swapTurn() {
		turn = !turn;
	}
	
	public int victory(Item [][]token) {

		// check row victory player 1
		for (int i = 0; i < 3; i++)
			if (token[i][0].active && token[i][0].turn &&
				token[i][1].active && token[i][1].turn &&
				token[i][2].active && token[i][2].turn) 
				return 1;
			
		// check column victory player 1
		for (int i = 0; i < 3; i++)
			if (token[0][i].active && token[0][i].turn &&
				token[1][i].active && token[1][i].turn &&
				token[2][i].active && token[2][i].turn) 
				return 1;
			
		// check diagonal victory player 1
		if (token[0][0].active && token[0][0].turn && 
			token[1][1].active && token[1][1].turn && 
			token[2][2].active && token[2][2].turn)
			return 1;
		if (token[0][2].active && token[0][2].turn && 
			token[1][1].active && token[1][1].turn && 
			token[2][0].active && token[2][0].turn)
			return 1;
			
		
		// check row victory player 2
		for (int i = 0; i < 3; i++)
			if (token[i][0].active && !token[i][0].turn &&
				token[i][1].active && !token[i][1].turn &&
				token[i][2].active && !token[i][2].turn) 
				return 2;
			
		// check column victory player 2
		for (int i = 0; i < 3; i++)
			if (token[0][i].active && !token[0][i].turn &&
				token[1][i].active && !token[1][i].turn &&
				token[2][i].active && !token[2][i].turn) 
				return 2;
			
		// check diagonal victory player 2
		if (token[0][0].active && !token[0][0].turn && 
			token[1][1].active && !token[1][1].turn && 
			token[2][2].active && !token[2][2].turn)
			return 2;
		if (token[0][2].active && !token[0][2].turn && 
			token[1][1].active && !token[1][1].turn && 
			token[2][0].active && !token[2][0].turn)
			return 2;
		
		// check for a draw
		if (token[0][0].active && token[0][1].active && token[0][2].active && 
			token[1][0].active && token[1][1].active && token[1][2].active &&
			token[2][0].active && token[2][1].active && token[2][2].active)
			return 3;
		
		return 0;
	}
}
