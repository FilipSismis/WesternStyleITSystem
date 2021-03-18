package model;

import java.time.LocalDate;

public class Invoice {
	
	private String invoiceNo;
	private LocalDate paymentDate;
	private double paidAmount;

	public Invoice(String invoiceNo, double paidAmount) {
		this.invoiceNo = invoiceNo;
		this.paidAmount = paidAmount;
	}
	
	public Invoice(String invoiceNo, double paidAmount, LocalDate paymentDate) {
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
	
	public LocalDate getPaymentDate() {
		return this.paymentDate;
	}
	
}