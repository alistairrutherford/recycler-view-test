package com.netthreads.test.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Test Data object adapter.
 *
 */
public class TestDataAdapter extends RecyclerView.Adapter<TestDataViewHolder>
{
    /**
     * On click handler interface.
     *
     */
    public interface IItemClickListener
    {
        public void onClick(TestData testData);
        public void onLongClick(TestData testData);
    }

    private ArrayList<TestData> dataset;

    private IItemClickListener itemClickListener;

    /**
     * Construct view holder.
     *
     * @param dataset
     */
    public TestDataAdapter(ArrayList<TestData> dataset, IItemClickListener itemClickListener)
    {
        this.dataset = dataset;
        this.itemClickListener = itemClickListener;
    }

    /**
     * Create view
     *
     * @param viewGroup
     * @param viewType
     *
     * @return The view.
     */
    @Override
    public TestDataViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_list_row, viewGroup, false);

        TestDataViewHolder testDataViewHolder = new TestDataViewHolder(view, itemClickListener);

        return testDataViewHolder;
    }

    /**
     * Bind data to view.
     *
     * @param testDataViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(TestDataViewHolder testDataViewHolder, int position)
    {
        TestData testData = dataset.get(position);

        testDataViewHolder.bindData(testData);

    }

    /**
     * Return item count.
     *
     * @return The count.
     */
    @Override
    public int getItemCount()
    {
        return dataset.size();
    }
}

