package com.umeng.vt.diff;

/* loaded from: classes19.dex */
public class Event {
    private static final int MAX_PROPERTY_LENGTH = 128;

    public static void commit(android.content.Context context, android.view.View view, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Boolean bool) {
        if (!bool.booleanValue()) {
            if (view != null) {
                java.lang.String textPropertyFromView = textPropertyFromView(view);
                if (!android.text.TextUtils.isEmpty(textPropertyFromView)) {
                    map.put(com.umeng.vt.diff.V.VISUAL_TRACK_TEXT, textPropertyFromView);
                }
                map.put(com.umeng.vt.diff.V.VISUAL_TRACK_PG, view.getContext().getClass().getName());
            } else {
                map.put(com.umeng.vt.diff.V.VISUAL_TRACK_PG, context.getClass().getName());
            }
            map.put(com.umeng.vt.diff.V.VISUAL_TRACK_STYLE, 1);
            map.put(com.umeng.vt.diff.V.VISUAL_TRACK_UAPP_PG, getPageName());
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "release:事件名: " + str);
            if (map.containsKey(com.umeng.vt.diff.V.VISUAL_TRACK_TEXT)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 参数：" + ((java.lang.String) map.get(com.umeng.vt.diff.V.VISUAL_TRACK_TEXT)));
            }
            if (map.containsKey(com.umeng.vt.diff.V.VISUAL_TRACK_PG)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 页面：" + ((java.lang.String) map.get(com.umeng.vt.diff.V.VISUAL_TRACK_PG)));
            }
            if (map.containsKey(com.umeng.vt.diff.V.VISUAL_TRACK_UAPP_PG)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; UApp页面路径：" + ((java.lang.String) map.get(com.umeng.vt.diff.V.VISUAL_TRACK_UAPP_PG)));
            }
            com.umeng.analytics.MobclickAgent.onEventObject(context, str, map);
            return;
        }
        if (com.umeng.tunnel.UMChannelAgent.init()) {
            if (view != null) {
                java.lang.String textPropertyFromView2 = textPropertyFromView(view);
                if (!android.text.TextUtils.isEmpty(textPropertyFromView2)) {
                    map.put(com.umeng.vt.diff.V.VISUAL_TRACK_TEXT, textPropertyFromView2);
                }
                map.put(com.umeng.vt.diff.V.VISUAL_TRACK_PG, view.getContext().getClass().getName());
            } else {
                map.put(com.umeng.vt.diff.V.VISUAL_TRACK_PG, context.getClass().getName());
            }
            map.put(com.umeng.vt.diff.V.VISUAL_TRACK_STYLE, 1);
            map.put(com.umeng.vt.diff.V.VISUAL_TRACK_UAPP_PG, getPageName());
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "config:事件名: " + str);
            if (map.containsKey(com.umeng.vt.diff.V.VISUAL_TRACK_TEXT)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 参数：" + ((java.lang.String) map.get(com.umeng.vt.diff.V.VISUAL_TRACK_TEXT)));
            }
            if (map.containsKey(com.umeng.vt.diff.V.VISUAL_TRACK_PG)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 页面：" + ((java.lang.String) map.get(com.umeng.vt.diff.V.VISUAL_TRACK_PG)));
            }
            if (map.containsKey(com.umeng.vt.diff.V.VISUAL_TRACK_UAPP_PG)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; UApp页面路径：" + ((java.lang.String) map.get(com.umeng.vt.diff.V.VISUAL_TRACK_UAPP_PG)));
            }
            com.umeng.tunnel.UMChannelAgent.onDebugEvent(context, str, map);
        }
    }

    public static java.lang.String getActivityName(android.view.View view) {
        android.content.Context context;
        if (view == null || (context = view.getContext()) == null) {
            return null;
        }
        if (context instanceof android.content.ContextWrapper) {
            context = ((android.content.ContextWrapper) context).getBaseContext();
        }
        if (context instanceof android.app.Activity) {
            return context.getClass().getCanonicalName();
        }
        return null;
    }

    public static java.lang.String getPageName() {
        java.lang.String currenPageName = com.umeng.analytics.vshelper.PageNameMonitor.getInstance().getCurrenPageName();
        return android.text.TextUtils.isEmpty(currenPageName) ? "" : currenPageName;
    }

    public static java.lang.String getPageName(android.view.View view) {
        java.lang.String pageName = getPageName();
        if (pageName != null && !pageName.equals("") && !pageName.equals("VT")) {
            return pageName;
        }
        java.lang.String activityName = getActivityName(view);
        return (activityName == null || activityName.equals("")) ? "VT" : activityName;
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
    }

    public static void openDebug(java.lang.String str) {
    }

    private static void reflectTrack(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.reflect.Method method;
        try {
            java.lang.Class<?> findClass = com.umeng.vt.diff.util.ClassLoadUtil.findClass("com.umeng.analytics.MobclickAgent");
            if (findClass == null || (method = findClass.getMethod("onEvent", android.content.Context.class, java.lang.String.class, java.util.Map.class)) == null) {
                return;
            }
            method.invoke(null, context, str, map);
        } catch (java.lang.Exception unused) {
        }
    }

    private static java.lang.String textPropertyFromView(android.view.View view) {
        if (view instanceof android.widget.TextView) {
            java.lang.CharSequence text = ((android.widget.TextView) view).getText();
            if (text != null) {
                return text.toString();
            }
            return null;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount && sb.length() < 128; i++) {
            java.lang.String textPropertyFromView = textPropertyFromView(viewGroup.getChildAt(i));
            if (textPropertyFromView != null && textPropertyFromView.length() > 0) {
                if (z) {
                    sb.append(", ");
                }
                sb.append(textPropertyFromView);
                z = true;
            }
        }
        if (sb.length() > 128) {
            return sb.substring(0, 128);
        }
        if (z) {
            return sb.toString();
        }
        return null;
    }
}
