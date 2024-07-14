package HIS;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Doctor implements ActionListener
{
	
	String name,id,special;
	String passw;
	floor dfloor;
	
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getSpecial() 
	{
		return special;
	}
	public void setSpecial(String special) 
	{
		this.special = special;
	}
	public String getPassw() 
	{
		return passw;
	}
	public void setPassw(String passw) 
	{
		this.passw = passw;
	}

	public floor getDfloor() 
	{
		return dfloor;
	}
	public void setDfloor(floor dfloor) 
	{
		this.dfloor = dfloor;
	}
	
	JFrame dframe;
	JTabbedPane dpan;
	JPanel info,patientinfo,floorinfo;
	JLabel pil,fl,dname,dspec,fnum,favgtem,favgpre;//patient info label,floor info label,doctor name, doctor specialization. floor number, floor average temperatur,floor average pressure
	JTextField pilf,dnf,dsf,favgt,favgp;//patient text field,doc name field, doc specialization field.
	JLabel fn;
	
	int findp(ArrayList <Patient> sample,String fname)
	{
		int j =-1;
		for(int i =0;i<sample.size();i++)
		{
			if(sample.get(i).getId().equals(fname))
			{
				j = i;
				return j;
			}
		}
		
		return j;
	}
	
	
	public void docpage()
	{
		dframe = new JFrame("Doctors page!");
		
		info = new JPanel(new GridLayout(2,2));
		patientinfo = new JPanel();
		patientinfo.setLayout(new GridLayout(2,2));
		floorinfo = new JPanel();
		floorinfo.setLayout(new GridLayout());
		pil = new JLabel("Patient ID:");
		pilf = new JTextField();
		
		patientinfo.add(pil);
		patientinfo.add(pilf);
		pilf.addActionListener(this);
		
		dname = new JLabel("Name: ");
		dspec = new JLabel("Specialization: ");
		
		dnf = new JTextField();
		dsf = new JTextField();
		
		info.add(dname);
		info.add(dnf);
		info.add(dspec);
		info.add(dsf);
		
		fnum = new JLabel("Number of Patients: ");
		fn = new JLabel(Integer.toString(dfloor.pl.size()));
		
		
		
		dframe.add(info);
		dframe.add(patientinfo);
		dframe.add(floorinfo);
		
		dframe.pack();
		dframe.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource()==pilf)
		{
			String patientid = pilf.getText();
			int i = findp(dfloor.pl,patientid);
			
			if(i>-1)
			{
				JOptionPane.showMessageDialog(null, dfloor.pl.get(i).toString());
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Patient not found on your floor!");
			}
			
		}
		
	}
	
	
}
