package com.nt.model;

public class Customer 
{
private Integer Cno;
private String Cname;
private String Caddres;
private Double billAmount;
private Double discount;
private Double finalAmount;

		// setter gettter injection


public Integer getCno() {
	return Cno;
}
public void setCno(Integer cno) {
	Cno = cno;
}
public String getCname() {
	return Cname;
}
public void setCname(String cname) {
	Cname = cname;
}
public String getCaddres() {
	return Caddres;
}
public void setCaddres(String caddres) {
	Caddres = caddres;
}
public Double getBillAmount() {
	return billAmount;
}
public void setBillAmount(Double billAmount) {
	this.billAmount = billAmount;
}
public Double getDiscount() {
	return discount;
}
public void setDiscount(Double discount) {
	this.discount = discount;
}
public Double getFinalAmount() {
	return finalAmount;
}
public void setFinalAmount(Double finalAmount) {
	this.finalAmount = finalAmount;
}

}
