//
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
//

package com.cloud.agent.api;

import java.net.InetAddress;

import com.cloud.agent.api.LogLevel.Log4jLevel;

@LogLevel(Log4jLevel.Trace)
public class NetworkUsageCommand extends Command {
    private InetAddress privateIP;
    private String domRName;
    private String option;
    boolean forVpc = false;
    private InetAddress gatewayIP;
    private String vpcCIDR;

    protected NetworkUsageCommand() {

    }

    public NetworkUsageCommand(InetAddress privateIP, String domRName, boolean forVpc, InetAddress gatewayIP) {
        this.privateIP = privateIP;
        this.domRName = domRName;
        this.forVpc = forVpc;
        this.gatewayIP = gatewayIP;
        this.option = "get";
    }

    public NetworkUsageCommand(InetAddress privateIP, String domRName, String option, boolean forVpc) {
        this.privateIP = privateIP;
        this.domRName = domRName;
        this.option = option;
        this.forVpc = forVpc;
    }

    public NetworkUsageCommand(InetAddress privateIP, String domRName, boolean forVpc, InetAddress gatewayIP, String vpcCIDR) {
        this.privateIP = privateIP;
        this.domRName = domRName;
        this.forVpc = forVpc;
        this.gatewayIP = gatewayIP;
        this.option = "create";
        this.vpcCIDR = vpcCIDR;
    }

    public NetworkUsageCommand(InetAddress privateIP, String domRName, String option, boolean forVpc, InetAddress gatewayIP) {
        this.privateIP = privateIP;
        this.domRName = domRName;
        this.forVpc = forVpc;
        this.gatewayIP = gatewayIP;
        this.option = option;
    }

    public InetAddress getPrivateIP() {
        return privateIP;
    }

    public String getDomRName() {
        return domRName;
    }

    public String getOption() {
        return option;
    }

    public boolean isForVpc() {
        return forVpc;
    }

    public String getVpcCIDR() {
        return vpcCIDR;
    }

    public InetAddress getGatewayIP() {
        return gatewayIP;
    }

    @Override
    public boolean executeInSequence() {
        return false;
    }
}
