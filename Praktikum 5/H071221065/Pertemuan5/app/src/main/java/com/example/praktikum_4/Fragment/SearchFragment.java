package com.example.praktikum_4.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.praktikum_4.DataSource;
import com.example.praktikum_4.Instagram;
import com.example.praktikum_4.R;
import com.example.praktikum_4.SearchAdapter;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private SearchAdapter searchAdapter;
    private ArrayList<Instagram> instagrams;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchView = view.findViewById(R.id.search_user);
        searchView.clearFocus();

        recyclerView = view.findViewById(R.id.rv_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setVisibility(View.GONE); // Sembunyikan RecyclerView dari awal

        // Initialize RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Get data from DataSource
        instagrams = DataSource.getInstagrams();
        searchAdapter = new SearchAdapter(instagrams);
        recyclerView.setAdapter(searchAdapter);
        progressBar = view.findViewById(R.id.progressBar);

        // Setup search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Tampilkan progress bar
                progressBar.setVisibility(View.VISIBLE);

                // Sembunyikan RecyclerView
                recyclerView.setVisibility(View.GONE);

                // Menjalankan proses pemfilteran di thread latar belakang
//                executor memanajement thread

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(() -> {
                    // Memfilter daftar berdasarkan teks pencarian baru
                    ArrayList<Instagram> filteredList;
                    if (newText.isEmpty()) {
                        filteredList = new ArrayList<>(); // Jika pencarian kosong, tampilkan daftar kosong
                    } else {
                        filteredList = filterList(newText);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Setelah selesai, kembali ke thread utama untuk mengubah UI
                    getActivity().runOnUiThread(() -> {
                        progressBar.setVisibility(View.GONE);

                        // Tampilkan RecyclerView jika hasil filter tidak kosong
                        if (!filteredList.isEmpty()) {
                            recyclerView.setVisibility(View.VISIBLE);
                            searchAdapter.setFilteredList(filteredList);
                            }
//                        } else {
//                            Toast.makeText(getContext(), "No user found", Toast.LENGTH_SHORT).show();
//                        }
                    });
                });
                return true;
            }
        });

        return view;
    }

    private ArrayList<Instagram> filterList(String text) {
        ArrayList<Instagram> filteredList = new ArrayList<>();
        for (Instagram instagram : instagrams) {
            if (instagram.getName().toLowerCase().contains(text.toLowerCase()) ||
                    instagram.getUsername().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(instagram);
            }
        }
        return filteredList;
    }
}