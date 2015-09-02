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
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.cloud.host.Host;

public class HostTO {
    private static final Logger s_logger = Logger.getLogger(HostTO.class);

    private String guid;
    private NetworkTO privateNetwork;
    private NetworkTO publicNetwork;
    private NetworkTO storageNetwork1;
    private NetworkTO storageNetwork2;

    protected HostTO() {
    }

    public HostTO(Host vo) {
        guid = vo.getGuid();

        /**
         * TODO The following will be removed when the VO classes are being converted from String to InetAddress.
         */
        InetAddress privateIpAddress = null;
        InetAddress privateNetmask = null;
        InetAddress publicIpAddress = null;
        InetAddress publicNetmask = null;
        InetAddress storageIpAddress = null;
        InetAddress storageNetmask = null;
        InetAddress storageIpAddress2 = null;
        InetAddress storageNetmask2 = null;

        try {
            privateIpAddress = InetAddress.getByName(vo.getPrivateIpAddress());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }
        try {
            privateNetmask = InetAddress.getByName(vo.getPrivateNetmask());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }
        try {
            publicIpAddress = InetAddress.getByName(vo.getPublicIpAddress());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }
        try {
            publicNetmask = InetAddress.getByName(vo.getPublicNetmask());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }
        try {
            storageIpAddress = InetAddress.getByName(vo.getStorageIpAddress());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }
        try {
            storageNetmask = InetAddress.getByName(vo.getStorageNetmask());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }
        try {
            storageIpAddress2 = InetAddress.getByName(vo.getStorageIpAddressDeux());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }
        try {
            storageNetmask2 = InetAddress.getByName(vo.getStorageNetmaskDeux());
        } catch (UnknownHostException e) {
            s_logger.debug("Couldn't parse ip address String to InetAddress: " + e);
        }

        privateNetwork = new NetworkTO(privateIpAddress, privateNetmask, vo.getPrivateMacAddress());
        if (vo.getPublicIpAddress() != null) {
            publicNetwork = new NetworkTO(publicIpAddress, publicNetmask, vo.getPublicMacAddress());
        }
        if (vo.getStorageIpAddress() != null) {
            storageNetwork1 = new NetworkTO(storageIpAddress, storageNetmask, vo.getStorageMacAddress());
        }
        if (vo.getStorageIpAddressDeux() != null) {
            storageNetwork2 = new NetworkTO(storageIpAddress2, storageNetmask2, vo.getStorageMacAddressDeux());
        }
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public NetworkTO getPrivateNetwork() {
        return privateNetwork;
    }

    public void setPrivateNetwork(NetworkTO privateNetwork) {
        this.privateNetwork = privateNetwork;
    }

    public NetworkTO getPublicNetwork() {
        return publicNetwork;
    }

    public void setPublicNetwork(NetworkTO publicNetwork) {
        this.publicNetwork = publicNetwork;
    }

    public NetworkTO getStorageNetwork1() {
        return storageNetwork1;
    }

    public void setStorageNetwork1(NetworkTO storageNetwork1) {
        this.storageNetwork1 = storageNetwork1;
    }

    public NetworkTO getStorageNetwork2() {
        return storageNetwork2;
    }

    public void setStorageNetwork2(NetworkTO storageNetwork2) {
        this.storageNetwork2 = storageNetwork2;
    }
}
