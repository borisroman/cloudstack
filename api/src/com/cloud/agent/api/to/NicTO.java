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

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.cloud.utils.net.MacAddress;

/**
 * Transferable Object NicTO
 *
 * Transfers information about a Nic.
 */
public class NicTO {
    private UUID uuid;
    private String name;
    private MacAddress macAddress;
    private int deviceId;
    private int networkRateMbps;
    private int networkRateMulticastMbps;
    private boolean add; // FIXME What does it do? Find out after refactor.
    private boolean defaultNic;
    private boolean newNic;
    private boolean pxeDisable;
    private Set<IPv4TO> iPv4TOs;
    private Set<IPv6TO> iPv6TOs;
    private NetworkTO networkTO;

    /**
     * Default constructor
     */
    public NicTO() {
        iPv4TOs = new HashSet<>();
        iPv6TOs = new HashSet<>();
        networkTO = new NetworkTO();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MacAddress getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(MacAddress macAddress) {
        this.macAddress = macAddress;
    }


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getNetworkRateMbps() {
        return networkRateMbps;
    }

    public void setNetworkRateMbps(int networkRateMbps) {
        this.networkRateMbps = networkRateMbps;
    }

    public int getNetworkRateMulticastMbps() {
        return networkRateMulticastMbps;
    }

    public void setNetworkRateMulticastMbps(int networkRateMulticastMbps) {
        this.networkRateMulticastMbps = networkRateMulticastMbps;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isDefaultNic() {
        return defaultNic;
    }

    public void setDefaultNic(boolean defaultNic) {
        this.defaultNic = defaultNic;
    }

    public boolean isNewNic() {
        return newNic;
    }

    public void setNewNic(boolean newNic) {
        this.newNic = newNic;
    }

    public boolean isPxeDisable() {
        return pxeDisable;
    }

    public void setPxeDisable(boolean pxeDisable) {
        this.pxeDisable = pxeDisable;
    }

    public Set<IPv4TO> getIPv4TOs() {
        return iPv4TOs;
    }

    public void setIPv4TOs(Set<IPv4TO> iPv4TOs) {
        this.iPv4TOs = iPv4TOs;
    }

    public Set<IPv6TO> getIPv6TOs() {
        return iPv6TOs;
    }

    public void setIPv6TOs(Set<IPv6TO> iPv6TOs) {
        this.iPv6TOs = iPv6TOs;
    }

    public NetworkTO getNetworkTO() {
        return networkTO;
    }

    public void setNetworkTO(NetworkTO networkTO) {
        this.networkTO = networkTO;
    }
}
