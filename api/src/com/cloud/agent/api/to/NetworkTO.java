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

import java.net.InetAddress;
import java.net.URI;

import com.cloud.network.Networks.BroadcastDomainType;
import com.cloud.network.Networks.TrafficType;

/**
 * Transfer object to transfer network settings.
 */
public class NetworkTO {
    protected String uuid;
    protected InetAddress ip;
    protected InetAddress netmask;
    protected InetAddress gateway;
    protected String mac;
    protected InetAddress dns1;
    protected InetAddress dns2;
    protected BroadcastDomainType broadcastType;
    protected TrafficType type;
    protected URI broadcastUri;
    protected URI isolationUri;
    protected boolean isSecurityGroupEnabled;
    protected String name;

    public NetworkTO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BroadcastDomainType getBroadcastType() {
        return broadcastType;
    }

    public void setBroadcastType(BroadcastDomainType broadcastType) {
        this.broadcastType = broadcastType;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public void setNetmask(InetAddress netmask) {
        this.netmask = netmask;
    }

    public void setGateway(InetAddress gateway) {
        this.gateway = gateway;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setDns1(InetAddress dns1) {
        this.dns1 = dns1;
    }

    public void setDns2(InetAddress dns2) {
        this.dns2 = dns2;
    }

    public void setType(TrafficType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSecurityGroupEnabled(boolean enabled) {
        this.isSecurityGroupEnabled = enabled;
    }

    /**
     * This constructor is usually for hosts where the other information are not important.
     *
     * @param ip ip address
     * @param netmask netmask
     * @param mac mac address
     */
    public NetworkTO(InetAddress ip, InetAddress netmask, String mac) {
        this(ip, netmask, mac, null, null, null);
    }

    /**
     * This is the full constructor and should be used for VM's network as it contains
     * the full information about what is needed.
     *
     * @param ip
     * @param vlan
     * @param netmask
     * @param mac
     * @param gateway
     * @param dns1
     * @param dns2
     */
    public NetworkTO(InetAddress ip, InetAddress netmask, String mac, InetAddress gateway, InetAddress dns1, InetAddress dns2) {
        this.ip = ip;
        this.netmask = netmask;
        this.mac = mac;
        this.gateway = gateway;
        this.dns1 = dns1;
        this.dns2 = dns2;
    }

    public InetAddress getIp() {
        return ip;
    }

    public InetAddress getNetmask() {
        return netmask;
    }

    public InetAddress getGateway() {
        return gateway;
    }

    public String getMac() {
        return mac;
    }

    public InetAddress getDns1() {
        return dns1;
    }

    public InetAddress getDns2() {
        return dns2;
    }

    public TrafficType getType() {
        return type;
    }

    public URI getBroadcastUri() {
        return broadcastUri;
    }

    public void setBroadcastUri(URI broadcastUri) {
        // only do this if the scheme needs aligning with the broadcastUri
        if (broadcastUri != null && getBroadcastType() == null) {
            setBroadcastType(BroadcastDomainType.getSchemeValue(broadcastUri));
        }
        this.broadcastUri = broadcastUri;
    }

    public URI getIsolationUri() {
        return isolationUri;
    }

    public void setIsolationuri(URI isolationUri) {
        this.isolationUri = isolationUri;
    }

    public boolean isSecurityGroupEnabled() {
        return this.isSecurityGroupEnabled;
    }
}
