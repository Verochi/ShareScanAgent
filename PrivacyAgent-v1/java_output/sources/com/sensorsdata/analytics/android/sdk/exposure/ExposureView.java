package com.sensorsdata.analytics.android.sdk.exposure;

/* loaded from: classes19.dex */
public class ExposureView implements java.lang.Cloneable {
    private boolean exposed;
    private com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData exposureData;
    private boolean isActivityChange;
    private boolean isViewLayoutChange;
    private boolean lastVisible;
    private java.lang.ref.WeakReference<android.view.View> viewWeakReference;
    private boolean isAddExposureView = false;
    private final long addTime = java.lang.System.nanoTime();

    public ExposureView(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData, boolean z, boolean z2, android.view.View view) {
        this.exposureData = sAExposureData;
        this.lastVisible = z;
        this.exposed = z2;
        this.viewWeakReference = new java.lang.ref.WeakReference<>(view);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.sensorsdata.analytics.android.sdk.exposure.ExposureView m95clone() throws java.lang.CloneNotSupportedException {
        return (com.sensorsdata.analytics.android.sdk.exposure.ExposureView) super.clone();
    }

    public long getAddTime() {
        return this.addTime;
    }

    public com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData getExposureData() {
        return this.exposureData;
    }

    public android.view.View getView() {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.viewWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean isActivityChange() {
        return this.isActivityChange;
    }

    public boolean isAddExposureView() {
        return this.isAddExposureView;
    }

    public boolean isExposed() {
        return this.exposed;
    }

    public boolean isLastVisible() {
        return this.lastVisible;
    }

    public boolean isViewLayoutChange() {
        return this.isViewLayoutChange;
    }

    public void setActivityChange(boolean z) {
        this.isActivityChange = z;
    }

    public void setAddExposureView(boolean z) {
        this.isAddExposureView = z;
    }

    public void setExposed(boolean z) {
        this.exposed = z;
    }

    public void setExposureData(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData) {
        this.exposureData = sAExposureData;
    }

    public void setLastVisible(boolean z) {
        this.lastVisible = z;
    }

    public void setView(android.view.View view) {
        this.viewWeakReference = new java.lang.ref.WeakReference<>(view);
    }

    public void setViewLayoutChange(boolean z) {
        this.isViewLayoutChange = z;
    }

    public java.lang.String toString() {
        return "ExposureView{exposureData=" + this.exposureData + ", lastVisible=" + this.lastVisible + ", exposed=" + this.exposed + ", viewWeakReference=" + this.viewWeakReference.get() + ",isAddExposureView=" + this.isAddExposureView + ",isViewLayoutChange=" + this.isViewLayoutChange + '}';
    }
}
