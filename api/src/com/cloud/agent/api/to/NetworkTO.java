// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.agent.api.to;

import java.net.URI;

import com.cloud.network.Networks.BroadcastDomainType;
import com.cloud.network.Networks.TrafficType;

/**
 * Transferable Object Network
 *
 * Transfers information about a Network.
 */
public class NetworkTO {
    private String networkName;
    private BroadcastDomainType broadcastType;
    private TrafficType trafficType;
    private URI broadcastUri;
    private URI isolationUri;
    private String vlanGateway;
    private String vlanNetmask;
    private boolean sourceNat;
    private boolean oneToOneNat;
    private boolean isSecurityGroupEnabled;

    /**
     * Default constructor
     */
    public NetworkTO() {
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public BroadcastDomainType getBroadcastType() {
        return broadcastType;
    }

    public void setBroadcastType(BroadcastDomainType broadcastType) {
        this.broadcastType = broadcastType;
    }

    public TrafficType getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(TrafficType trafficType) {
        this.trafficType = trafficType;
    }

    public URI getBroadcastUri() {
        return broadcastUri;
    }

    public void setBroadcastUri(URI broadcastUri) {
        this.broadcastUri = broadcastUri;
    }

    public URI getIsolationUri() {
        return isolationUri;
    }

    public void setIsolationUri(URI isolationUri) {
        this.isolationUri = isolationUri;
    }

    public String getVlanGateway() {
        return vlanGateway;
    }

    public void setVlanGateway(String vlanGateway) {
        this.vlanGateway = vlanGateway;
    }

    public String getVlanNetmask() {
        return vlanNetmask;
    }

    public void setVlanNetmask(String vlanNetmask) {
        this.vlanNetmask = vlanNetmask;
    }

    public boolean isSourceNat() {
        return sourceNat;
    }

    public void setSourceNat(boolean sourceNat) {
        this.sourceNat = sourceNat;
    }

    public boolean isOneToOneNat() {
        return oneToOneNat;
    }

    public void setOneToOneNat(boolean oneToOneNat) {
        this.oneToOneNat = oneToOneNat;
    }

    public boolean isSecurityGroupEnabled() {
        return isSecurityGroupEnabled;
    }

    public void setSecurityGroupEnabled(boolean isSecurityGroupEnabled) {
        this.isSecurityGroupEnabled = isSecurityGroupEnabled;
    }
}
