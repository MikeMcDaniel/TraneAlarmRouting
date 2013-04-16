/**
 * Copyright 2013 - All Rights Reserved.
 */
package com.trane.util;

import javax.baja.lonworks.enums.BLonHvacEnum;
import javax.baja.lonworks.enums.BLonOccupancyEnum;
import javax.baja.lonworks.enums.BLonStateEnum;
import javax.baja.naming.BOrd;
import javax.baja.status.BStatusEnum;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.sys.Action;
import javax.baja.sys.BAbsTime;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BDynamicEnum;
import javax.baja.sys.BEnumRange;
import javax.baja.sys.BFacets;
import javax.baja.sys.BString;
import javax.baja.sys.Clock;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.units.UnitDatabase;
import javax.baja.util.BFormat;

import com.trane.enums.BLonTraneAlarmMessage;
import com.tridium.report.BEmailRecipient;
import com.vykon.vykonPro.report.BVykonProReportSource;

/**
 * - BAlarmMessageToTIS takes an input from nvoAlarmMessage and provides and formatted email output
 * to TIS services. There are customizable features to select which alarms will be accepted, the
 * outgoing email address, and ability to select different alarm enumerations.
 * 
 * @author Mike McDaniel
 * @creation Mar 28, 2013
 * 
 */
public class BAlarmMessageToTIS
    extends BEmailRecipient
{
  /*-
  class BAlarmMessageToTIS
  {
    properties
    {
     alarmMessage:  String
       flags { readonly, summary }
       default {[ "No Alarms Present" ]}
     storeName:  String
       flags { summary }
       default {[ "No Store Name" ]}
     unitName:  String
       flags { summary }
       default {[ "No Unit Name" ]} 
     alarmNames: BStatusEnum
       flags { summary, hidden, readonly }
       default {[ new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonTraneAlarmMessage.TYPE))) ]}
       slotfacets {[ BFacets.makeEnum(BEnumRange.make(BLonTraneAlarmMessage.TYPE)) ]}
     effectiveOccupancy: BStatusEnum
       flags { summary }
       default {[ new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonOccupancyEnum.TYPE))) ]}
       slotfacets {[ BFacets.makeEnum(BEnumRange.make(BLonOccupancyEnum.TYPE)) ]}
     effectiveSetpoint:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7) ]}
     mode:  BStatusEnum
       flags { summary }
       default {[ new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonHvacEnum.TYPE))) ]}
       slotfacets {[ BFacets.makeEnum(BEnumRange.make(BLonHvacEnum.TYPE)) ]}
     spaceTemp:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7) ]}
     dischargeAirTemp:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7) ]}
     spaceRH:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100) ]}
     coolingOutput:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100) ]}
     heatingPrimaryOutput:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100) ]}
     heatingSecondaryOutput:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100) ]}
     fanOutput:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100) ]}
     fanStatus: BStatusEnum
       flags { summary }
       default {[ new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonStateEnum.TYPE))) ]}
       slotfacets {[ BFacets.makeEnum(BEnumRange.make(BLonStateEnum.TYPE)) ]}
     outdoorAirDamperPosition:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100) ]}
     outdoorAirTemp:  BStatusNumeric
       flags { summary }
       default {[ new BStatusNumeric() ]}
       slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7) ]}
     normalState: boolean
       flags { summary }
       default {[ false ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     maintenanceRequired: boolean
       default {[ false ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     spaceTempSensorFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     outdoorTempSensorFail: boolean
       default {[ true ]} 
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     compressor1HPCLockout: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     compressor1LPCLockout: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     comp1DisableInputLPC: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     compressor2HPCLockout: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     compressor2LPCLockout: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     comp2DisableInputLPC: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     smokeDetector: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     heatFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}
     dirtyFilter: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}     
     supplyFanFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     emergencyStopInput: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     froStatTrip: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     unitCommFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     mixedAirTempSensorFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     oARelHumidityFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     rATempSensorFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     rARelHumidityFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     ventOverridePurge: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     ventOverrideExhaust: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     ventOverridePressurize: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     externalAutoStop: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     freezeStatTripped: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     dischargeTempSensorFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     cO2SensorFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     cO2SetpointFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     dehumidSensorFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     dehumidSetpointFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     outdoorAirCFMSensorFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     outdoorAirCFMSetptFail: boolean
       default {[ true ]}
      slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     spacePressureSetptFail: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     spacePressureSensorFail: boolean
      default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     heatingHighTempLimitOpen: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     noFlameSensedOnHeatCall: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     flameSensedWithGasValveOff: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     gasHeatModuleFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     economizerActuatorFault: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     mWUSetPointFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sAResetAmountFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sACoolingSetPointFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sAResetSetPointFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sAPressureSetPointFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sAPressureDeadBandFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sAPressureSensorFailure: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sADuctPressureLimitFault: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     sAPressurePWMFault: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     comp1DisableInputHPC: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]} 
     comp2DisableInputHPC: boolean
       default {[ true ]}
       slotfacets {[ BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE"))]}

    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
    
    actions
    {
     getAlarm(sys: BStatusString)
       flags { summary }
       default {[ new BStatusString() ]}      
    }
    
    topics
    {
    }
  }
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.trane.util.BAlarmMessageToTIS(3728322795)1.0$ @*/
/* Generated Mon Apr 15 23:05:12 CDT 2013 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "alarmMessage"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmMessage</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getAlarmMessage
   * @see com.trane.util.BAlarmMessageToTIS#setAlarmMessage
   */
  public static final Property alarmMessage = newProperty(Flags.READONLY|Flags.SUMMARY, "No Alarms Present",null);
  
  /**
   * Get the <code>alarmMessage</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#alarmMessage
   */
  public String getAlarmMessage() { return getString(alarmMessage); }
  
  /**
   * Set the <code>alarmMessage</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#alarmMessage
   */
  public void setAlarmMessage(String v) { setString(alarmMessage,v,null); }

////////////////////////////////////////////////////////////////
// Property "storeName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>storeName</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getStoreName
   * @see com.trane.util.BAlarmMessageToTIS#setStoreName
   */
  public static final Property storeName = newProperty(Flags.SUMMARY, "No Store Name",null);
  
  /**
   * Get the <code>storeName</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#storeName
   */
  public String getStoreName() { return getString(storeName); }
  
  /**
   * Set the <code>storeName</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#storeName
   */
  public void setStoreName(String v) { setString(storeName,v,null); }

////////////////////////////////////////////////////////////////
// Property "unitName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>unitName</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getUnitName
   * @see com.trane.util.BAlarmMessageToTIS#setUnitName
   */
  public static final Property unitName = newProperty(Flags.SUMMARY, "No Unit Name",null);
  
  /**
   * Get the <code>unitName</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#unitName
   */
  public String getUnitName() { return getString(unitName); }
  
  /**
   * Set the <code>unitName</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#unitName
   */
  public void setUnitName(String v) { setString(unitName,v,null); }

////////////////////////////////////////////////////////////////
// Property "alarmNames"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmNames</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getAlarmNames
   * @see com.trane.util.BAlarmMessageToTIS#setAlarmNames
   */
  public static final Property alarmNames = newProperty(Flags.SUMMARY|Flags.HIDDEN|Flags.READONLY, new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonTraneAlarmMessage.TYPE))),BFacets.makeEnum(BEnumRange.make(BLonTraneAlarmMessage.TYPE)));
  
  /**
   * Get the <code>alarmNames</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#alarmNames
   */
  public BStatusEnum getAlarmNames() { return (BStatusEnum)get(alarmNames); }
  
  /**
   * Set the <code>alarmNames</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#alarmNames
   */
  public void setAlarmNames(BStatusEnum v) { set(alarmNames,v,null); }

