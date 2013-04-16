/**
 * Copyright 2013 - All Rights Reserved.
 */
package com.trane.enums;

import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.Lexicon;

/**
 *  BLonTraneAlarmMessage is an enumerated list of values.  This list will contain all possible alarm messages for nvoAlarmMessage
 *
 * @author Mike McDaniel
 * @creation Mar 29, 2013
 *
 */
public final class BLonTraneAlarmMessage
    extends BFrozenEnum
{
  /*-
   enum BLonTraneAlarmMessage
   {
     range
     {
      maintenanceRequired,
      spaceTempSensorFail,
      outdoorTempSensorFail,
      compressor1HPCLockout,
      compressor1LPCLockout,
      comp1DisableInputLPC,
      compressor2HPCLockout,
      compressor2LPCLockout,
      comp2DisableInputLPC,
      smokeDetector,
      heatFail,
      dirtyFilter,
      supplyFanFail,
      emergencyStopInput,
      froStatTrip,
      unitCommFail,
      mixedAirTempSensorFail,
      oARelHumidityFail,
      rATempSensorFail,
      rARelHumidityFail,
      ventOverridePurge,
      ventOverrideExhaust,
      ventOverridePressurize,
      externalAutoStop,
      freezeStatTripped,
      dischargeTempSensorFail,
      cO2SensorFailure,
      cO2SetpointFailure,
      dehumidSensorFailure,
      dehumidSetpointFailure,
      outdoorAirCFMSensorFail,
      outdoorAirCFMSetptFail,
      spacePressureSetptFail,
      spacePressureSensorFail,
      heatingHighTempLimitOpen,
      noFlameSensedOnHeatCall,
      flameSensedWithGasValveOff,
      gasHeatModuleFailure,
      economizerActuatorFault,
      mWUSetPointFailure,
      sAResetAmountFailure,
      sACoolingSetPointFailure,
      sAResetSetPointFailure,
      sAPressureSetPointFailure,
      sAPressureDeadBandFailure,
      sAPressureSensorFailure,
      sADuctPressureLimitFault,
      sAPressurePWMFault,
      comp1DisableInputHPC,
      comp2DisableInputHPC,
      normal
     }
     default {[ normal ]}
   }
   -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.trane.enums.BLonTraneAlarmMessage(1837862536)1.0$ @*/
/* Generated Mon Apr 01 22:38:49 CDT 2013 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */
  
  /** Ordinal value for maintenanceRequired. */
  public static final int MAINTENANCE_REQUIRED = 0;
  /** Ordinal value for spaceTempSensorFail. */
  public static final int SPACE_TEMP_SENSOR_FAIL = 1;
  /** Ordinal value for outdoorTempSensorFail. */
  public static final int OUTDOOR_TEMP_SENSOR_FAIL = 2;
  /** Ordinal value for compressor1HPCLockout. */
  public static final int COMPRESSOR_1HPCLOCKOUT = 3;
  /** Ordinal value for compressor1LPCLockout. */
  public static final int COMPRESSOR_1LPCLOCKOUT = 4;
  /** Ordinal value for comp1DisableInputLPC. */
  public static final int COMP_1DISABLE_INPUT_LPC = 5;
  /** Ordinal value for compressor2HPCLockout. */
  public static final int COMPRESSOR_2HPCLOCKOUT = 6;
  /** Ordinal value for compressor2LPCLockout. */
  public static final int COMPRESSOR_2LPCLOCKOUT = 7;
  /** Ordinal value for comp2DisableInputLPC. */
  public static final int COMP_2DISABLE_INPUT_LPC = 8;
  /** Ordinal value for smokeDetector. */
  public static final int SMOKE_DETECTOR = 9;
  /** Ordinal value for heatFail. */
  public static final int HEAT_FAIL = 10;
  /** Ordinal value for dirtyFilter. */
  public static final int DIRTY_FILTER = 11;
  /** Ordinal value for supplyFanFail. */
  public static final int SUPPLY_FAN_FAIL = 12;
  /** Ordinal value for emergencyStopInput. */
  public static final int EMERGENCY_STOP_INPUT = 13;
  /** Ordinal value for froStatTrip. */
  public static final int FRO_STAT_TRIP = 14;
  /** Ordinal value for unitCommFail. */
  public static final int UNIT_COMM_FAIL = 15;
  /** Ordinal value for mixedAirTempSensorFail. */
  public static final int MIXED_AIR_TEMP_SENSOR_FAIL = 16;
  /** Ordinal value for oARelHumidityFail. */
  public static final int O_AREL_HUMIDITY_FAIL = 17;
  /** Ordinal value for rATempSensorFail. */
  public static final int R_ATEMP_SENSOR_FAIL = 18;
  /** Ordinal value for rARelHumidityFail. */
  public static final int R_AREL_HUMIDITY_FAIL = 19;
  /** Ordinal value for ventOverridePurge. */
  public static final int VENT_OVERRIDE_PURGE = 20;
  /** Ordinal value for ventOverrideExhaust. */
  public static final int VENT_OVERRIDE_EXHAUST = 21;
  /** Ordinal value for ventOverridePressurize. */
  public static final int VENT_OVERRIDE_PRESSURIZE = 22;
  /** Ordinal value for externalAutoStop. */
  public static final int EXTERNAL_AUTO_STOP = 23;
  /** Ordinal value for freezeStatTripped. */
  public static final int FREEZE_STAT_TRIPPED = 24;
  /** Ordinal value for dischargeTempSensorFail. */
  public static final int DISCHARGE_TEMP_SENSOR_FAIL = 25;
  /** Ordinal value for cO2SensorFailure. */
  public static final int C_O2SENSOR_FAILURE = 26;
  /** Ordinal value for cO2SetpointFailure. */
  public static final int C_O2SETPOINT_FAILURE = 27;
  /** Ordinal value for dehumidSensorFailure. */
  public static final int DEHUMID_SENSOR_FAILURE = 28;
  /** Ordinal value for dehumidSetpointFailure. */
  public static final int DEHUMID_SETPOINT_FAILURE = 29;
  /** Ordinal value for outdoorAirCFMSensorFail. */
  public static final int OUTDOOR_AIR_CFMSENSOR_FAIL = 30;
  /** Ordinal value for outdoorAirCFMSetptFail. */
  public static final int OUTDOOR_AIR_CFMSETPT_FAIL = 31;
  /** Ordinal value for spacePressureSetptFail. */
  public static final int SPACE_PRESSURE_SETPT_FAIL = 32;
  /** Ordinal value for spacePressureSensorFail. */
  public static final int SPACE_PRESSURE_SENSOR_FAIL = 33;
  /** Ordinal value for heatingHighTempLimitOpen. */
  public static final int HEATING_HIGH_TEMP_LIMIT_OPEN = 34;
  /** Ordinal value for noFlameSensedOnHeatCall. */
  public static final int NO_FLAME_SENSED_ON_HEAT_CALL = 35;
  /** Ordinal value for flameSensedWithGasValveOff. */
  public static final int FLAME_SENSED_WITH_GAS_VALVE_OFF = 36;
  /** Ordinal value for gasHeatModuleFailure. */
  public static final int GAS_HEAT_MODULE_FAILURE = 37;
  /** Ordinal value for economizerActuatorFault. */
  public static final int ECONOMIZER_ACTUATOR_FAULT = 38;
  /** Ordinal value for mWUSetPointFailure. */
  public static final int M_WUSET_POINT_FAILURE = 39;
  /** Ordinal value for sAResetAmountFailure. */
  public static final int S_ARESET_AMOUNT_FAILURE = 40;
  /** Ordinal value for sACoolingSetPointFailure. */
  public static final int S_ACOOLING_SET_POINT_FAILURE = 41;
  /** Ordinal value for sAResetSetPointFailure. */
  public static final int S_ARESET_SET_POINT_FAILURE = 42;
  /** Ordinal value for sAPressureSetPointFailure. */
  public static final int S_APRESSURE_SET_POINT_FAILURE = 43;
  /** Ordinal value for sAPressureDeadBandFailure. */
  public static final int S_APRESSURE_DEAD_BAND_FAILURE = 44;
  /** Ordinal value for sAPressureSensorFailure. */
  public static final int S_APRESSURE_SENSOR_FAILURE = 45;
  /** Ordinal value for sADuctPressureLimitFault. */
  public static final int S_ADUCT_PRESSURE_LIMIT_FAULT = 46;
  /** Ordinal value for sAPressurePWMFault. */
  public static final int S_APRESSURE_PWMFAULT = 47;
  /** Ordinal value for comp1DisableInputHPC. */
  public static final int COMP_1DISABLE_INPUT_HPC = 48;
  /** Ordinal value for comp2DisableInputHPC. */
  public static final int COMP_2DISABLE_INPUT_HPC = 49;
  /** Ordinal value for normal. */
  public static final int NORMAL = 50;
  
  /** BLonTraneAlarmMessage constant for maintenanceRequired. */
  public static final BLonTraneAlarmMessage maintenanceRequired = new BLonTraneAlarmMessage(MAINTENANCE_REQUIRED);
  /** BLonTraneAlarmMessage constant for spaceTempSensorFail. */
  public static final BLonTraneAlarmMessage spaceTempSensorFail = new BLonTraneAlarmMessage(SPACE_TEMP_SENSOR_FAIL);
  /** BLonTraneAlarmMessage constant for outdoorTempSensorFail. */
  public static final BLonTraneAlarmMessage outdoorTempSensorFail = new BLonTraneAlarmMessage(OUTDOOR_TEMP_SENSOR_FAIL);
  /** BLonTraneAlarmMessage constant for compressor1HPCLockout. */
  public static final BLonTraneAlarmMessage compressor1HPCLockout = new BLonTraneAlarmMessage(COMPRESSOR_1HPCLOCKOUT);
  /** BLonTraneAlarmMessage constant for compressor1LPCLockout. */
  public static final BLonTraneAlarmMessage compressor1LPCLockout = new BLonTraneAlarmMessage(COMPRESSOR_1LPCLOCKOUT);
  /** BLonTraneAlarmMessage constant for comp1DisableInputLPC. */
  public static final BLonTraneAlarmMessage comp1DisableInputLPC = new BLonTraneAlarmMessage(COMP_1DISABLE_INPUT_LPC);
  /** BLonTraneAlarmMessage constant for compressor2HPCLockout. */
  public static final BLonTraneAlarmMessage compressor2HPCLockout = new BLonTraneAlarmMessage(COMPRESSOR_2HPCLOCKOUT);
  /** BLonTraneAlarmMessage constant for compressor2LPCLockout. */
  public static final BLonTraneAlarmMessage compressor2LPCLockout = new BLonTraneAlarmMessage(COMPRESSOR_2LPCLOCKOUT);
  /** BLonTraneAlarmMessage constant for comp2DisableInputLPC. */
  public static final BLonTraneAlarmMessage comp2DisableInputLPC = new BLonTraneAlarmMessage(COMP_2DISABLE_INPUT_LPC);
  /** BLonTraneAlarmMessage constant for smokeDetector. */
  public static final BLonTraneAlarmMessage smokeDetector = new BLonTraneAlarmMessage(SMOKE_DETECTOR);
  /** BLonTraneAlarmMessage constant for heatFail. */
  public static final BLonTraneAlarmMessage heatFail = new BLonTraneAlarmMessage(HEAT_FAIL);
  /** BLonTraneAlarmMessage constant for dirtyFilter. */
  public static final BLonTraneAlarmMessage dirtyFilter = new BLonTraneAlarmMessage(DIRTY_FILTER);
  /** BLonTraneAlarmMessage constant for supplyFanFail. */
  public static final BLonTraneAlarmMessage supplyFanFail = new BLonTraneAlarmMessage(SUPPLY_FAN_FAIL);
  /** BLonTraneAlarmMessage constant for emergencyStopInput. */
  public static final BLonTraneAlarmMessage emergencyStopInput = new BLonTraneAlarmMessage(EMERGENCY_STOP_INPUT);
  /** BLonTraneAlarmMessage constant for froStatTrip. */
  public static final BLonTraneAlarmMessage froStatTrip = new BLonTraneAlarmMessage(FRO_STAT_TRIP);
  /** BLonTraneAlarmMessage constant for unitCommFail. */
  public static final BLonTraneAlarmMessage unitCommFail = new BLonTraneAlarmMessage(UNIT_COMM_FAIL);
  /** BLonTraneAlarmMessage constant for mixedAirTempSensorFail. */
  public static final BLonTraneAlarmMessage mixedAirTempSensorFail = new BLonTraneAlarmMessage(MIXED_AIR_TEMP_SENSOR_FAIL);
  /** BLonTraneAlarmMessage constant for oARelHumidityFail. */
  public static final BLonTraneAlarmMessage oARelHumidityFail = new BLonTraneAlarmMessage(O_AREL_HUMIDITY_FAIL);
  /** BLonTraneAlarmMessage constant for rATempSensorFail. */
  public static final BLonTraneAlarmMessage rATempSensorFail = new BLonTraneAlarmMessage(R_ATEMP_SENSOR_FAIL);
  /** BLonTraneAlarmMessage constant for rARelHumidityFail. */
  public static final BLonTraneAlarmMessage rARelHumidityFail = new BLonTraneAlarmMessage(R_AREL_HUMIDITY_FAIL);
  /** BLonTraneAlarmMessage constant for ventOverridePurge. */
  public static final BLonTraneAlarmMessage ventOverridePurge = new BLonTraneAlarmMessage(VENT_OVERRIDE_PURGE);
  /** BLonTraneAlarmMessage constant for ventOverrideExhaust. */
  public static final BLonTraneAlarmMessage ventOverrideExhaust = new BLonTraneAlarmMessage(VENT_OVERRIDE_EXHAUST);
  /** BLonTraneAlarmMessage constant for ventOverridePressurize. */
  public static final BLonTraneAlarmMessage ventOverridePressurize = new BLonTraneAlarmMessage(VENT_OVERRIDE_PRESSURIZE);
  /** BLonTraneAlarmMessage constant for externalAutoStop. */
  public static final BLonTraneAlarmMessage externalAutoStop = new BLonTraneAlarmMessage(EXTERNAL_AUTO_STOP);
  /** BLonTraneAlarmMessage constant for freezeStatTripped. */
  public static final BLonTraneAlarmMessage freezeStatTripped = new BLonTraneAlarmMessage(FREEZE_STAT_TRIPPED);
  /** BLonTraneAlarmMessage constant for dischargeTempSensorFail. */
  public static final BLonTraneAlarmMessage dischargeTempSensorFail = new BLonTraneAlarmMessage(DISCHARGE_TEMP_SENSOR_FAIL);
  /** BLonTraneAlarmMessage constant for cO2SensorFailure. */
  public static final BLonTraneAlarmMessage cO2SensorFailure = new BLonTraneAlarmMessage(C_O2SENSOR_FAILURE);
  /** BLonTraneAlarmMessage constant for cO2SetpointFailure. */
  public static final BLonTraneAlarmMessage cO2SetpointFailure = new BLonTraneAlarmMessage(C_O2SETPOINT_FAILURE);
  /** BLonTraneAlarmMessage constant for dehumidSensorFailure. */
  public static final BLonTraneAlarmMessage dehumidSensorFailure = new BLonTraneAlarmMessage(DEHUMID_SENSOR_FAILURE);
  /** BLonTraneAlarmMessage constant for dehumidSetpointFailure. */
  public static final BLonTraneAlarmMessage dehumidSetpointFailure = new BLonTraneAlarmMessage(DEHUMID_SETPOINT_FAILURE);
  /** BLonTraneAlarmMessage constant for outdoorAirCFMSensorFail. */
  public static final BLonTraneAlarmMessage outdoorAirCFMSensorFail = new BLonTraneAlarmMessage(OUTDOOR_AIR_CFMSENSOR_FAIL);
  /** BLonTraneAlarmMessage constant for outdoorAirCFMSetptFail. */
  public static final BLonTraneAlarmMessage outdoorAirCFMSetptFail = new BLonTraneAlarmMessage(OUTDOOR_AIR_CFMSETPT_FAIL);
  /** BLonTraneAlarmMessage constant for spacePressureSetptFail. */
  public static final BLonTraneAlarmMessage spacePressureSetptFail = new BLonTraneAlarmMessage(SPACE_PRESSURE_SETPT_FAIL);
  /** BLonTraneAlarmMessage constant for spacePressureSensorFail. */
  public static final BLonTraneAlarmMessage spacePressureSensorFail = new BLonTraneAlarmMessage(SPACE_PRESSURE_SENSOR_FAIL);
  /** BLonTraneAlarmMessage constant for heatingHighTempLimitOpen. */
  public static final BLonTraneAlarmMessage heatingHighTempLimitOpen = new BLonTraneAlarmMessage(HEATING_HIGH_TEMP_LIMIT_OPEN);
  /** BLonTraneAlarmMessage constant for noFlameSensedOnHeatCall. */
  public static final BLonTraneAlarmMessage noFlameSensedOnHeatCall = new BLonTraneAlarmMessage(NO_FLAME_SENSED_ON_HEAT_CALL);
  /** BLonTraneAlarmMessage constant for flameSensedWithGasValveOff. */
  public static final BLonTraneAlarmMessage flameSensedWithGasValveOff = new BLonTraneAlarmMessage(FLAME_SENSED_WITH_GAS_VALVE_OFF);
  /** BLonTraneAlarmMessage constant for gasHeatModuleFailure. */
  public static final BLonTraneAlarmMessage gasHeatModuleFailure = new BLonTraneAlarmMessage(GAS_HEAT_MODULE_FAILURE);
  /** BLonTraneAlarmMessage constant for economizerActuatorFault. */
  public static final BLonTraneAlarmMessage economizerActuatorFault = new BLonTraneAlarmMessage(ECONOMIZER_ACTUATOR_FAULT);
  /** BLonTraneAlarmMessage constant for mWUSetPointFailure. */
  public static final BLonTraneAlarmMessage mWUSetPointFailure = new BLonTraneAlarmMessage(M_WUSET_POINT_FAILURE);
  /** BLonTraneAlarmMessage constant for sAResetAmountFailure. */
  public static final BLonTraneAlarmMessage sAResetAmountFailure = new BLonTraneAlarmMessage(S_ARESET_AMOUNT_FAILURE);
  /** BLonTraneAlarmMessage constant for sACoolingSetPointFailure. */
  public static final BLonTraneAlarmMessage sACoolingSetPointFailure = new BLonTraneAlarmMessage(S_ACOOLING_SET_POINT_FAILURE);
  /** BLonTraneAlarmMessage constant for sAResetSetPointFailure. */
  public static final BLonTraneAlarmMessage sAResetSetPointFailure = new BLonTraneAlarmMessage(S_ARESET_SET_POINT_FAILURE);
  /** BLonTraneAlarmMessage constant for sAPressureSetPointFailure. */
  public static final BLonTraneAlarmMessage sAPressureSetPointFailure = new BLonTraneAlarmMessage(S_APRESSURE_SET_POINT_FAILURE);
  /** BLonTraneAlarmMessage constant for sAPressureDeadBandFailure. */
  public static final BLonTraneAlarmMessage sAPressureDeadBandFailure = new BLonTraneAlarmMessage(S_APRESSURE_DEAD_BAND_FAILURE);
  /** BLonTraneAlarmMessage constant for sAPressureSensorFailure. */
  public static final BLonTraneAlarmMessage sAPressureSensorFailure = new BLonTraneAlarmMessage(S_APRESSURE_SENSOR_FAILURE);
  /** BLonTraneAlarmMessage constant for sADuctPressureLimitFault. */
  public static final BLonTraneAlarmMessage sADuctPressureLimitFault = new BLonTraneAlarmMessage(S_ADUCT_PRESSURE_LIMIT_FAULT);
  /** BLonTraneAlarmMessage constant for sAPressurePWMFault. */
  public static final BLonTraneAlarmMessage sAPressurePWMFault = new BLonTraneAlarmMessage(S_APRESSURE_PWMFAULT);
  /** BLonTraneAlarmMessage constant for comp1DisableInputHPC. */
  public static final BLonTraneAlarmMessage comp1DisableInputHPC = new BLonTraneAlarmMessage(COMP_1DISABLE_INPUT_HPC);
  /** BLonTraneAlarmMessage constant for comp2DisableInputHPC. */
  public static final BLonTraneAlarmMessage comp2DisableInputHPC = new BLonTraneAlarmMessage(COMP_2DISABLE_INPUT_HPC);
  /** BLonTraneAlarmMessage constant for normal. */
  public static final BLonTraneAlarmMessage normal = new BLonTraneAlarmMessage(NORMAL);

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLonTraneAlarmMessage.class);
  
  /** Factory method with ordinal. */
  public static BLonTraneAlarmMessage make(int ordinal)
  {
    return (BLonTraneAlarmMessage)maintenanceRequired.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BLonTraneAlarmMessage make(String tag)
  {
    return (BLonTraneAlarmMessage)maintenanceRequired.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BLonTraneAlarmMessage(int ordinal)
  {
    super(ordinal);
  }
  
  public static final int DEFAULT = NORMAL;

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  static final Lexicon lex = Lexicon.make(BLonTraneAlarmMessage.class);

}
