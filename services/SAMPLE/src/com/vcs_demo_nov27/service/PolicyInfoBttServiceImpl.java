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

import com.vcs_demo_nov27.PolicyInfoBtt;
import com.vcs_demo_nov27.PolicyInfoBttId;


/**
 * ServiceImpl object for domain model class PolicyInfoBtt.
 *
 * @see PolicyInfoBtt
 */
@Service("SAMPLE.PolicyInfoBttService")
@Validated
public class PolicyInfoBttServiceImpl implements PolicyInfoBttService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyInfoBttServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.PolicyInfoBttDao")
    private WMGenericDao<PolicyInfoBtt, PolicyInfoBttId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PolicyInfoBtt, PolicyInfoBttId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public PolicyInfoBtt create(PolicyInfoBtt policyInfoBtt) {
        LOGGER.debug("Creating a new PolicyInfoBtt with information: {}", policyInfoBtt);
        PolicyInfoBtt policyInfoBttCreated = this.wmGenericDao.create(policyInfoBtt);
        return policyInfoBttCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoBtt getById(PolicyInfoBttId policyinfobttId) throws EntityNotFoundException {
        LOGGER.debug("Finding PolicyInfoBtt by id: {}", policyinfobttId);
        PolicyInfoBtt policyInfoBtt = this.wmGenericDao.findById(policyinfobttId);
        if (policyInfoBtt == null){
            LOGGER.debug("No PolicyInfoBtt found with id: {}", policyinfobttId);
            throw new EntityNotFoundException(String.valueOf(policyinfobttId));
        }
        return policyInfoBtt;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoBtt findById(PolicyInfoBttId policyinfobttId) {
        LOGGER.debug("Finding PolicyInfoBtt by id: {}", policyinfobttId);
        return this.wmGenericDao.findById(policyinfobttId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoBtt update(PolicyInfoBtt policyInfoBtt) throws EntityNotFoundException {
        LOGGER.debug("Updating PolicyInfoBtt with information: {}", policyInfoBtt);
        this.wmGenericDao.update(policyInfoBtt);

        PolicyInfoBttId policyinfobttId = new PolicyInfoBttId();
        policyinfobttId.setPolicyId(policyInfoBtt.getPolicyId());
        policyinfobttId.setCoverage(policyInfoBtt.getCoverage());
        policyinfobttId.setBusStart(policyInfoBtt.getBusStart());
        policyinfobttId.setBusEnd(policyInfoBtt.getBusEnd());
        policyinfobttId.setSysStart(policyInfoBtt.getSysStart());
        policyinfobttId.setSysEnd(policyInfoBtt.getSysEnd());
        policyinfobttId.setTsId(policyInfoBtt.getTsId());

        return this.wmGenericDao.findById(policyinfobttId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public PolicyInfoBtt delete(PolicyInfoBttId policyinfobttId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PolicyInfoBtt with id: {}", policyinfobttId);
        PolicyInfoBtt deleted = this.wmGenericDao.findById(policyinfobttId);
        if (deleted == null) {
            LOGGER.debug("No PolicyInfoBtt found with id: {}", policyinfobttId);
            throw new EntityNotFoundException(String.valueOf(policyinfobttId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<PolicyInfoBtt> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PolicyInfoBtts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyInfoBtt> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PolicyInfoBtts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyInfoBtt> findHistory(String applicationClause, String systemClause, String query, Pageable pageable) {
        List<PeriodClause> periodClauses = new ArrayList<>(2);
        if(applicationClause != null && !applicationClause.isEmpty()) {
            periodClauses.add(new PeriodClauseWrapper(TableTemporal.TemporalType.APPLICATION, applicationClause));
        }
        if(systemClause != null && !systemClause.isEmpty()) {
            periodClauses.add(new PeriodClauseWrapper(TableTemporal.TemporalType.SYSTEM, systemClause));
        }
        return findHistory(periodClauses, query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<PolicyInfoBtt> findHistory(List<PeriodClause> periodClauses, String query, Pageable pageable) {
        LOGGER.debug("Finding history data for PolicyInfoBtt");
        return this.wmGenericDao.findHistory(periodClauses, query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table PolicyInfoBtt to {} format", exportType);
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

