package com.trane.util;

import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.workbench.BWbEditor;
import javax.baja.workbench.CannotSaveException;
import javax.baja.workbench.popup.BIPopupEditor;

public abstract class BAlarmSetupView
    extends BWbEditor
    implements BIPopupEditor
{

////////////////////////////////////////////////////////////////
//Constructor
////////////////////////////////////////////////////////////////

 public BAlarmSetupView()
     throws CannotSaveException, Exception
 {
//   BGridPane box = new BGridPane(1);
//   box.add(null, cb);
//
//   setContent(box);
//
//linkTo(cb, BCheckBox.actionPerformed, setModified);
//
// }
//////////////////////////////////////////////////////////////////
////Static
//////////////////////////////////////////////////////////////////
//
//private static Lexicon lex = Lexicon.make("workbench");
//
//private static String text(String s)
//{
//  return lex.getText(s);
}

// private BCheckBox cb = new BCheckBox(text("Enabled"));
  public Type getType(){  return TYPE; }

  public static final Type TYPE = Sys.loadType(BAlarmSetupView.class);
}
