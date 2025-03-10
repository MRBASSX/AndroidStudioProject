package com.example.facebook.ui.gallery;

import android.app.Activity;
import android.app.backup.BackupDataOutput;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.facebook.R;
import com.example.facebook.account.MainActivity;
import com.example.facebook.databinding.ActivityRegisterBinding;
import com.example.facebook.databinding.FragmentGalleryBinding;
import com.example.facebook.ui.sports.ItemFragment;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    Activity context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}