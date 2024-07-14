package HIS;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Loginpage implements ActionListener
{
	JFrame loginframe;
	JPanel loginpan1;
	JTextField login,pass;
	JLabel loginlabel,passlabel;
	
	ArrayList<String> loginidsdocs = new ArrayList<String>();
	ArrayList<String> passwordsdocs = new ArrayList<String>();
	
	ArrayList<String> loginidsstaff = new ArrayList<String>();
	ArrayList<String> passwordsstaff = new ArrayList<String>();
	
	Loginpage()
	{
		loginframe = new JFrame("HIS login page");
		loginpan1 = new JPanel();
		loginpan1.setLayout(new GridLayout(2,2));
		
		loginlabel = new JLabel("Username: ");
		passlabel = new JLabel("Password: ");
		
		login = new JTextField();
		pass = new JTextField();
		
		loginpan1.add(loginlabel,0);
		loginpan1.add(login,1);
		loginpan1.add(passlabel,2);
		loginpan1.add(pass,3);
		
		loginidsstaff.add("St.sana");
		passwordsstaff.add("123");
		
		loginidsdocs.add("Dr.Khan");
		passwordsdocs.add("0505");
		
		login.addActionListener(this);
		pass.addActionListener(this);
		
		loginframe.add(loginpan1);
		loginframe.pack();
		loginframe.setVisible(true);
	}
	int find(ArrayList <String> sample,String us)
	{
		for(int i =0;i<sample.size();i++)
		{
			if(sample.get(i).equals(us))
			{
				return i;
			}
		}
		return -1;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String usname,passw;
		if(e.getSource() == pass)
		{
			usname = login.getText();
			passw = pass.getText();
			
			if(usname.charAt(0) =='D'&&usname.charAt(1)=='r')
			{
				int num = find(loginidsdocs,usname);
				if(num>-1)
				{
					if(passwordsdocs.get(num).equals(passw))
					{
						Doctor doc1 = new Doctor();
						doc1.docpage();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Login or Password!");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Wrong Login or Password!");
			}
			
			else if(usname.charAt(0)=='S' && usname.charAt(1)=='t')
			{
				int num = find(loginidsstaff,usname);
				if(num>-1)
				{
					if(passwordsstaff.get(num).equals(passw))
					{
						Staff staff1 = new Staff();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Login or Password!");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Wrong Login or Password!");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong Starter)");
			}
			
		}
		
	}
	public static void main(String args[])
	{
		Loginpage test = new Loginpage();
	}
}
