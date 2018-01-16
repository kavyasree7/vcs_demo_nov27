/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.vcs_demo_nov27.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.annotations.TableTemporal;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.data.periods.PeriodClause;
import com.wavemaker.runtime.data.periods.PeriodClauseWrapper;
import com.wavemaker.runtime.file.model.Downloadable;

import com.vcs_demo_nov27.PolicyInfoAttOverlapNotPk;


/**
 * ServiceImpl object for domain model class PolicyInfoAttOverlapNotPk.
 *
 * @see PolicyInfoAttOverlapNotPk
 */
@Service("SAMPLE.PolicyInfoAttOverlapNotPkService")
@Validated
public class PolicyInfoAttOverlapNotPkServiceImpl implements PolicyInfoAttOverlapNotPkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyInfoAttOverlapNotPkServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.PolicyInfoAttOverlapNotPkDao")
    private WMGenericDao<PolicyInfoAttOverlapNotPk, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PolicyInfoAttOverlapNotPk, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public PolicyInfoAttOverlapNotPk create(PolicyInfoAttOverlapNotPk policyInfoAttOverlapNotPk) {
        LOGGER.debug("Creating a new PolicyInfoAttOverlapNotPk with information: {}", policyInfoAttOverlapNotPk);
        PolicyInfoAttOverlapNotPk policyInfoAttOverlapNotPkCreated = this.wmGenericDao.create(policyInfoAttOverlapNotPk);
        return policyInfoAttOverlapNotPkCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoAttOverlapNotPk getById(String policyinfoattoverlapnotpkId) throws EntityNotFoundException {
        LOGGER.debug("Finding PolicyInfoAttOverlapNotPk by id: {}", policyinfoattoverlapnotpkId);
        PolicyInfoAttOverlapNotPk policyInfoAttOverlapNotPk = this.wmGenericDao.findById(policyinfoattoverlapnotpkId);
        if (policyInfoAttOverlapNotPk == null){
            LOGGER.debug("No PolicyInfoAttOverlapNotPk found with id: {}", policyinfoattoverlapnotpkId);
            throw new EntityNotFoundException(String.valueOf(policyinfoattoverlapnotpkId));
        }
        return policyInfoAttOverlapNotPk;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoAttOverlapNotPk findById(String policyinfoattoverlapnotpkId) {
        LOGGER.debug("Finding PolicyInfoAttOverlapNotPk by id: {}", policyinfoattoverlapnotpkId);
        return this.wmGenericDao.findById(policyinfoattoverlapnotpkId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoAttOverlapNotPk update(PolicyInfoAttOverlapNotPk policyInfoAttOverlapNotPk) throws EntityNotFoundException {
        LOGGER.debug("Updating PolicyInfoAttOverlapNotPk with information: {}", policyInfoAttOverlapNotPk);
        this.wmGenericDao.update(policyInfoAttOverlapNotPk);

        String policyinfoattoverlapnotpkId = policyInfoAttOverlapNotPk.getPolicyId();

        return this.wmGenericDao.findById(policyinfoattoverlapnotpkId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoAttOverlapNotPk delete(String policyinfoattoverlapnotpkId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PolicyInfoAttOverlapNotPk with id: {}", policyinfoattoverlapnotpkId);
        PolicyInfoAttOverlapNotPk deleted = this.wmGenericDao.findById(policyinfoattoverlapnotpkId);
        if (deleted == null) {
            LOGGER.debug("No PolicyInfoAttOverlapNotPk found with id: {}", policyinfoattoverlapnotpkId);
            throw new EntityNotFoundException(String.valueOf(policyinfoattoverlapnotpkId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<PolicyInfoAttOverlapNotPk> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PolicyInfoAttOverlapNotPks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyInfoAttOverlapNotPk> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PolicyInfoAttOverlapNotPks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyInfoAttOverlapNotPk> findHistory(String applicationClause, String query, Pageable pageable) {
        List<PeriodClause> periodClauses = new ArrayList<>(2);
        if(applicationClause != null && !applicationClause.isEmpty()) {
            periodClauses.add(new PeriodClauseWrapper(TableTemporal.TemporalType.APPLICATION, applicationClause));
        }
        return findHistory(periodClauses, query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyInfoAttOverlapNotPk> findHistory(List<PeriodClause> periodClauses, String query, Pageable pageable) {
        LOGGER.debug("Finding history data for PolicyInfoAttOverlapNotPk");
        return this.wmGenericDao.findHistory(periodClauses, query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table PolicyInfoAttOverlapNotPk to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
