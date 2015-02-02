package com.netthreads.test.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Details Fragment.
 */
public class DetailsActivity extends ActionBarActivity
{
    public static final String ARG_ITEM = "item";

    /**
     * Create activity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        // Extract bundle item.
        TestData data = (TestData) getIntent().getSerializableExtra(ARG_ITEM);

        if (savedInstanceState == null)
        {
            TestDataDetailsFragment fragment =  new TestDataDetailsFragment();
            Bundle bundle = new Bundle();

            // Can't pass object so we'll have to pass individual values.
            bundle.putString(TestDataDetailsFragment.ARG_CATEGORY, data.getCategory());
            bundle.putString(TestDataDetailsFragment.ARG_SEVERITY, data.getSeverity());
            bundle.putString(TestDataDetailsFragment.ARG_LOCATION, data.getLocation());
            bundle.putString(TestDataDetailsFragment.ARG_DESCRIPTION, data.getTitle());

            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
