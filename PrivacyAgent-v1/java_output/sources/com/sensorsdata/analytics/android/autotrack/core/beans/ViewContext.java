package com.sensorsdata.analytics.android.autotrack.core.beans;

/* loaded from: classes19.dex */
public class ViewContext {
    public android.app.Activity activity;
    public java.lang.Object fragment;
    public android.view.View view;

    public ViewContext(android.app.Activity activity, java.lang.Object obj) {
        this.activity = activity;
        this.fragment = obj;
    }

    public ViewContext(android.app.Activity activity, java.lang.Object obj, android.view.View view) {
        this.activity = activity;
        this.fragment = obj;
        this.view = view;
    }

    public ViewContext(android.view.View view) {
        this.view = view;
    }
}
