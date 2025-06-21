package com.sensorsdata.sf.core.entity;

/* loaded from: classes19.dex */
public class GlobalData implements com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener {
    private static final int MSG_QUERY_CONVERT_STATE = 0;
    private static final java.lang.String TAG = "GlobalData";
    public org.json.JSONObject cachedGlobalData;
    public long configPullIntervalMs;
    public com.sensorsdata.sf.core.window.Window globalIntervalWindow;
    public com.sensorsdata.sf.core.entity.GlobalPopupLimit globalPopupLimit;
    private boolean isConverting;
    public android.content.Context mContext;
    private android.os.Handler mConvertHandler;
    public java.lang.String minSdkVersion;
    public java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> popupPlans;
    public java.lang.String serverCurrentTime;
    public java.lang.String userId;
    public java.util.Map<java.lang.String, java.util.List<com.sensorsdata.sf.core.entity.PopupPlan>> eventPopupPlans = new java.util.HashMap();
    private boolean mAppInForeground = true;
    public java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.sf.core.entity.PopupPlan> mConvertPlans = new java.util.concurrent.CopyOnWriteArrayList<>();

    /* renamed from: com.sensorsdata.sf.core.entity.GlobalData$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        private com.sensorsdata.sf.core.entity.PopupPlan getPlan(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            for (com.sensorsdata.sf.core.entity.PopupPlan popupPlan : com.sensorsdata.sf.core.entity.GlobalData.this.popupPlans) {
                com.sensorsdata.sf.core.window.ConvertWindow convertWindow = popupPlan.convertWindow;
                if (convertWindow != null && android.text.TextUtils.equals(convertWindow.getUUID(), str)) {
                    return popupPlan;
                }
            }
            return null;
        }

        private boolean requestConvert(java.lang.String str) {
            java.lang.Exception e;
            boolean z;
            java.lang.String pullWindowState = com.sensorsdata.sf.core.http.HttpRequestHelper.shareInstance().pullWindowState(str);
            try {
            } catch (java.lang.Exception e2) {
                e = e2;
                z = false;
            }
            if (android.text.TextUtils.isEmpty(pullWindowState)) {
                return false;
            }
            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.entity.GlobalData.TAG, "convert result:" + com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(pullWindowState));
            org.json.JSONArray jSONArray = new org.json.JSONArray(pullWindowState);
            z = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    org.json.JSONObject jSONObject = (org.json.JSONObject) jSONArray.get(i);
                    com.sensorsdata.sf.core.entity.PopupPlan plan = getPlan(jSONObject.optString("popup_display_uuid"));
                    if (plan != null && jSONObject.optLong("convert_time", 0L) > 0) {
                        com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.remove(plan);
                        org.json.JSONObject jSONObject2 = com.sensorsdata.sf.core.entity.GlobalData.this.cachedGlobalData;
                        if (jSONObject2 != null) {
                            org.json.JSONObject optJSONObject = jSONObject2.optJSONObject("plan_" + plan.planId);
                            if (optJSONObject != null) {
                                optJSONObject.remove("convert");
                            }
                        }
                        z = true;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    return z;
                }
            }
            return z;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            boolean z;
            super.handleMessage(message);
            if (com.sensorsdata.sf.core.entity.GlobalData.this.mAppInForeground && com.sensorsdata.sf.core.entity.GlobalData.this.isConverting && !com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.isEmpty()) {
                java.lang.Object obj = message.obj;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<com.sensorsdata.sf.core.entity.PopupPlan> it = com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.iterator();
                while (it.hasNext()) {
                    com.sensorsdata.sf.core.entity.PopupPlan next = it.next();
                    com.sensorsdata.sf.core.window.ConvertWindow convertWindow = next.convertWindow;
                    if (convertWindow != null && convertWindow.isFinished()) {
                        arrayList.add(next);
                    }
                }
                com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.removeAll(arrayList);
                if (com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.isEmpty()) {
                    return;
                }
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                int i = 0;
                while (true) {
                    java.lang.String str = ",";
                    if (i >= com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.size()) {
                        break;
                    }
                    java.lang.String uuid = com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.get(i).convertWindow.getUUID();
                    arrayList2.add(uuid);
                    sb.append(uuid);
                    if (i == com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.size() - 1) {
                        str = "";
                    }
                    sb.append(str);
                    i++;
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                java.lang.String sb2 = sb.toString();
                if (requestConvert(sb2)) {
                    com.sensorsdata.sf.core.entity.GlobalData.this.commit();
                    if (com.sensorsdata.sf.core.entity.GlobalData.this.mConvertPlans.isEmpty()) {
                        return;
                    }
                }
                android.os.Message message2 = new android.os.Message();
                if (obj != null) {
                    int i2 = message.arg1 + 5;
                    message2.arg1 = i2;
                    message2.arg1 = java.lang.Math.min(i2, 600);
                    java.lang.String[] split = ((java.lang.String) obj).split(",");
                    java.util.Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        java.lang.String str2 = (java.lang.String) it2.next();
                        int length = split.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                z = false;
                                break;
                            } else {
                                if (android.text.TextUtils.equals(str2, split[i3])) {
                                    z = true;
                                    break;
                                }
                                i3++;
                            }
                        }
                        if (!z) {
                            message2.arg1 = 5;
                            break;
                        }
                    }
                } else {
                    message2.arg1 = 5;
                }
                message2.what = 0;
                message2.obj = sb2;
                com.sensorsdata.sf.core.entity.GlobalData.this.mConvertHandler.sendMessageDelayed(message2, message2.arg1 * 1000);
            }
        }
    }

    public GlobalData(android.content.Context context) {
        this.mContext = context;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("query_convert_state");
        handlerThread.start();
        this.mConvertHandler = new com.sensorsdata.sf.core.entity.GlobalData.AnonymousClass1(handlerThread.getLooper());
    }

    private void startConvert() {
        if (!this.isConverting) {
            this.isConverting = true;
            this.mConvertHandler.sendEmptyMessage(0);
            return;
        }
        android.os.Handler handler = this.mConvertHandler;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(0)) {
            this.mConvertHandler.removeMessages(0);
        }
        this.mConvertHandler.sendEmptyMessage(0);
    }

    private void stopConvert() {
        this.isConverting = false;
        android.os.Handler handler = this.mConvertHandler;
        if (handler == null || !handler.hasMessages(0)) {
            return;
        }
        this.mConvertHandler.removeMessages(0);
    }

    public void addConvertPlan(com.sensorsdata.sf.core.entity.PopupPlan popupPlan) {
        java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.sf.core.entity.PopupPlan> copyOnWriteArrayList;
        if (popupPlan == null || (copyOnWriteArrayList = this.mConvertPlans) == null || copyOnWriteArrayList.contains(popupPlan)) {
            return;
        }
        this.mConvertPlans.add(popupPlan);
        startConvert();
    }

    public void cleanAllPlans() {
        java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> list = this.popupPlans;
        if (list != null) {
            list.clear();
        }
        java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.sf.core.entity.PopupPlan> copyOnWriteArrayList = this.mConvertPlans;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        java.util.Map<java.lang.String, java.util.List<com.sensorsdata.sf.core.entity.PopupPlan>> map = this.eventPopupPlans;
        if (map != null) {
            map.clear();
        }
        this.cachedGlobalData = null;
    }

    public void commit() {
        org.json.JSONObject jSONObject = this.cachedGlobalData;
        if (jSONObject == null) {
            return;
        }
        try {
            com.sensorsdata.sf.core.SFContextManger.getInstance().getDataOperate().savePlanLocal(this.userId, jSONObject.toString());
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public org.json.JSONObject getCachedGlobalData() {
        return this.cachedGlobalData;
    }

    public com.sensorsdata.sf.core.entity.PopupPlan getPopupPlan(long j) {
        java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> list = this.popupPlans;
        if (list == null) {
            return null;
        }
        try {
            for (com.sensorsdata.sf.core.entity.PopupPlan popupPlan : list) {
                if (popupPlan.planId == j) {
                    return popupPlan;
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        return null;
    }

    public boolean isConvertSuccess(com.sensorsdata.sf.core.entity.PopupPlan popupPlan) {
        com.sensorsdata.sf.core.window.ConvertWindow convertWindow;
        return popupPlan == null || (convertWindow = popupPlan.convertWindow) == null || convertWindow.isFinished() || !this.mConvertPlans.contains(popupPlan);
    }

    @Override // com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener
    public void onEnterBackground() {
        this.mAppInForeground = false;
        stopConvert();
    }

    @Override // com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener
    public void onEnterForeground(boolean z) {
        this.mAppInForeground = true;
        startConvert();
    }

    public void removeConvertPlan(com.sensorsdata.sf.core.entity.PopupPlan popupPlan) {
        java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.sf.core.entity.PopupPlan> copyOnWriteArrayList = this.mConvertPlans;
        if (copyOnWriteArrayList == null || popupPlan == null) {
            return;
        }
        copyOnWriteArrayList.remove(popupPlan);
    }

    public void setCachedGlobalData(org.json.JSONObject jSONObject) {
        this.cachedGlobalData = jSONObject;
    }

    public java.lang.String toString() {
        return "GlobalData{minSdkVersion='" + this.minSdkVersion + "', serverCurrentTime='" + this.serverCurrentTime + "', globalPopupLimit=" + this.globalPopupLimit + ", GlobalIntervalWindow=" + this.globalIntervalWindow + ", popupPlans=" + this.popupPlans + "}\n";
    }
}
