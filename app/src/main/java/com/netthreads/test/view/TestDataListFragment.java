package com.netthreads.test.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * -------------------------------------------------------------------
 * Test Data List Fragment.
 * -------------------------------------------------------------------
 */
public class TestDataListFragment extends Fragment implements TestDataAdapter.IItemClickListener
{
    private RecyclerView               recyclerView;
    private RecyclerView.Adapter       adapter;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * On create view.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return The view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.data_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        recyclerView.setClickable(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<TestData> testData = TestDataHelper.generateTestData(30);

        // Specify an adapter
        adapter = new TestDataAdapter(testData, this);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    /**
     * Click handler.
     *
     * @param testData
     */
    @Override
    public void onClick(TestData testData)
    {
        // Build intent and add data.
        Intent detailIntent = new Intent(getActivity(), DetailsActivity.class);
        detailIntent.putExtra(DetailsActivity.ARG_ITEM, testData);

        // Launch from intent
        startActivity(detailIntent);
    }


    /**
     * On long click handler.
     *
     * @param testData
     */
    @Override
    public void onLongClick(TestData testData)
    {
        Context context = getActivity();
        CharSequence text = "Long Click!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}