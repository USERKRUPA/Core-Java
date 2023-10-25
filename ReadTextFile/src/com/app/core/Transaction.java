package com.app.core;

import java.util.Date;

public class Transaction {
	private Date txDate;
	private String narrat;
	private double wdrawlAmt;
	private double dpstAmt;
	public Transaction(Date txDate, String narrat, double wdrawlAmt, double dpstAmt) {
		super();
		this.txDate = txDate;
		this.narrat = narrat;
		this.wdrawlAmt = wdrawlAmt;
		this.dpstAmt = dpstAmt;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}
	public double getWdrawlAmt() {
		return wdrawlAmt;
	}
	public void setWdrawlAmt(double wdrawlAmt) {
		this.wdrawlAmt = wdrawlAmt;
	}
	public double getDpstAmt() {
		return dpstAmt;
	}
	public void setDpstAmt(double dpstAmt) {
		this.dpstAmt = dpstAmt;
	}
	public String getNarrat() {
		return narrat;
	}
	public void setNarrat(String narrat) {
		this.narrat = narrat;
	}
	@Override
	public String toString() {
		return "Transaction [txDate=" + txDate + ", narrat=" + narrat + ", wdrawlAmt=" + wdrawlAmt + ", dpstAmt="
				+ dpstAmt + "]";
	}
	
}
