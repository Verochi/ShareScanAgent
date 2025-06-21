package com.umeng.commonsdk.statistics;

/* loaded from: classes19.dex */
public class TagHelper {
    private static java.lang.Object lock = new java.lang.Object();
    private static java.util.Map<java.lang.String, java.lang.String> moduleTags = new java.util.HashMap();

    public static void deleteModuleTag(java.lang.String str) {
        synchronized (lock) {
            try {
                if (moduleTags.containsKey(str)) {
                    moduleTags.remove(str);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> getModuleTags() {
        java.util.HashMap hashMap = new java.util.HashMap();
        synchronized (lock) {
            try {
                if (moduleTags.size() > 0) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : moduleTags.entrySet()) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return hashMap;
    }

    public static void setModuleTag(java.lang.String str, java.lang.String str2) {
        synchronized (lock) {
            if (moduleTags.size() >= 30) {
                return;
            }
            if (!moduleTags.containsKey(str)) {
                moduleTags.put(str, str2);
            }
        }
    }
}
