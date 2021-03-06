/**
 * Copyright 2017 Comcast Cable Communications Management, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.comcast.dawg.config;

import com.comcast.video.dawg.common.Config;

/**
 * contains the SauceLabs credentials and key informations to run tests in sauce. This will look up system properties 
 * and apply defaults if they are not set
 * 
 * @author Priyanka
 *
 */
public class SauceLabConfig {

    /**
     * Constants for system properties  
     */
    private static final String TEST_MODE = "test.mode";
    private static final String SAUCE_KEY = "sauce.key";
    private static final String SAUCE_USERNAME = "sauce.username";
    private static final String SAUCE_PORT = "sauce.port";
    private static final String SAUCE_PLATFORM = "test.platform";
    private static final String SAUCE_URL = "sauce.url";
    private static final String SAUCE_WIN_VERSION = "win.version";
    private static final String SAUCE_MAC_VERSION = "mac.version";
    private static final String CHROME_VERSION = "chrome.version";
    
    /**
     * Constants to keep default values from config file
     */
    private static final String DEFAULT_TEST_MODE = Config.get("saucelab", "default-test-mode");
    private static final String DEFAULT_SAUCE_PLATFORM = Config.get("saucelab", "default-sauce-platform");
    private static final String DEFAULT_WIN_VERSION = Config.get("saucelab", "default-sauce-win-version");
    private static final String DEFAULT_MAC_VERSION = Config.get("saucelab", "default-sauce-mac-version");
    private static final String DEFAULT_CHROME_VERSION = Config.get("saucelab", "default-chrome-version");
    private static final String DEFAULT_SAUCE_URL = Config.get("saucelab", "default-sauce-url");

    /**
     * Gets the test mode to run tests in local or in SauceLabs
     * @return - Test mode (sauce or local)
     */
    public static final String getTestMode() {
        return getData(TEST_MODE, DEFAULT_TEST_MODE);
    }

    /**
     * Gets the sauce URL
     * @return -Sauce Url
     */
    public static final String getSauceURl() {
        return getData(SAUCE_URL, DEFAULT_SAUCE_URL);
    }

    /**
     * Gets the sauce lab key
     * @return - Sauce Key
     */
    public static final String getSauceKey() {
        return System.getProperty(SAUCE_KEY);
    }

    /**
     * Gets the username of saucelab
     * @return - Sauce User name
     */
    public static final String getSauceUserName() {
        return System.getProperty(SAUCE_USERNAME);
    }

    /**
     * Gets the sauce port
     * @return - Sauce Port
     */
    public static final String getSaucePort() {
        return System.getProperty(SAUCE_PORT);
    }

    /**
     * Gets the sauce platform to be test run
     * @return - Sauce platform
     */
    public static final String getSaucePlatform() {
        return getData(SAUCE_PLATFORM, DEFAULT_SAUCE_PLATFORM);
    }

    /**
     * Gets the sauce platform version for windows
     * @return - Win Os version
     */
    public static final String getWinOsVersion() {
        return getData(SAUCE_WIN_VERSION, DEFAULT_WIN_VERSION);
    }

    /**
     *  Gets the sauce platform version for Mac OSX
     * @return - Mac Os version
     */
    public static final String getMacOsVersion() {
        return getData(SAUCE_MAC_VERSION, DEFAULT_MAC_VERSION);
    }

    /**
     * Get chrome version for running test in sauce labs.
     * @return chrome version
     */
    public static final String getChromeVersion() {
        return getData(CHROME_VERSION, DEFAULT_CHROME_VERSION);
    }
    
    /**
     * Get values, if  system properties are not set then fetch default values from config file
     * @param property key
     * @param default value
     * @return corresponding system property value or config value
     */
    private static final String getData(String propKey, String defaultVal) {
        return System.getProperty(propKey, defaultVal);
    }
}
