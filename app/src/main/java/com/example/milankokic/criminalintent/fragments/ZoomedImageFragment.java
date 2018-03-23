package com.example.milankokic.criminalintent.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.milankokic.criminalintent.R;

public class ZoomedImageFragment extends DialogFragment {

    private static final String IMAGE_URI = "imageUri";

    private String imageUri;


    public ZoomedImageFragment() {
        // Required empty public constructor
    }

    public static ZoomedImageFragment newInstance(String param1) {
        ZoomedImageFragment fragment = new ZoomedImageFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_URI, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageUri = getArguments().getString(IMAGE_URI);
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_zoomed_image, null);
        ImageView image = v.findViewById(R.id.zoomed_image);
        image.setScaleType(ImageView.ScaleType.MATRIX);
        image.setImageURI(Uri.parse(imageUri));

        return new AlertDialog.Builder(getActivity()).setView(v).create();
    }

}
