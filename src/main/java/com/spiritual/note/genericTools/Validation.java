package com.spiritual.note.genericTools;

public class Validation {

    public static boolean validateText(String var_text)
    {
        if(var_text==null) return false;
        if (var_text.equals("")) return false;
        if(var_text.equals("0"))return false;
        return true;
    }
}
