package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class CrossOverlay {
    public static final int UPDATE_TYPE_DATA = 0;
    com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay a;

    public interface GenerateCrossImageListener {
        void onGenerateComplete(android.graphics.Bitmap bitmap, int i);
    }

    public interface OnCrossVectorUpdateListener {
        void onUpdate(int i, com.amap.api.maps.model.CrossOverlay.UpdateItem updateItem);
    }

    public static class UpdateItem {
        public int dataUpdateFlag = -1;
    }

    public CrossOverlay(com.amap.api.maps.model.CrossOverlayOptions crossOverlayOptions, com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay iCrossVectorOverlay) {
        this.a = iCrossVectorOverlay;
    }

    public void remove() {
        com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay iCrossVectorOverlay = this.a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.remove();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setAttribute(com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr aVectorCrossAttr) {
        try {
            this.a.setAttribute(aVectorCrossAttr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public int setData(byte[] bArr) {
        com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay iCrossVectorOverlay;
        if (bArr == null || (iCrossVectorOverlay = this.a) == null) {
            return 0;
        }
        try {
            iCrossVectorOverlay.setData(bArr);
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setGenerateCrossImageListener(com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay iCrossVectorOverlay = this.a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setGenerateCrossImageListener(generateCrossImageListener);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setImageMode(boolean z) {
        com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay iCrossVectorOverlay = this.a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setImageMode(z);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setOnCrossVectorUpdateListener(com.amap.api.maps.model.CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay iCrossVectorOverlay = this.a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setOnCrossVectorUpdateListener(onCrossVectorUpdateListener);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setVisible(boolean z) {
        com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay iCrossVectorOverlay = this.a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setVisible(z);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
