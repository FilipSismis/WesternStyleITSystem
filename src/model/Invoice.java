package model;

import java.util.Date;

public class Invoice {
	
	private String invoiceNo;
	private Date paymentDate;
	private double paidAmount;

	public Invoice(String invoiceNo, double paidAmount, Date paymentDate) {
		this.invoiceNo = invoiceNo;
		this.paidAmount = paidAmount;
		this.paymentDate = paymentDate;
}
	public String getInvoiceNo() {
		return this.invoiceNo;
	}
	public double getPaidAmount() {
		return this.paidAmount;
	}
	public Date getPaymentDate() {
		return this.paymentDate;
	}
	
}