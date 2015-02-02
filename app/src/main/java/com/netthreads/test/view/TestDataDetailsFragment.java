package com.netthreads.test.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * TestData details fragment containing a simple view.
 *
 */
public class TestDataDetailsFragment extends Fragment
{
    public static final String ARG_CATEGORY    = "category";
    public static final String ARG_SEVERITY    = "severity";
    public static final String ARG_LOCATION    = "location";
    public static final String ARG_DESCRIPTION = "description";

    private ImageView image;
    private TextView  locationText;
    private TextView  categoryText;
    private TextView  descriptionText;

    /**
     * Create details view.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     *
     * @return Return view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_item_details, container, false);

        Context context = container.getContext();

        Bundle bundle = getArguments();

        String category = bundle.getString(ARG_CATEGORY);
        String severity = bundle.getString(ARG_SEVERITY);
        String location = bundle.getString(ARG_LOCATION);
        String description = bundle.getString(ARG_DESCRIPTION);

        // Set view elements from supplied data.
        String name = ImageHelper.buildIconName(category, severity);
        Bitmap icon = ImageHelper.fetchIcon(context, name, TestData.DEFAULT_ICON);

        image = (ImageView) rootView.findViewById(R.id.event_image);
        locationText = (TextView) rootView.findViewById(R.id.event_location);
        descriptionText = (TextView) rootView.findViewById(R.id.event_description);
        categoryText = (TextView) rootView.findViewById(R.id.event_category);

        image.setImageBitmap(icon);
        locationText.setText(location);
        descriptionText.setText(description);
        categoryText.setText(category);

        return rootView;
    }
}