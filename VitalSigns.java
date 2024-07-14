package HIS;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

public class VitalSigns 
{
	
	ArrayList<Long> temperatures = new ArrayList<Long>();
	ArrayList<Long> bp = new ArrayList<Long>();
	
	public ArrayList<Long> getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(ArrayList<Long> temperatures) {
		this.temperatures = temperatures;
	}
	public ArrayList<Long> getBp() {
		return bp;
	}
	public void setBp(ArrayList<Long> bp) {
		this.bp = bp;
	}
	@Override
	public String toString() {
		return "VitalSigns [temperatures=" + temperatures + ", bp=" + bp + "]";
	}
	
}
