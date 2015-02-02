package com.netthreads.test.view;

import java.util.ArrayList;

/**
 *
 *
 */
public class TestDataHelper
{

    private static String[] category =
            {
                    "incident",
                    "accident",
                    "roadwork"
            };

    private static String[] severity =
            {
                    "low",
                    "medium",
                    "severe"
            };

    private static final String[] roads =
            {
                    "M1", "M2", "M3", "M4", "M5", "M6",
                    "M8", "M9", "M11", "M18", "M20", "M23",
                    "M25", "M26", "M27", "M32", "M40", "M42",
                    "M45", "M48", "M49", "M50", "M53", "M54",
                    "M55", "M56", "M57", "M58", "M60", "M61",
                    "M62", "M65", "M66", "M67", "M69", "M73",
                    "M74", "M77", "M80", "M90", "M180", "M181",
                    "M271", "M275", "M602", "M606", "M621",
                    "M876", "M898"
            };

    /**
     * Generate test data.
     *
     * @param count
     * @return List of test data.
     */
    public static ArrayList<TestData> generateTestData(int count)
    {
        ArrayList<TestData> data = new ArrayList<>();

        for (int index = 0; index < count; index++)
        {
            int categoryIndex = (int) (Math.random() * category.length);
            int severityIndex = (int) (Math.random() * severity.length);
            int roadIndex = (int) (Math.random() * roads.length);

            String categoryText = category[categoryIndex];
            String severityText = severity[severityIndex];
            String location = roads[roadIndex];

            String testDesc = buildTestDescription(categoryText, severityText);

            TestData testData = new TestData(categoryText, location, testDesc, severityText);

            data.add(testData);
        }

        return data;
    }

    /**
     * Build text description.
     *
     * @param category
     * @param severity
     * @return The test description.
     */
    public static String buildTestDescription(String category, String severity)
    {
        String text = "Lorem ipsum dolor sit amet, arcu mi fermentum nam, pede est integer, pharetra sed a, adipiscing in viverra eu sagittis nec laoreet, ante maiores euismod ultrices diam urna. Commodo faucibus. Rhoncus mi ut felis, ante dolor cras scelerisque a vestibulum vitae, amet sagittis velit lacus ipsum lorem";

        return text;
    }
}
