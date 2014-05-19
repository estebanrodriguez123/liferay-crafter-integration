/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.crafter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Crafter. This utility wraps
 * {@link com.rivetlogic.crafter.service.impl.CrafterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rivetlogic
 * @see CrafterLocalService
 * @see com.rivetlogic.crafter.service.base.CrafterLocalServiceBaseImpl
 * @see com.rivetlogic.crafter.service.impl.CrafterLocalServiceImpl
 * @generated
 */
public class CrafterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.crafter.service.impl.CrafterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* This method takes a list of query parameters, constructs a query,
	* and invokes Crafter's REST Search API to get the results matching
	* those parameters.
	*/
	public static java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> searchByMap(
		java.util.Map<java.lang.String, java.lang.String> queryParams) {
		return getService().searchByMap(queryParams);
	}

	/**
	* This method takes a single string, constructs a query by passing
	* that string as q's value, and invokes Crafter's REST Search API
	* to get the results matching those parameters.
	*/
	public static java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> searchByMap(
		java.lang.String query) {
		return getService().searchByMap(query);
	}

	public static void clearService() {
		_service = null;
	}

	public static CrafterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CrafterLocalService.class.getName());

			if (invokableLocalService instanceof CrafterLocalService) {
				_service = (CrafterLocalService)invokableLocalService;
			}
			else {
				_service = new CrafterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CrafterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CrafterLocalService service) {
	}

	private static CrafterLocalService _service;
}