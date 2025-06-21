package com.autonavi.amap.mapcore.interfaces;

/* loaded from: classes12.dex */
public interface ICrossVectorOverlay {
    void remove();

    void setAttribute(com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr aVectorCrossAttr);

    int setData(byte[] bArr);

    void setGenerateCrossImageListener(com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener generateCrossImageListener);

    void setImageMode(boolean z);

    void setOnCrossVectorUpdateListener(com.amap.api.maps.model.CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener);

    void setVisible(boolean z);
}
