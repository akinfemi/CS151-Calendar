import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EventDisplayPanel extends JPanel {
	public enum FilterType{
		Day, Week, Month, Agenda
	}
	
	private CalendarWithEvents calendar;
	private FilterType filter = FilterType.Day;
	private int width;
	private int height;
	
	public EventDisplayPanel(CalendarWithEvents cal, int w, int h){
		calendar = cal;
		
		calendar.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				refreshView();
			}
		});
		//We want to track the width and height - we will use this info
		//to create the icons for each individual day later
		//when we are viewing events by week/month
		this.width = w;
		this.height = h;
		
		//This helps keep parent LayoutManagers from changing our size
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		
		//Set a border, just so we can visualize where it is for now
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void setFilterType(FilterType t){
		filter = t;
		refreshView();
	}
	
	private void refreshView(){
		//In here we will create and change the view to display
		//the events from a particular day/week/month or to show
		//the agenda view
	}
}
