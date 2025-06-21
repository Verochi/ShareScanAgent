package com.sensorsdata.analytics.android.autotrack.core.autotrack;

/* loaded from: classes19.dex */
public interface SAFragmentLifecycleCallbacks {
    void onCreate(java.lang.Object obj);

    void onHiddenChanged(java.lang.Object obj, boolean z);

    void onPause(java.lang.Object obj);

    void onResume(java.lang.Object obj);

    void onStart(java.lang.Object obj);

    void onStop(java.lang.Object obj);

    void onViewCreated(java.lang.Object obj, android.view.View view, android.os.Bundle bundle);

    void setUserVisibleHint(java.lang.Object obj, boolean z);
}
