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
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cloud.utils.UUID5;
import com.cloud.utils.db.GenericDao;
import com.cloud.utils.net.MacAddress;

@Entity
@Table(name = "nics")
public class NicVO implements Nic {
    protected NicVO() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "uuid")
    byte[] uuid;

    @Column(name = "instance_id")
    long instanceId;

    @Column(name = "network_id")
    long networkId;

    @Column(name = "reservation_uuid")
    byte[] reservationUuid;

    @Column(name = "device_id")
    int deviceId;

    @Column(name = "mac_address")
    byte[] macAddress;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    State state;

    @Column(name = "reservation_strategy")
    @Enumerated(value = EnumType.STRING)
    ReservationStrategy reservationStrategy;

    @Column(name = "reserver_name")
    String reserverName;

    @Column(name = "update_time")
    Date updateTime;

    @Column(name = "default_nic")
    boolean defaultNic;

    @Column(name = GenericDao.CREATED_COLUMN)
    Date created;

    @Column(name = GenericDao.REMOVED_COLUMN)
    Date removed;

    public NicVO(long instanceId, long networkId, ReservationStrategy reservationStrategy, String reserverName, boolean defaultNic) {
        this.instanceId = instanceId;
        this.networkId = networkId;
        this.reservationStrategy = reservationStrategy;
        this.reserverName = reserverName;
        this.defaultNic = defaultNic;
        this.state = State.Allocated;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public UUID getUuid() {
        return UUID5.fromByteArray(uuid);
    }

    public void setUuid(byte[] uuid) {
        this.uuid = uuid;
    }

    @Override
    public long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(long instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public long getNetworkId() {
        return networkId;
    }

    public void setNetworkId(long networkId) {
        this.networkId = networkId;
    }

    @Override
    public UUID getReservationUuid() {
        return UUID5.fromByteArray(reservationUuid);
    }

    public void setReservationUuid(UUID reservationUuid) {
        this.reservationUuid = UUID5.toByteArray(reservationUuid);
    }

    @Override
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public MacAddress getMacAddress() {
        return new MacAddress(macAddress);
    }

    public void setMacAddress(MacAddress macAddress) {
        this.macAddress = macAddress.getBytes();
    }

    @Override
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public ReservationStrategy getReservationStrategy() {
        return reservationStrategy;
    }

    public void setReservationStrategy(ReservationStrategy reservationStrategy) {
        this.reservationStrategy = reservationStrategy;
    }

    @Override
    public String getReserverName() {
        return reserverName;
    }

    public void setReserver(String reserverName) {
        this.reserverName = reserverName;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public boolean isDefaultNic() {
        return defaultNic;
    }

    public void setDefaultNic(boolean defaultNic) {
        this.defaultNic = defaultNic;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public Date getRemoved() {
        return removed;
    }
}
