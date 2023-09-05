//import java.util.Random;
import java.util.Scanner;

class TicTacToe
{
	static char[][] board ;
	
	public TicTacToe() // constructor 
	{
		board = new char[3][3];
		initBoard();
	}
	
	void initBoard() //initialization of board
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	
	static void displayBoard() // displaying the board
	{
		System.out.println("-------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	static void placeMark(int row, int col,char mark)
	{
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
			board[row][col]=mark;
		}
		else 
		{
			System.out.println("invalid Position");
		}
	}
	
	static boolean checkColWin()//checking the column win
	{
		for(int j=0;j<=2;j++)
		{
		if(board[0][j]!= ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
		{
			return true;
		}
		}
		return false;
	}
	
	static boolean checkRowWin()//checking the row win
	{
		for(int i=0;i<=2;i++)
		{
		if(board[i][0]!= ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
		{
			return true;
		}
		}
		return false;
	}
	
	static boolean checkDigWin()//checking the dig win
	{
		if(board[0][0]!=' '&& board[0][0]==board[1][1] && board[1][1]==board[2][2] 
		|| board[2][2]!=' '&& board[0][2]==board[1][1] && board[1][1]==board[2][0])
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}

class HumanPlayer
{
	String name;
	char mark;
	
	HumanPlayer(String name ,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	
	void makeMove()
	{
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
		do
		{
			System.out.println("Enter the row and col");
			row=sc.nextInt();
			col=sc.nextInt();
		}while(!isValidMove(row,col));
		{
			TicTacToe.placeMark(row, col, mark);
		}
	}
	
	boolean isValidMove(int row , int col)
	{
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
			if(TicTacToe.board[row][col]==' ')//check empty space -- if empty place the mark 
			{
				return true;
			}
		}
		return false;
	}
}

/*
class AIPlayer
{
	String name;
	char mark;
	
	AIPlayer(String name ,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	
	void makeMove()
	{
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
		do
		{
			Random r= new Random();
			row=r.nextInt(3);
			col=r.nextInt(3);
		}while(!isValidMove(row,col));
		{
			TicTacToe.placeMark(row, col, mark);
		}
	}
	
	boolean isValidMove(int row , int col)
	{
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
			if(TicTacToe.board[row][col]==' ')//check empty space -- if empty place the mark 
			{
				return true;
			}
		}
		return false;
	}
}*/

public class LaunchGame {

	public static void main(String[] args) {
		TicTacToe t= new TicTacToe();
		t.displayBoard();
		
		HumanPlayer p1=new HumanPlayer("Ashish" , 'X');
		HumanPlayer p2=new HumanPlayer("Nani" , 'O');
		
		HumanPlayer cp;
		cp = p1;
		while(true) {
		System.out.println(cp.name + " turn");
		cp.makeMove();
		TicTacToe.displayBoard();//Every time cp changes the board should be displayed 
		if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() 
				|| TicTacToe.checkDigWin())
		{
			System.out.println(cp.name+" has won the game");
			break;
		}
		else
		{
			if(cp == p1) // if cp=p1 then change it to p2
			{
				cp = p2;
			}
			else //if cp=p2 then change it to p1
			{
				cp = p1;
			}
		}
	}
	}
}
