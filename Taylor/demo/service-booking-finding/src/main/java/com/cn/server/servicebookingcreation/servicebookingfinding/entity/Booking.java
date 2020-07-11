package com.cn.server.servicebookingcreation.servicebookingfinding.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cn_booking")
public class Booking implements Serializable {

  private static final long serialVersionUID = -5809782578272943999L;

  @Id
  @Column(length = 32)
  private String bookingNumber;

  @Column(length = 30)
  private String bookingStatus;

  @Column(length = 30)
  private String port;

  public Booking() {
  }

  public Booking(String bookingNumber, String port) {
    this.bookingNumber = bookingNumber;
    this.port = port;
    this.bookingStatus = "Pending";
  }

  public String getBookingNumber() {
    return bookingNumber;
  }

  public void setBookingNumber(String bookingNumber) {
    this.bookingNumber = bookingNumber;
  }

  public String getBookingStatus() {
    return bookingStatus;
  }

  public void setBookingStatus(String bookingStatus) {
    this.bookingStatus = bookingStatus;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }
}
