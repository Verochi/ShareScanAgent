package com.autonavi.base.ae.gmap.gloverlay;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class CrossVectorOverlay extends com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay<com.autonavi.base.ae.gmap.gloverlay.GLCrossVector, java.lang.Object> implements com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay {
    com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr attr;
    private com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener imageListener;
    private boolean isImageMode;
    private com.amap.api.maps.model.CrossOverlay.OnCrossVectorUpdateListener updateListener;

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay crossVectorOverlay = com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this;
            crossVectorOverlay.mGLOverlay = new com.autonavi.base.ae.gmap.gloverlay.GLCrossVector(crossVectorOverlay.mEngineID, crossVectorOverlay.mMapView, hashCode());
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Bitmap val$bitmap;

        public AnonymousClass2(android.graphics.Bitmap bitmap) {
            this.val$bitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.addOverlayTexture(this.val$bitmap, 12345, 4);
            ((com.autonavi.base.ae.gmap.gloverlay.GLCrossVector) com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.mGLOverlay).setArrowResId(false, 12345);
            ((com.autonavi.base.ae.gmap.gloverlay.GLCrossVector) com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.mGLOverlay).setCarResId(12345);
            com.amap.api.maps.model.BitmapDescriptor fromAsset = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("cross/crossing_nigth_bk.data");
            com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.addOverlayTexture(fromAsset != null ? fromAsset.getBitmap() : null, 54321, 0);
            ((com.autonavi.base.ae.gmap.gloverlay.GLCrossVector) com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.mGLOverlay).setBackgroundResId(54321);
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ boolean val$visible;

        public AnonymousClass3(boolean z) {
            this.val$visible = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t = com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.mGLOverlay;
            if (t != 0) {
                ((com.autonavi.base.ae.gmap.gloverlay.GLCrossVector) t).setVisible(this.val$visible);
            }
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ byte[] val$data;

        public AnonymousClass4(byte[] bArr) {
            this.val$data = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay crossVectorOverlay = com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this;
            crossVectorOverlay.initImageMode(crossVectorOverlay.isImageMode);
            com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay crossVectorOverlay2 = com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this;
            com.autonavi.base.ae.gmap.gloverlay.GLCrossVector gLCrossVector = (com.autonavi.base.ae.gmap.gloverlay.GLCrossVector) crossVectorOverlay2.mGLOverlay;
            com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr aVectorCrossAttr = crossVectorOverlay2.attr;
            byte[] bArr = this.val$data;
            int addVectorItem = gLCrossVector.addVectorItem(aVectorCrossAttr, bArr, bArr.length);
            if (addVectorItem != 0) {
                com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.drawVectorFailed(addVectorItem);
            } else if (com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.updateListener != null) {
                com.amap.api.maps.model.CrossOverlay.UpdateItem updateItem = new com.amap.api.maps.model.CrossOverlay.UpdateItem();
                updateItem.dataUpdateFlag = addVectorItem;
                com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.updateListener.onUpdate(0, updateItem);
            }
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.this.releaseInstance();
        }
    }

    public CrossVectorOverlay(int i, android.content.Context context, com.autonavi.amap.mapcore.interfaces.IAMap iAMap) {
        super(i, context, iAMap);
        this.isImageMode = false;
        this.attr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawVectorFailed(int i) {
        com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener generateCrossImageListener;
        if (this.isImageMode && (generateCrossImageListener = this.imageListener) != null) {
            generateCrossImageListener.onGenerateComplete(null, i);
        }
        if (this.updateListener != null) {
            com.amap.api.maps.model.CrossOverlay.UpdateItem updateItem = new com.amap.api.maps.model.CrossOverlay.UpdateItem();
            updateItem.dataUpdateFlag = i;
            this.updateListener.onUpdate(0, updateItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initImageMode(boolean z) {
        T t = this.mGLOverlay;
        if (t != 0) {
            ((com.autonavi.base.ae.gmap.gloverlay.GLCrossVector) t).initTextureCallback(this, z);
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void addItem(java.lang.Object obj) {
    }

    public void addOverlayTexture(android.graphics.Bitmap bitmap, int i, int i2) {
        com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty gLTextureProperty = new com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty();
        gLTextureProperty.mId = i;
        gLTextureProperty.mAnchor = i2;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        this.mMapView.addOverlayTexture(this.mEngineID, gLTextureProperty);
    }

    public int dipToPixel(android.content.Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) android.util.TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void imageContentResult(int[] iArr, int i, int i2) {
        if (iArr == null) {
            drawVectorFailed(-1);
        } else if (this.imageListener != null) {
            android.graphics.Bitmap a = com.amap.api.mapcore.util.dl.a(iArr, i, i2);
            this.imageListener.onGenerateComplete(a, a != null ? 0 : -1);
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void iniGLOverlay() {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.AnonymousClass1());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void remove() {
        this.imageListener = null;
        setVisible(false);
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.AnonymousClass5());
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void resumeMarker(android.graphics.Bitmap bitmap) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.AnonymousClass2(bitmap));
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setAttribute(com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr aVectorCrossAttr) {
        this.attr = aVectorCrossAttr;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public int setData(byte[] bArr) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate;
        if (this.attr == null) {
            com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr aVectorCrossAttr = new com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr();
            this.attr = aVectorCrossAttr;
            aVectorCrossAttr.stAreaRect = new android.graphics.Rect(0, 0, this.mMapView.getMapWidth(), (this.mMapView.getMapHeight() * 4) / 11);
            this.attr.stAreaColor = android.graphics.Color.argb(217, 95, 95, 95);
            this.attr.fArrowBorderWidth = dipToPixel(this.mContext, 22);
            this.attr.stArrowBorderColor = android.graphics.Color.argb(0, 0, 50, 20);
            this.attr.fArrowLineWidth = dipToPixel(this.mContext, 18);
            this.attr.stArrowLineColor = android.graphics.Color.argb(255, 255, com.igexin.push.config.c.E, 65);
            this.attr.dayMode = false;
        }
        if (bArr == null || this.attr == null || (iAMapDelegate = this.mMapView) == null) {
            return -1;
        }
        iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.AnonymousClass4(bArr));
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setGenerateCrossImageListener(com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        this.imageListener = generateCrossImageListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setImageMode(boolean z) {
        this.isImageMode = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setOnCrossVectorUpdateListener(com.amap.api.maps.model.CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        this.updateListener = onCrossVectorUpdateListener;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay, com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setVisible(boolean z) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.AnonymousClass3(z));
        }
    }
}
