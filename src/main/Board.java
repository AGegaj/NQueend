package main;

import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board {
	public int N;
	int[] board;
	public int cnt;
	public int row;
	public int column;
	
	public Board(int n)
	{
		N = n;
		board = new int[N];
		for (int i = 0; i < N; i++)
		{
			board[i] = 0;
		}
		cnt = 0;
	}
	
	public boolean isSafe(int Clm)
	{
		
		for (int i = 0; i < cnt; i++)
        {
			
            if ((board[i] == Clm) || Math.abs(Clm - board[i]) == (cnt - i) || (board[i] == column && Clm == row))
                return false;
        }
        return true;
	}
	
	
	public void place(int Clm)
	{
		if (Clm >= 0 && Clm < N)
		{
			board[cnt] = Clm;
			cnt++;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Bad Column");
		}
	}
	
	
	public boolean isGoal()
	{
		if (cnt == N)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	public void unPlace()
	{
		if (cnt > 0)
		{
			cnt--;
		}
	}
	
	Board DFS(Board board)
	{
		if (board.isGoal() == true)
		{
			return board;
		}
		else
		{
			for (int i = 0; i < board.N; i++)
			{
				if (board.isSafe(i))
				{
					board.place(i);
					Board res = DFS(board);
					if (res != null)
						return res;
					board.unPlace();
				}
			}
		}
		return null;
	}
	
	public String printSolution()
	{
		String solution = "";
		System.out.println("********************");
		 for(int i =0; i < N; i++) {
	        	for(int j = 0; j < N; j++)
	        	{
	        	
	        		if (j == board[i])
	        			solution += "1,";
	        		else
	        			solution += "0,";
	        							        			
	        	}
	        	solution += "\n";
	        }
		 System.out.println(solution);
		 System.out.println("********************");
		 return solution;
		
	}
	



}









