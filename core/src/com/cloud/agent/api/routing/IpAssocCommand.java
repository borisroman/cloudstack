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

package com.cloud.agent.api.routing;

import java.util.Set;

import com.cloud.agent.api.to.NicTO;

public class IpAssocCommand extends NetworkElementCommand {

    Set<NicTO> nicTOs;

    protected IpAssocCommand() {
    }

    public IpAssocCommand(Set<NicTO> nicTOs) {
        this.nicTOs = nicTOs;
    }

    @Override
    public boolean executeInSequence() {
        return false;
    }

    public Set<NicTO> getNicTOs() {
        return nicTOs;
    }

    @Override
    public int getAnswersCount() {
        int count = 0;
        for (NicTO nicTO : nicTOs) {
            count += (nicTO.getIPv4TOs().size() + nicTO.getIPv6TOs().size());
        }
        return count;
    }
}
