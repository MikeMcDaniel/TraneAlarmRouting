/**
 * Copyright 2013 - All Rights Reserved.
 */
package com.trane.fieldEditors;

import javax.baja.sys.BBoolean;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.BCheckBox;
import javax.baja.ui.pane.BGridPane;
import javax.baja.util.Lexicon;
import javax.baja.workbench.CannotSaveException;
import javax.baja.workbench.fieldeditor.BWbFieldEditor;

/**
 * - Insert description here.
 * 
 * @author Mike McDaniel
 * @creation Mar 28, 2013
 * 
 */
public class BCheckBoxFE
    extends BWbFieldEditor
{

// //////////////////////////////////////////////////////////////
// BObject
// //////////////////////////////////////////////////////////////

  public Type getType()
  {
    return TYPE;
  }

  public static final Type TYPE = Sys.loadType(BCheckBoxFE.class);

// //////////////////////////////////////////////////////////////
// Constructor
// //////////////////////////////////////////////////////////////

  public BCheckBoxFE()
      throws CannotSaveException, Exception
  {
    BGridPane box = new BGridPane(1);
    box.add(null, cb);

    setContent(box);

 linkTo(cb, BCheckBox.actionPerformed, setModified);

  }

// //////////////////////////////////////////////////////////////
// actions
// //////////////////////////////////////////////////////////////

  /**
   * doUpdateBool
   */
  public void doUpdateBool()
  {
    BBoolean.make(saveBool().getBoolean());
  }

// //////////////////////////////////////////////////////////////
// BWbEditor
// //////////////////////////////////////////////////////////////

  /**
   * doSetReadonly
   */
  protected void doSetReadonly(boolean readonly)
  {

    cb.setEnabled(!readonly);

  }

  /**
   * doLoadValue
   */
  protected void doLoadValue(BObject value, Context cx) throws Exception
  {

    BBoolean bool = BBoolean.DEFAULT;
    if (value instanceof BBoolean) bool = (BBoolean) value;

    if (bool.getBoolean())
    {
      cb.setSelected(true);
      enable(true);
    }
    else
    {
      cb.setSelected(false);
      enable(true);
    }
//    cb.fireActionPerformed((BWidgetEvent) super.doSaveValue(value, cx));
  }

  /**
   * doSaveValue
   */
  protected BObject doSaveValue(BObject value, Context cx) throws Exception
  {
    BBoolean bool = saveBool();
    doUpdateBool();
    if (value instanceof BBoolean)
      return BBoolean.make(bool.getBoolean());
    else return bool;

  }

  /**
   * saveBool
   */
  private BBoolean saveBool()
  {

    boolean sel = false;
    if (cb.getSelected()) sel |= true;

    return BBoolean.make(sel);
  }

// //////////////////////////////////////////////////////////////
// private
// //////////////////////////////////////////////////////////////

  /**
   * enable
   */
  private void enable(boolean flag)
  {
    cb.setEnabled(true);
  }

  

// //////////////////////////////////////////////////////////////
// Static
// //////////////////////////////////////////////////////////////

  private static Lexicon lex = Lexicon.make("workbench");

  private static String text(String s)
  {
    return lex.getText(s);
  }

// //////////////////////////////////////////////////////////////
// Attributes
// //////////////////////////////////////////////////////////////

// private BCheckBox isNull = new BCheckBox(new Null());

  private BCheckBox cb = new BCheckBox(text("Enabled"));

// private BBoolean bool;

}