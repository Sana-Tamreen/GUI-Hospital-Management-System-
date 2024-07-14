package HIS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

public class Patient
{
	
	String name,id,floor,gender,birthday;
	VitalSigns vs = new VitalSigns();
	floor fl;
	ArrayList<illness> illnesslist = new ArrayList<illness>();
	
	String docname;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getFloor() 
	{
		return floor;
	}
	public void setFloor(String floor) 
	{
		this.floor = floor;
	}
	public VitalSigns getVs() 
	{
		return vs;
	}
	public void setVs(VitalSigns vs) 
	{
		this.vs = vs;
	}
	public floor getFl() 
	{
		return fl;
	}
	public void setFl(floor fl) 
	{
		this.fl = fl;
	}
	
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public String getBirthday() 
	{
		return birthday;
	}
	public void setBirthday(String birthday) 
	{
		this.birthday = birthday;
	}
	public ArrayList<illness> getIllnesslist() 
	{
		return illnesslist;
	}
	public void setIllnesslist(ArrayList<illness> illnesslist) 
	{
		this.illnesslist = illnesslist;
	}
	
	@Override
	public String toString() 
	{
		final int maxLen = 10;
		return "Patient [name=" + name + ", id=" + id + ", floor=" + floor + ", vs=" + vs + ", fl=" + fl
				+ ", illnesslist="
				+ (illnesslist != null ? illnesslist.subList(0, Math.min(illnesslist.size(), maxLen)) : null) + "]";
	}
	public String getDocname() 
	{
		return docname;
	}
	public void setDocname(String docname) 
	{
		this.docname = docname;
	}

//==================================================================================================================================================
	JFrame tableframe;
	JPanel tablepanel;
	JTableHeader tabti;
	
	JTable statstable;
	TableColumn col;
	TableRow row;
	
	JLabel avgtemp,avgpress,tempval,pressval,mintl,mintlval,maxtl,maxtlval,minpl,minplval,maxpl,maxplval;
	
	public void displaytable()
	{
		tableframe = new JFrame(this.name+" Statistics");
		
		tablepanel = new JPanel();
		tablepanel.setLayout(new FlowLayout());
		
		
		String colnames[] = {"Tempertures","Pressure"}; 
		Object[][] data = new Object[vs.temperatures.size()][2]; 
		
		long tem=0;
		long pres=0;
		long mint,minp,maxt,maxp;
		
		mint = this.vs.temperatures.get(0);
		maxt = this.vs.temperatures.get(0);
		
		for(int i =0;i<this.vs.temperatures.size();i++)
		{
			data[i][0] = this.vs.temperatures.get(i);
			tem = tem+this.vs.temperatures.get(i);
			
			if(this.vs.temperatures.get(i)<mint)
			{
				mint = this.vs.temperatures.get(i);
			}
			
			if(this.vs.temperatures.get(i)>maxt)
			{
				maxt = this.vs.temperatures.get(i);
			}
			
		}
		
		minp = this.vs.bp.get(0);
		maxp = this.vs.bp.get(0);
		
		for(int i =0;i<this.vs.bp.size();i++)
		{
			data[i][1] = this.vs.bp.get(i);
			pres = pres+this.vs.bp.get(i);
			
			if(this.vs.bp.get(i)<minp)
			{
				minp = this.vs.bp.get(i);
			}
			
			if(this.vs.bp.get(i)>maxp)
			{
				maxp = this.vs.bp.get(i);
			}
			
		}
		
		statstable = new JTable(data,new Object[]{"Temperature","Pressure"});
		statstable.setName("STATS");
		
		tabti = statstable.getTableHeader();
		tabti.setBackground(Color.gray);
		statstable.setTableHeader(tabti);
		
		tablepanel.add(statstable);
		
		avgtemp = new JLabel("Average Temperature: ");
		avgpress = new JLabel("Average Pressure: ");
		
		tempval = new JLabel();
		tempval.setText(Double.toString(tem/this.vs.temperatures.size()));
		
		mintl = new JLabel("Min Temperature: ");
		mintlval = new JLabel();
		mintlval.setText(Double.toString(mint));
		
		maxtl = new JLabel("Max Temperature: ");
		maxtlval = new JLabel();
		maxtlval.setText(Double.toString(maxt));
		
		minpl = new JLabel("Min Pressure:");
		minplval = new JLabel();
		minplval.setText(Double.toString(minp));
		
		maxpl = new JLabel("Max Pressure:");
		maxplval = new JLabel();
		maxplval.setText(Double.toString(maxp));
		
		pressval = new JLabel();
		pressval.setText(Double.toString(pres/this.vs.bp.size()));
		tablepanel.add(avgtemp);
		tablepanel.add(tempval);
		tablepanel.add(avgpress);
		tablepanel.add(pressval);
		
		tablepanel.add(mintl);
		tablepanel.add(mintlval);
		
		tablepanel.add(maxtl);
		tablepanel.add(maxtlval);
		
		tablepanel.add(minpl);
		tablepanel.add(minplval);
		
		tablepanel.add(maxpl);
		tablepanel.add(maxplval);
		
		tableframe.add(tablepanel);
		tableframe.setVisible(true);
		tableframe.pack();
		
		//col = new TableColumn();
		//row = new TableRow();
		
	}
	
}
