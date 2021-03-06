/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.vcs_demo_nov27.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.vcs_demo_nov27.NewTable;

/**
 * Service object for domain model class {@link NewTable}.
 */
public interface NewTableService {

    /**
     * Creates a new NewTable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on NewTable if any.
     *
     * @param newTable Details of the NewTable to be created; value cannot be null.
     * @return The newly created NewTable.
     */
	NewTable create(@Valid NewTable newTable);


	/**
	 * Returns NewTable by given id if exists.
	 *
	 * @param newtableId The id of the NewTable to get; value cannot be null.
	 * @return NewTable associated with the given newtableId.
     * @throws EntityNotFoundException If no NewTable is found.
	 */
	NewTable getById(Integer newtableId) throws EntityNotFoundException;

    /**
	 * Find and return the NewTable by given id if exists, returns null otherwise.
	 *
	 * @param newtableId The id of the NewTable to get; value cannot be null.
	 * @return NewTable associated with the given newtableId.
	 */
	NewTable findById(Integer newtableId);


	/**
	 * Updates the details of an existing NewTable. It replaces all fields of the existing NewTable with the given newTable.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on NewTable if any.
     *
	 * @param newTable The details of the NewTable to be updated; value cannot be null.
	 * @return The updated NewTable.
	 * @throws EntityNotFoundException if no NewTable is found with given input.
	 */
	NewTable update(@Valid NewTable newTable) throws EntityNotFoundException;

    /**
	 * Deletes an existing NewTable with the given id.
	 *
	 * @param newtableId The id of the NewTable to be deleted; value cannot be null.
	 * @return The deleted NewTable.
	 * @throws EntityNotFoundException if no NewTable found with the given id.
	 */
	NewTable delete(Integer newtableId) throws EntityNotFoundException;

	/**
	 * Find all NewTables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching NewTables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<NewTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all NewTables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching NewTables.
     *
     * @see Pageable
     * @see Page
	 */
    Page<NewTable> findAll(String query, Pageable pageable);

    /**
	 * Exports all NewTables matching the given input query to the given exportType format.
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
	 * Retrieve the count of the NewTables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the NewTable.
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

