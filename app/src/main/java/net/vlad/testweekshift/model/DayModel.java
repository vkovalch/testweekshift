package net.vlad.testweekshift.model;

import org.joda.time.DateTime;
/**
 * Created by 76672 on 04.02.2018.
 */

public class DayModel {
	
	private int fid;
	private DateTime fdate;
	private boolean fisSelected;
	private boolean fisHasShift;
	private int fShiftColor;
	private int fShiftCount;
	
	public int getFid() {
		return fid;
	}
	
	public void setFid(int pFid) {
		fid = pFid;
	}
	
	public DateTime getFdate() {
		return fdate;
	}
	
	public void setFdate(DateTime pFdate) {
		fdate = pFdate;
	}
	
	public boolean isFisSelected() {
		return fisSelected;
	}
	
	public void setFisSelected(boolean pFisSelected) {
		fisSelected = pFisSelected;
	}
	
	public boolean isFisHasShift() {
		return fisHasShift;
	}
	
	public void setFisHasShift(boolean pFisHasShift) {
		fisHasShift = pFisHasShift;
	}
	
	public int getShiftColor() {
		return fShiftColor;
	}
	
	public void setShiftColor(int pShiftColor) {
		fShiftColor = pShiftColor;
	}
	
	public int getShiftCount() {
		return fShiftCount;
	}
	
	public void setShiftCount(int pShiftCount) {
		fShiftCount = pShiftCount;
	}
   
    public DayModel(){
    	fdate = org.joda.time.DateTime.now();
    	fisSelected = false;
    	fisHasShift = false;
    	fShiftColor = 1;
    	fShiftCount = 0;
    }
    
    
}
