/*
 *  The MIT License
 *
 *  Copyright 2010 Sony Ericsson Mobile Communications.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.sonyericsson.hudson.plugins.gerrit.trigger.config;


import com.sonyericsson.hudson.plugins.gerrit.trigger.config.Config;
import java.io.File;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.util.ajax.JSON;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Sandell &lt;robert.sandell@sonyericsson.com&gt;
 */
public class ConfigTest {

    public ConfigTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSetValues() {
        String formString = "{\"gerritVerifiedCmdBuildFailed\":\"gerrit approve <CHANGE>,<PATCHSET> " +
                "--message 'Failed misserably <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>\"," +
                "\"gerritVerifiedCmdBuildStarted\":\"gerrit approve <CHANGE>,<PATCHSET> " +
                "--message 'Started yay!! <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>\"," +
                "\"gerritVerifiedCmdBuildSuccessful\":\"gerrit approve <CHANGE>,<PATCHSET>" +
                " --message 'Successful wonderful <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>\"," +
                "\"gerritVerifiedCmdBuildUnstable\":\"gerrit approve <CHANGE>,<PATCHSET> " +
                "--message 'Unstable and you are to <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>\"," +
                "\"gerritAuthKeyFile\":\"/home/local/hudsongerrit/.ssh/id_rsa\"," +
                "\"gerritAuthKeyFilePassword\":\"passis\"," +
                "\"gerritBuildFailedCodeReviewValue\":\"1\"," +
                "\"gerritBuildFailedVerifiedValue\":\"-1\"," +
                "\"gerritBuildStartedCodeReviewValue\":\"2\"," +
                "\"gerritBuildStartedVerifiedValue\":\"-2\"," +
                "\"gerritBuildSuccessfulCodeReviewValue\":\"3\"," +
                "\"gerritBuildSuccessfulVerifiedValue\":\"-3\"," +
                "\"gerritBuildUnstableCodeReviewValue\":\"4\"," +
                "\"gerritBuildUnstableVerifiedValue\":\"-4\"," +
                "\"gerritFrontEndUrl\":\"http://gerrit:8088\"," +
                "\"gerritHostName\":\"gerrit\"," +
                "\"gerritSshPort\":\"1337\"," +
                "\"gerritUserName\":\"hudsongerrit\"," +
                "\"numberOfWorkerThreads\":\"6\"}";
        JSONObject form = (JSONObject)JSONSerializer.toJSON(formString);
        Config config = new Config(form);
        assertEquals("gerrit approve <CHANGE>,<PATCHSET> " +
                "--message 'Failed misserably <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>",
                config.getGerritCmdBuildFailed());
        assertEquals("gerrit approve <CHANGE>,<PATCHSET> " +
                "--message 'Started yay!! <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>",
                config.getGerritCmdBuildStarted());
        assertEquals("gerrit approve <CHANGE>,<PATCHSET>" +
                " --message 'Successful wonderful <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>",
                config.getGerritCmdBuildSuccessful());
        assertEquals("gerrit approve <CHANGE>,<PATCHSET> " +
                "--message 'Unstable and you are to <BUILDURL>' --verified <VERIFIED> --code-review <CODE_REVIEW>",
                config.getGerritCmdBuildUnstable());
        assertEquals(new File("/home/local/hudsongerrit/.ssh/id_rsa").getPath(),
                config.getGerritAuthKeyFile().getPath());
        assertEquals("passis", config.getGerritAuthKeyFilePassword());
        assertEquals(1, config.getGerritBuildFailedCodeReviewValue());
        assertEquals(-1, config.getGerritBuildFailedVerifiedValue());
        assertEquals(2, config.getGerritBuildStartedCodeReviewValue());
        assertEquals(-2, config.getGerritBuildStartedVerifiedValue());
        assertEquals(3, config.getGerritBuildSuccessfulCodeReviewValue());
        assertEquals(-3, config.getGerritBuildSuccessfulVerifiedValue());
        assertEquals(4, config.getGerritBuildUnstableCodeReviewValue());
        assertEquals(-4, config.getGerritBuildUnstableVerifiedValue());
        assertEquals("http://gerrit:8088/", config.getGerritFrontEndUrl());
        assertEquals("gerrit", config.getGerritHostName());
        assertEquals(1337, config.getGerritSshPort());
        assertEquals("hudsongerrit", config.getGerritUserName());
        assertEquals(6, config.getNumberOfWorkerThreads());
    }

}