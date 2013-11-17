package com.eleven.booklibrary.model;

public class BorrowKey {
    private Long bookNumber;

    private Long borrowerNumber;

    public Long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Long getBorrowerNumber() {
        return borrowerNumber;
    }

    public void setBorrowerNumber(Long borrowerNumber) {
        this.borrowerNumber = borrowerNumber;
    }
}