package com.sensorsdata.analytics.android.autotrack.core.impl;

/* loaded from: classes19.dex */
public class FragmentAPI implements com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI {
    private static final java.lang.String TAG = "FragmentAPI";
    private java.util.Set<java.lang.Integer> mAutoTrackFragments;
    private java.util.Set<java.lang.Integer> mAutoTrackIgnoredFragments;
    private boolean mTrackFragmentAppViewScreen;

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragment(java.lang.Class<?> cls) {
        if (cls == null) {
            return;
        }
        try {
            if (this.mAutoTrackFragments == null) {
                this.mAutoTrackFragments = new java.util.concurrent.CopyOnWriteArraySet();
            }
            java.lang.String canonicalName = cls.getCanonicalName();
            if (android.text.TextUtils.isEmpty(canonicalName)) {
                return;
            }
            this.mAutoTrackFragments.add(java.lang.Integer.valueOf(canonicalName.hashCode()));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.mAutoTrackFragments == null) {
            this.mAutoTrackFragments = new java.util.concurrent.CopyOnWriteArraySet();
        }
        try {
            java.util.Iterator<java.lang.Class<?>> it = list.iterator();
            while (it.hasNext()) {
                java.lang.String canonicalName = it.next().getCanonicalName();
                if (!android.text.TextUtils.isEmpty(canonicalName)) {
                    this.mAutoTrackFragments.add(java.lang.Integer.valueOf(canonicalName.hashCode()));
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragment(java.lang.Class<?> cls) {
        if (cls == null) {
            return;
        }
        try {
            if (this.mAutoTrackIgnoredFragments == null) {
                this.mAutoTrackIgnoredFragments = new java.util.concurrent.CopyOnWriteArraySet();
            }
            java.lang.String canonicalName = cls.getCanonicalName();
            if (android.text.TextUtils.isEmpty(canonicalName)) {
                return;
            }
            this.mAutoTrackIgnoredFragments.add(java.lang.Integer.valueOf(canonicalName.hashCode()));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                if (this.mAutoTrackIgnoredFragments == null) {
                    this.mAutoTrackIgnoredFragments = new java.util.concurrent.CopyOnWriteArraySet();
                }
                for (java.lang.Class<?> cls : list) {
                    if (cls != null) {
                        java.lang.String canonicalName = cls.getCanonicalName();
                        if (!android.text.TextUtils.isEmpty(canonicalName)) {
                            this.mAutoTrackIgnoredFragments.add(java.lang.Integer.valueOf(canonicalName.hashCode()));
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isFragmentAutoTrackAppViewScreen(java.lang.Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN) && this.mTrackFragmentAppViewScreen) {
            java.util.Set<java.lang.Integer> set = this.mAutoTrackFragments;
            if (set != null && set.size() > 0) {
                java.lang.String canonicalName = cls.getCanonicalName();
                if (!android.text.TextUtils.isEmpty(canonicalName)) {
                    return this.mAutoTrackFragments.contains(java.lang.Integer.valueOf(canonicalName.hashCode()));
                }
            }
            if (cls.getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreen.class) != null || cls.getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
                return false;
            }
            java.util.Set<java.lang.Integer> set2 = this.mAutoTrackIgnoredFragments;
            if (set2 != null && set2.size() > 0) {
                if (!android.text.TextUtils.isEmpty(cls.getCanonicalName())) {
                    return !this.mAutoTrackIgnoredFragments.contains(java.lang.Integer.valueOf(r5.hashCode()));
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isTrackFragmentAppViewScreenEnabled() {
        return this.mTrackFragmentAppViewScreen;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragment(java.lang.Class<?> cls) {
        if (cls != null) {
            try {
                if (this.mAutoTrackIgnoredFragments == null) {
                    return;
                }
                java.lang.String canonicalName = cls.getCanonicalName();
                if (android.text.TextUtils.isEmpty(canonicalName)) {
                    return;
                }
                this.mAutoTrackIgnoredFragments.remove(java.lang.Integer.valueOf(canonicalName.hashCode()));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0 && this.mAutoTrackIgnoredFragments != null) {
                    for (java.lang.Class<?> cls : list) {
                        if (cls != null) {
                            java.lang.String canonicalName = cls.getCanonicalName();
                            if (!android.text.TextUtils.isEmpty(canonicalName)) {
                                this.mAutoTrackIgnoredFragments.remove(java.lang.Integer.valueOf(canonicalName.hashCode()));
                            }
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void trackFragmentAppViewScreen() {
        this.mTrackFragmentAppViewScreen = true;
    }
}
