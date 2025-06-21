package org.greenrobot.eventbus.util;

/* loaded from: classes26.dex */
public class ExceptionToResourceMapping {
    public final java.util.Map<java.lang.Class<? extends java.lang.Throwable>, java.lang.Integer> throwableToMsgIdMap = new java.util.HashMap();

    public org.greenrobot.eventbus.util.ExceptionToResourceMapping addMapping(java.lang.Class<? extends java.lang.Throwable> cls, int i) {
        this.throwableToMsgIdMap.put(cls, java.lang.Integer.valueOf(i));
        return this;
    }

    public java.lang.Integer mapThrowable(java.lang.Throwable th) {
        int i = 20;
        java.lang.Throwable th2 = th;
        do {
            java.lang.Integer mapThrowableFlat = mapThrowableFlat(th2);
            if (mapThrowableFlat == null) {
                th2 = th2.getCause();
                i--;
                if (i <= 0 || th2 == th) {
                    break;
                }
            } else {
                return mapThrowableFlat;
            }
        } while (th2 != null);
        org.greenrobot.eventbus.Logger.Default.get().log(java.util.logging.Level.FINE, "No specific message resource ID found for " + th);
        return null;
    }

    public java.lang.Integer mapThrowableFlat(java.lang.Throwable th) {
        java.lang.Class<?> cls = th.getClass();
        java.lang.Integer num = this.throwableToMsgIdMap.get(cls);
        if (num == null) {
            java.lang.Class<? extends java.lang.Throwable> cls2 = null;
            for (java.util.Map.Entry<java.lang.Class<? extends java.lang.Throwable>, java.lang.Integer> entry : this.throwableToMsgIdMap.entrySet()) {
                java.lang.Class<? extends java.lang.Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    num = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return num;
    }
}
