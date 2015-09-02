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

import java.net.Inet6Address;

/**
 * Transferable Object IPv6
 *
 * Transfers information about or corresponding to an IPv6 address.
 */
public class IPv6TO extends IPTO{
    private Inet6Address iPv6Address;
    private int iPv6Cidr;
    private Inet6Address iPv6DefaultGateWay;
    private Inet6Address iPv6Dns1;
    private Inet6Address iPv6Dns2;

    /**
     * Default constructor.
     */
    public IPv6TO() {
    }

    public Inet6Address getIPv6Address() {
        return iPv6Address;
    }

    public void setIPv6Address(Inet6Address iPv6Address) {
        this.iPv6Address = iPv6Address;
    }

    public int getIPv6Cidr() {
        return iPv6Cidr;
    }

    public void setIPv6Cidr(int iPv6Cidr) {
        this.iPv6Cidr = iPv6Cidr;
    }

    public Inet6Address getIPv6DefaultGateWay() {
        return iPv6DefaultGateWay;
    }

    public void setIPv6DefaultGateWay(Inet6Address iPv6DefaultGateWay) {
        this.iPv6DefaultGateWay = iPv6DefaultGateWay;
    }

    public Inet6Address getIPv6Dns1() {
        return iPv6Dns1;
    }

    public void setIPv6Dns1(Inet6Address iPv6Dns1) {
        this.iPv6Dns1 = iPv6Dns1;
    }

    public Inet6Address getIPv6Dns2() {
        return iPv6Dns2;
    }

    public void setIPv6Dns2(Inet6Address iPv6Dns2) {
        this.iPv6Dns2 = iPv6Dns2;
    }
}