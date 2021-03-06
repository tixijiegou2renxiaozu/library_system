package model;

import java.sql.Date;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 用户借书订单的基本信息
 */
public class UserOrder {
    public String id;//用户借阅订单的id---pk
    public String userId;//借阅用户的id
    public String bookId;//借阅图书的id
    public Date borrowTime;//开始借阅的时间
    public Date returnTime;//还书的时间：未还书：1000-01-01；函还书：date;
    public int fineDay;//逾期的天数：未还书：-1；未逾期：0；逾期：x；
    public int alreadyPay;//逾期罚款的钱是否已交；已交：1；未交：0；未还书：-1；（未逾期时未缴纳也为0，缴纳了才为1）
    //未还书：fineDay=-1；
    //已还书：fineDay=0（未逾期）/x（逾期天数）;
    //  有罚款：
    //      已缴纳：alreadyPay=1；
    //      未缴纳：alreadyPay=0；
    //  无罚款：
    //      已缴纳：alreadyPay=1；
    //      未缴纳：alreadyPay=0；

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public int getFineDay() {
        return fineDay;
    }

    public void setFineDay(int fineDay) {
        this.fineDay = fineDay;
    }

    public int getAlreadyPay() {
        return alreadyPay;
    }

    public void setAlreadyPay(int alreadyPay) {
        this.alreadyPay = alreadyPay;
    }
}
