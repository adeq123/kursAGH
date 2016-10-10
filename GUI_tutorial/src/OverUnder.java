import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OverUnder extends JFrame{
	
	int round = 1;
	int firstRand, rand2, rand3, rand4;
	
	JLabel firstLabel, secondLabel, thirdLabel, fourthLabel, or, winOrLose;
	JButton higher, lower;
	JMenuBar menubar;
	JMenu file;
	JMenuItem reset, exit;
	
	
	
	public OverUnder(){
	
		firstRand = (int) (Math.random()*20 + 1);
		
		Font font = new Font("SSerif", Font.BOLD, 16);
		
		setLayout(new GridLayout(3,1));
		
		menubar = new JMenuBar();
		setJMenuBar (menubar);
		
		file = new JMenu("File");
		menubar.add(file);
		
		reset = new JMenuItem("Restart");
		file.add(reset);
		
		exit = new JMenuItem("Quit");
		file.add(exit);
		
		systemClose s = new systemClose();
		exit.addActionListener(s);
		
		restartGame r = new restartGame();
		reset.addActionListener(r);
		
		Container pane = this.getContentPane();
		
		//top panel setup
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1, 4));
		
		firstLabel = new JLabel(" " + firstRand, SwingConstants.CENTER);
		firstLabel.setFont(font);
		top.add(firstLabel);
		
		secondLabel = new JLabel(" ", SwingConstants.CENTER);
		secondLabel.setFont(font);
		top.add(secondLabel);
		
		thirdLabel = new JLabel(" ", SwingConstants.CENTER);
		thirdLabel.setFont(font);
		top.add(thirdLabel);
		
		fourthLabel = new JLabel(" ", SwingConstants.CENTER);
		fourthLabel.setFont(font);
		top.add(fourthLabel);
		pane.add(top);
		
		//middle panel setup
		
		JPanel middle = new JPanel();
		middle.setLayout(new GridLayout(1, 3));
		
		higher = new JButton("HIGHER");
		middle.add(higher);
		
		or = new JLabel("OR", SwingConstants.CENTER);
		middle.add(or);
		
		lower = new JButton("LOWER");
		middle.add(lower);
		
		pane.add(middle);
		
		Event e = new Event();
		higher.addActionListener(e);
		lower.addActionListener(e);
		
		//simplest bottom panel ewver...
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 1));
		
		winOrLose = new JLabel("", SwingConstants.CENTER);
		winOrLose.setFont(font);
		bottom.add(winOrLose);
		pane.add(bottom);
		
	}
	
	public class Event implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String option = e.getActionCommand();
			
			if(round == 1){

				rand2 = (int) (Math.random()*20 + 1);
				secondLabel.setText("" + rand2);
				
				if(rand2 > firstRand && option.equals("HIGHER")){
					winOrLose.setText("Right, 2 more!");
					round++;
				}else if (rand2 < firstRand && option.equals("HIGHER")){
					winOrLose.setText("You Lost");
					higher.setEnabled(false);
					lower.setEnabled(false);
				}else if (rand2 > firstRand && option.equals("LOWER")){
					winOrLose.setText("You Lost");
					higher.setEnabled(false);
					lower.setEnabled(false);
				}else if (rand2 < firstRand && option.equals("LOWER")){
					winOrLose.setText("Right, 2 more!");			
					round++;
			}
			
		}else if(round == 2){
			
			rand3 = (int) (Math.random()*20 + 1);
			thirdLabel.setText("" + rand3);
			
			if(rand3 > rand2 && option.equals("HIGHER")){
				winOrLose.setText("Right, 1 more!");
				round++;
			}else if (rand3 < rand2 && option.equals("HIGHER")){
				winOrLose.setText("You Lost");
				higher.setEnabled(false);
				lower.setEnabled(false);
			}else if (rand3 > rand2 && option.equals("LOWER")){
				winOrLose.setText("You Lost");
				higher.setEnabled(false);
				lower.setEnabled(false);
			}else if (rand3 < rand2 && option.equals("LOWER")){
				winOrLose.setText("Right, 1 more!");	
				round++;
		}
			
		}else if(round == 3){
			
			rand4 = (int) (Math.random()*20 + 1);
			fourthLabel.setText("" + rand4);
			
			if(rand4 > rand3 && option.equals("HIGHER")){
				winOrLose.setText("Right, You won!");
				higher.setEnabled(false);
				lower.setEnabled(false);
			}else if (rand4 < rand3 && option.equals("HIGHER")){
				winOrLose.setText("You Lost");
				higher.setEnabled(false);
				lower.setEnabled(false);
			}else if (rand4 > rand3 && option.equals("LOWER")){
				winOrLose.setText("You Lost");
				higher.setEnabled(false);
				lower.setEnabled(false);
			}else if (rand4 < rand3 && option.equals("LOWER")){
				winOrLose.setText("Right, You won!");
				higher.setEnabled(false);
				lower.setEnabled(false);
			}
		
		}
			
		}
	}
	
	public class systemClose implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	
	public class restartGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			firstRand = (int) (Math.random()*20 +1);
			round =1;
			higher.setEnabled(true);
			lower.setEnabled(true);
			firstLabel.setText("" + firstRand);
			secondLabel.setText("");
			thirdLabel.setText("");
			fourthLabel.setText("");
			winOrLose.setText("");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		OverUnder gui = new OverUnder();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setSize(300, 150);
		gui.setTitle("High Lower Guessing Game");
		gui.setResizable(false);
		

	}

}
