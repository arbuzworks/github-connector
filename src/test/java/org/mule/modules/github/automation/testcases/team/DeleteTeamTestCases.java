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

package org.mule.modules.github.automation.testcases.team;

import org.eclipse.egit.github.core.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.github.automation.testcases.GutHubTestParent;
import org.mule.modules.github.automation.testcases.RegressionTests;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.fail;

public class DeleteTeamTestCases extends GutHubTestParent
{
    @Before
    public void setUp() throws Exception
    {
        initializeTestRunMessage("team");
        Team team = runFlowAndGetPayload("createTeam");
        upsertOnTestRunMessage("teamId", team.getId());
    }

    @Category({RegressionTests.class})
    @Test
    public void deleteTeam()
    {
        try
        {
            runFlowAndGetPayload("deleteTeam");

        } catch (Exception e)
        {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}