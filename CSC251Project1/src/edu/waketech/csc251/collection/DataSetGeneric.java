package edu.waketech.csc251.collection;

import java.util.ArrayList;

import edu.waketech.csc251.tools.Screener;

//A class that stores objects that implement the Measurable interface

public class DataSetGeneric<E extends Measurable> extends ArrayList<E>{

	public DataSetGeneric() {
		
	}
	
	//adds an object
	public boolean add(E objToAdd) {
		return super.add(objToAdd);
	}
	
	
	//gets the size of DataSetGeneric list.  Overrides ArrayList method
	@Override
	public int size() {
		return super.size();
	}
	
	//returns object with the smallest Measurable value in the list
	public E getMin() {
		if (isEmpty()) {
			return null;
		}
		E mEle = (E) get(0);
		for (int i = 1; i < size(); i++) {
			if (((Measurable) mEle).getMeasure() > (((Measurable) get(i)).getMeasure())) {
				mEle = (E) get(i);
			}
		}
		return mEle;
	}
	
	//returns object with the largest Measurable value in the list
	public E getMax() {
		if (isEmpty()) {
			return null;
		}
		E mEle = (E) get(0);
		for (int i = 1; i < size(); i++) {
			if (((Measurable) mEle).getMeasure() < (((Measurable) get(i)).getMeasure())) {
				mEle = (E) get(i);
			}
		}
		return mEle;
	}
	
	//returns the complete DataSetGeneric list
	public ArrayList<E> getList() {
		ArrayList<E> list = new ArrayList<E>();
		for (int i = 0; i < size(); i++) {
			list.add(super.get(i));
		}
		return list;
	}
	
	//returns a screened or filtered list of DataSetGeneric
	public ArrayList<E> getList(Screener<E> elementScreener) {
		ArrayList<E> screenedList = new ArrayList<E>();
		for (int i = 0; i < size(); i++) {
			if (elementScreener.test(super.get(i)) == true) {
				screenedList.add(super.get(i));
			}
		}
		return screenedList;
		
	}
	
	//Overrides the ArrayList toString method
	@Override
	public String toString() {
		return "DataSetGeneric [\n size()=" + size() + "\n getMin()=" + getMin() + "\n getMax()=" + getMax()
				+ "\n Generics=\n" + super.toString() + "]";
	}
}
