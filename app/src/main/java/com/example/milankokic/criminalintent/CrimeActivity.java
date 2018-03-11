package com.example.milankokic.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_POSITION = ".crime_id";

    @Override
    protected Fragment createFragment() {
        int position = (int) getIntent().getSerializableExtra(EXTRA_CRIME_POSITION);
        return CrimeFragment.newInstance(position);
    }

    public static Intent newIntent(Context context, int position) {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_POSITION, position);
        return intent;
    }
}
