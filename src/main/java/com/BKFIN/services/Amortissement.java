package com.BKFIN.services;

public class Amortissement {

	double montantR;
	double interest;
	double amortissement;
	double mensualité;
	public double getMontantR() {
		return montantR;
	}
	public void setMontantR(double montantR) {
		this.montantR = montantR;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getAmortissement() {
		return amortissement;
	}
	public void setAmortissement(double amortissement) {
		this.amortissement = amortissement;
	}
	public double getMensualité() {
		return mensualité;
	}
	public void setMensualité(double mensualité) {
		this.mensualité = mensualité;
	}
	public Amortissement(double montantR, double interest, double amortissement, double mensualité) {
		super();
		this.montantR = montantR;
		this.interest = interest;
		this.amortissement = amortissement;
		this.mensualité = mensualité;
	}
	public Amortissement() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Amortissement [montantR=" + montantR + ", interest=" + interest + ", amortissement=" + amortissement
				+ ", mensualité=" + mensualité + "]";
	}
	
	
	
}
