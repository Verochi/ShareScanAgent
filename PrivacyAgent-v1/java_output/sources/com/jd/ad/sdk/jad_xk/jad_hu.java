package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_hu implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context jad_an;
    public final /* synthetic */ com.jd.ad.sdk.jad_xk.jad_iv jad_bo;

    public jad_hu(com.jd.ad.sdk.jad_xk.jad_iv jad_ivVar, android.content.Context context) {
        this.jad_bo = jad_ivVar;
        this.jad_an = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x01e2, code lost:
    
        if (r3.isClosed() == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f9, code lost:
    
        if (r3.isClosed() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010e, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x010c, code lost:
    
        if (r3.isClosed() == false) goto L55;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar;
        this.jad_bo.jad_fs = com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(this.jad_an);
        this.jad_bo.jad_jt = com.jd.ad.sdk.jad_qd.jad_jw.jad_cp(this.jad_an);
        this.jad_bo.jad_cp = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.jad_bo.jad_er = new java.util.concurrent.ConcurrentLinkedQueue<>();
        com.jd.ad.sdk.jad_xk.jad_iv jad_ivVar = this.jad_bo;
        android.database.Cursor cursor = null;
        if (jad_ivVar.jad_fs) {
            if (jad_ivVar.jad_dq == null) {
                android.content.Context context = this.jad_an;
                synchronized (com.jd.ad.sdk.jad_xk.jad_cp.class) {
                    if (com.jd.ad.sdk.jad_xk.jad_cp.jad_bo == null) {
                        com.jd.ad.sdk.jad_xk.jad_cp.jad_bo = new com.jd.ad.sdk.jad_xk.jad_cp(context, "jaddb.db", 2);
                    }
                    jad_cpVar = com.jd.ad.sdk.jad_xk.jad_cp.jad_bo;
                }
                jad_ivVar.jad_dq = jad_cpVar;
                this.jad_bo.jad_dq.jad_cp();
            }
            com.jd.ad.sdk.jad_xk.jad_iv jad_ivVar2 = this.jad_bo;
            if (jad_ivVar2.jad_dq != null) {
                if (jad_ivVar2.jad_cp == null) {
                    jad_ivVar2.jad_cp = new java.util.concurrent.ConcurrentLinkedQueue<>();
                }
                if (jad_ivVar2.jad_er == null) {
                    jad_ivVar2.jad_er = new java.util.concurrent.ConcurrentLinkedQueue<>();
                }
                java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> concurrentLinkedQueue = jad_ivVar2.jad_cp;
                com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar2 = jad_ivVar2.jad_dq;
                java.lang.String str = jad_ivVar2.jad_jt;
                synchronized (jad_cpVar2) {
                    arrayList2 = new java.util.ArrayList();
                    if (!android.text.TextUtils.isEmpty(str)) {
                        try {
                            jad_cpVar2.getReadableDatabase();
                            if (jad_cpVar2.jad_bo()) {
                                cursor = jad_cpVar2.jad_an.query("events", null, "process_name =?", new java.lang.String[]{str}, null, null, null);
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    while (!cursor.isAfterLast()) {
                                        int i = cursor.getInt(cursor.getColumnIndex("_id"));
                                        java.lang.String string = cursor.getString(cursor.getColumnIndex("event"));
                                        if (!android.text.TextUtils.isEmpty(string) && (!string.startsWith("{") || !string.endsWith(com.alipay.sdk.m.u.i.d))) {
                                            string = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(string);
                                        }
                                        com.jd.ad.sdk.jad_xk.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_xk.jad_dq(i, string);
                                        jad_dqVar.jad_kv = 1;
                                        arrayList2.add(jad_dqVar);
                                        cursor.moveToNext();
                                    }
                                    cursor.close();
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            try {
                                com.jd.ad.sdk.logger.Logger.w("Exception while loading events: ", th);
                                if (cursor != null) {
                                }
                            } finally {
                            }
                        }
                    }
                }
                concurrentLinkedQueue.addAll(arrayList2);
                return;
            }
            return;
        }
        if (jad_ivVar.jad_cp == null) {
            jad_ivVar.jad_cp = new java.util.concurrent.ConcurrentLinkedQueue<>();
        }
        if (jad_ivVar.jad_er == null) {
            jad_ivVar.jad_er = new java.util.concurrent.ConcurrentLinkedQueue<>();
        }
        java.lang.String str2 = jad_ivVar.jad_jt;
        synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
            java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
            arrayList = new java.util.ArrayList();
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    android.content.ContentResolver jad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                    if (jad_an != null) {
                        cursor = jad_an.query(android.net.Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_event" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "query" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2), null, null, null, null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            while (!cursor.isAfterLast()) {
                                int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
                                java.lang.String string2 = cursor.getString(cursor.getColumnIndex("event"));
                                if (!android.text.TextUtils.isEmpty(string2) && (!string2.startsWith("{") || !string2.endsWith(com.alipay.sdk.m.u.i.d))) {
                                    string2 = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(string2);
                                }
                                com.jd.ad.sdk.jad_xk.jad_dq jad_dqVar2 = new com.jd.ad.sdk.jad_xk.jad_dq(i2, string2);
                                jad_dqVar2.jad_kv = 1;
                                arrayList.add(jad_dqVar2);
                                cursor.moveToNext();
                            }
                            cursor.close();
                        }
                        if (cursor != null) {
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    try {
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_EVENT_QUERY_ERROR;
                        com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th2.getMessage()));
                    } finally {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            jad_ivVar.jad_cp.addAll(arrayList);
        }
    }
}
