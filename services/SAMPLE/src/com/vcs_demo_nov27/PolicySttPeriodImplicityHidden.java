/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.vcs_demo_nov27;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.wavemaker.runtime.data.annotations.TableTemporal;

/**
 * PolicySttPeriodImplicityHidden generated by WaveMaker Studio.
 */
@TableTemporal(value = {TableTemporal.TemporalType.SYSTEM})
@Entity
@Table(name = "`POLICY_STT_PERIOD_IMPLICITY_HIDDEN`")
@IdClass(PolicySttPeriodImplicityHiddenId.class)
public class PolicySttPeriodImplicityHidden implements Serializable {

    private String policyId;
    private Integer coverage;
    private Timestamp sysStart;
    private Timestamp sysEnd;
    private Timestamp tsId;

    @Id
    @Column(name = "`POLICY_ID`", nullable = false, length = 4)
    public String getPolicyId() {
        return this.policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    @Id
    @Column(name = "`COVERAGE`", nullable = false, scale = 0, precision = 10)
    public Integer getCoverage() {
        return this.coverage;
    }

    public void setCoverage(Integer coverage) {
        this.coverage = coverage;
    }

    @Id
    @Column(name = "`SYS_START`", nullable = false)
    public Timestamp getSysStart() {
        return this.sysStart;
    }

    public void setSysStart(Timestamp sysStart) {
        this.sysStart = sysStart;
    }

    @Id
    @Column(name = "`SYS_END`", nullable = false)
    public Timestamp getSysEnd() {
        return this.sysEnd;
    }

    public void setSysEnd(Timestamp sysEnd) {
        this.sysEnd = sysEnd;
    }

    @Id
    @Column(name = "`TS_ID`", nullable = false)
    public Timestamp getTsId() {
        return this.tsId;
    }

    public void setTsId(Timestamp tsId) {
        this.tsId = tsId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolicySttPeriodImplicityHidden)) return false;
        final PolicySttPeriodImplicityHidden policySttPeriodImplicityHidden = (PolicySttPeriodImplicityHidden) o;
        return Objects.equals(getPolicyId(), policySttPeriodImplicityHidden.getPolicyId()) &&
                Objects.equals(getCoverage(), policySttPeriodImplicityHidden.getCoverage()) &&
                Objects.equals(getSysStart(), policySttPeriodImplicityHidden.getSysStart()) &&
                Objects.equals(getSysEnd(), policySttPeriodImplicityHidden.getSysEnd()) &&
                Objects.equals(getTsId(), policySttPeriodImplicityHidden.getTsId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPolicyId(),
                getCoverage(),
                getSysStart(),
                getSysEnd(),
                getTsId());
    }
}

