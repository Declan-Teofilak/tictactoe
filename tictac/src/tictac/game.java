package tictac;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


//currently need to use playerX and playO move arrays to 
//continually remove whatever space was used i.e if
//x takes a1, go into the array and remove a1 from x's array

//this will allow me to run a check every turn to see if either player is missing the required pieces to win! i.e playerOMoves is missing a1, b2, c3. That is a diagonal win.
public class game extends Frame implements ActionListener{
	
	//buttons
	private Button a1;
	private Button a2;
	private Button a3;
	
	private Button b1;
	private Button b2;
	private Button b3;
	
	private Button c1;
	private Button c2;
	private Button c3;
	
	//button array to create for panel
	Button[] btns = {a1, a2, a3, b1, b2, b3, c1, c2, c3};
	
	//button names as strings for comparison purposes
	String[] btnsNames = {"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"};
	
	//arrays to add player moves to
	String[] playerXMoves;
	String[] playerOMoves;
	
	//array to compare player moves to check if win state is met
	String[] winA1 = {"a1", "a2", "a3"};
	
	//turn counter;
	int turn = 1;
	
	int xWins = 0;
	
	//player x counter
	int xTurn = 0;
	
	//player o counter
	int oTurn = 0;
	
	//score counter
	private int score = 0;
	
	public game()
	{
		Panel panelSpace = new Panel(new GridLayout(3,3));
		
		//construct and add buttons to panel
		for (int i = 0; i <= 8; i++)
		{
			btns[i] = new Button(btnsNames[i]);
			add(btns[i]);
			btns[i].addActionListener(this);
			panelSpace.add(btns[i]);
		}

		//general window info
		setLayout(new BorderLayout());
		add(panelSpace, BorderLayout.CENTER);
		setTitle("Tic Tac Toe");
		setSize(600, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new game();

	}
	//checks if pressed button is currently in use
	//if not returns that the move is legal
	//param e = clicked button
	//return legal = label of button is empty
	public boolean moveCheck(Button e)
	{
		boolean legal;
		if ( e.getLabel() != "X" && e.getLabel() != "O")
		{
			legal = true;
			return legal;
		}
		else
		{
			legal = false;
			return legal;
		}
		
		
	}
	public void move(ActionEvent e)
	{
		System.out.println(score);
		String findName;
		for (int i = 0; i < btns.length; i++)
		{
		if (e.getSource() == btns[i])
		{
			if (moveCheck(btns[i]) == true && (turn % 2) == 0)
			{
				turn++;
				findName = btns[i].getLabel();
				btns[i].setLabel("X");
				moveList(turn -1, findName);
				//moveList(playerXMoves, findName);
			}
			else if (moveCheck(btns[i]) == true && (turn % 2) != 0)
			{
				turn++;
				findName = btns[i].getLabel();
				btns[i].setLabel("O");
				moveList(turn -1, findName);
				//moveList(playerOMoves, find);
			}
		}
		}
		winCheck();
	}
	public void moveList(int a, String n)
	{
		playerXMoves[xTurn] = n;
		xTurn++;
		Arrays.sort(playerXMoves);
	}
	public void winCheck()
	{
		if (contains(playerXMoves, "a1", "a2", "a3"))
		{
			a2.setLabel("YOU WIN");
		}
		else
		{
			a2.setLabel("Is it even checking this?");
		}
	}
	public boolean contains(String[] s, String target1, String target2, String target3)
	{
		int win = 0;
		for (String n : s)
		{
			if (n == target1 || n == target2 || n == target3)
			{
				win++;
			}
		}
		if (win == 3)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		move(e);
	}

}
