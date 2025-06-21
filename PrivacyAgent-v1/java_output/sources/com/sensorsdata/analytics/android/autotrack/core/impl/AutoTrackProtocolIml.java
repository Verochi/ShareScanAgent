package com.sensorsdata.analytics.android.autotrack.core.impl;

/* loaded from: classes19.dex */
public class AutoTrackProtocolIml implements com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol {
    private static final java.lang.String TAG = "SA.AutoTrackProtocolIml";
    protected boolean mAutoTrack;
    private final com.sensorsdata.analytics.android.sdk.core.SAContextManager mContextManager;
    private final com.sensorsdata.analytics.android.sdk.SAConfigOptions mSAConfigOptions;
    protected java.util.List<java.lang.Class<?>> mIgnoredViewTypeList = new java.util.ArrayList();
    protected boolean mClearReferrerWhenAppEnd = false;
    protected com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI mFragmentAPI = new com.sensorsdata.analytics.android.autotrack.core.impl.FragmentAPI();
    protected java.util.List<java.lang.Integer> mAutoTrackIgnoredActivities = new java.util.ArrayList();

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneProperties;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass1(java.lang.String str, org.json.JSONObject jSONObject) {
            this.val$url = str;
            this.val$cloneProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (android.text.TextUtils.isEmpty(this.val$url) && this.val$cloneProperties == null) {
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                java.lang.String str = this.val$url;
                org.json.JSONObject jSONObject2 = this.val$cloneProperties;
                if (jSONObject2 != null) {
                    if (jSONObject2.has("$title")) {
                        com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setCurrentTitle(this.val$cloneProperties.getString("$title"));
                    } else {
                        com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setCurrentTitle(null);
                    }
                    if (this.val$cloneProperties.has("$url")) {
                        str = this.val$cloneProperties.optString("$url");
                    }
                }
                com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setCurrentScreenUrl(str);
                if (com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrer() != null) {
                    jSONObject.put("$referrer", com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrer());
                }
                jSONObject.put("$url", com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getCurrentScreenUrl());
                org.json.JSONObject jSONObject3 = this.val$cloneProperties;
                if (jSONObject3 != null) {
                    com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject3, jSONObject);
                }
                com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setCurrentScreenTrackProperties(jSONObject);
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppViewScreen").setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setProperties(jSONObject));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$propertyJson;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass2(org.json.JSONObject jSONObject, android.view.View view) {
            this.val$propertyJson = jSONObject;
            this.val$view = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_MERGE_VISUAL_PROPERTIES, this.val$propertyJson, this.val$view);
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppClick").setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setProperties(this.val$propertyJson));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public AutoTrackProtocolIml(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mContextManager = sAContextManager;
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        this.mSAConfigOptions = sAConfigOptions;
        this.mAutoTrack = com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppInfoBundle(sAContextManager.getContext()).getBoolean("com.sensorsdata.analytics.android.AutoTrack", false);
        if (sAConfigOptions.getAutoTrackEventType() != 0) {
            enableAutoTrack(sAConfigOptions.getAutoTrackEventType());
            this.mAutoTrack = true;
        }
    }

    private void enableAutoTrack(int i) {
        if (i <= 0 || i > 15) {
            return;
        }
        try {
            this.mAutoTrack = true;
            com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
            sAConfigOptions.setAutoTrackEventType(i | sAConfigOptions.getAutoTrackEventType());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void clearLastScreenUrl() {
        if (this.mClearReferrerWhenAppEnd) {
            com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setLastScreenUrl(null);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void clearReferrerWhenAppEnd() {
        this.mClearReferrerWhenAppEnd = true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void disableAutoTrack(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType == null) {
            return;
        }
        try {
            if (this.mSAConfigOptions.getAutoTrackEventType() == 0) {
                return;
            }
            int autoTrackEventType2 = this.mSAConfigOptions.getAutoTrackEventType();
            int i = autoTrackEventType.eventValue;
            int i2 = autoTrackEventType2 | i;
            if (i2 == i) {
                this.mSAConfigOptions.setAutoTrackEventType(0);
            } else {
                this.mSAConfigOptions.setAutoTrackEventType(i ^ i2);
            }
            if (this.mSAConfigOptions.getAutoTrackEventType() == 0) {
                this.mAutoTrack = false;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void disableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list) {
        if (list == null) {
            return;
        }
        try {
            if (this.mSAConfigOptions.getAutoTrackEventType() == 0) {
                return;
            }
            for (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType : list) {
                if ((this.mSAConfigOptions.getAutoTrackEventType() | autoTrackEventType.eventValue) == this.mSAConfigOptions.getAutoTrackEventType()) {
                    com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
                    sAConfigOptions.setAutoTrackEventType(autoTrackEventType.eventValue ^ sAConfigOptions.getAutoTrackEventType());
                }
            }
            if (this.mSAConfigOptions.getAutoTrackEventType() == 0) {
                this.mAutoTrack = false;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void enableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                this.mAutoTrack = true;
                for (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType : list) {
                    com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
                    sAConfigOptions.setAutoTrackEventType(autoTrackEventType.eventValue | sAConfigOptions.getAutoTrackEventType());
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragment(java.lang.Class<?> cls) {
        this.mFragmentAPI.enableAutoTrackFragment(cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        this.mFragmentAPI.enableAutoTrackFragments(list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public java.util.List<java.lang.Class<?>> getIgnoredViewTypeList() {
        if (this.mIgnoredViewTypeList == null) {
            this.mIgnoredViewTypeList = new java.util.ArrayList();
        }
        return this.mIgnoredViewTypeList;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public org.json.JSONObject getLastScreenTrackProperties() {
        try {
            org.json.JSONObject cloneJsonObject = com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getLastTrackProperties());
            if (cloneJsonObject != null) {
                cloneJsonObject.remove("$lib_method");
            }
            return cloneJsonObject;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return new org.json.JSONObject();
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public java.lang.String getLastScreenUrl() {
        return com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getLastScreenUrl();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.mAutoTrackIgnoredActivities == null) {
            this.mAutoTrackIgnoredActivities = new java.util.ArrayList();
        }
        for (java.lang.Class<?> cls : list) {
            if (cls != null) {
                int hashCode = cls.hashCode();
                if (!this.mAutoTrackIgnoredActivities.contains(java.lang.Integer.valueOf(hashCode))) {
                    this.mAutoTrackIgnoredActivities.add(java.lang.Integer.valueOf(hashCode));
                }
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreAutoTrackActivity(java.lang.Class<?> cls) {
        if (cls == null) {
            return;
        }
        if (this.mAutoTrackIgnoredActivities == null) {
            this.mAutoTrackIgnoredActivities = new java.util.ArrayList();
        }
        try {
            int hashCode = cls.hashCode();
            if (this.mAutoTrackIgnoredActivities.contains(java.lang.Integer.valueOf(hashCode))) {
                return;
            }
            this.mAutoTrackIgnoredActivities.add(java.lang.Integer.valueOf(hashCode));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragment(java.lang.Class<?> cls) {
        this.mFragmentAPI.ignoreAutoTrackFragment(cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        this.mFragmentAPI.ignoreAutoTrackFragments(list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreView(android.view.View view) {
        if (view != null) {
            view.setTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_ignored, "1");
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreView(android.view.View view, boolean z) {
        if (view != null) {
            view.setTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_ignored, z ? "1" : "0");
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreViewType(java.lang.Class<?> cls) {
        if (cls == null) {
            return;
        }
        if (this.mIgnoredViewTypeList == null) {
            this.mIgnoredViewTypeList = new java.util.ArrayList();
        }
        if (this.mIgnoredViewTypeList.contains(cls)) {
            return;
        }
        this.mIgnoredViewTypeList.add(cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isActivityAutoTrackAppClickIgnored(java.lang.Class<?> cls) {
        if (cls == null) {
            return false;
        }
        java.util.List<java.lang.Integer> list = this.mAutoTrackIgnoredActivities;
        return ((list == null || !list.contains(java.lang.Integer.valueOf(cls.hashCode()))) && cls.getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) == null && cls.getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppClick.class) == null) ? false : true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isActivityAutoTrackAppViewScreenIgnored(java.lang.Class<?> cls) {
        if (cls == null) {
            return false;
        }
        java.util.List<java.lang.Integer> list = this.mAutoTrackIgnoredActivities;
        return ((list == null || !list.contains(java.lang.Integer.valueOf(cls.hashCode()))) && cls.getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) == null && cls.getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreen.class) == null) ? false : true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEnabled() {
        java.lang.Boolean isAutoTrackEnabled;
        return (this.mContextManager.getRemoteManager() == null || (isAutoTrackEnabled = this.mContextManager.getRemoteManager().isAutoTrackEnabled()) == null) ? this.mAutoTrack : isAutoTrackEnabled.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEventTypeIgnored(int i) {
        java.lang.Boolean isAutoTrackEventTypeIgnored;
        if (this.mContextManager.getRemoteManager() == null || (isAutoTrackEventTypeIgnored = this.mContextManager.getRemoteManager().isAutoTrackEventTypeIgnored(i)) == null) {
            return (i | this.mSAConfigOptions.getAutoTrackEventType()) != this.mSAConfigOptions.getAutoTrackEventType();
        }
        if (isAutoTrackEventTypeIgnored.booleanValue()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: " + com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.autoTrackEventName(i) + " is ignored by remote config");
        }
        return isAutoTrackEventTypeIgnored.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType == null) {
            return false;
        }
        return isAutoTrackEventTypeIgnored(autoTrackEventType.eventValue);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isFragmentAutoTrackAppViewScreen(java.lang.Class<?> cls) {
        return this.mFragmentAPI.isFragmentAutoTrackAppViewScreen(cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isTrackFragmentAppViewScreenEnabled() {
        return this.mFragmentAPI.isTrackFragmentAppViewScreenEnabled();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void resumeAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.mAutoTrackIgnoredActivities == null) {
            this.mAutoTrackIgnoredActivities = new java.util.ArrayList();
        }
        try {
            for (java.lang.Class<?> cls : list) {
                if (cls != null) {
                    int hashCode = cls.hashCode();
                    if (this.mAutoTrackIgnoredActivities.contains(java.lang.Integer.valueOf(hashCode))) {
                        this.mAutoTrackIgnoredActivities.remove(java.lang.Integer.valueOf(hashCode));
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void resumeAutoTrackActivity(java.lang.Class<?> cls) {
        if (cls == null) {
            return;
        }
        if (this.mAutoTrackIgnoredActivities == null) {
            this.mAutoTrackIgnoredActivities = new java.util.ArrayList();
        }
        try {
            int hashCode = cls.hashCode();
            if (this.mAutoTrackIgnoredActivities.contains(java.lang.Integer.valueOf(hashCode))) {
                this.mAutoTrackIgnoredActivities.remove(java.lang.Integer.valueOf(hashCode));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragment(java.lang.Class<?> cls) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragment(cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragments(list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewActivity(android.view.View view, android.app.Activity activity) {
        if (view == null || activity == null) {
            return;
        }
        try {
            view.setTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_activity, activity);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewFragmentName(android.view.View view, java.lang.String str) {
        if (view != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                view.setTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_fragment_name2, str);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(android.app.Dialog dialog, java.lang.String str) {
        if (dialog != null) {
            try {
                if (android.text.TextUtils.isEmpty(str) || dialog.getWindow() == null) {
                    return;
                }
                dialog.getWindow().getDecorView().setTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_id, str);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(android.view.View view, java.lang.String str) {
        if (view == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_id, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(java.lang.Object obj, java.lang.String str) {
        java.lang.Class<androidx.appcompat.app.AlertDialog> cls;
        java.lang.reflect.Method method;
        android.view.Window window;
        java.lang.Class<androidx.appcompat.app.AlertDialog> cls2 = androidx.appcompat.app.AlertDialog.class;
        if (obj == null) {
            return;
        }
        try {
            int i = androidx.appcompat.app.AlertDialog.n;
            cls = cls2;
        } catch (java.lang.Exception unused) {
            cls = null;
        }
        try {
            int i2 = androidx.appcompat.app.AlertDialog.n;
        } catch (java.lang.Exception unused2) {
            cls2 = null;
        }
        if (cls == null) {
            cls = cls2;
        }
        if (cls == null) {
            return;
        }
        try {
            if (!cls.isInstance(obj) || android.text.TextUtils.isEmpty(str) || (method = obj.getClass().getMethod("getWindow", new java.lang.Class[0])) == null || (window = (android.view.Window) method.invoke(obj, new java.lang.Object[0])) == null) {
                return;
            }
            window.getDecorView().setTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_id, str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewProperties(android.view.View view, org.json.JSONObject jSONObject) {
        if (view == null || jSONObject == null) {
            return;
        }
        view.setTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void trackFragmentAppViewScreen() {
        this.mFragmentAPI.trackFragmentAppViewScreen();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewAppClick(android.view.View view) {
        trackViewAppClick(view, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewAppClick(android.view.View view, org.json.JSONObject jSONObject) {
        if (view == null) {
            return;
        }
        try {
            org.json.JSONObject injectClickInfo = com.sensorsdata.analytics.android.autotrack.utils.AopUtil.injectClickInfo(new com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext(view), jSONObject != null ? com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject) : new org.json.JSONObject(), true);
            if (injectClickInfo != null) {
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml.AnonymousClass2(injectClickInfo, view));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(android.app.Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            trackViewScreen(com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(activity), com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activity));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(java.lang.Object obj) {
        java.lang.Class<androidx.fragment.app.Fragment> cls;
        java.lang.Class<?> cls2;
        org.json.JSONObject trackProperties;
        com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle sensorsDataFragmentTitle;
        java.lang.Class<androidx.fragment.app.Fragment> cls3 = androidx.fragment.app.Fragment.class;
        if (obj == null) {
            return;
        }
        android.app.Activity activity = null;
        try {
            int i = androidx.fragment.app.Fragment.n;
            cls = cls3;
        } catch (java.lang.Exception unused) {
            cls = null;
        }
        try {
            cls2 = java.lang.Class.forName("android.app.Fragment");
        } catch (java.lang.Exception unused2) {
            cls2 = null;
        }
        try {
            int i2 = androidx.fragment.app.Fragment.n;
        } catch (java.lang.Exception unused3) {
            cls3 = null;
        }
        if ((cls == null || !cls.isInstance(obj)) && ((cls2 == null || !cls2.isInstance(obj)) && (cls3 == null || !cls3.isInstance(obj)))) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.lang.Object canonicalName = obj.getClass().getCanonicalName();
            java.lang.String title = (!obj.getClass().isAnnotationPresent(com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class) || (sensorsDataFragmentTitle = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) obj.getClass().getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class)) == null) ? null : sensorsDataFragmentTitle.title();
            try {
                java.lang.reflect.Method method = obj.getClass().getMethod("getActivity", new java.lang.Class[0]);
                if (method != null) {
                    activity = (android.app.Activity) method.invoke(obj, new java.lang.Object[0]);
                }
            } catch (java.lang.Exception unused4) {
            }
            if (activity != null) {
                if (android.text.TextUtils.isEmpty(title)) {
                    title = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(activity);
                }
                canonicalName = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "%s|%s", activity.getClass().getCanonicalName(), canonicalName);
            }
            if (!android.text.TextUtils.isEmpty(title)) {
                jSONObject.put("$title", title);
            }
            jSONObject.put("$screen_name", canonicalName);
            if ((obj instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) && (trackProperties = ((com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) obj).getTrackProperties()) != null) {
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(trackProperties, jSONObject);
            }
            trackViewScreen(com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(obj), jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml.AnonymousClass1(str, com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
