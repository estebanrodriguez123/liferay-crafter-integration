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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CrafterLocalService}.
 *
 * @author rivetlogic
 * @see CrafterLocalService
 * @generated
 */
public class CrafterLocalServiceWrapper implements CrafterLocalService,
	ServiceWrapper<CrafterLocalService> {
	public CrafterLocalServiceWrapper(CrafterLocalService crafterLocalService) {
		_crafterLocalService = crafterLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _crafterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_crafterLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _crafterLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* This method takes a list of query parameters, constructs a query,
	* and invokes Crafter's REST Search API to get the results matching
	* those parameters.
	*/
	@Override
	public java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> searchByMap(
		java.util.Map<java.lang.String, java.lang.String> queryParams) {
		return _crafterLocalService.searchByMap(queryParams);
	}

	/**
	* This method takes a single string, constructs a query by passing
	* that string as q's value, and invokes Crafter's REST Search API
	* to get the results matching those parameters.
	*/
	@Override
	public java.util.List<java.util.HashMap<java.lang.String, java.lang.Object>> searchByMap(
		java.lang.String query) {
		return _crafterLocalService.searchByMap(query);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CrafterLocalService getWrappedCrafterLocalService() {
		return _crafterLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCrafterLocalService(
		CrafterLocalService crafterLocalService) {
		_crafterLocalService = crafterLocalService;
	}

	@Override
	public CrafterLocalService getWrappedService() {
		return _crafterLocalService;
	}

	@Override
	public void setWrappedService(CrafterLocalService crafterLocalService) {
		_crafterLocalService = crafterLocalService;
	}

	private CrafterLocalService _crafterLocalService;
}