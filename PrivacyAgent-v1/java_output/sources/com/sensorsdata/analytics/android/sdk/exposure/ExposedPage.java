package com.sensorsdata.analytics.android.sdk.exposure;

/* loaded from: classes19.dex */
public class ExposedPage {
    private static final java.lang.String TAG = "SA.ExposedPage";
    private final java.util.WeakHashMap<android.view.View, com.sensorsdata.analytics.android.sdk.exposure.ExposureView> mViewWeakHashMap = new java.util.WeakHashMap<>();
    private final java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.exposure.ExposureView> mExposureViewMap = new java.util.HashMap();
    private final com.sensorsdata.analytics.android.sdk.exposure.ExposureVisible mExposureVisible = new com.sensorsdata.analytics.android.sdk.exposure.ExposureVisible();

    /* renamed from: com.sensorsdata.analytics.android.sdk.exposure.ExposedPage$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.sensorsdata.analytics.android.sdk.exposure.ExposureView> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView, com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView2) {
            return (int) (exposureView.getAddTime() - exposureView2.getAddTime());
        }
    }

    private boolean isExposed(com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
        boolean isLastVisible = exposureView.isLastVisible();
        android.view.View view = exposureView.getView();
        if (view == null) {
            return false;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        if (this.mExposureVisible.isVisible(view, rect)) {
            return !isLastVisible && visibleRect(view, rect, exposureView.getExposureData().getExposureConfig().getAreaRate());
        }
        exposureView.setLastVisible(false);
        return false;
    }

    private boolean viewIsExposed(com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
        com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData exposureData;
        com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig exposureConfig;
        if (exposureView != null && (exposureData = exposureView.getExposureData()) != null && (exposureConfig = exposureData.getExposureConfig()) != null && exposureView.isAddExposureView()) {
            boolean isRepeated = exposureConfig.isRepeated();
            boolean isExposed = isExposed(exposureView);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "viewIsExposed:" + isExposed);
            if (isRepeated) {
                if (isExposed) {
                    return true;
                }
            } else if (isExposed && (!exposureView.isExposed() || exposureView.isActivityChange())) {
                return true;
            }
        }
        return false;
    }

    private boolean visibleRect(android.view.View view, android.graphics.Rect rect, float f) {
        if (view == null) {
            return false;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "width = " + rect.width() + ", height = " + rect.height() + ", MeasuredHeight = " + view.getMeasuredHeight() + ", MeasuredWidth = " + view.getMeasuredWidth());
        return ((float) (rect.width() * rect.height())) >= ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * f;
    }

    public synchronized void addExposureView(android.view.View view, com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
        if (view == null || exposureView == null) {
            return;
        }
        this.mViewWeakHashMap.put(view, exposureView);
    }

    public synchronized void addExposureView(java.lang.String str, com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
        if (!android.text.TextUtils.isEmpty(str) && exposureView != null) {
            this.mExposureViewMap.put(str, exposureView);
        }
    }

    public synchronized com.sensorsdata.analytics.android.sdk.exposure.ExposureView getExposureView(android.view.View view) {
        if (view == null) {
            return null;
        }
        return this.mViewWeakHashMap.get(view);
    }

    public synchronized com.sensorsdata.analytics.android.sdk.exposure.ExposureView getExposureView(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mExposureViewMap.get(str);
    }

    public synchronized java.util.List<com.sensorsdata.analytics.android.sdk.exposure.ExposureView> getExposureViewList(android.view.View view) {
        java.util.ArrayList arrayList;
        this.mExposureVisible.cleanVisible();
        arrayList = new java.util.ArrayList();
        if (view != null) {
            arrayList.add(this.mViewWeakHashMap.get(view));
        } else {
            for (android.view.View view2 : this.mViewWeakHashMap.keySet()) {
                if (view2 != null) {
                    com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView = this.mViewWeakHashMap.get(view2);
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "getExposureViewList->exposureview:" + exposureView);
                    if (viewIsExposed(exposureView)) {
                        arrayList.add(exposureView);
                    }
                }
            }
            this.mExposureVisible.cleanVisible();
            java.util.Collections.sort(arrayList, new com.sensorsdata.analytics.android.sdk.exposure.ExposedPage.AnonymousClass1());
        }
        return arrayList;
    }

    public int getExposureViewSize() {
        return this.mViewWeakHashMap.size();
    }

    public java.util.Collection<com.sensorsdata.analytics.android.sdk.exposure.ExposureView> getExposureViews() {
        return this.mViewWeakHashMap.values();
    }

    public synchronized void invisibleElement() {
        com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView;
        for (android.view.View view : this.mViewWeakHashMap.keySet()) {
            if (view != null && (exposureView = this.mViewWeakHashMap.get(view)) != null) {
                exposureView.setLastVisible(false);
            }
        }
    }

    public synchronized void removeExposureView(android.view.View view, java.lang.String str) {
        if (view == null) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView = getExposureView(view);
        if (exposureView != null && exposureView.getExposureData() != null) {
            if (exposureView.getExposureData().getIdentifier() == null || str == null) {
                if (exposureView.getExposureData().getIdentifier() == null && str == null) {
                    this.mViewWeakHashMap.remove(view);
                }
            } else if (exposureView.getExposureData().getIdentifier().equals(str)) {
                this.mViewWeakHashMap.remove(view);
                this.mExposureViewMap.remove(str);
            }
        }
    }
}
