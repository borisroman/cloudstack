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
package com.cloud.vm;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.cloudstack.api.Identity;
import org.apache.cloudstack.api.InternalIdentity;

import com.cloud.utils.fsm.FiniteState;
import com.cloud.utils.fsm.StateMachine;
import com.cloud.utils.net.MacAddress;

/**
 * Nic represents a single nic on a VM.
 */
public interface Nic extends Identity, InternalIdentity {
    enum Event {
        ReservationRequested, ReleaseRequested, CancelRequested, OperationCompleted, OperationFailed,
    }

    public enum State implements FiniteState<State, Event> {
        Allocated   ("Resource is allocated but not reserved"),
        Reserving   ("Resource is being reserved right now"),
        Reserved    ("Resource has been reserved."),
        Releasing   ("Resource is being released"),
        Deallocating("Resource is being deallocated");

        String _description;

        @Override
        public StateMachine<State, Event> getStateMachine() {
            return s_fsm;
        }

        @Override
        public State getNextState(Event event) {
            return s_fsm.getNextState(this, event);
        }

        @Override
        public List<State> getFromStates(Event event) {
            return s_fsm.getFromStates(this, event);
        }

        @Override
        public Set<Event> getPossibleEvents() {
            return s_fsm.getPossibleEvents(this);
        }

        private State(String description) {
            _description = description;
        }

        @Override
        public String getDescription() {
            return _description;
        }

        final static private StateMachine<State, Event> s_fsm = new StateMachine<State, Event>();
        static {
            s_fsm.addTransition(State.Allocated, Event.ReservationRequested, State.Reserving);
            s_fsm.addTransition(State.Reserving, Event.CancelRequested, State.Allocated);
            s_fsm.addTransition(State.Reserving, Event.OperationCompleted, State.Reserved);
            s_fsm.addTransition(State.Reserving, Event.OperationFailed, State.Allocated);
            s_fsm.addTransition(State.Reserved, Event.ReleaseRequested, State.Releasing);
            s_fsm.addTransition(State.Releasing, Event.OperationCompleted, State.Allocated);
            s_fsm.addTransition(State.Releasing, Event.OperationFailed, State.Reserved);
        }
    }

    public enum ReservationStrategy {
        PlaceHolder, Create, Start, Managed;
    }

    /**
     * @return the id of the vm this nic is attached to.
     */
    long getInstanceId();

    /**
     * @return the id of the network this vm is in.
     */
    long getNetworkId();

    /**
     * @return reservation id returned by the allocation source. This can be the String version of the
     *          database id if the allocation source does not need it's own implementation of the reservation id.
     *          This is passed back to the allocation source to release the resource.
     */
    UUID getReservationUuid();

    /**
     * @return the device id of the nic.
     */
    int getDeviceId();

    /**
     * @return the mac address of the resource.
     */
    MacAddress getMacAddress();

    /**
     * @return the reservation state of the resource.
     */
    State getState();

    /**
     * @return the reservation strategy of the resource.
     */
    ReservationStrategy getReservationStrategy();

    /**
     * @return unique name for the allocation source.
     */
    String getReserverName();

    /**
     * @return the time a reservation request was made to the allocation source.
     */
    Date getUpdateTime();

    /**
     * @return true if this is the default nic of the VM. False otherwise.
     */
    boolean isDefaultNic();

    /**
     * @return the time at which this nic was created.
     */
    Date getCreated();

    /**
     * @return the time at which this nic was removed.
     */
    Date getRemoved();
}
