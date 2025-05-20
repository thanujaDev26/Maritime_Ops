package com.Maritime.CruiseShipsOpsAPI.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OperationType {
    DOCKING,
    UNDOCKING,
    PASSENGER_EMBARKATION,
    PASSENGER_DEBARKATION,
    CARGO_LOADING,
    CARGO_UNLOADING,
    FUEL_REFILL,
    MAINTENANCE_CHECK,
    SECURITY_CHECK,
    CUSTOMS_INSPECTION,
    CREW_ROTATION,
    WASTE_DISPOSAL,
    WATER_SUPPLY,
    MEDICAL_ASSISTANCE,
    EMERGENCY_RESPONSE,
    TECHNICAL_INSPECTION,
    BUNKERING,
    ANCHORAGE,
    PILOT_ONBOARDING;

    @JsonCreator
    public static OperationType fromString(String value) {
        return OperationType.valueOf(value.toUpperCase());
    }
}