////////////////////////////////////////////////////////////////
// Property "effectiveOccupancy"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>effectiveOccupancy</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getEffectiveOccupancy
   * @see com.trane.util.BAlarmMessageToTIS#setEffectiveOccupancy
   */
  public static final Property effectiveOccupancy = newProperty(Flags.SUMMARY, new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonOccupancyEnum.TYPE))),BFacets.makeEnum(BEnumRange.make(BLonOccupancyEnum.TYPE)));
  
  /**
   * Get the <code>effectiveOccupancy</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#effectiveOccupancy
   */
  public BStatusEnum getEffectiveOccupancy() { return (BStatusEnum)get(effectiveOccupancy); }
  
  /**
   * Set the <code>effectiveOccupancy</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#effectiveOccupancy
   */
  public void setEffectiveOccupancy(BStatusEnum v) { set(effectiveOccupancy,v,null); }

////////////////////////////////////////////////////////////////
// Property "effectiveSetpoint"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>effectiveSetpoint</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getEffectiveSetpoint
   * @see com.trane.util.BAlarmMessageToTIS#setEffectiveSetpoint
   */
  public static final Property effectiveSetpoint = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7));
  
  /**
   * Get the <code>effectiveSetpoint</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#effectiveSetpoint
   */
  public BStatusNumeric getEffectiveSetpoint() { return (BStatusNumeric)get(effectiveSetpoint); }
  
  /**
   * Set the <code>effectiveSetpoint</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#effectiveSetpoint
   */
  public void setEffectiveSetpoint(BStatusNumeric v) { set(effectiveSetpoint,v,null); }

////////////////////////////////////////////////////////////////
// Property "mode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>mode</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getMode
   * @see com.trane.util.BAlarmMessageToTIS#setMode
   */
  public static final Property mode = newProperty(Flags.SUMMARY, new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonHvacEnum.TYPE))),BFacets.makeEnum(BEnumRange.make(BLonHvacEnum.TYPE)));
  
  /**
   * Get the <code>mode</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#mode
   */
  public BStatusEnum getMode() { return (BStatusEnum)get(mode); }
  
  /**
   * Set the <code>mode</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#mode
   */
  public void setMode(BStatusEnum v) { set(mode,v,null); }

////////////////////////////////////////////////////////////////
// Property "spaceTemp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>spaceTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSpaceTemp
   * @see com.trane.util.BAlarmMessageToTIS#setSpaceTemp
   */
  public static final Property spaceTemp = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7));
  
  /**
   * Get the <code>spaceTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spaceTemp
   */
  public BStatusNumeric getSpaceTemp() { return (BStatusNumeric)get(spaceTemp); }
  
  /**
   * Set the <code>spaceTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spaceTemp
   */
  public void setSpaceTemp(BStatusNumeric v) { set(spaceTemp,v,null); }

////////////////////////////////////////////////////////////////
// Property "dischargeAirTemp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>dischargeAirTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getDischargeAirTemp
   * @see com.trane.util.BAlarmMessageToTIS#setDischargeAirTemp
   */
  public static final Property dischargeAirTemp = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7));
  
  /**
   * Get the <code>dischargeAirTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dischargeAirTemp
   */
  public BStatusNumeric getDischargeAirTemp() { return (BStatusNumeric)get(dischargeAirTemp); }
  
  /**
   * Set the <code>dischargeAirTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dischargeAirTemp
   */
  public void setDischargeAirTemp(BStatusNumeric v) { set(dischargeAirTemp,v,null); }

////////////////////////////////////////////////////////////////
// Property "spaceRH"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>spaceRH</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSpaceRH
   * @see com.trane.util.BAlarmMessageToTIS#setSpaceRH
   */
  public static final Property spaceRH = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100));
  
  /**
   * Get the <code>spaceRH</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spaceRH
   */
  public BStatusNumeric getSpaceRH() { return (BStatusNumeric)get(spaceRH); }
  
  /**
   * Set the <code>spaceRH</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spaceRH
   */
  public void setSpaceRH(BStatusNumeric v) { set(spaceRH,v,null); }

////////////////////////////////////////////////////////////////
// Property "coolingOutput"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>coolingOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getCoolingOutput
   * @see com.trane.util.BAlarmMessageToTIS#setCoolingOutput
   */
  public static final Property coolingOutput = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100));
  
  /**
   * Get the <code>coolingOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#coolingOutput
   */
  public BStatusNumeric getCoolingOutput() { return (BStatusNumeric)get(coolingOutput); }
  
  /**
   * Set the <code>coolingOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#coolingOutput
   */
  public void setCoolingOutput(BStatusNumeric v) { set(coolingOutput,v,null); }

////////////////////////////////////////////////////////////////
// Property "heatingPrimaryOutput"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>heatingPrimaryOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getHeatingPrimaryOutput
   * @see com.trane.util.BAlarmMessageToTIS#setHeatingPrimaryOutput
   */
  public static final Property heatingPrimaryOutput = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100));
  
  /**
   * Get the <code>heatingPrimaryOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatingPrimaryOutput
   */
  public BStatusNumeric getHeatingPrimaryOutput() { return (BStatusNumeric)get(heatingPrimaryOutput); }
  
  /**
   * Set the <code>heatingPrimaryOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatingPrimaryOutput
   */
  public void setHeatingPrimaryOutput(BStatusNumeric v) { set(heatingPrimaryOutput,v,null); }

