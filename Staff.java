package HIS;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Staff implements ActionListener
{
	
	JFrame frame1;
	JTabbedPane staffpane;	
	JPanel addtab,assigntab,vitalsigntab,doctab;
	JLabel name,id,gender,birthdate,floors,docname;
	JTextField namef,idf,genf,bf,floorname,docf;
	
	ArrayList <Patient> patientlist;//list of patients
	ArrayList<floor> floorlist;//list of floors
	ArrayList<Doctor> doctorlist;//list of docs
	
	floor floor1,floor2,floor3,floor4;
	
	JButton okbutton,illlist;
	
	JLabel fname1,cap1,spec1;
	JTextField fname1f,cap1f,spec1f; 
	JButton okfb;
	
	JLabel pid,temp,pres;
	JTextField pidt,tt,pt;
	JButton conf;
	
	JLabel doctname,ID,specialization,pass;
	
	JPanel statvals;
	JLabel patientid;
	JTextField patientidval;
	JButton search;
	
	Staff()
	{
		
		patientlist = new ArrayList<Patient>();
		
		frame1 = new JFrame();
		
		staffpane = new JTabbedPane();
		
		addtab = new JPanel();
		assigntab = new JPanel();
		
		addtab.setLayout(new GridLayout(7,2));
		assigntab.setLayout(new GridLayout(4,2));
		
		addtab.setName("Add Patient");
		assigntab.setName("Assign");
		
		floorlist = new ArrayList<floor>();
		floor1 = new floor();
		floor2 = new floor();
		floor3 = new floor();
		floor4 = new floor();
		
		floor1.setFloorname("1");
		floor2.setFloorname("2");
		floor3.setFloorname("3");
		floor4.setFloorname("4");
		
		floorlist.add(floor1);
		floorlist.add(floor2);
		floorlist.add(floor3);
		floorlist.add(floor4);
		
//==================================================================================================================================================		

		fname1 = new JLabel("Floor:");
		cap1 = new JLabel("Floor capacity:");
		spec1 = new JLabel("Specialization:");
		
		fname1f = new JTextField();
		cap1f = new JTextField();
		spec1f = new JTextField();
		
		okfb = new JButton("Add Specifications:");
		
		assigntab.add(fname1,0);
		assigntab.add(fname1f,1);
		assigntab.add(cap1,2);
		assigntab.add(cap1f,3);
		assigntab.add(spec1,4);
		assigntab.add(spec1f,5);
		assigntab.add(okfb,6);
		okfb.addActionListener(this);
//==================================================================================================================================================		
		
		name = new JLabel("Name:");
		id = new JLabel("ID:");
		gender = new JLabel("Gender:");
		birthdate = new JLabel("Date of Birth:");
		floors = new JLabel("Floor:");
		docname = new JLabel("Doctor:");
		
		namef = new JTextField();
		idf = new JTextField();
		genf = new JTextField();
		bf = new JTextField();
		floorname = new JTextField();
		docf = new JTextField();
		
		okbutton = new JButton("Add Patient");
		illlist = new JButton("Add the illness list!");
		
		okbutton.addActionListener(this);
		
		addtab.add(name,0);
		addtab.add(namef,1);
		addtab.add(id,2);
		addtab.add(idf,3);
		addtab.add(gender,4);
		addtab.add(genf,5);
		addtab.add(birthdate,6);
		addtab.add(bf,7);
		
		
		addtab.add(floors,8);
		addtab.add(floorname,9);
		
		addtab.add(docname,10);
		addtab.add(docf,11);
		
		addtab.add(okbutton,12);
		//addtab.add(s)
//==================================================================================================================================================				
		vitalsigntab = new JPanel(new GridLayout(4,2));
		vitalsigntab.setName("Vital Signs");
		pid = new JLabel("Patient ID:");
		temp = new JLabel("Temperature:");
		pres = new JLabel("Pressure:");
		
		pidt = new JTextField();
		tt = new JTextField();
		pt = new JTextField();
		
		conf = new JButton("Add Vital signs?");
		conf.addActionListener(this);
		
		vitalsigntab.add(pid,0);
		vitalsigntab.add(pidt,1);
		vitalsigntab.add(temp,2);
		vitalsigntab.add(tt,3);
		vitalsigntab.add(pres,4);
		vitalsigntab.add(pt,5);
		vitalsigntab.add(conf,6);
//==================================================================================================================================================		

		/**
		 *JPanel statvals;
	JLabel patientid;
	JTextField patientidval;
	JButton search; 
		 */
		
		statvals = new JPanel();
		statvals.setName("Report");
		
		statvals.setLayout(new GridLayout(3,2));
		
		patientid = new JLabel("Patient ID:");
		patientidval = new JTextField();
		
		statvals.add(patientid,0);
		statvals.add(patientidval,1);
		
		search = new JButton("Search");
		search.addActionListener(this);
		statvals.add(search);
		
//==================================================================================================================================================		
		
		staffpane.add(addtab);
		staffpane.add(assigntab);
		staffpane.add(vitalsigntab);
		staffpane.add(statvals);
		
		frame1.add(staffpane);
		frame1.pack();
		frame1.setVisible(true);
	}
	
	int find(ArrayList <floor> sample,String fname)
	{
		int j = -1;
		for(int i =0;i<sample.size();i++)
		{
			if(sample.get(i).getFloorname().equals(fname))
			{
				j = i;
				break;
			}
		}
		return j;
	}
	
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
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == okbutton)
		{
			int fi;
			String fn = floorname.getText();
			fi = find(floorlist,fn);
			String pn,pi,pg,pb,dn;
			
			pn = namef.getText();
			pi = idf.getText();
			pg = genf.getText();
			pb = bf.getText();
			dn = docf.getText();
			
			Patient ones = new Patient();
			ones.setName(pn);
			ones.setBirthday(pb);
			ones.setGender(pg);
			ones.setId(pi);
			ones.setDocname(dn);
			
			if(fi > -1)
			{
			
				if(floorlist.get(fi).getCapacity()>floorlist.get(fi).pl.size())
				{
					JOptionPane.showConfirmDialog(null, "Add patient?");
					patientlist.add(ones);
					floorlist.get(fi).pl.add(ones);

				}
				else
				{
					floorlist.get(fi).setCapacity(floorlist.get(fi).getCapacity()+1);
					//floorlist.get(fi).setNumpatients(floorlist.get(fi).getNumpatients()+1);
					JOptionPane.showConfirmDialog(null, "Increase the capacity of the floor?");
					patientlist.add(ones);
					floorlist.get(fi).pl.add(ones);
					JOptionPane.showConfirmDialog(null, "Patient is added!!!");
					
				}
				
			}
			else 
				JOptionPane.showMessageDialog(null, "FLOOR DOES NOT EXIST!");
			
		}
		
		else if(e.getSource() == okfb)
		{
			int fi;
			String fn = fname1f.getText();
			fi = find(floorlist,fn);
			
			if(fi>-1)
			{
				int num1 = Integer.parseInt(cap1f.getText());
				String specifica = spec1f.getText();
				
				JOptionPane.showConfirmDialog(null,"Add floor specifications!");
				
				floorlist.get(fi).setCapacity(num1);
				floorlist.get(fi).setSpecialization(specifica);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "FLOOR DOES NOT EXIST!");
			}
		}
		
		else if(e.getSource() == conf)
		{
			/*
			 * pidt = new JTextField();
		tt = new JTextField();
		pt = new JTextField();
			 * */
			String id = pidt.getText();
			int i = findp(patientlist,id);
			if(i>-1)
			{
			
				Long t;
				Long pres;
				
				t = (long) Double.parseDouble(tt.getText());
				pres = (long) Double.parseDouble(pt.getText());
				
				patientlist.get(i).vs.temperatures.add(t);
				patientlist.get(i).vs.bp.add(pres);
				
				if(t<35.5 || t>38)
				{
					JOptionPane.showMessageDialog(null,"WARNING!! ABNORMAL TEMPERATURES!");
				}
				
				if(pres<50||pres>100)
				{
					JOptionPane.showMessageDialog(null,"WARNING!! ABNORMAL PULSE!");
				}
				JOptionPane.showConfirmDialog(null,"Add vitals signs to patient "+patientlist.get(i).getName());
				
				
			}
			else
				JOptionPane.showMessageDialog(null, "PATIENT DOES NOT EXIST!");
			
		}
		
		else if(e.getSource()==search)
		{
			String pid2;
			pid2 = patientidval.getText();
			
			int num = findp(patientlist,pid2);
			if(num > -1)
			{
			
				patientlist.get(num).displaytable();
				
			}
			else
			{
				
				JOptionPane.showMessageDialog(null, num + "Patient does not exist!");
			}
		}
		
	}
}
