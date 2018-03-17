package com.example.milankokic.criminalintent.activities;

import android.support.v4.app.Fragment;

import com.example.milankokic.criminalintent.fragments.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
