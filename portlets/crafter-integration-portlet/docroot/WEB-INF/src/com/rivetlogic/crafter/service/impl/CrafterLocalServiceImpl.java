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

package com.rivetlogic.crafter.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rivetlogic.crafter.search.service.Query;
import org.rivetlogic.crafter.search.service.impl.QueryParams;
import org.rivetlogic.crafter.search.service.impl.RestClientSearchService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.crafter.service.base.CrafterLocalServiceBaseImpl;
import com.rivetlogic.crafter.util.CrafterConstants;

/**
 * The implementation of the crafter local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.crafter.service.CrafterLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author rivetlogic
 * @see com.rivetlogic.crafter.service.base.CrafterLocalServiceBaseImpl
 * @see com.rivetlogic.crafter.service.CrafterLocalServiceUtil
 */
public class CrafterLocalServiceImpl extends CrafterLocalServiceBaseImpl {

    private static final Log LOG = LogFactoryUtil.getLog(CrafterLocalServiceImpl.class);

    /**
     * This method takes a list of query parameters, constructs a query, and
     * invokes Crafter's REST Search API to get the results matching those
     * parameters.
     * 
     */
    @SuppressWarnings("unchecked")
    public List<HashMap<String, Object>> searchByMap(final Map<String, String> queryParams) {
        Map<String, String[]> crafterQueryParams = new HashMap<String, String[]>();
        try {
            String searchServerURL = PrefsPropsUtil.getString(CrafterConstants.CRAFTER_SERVER_PROPERTY,
                    StringPool.BLANK);
            if (Validator.isNotNull(searchServerURL)) {
                for (Map.Entry<String, String> e : queryParams.entrySet()) {
                    crafterQueryParams.put(e.getKey(), new String[] { e.getValue() });
                }
                crafterQueryParams.put(CrafterConstants.CRAFTER_START,
                        new String[] { CrafterConstants.CRAFTER_0_STRING });
                RestClientSearchService rcss = new RestClientSearchService();
                rcss.setServerUrl(searchServerURL);
                Query q = new QueryParams(crafterQueryParams);
                Map<String, Object> contentMap = rcss.search(q);
                if (Validator.isNotNull(contentMap.get(CrafterConstants.CRAFTER_RESPONSE))) {
                    HashMap<String, Object> responseMap = (HashMap<String, Object>) contentMap
                            .get(CrafterConstants.CRAFTER_RESPONSE);
                    if (Validator.isNotNull(responseMap)) {
                        List<HashMap<String, Object>> documentsMap = (List<HashMap<String, Object>>) responseMap
                                .get(CrafterConstants.CRAFTER_DOCUMENTS);
                        return documentsMap;
                    }
                }
                LOG.debug("Query Result Content Map : " + contentMap);
            }
        } catch (Exception e) {
            LOG.error("Failed to invoke crafter search api : " + e.getMessage());
        }
        return new ArrayList<HashMap<String, Object>>();
    }

    /**
     * This method takes a single string, constructs a query by passing that
     * string as q's value, and invokes Crafter's REST Search API to get the
     * results matching those parameters.
     * 
     */
    @SuppressWarnings("unchecked")
    public List<HashMap<String, Object>> searchByMap(final String query) {
        Map<String, String[]> crafterQueryParams = new HashMap<String, String[]>();
        try {
            String searchServerURL = PrefsPropsUtil.getString(CrafterConstants.CRAFTER_SERVER_PROPERTY,
                    StringPool.BLANK);
            if (Validator.isNotNull(searchServerURL)) {
                crafterQueryParams.put(CrafterConstants.CRAFTER_Q, new String[] { query });
                crafterQueryParams.put(CrafterConstants.CRAFTER_START,
                        new String[] { CrafterConstants.CRAFTER_0_STRING });
                RestClientSearchService rcss = new RestClientSearchService();
                rcss.setServerUrl(searchServerURL);
                Query q = new QueryParams(crafterQueryParams);
                Map<String, Object> contentMap = rcss.search(q);
                if (Validator.isNotNull(contentMap.get(CrafterConstants.CRAFTER_RESPONSE))) {
                    HashMap<String, Object> responseMap = (HashMap<String, Object>) contentMap
                            .get(CrafterConstants.CRAFTER_RESPONSE);
                    if (Validator.isNotNull(responseMap)) {
                        List<HashMap<String, Object>> documentsMap = (List<HashMap<String, Object>>) responseMap
                                .get(CrafterConstants.CRAFTER_DOCUMENTS);
                        return documentsMap;
                    }
                }
                LOG.debug("Query Result Content Map: " + contentMap);
            }
        } catch (Exception e) {
            LOG.error("Failed to invoke crafter search api: " + e.getMessage());
        }
        return new ArrayList<HashMap<String, Object>>();
    }
}