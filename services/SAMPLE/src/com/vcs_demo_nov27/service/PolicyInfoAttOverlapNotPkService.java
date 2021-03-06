/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.vcs_demo_nov27.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.data.periods.PeriodClause;
import com.wavemaker.runtime.file.model.Downloadable;

import com.vcs_demo_nov27.PolicyInfoAttOverlapNotPk;

/**
 * Service object for domain model class {@link PolicyInfoAttOverlapNotPk}.
 */
public interface PolicyInfoAttOverlapNotPkService {

    /**
     * Creates a new PolicyInfoAttOverlapNotPk. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PolicyInfoAttOverlapNotPk if any.
     *
     * @param policyInfoAttOverlapNotPk Details of the PolicyInfoAttOverlapNotPk to be created; value cannot be null.
     * @return The newly created PolicyInfoAttOverlapNotPk.
     */
	PolicyInfoAttOverlapNotPk create(@Valid PolicyInfoAttOverlapNotPk policyInfoAttOverlapNotPk);


	/**
	 * Returns PolicyInfoAttOverlapNotPk by given id if exists.
	 *
	 * @param policyinfoattoverlapnotpkId The id of the PolicyInfoAttOverlapNotPk to get; value cannot be null.
	 * @return PolicyInfoAttOverlapNotPk associated with the given policyinfoattoverlapnotpkId.
     * @throws EntityNotFoundException If no PolicyInfoAttOverlapNotPk is found.
	 */
	PolicyInfoAttOverlapNotPk getById(String policyinfoattoverlapnotpkId) throws EntityNotFoundException;

    /**
	 * Find and return the PolicyInfoAttOverlapNotPk by given id if exists, returns null otherwise.
	 *
	 * @param policyinfoattoverlapnotpkId The id of the PolicyInfoAttOverlapNotPk to get; value cannot be null.
	 * @return PolicyInfoAttOverlapNotPk associated with the given policyinfoattoverlapnotpkId.
	 */
	PolicyInfoAttOverlapNotPk findById(String policyinfoattoverlapnotpkId);


	/**
	 * Updates the details of an existing PolicyInfoAttOverlapNotPk. It replaces all fields of the existing PolicyInfoAttOverlapNotPk with the given policyInfoAttOverlapNotPk.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PolicyInfoAttOverlapNotPk if any.
     *
	 * @param policyInfoAttOverlapNotPk The details of the PolicyInfoAttOverlapNotPk to be updated; value cannot be null.
	 * @return The updated PolicyInfoAttOverlapNotPk.
	 * @throws EntityNotFoundException if no PolicyInfoAttOverlapNotPk is found with given input.
	 */
	PolicyInfoAttOverlapNotPk update(@Valid PolicyInfoAttOverlapNotPk policyInfoAttOverlapNotPk) throws EntityNotFoundException;

    /**
	 * Deletes an existing PolicyInfoAttOverlapNotPk with the given id.
	 *
	 * @param policyinfoattoverlapnotpkId The id of the PolicyInfoAttOverlapNotPk to be deleted; value cannot be null.
	 * @return The deleted PolicyInfoAttOverlapNotPk.
	 * @throws EntityNotFoundException if no PolicyInfoAttOverlapNotPk found with the given id.
	 */
	PolicyInfoAttOverlapNotPk delete(String policyinfoattoverlapnotpkId) throws EntityNotFoundException;

	/**
	 * Find all PolicyInfoAttOverlapNotPks matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PolicyInfoAttOverlapNotPks.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PolicyInfoAttOverlapNotPk> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PolicyInfoAttOverlapNotPks matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PolicyInfoAttOverlapNotPks.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PolicyInfoAttOverlapNotPk> findAll(String query, Pageable pageable);

    /**
	 * Find all PolicyInfoAttOverlapNotPks's history matching the given period clauses and query. This method returns
     * Paginated results.
     * Note: Go through the documentation for <u>periodClause</u> and <u>query</u> syntax.
	 *
     * @param applicationClause The period clause condition.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PolicyInfoAttOverlapNotPks.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PolicyInfoAttOverlapNotPk> findHistory(String applicationClause, String query, Pageable pageable);

    /**
	 * Find all PolicyInfoAttOverlapNotPks's history matching the given period clauses and query. This method returns
     * Paginated results.
     * Note: Go through the documentation for <u>periodClause</u> and <u>query</u> syntax.
	 *
     * @param periodClauses The clauses to filter history.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PolicyInfoAttOverlapNotPks.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PolicyInfoAttOverlapNotPk> findHistory(List<PeriodClause> periodClauses, String query, Pageable pageable);

    /**
	 * Exports all PolicyInfoAttOverlapNotPks matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the PolicyInfoAttOverlapNotPks in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PolicyInfoAttOverlapNotPk.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

