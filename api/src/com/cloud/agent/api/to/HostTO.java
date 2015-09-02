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

import com.cloud.host.Host;

/**
 * Transferable Object Host
 *
 * Transfers information about a Host.
 */
public class HostTO {
    private String uuid;
    private NicTO privateNicTO;
    private NicTO publicNicTO;
    private NicTO storage1NicTO;
    private NicTO storage2NicTO;

    protected HostTO() {
    }

    public HostTO(Host host) {
        uuid = host.getUuid();

        if (host.getPrivateIPv4Address() != null) {
            IPv4TO privateIPv4TO = new IPv4TO();
            privateIPv4TO.setIPv4Address(host.getPrivateIPv4Address());
            privateIPv4TO.setIPv4NetMask(host.getPrivateIPv4Netmask());

            privateNicTO = new NicTO();
            privateNicTO.setMac(host.getPrivateMacAddress());
            privateNicTO.getIPv4Addresses().add(privateIPv4TO);
        }

        if (host.getPublicIPv4Address() != null) {
            IPv4TO publicIPv4TO = new IPv4TO();
            publicIPv4TO.setIPv4Address(host.getPublicIPv4Address());
            publicIPv4TO.setIPv4NetMask(host.getPublicIPv4Netmask());

            publicNicTO = new NicTO();
            publicNicTO.setMac(host.getPublicMacAddress());
            publicNicTO.getIPv4Addresses().add(publicIPv4TO);
        }

        if (host.getStorageIPv4Address() != null) {
            IPv4TO storageIPv4TO = new IPv4TO();
            storageIPv4TO.setIPv4Address(host.getStorageIPv4Address());
            storageIPv4TO.setIPv4NetMask(host.getStorageIPv4Netmask());

            storage1NicTO = new NicTO();
            storage1NicTO.setMac(host.getStorageMacAddress());
            storage1NicTO.getIPv4Addresses().add(storageIPv4TO);
        }

        if (host.getStorageIPv4AddressDeux() != null) {
            IPv4TO storageIPv4TO = new IPv4TO();
            storageIPv4TO.setIPv4Address(host.getStorageIPv4AddressDeux());
            storageIPv4TO.setIPv4NetMask(host.getStorageIPv4NetmaskDeux());

            storage2NicTO = new NicTO();
            storage2NicTO.setMac(host.getStorageMacAddressDeux());
            storage2NicTO.getIPv4Addresses().add(storageIPv4TO);
        }
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public NicTO getPrivateNicTO() {
        return privateNicTO;
    }

    public void setPrivateNicTO(NicTO privateNicTO) {
        this.privateNicTO = privateNicTO;
    }

    public NicTO getPublicNicTO() {
        return publicNicTO;
    }

    public void setPublicNicTO(NicTO publicNicTO) {
        this.publicNicTO = publicNicTO;
    }

    public NicTO getStorage1NicTO() {
        return storage1NicTO;
    }

    public void setStorage1NicTO(NicTO storage1NicTO) {
        this.storage1NicTO = storage1NicTO;
    }

    public NicTO getStorage2NicTO() {
        return storage2NicTO;
    }

    public void setStorage2NicTO(NicTO storage2NicTO) {
        this.storage2NicTO = storage2NicTO;
    }
}
