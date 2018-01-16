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
 * PolicyStt generated by WaveMaker Studio.
 */
@TableTemporal(value = {TableTemporal.TemporalType.SYSTEM})
@Entity
@Table(name = "`POLICY_STT`")
@IdClass(PolicySttId.class)
public class PolicyStt implements Serializable {

    private String bank;
    private String client;
    private Timestamp sysBegin;
    private Timestamp sysEnd;
    private Timestamp transId;
    private String type;
    private Integer pay;

    @Id
    @Column(name = "`BANK`", nullable = false, length = 4)
    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Id
    @Column(name = "`CLIENT`", nullable = false, length = 4)
    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Column(name = "`SYS_BEGIN`", nullable = false, insertable = false, updatable = false)
    public Timestamp getSysBegin() {
        return this.sysBegin;
    }

    public void setSysBegin(Timestamp sysBegin) {
        this.sysBegin = sysBegin;
    }

    @Column(name = "`SYS_END`", nullable = false, insertable = false, updatable = false)
    public Timestamp getSysEnd() {
        return this.sysEnd;
    }

    public void setSysEnd(Timestamp sysEnd) {
        this.sysEnd = sysEnd;
    }

    @Column(name = "`TRANS_ID`", nullable = false, insertable = false, updatable = false)
    public Timestamp getTransId() {
        return this.transId;
    }

    public void setTransId(Timestamp transId) {
        this.transId = transId;
    }

    @Column(name = "`TYPE`", nullable = true, length = 5)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "`PAY`", nullable = true, scale = 0, precision = 10)
    public Integer getPay() {
        return this.pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolicyStt)) return false;
        final PolicyStt policyStt = (PolicyStt) o;
        return Objects.equals(getBank(), policyStt.getBank()) &&
                Objects.equals(getClient(), policyStt.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBank(),
                getClient());
    }
}
