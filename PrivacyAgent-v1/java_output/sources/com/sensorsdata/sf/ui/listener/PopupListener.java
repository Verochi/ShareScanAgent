package com.sensorsdata.sf.ui.listener;

/* loaded from: classes19.dex */
public interface PopupListener {
    void onPopupClick(java.lang.String str, com.sensorsdata.sf.ui.view.SensorsFocusActionModel sensorsFocusActionModel);

    void onPopupClose(java.lang.String str);

    void onPopupLoadFailed(java.lang.String str, int i, java.lang.String str2);

    void onPopupLoadSuccess(java.lang.String str);
}
