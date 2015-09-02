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

import java.net.Inet4Address;

/**
 * Transferable Object IPv4
 *
 * Transfers information about or corresponding to an IPv4 address.
 */
public class IPv4TO extends IPTO{
    private Inet4Address iPv4Address;
    private Inet4Address iPv4NetMask;
    private Inet4Address iPv4GateWay;
    private Inet4Address iPv4Dns1;
    private Inet4Address iPv4Dns2;

    /**
     * Default constructor.
     */
    public IPv4TO() {
    }

    public Inet4Address getIPv4Address() {
        return iPv4Address;
    }

    public void setIPv4Address(Inet4Address iPv4Address) {
        this.iPv4Address = iPv4Address;
    }

    public Inet4Address getIPv4NetMask() {
        return iPv4NetMask;
    }

    public void setIPv4NetMask(Inet4Address iPv4NetMask) {
        this.iPv4NetMask = iPv4NetMask;
    }

    public Inet4Address getIPv4GateWay() {
        return iPv4GateWay;
    }

    public void setIPv4GateWay(Inet4Address iPv4GateWay) {
        this.iPv4GateWay = iPv4GateWay;
    }

    public Inet4Address getIPv4Dns1() {
        return iPv4Dns1;
    }

    public void setIPv4Dns1(Inet4Address iPv4Dns1) {
        this.iPv4Dns1 = iPv4Dns1;
    }

    public Inet4Address getIPv4Dns2() {
        return iPv4Dns2;
    }

    public void setIPv4Dns2(Inet4Address iPv4Dns2) {
        this.iPv4Dns2 = iPv4Dns2;
    }
}