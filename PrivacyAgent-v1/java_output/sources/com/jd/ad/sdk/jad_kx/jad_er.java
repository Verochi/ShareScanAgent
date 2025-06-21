package com.jd.ad.sdk.jad_kx;

/* loaded from: classes23.dex */
public class jad_er {
    public com.jd.ad.sdk.jad_kx.jad_an jad_an;
    public com.jd.ad.sdk.jad_kx.jad_fs jad_bo;
    public com.jd.ad.sdk.jad_pc.jad_an jad_er;
    public int jad_cp = com.anythink.expressad.d.a.b.ck;
    public int jad_dq = 2;
    public int jad_fs = 3;
    public boolean jad_jt = true;

    public static class jad_an {
        public static final com.jd.ad.sdk.jad_kx.jad_er jad_an = new com.jd.ad.sdk.jad_kx.jad_er();
    }

    public int jad_an() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_dq = jad_anVar.jad_ly;
        }
        return this.jad_dq;
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x029f, code lost:
    
        if (r3.isClosed() == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x026c, code lost:
    
        r4 = new com.jd.ad.sdk.jad_kx.jad_cp(r11, r12, r0, r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0273, code lost:
    
        ((java.util.ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_bo).add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x027a, code lost:
    
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x027c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0141, code lost:
    
        r11 = new com.jd.ad.sdk.jad_kx.jad_cp(r3, r27, r10, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014a, code lost:
    
        r12.jad_bo.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014f, code lost:
    
        r17 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0178, code lost:
    
        if (r13.isClosed() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0152, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0153, code lost:
    
        r12 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029b A[Catch: all -> 0x02e1, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:111:0x01ba, B:122:0x029b, B:124:0x02c6, B:131:0x02bf, B:138:0x02d7, B:140:0x02dd, B:141:0x02e0, B:129:0x02a8), top: B:110:0x01ba, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02bf A[Catch: all -> 0x02e1, TRY_ENTER, TryCatch #1 {, blocks: (B:111:0x01ba, B:122:0x029b, B:124:0x02c6, B:131:0x02bf, B:138:0x02d7, B:140:0x02dd, B:141:0x02e0, B:129:0x02a8), top: B:110:0x01ba, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String jad_an(java.lang.String str) {
        android.database.Cursor cursor;
        com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar2;
        com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar3;
        android.database.Cursor cursor2;
        com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar4;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (this.jad_jt) {
            if (this.jad_bo == null) {
                this.jad_bo = com.jd.ad.sdk.jad_kx.jad_fs.jad_an.jad_an;
            }
            com.jd.ad.sdk.jad_kx.jad_fs jad_fsVar = this.jad_bo;
            java.util.Map<java.lang.String, java.util.ArrayList<com.jd.ad.sdk.jad_kx.jad_cp>> map = jad_fsVar.jad_an;
            java.util.ArrayList<com.jd.ad.sdk.jad_kx.jad_cp> arrayList = map != null ? map.get(str) : null;
            if (arrayList != null && arrayList.size() > 0) {
                jad_fsVar.jad_bo.clear();
                jad_fsVar.jad_cp.clear();
                long currentTimeMillis = java.lang.System.currentTimeMillis() - (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo() * 1000);
                java.util.Iterator<com.jd.ad.sdk.jad_kx.jad_cp> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.jd.ad.sdk.jad_kx.jad_cp next = it.next();
                    if (next != null) {
                        int i = next.jad_an;
                        java.lang.String str2 = next.jad_er;
                        java.lang.String str3 = next.jad_dq;
                        java.lang.String str4 = next.jad_bo;
                        if (!android.text.TextUtils.isEmpty(str3) && java.lang.Long.parseLong(str2) >= currentTimeMillis) {
                            com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar5 = new com.jd.ad.sdk.jad_kx.jad_cp(i, str, str4, str3, str2);
                            jad_fsVar.jad_cp.add(str4);
                            it.remove();
                            jad_cpVar3 = jad_cpVar5;
                            break;
                        }
                        jad_fsVar.jad_bo.add(str4);
                        it.remove();
                    }
                }
            }
            jad_cpVar3 = null;
            if (this.jad_an == null) {
                this.jad_an = com.jd.ad.sdk.jad_kx.jad_an.jad_dq();
            }
            this.jad_an.jad_an(this.jad_bo.jad_bo);
            if (jad_cpVar3 != null) {
                this.jad_an.jad_an(this.jad_bo.jad_cp);
                return jad_cpVar3.jad_dq;
            }
            com.jd.ad.sdk.jad_kx.jad_an jad_anVar = this.jad_an;
            if (jad_anVar != null) {
                try {
                    jad_anVar.getReadableDatabase();
                    if (jad_anVar.jad_bo()) {
                        android.database.Cursor cursor3 = jad_anVar.jad_an.query("preloadAd", null, "appIdSlotId =?", new java.lang.String[]{java.lang.String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
                        try {
                            if (cursor3.getCount() > 0) {
                                cursor3.moveToFirst();
                                long currentTimeMillis2 = java.lang.System.currentTimeMillis() - (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo() * 1000);
                                while (true) {
                                    if (cursor3.isAfterLast()) {
                                        jad_cpVar4 = null;
                                        break;
                                    }
                                    int i2 = cursor3.getInt(cursor3.getColumnIndex("_id"));
                                    java.lang.String string = cursor3.getString(cursor3.getColumnIndex("preloadAdCacheTimeStamp"));
                                    java.lang.String string2 = cursor3.getString(cursor3.getColumnIndex("rId"));
                                    java.lang.String jb = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor3.getString(cursor3.getColumnIndex("preloadAdJson")));
                                    if (!android.text.TextUtils.isEmpty(jb) && java.lang.Long.parseLong(string) >= currentTimeMillis2) {
                                        break;
                                    }
                                    ((java.util.ArrayList) com.jd.ad.sdk.jad_kx.jad_an.jad_dq).add(string2);
                                    cursor3.moveToNext();
                                }
                                try {
                                    cursor3.close();
                                    com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_kx.jad_bo(jad_anVar));
                                    jad_cpVar = jad_cpVar4;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    cursor2 = cursor3;
                                    cursor3 = cursor2;
                                    jad_cpVar = jad_cpVar4;
                                    try {
                                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                        com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(th.getMessage()));
                                        if (jad_cpVar == null) {
                                        }
                                    } finally {
                                    }
                                }
                            } else {
                                jad_cpVar = null;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            cursor2 = cursor3;
                            jad_cpVar4 = null;
                            cursor3 = cursor2;
                            jad_cpVar = jad_cpVar4;
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar22 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar22.jad_an, jad_anVar22.jad_an(th.getMessage()));
                            if (jad_cpVar == null) {
                            }
                        }
                    } else {
                        jad_cpVar = null;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    cursor2 = null;
                }
            } else {
                jad_cpVar = jad_cpVar3;
            }
        } else {
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                java.lang.String str5 = com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_preload_ad" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "query" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
                ((java.util.ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_an).clear();
                ((java.util.ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_bo).clear();
                try {
                    android.content.ContentResolver jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                    if (jad_an2 == null) {
                        jad_cpVar = null;
                    } else {
                        cursor = jad_an2.query(android.net.Uri.parse(str5), null, null, null, "preloadAdCacheTimeStamp ASC");
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    long currentTimeMillis3 = java.lang.System.currentTimeMillis() - (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo() * 1000);
                                    cursor.moveToFirst();
                                    while (true) {
                                        if (cursor.isAfterLast()) {
                                            jad_cpVar = null;
                                            break;
                                        }
                                        int i3 = cursor.getInt(cursor.getColumnIndex("_id"));
                                        java.lang.String string3 = cursor.getString(cursor.getColumnIndex("appIdSlotId"));
                                        java.lang.String string4 = cursor.getString(cursor.getColumnIndex("rId"));
                                        java.lang.String string5 = cursor.getString(cursor.getColumnIndex("preloadAdCacheTimeStamp"));
                                        java.lang.String jb2 = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("preloadAdJson")));
                                        if (!android.text.TextUtils.isEmpty(jb2) && java.lang.Long.parseLong(string5) >= currentTimeMillis3) {
                                            break;
                                        }
                                        ((java.util.ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_an).add(string4);
                                        cursor.moveToNext();
                                    }
                                    try {
                                        cursor.close();
                                        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_tg.jad_bo());
                                        if (cursor != null) {
                                        }
                                    } catch (java.lang.Throwable th4) {
                                        th = th4;
                                        jad_cpVar2 = jad_cpVar;
                                        try {
                                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(th.getMessage()));
                                            if (cursor != null || cursor.isClosed()) {
                                                jad_cpVar = jad_cpVar2;
                                                if (jad_cpVar == null) {
                                                }
                                            } else {
                                                jad_cpVar = jad_cpVar2;
                                                cursor.close();
                                                if (jad_cpVar == null) {
                                                }
                                            }
                                        } finally {
                                            if (cursor != null && !cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        }
                                    }
                                }
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                jad_cpVar = null;
                                jad_cpVar2 = jad_cpVar;
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar32 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar32.jad_an, jad_anVar32.jad_an(th.getMessage()));
                                if (cursor != null) {
                                }
                                jad_cpVar = jad_cpVar2;
                                if (jad_cpVar == null) {
                                }
                            }
                        }
                        jad_cpVar = null;
                        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_tg.jad_bo());
                        if (cursor != null) {
                        }
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    cursor = null;
                }
            }
        }
        return jad_cpVar == null ? jad_cpVar.jad_dq : "";
    }

    public int jad_bo() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_cp = jad_anVar.jad_kx;
        }
        return this.jad_cp;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: all -> 0x005c, DONT_GENERATE, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x000d, B:11:0x0011, B:12:0x0015, B:14:0x001f, B:15:0x0025, B:17:0x0030, B:19:0x0044, B:21:0x004a, B:24:0x004e, B:27:0x005a, B:30:0x0036, B:32:0x003a, B:34:0x003f), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean jad_bo(java.lang.String str) {
        java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an2;
        java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> list;
        com.jd.ad.sdk.jad_kx.jad_an jad_anVar;
        boolean z = true;
        if (android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        synchronized (this) {
            if (this.jad_jt) {
                if (this.jad_bo == null) {
                    this.jad_bo = com.jd.ad.sdk.jad_kx.jad_fs.jad_an.jad_an;
                }
                list = this.jad_bo.jad_an(str);
                if (this.jad_an == null) {
                    this.jad_an = com.jd.ad.sdk.jad_kx.jad_an.jad_dq();
                }
                this.jad_an.jad_an(this.jad_bo.jad_bo);
                if ((list == null || list.size() <= 0) && (jad_anVar = this.jad_an) != null) {
                    jad_an2 = jad_anVar.jad_an(str);
                }
                if (jad_an() > 0) {
                    return true;
                }
                if (list == null || list.size() < jad_an()) {
                    z = false;
                }
                return z;
            }
            jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an(str);
            list = jad_an2;
            if (jad_an() > 0) {
            }
        }
    }

    public int jad_cp() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_fs = jad_anVar.jad_mz;
        }
        if (this.jad_fs < 3) {
            this.jad_fs = 3;
        }
        return this.jad_fs;
    }
}
