package com.example.demo.dto;


public class DTO {
    private double min;
    private double max;
    private double avg;
    
	public void setMax(double maxi) {
		this.max = maxi;
	}
	public double getMax() {
		return this.max;
	}
	
	public void setMin(double mini) {
		this.min = mini;
	}
	public double getMin() {
		return this.min;
	}
	public void setAvg(double av) {
		this.avg = av;
	}
	public double getAvg() {
		return this.avg;
	}
}