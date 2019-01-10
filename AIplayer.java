package tictactoe;
//An object type representing the artificial intelligence player
public class AIplayer {
	private int[][] status;
	public Position lastMoveAI = new Position(0, 0);
	public final int x = 1;
	public final int o = -1;
	public final int empty = 0;
	public final int userWin = 1;
	public final int aiWin = -1;
	public final int draw = 0;
	public final int inProgress = 2;
	
	public AIplayer(){ // Creates a new AIplayer object with an empty status array
		status = new int[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				status[i][j] = empty;
			}
		}
	}
	
	public void updateStatus(int i, int j, int value) // Updates the specified button index to the desired value
	{
		status[i][j] = value;
	}
	
	public int play(Position ai, int difficulty) // Returns the current game state and AI's move indexes to the doMoveAI function
	{
		int gamestate = winState(status), finalI = 0, finalJ = 0, secondI = 0, secondJ = 0, maxGrade = -1000, secondGrade = -1000, moveGrade;
		if(gamestate == userWin || gamestate == draw)
		{
			return gamestate;
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if (status[i][j] == empty){
					moveGrade = -moveChooser(status, i, j, -1);
					if (moveGrade > maxGrade)
					{
						secondI = finalI;
						secondJ = finalJ;
						maxGrade = moveGrade;
						finalI = i;
						finalJ = j;
					}	
					else if(moveGrade > secondGrade)
					{
						secondGrade = moveGrade;
						secondI = i;
						secondJ = j;
					}
				}
			}
		}
		int rand = (int) (Math.random()* 100);
		if (rand > difficulty)
		{
			finalI = secondI;
			finalJ = secondJ;
		}
		ai.setI(finalI);
		ai.setJ(finalJ);
		lastMoveAI.setI(finalI);
		lastMoveAI.setJ(finalJ);
		updateStatus(ai.getI(), ai.getJ(), o);
		return winState(status);
	}
	
	private int winState(int[][] a){ // Checks for the current game state
		int sumD1 = 0;
		int sumD2 = 0;
		int sumLine = 0;
		int[] sum = new int[3]; 
		boolean isEmpty = false;
		for(int i = 0; i < 3; i++)
		{
			sumLine = 0;
			for (int j = 0; j< 3; j ++)
			{
				sumLine += a[i][j];
				if (i == j)
				{
					sumD1 += a[i][j];
				}
				if (i + j == 2)
				{
					sumD2 += a[i][j];
				}
				sum[j] += a[i][j];
				if (a[i][j] == empty)
				{
					isEmpty = true;
				}
			}
			if (sumLine == 3)
				return userWin;
			if (sumLine == -3)
				return aiWin;
		}
		if (sumD1 == 3 || sumD2 == 3)
			return userWin;
		if (sumD1 == -3 || sumD2 == -3)
			return aiWin;
		for (int i = 0; i< 3; i++)
		{
			if (sum[i] == 3)
				return userWin;
			if (sum[i] == -3)
				return aiWin;
			
		}
		if (!isEmpty)
		{
			return draw;
		}
		return inProgress;
	}
	
	private int moveChooser(int[][] A, int imove, int jmove, int turn) // Chooses the move for the AI to play
	{
		int[][] Anext = new int[3][3]; // generate a copy of the status array
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				Anext[i][j] = A[i][j];
			}
		}	
		Anext[imove][jmove] = turn;
		int grade = -1000, retGrd, w = winState(Anext);
		
		
		if (w != inProgress)
		{
			return w * 256; 
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if (Anext[i][j] == empty){
					retGrd = moveChooser(Anext, i, j, -turn) / 2;
					if (turn>0)
					{
						retGrd = -retGrd;
					}
					if (retGrd > grade)
					{
						grade = retGrd;
					}	
				}
			}
		}
		return -grade*turn;
	}


}