////////////////////////////////////////////////////////////////
// Property "heatingSecondaryOutput"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>heatingSecondaryOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getHeatingSecondaryOutput
   * @see com.trane.util.BAlarmMessageToTIS#setHeatingSecondaryOutput
   */
  public static final Property heatingSecondaryOutput = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100));
  
  /**
   * Get the <code>heatingSecondaryOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatingSecondaryOutput
   */
  public BStatusNumeric getHeatingSecondaryOutput() { return (BStatusNumeric)get(heatingSecondaryOutput); }
  
  /**
   * Set the <code>heatingSecondaryOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatingSecondaryOutput
   */
  public void setHeatingSecondaryOutput(BStatusNumeric v) { set(heatingSecondaryOutput,v,null); }

////////////////////////////////////////////////////////////////
// Property "fanOutput"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>fanOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getFanOutput
   * @see com.trane.util.BAlarmMessageToTIS#setFanOutput
   */
  public static final Property fanOutput = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100));
  
  /**
   * Get the <code>fanOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#fanOutput
   */
  public BStatusNumeric getFanOutput() { return (BStatusNumeric)get(fanOutput); }
  
  /**
   * Set the <code>fanOutput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#fanOutput
   */
  public void setFanOutput(BStatusNumeric v) { set(fanOutput,v,null); }

////////////////////////////////////////////////////////////////
// Property "fanStatus"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>fanStatus</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getFanStatus
   * @see com.trane.util.BAlarmMessageToTIS#setFanStatus
   */
  public static final Property fanStatus = newProperty(Flags.SUMMARY, new BStatusEnum(BDynamicEnum.make(2, BEnumRange.make(BLonStateEnum.TYPE))),BFacets.makeEnum(BEnumRange.make(BLonStateEnum.TYPE)));
  
  /**
   * Get the <code>fanStatus</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#fanStatus
   */
  public BStatusEnum getFanStatus() { return (BStatusEnum)get(fanStatus); }
  
  /**
   * Set the <code>fanStatus</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#fanStatus
   */
  public void setFanStatus(BStatusEnum v) { set(fanStatus,v,null); }

////////////////////////////////////////////////////////////////
// Property "outdoorAirDamperPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outdoorAirDamperPosition</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getOutdoorAirDamperPosition
   * @see com.trane.util.BAlarmMessageToTIS#setOutdoorAirDamperPosition
   */
  public static final Property outdoorAirDamperPosition = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0, 0, 100));
  
  /**
   * Get the <code>outdoorAirDamperPosition</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirDamperPosition
   */
  public BStatusNumeric getOutdoorAirDamperPosition() { return (BStatusNumeric)get(outdoorAirDamperPosition); }
  
  /**
   * Set the <code>outdoorAirDamperPosition</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirDamperPosition
   */
  public void setOutdoorAirDamperPosition(BStatusNumeric v) { set(outdoorAirDamperPosition,v,null); }

////////////////////////////////////////////////////////////////
// Property "outdoorAirTemp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outdoorAirTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getOutdoorAirTemp
   * @see com.trane.util.BAlarmMessageToTIS#setOutdoorAirTemp
   */
  public static final Property outdoorAirTemp = newProperty(Flags.SUMMARY, new BStatusNumeric(),BFacets.makeNumeric(UnitDatabase.getUnit("fahrenheit"), 1, 273.2, 327.7));
  
  /**
   * Get the <code>outdoorAirTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirTemp
   */
  public BStatusNumeric getOutdoorAirTemp() { return (BStatusNumeric)get(outdoorAirTemp); }
  
  /**
   * Set the <code>outdoorAirTemp</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirTemp
   */
  public void setOutdoorAirTemp(BStatusNumeric v) { set(outdoorAirTemp,v,null); }

