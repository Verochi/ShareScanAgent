package com.sensorsdata.sf.ui.utils;

/* loaded from: classes19.dex */
public class ActionHelper {
    private static final java.lang.String TAG = "SActionHelper";

    public static void copyToClip(android.content.Context context, java.lang.String str) {
        try {
            ((android.content.ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(android.content.ClipData.newPlainText(TAG, str));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}
