package com.sensorsdata.analytics.android.sdk.core.mediator.autotrack;

/* loaded from: classes19.dex */
public interface IFragmentAPI {
    void enableAutoTrackFragment(java.lang.Class<?> cls);

    void enableAutoTrackFragments(java.util.List<java.lang.Class<?>> list);

    void ignoreAutoTrackFragment(java.lang.Class<?> cls);

    void ignoreAutoTrackFragments(java.util.List<java.lang.Class<?>> list);

    boolean isFragmentAutoTrackAppViewScreen(java.lang.Class<?> cls);

    boolean isTrackFragmentAppViewScreenEnabled();

    void resumeIgnoredAutoTrackFragment(java.lang.Class<?> cls);

    void resumeIgnoredAutoTrackFragments(java.util.List<java.lang.Class<?>> list);

    void trackFragmentAppViewScreen();
}
