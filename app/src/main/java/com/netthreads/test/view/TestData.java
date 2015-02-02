package com.netthreads.test.view;

import java.io.Serializable;

/**
 * Test data class models traffic event with severity, category, location and description text.
 *
 */
public class TestData implements Serializable
{
    public static final String DEFAULT_ICON = "incident_low";

    private String severity;
    private String category;
    private String location;
    private String title;

    public TestData(String category, String location, String title, String severity)
    {
        this.category = category;
        this.location = location;
        this.title = title;
        this.severity = severity;
    }

    public String getSeverity()
    {
        return severity;
    }

    public void setSeverity(String severity)
    {
        this.severity = severity;
    }

    public String getLocation()
    {
        return location;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
