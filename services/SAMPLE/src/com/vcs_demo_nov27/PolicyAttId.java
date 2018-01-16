/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.vcs_demo_nov27;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class PolicyAttId implements Serializable {

    private String bank;
    private String client;

    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolicyAtt)) return false;
        final PolicyAtt policyAtt = (PolicyAtt) o;
        return Objects.equals(getBank(), policyAtt.getBank()) &&
                Objects.equals(getClient(), policyAtt.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBank(),
                getClient());
    }
}
