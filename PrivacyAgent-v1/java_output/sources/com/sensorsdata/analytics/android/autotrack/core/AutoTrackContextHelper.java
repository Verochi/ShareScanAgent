package com.sensorsdata.analytics.android.autotrack.core;

/* loaded from: classes19.dex */
public class AutoTrackContextHelper {
    private static final java.lang.String TAG = "AutoTrackContextHelper";
    private com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private final com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions mInternalConfigs;
    private final com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml mProtocolImp;
    private final com.sensorsdata.analytics.android.sdk.core.SAContextManager mSAContextManager;

    public AutoTrackContextHelper(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        this.mInternalConfigs = sAContextManager.getInternalConfigs();
        this.mProtocolImp = new com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml(sAContextManager);
        registerListener();
        sAContextManager.getPluginManager().registerPropertyPlugin(new com.sensorsdata.analytics.android.autotrack.core.plugins.AutoTrackEventPlugin());
        try {
            if (sAContextManager.getInternalConfigs().context instanceof android.app.Activity) {
                delayExecution((android.app.Activity) sAContextManager.getInternalConfigs().context);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void delayExecution(android.app.Activity activity) {
        com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.mActivityLifecycleCallbacks;
        if (activityLifecycleCallbacks != null) {
            activityLifecycleCallbacks.onActivityCreated(activity, null);
            this.mActivityLifecycleCallbacks.onDelayInitStarted(activity);
        }
        if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SDK init success by：" + activity.getClass().getName());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2041176285:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPVIEWSCREEN_IGNORED)) {
                    c = 0;
                    break;
                }
                break;
            case -1758337854:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_FRAGMENT_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case -1032848920:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPCLICK_IGNORED)) {
                    c = 2;
                    break;
                }
                break;
            case -879617324:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_DISABLE_AUTO_TRACK)) {
                    c = 3;
                    break;
                }
                break;
            case -855900378:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_LAST_SCREEN_TRACK_PROPERTIES)) {
                    c = 4;
                    break;
                }
                break;
            case -780627273:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITIES)) {
                    c = 5;
                    break;
                }
                break;
            case -632963972:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITIES)) {
                    c = 6;
                    break;
                }
                break;
            case -573253991:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_ENABLE_AUTO_TRACK)) {
                    c = 7;
                    break;
                }
                break;
            case -402423012:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN)) {
                    c = '\b';
                    break;
                }
                break;
            case -255560615:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITY)) {
                    c = '\t';
                    break;
                }
                break;
            case -249863270:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENT)) {
                    c = '\n';
                    break;
                }
                break;
            case 184800113:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_VIEW_TYPE)) {
                    c = 11;
                    break;
                }
                break;
            case 459453303:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_FRAGMENT_APPVIEWSCREEN)) {
                    c = '\f';
                    break;
                }
                break;
            case 492266615:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_REFERRER_SCREEN_TITLE)) {
                    c = '\r';
                    break;
                }
                break;
            case 529995791:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_AUTOTRACK_ENABLED)) {
                    c = 14;
                    break;
                }
                break;
            case 584755798:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_ACTIVITY)) {
                    c = 15;
                    break;
                }
                break;
            case 629903034:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_PROPERTIES)) {
                    c = 16;
                    break;
                }
                break;
            case 664765826:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_ID)) {
                    c = 17;
                    break;
                }
                break;
            case 669731678:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITY)) {
                    c = 18;
                    break;
                }
                break;
            case 722156336:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_FRAGMENT_AUTOTRACK_APPVIEWSCREEN)) {
                    c = 19;
                    break;
                }
                break;
            case 844173337:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENTS)) {
                    c = 20;
                    break;
                }
                break;
            case 880636823:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_VIEW)) {
                    c = 21;
                    break;
                }
                break;
            case 998210608:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_AUTOTRACK_EVENT_TYPE_IGNORED)) {
                    c = 22;
                    break;
                }
                break;
            case 1023570953:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENT)) {
                    c = 23;
                    break;
                }
                break;
            case 1371889303:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_VIEW_APPCLICK)) {
                    c = 24;
                    break;
                }
                break;
            case 1507882935:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_LAST_SCREENURL)) {
                    c = 25;
                    break;
                }
                break;
            case 1525033920:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_TRACK_FRAGMENT_APPVIEWSCREEN_ENABLED)) {
                    c = com.alibaba.fastjson.parser.JSONLexer.EOI;
                    break;
                }
                break;
            case 1546646393:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_IGNORED_VIEW_TYPE_LIST)) {
                    c = 27;
                    break;
                }
                break;
            case 1577777639:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENT)) {
                    c = 28;
                    break;
                }
                break;
            case 1665928586:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENTS)) {
                    c = 29;
                    break;
                }
                break;
            case 1666466668:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENTS)) {
                    c = 30;
                    break;
                }
                break;
            case 1886155136:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_CLEAR_REFERRER_WHEN_APPEND)) {
                    c = 31;
                    break;
                }
                break;
            case 2007472672:
                if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_CLEAR_LAST_SCREENURL)) {
                    c = ' ';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return (T) java.lang.Boolean.valueOf(this.mProtocolImp.isActivityAutoTrackAppViewScreenIgnored((java.lang.Class) objArr[0]));
            case 1:
                this.mProtocolImp.setViewFragmentName((android.view.View) objArr[0], (java.lang.String) objArr[1]);
                return null;
            case 2:
                return (T) java.lang.Boolean.valueOf(this.mProtocolImp.isActivityAutoTrackAppClickIgnored((java.lang.Class) objArr[0]));
            case 3:
                java.lang.Object obj = objArr[0];
                if (obj instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) {
                    this.mProtocolImp.disableAutoTrack((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) obj);
                    return null;
                }
                this.mProtocolImp.disableAutoTrack((java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType>) obj);
                return null;
            case 4:
                return (T) this.mProtocolImp.getLastScreenTrackProperties();
            case 5:
                this.mProtocolImp.ignoreAutoTrackActivities((java.util.List) objArr[0]);
                return null;
            case 6:
                this.mProtocolImp.resumeAutoTrackActivities((java.util.List) objArr[0]);
                return null;
            case 7:
                this.mProtocolImp.enableAutoTrack((java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType>) objArr[0]);
                return null;
            case '\b':
                if (objArr.length != 1) {
                    this.mProtocolImp.trackViewScreen((java.lang.String) objArr[0], (org.json.JSONObject) objArr[1]);
                    return null;
                }
                java.lang.Object obj2 = objArr[0];
                if (obj2 instanceof android.app.Activity) {
                    this.mProtocolImp.trackViewScreen((android.app.Activity) obj2);
                    return null;
                }
                this.mProtocolImp.trackViewScreen(obj2);
                return null;
            case '\t':
                this.mProtocolImp.ignoreAutoTrackActivity((java.lang.Class) objArr[0]);
                return null;
            case '\n':
                this.mProtocolImp.ignoreAutoTrackFragment((java.lang.Class) objArr[0]);
                return null;
            case 11:
                this.mProtocolImp.ignoreViewType((java.lang.Class) objArr[0]);
                return null;
            case '\f':
                this.mProtocolImp.trackFragmentAppViewScreen();
                return null;
            case '\r':
                return (T) com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrerTitle();
            case 14:
                return (T) java.lang.Boolean.valueOf(this.mProtocolImp.isAutoTrackEnabled());
            case 15:
                this.mProtocolImp.setViewActivity((android.view.View) objArr[0], (android.app.Activity) objArr[1]);
                return null;
            case 16:
                this.mProtocolImp.setViewProperties((android.view.View) objArr[0], (org.json.JSONObject) objArr[1]);
                return null;
            case 17:
                java.lang.Object obj3 = objArr[0];
                if (obj3 instanceof android.view.View) {
                    this.mProtocolImp.setViewID((android.view.View) obj3, (java.lang.String) objArr[1]);
                    return null;
                }
                if (obj3 instanceof android.app.Dialog) {
                    this.mProtocolImp.setViewID((android.app.Dialog) obj3, (java.lang.String) objArr[1]);
                    return null;
                }
                this.mProtocolImp.setViewID(obj3, (java.lang.String) objArr[1]);
                return null;
            case 18:
                this.mProtocolImp.resumeAutoTrackActivity((java.lang.Class) objArr[0]);
                return null;
            case 19:
                return (T) java.lang.Boolean.valueOf(this.mProtocolImp.isFragmentAutoTrackAppViewScreen((java.lang.Class) objArr[0]));
            case 20:
                this.mProtocolImp.ignoreAutoTrackFragments((java.util.List) objArr[0]);
                return null;
            case 21:
                if (objArr.length == 1) {
                    this.mProtocolImp.ignoreView((android.view.View) objArr[0]);
                    return null;
                }
                this.mProtocolImp.ignoreView((android.view.View) objArr[0], ((java.lang.Boolean) objArr[1]).booleanValue());
                return null;
            case 22:
                java.lang.Object obj4 = objArr[0];
                return obj4 instanceof java.lang.Integer ? (T) java.lang.Boolean.valueOf(this.mProtocolImp.isAutoTrackEventTypeIgnored(((java.lang.Integer) obj4).intValue())) : (T) java.lang.Boolean.valueOf(this.mProtocolImp.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) obj4));
            case 23:
                this.mProtocolImp.enableAutoTrackFragment((java.lang.Class) objArr[0]);
                return null;
            case 24:
                if (objArr.length == 1) {
                    this.mProtocolImp.trackViewAppClick((android.view.View) objArr[0]);
                    return null;
                }
                this.mProtocolImp.trackViewAppClick((android.view.View) objArr[0], (org.json.JSONObject) objArr[1]);
                return null;
            case 25:
                return (T) this.mProtocolImp.getLastScreenUrl();
            case 26:
                return (T) java.lang.Boolean.valueOf(this.mProtocolImp.isTrackFragmentAppViewScreenEnabled());
            case 27:
                return (T) this.mProtocolImp.getIgnoredViewTypeList();
            case 28:
                this.mProtocolImp.resumeIgnoredAutoTrackFragment((java.lang.Class) objArr[0]);
                return null;
            case 29:
                this.mProtocolImp.enableAutoTrackFragments((java.util.List) objArr[0]);
                return null;
            case 30:
                this.mProtocolImp.resumeIgnoredAutoTrackFragments((java.util.List) objArr[0]);
                return null;
            case 31:
                this.mProtocolImp.clearReferrerWhenAppEnd();
                return null;
            case ' ':
                this.mProtocolImp.clearLastScreenUrl();
                return null;
            default:
                return null;
        }
    }

    public void registerListener() {
        this.mActivityLifecycleCallbacks = new com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks(this.mSAContextManager);
        com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mActivityLifecycleCallbacks);
        com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.addExceptionListener(this.mActivityLifecycleCallbacks);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.addFragmentCallbacks(new com.sensorsdata.analytics.android.autotrack.core.autotrack.FragmentViewScreenCallbacks());
        if (this.mInternalConfigs.saConfigOptions.isTrackPageLeave()) {
            com.sensorsdata.analytics.android.autotrack.core.pageleave.ActivityPageLeaveCallbacks activityPageLeaveCallbacks = new com.sensorsdata.analytics.android.autotrack.core.pageleave.ActivityPageLeaveCallbacks(this.mInternalConfigs.saConfigOptions.getIgnorePageLeave());
            com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(activityPageLeaveCallbacks);
            com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.addExceptionListener(activityPageLeaveCallbacks);
            if (this.mInternalConfigs.saConfigOptions.isTrackFragmentPageLeave()) {
                com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks fragmentPageLeaveCallbacks = new com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks(this.mInternalConfigs.saConfigOptions.getIgnorePageLeave());
                com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.addFragmentCallbacks(fragmentPageLeaveCallbacks);
                com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.addExceptionListener(fragmentPageLeaveCallbacks);
            }
        }
    }
}
