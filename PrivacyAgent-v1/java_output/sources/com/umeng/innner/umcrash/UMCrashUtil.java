package com.umeng.innner.umcrash;

/* loaded from: classes19.dex */
public class UMCrashUtil {
    private static final int MAX_THREAD_TRACE_LENGTH = 20480;
    private static final java.lang.String TAG = "UMCrashUtil";

    public static java.util.Map<java.lang.String, java.lang.String> getAllThreadTraces() {
        java.util.Map<java.lang.Thread, java.lang.StackTraceElement[]> allStackTraces;
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            allStackTraces = java.lang.Thread.getAllStackTraces();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (allStackTraces == null) {
            return null;
        }
        java.lang.Thread thread = android.os.Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = java.lang.Thread.currentThread().getId();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.Thread, java.lang.StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (id != entry.getKey().getId()) {
                int i = 0;
                sb.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    java.lang.StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        java.lang.StackTraceElement stackTraceElement = value[i];
                        if (sb.length() >= 20480) {
                            sb.append("\n[Stack trace size must be less than :");
                            sb.append(20480);
                            sb.append("!]");
                            break;
                        }
                        sb.append("  at ");
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i++;
                    }
                    hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                }
            }
        }
        return hashMap;
    }
}
