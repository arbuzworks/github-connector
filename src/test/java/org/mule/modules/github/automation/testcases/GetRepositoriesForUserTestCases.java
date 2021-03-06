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

package org.mule.modules.github.automation.testcases;

import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetRepositoriesForUserTestCases extends GitHubTestParent
{
    @Before
    public void setUp() throws Exception
    {
        createTestRepository();
        initializeTestRunMessage("getRepositoriesForUserTestData");
    }

    @Category({RegressionTests.class, RepositoryTests.class})
    @Test
    public void testGetRepositoriesForUser()
    {
        try
        {
            List<Repository> repositories = runFlowAndGetPayload("getRepositoriesForUser");
            assertTrue(repositories.size() > 0);
            boolean found = false;
            for (Repository repo: repositories)
            {
                if (repository.getName().equals(repo.getName()))
                {
                    found = true;
                    break;
                }
            }
            assertTrue(found);

        } catch (Exception e)
        {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
