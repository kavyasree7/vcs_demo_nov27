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

import com.vcs_demo_nov27.PolicyAtt;
import com.vcs_demo_nov27.PolicyAttId;


/**
 * ServiceImpl object for domain model class PolicyAtt.
 *
 * @see PolicyAtt
 */
@Service("SAMPLE.PolicyAttService")
@Validated
public class PolicyAttServiceImpl implements PolicyAttService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyAttServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.PolicyAttDao")
    private WMGenericDao<PolicyAtt, PolicyAttId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PolicyAtt, PolicyAttId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public PolicyAtt create(PolicyAtt policyAtt) {
        LOGGER.debug("Creating a new PolicyAtt with information: {}", policyAtt);
        PolicyAtt policyAttCreated = this.wmGenericDao.create(policyAtt);
        return policyAttCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public PolicyAtt getById(PolicyAttId policyattId) throws EntityNotFoundException {
        LOGGER.debug("Finding PolicyAtt by id: {}", policyattId);
        PolicyAtt policyAtt = this.wmGenericDao.findById(policyattId);
        if (policyAtt == null){
            LOGGER.debug("No PolicyAtt found with id: {}", policyattId);
            throw new EntityNotFoundException(String.valueOf(policyattId));
        }
        return policyAtt;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public PolicyAtt findById(PolicyAttId policyattId) {
        LOGGER.debug("Finding PolicyAtt by id: {}", policyattId);
        return this.wmGenericDao.findById(policyattId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public PolicyAtt update(PolicyAtt policyAtt) throws EntityNotFoundException {
        LOGGER.debug("Updating PolicyAtt with information: {}", policyAtt);
        this.wmGenericDao.update(policyAtt);

        PolicyAttId policyattId = new PolicyAttId();
        policyattId.setBank(policyAtt.getBank());
        policyattId.setClient(policyAtt.getClient());

        return this.wmGenericDao.findById(policyattId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public PolicyAtt delete(PolicyAttId policyattId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PolicyAtt with id: {}", policyattId);
        PolicyAtt deleted = this.wmGenericDao.findById(policyattId);
        if (deleted == null) {
            LOGGER.debug("No PolicyAtt found with id: {}", policyattId);
            throw new EntityNotFoundException(String.valueOf(policyattId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<PolicyAtt> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PolicyAtts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyAtt> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PolicyAtts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyAtt> findHistory(String applicationClause, String query, Pageable pageable) {
        List<PeriodClause> periodClauses = new ArrayList<>(2);
        if(applicationClause != null && !applicationClause.isEmpty()) {
            periodClauses.add(new PeriodClauseWrapper(TableTemporal.TemporalType.APPLICATION, applicationClause));
        }
        return findHistory(periodClauses, query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyAtt> findHistory(List<PeriodClause> periodClauses, String query, Pageable pageable) {
        LOGGER.debug("Finding history data for PolicyAtt");
        return this.wmGenericDao.findHistory(periodClauses, query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table PolicyAtt to {} format", exportType);
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
