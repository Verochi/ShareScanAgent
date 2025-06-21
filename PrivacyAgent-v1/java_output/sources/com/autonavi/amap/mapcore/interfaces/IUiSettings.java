package com.autonavi.amap.mapcore.interfaces;

/* loaded from: classes12.dex */
public interface IUiSettings {
    float getLogoMarginRate(int i) throws android.os.RemoteException;

    int getLogoPosition() throws android.os.RemoteException;

    int getZoomPosition() throws android.os.RemoteException;

    boolean isCompassEnabled() throws android.os.RemoteException;

    boolean isGestureScaleByMapCenter() throws android.os.RemoteException;

    boolean isIndoorSwitchEnabled() throws android.os.RemoteException;

    boolean isLogoEnable();

    boolean isMyLocationButtonEnabled() throws android.os.RemoteException;

    boolean isRotateGesturesEnabled() throws android.os.RemoteException;

    boolean isScaleControlsEnabled() throws android.os.RemoteException;

    boolean isScrollGesturesEnabled() throws android.os.RemoteException;

    boolean isTiltGesturesEnabled() throws android.os.RemoteException;

    boolean isZoomControlsEnabled() throws android.os.RemoteException;

    boolean isZoomGesturesEnabled() throws android.os.RemoteException;

    boolean isZoomInByScreenCenter() throws android.os.RemoteException;

    void requestRefreshLogo();

    void setAllGesturesEnabled(boolean z) throws android.os.RemoteException;

    void setCompassEnabled(boolean z) throws android.os.RemoteException;

    void setGestureScaleByMapCenter(boolean z) throws android.os.RemoteException;

    void setIndoorSwitchEnabled(boolean z) throws android.os.RemoteException;

    void setLogoBottomMargin(int i) throws android.os.RemoteException;

    void setLogoEnable(boolean z);

    void setLogoLeftMargin(int i) throws android.os.RemoteException;

    void setLogoMarginRate(int i, float f) throws android.os.RemoteException;

    void setLogoPosition(int i) throws android.os.RemoteException;

    void setMyLocationButtonEnabled(boolean z) throws android.os.RemoteException;

    void setRotateGesturesEnabled(boolean z) throws android.os.RemoteException;

    void setScaleControlsEnabled(boolean z) throws android.os.RemoteException;

    void setScrollGesturesEnabled(boolean z) throws android.os.RemoteException;

    void setTiltGesturesEnabled(boolean z) throws android.os.RemoteException;

    void setZoomControlsEnabled(boolean z) throws android.os.RemoteException;

    void setZoomGesturesEnabled(boolean z) throws android.os.RemoteException;

    void setZoomInByScreenCenter(boolean z) throws android.os.RemoteException;

    void setZoomPosition(int i) throws android.os.RemoteException;
}
