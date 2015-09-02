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
package com.cloud.host;

import java.net.Inet4Address;
import java.util.Date;

import org.apache.cloudstack.api.Identity;
import org.apache.cloudstack.api.InternalIdentity;

import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.resource.ResourceState;
import com.cloud.storage.Storage.StoragePoolType;
import com.cloud.utils.fsm.StateObject;
import com.cloud.utils.net.MacAddress;

/**
 *  Host represents one particular host server.
 */
public interface Host extends StateObject<Status>, Identity, InternalIdentity {
    public enum Type {
        BaremetalDhcp(false),
        BaremetalPxe(false),
        ConsoleProxy(true),
        ExternalDhcp(false),
        ExternalFirewall(false),
        ExternalLoadBalancer(false),
        ExternalVirtualSwitchSupervisor(false),
        L2Networking(false),
        LocalSecondaryStorage(false),
        PxeServer(false),
        Routing(false),
        SecondaryStorage(false),
        SecondaryStorageCmdExecutor(false),
        SecondaryStorageVM(true),
        Storage(false),
        TrafficMonitor(false);

        boolean _virtual;

        private Type(boolean virtual) {
            _virtual = virtual;
        }

        public boolean isVirtual() {
            return _virtual;
        }

        public static String[] toStrings(Host.Type... types) {
            String[] strs = new String[types.length];
            for (int i = 0; i < types.length; i++) {
                strs[i] = types[i].toString();
            }
            return strs;
        }
    }

    /**
     * @return name of the machine.
     */
    String getName();

    /////////
    // IDs //
    /////////

    /**
     * @return the pod id.
     */
    long getPodId();

    /**
     * @return the cluster id.
     */
    long getClusterId();

    /**
     * @return availability zone id.
     */
    long getDataCenterId();

    /**
     * @return management server id
     */
    long getManagementServerId();

    ////////////////
    // Host specs //
    ////////////////

    /**
     * @return total amount of memory.
     */
    long getTotalMemory();

    /**
     * @return # of cpu sockets in a machine.
     */
    int getCpuSockets();

    /**
     * @return # of cores in a machine.  Note two cpus with two cores each returns 4.
     */
    int getCpus();

    /**
     * @return speed of each cpu in mhz.
     */
    long getSpeed();

    /**
     * @return total size
     */
    long getTotalSize();

    /**
     * @return type of hypervisor
     */
    HypervisorType getHypervisorType();

    ////////////
    // STATUS //
    ////////////

    /**
     * @return current state of this machine.
     */
    Status getStatus();

    /**
     * @return true if the host is in maintance mode.
     */
    boolean isInMaintenanceStates();

    /**
     * @return the resource state.
     */
    ResourceState getResourceState();

    /**
     * @return disconnection date
     */
    Date getDisconnectedOn();

    /**
     * @return last pinged time
     */
    long getLastPinged();

    //////////////
    // VERSIONS //
    //////////////

    /**
     * @return the hypervisor version
     */
    String getHypervisorVersion();

    //////////////////
    // HOST VARIOUS //
    //////////////////

    /**
     * @return the type of host.
     */
    Type getType();

    /**
     * @return the storage pool type of this host.
     */
    StoragePoolType getStoragePoolType();

    /**
     * @return the storage url being used on the host.
     */
    String getStorageUrl();

    /**
     * @return the proxy port that is being listened at the agent host
     */
    int getProxyPort();

    /**
     * @return parent path. Only used for storage server.
     */
    String getParent();

    ///////////////////////
    // CREATED / REMOVED //
    ///////////////////////

    /**
     * @return the date the host first registered
     */
    Date getCreated();

    /**
     * @return removal date
     */
    Date getRemoved();

    /**
     * @return capabilities
     */
    String getCapabilities();


    //////////////////
    // IP Addresses //
    //////////////////

    // Public IPv4
    Inet4Address getPublicIPv4Address();

    Inet4Address getPublicIPv4Netmask();

    MacAddress getPublicMacAddress();

    // Private IPv4
    Inet4Address getPrivateIPv4Address();

    Inet4Address getPrivateIPv4Netmask();

    MacAddress getPrivateMacAddress();

    // Storage IPv4
    Inet4Address getStorageIPv4Address();

    Inet4Address getStorageIPv4Netmask();

    MacAddress getStorageMacAddress();

    // Storage 2 IPv4
    Inet4Address getStorageIPv4AddressDeux();

    Inet4Address getStorageIPv4NetmaskDeux();

    MacAddress getStorageMacAddressDeux();
}
