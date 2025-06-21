package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class go {

    public static class a {
        public static com.amap.api.mapcore.util.go a = new com.amap.api.mapcore.util.go();
    }

    private static com.amap.api.mapcore.util.fh a(java.lang.String str, java.util.List<com.amap.api.mapcore.util.fh> list) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; list != null && i < list.size(); i++) {
            com.amap.api.mapcore.util.fh fhVar = list.get(i);
            if (fhVar != null) {
                java.lang.String[] g = fhVar.g();
                for (java.lang.String str2 : g) {
                    if (!android.text.TextUtils.isEmpty(g[i]) && str.contains(str2)) {
                        return fhVar;
                    }
                }
            }
        }
        return null;
    }

    private static org.json.JSONArray a(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        java.lang.String[] strArr = {"AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", "main"};
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (java.lang.Thread thread : java.lang.Thread.getAllStackTraces().keySet()) {
            if (thread != null && !str.equals(thread.getName())) {
                for (int i = 0; i < 6; i++) {
                    java.lang.String str2 = strArr[i];
                    java.lang.String name = thread.getName();
                    if (((android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(name) || (!str2.contains(name) && !name.contains(str2))) ? false : true) && a(thread) != null) {
                        jSONArray.put(a(thread));
                    }
                }
            }
        }
        return jSONArray;
    }

    private static org.json.JSONObject a(java.lang.Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        java.lang.StackTraceElement[] stackTrace = thread.getStackTrace();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.List<com.amap.api.mapcore.util.fh> list, boolean z, com.amap.api.mapcore.util.fh fhVar) {
        java.lang.String str3 = "";
        if (str2 != null) {
            for (java.lang.Thread thread : java.lang.Thread.getAllStackTraces().keySet()) {
                if (thread != null && !android.text.TextUtils.isEmpty(thread.getName()) && (str2.contains(thread.getName()) || thread.getName().contains(str2))) {
                    java.lang.StackTraceElement[] stackTrace = thread.getStackTrace();
                    if (stackTrace != null) {
                        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                        for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                            stringBuffer.append("at ");
                            stringBuffer.append(stackTraceElement);
                            stringBuffer.append("<br />");
                        }
                        str3 = stringBuffer.toString();
                    }
                }
            }
            str3 = null;
        }
        com.amap.api.mapcore.util.fh a2 = a(str3, list);
        if (z && a2 == null) {
            return false;
        }
        java.lang.String str4 = str + "<br />" + str3;
        org.json.JSONArray a3 = a(str2);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("crashStack", str4);
            jSONObject.put("backStacks", a3);
        } catch (java.lang.Throwable unused) {
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        if (android.text.TextUtils.isEmpty(jSONObject2)) {
            return false;
        }
        if (z || a2 != null) {
            com.amap.api.mapcore.util.gd.a(context, a2, jSONObject2, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
            return true;
        }
        com.amap.api.mapcore.util.gd.b(context, fhVar, jSONObject2, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
        return true;
    }
}
