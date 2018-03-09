package com.example.milankokic.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean isSolved;
    private boolean mRequiresPolice;

    public boolean ismRequiresPolice() {
        return mRequiresPolice;
    }

    public void setmRequiresPolice(boolean mRequiresPolice) {
        this.mRequiresPolice = mRequiresPolice;
    }

    public Crime (){
      mId = UUID.randomUUID();
      mDate = new Date();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public UUID getId() {
        return mId;
    }
}
