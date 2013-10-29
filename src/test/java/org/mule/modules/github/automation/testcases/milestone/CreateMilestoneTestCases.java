/**
 *
 * Mule GitHub Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p/>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.github.automation.testcases.milestone;

import org.eclipse.egit.github.core.Label;
import org.eclipse.egit.github.core.Milestone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.github.automation.testcases.GutHubTestParent;
import org.mule.modules.github.automation.testcases.RegressionTests;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CreateMilestoneTestCases extends GutHubTestParent
{
    @Before
    public void setUp() throws Exception
    {
        createTestRepository(false);
        initializeTestRunMessage("milestone");

    }

    @After
    public void tearDown() throws Exception
    {
        runFlowAndGetPayload("deleteMilestone");
    }

    @Category({RegressionTests.class})
    @Test
    public void createMilestone()
    {
        try
        {
            Milestone milestone = runFlowAndGetPayload("createMilestone");

            assertNotNull(milestone);
            assertEquals(getTestRunMessageValue("title"), milestone.getTitle());
            assertEquals(getTestRunMessageValue("description"), milestone.getDescription());
            assertEquals(getTestRunMessageValue("state"), milestone.getState());

            upsertOnTestRunMessage("number", milestone.getNumber());

        } catch (Exception e)
        {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }


}
