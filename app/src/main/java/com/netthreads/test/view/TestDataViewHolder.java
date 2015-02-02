package com.netthreads.test.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * TesData view holder.
 */
public class TestDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
{
    private ImageView      image;
    private TextView       locationText;
    private TextView       titleText;
    private TextView       categoryText;
    private RelativeLayout relativeLayout;

    private TestData testData;

    private View itemView;

    private TestDataAdapter.IItemClickListener clickListener;

    // Image cache
    private static HashMap<String, Bitmap> images = new HashMap<String, Bitmap>();

    // Use a static string builder to avoid instantiating strings for every row
    private static final StringBuilder iconName = new StringBuilder(30);

    /**
     * Map category->image-name
     */
    private Map<String, String> imageMap = new HashMap<String, String>()
    {
        {
            put("roadwork", "roadwork");
            put("accident", "accident");
            put("incident", "incident");
        }
    };

    /**
     * Construct view holder.
     *
     * @param itemView      The view.
     * @param clickListener The click listener
     */
    public TestDataViewHolder(View itemView, TestDataAdapter.IItemClickListener clickListener)
    {
        super(itemView);

        this.itemView = itemView;
        this.clickListener = clickListener;

        // Create image cache.
        images = new HashMap<String, Bitmap>();

        image = (ImageView) itemView.findViewById(R.id.event_image);
        locationText = (TextView) itemView.findViewById(R.id.event_location);
        titleText = (TextView) itemView.findViewById(R.id.event_description);
        categoryText = (TextView) itemView.findViewById(R.id.event_category);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.event_row);

        // Click handlers.
        relativeLayout.setOnClickListener(this);
        relativeLayout.setOnLongClickListener(this);
    }

    /**
     * Bind data to view holder elements.
     *
     * @param testData
     */
    public void bindData(TestData testData)
    {
        this.testData = testData;

        // Set image
        String category = testData.getCategory();

        categoryText.setText(category);

        String severity = testData.getSeverity();

        // Map our category down to a shared image.
        String imagePrefix = imageMap.get(category);

        iconName.setLength(0);
        iconName.append(imagePrefix);
        iconName.append("_");
        iconName.append(severity.toLowerCase(Locale.ENGLISH));

        Bitmap icon = get(itemView.getContext(), iconName.toString(), TestData.DEFAULT_ICON);

        if (icon != null)
        {
            image.setImageBitmap(icon);
        }

        // Set location
        locationText.setText(testData.getLocation());

        // Set title
        titleText.setText(testData.getTitle());
    }

    /**
     * Get image from cache.
     *
     * @param name
     * @return Bitmap image
     */
    public Bitmap get(Context context, String name, String defaultName)
    {
        Bitmap target = images.get(name);

        if (target == null)
        {
            target = ImageHelper.fetchIcon(context, name, defaultName);

            images.put(name, target);
        }

        return target;
    }

    /**
     * Click handler.
     *
     * @param view
     */
    @Override
    public void onClick(View view)
    {
        clickListener.onClick(testData);
    }


    /**
     * On Long Click.
     *
     * @param v
     * @return True if handled.
     */
    @Override
    public boolean onLongClick(View v)
    {
        clickListener.onLongClick(testData);

        return true;
    }
}
