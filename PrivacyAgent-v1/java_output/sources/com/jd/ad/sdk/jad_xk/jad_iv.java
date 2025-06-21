package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_iv implements com.jd.ad.sdk.jad_zm.jad_ly.jad_an {
    public java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> jad_cp;
    public com.jd.ad.sdk.jad_xk.jad_cp jad_dq;
    public java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> jad_er;
    public final java.util.concurrent.atomic.AtomicBoolean jad_an = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final java.util.concurrent.atomic.AtomicInteger jad_bo = new java.util.concurrent.atomic.AtomicInteger(1);
    public boolean jad_fs = true;
    public java.lang.String jad_jt = "";

    public class jad_an implements java.lang.Runnable {
        public final /* synthetic */ org.json.JSONObject jad_an;

        public jad_an(org.json.JSONObject jSONObject) {
            this.jad_an = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.content.ContentResolver jad_an;
            com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar;
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("event: ");
            jad_an2.append(this.jad_an);
            com.jd.ad.sdk.logger.Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_xk.jad_iv jad_ivVar = com.jd.ad.sdk.jad_xk.jad_iv.this;
            com.jd.ad.sdk.jad_xk.jad_dq jad_an3 = com.jd.ad.sdk.jad_xk.jad_iv.jad_an(this.jad_an);
            com.jd.ad.sdk.jad_xk.jad_iv.this.getClass();
            com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            java.lang.String str = (jad_cp == null || (jad_dqVar = jad_cp.jad_bo) == null) ? "" : jad_dqVar.jad_an;
            if (jad_ivVar.jad_cp == null) {
                jad_ivVar.jad_cp = new java.util.concurrent.ConcurrentLinkedQueue<>();
            }
            if (jad_ivVar.jad_er == null) {
                jad_ivVar.jad_er = new java.util.concurrent.ConcurrentLinkedQueue<>();
            }
            jad_ivVar.jad_cp.add(jad_an3);
            if (jad_ivVar.jad_fs) {
                com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar = jad_ivVar.jad_dq;
                if (jad_cpVar != null) {
                    jad_cpVar.jad_an(jad_an3, jad_ivVar.jad_jt);
                }
            } else {
                java.lang.String str2 = jad_ivVar.jad_jt;
                synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                    java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        try {
                            if (!android.text.TextUtils.isEmpty(jad_an3.jad_an().toString()) && (jad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an()) != null) {
                                android.net.Uri parse = android.net.Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_event" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "update");
                                android.content.ContentValues contentValues = new android.content.ContentValues();
                                contentValues.put("event", jad_an3.jad_an().toString());
                                contentValues.put(com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME, str2);
                                contentValues.put("key", java.lang.Integer.valueOf(jad_an3.jad_an));
                                jad_an.update(parse, contentValues, null, null);
                            }
                        } catch (java.lang.Exception e) {
                            com.jd.ad.sdk.logger.Logger.w("Exception while multi process saving events: ", e.getMessage());
                        }
                    }
                }
            }
            if (jad_ivVar.jad_cp.size() >= jad_ivVar.jad_bo.get()) {
                jad_ivVar.jad_an(str);
            }
        }
    }

    public class jad_bo implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String[] jad_an;

        public jad_bo(java.lang.String[] strArr) {
            this.jad_an = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.jd.ad.sdk.jad_zm.jad_fs jad_an = com.jd.ad.sdk.jad_xk.jad_jt.jad_an();
                for (int i = 0; i < this.jad_an.length; i++) {
                    com.jd.ad.sdk.jad_zm.jad_ly.jad_bo jad_an2 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
                    jad_an2.jad_er = this.jad_an[i];
                    jad_an2.jad_bo = jad_an;
                    jad_an2.jad_cp = 50000;
                    jad_an2.jad_dq = 100000;
                    jad_an2.jad_jt = com.jd.ad.sdk.jad_xk.jad_iv.this;
                    jad_an2.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
                }
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.w("Exception while gw event: ", e.getMessage());
            }
        }
    }

    public static class jad_cp {
        public static final com.jd.ad.sdk.jad_xk.jad_iv jad_an = new com.jd.ad.sdk.jad_xk.jad_iv();
    }

    public static com.jd.ad.sdk.jad_xk.jad_dq jad_an(java.lang.String str, int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 5);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "extp", 1);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.anythink.expressad.d.a.b.dy, java.lang.Integer.valueOf(com.jd.ad.sdk.jad_wj.jad_an.CRASH_ERROR.jad_an));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "erin", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "crt", java.lang.Integer.valueOf(i));
        return jad_an(jSONObject);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:75:0x03ad
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0405 A[Catch: Exception -> 0x0403, TryCatch #18 {Exception -> 0x0403, blocks: (B:84:0x03fd, B:103:0x0405, B:105:0x040d, B:106:0x0414), top: B:83:0x03fd }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03e2 A[Catch: Exception -> 0x03e0, TryCatch #10 {Exception -> 0x03e0, blocks: (B:77:0x03da, B:113:0x03e2, B:115:0x03ea, B:116:0x03f1), top: B:76:0x03da }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03af A[Catch: Exception -> 0x03ad, TryCatch #1 {Exception -> 0x03ad, blocks: (B:70:0x03a7, B:123:0x03af, B:125:0x03b7, B:126:0x03bc), top: B:69:0x03a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x038e A[Catch: Exception -> 0x038c, TryCatch #3 {Exception -> 0x038c, blocks: (B:65:0x0386, B:135:0x038e, B:137:0x0396, B:138:0x039d), top: B:64:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0352 A[Catch: Exception -> 0x0376, TryCatch #8 {Exception -> 0x0376, blocks: (B:58:0x034b, B:148:0x0352, B:150:0x035a, B:151:0x035f, B:157:0x036d), top: B:57:0x034b }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0312 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0427 A[Catch: Exception -> 0x043e, TryCatch #11 {Exception -> 0x043e, blocks: (B:89:0x0420, B:96:0x0427, B:98:0x042f, B:99:0x0437), top: B:88:0x0420 }] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v69, types: [int] */
    /* JADX WARN: Type inference failed for: r14v70, types: [int] */
    /* JADX WARN: Type inference failed for: r14v71, types: [int] */
    /* JADX WARN: Type inference failed for: r14v72 */
    /* JADX WARN: Type inference failed for: r14v73 */
    /* JADX WARN: Type inference failed for: r14v74 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.jd.ad.sdk.jad_xk.jad_dq jad_an(org.json.JSONObject r14) {
        /*
            Method dump skipped, instructions count: 1227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xk.jad_iv.jad_an(org.json.JSONObject):com.jd.ad.sdk.jad_xk.jad_dq");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if (r1.inTransaction() != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
    
        r0.jad_an.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00aa, code lost:
    
        if (r1.inTransaction() != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_an() {
        android.content.ContentResolver jad_an2;
        if (this.jad_er.isEmpty()) {
            return;
        }
        java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> concurrentLinkedQueue = this.jad_cp;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.removeAll(this.jad_er);
        }
        if (this.jad_fs) {
            com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar = this.jad_dq;
            if (jad_cpVar != null) {
                java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> concurrentLinkedQueue2 = this.jad_er;
                synchronized (jad_cpVar) {
                    try {
                        try {
                            jad_cpVar.getWritableDatabase();
                            if (jad_cpVar.jad_bo()) {
                                jad_cpVar.jad_an.beginTransaction();
                                java.util.Iterator<com.jd.ad.sdk.jad_xk.jad_dq> it = concurrentLinkedQueue2.iterator();
                                while (it.hasNext()) {
                                    com.jd.ad.sdk.jad_xk.jad_dq next = it.next();
                                    int i = next.jad_an;
                                    if (i > 0) {
                                        jad_cpVar.jad_an.delete("events", "_id=?", new java.lang.String[]{java.lang.String.valueOf(i)});
                                    } else {
                                        jad_cpVar.jad_an.delete("events", "event=?", new java.lang.String[]{com.jd.ad.sdk.fdt.utils.ANEProxy.ja(next.jad_an().toString())});
                                    }
                                }
                                jad_cpVar.jad_an.setTransactionSuccessful();
                                android.database.sqlite.SQLiteDatabase sQLiteDatabase = jad_cpVar.jad_an;
                                if (sQLiteDatabase != null) {
                                }
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    } catch (java.lang.Throwable th) {
                        try {
                            com.jd.ad.sdk.logger.Logger.w("Exception while clearing events: ", th.getMessage());
                            android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = jad_cpVar.jad_an;
                            if (sQLiteDatabase2 != null) {
                            }
                        } finally {
                            android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = jad_cpVar.jad_an;
                            if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                                jad_cpVar.jad_an.endTransaction();
                            }
                        }
                    }
                }
            }
        } else {
            java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> concurrentLinkedQueue3 = this.jad_er;
            java.lang.String str = this.jad_jt;
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
                try {
                    if (!android.text.TextUtils.isEmpty(str) && concurrentLinkedQueue3 != null && concurrentLinkedQueue3.size() != 0 && (jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an()) != null) {
                        android.net.Uri parse = android.net.Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_event" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "remove");
                        java.util.Iterator<com.jd.ad.sdk.jad_xk.jad_dq> it2 = concurrentLinkedQueue3.iterator();
                        while (it2.hasNext()) {
                            com.jd.ad.sdk.jad_xk.jad_dq next2 = it2.next();
                            int i2 = next2.jad_an;
                            if (i2 > 0) {
                                jad_an2.delete(parse, "_id=?", new java.lang.String[]{java.lang.String.valueOf(i2)});
                            } else {
                                jad_an2.delete(parse, "event=?", new java.lang.String[]{com.jd.ad.sdk.fdt.utils.ANEProxy.ja(next2.jad_an().toString())});
                            }
                        }
                    }
                } catch (java.lang.Exception e2) {
                    com.jd.ad.sdk.logger.Logger.w("Exception while multi process clearing events: ", e2.getMessage());
                }
            }
        }
        this.jad_er.clear();
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
    public void jad_an(int i, java.lang.String str) {
        this.jad_an.set(false);
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
    public void jad_an(com.jd.ad.sdk.jad_zm.jad_mz jad_mzVar) {
        com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar;
        this.jad_an.set(false);
        if (this.jad_cp.size() >= this.jad_bo.get()) {
            com.jd.ad.sdk.jad_pc.jad_cp jad_cp2 = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            jad_an((jad_cp2 == null || (jad_dqVar = jad_cp2.jad_bo) == null) ? "" : jad_dqVar.jad_an);
        }
    }

    public final synchronized void jad_an(java.lang.String str) {
        java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> concurrentLinkedQueue;
        try {
            concurrentLinkedQueue = this.jad_cp;
        } catch (java.lang.Exception unused) {
            this.jad_an.set(false);
        }
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty() && !this.jad_an.get()) {
            if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
                return;
            }
            this.jad_an.set(true);
            java.util.Iterator<com.jd.ad.sdk.jad_xk.jad_dq> it = this.jad_cp.iterator();
            for (int i = 0; i < this.jad_bo.get(); i++) {
                if (it.hasNext()) {
                    this.jad_er.add(it.next());
                }
            }
            if (this.jad_er.isEmpty()) {
                return;
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            byte[] jad_an2 = com.jd.ad.sdk.jad_xk.jad_jt.jad_an(this.jad_er);
            if (jad_an2 == null) {
                return;
            }
            com.jd.ad.sdk.jad_zm.jad_er jad_erVar = new com.jd.ad.sdk.jad_zm.jad_er(jad_an2);
            com.jd.ad.sdk.jad_zm.jad_fs jad_an3 = com.jd.ad.sdk.jad_xk.jad_jt.jad_an();
            com.jd.ad.sdk.jad_zm.jad_ly.jad_bo jad_an4 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
            jad_an4.jad_er = str;
            jad_an4.jad_fs = jad_erVar;
            jad_an4.jad_bo = jad_an3;
            jad_an4.jad_cp = 50000;
            jad_an4.jad_dq = 100000;
            jad_an4.jad_jt = this;
            jad_an4.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
            jad_an();
        }
    }

    public void jad_an(java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        com.jd.ad.sdk.jad_xk.jad_er.jad_an.execute(new com.jd.ad.sdk.jad_xk.jad_iv.jad_bo(strArr));
    }

    public void jad_bo(org.json.JSONObject jSONObject) {
        com.jd.ad.sdk.jad_xk.jad_er.jad_an.execute(new com.jd.ad.sdk.jad_xk.jad_iv.jad_an(jSONObject));
    }
}
