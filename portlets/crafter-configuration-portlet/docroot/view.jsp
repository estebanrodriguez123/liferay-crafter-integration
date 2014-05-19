<%--
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
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet-ext" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.rivetlogic.crafter.util.ConfigurationConstants" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String searchServerURL = (String)request.getAttribute(ConfigurationConstants.PARAMUTIL_SEARCH_URL);
	String crafterEndPoint = (String)request.getAttribute(ConfigurationConstants.PARAMUTIL_END_POINT);
%>

<portlet:actionURL name="submitPreferencesAction" var="submitPreferencesURL" /> 

<div> 
	<aui:form name="save_preferences" action="<%=submitPreferencesURL%>" method="post">
			<aui:column>
				<aui:fieldset label="configuration-header">
					<aui:field-wrapper label="crafter-search-url">
						<aui:input type="text" name="search_server_url" label="" size="40" value="<%=searchServerURL%>">
							<aui:validator name="url" errorMessage="error-invalid-url"/>
						</aui:input>
					</aui:field-wrapper>
					<aui:field-wrapper label="crafter-end-point">
						<aui:input type="text" name="crafter_end_point" label="" size="40" value="<%=crafterEndPoint%>">
							<aui:validator name="url" errorMessage="error-invalid-end-point"/>
						</aui:input>	
					</aui:field-wrapper>
				</aui:fieldset>
				<aui:fieldset label="&nbsp;">
					<aui:field-wrapper>
						<aui:button type="submit" name="update" value="Update" />
					</aui:field-wrapper>
				</aui:fieldset>
			</aui:column>
	</aui:form>
</div>
