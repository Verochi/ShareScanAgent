package com.umeng.ccg;

/* loaded from: classes19.dex */
public class CcgAgent {
    private static java.util.Map<java.lang.String, java.util.ArrayList<java.lang.String>> forbidSdkTable;
    private static java.lang.Object lock = new java.lang.Object();
    private static java.lang.Object configUpdateLock = new java.lang.Object();
    private static java.util.ArrayList<com.umeng.ccg.ConfigListener> callbacks = new java.util.ArrayList<>();
    private static java.util.ArrayList<com.umeng.ccg.ConfigUpdateListener> updateCallbacks = new java.util.ArrayList<>();
    private static java.lang.Object actionInfoLock = new java.lang.Object();
    private static java.util.Map<java.lang.String, com.umeng.ccg.ActionInfo> actionInfoTable = new java.util.HashMap();

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        forbidSdkTable = hashMap;
        hashMap.put(com.umeng.ccg.a.e, new java.util.ArrayList());
        forbidSdkTable.put(com.umeng.ccg.a.d, new java.util.ArrayList<>());
        forbidSdkTable.put(com.umeng.ccg.a.b, new java.util.ArrayList<>());
        forbidSdkTable.put(com.umeng.ccg.a.c, new java.util.ArrayList<>());
    }

    public static com.umeng.ccg.ActionInfo getActionInfo(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            synchronized (actionInfoLock) {
                r1 = actionInfoTable.containsKey(str) ? actionInfoTable.get(str) : null;
            }
        }
        return r1;
    }

    public static java.lang.String[] getCollectItemList() {
        return new java.lang.String[]{com.umeng.ccg.a.e, com.umeng.ccg.a.d, com.umeng.ccg.a.b, com.umeng.ccg.a.c};
    }

    public static void getConfigInfo(com.umeng.ccg.ConfigResult configResult) {
        if (configResult != null) {
            configResult.onConfigInfo(com.umeng.ccg.d.a().b(com.umeng.commonsdk.service.UMGlobalContext.getAppContext()));
        }
    }

    public static java.util.ArrayList<java.lang.String> getForbidSdkArray(java.lang.String str) {
        if (forbidSdkTable.containsKey(str)) {
            return forbidSdkTable.get(str);
        }
        return null;
    }

    public static java.util.ArrayList<java.lang.String> getRegistedModuleList() {
        java.util.ArrayList<java.lang.String> arrayList;
        synchronized (actionInfoLock) {
            arrayList = new java.util.ArrayList<>(actionInfoTable.keySet());
        }
        return arrayList;
    }

    public static boolean hasRegistedActionInfo() {
        boolean z;
        synchronized (actionInfoLock) {
            z = actionInfoTable.size() > 0;
        }
        return z;
    }

    public static void init(android.content.Context context) {
        com.umeng.ccg.d.a().a(context);
    }

    public static void notifyConfigChanged(org.json.JSONObject jSONObject) {
        synchronized (configUpdateLock) {
            int size = updateCallbacks.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    updateCallbacks.get(i).onConfigUpdate(jSONObject);
                }
            }
        }
    }

    public static void notifyConfigReady(org.json.JSONObject jSONObject) {
        synchronized (lock) {
            int size = callbacks.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    callbacks.get(i).onConfigReady(jSONObject);
                }
            }
        }
    }

    public static void onActUpEvent(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "onActUpEvent: type or token agument is empty string, pls check!");
            com.umeng.commonsdk.statistics.common.MLog.e("onActUpEvent: type、token参数不能为null或者空字符串！");
            return;
        }
        java.lang.String str3 = "";
        if (bundle != null) {
            try {
                str3 = bundle.getString("ss");
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        org.json.JSONObject a = com.umeng.ccg.d.a().a(str, str2, str3);
        if (a != null) {
            com.umeng.analytics.pro.av.a(new com.umeng.analytics.pro.aq(com.umeng.analytics.pro.aq.b, a), 0L, java.util.concurrent.TimeUnit.SECONDS);
            java.lang.Thread.sleep(2000L);
        }
    }

    public static void registerActionInfo(com.umeng.ccg.ActionInfo actionInfo) {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (actionInfo != null) {
            synchronized (actionInfoLock) {
                try {
                    java.lang.String module = actionInfo.getModule(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
                    if (!android.text.TextUtils.isEmpty(module) && !actionInfoTable.containsKey(module)) {
                        java.lang.String[] supportAction = actionInfo.getSupportAction(appContext);
                        if (supportAction != null) {
                            for (java.lang.String str : supportAction) {
                                boolean switchState = actionInfo.getSwitchState(appContext, str);
                                if (forbidSdkTable.containsKey(str)) {
                                    java.util.ArrayList<java.lang.String> arrayList = forbidSdkTable.get(str);
                                    if (!switchState) {
                                        arrayList.add(module);
                                    }
                                }
                            }
                        }
                        actionInfoTable.put(module, actionInfo);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public static void registerConfigListener(com.umeng.ccg.ConfigListener configListener) {
        if (configListener != null) {
            synchronized (lock) {
                callbacks.add(configListener);
            }
        }
    }

    public static void registerConfigUpdateListener(com.umeng.ccg.ConfigUpdateListener configUpdateListener) {
        if (configUpdateListener != null) {
            synchronized (configUpdateLock) {
                updateCallbacks.add(configUpdateListener);
            }
        }
    }
}