////////////////////////////////////////////////////////////////
// Property "normalState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>normalState</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getNormalState
   * @see com.trane.util.BAlarmMessageToTIS#setNormalState
   */
  public static final Property normalState = newProperty(Flags.SUMMARY, false,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>normalState</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#normalState
   */
  public boolean getNormalState() { return getBoolean(normalState); }
  
  /**
   * Set the <code>normalState</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#normalState
   */
  public void setNormalState(boolean v) { setBoolean(normalState,v,null); }

////////////////////////////////////////////////////////////////
// Property "maintenanceRequired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>maintenanceRequired</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getMaintenanceRequired
   * @see com.trane.util.BAlarmMessageToTIS#setMaintenanceRequired
   */
  public static final Property maintenanceRequired = newProperty(0, false,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>maintenanceRequired</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#maintenanceRequired
   */
  public boolean getMaintenanceRequired() { return getBoolean(maintenanceRequired); }
  
  /**
   * Set the <code>maintenanceRequired</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#maintenanceRequired
   */
  public void setMaintenanceRequired(boolean v) { setBoolean(maintenanceRequired,v,null); }

////////////////////////////////////////////////////////////////
// Property "spaceTempSensorFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>spaceTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSpaceTempSensorFail
   * @see com.trane.util.BAlarmMessageToTIS#setSpaceTempSensorFail
   */
  public static final Property spaceTempSensorFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>spaceTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spaceTempSensorFail
   */
  public boolean getSpaceTempSensorFail() { return getBoolean(spaceTempSensorFail); }
  
  /**
   * Set the <code>spaceTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spaceTempSensorFail
   */
  public void setSpaceTempSensorFail(boolean v) { setBoolean(spaceTempSensorFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "outdoorTempSensorFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outdoorTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getOutdoorTempSensorFail
   * @see com.trane.util.BAlarmMessageToTIS#setOutdoorTempSensorFail
   */
  public static final Property outdoorTempSensorFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>outdoorTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorTempSensorFail
   */
  public boolean getOutdoorTempSensorFail() { return getBoolean(outdoorTempSensorFail); }
  
  /**
   * Set the <code>outdoorTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorTempSensorFail
   */
  public void setOutdoorTempSensorFail(boolean v) { setBoolean(outdoorTempSensorFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "compressor1HPCLockout"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>compressor1HPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getCompressor1HPCLockout
   * @see com.trane.util.BAlarmMessageToTIS#setCompressor1HPCLockout
   */
  public static final Property compressor1HPCLockout = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>compressor1HPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor1HPCLockout
   */
  public boolean getCompressor1HPCLockout() { return getBoolean(compressor1HPCLockout); }
  
  /**
   * Set the <code>compressor1HPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor1HPCLockout
   */
  public void setCompressor1HPCLockout(boolean v) { setBoolean(compressor1HPCLockout,v,null); }

////////////////////////////////////////////////////////////////
// Property "compressor1LPCLockout"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>compressor1LPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getCompressor1LPCLockout
   * @see com.trane.util.BAlarmMessageToTIS#setCompressor1LPCLockout
   */
  public static final Property compressor1LPCLockout = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>compressor1LPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor1LPCLockout
   */
  public boolean getCompressor1LPCLockout() { return getBoolean(compressor1LPCLockout); }
  
  /**
   * Set the <code>compressor1LPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor1LPCLockout
   */
  public void setCompressor1LPCLockout(boolean v) { setBoolean(compressor1LPCLockout,v,null); }

////////////////////////////////////////////////////////////////
// Property "comp1DisableInputLPC"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>comp1DisableInputLPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getComp1DisableInputLPC
   * @see com.trane.util.BAlarmMessageToTIS#setComp1DisableInputLPC
   */
  public static final Property comp1DisableInputLPC = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>comp1DisableInputLPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp1DisableInputLPC
   */
  public boolean getComp1DisableInputLPC() { return getBoolean(comp1DisableInputLPC); }
  
  /**
   * Set the <code>comp1DisableInputLPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp1DisableInputLPC
   */
  public void setComp1DisableInputLPC(boolean v) { setBoolean(comp1DisableInputLPC,v,null); }

////////////////////////////////////////////////////////////////
// Property "compressor2HPCLockout"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>compressor2HPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getCompressor2HPCLockout
   * @see com.trane.util.BAlarmMessageToTIS#setCompressor2HPCLockout
   */
  public static final Property compressor2HPCLockout = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>compressor2HPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor2HPCLockout
   */
  public boolean getCompressor2HPCLockout() { return getBoolean(compressor2HPCLockout); }
  
  /**
   * Set the <code>compressor2HPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor2HPCLockout
   */
  public void setCompressor2HPCLockout(boolean v) { setBoolean(compressor2HPCLockout,v,null); }

////////////////////////////////////////////////////////////////
// Property "compressor2LPCLockout"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>compressor2LPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getCompressor2LPCLockout
   * @see com.trane.util.BAlarmMessageToTIS#setCompressor2LPCLockout
   */
  public static final Property compressor2LPCLockout = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>compressor2LPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor2LPCLockout
   */
  public boolean getCompressor2LPCLockout() { return getBoolean(compressor2LPCLockout); }
  
  /**
   * Set the <code>compressor2LPCLockout</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#compressor2LPCLockout
   */
  public void setCompressor2LPCLockout(boolean v) { setBoolean(compressor2LPCLockout,v,null); }

////////////////////////////////////////////////////////////////
// Property "comp2DisableInputLPC"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>comp2DisableInputLPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getComp2DisableInputLPC
   * @see com.trane.util.BAlarmMessageToTIS#setComp2DisableInputLPC
   */
  public static final Property comp2DisableInputLPC = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>comp2DisableInputLPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp2DisableInputLPC
   */
  public boolean getComp2DisableInputLPC() { return getBoolean(comp2DisableInputLPC); }
  
  /**
   * Set the <code>comp2DisableInputLPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp2DisableInputLPC
   */
  public void setComp2DisableInputLPC(boolean v) { setBoolean(comp2DisableInputLPC,v,null); }

////////////////////////////////////////////////////////////////
// Property "smokeDetector"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>smokeDetector</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSmokeDetector
   * @see com.trane.util.BAlarmMessageToTIS#setSmokeDetector
   */
  public static final Property smokeDetector = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>smokeDetector</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#smokeDetector
   */
  public boolean getSmokeDetector() { return getBoolean(smokeDetector); }
  
  /**
   * Set the <code>smokeDetector</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#smokeDetector
   */
  public void setSmokeDetector(boolean v) { setBoolean(smokeDetector,v,null); }

////////////////////////////////////////////////////////////////
// Property "heatFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>heatFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getHeatFail
   * @see com.trane.util.BAlarmMessageToTIS#setHeatFail
   */
  public static final Property heatFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>heatFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatFail
   */
  public boolean getHeatFail() { return getBoolean(heatFail); }
  
  /**
   * Set the <code>heatFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatFail
   */
  public void setHeatFail(boolean v) { setBoolean(heatFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "dirtyFilter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>dirtyFilter</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getDirtyFilter
   * @see com.trane.util.BAlarmMessageToTIS#setDirtyFilter
   */
  public static final Property dirtyFilter = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>dirtyFilter</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dirtyFilter
   */
  public boolean getDirtyFilter() { return getBoolean(dirtyFilter); }
  
  /**
   * Set the <code>dirtyFilter</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dirtyFilter
   */
  public void setDirtyFilter(boolean v) { setBoolean(dirtyFilter,v,null); }

////////////////////////////////////////////////////////////////
// Property "supplyFanFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>supplyFanFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSupplyFanFail
   * @see com.trane.util.BAlarmMessageToTIS#setSupplyFanFail
   */
  public static final Property supplyFanFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>supplyFanFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#supplyFanFail
   */
  public boolean getSupplyFanFail() { return getBoolean(supplyFanFail); }
  
  /**
   * Set the <code>supplyFanFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#supplyFanFail
   */
  public void setSupplyFanFail(boolean v) { setBoolean(supplyFanFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "emergencyStopInput"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>emergencyStopInput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getEmergencyStopInput
   * @see com.trane.util.BAlarmMessageToTIS#setEmergencyStopInput
   */
  public static final Property emergencyStopInput = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>emergencyStopInput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#emergencyStopInput
   */
  public boolean getEmergencyStopInput() { return getBoolean(emergencyStopInput); }
  
  /**
   * Set the <code>emergencyStopInput</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#emergencyStopInput
   */
  public void setEmergencyStopInput(boolean v) { setBoolean(emergencyStopInput,v,null); }

////////////////////////////////////////////////////////////////
// Property "froStatTrip"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>froStatTrip</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getFroStatTrip
   * @see com.trane.util.BAlarmMessageToTIS#setFroStatTrip
   */
  public static final Property froStatTrip = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>froStatTrip</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#froStatTrip
   */
  public boolean getFroStatTrip() { return getBoolean(froStatTrip); }
  
  /**
   * Set the <code>froStatTrip</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#froStatTrip
   */
  public void setFroStatTrip(boolean v) { setBoolean(froStatTrip,v,null); }

////////////////////////////////////////////////////////////////
// Property "unitCommFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>unitCommFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getUnitCommFail
   * @see com.trane.util.BAlarmMessageToTIS#setUnitCommFail
   */
  public static final Property unitCommFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>unitCommFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#unitCommFail
   */
  public boolean getUnitCommFail() { return getBoolean(unitCommFail); }
  
  /**
   * Set the <code>unitCommFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#unitCommFail
   */
  public void setUnitCommFail(boolean v) { setBoolean(unitCommFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "mixedAirTempSensorFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>mixedAirTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getMixedAirTempSensorFail
   * @see com.trane.util.BAlarmMessageToTIS#setMixedAirTempSensorFail
   */
  public static final Property mixedAirTempSensorFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>mixedAirTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#mixedAirTempSensorFail
   */
  public boolean getMixedAirTempSensorFail() { return getBoolean(mixedAirTempSensorFail); }
  
  /**
   * Set the <code>mixedAirTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#mixedAirTempSensorFail
   */
  public void setMixedAirTempSensorFail(boolean v) { setBoolean(mixedAirTempSensorFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "oARelHumidityFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>oARelHumidityFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getOARelHumidityFail
   * @see com.trane.util.BAlarmMessageToTIS#setOARelHumidityFail
   */
  public static final Property oARelHumidityFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>oARelHumidityFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#oARelHumidityFail
   */
  public boolean getOARelHumidityFail() { return getBoolean(oARelHumidityFail); }
  
  /**
   * Set the <code>oARelHumidityFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#oARelHumidityFail
   */
  public void setOARelHumidityFail(boolean v) { setBoolean(oARelHumidityFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "rATempSensorFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>rATempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getRATempSensorFail
   * @see com.trane.util.BAlarmMessageToTIS#setRATempSensorFail
   */
  public static final Property rATempSensorFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>rATempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#rATempSensorFail
   */
  public boolean getRATempSensorFail() { return getBoolean(rATempSensorFail); }
  
  /**
   * Set the <code>rATempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#rATempSensorFail
   */
  public void setRATempSensorFail(boolean v) { setBoolean(rATempSensorFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "rARelHumidityFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>rARelHumidityFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getRARelHumidityFail
   * @see com.trane.util.BAlarmMessageToTIS#setRARelHumidityFail
   */
  public static final Property rARelHumidityFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>rARelHumidityFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#rARelHumidityFail
   */
  public boolean getRARelHumidityFail() { return getBoolean(rARelHumidityFail); }
  
  /**
   * Set the <code>rARelHumidityFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#rARelHumidityFail
   */
  public void setRARelHumidityFail(boolean v) { setBoolean(rARelHumidityFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "ventOverridePurge"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>ventOverridePurge</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getVentOverridePurge
   * @see com.trane.util.BAlarmMessageToTIS#setVentOverridePurge
   */
  public static final Property ventOverridePurge = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>ventOverridePurge</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#ventOverridePurge
   */
  public boolean getVentOverridePurge() { return getBoolean(ventOverridePurge); }
  
  /**
   * Set the <code>ventOverridePurge</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#ventOverridePurge
   */
  public void setVentOverridePurge(boolean v) { setBoolean(ventOverridePurge,v,null); }

////////////////////////////////////////////////////////////////
// Property "ventOverrideExhaust"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>ventOverrideExhaust</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getVentOverrideExhaust
   * @see com.trane.util.BAlarmMessageToTIS#setVentOverrideExhaust
   */
  public static final Property ventOverrideExhaust = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>ventOverrideExhaust</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#ventOverrideExhaust
   */
  public boolean getVentOverrideExhaust() { return getBoolean(ventOverrideExhaust); }
  
  /**
   * Set the <code>ventOverrideExhaust</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#ventOverrideExhaust
   */
  public void setVentOverrideExhaust(boolean v) { setBoolean(ventOverrideExhaust,v,null); }

////////////////////////////////////////////////////////////////
// Property "ventOverridePressurize"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>ventOverridePressurize</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getVentOverridePressurize
   * @see com.trane.util.BAlarmMessageToTIS#setVentOverridePressurize
   */
  public static final Property ventOverridePressurize = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>ventOverridePressurize</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#ventOverridePressurize
   */
  public boolean getVentOverridePressurize() { return getBoolean(ventOverridePressurize); }
  
  /**
   * Set the <code>ventOverridePressurize</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#ventOverridePressurize
   */
  public void setVentOverridePressurize(boolean v) { setBoolean(ventOverridePressurize,v,null); }

////////////////////////////////////////////////////////////////
// Property "externalAutoStop"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>externalAutoStop</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getExternalAutoStop
   * @see com.trane.util.BAlarmMessageToTIS#setExternalAutoStop
   */
  public static final Property externalAutoStop = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>externalAutoStop</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#externalAutoStop
   */
  public boolean getExternalAutoStop() { return getBoolean(externalAutoStop); }
  
  /**
   * Set the <code>externalAutoStop</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#externalAutoStop
   */
  public void setExternalAutoStop(boolean v) { setBoolean(externalAutoStop,v,null); }

////////////////////////////////////////////////////////////////
// Property "freezeStatTripped"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>freezeStatTripped</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getFreezeStatTripped
   * @see com.trane.util.BAlarmMessageToTIS#setFreezeStatTripped
   */
  public static final Property freezeStatTripped = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>freezeStatTripped</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#freezeStatTripped
   */
  public boolean getFreezeStatTripped() { return getBoolean(freezeStatTripped); }
  
  /**
   * Set the <code>freezeStatTripped</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#freezeStatTripped
   */
  public void setFreezeStatTripped(boolean v) { setBoolean(freezeStatTripped,v,null); }

////////////////////////////////////////////////////////////////
// Property "dischargeTempSensorFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>dischargeTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getDischargeTempSensorFail
   * @see com.trane.util.BAlarmMessageToTIS#setDischargeTempSensorFail
   */
  public static final Property dischargeTempSensorFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>dischargeTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dischargeTempSensorFail
   */
  public boolean getDischargeTempSensorFail() { return getBoolean(dischargeTempSensorFail); }
  
  /**
   * Set the <code>dischargeTempSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dischargeTempSensorFail
   */
  public void setDischargeTempSensorFail(boolean v) { setBoolean(dischargeTempSensorFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "cO2SensorFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cO2SensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getCO2SensorFailure
   * @see com.trane.util.BAlarmMessageToTIS#setCO2SensorFailure
   */
  public static final Property cO2SensorFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>cO2SensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#cO2SensorFailure
   */
  public boolean getCO2SensorFailure() { return getBoolean(cO2SensorFailure); }
  
  /**
   * Set the <code>cO2SensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#cO2SensorFailure
   */
  public void setCO2SensorFailure(boolean v) { setBoolean(cO2SensorFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "cO2SetpointFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cO2SetpointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getCO2SetpointFailure
   * @see com.trane.util.BAlarmMessageToTIS#setCO2SetpointFailure
   */
  public static final Property cO2SetpointFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>cO2SetpointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#cO2SetpointFailure
   */
  public boolean getCO2SetpointFailure() { return getBoolean(cO2SetpointFailure); }
  
  /**
   * Set the <code>cO2SetpointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#cO2SetpointFailure
   */
  public void setCO2SetpointFailure(boolean v) { setBoolean(cO2SetpointFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "dehumidSensorFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>dehumidSensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getDehumidSensorFailure
   * @see com.trane.util.BAlarmMessageToTIS#setDehumidSensorFailure
   */
  public static final Property dehumidSensorFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>dehumidSensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dehumidSensorFailure
   */
  public boolean getDehumidSensorFailure() { return getBoolean(dehumidSensorFailure); }
  
  /**
   * Set the <code>dehumidSensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dehumidSensorFailure
   */
  public void setDehumidSensorFailure(boolean v) { setBoolean(dehumidSensorFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "dehumidSetpointFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>dehumidSetpointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getDehumidSetpointFailure
   * @see com.trane.util.BAlarmMessageToTIS#setDehumidSetpointFailure
   */
  public static final Property dehumidSetpointFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>dehumidSetpointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dehumidSetpointFailure
   */
  public boolean getDehumidSetpointFailure() { return getBoolean(dehumidSetpointFailure); }
  
  /**
   * Set the <code>dehumidSetpointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#dehumidSetpointFailure
   */
  public void setDehumidSetpointFailure(boolean v) { setBoolean(dehumidSetpointFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "outdoorAirCFMSensorFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outdoorAirCFMSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getOutdoorAirCFMSensorFail
   * @see com.trane.util.BAlarmMessageToTIS#setOutdoorAirCFMSensorFail
   */
  public static final Property outdoorAirCFMSensorFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>outdoorAirCFMSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirCFMSensorFail
   */
  public boolean getOutdoorAirCFMSensorFail() { return getBoolean(outdoorAirCFMSensorFail); }
  
  /**
   * Set the <code>outdoorAirCFMSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirCFMSensorFail
   */
  public void setOutdoorAirCFMSensorFail(boolean v) { setBoolean(outdoorAirCFMSensorFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "outdoorAirCFMSetptFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outdoorAirCFMSetptFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getOutdoorAirCFMSetptFail
   * @see com.trane.util.BAlarmMessageToTIS#setOutdoorAirCFMSetptFail
   */
  public static final Property outdoorAirCFMSetptFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>outdoorAirCFMSetptFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirCFMSetptFail
   */
  public boolean getOutdoorAirCFMSetptFail() { return getBoolean(outdoorAirCFMSetptFail); }
  
  /**
   * Set the <code>outdoorAirCFMSetptFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#outdoorAirCFMSetptFail
   */
  public void setOutdoorAirCFMSetptFail(boolean v) { setBoolean(outdoorAirCFMSetptFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "spacePressureSetptFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>spacePressureSetptFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSpacePressureSetptFail
   * @see com.trane.util.BAlarmMessageToTIS#setSpacePressureSetptFail
   */
  public static final Property spacePressureSetptFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>spacePressureSetptFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spacePressureSetptFail
   */
  public boolean getSpacePressureSetptFail() { return getBoolean(spacePressureSetptFail); }
  
  /**
   * Set the <code>spacePressureSetptFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spacePressureSetptFail
   */
  public void setSpacePressureSetptFail(boolean v) { setBoolean(spacePressureSetptFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "spacePressureSensorFail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>spacePressureSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSpacePressureSensorFail
   * @see com.trane.util.BAlarmMessageToTIS#setSpacePressureSensorFail
   */
  public static final Property spacePressureSensorFail = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>spacePressureSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spacePressureSensorFail
   */
  public boolean getSpacePressureSensorFail() { return getBoolean(spacePressureSensorFail); }
  
  /**
   * Set the <code>spacePressureSensorFail</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#spacePressureSensorFail
   */
  public void setSpacePressureSensorFail(boolean v) { setBoolean(spacePressureSensorFail,v,null); }

////////////////////////////////////////////////////////////////
// Property "heatingHighTempLimitOpen"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>heatingHighTempLimitOpen</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getHeatingHighTempLimitOpen
   * @see com.trane.util.BAlarmMessageToTIS#setHeatingHighTempLimitOpen
   */
  public static final Property heatingHighTempLimitOpen = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>heatingHighTempLimitOpen</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatingHighTempLimitOpen
   */
  public boolean getHeatingHighTempLimitOpen() { return getBoolean(heatingHighTempLimitOpen); }
  
  /**
   * Set the <code>heatingHighTempLimitOpen</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#heatingHighTempLimitOpen
   */
  public void setHeatingHighTempLimitOpen(boolean v) { setBoolean(heatingHighTempLimitOpen,v,null); }

////////////////////////////////////////////////////////////////
// Property "noFlameSensedOnHeatCall"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>noFlameSensedOnHeatCall</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getNoFlameSensedOnHeatCall
   * @see com.trane.util.BAlarmMessageToTIS#setNoFlameSensedOnHeatCall
   */
  public static final Property noFlameSensedOnHeatCall = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>noFlameSensedOnHeatCall</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#noFlameSensedOnHeatCall
   */
  public boolean getNoFlameSensedOnHeatCall() { return getBoolean(noFlameSensedOnHeatCall); }
  
  /**
   * Set the <code>noFlameSensedOnHeatCall</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#noFlameSensedOnHeatCall
   */
  public void setNoFlameSensedOnHeatCall(boolean v) { setBoolean(noFlameSensedOnHeatCall,v,null); }

////////////////////////////////////////////////////////////////
// Property "flameSensedWithGasValveOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>flameSensedWithGasValveOff</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getFlameSensedWithGasValveOff
   * @see com.trane.util.BAlarmMessageToTIS#setFlameSensedWithGasValveOff
   */
  public static final Property flameSensedWithGasValveOff = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>flameSensedWithGasValveOff</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#flameSensedWithGasValveOff
   */
  public boolean getFlameSensedWithGasValveOff() { return getBoolean(flameSensedWithGasValveOff); }
  
  /**
   * Set the <code>flameSensedWithGasValveOff</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#flameSensedWithGasValveOff
   */
  public void setFlameSensedWithGasValveOff(boolean v) { setBoolean(flameSensedWithGasValveOff,v,null); }

////////////////////////////////////////////////////////////////
// Property "gasHeatModuleFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>gasHeatModuleFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getGasHeatModuleFailure
   * @see com.trane.util.BAlarmMessageToTIS#setGasHeatModuleFailure
   */
  public static final Property gasHeatModuleFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>gasHeatModuleFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#gasHeatModuleFailure
   */
  public boolean getGasHeatModuleFailure() { return getBoolean(gasHeatModuleFailure); }
  
  /**
   * Set the <code>gasHeatModuleFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#gasHeatModuleFailure
   */
  public void setGasHeatModuleFailure(boolean v) { setBoolean(gasHeatModuleFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "economizerActuatorFault"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>economizerActuatorFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getEconomizerActuatorFault
   * @see com.trane.util.BAlarmMessageToTIS#setEconomizerActuatorFault
   */
  public static final Property economizerActuatorFault = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>economizerActuatorFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#economizerActuatorFault
   */
  public boolean getEconomizerActuatorFault() { return getBoolean(economizerActuatorFault); }
  
  /**
   * Set the <code>economizerActuatorFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#economizerActuatorFault
   */
  public void setEconomizerActuatorFault(boolean v) { setBoolean(economizerActuatorFault,v,null); }

////////////////////////////////////////////////////////////////
// Property "mWUSetPointFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>mWUSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getMWUSetPointFailure
   * @see com.trane.util.BAlarmMessageToTIS#setMWUSetPointFailure
   */
  public static final Property mWUSetPointFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>mWUSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#mWUSetPointFailure
   */
  public boolean getMWUSetPointFailure() { return getBoolean(mWUSetPointFailure); }
  
  /**
   * Set the <code>mWUSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#mWUSetPointFailure
   */
  public void setMWUSetPointFailure(boolean v) { setBoolean(mWUSetPointFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "sAResetAmountFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sAResetAmountFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSAResetAmountFailure
   * @see com.trane.util.BAlarmMessageToTIS#setSAResetAmountFailure
   */
  public static final Property sAResetAmountFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sAResetAmountFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAResetAmountFailure
   */
  public boolean getSAResetAmountFailure() { return getBoolean(sAResetAmountFailure); }
  
  /**
   * Set the <code>sAResetAmountFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAResetAmountFailure
   */
  public void setSAResetAmountFailure(boolean v) { setBoolean(sAResetAmountFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "sACoolingSetPointFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sACoolingSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSACoolingSetPointFailure
   * @see com.trane.util.BAlarmMessageToTIS#setSACoolingSetPointFailure
   */
  public static final Property sACoolingSetPointFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sACoolingSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sACoolingSetPointFailure
   */
  public boolean getSACoolingSetPointFailure() { return getBoolean(sACoolingSetPointFailure); }
  
  /**
   * Set the <code>sACoolingSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sACoolingSetPointFailure
   */
  public void setSACoolingSetPointFailure(boolean v) { setBoolean(sACoolingSetPointFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "sAResetSetPointFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sAResetSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSAResetSetPointFailure
   * @see com.trane.util.BAlarmMessageToTIS#setSAResetSetPointFailure
   */
  public static final Property sAResetSetPointFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sAResetSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAResetSetPointFailure
   */
  public boolean getSAResetSetPointFailure() { return getBoolean(sAResetSetPointFailure); }
  
  /**
   * Set the <code>sAResetSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAResetSetPointFailure
   */
  public void setSAResetSetPointFailure(boolean v) { setBoolean(sAResetSetPointFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "sAPressureSetPointFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sAPressureSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSAPressureSetPointFailure
   * @see com.trane.util.BAlarmMessageToTIS#setSAPressureSetPointFailure
   */
  public static final Property sAPressureSetPointFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sAPressureSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressureSetPointFailure
   */
  public boolean getSAPressureSetPointFailure() { return getBoolean(sAPressureSetPointFailure); }
  
  /**
   * Set the <code>sAPressureSetPointFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressureSetPointFailure
   */
  public void setSAPressureSetPointFailure(boolean v) { setBoolean(sAPressureSetPointFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "sAPressureDeadBandFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sAPressureDeadBandFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSAPressureDeadBandFailure
   * @see com.trane.util.BAlarmMessageToTIS#setSAPressureDeadBandFailure
   */
  public static final Property sAPressureDeadBandFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sAPressureDeadBandFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressureDeadBandFailure
   */
  public boolean getSAPressureDeadBandFailure() { return getBoolean(sAPressureDeadBandFailure); }
  
  /**
   * Set the <code>sAPressureDeadBandFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressureDeadBandFailure
   */
  public void setSAPressureDeadBandFailure(boolean v) { setBoolean(sAPressureDeadBandFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "sAPressureSensorFailure"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sAPressureSensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSAPressureSensorFailure
   * @see com.trane.util.BAlarmMessageToTIS#setSAPressureSensorFailure
   */
  public static final Property sAPressureSensorFailure = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sAPressureSensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressureSensorFailure
   */
  public boolean getSAPressureSensorFailure() { return getBoolean(sAPressureSensorFailure); }
  
  /**
   * Set the <code>sAPressureSensorFailure</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressureSensorFailure
   */
  public void setSAPressureSensorFailure(boolean v) { setBoolean(sAPressureSensorFailure,v,null); }

////////////////////////////////////////////////////////////////
// Property "sADuctPressureLimitFault"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sADuctPressureLimitFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSADuctPressureLimitFault
   * @see com.trane.util.BAlarmMessageToTIS#setSADuctPressureLimitFault
   */
  public static final Property sADuctPressureLimitFault = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sADuctPressureLimitFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sADuctPressureLimitFault
   */
  public boolean getSADuctPressureLimitFault() { return getBoolean(sADuctPressureLimitFault); }
  
  /**
   * Set the <code>sADuctPressureLimitFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sADuctPressureLimitFault
   */
  public void setSADuctPressureLimitFault(boolean v) { setBoolean(sADuctPressureLimitFault,v,null); }

////////////////////////////////////////////////////////////////
// Property "sAPressurePWMFault"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sAPressurePWMFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getSAPressurePWMFault
   * @see com.trane.util.BAlarmMessageToTIS#setSAPressurePWMFault
   */
  public static final Property sAPressurePWMFault = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>sAPressurePWMFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressurePWMFault
   */
  public boolean getSAPressurePWMFault() { return getBoolean(sAPressurePWMFault); }
  
  /**
   * Set the <code>sAPressurePWMFault</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#sAPressurePWMFault
   */
  public void setSAPressurePWMFault(boolean v) { setBoolean(sAPressurePWMFault,v,null); }

////////////////////////////////////////////////////////////////
// Property "comp1DisableInputHPC"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>comp1DisableInputHPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getComp1DisableInputHPC
   * @see com.trane.util.BAlarmMessageToTIS#setComp1DisableInputHPC
   */
  public static final Property comp1DisableInputHPC = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>comp1DisableInputHPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp1DisableInputHPC
   */
  public boolean getComp1DisableInputHPC() { return getBoolean(comp1DisableInputHPC); }
  
  /**
   * Set the <code>comp1DisableInputHPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp1DisableInputHPC
   */
  public void setComp1DisableInputHPC(boolean v) { setBoolean(comp1DisableInputHPC,v,null); }

////////////////////////////////////////////////////////////////
// Property "comp2DisableInputHPC"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>comp2DisableInputHPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#getComp2DisableInputHPC
   * @see com.trane.util.BAlarmMessageToTIS#setComp2DisableInputHPC
   */
  public static final Property comp2DisableInputHPC = newProperty(0, true,BFacets.make(BFacets.TRUE_TEXT, BString.make("Enabled"), BFacets.FALSE_TEXT, BString.make("Disabled"), BFacets.FIELD_EDITOR, BString.make("traneAlarmRouting:CheckBoxFE")));
  
  /**
   * Get the <code>comp2DisableInputHPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp2DisableInputHPC
   */
  public boolean getComp2DisableInputHPC() { return getBoolean(comp2DisableInputHPC); }
  
  /**
   * Set the <code>comp2DisableInputHPC</code> property.
   * @see com.trane.util.BAlarmMessageToTIS#comp2DisableInputHPC
   */
  public void setComp2DisableInputHPC(boolean v) { setBoolean(comp2DisableInputHPC,v,null); }

////////////////////////////////////////////////////////////////
// Action "getAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>getAlarm</code> action.
   * @see com.trane.util.BAlarmMessageToTIS#getAlarm()
   */
  public static final Action getAlarm = newAction(Flags.SUMMARY,new BStatusString(),null);
  
  /**
   * Invoke the <code>getAlarm</code> action.
   * @see com.trane.util.BAlarmMessageToTIS#getAlarm
   */
  public void getAlarm(BStatusString sys) { invoke(getAlarm,sys,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAlarmMessageToTIS.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


// Set the email date to the current time and date
  public BAbsTime          currentTime = Clock.time();

  public boolean           sendEmail   = false;

  private void checkAlarms(String alarm, Context context)
  {
    setAlarmMessage(alarm);
    Property[] properties = null;
    properties = this.getPropertiesArray();
    for (int i = 0; i < properties.length; i++)
    {
      Property property = properties[i];
      String propertyName = this.getDisplayName(property, context);
      if (property.getType().is(BBoolean.TYPE))
      {
        if (getAlarmMessage().toString().equals(propertyName) && getBoolean((Property) property))
        {
          sendEmail = true;
          sendAlarmEmail();
        }

      }

    }
  }

  public final BEmailRecipient setUpEmail()
  {
    try
    {
      // Create a new email
      BEmailRecipient newMail = new BEmailRecipient();

      // Set the email subject
      this.setSubject(BFormat.make("Darden Group Alarm " + getStoreName().trim() + " at " +
          currentTime.toString()));

      // Format the body of the email
      String emailBody =
          "TNS ID = " + getStoreName().substring(0, 6) + "\r" +
              "Get file from tnscontrolssupport@trane.com email box\r" + 
              "Filename: " + getStoreName().substring(0, 6) + " at " + currentTime.getDay() + " " + currentTime.getMonth() + currentTime.getYear() + "\r" + 
              "\r" + 
              "Timestamp: " + currentTime.getDay() + " " + currentTime.getMonth() + " " + currentTime.getYear() + " - " + currentTime.getTime() + "\r" + 
              "\r" + 
              getStoreName() + "\r" + "Unit = " + getUnitName().toString() + "\r" + 
              "Alarm Message = " + getAlarmMessage().toString() + "\r" + 
              "Effective Occupancy = " + getEffectiveOccupancy().getValue() + "\r" +
              "Effective Setpoint = " + getEffectiveSetpoint().getValueValue() + " °F\r" +
              "Mode = " + getMode().getValue() + "\r" + 
              "Space Temp = " + getSpaceTemp().getValueValue() + " °F\r" + 
              "Discharge Air Temp = " + getDischargeAirTemp().getValueValue() + " °F\r" + 
              "Space RH = " + getSpaceRH().getValue() +  '%'+"RH\r" + 
              "Cooling Output = " + getCoolingOutput().getValue() + " %\r" + 
              "Heating Output Primary = " + getHeatingPrimaryOutput().getValue() + '%'+ "\r" + 
              "Heating Output Secondary = " + getHeatingSecondaryOutput().getValue() + '%'+ "\r" + 
              "Fan Output = " + getFanOutput().getValueValue().toString() + " %\r" + 
              "Fan Status = " + getFanStatus().getValue() + "\r" + 
              "Outdoor Air Damper Position = " + getOutdoorAirDamperPosition().getValue() + '%'+ "\r" + 
              "Outdoor Air Temp = " +  getOutdoorAirTemp().getValueValue() + " °F";

      getBody();
      this.setBody(BFormat.make(emailBody));
      System.out.println(emailBody);
      newMail = this;
      return newMail;
    }
    catch (Exception e)
    {
      System.out.println("Exception Error: " + e);
    }
    return null;
  }

// Get the nvoAlarmMessage
  public void doGetAlarm(BStatusString string)
  {
    if (isRunning() && Sys.atSteadyState())
    {
// Change the alarm message to a String value
      checkAlarms(string.getValue().toString(), null);
    }
  }

  // Create the report
  public void createReport()
  {
    try
    {
      setUpEmail();

      BOrd reportSource =
          BOrd.make("station:|" + this.getSlotPathOrd().getParent().toString() +
              "/VykonProReportSource");
      BVykonProReportSource report = (BVykonProReportSource) reportSource.resolve().get();
      report.setReportName(getStoreName().substring(0, 5) + " at " + currentTime.toString());
      report.generate();

    }

    catch (Exception e)
    {
      System.out.println(e);
    }

  }

  // Send the alarm email to TIS
  public void sendAlarmEmail()
  {
    if (sendEmail)
    {
      createReport();
      sendEmail = false;
    }
  }
}