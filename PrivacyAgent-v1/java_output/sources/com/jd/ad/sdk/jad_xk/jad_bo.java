package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_bo implements java.lang.Thread.UncaughtExceptionHandler {
    public android.content.SharedPreferences jad_an;
    public java.lang.Thread.UncaughtExceptionHandler jad_bo;

    public class jad_an implements com.jd.ad.sdk.jad_zm.jad_ly.jad_an {
        public jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i, java.lang.String str) {
            com.jd.ad.sdk.logger.Logger.d("crash report fail " + i + ",  " + str);
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(com.jd.ad.sdk.jad_zm.jad_mz jad_mzVar) {
            com.jd.ad.sdk.jad_xk.jad_bo.this.jad_an.edit().clear().commit();
            com.jd.ad.sdk.logger.Logger.d("crash report success " + jad_mzVar.toString());
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_xk.jad_bo$jad_bo, reason: collision with other inner class name */
    public static class C0415jad_bo {
        public static final com.jd.ad.sdk.jad_xk.jad_bo jad_an = new com.jd.ad.sdk.jad_xk.jad_bo();
    }

    public static java.lang.String jad_an(java.lang.Throwable th) {
        for (java.lang.Throwable th2 = new java.lang.Throwable("2.6.20", th); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof java.net.UnknownHostException) {
                return "";
            }
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        java.lang.String stringWriter2 = stringWriter.toString();
        return android.text.TextUtils.isEmpty(stringWriter2) ? "" : stringWriter2.length() > 512000 ? stringWriter2.substring(stringWriter2.length() - 512000) : stringWriter2;
    }

    public final synchronized void jad_an() {
        java.lang.String str;
        byte[] jad_an2;
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        android.content.SharedPreferences sharedPreferences = this.jad_an;
        if (sharedPreferences != null && jad_cp != null && jad_cp.jad_bo != null) {
            if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
                return;
            }
            java.util.Map<java.lang.String, ?> all = sharedPreferences.getAll();
            java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("crash uploadCrash size: ");
            jad_an3.append(all.size());
            com.jd.ad.sdk.logger.Logger.d(jad_an3.toString());
            if (all.size() == 0) {
                return;
            }
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("crash uploadCrash size: ");
            jad_an4.append(all.size());
            com.jd.ad.sdk.logger.Logger.d(jad_an4.toString());
            try {
                str = jad_cp.jad_bo.jad_an;
                java.util.concurrent.ConcurrentLinkedQueue concurrentLinkedQueue = new java.util.concurrent.ConcurrentLinkedQueue();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    java.lang.String str2 = (java.lang.String) it.next().getValue();
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        java.lang.String replaceAll = str2.replaceAll("\u0001", " ");
                        concurrentLinkedQueue.add(com.jd.ad.sdk.jad_xk.jad_iv.jad_an(replaceAll, jad_an(replaceAll) ? 2 : 1));
                    }
                }
                jad_an2 = com.jd.ad.sdk.jad_xk.jad_jt.jad_an(concurrentLinkedQueue);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (jad_an2 == null) {
                return;
            }
            com.jd.ad.sdk.jad_zm.jad_fs jad_an5 = com.jd.ad.sdk.jad_xk.jad_jt.jad_an();
            com.jd.ad.sdk.jad_zm.jad_ly.jad_bo jad_an6 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
            jad_an6.jad_fs = new com.jd.ad.sdk.jad_zm.jad_er(jad_an2);
            jad_an6.jad_bo = jad_an5;
            jad_an6.jad_er = str;
            jad_an6.jad_jt = new com.jd.ad.sdk.jad_xk.jad_bo.jad_an();
            jad_an6.jad_cp = 30000;
            jad_an6.jad_dq = 60000;
            jad_an6.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
        }
    }

    public final boolean jad_an(java.lang.String str) {
        return str.contains("com.jd.ad.sdk") || str.contains("jad") || str.contains("JAD");
    }

    public final synchronized void jad_bo(java.lang.Throwable th) {
        java.lang.String jad_an2;
        android.content.SharedPreferences sharedPreferences = this.jad_an;
        if (sharedPreferences == null) {
            return;
        }
        if (sharedPreferences.getAll() == null || this.jad_an.getAll().size() < 10) {
            try {
                jad_an2 = jad_an(th);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (android.text.TextUtils.isEmpty(jad_an2)) {
                return;
            }
            java.lang.String concat = "2.6.20".concat(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR).concat(java.lang.String.valueOf(com.jd.ad.sdk.jad_wj.jad_an.CRASH_ERROR.jad_an)).concat(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR).concat(jad_an2);
            android.content.SharedPreferences.Editor edit = this.jad_an.edit();
            edit.putString(java.lang.Long.toString(java.lang.System.currentTimeMillis()), concat.trim());
            com.jd.ad.sdk.jad_pc.jad_an jad_an3 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            if (jad_an3 == null) {
                edit.commit();
                com.jd.ad.sdk.logger.Logger.d("crash config is null, catch all errorInfo: " + concat);
                jad_an();
                return;
            }
            if (!"1".equals(jad_an3.jad_an)) {
                edit.commit();
                com.jd.ad.sdk.logger.Logger.d("crash config's crt is 0, catch all errorInfo: " + concat);
                jad_an();
            } else if (jad_an(concat)) {
                edit.commit();
                com.jd.ad.sdk.logger.Logger.d("crash config's crt is 1, catch sdk errorInfo: " + concat);
                jad_an();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@androidx.annotation.NonNull java.lang.Thread thread, @androidx.annotation.NonNull java.lang.Throwable th) {
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (th != null) {
                try {
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    uncaughtExceptionHandler = this.jad_bo;
                    if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof com.jd.ad.sdk.jad_xk.jad_bo)) {
                        return;
                    }
                }
                if (!(th instanceof java.lang.reflect.UndeclaredThrowableException)) {
                    jad_bo(th);
                    uncaughtExceptionHandler = this.jad_bo;
                    if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof com.jd.ad.sdk.jad_xk.jad_bo)) {
                        return;
                    }
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
            }
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.jad_bo;
            if (uncaughtExceptionHandler2 == null || uncaughtExceptionHandler2 == this || (uncaughtExceptionHandler2 instanceof com.jd.ad.sdk.jad_xk.jad_bo)) {
                return;
            }
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        } catch (java.lang.Throwable th2) {
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.jad_bo;
            if (uncaughtExceptionHandler3 != null && uncaughtExceptionHandler3 != this && !(uncaughtExceptionHandler3 instanceof com.jd.ad.sdk.jad_xk.jad_bo)) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
