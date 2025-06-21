package com.sensorsdata.analytics.android.autotrack.aop;

/* loaded from: classes19.dex */
public class SensorsDataAutoTrackHelper {
    private static final java.lang.String TAG = "SA.SensorsDataAutoTrackHelper";

    /* renamed from: com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$tabName;

        public AnonymousClass1(java.lang.String str) {
            this.val$tabName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackTabHost(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), this.val$tabName);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.view.MenuItem val$menuItem;
        final /* synthetic */ java.lang.Object val$object;

        public AnonymousClass2(java.lang.Object obj, android.view.MenuItem menuItem) {
            this.val$object = obj;
            this.val$menuItem = menuItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackMenuItem(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), this.val$object, this.val$menuItem);
        }
    }

    public static void track(java.lang.String str, java.lang.String str2) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.track(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), str, str2);
    }

    public static void trackDialog(android.content.DialogInterface dialogInterface, int i) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackDialog(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), dialogInterface, i);
    }

    public static void trackDrawerClosed(android.view.View view) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackDrawerClosed(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), view);
    }

    public static void trackDrawerOpened(android.view.View view) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackDrawerOpened(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), view);
    }

    public static void trackExpandableListViewOnChildClick(android.widget.ExpandableListView expandableListView, android.view.View view, int i, int i2) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackExpandableListViewOnChildClick(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), expandableListView, view, i, i2);
    }

    public static void trackExpandableListViewOnGroupClick(android.widget.ExpandableListView expandableListView, android.view.View view, int i) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackExpandableListViewOnGroupClick(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), expandableListView, view, i);
    }

    public static void trackListView(android.widget.AdapterView<?> adapterView, android.view.View view, int i) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackListView(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), adapterView, view, i);
    }

    public static void trackMenuItem(android.view.MenuItem menuItem) {
        trackMenuItem(null, menuItem);
    }

    public static void trackMenuItem(java.lang.Object obj, android.view.MenuItem menuItem) {
        try {
            com.sensorsdata.analytics.android.sdk.util.ThreadUtils.getSinglePool().execute(new com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.AnonymousClass2(obj, menuItem));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void trackRN(java.lang.Object obj, int i, int i2, boolean z) {
    }

    public static void trackRadioGroup(android.widget.RadioGroup radioGroup, int i) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackRadioGroup(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), radioGroup, i);
    }

    public static void trackTabHost(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.util.ThreadUtils.getSinglePool().execute(new com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.AnonymousClass1(str));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void trackTabLayoutSelected(java.lang.Object obj, java.lang.Object obj2) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackTabLayoutSelected(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), obj, obj2);
    }

    public static void trackViewOnClick(android.view.View view) {
        if (view == null) {
            return;
        }
        trackViewOnClick(view, view.isPressed());
    }

    public static void trackViewOnClick(android.view.View view, boolean z) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackViewOnClick(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(), view, z);
    }
}
