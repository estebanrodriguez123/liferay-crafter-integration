/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.rivetlogic.crafter.configuration;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.crafter.util.ConfigurationConstants;

/**
 * The Class CrafterConfigurationPortlet.
 * 
 * @author rkanakam
 */
public class CrafterConfigurationPortlet extends MVCPortlet {

    /** The log. */
    private static final Log LOG = LogFactoryUtil.getLog(CrafterConfigurationPortlet.class);

    /**
     * Submit preferences action.
     * 
     * @param actionRequest
     *            the action request
     * @param actionResponse
     *            the action response
     * @throws IOException
     *             the IO exception
     * @throws PortletException
     *             the portlet exception
     */
    public void submitPreferencesAction(final ActionRequest actionRequest, final ActionResponse actionResponse)
            throws IOException, PortletException {

        String searchServerURL = ParamUtil.getString(actionRequest, ConfigurationConstants.PARAMUTIL_SEARCH_URL);
        String crafterEndPoint = ParamUtil.getString(actionRequest, ConfigurationConstants.PARAMUTIL_END_POINT);
        try {
            if (Validator.isNotNull(searchServerURL)) {
                PortletPreferences preferences = PrefsPropsUtil.getPreferences();
                preferences.setValue(ConfigurationConstants.PREFERENCES_SEARCH_URL, searchServerURL);
                preferences.setValue(ConfigurationConstants.PREFERENCES_END_POINT, crafterEndPoint);
                preferences.store();
            }
        } catch (SystemException e) {
            LOG.error("Error while storing preferences:" + e.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest
     * , javax.portlet.RenderResponse)
     */
    public void doView(final RenderRequest request, final RenderResponse response) throws IOException, PortletException {

        try {
            PortletPreferences preferences = PrefsPropsUtil.getPreferences();
            request.setAttribute(ConfigurationConstants.PARAMUTIL_SEARCH_URL,
                    preferences.getValue(ConfigurationConstants.PREFERENCES_SEARCH_URL, ConfigurationConstants._EMPTY));
            request.setAttribute(ConfigurationConstants.PARAMUTIL_END_POINT,
                    preferences.getValue(ConfigurationConstants.PREFERENCES_END_POINT, ConfigurationConstants._EMPTY));
        } catch (SystemException e) {
            LOG.error("Error while rendering:" + e.getMessage());
        }

        include(viewTemplate, request, response);
    }
}
