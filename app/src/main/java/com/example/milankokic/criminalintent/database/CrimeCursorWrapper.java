package com.example.milankokic.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.milankokic.criminalintent.database.CrimeDbSchema.CrimeTable;
import com.example.milankokic.criminalintent.model.Crime;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime(){
        String uuidString = getString(getColumnIndex(CrimeTable.UUID));
        String title = getString(getColumnIndex(CrimeTable.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        return crime;
    }
}
