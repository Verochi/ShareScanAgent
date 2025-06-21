package com.loc;

/* loaded from: classes23.dex */
public final class w {
    private static java.lang.String a() {
        java.lang.String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "pu", "gdh");
            str = null;
        }
        return str == null ? com.igexin.push.core.b.m : str;
    }

    private static java.lang.String a(java.lang.String str) {
        return com.loc.y.c(str);
    }

    public static java.net.Proxy a(android.content.Context context) {
        try {
            return a(context, new java.net.URI("http://restsdk.amap.com"));
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy a(android.content.Context context, java.net.URI uri) {
        java.net.Proxy proxy;
        if (c(context)) {
            try {
                java.util.List<java.net.Proxy> select = java.net.ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null) {
                    return null;
                }
                if (proxy.type() == java.net.Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (java.lang.Throwable th) {
                com.loc.aw.b(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0074, code lost:
    
        if (r10 == (-1)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
    
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
    
        r18 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a6, code lost:
    
        if (r10 == (-1)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0119, code lost:
    
        if (r12 == (-1)) goto L88;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x015c A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #10 {all -> 0x0158, blocks: (B:20:0x014d, B:12:0x015c), top: B:19:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ef A[Catch: all -> 0x0171, TryCatch #8 {all -> 0x0171, blocks: (B:102:0x00ca, B:68:0x00e4, B:70:0x00ef, B:72:0x0103, B:74:0x0109, B:78:0x0115, B:89:0x011e, B:91:0x0124, B:93:0x012a, B:97:0x0136), top: B:4:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013e  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.net.Proxy b(android.content.Context context) {
        android.database.Cursor cursor;
        ?? r10;
        java.lang.String l;
        int i;
        java.lang.Throwable th;
        boolean z;
        boolean z2;
        int i2;
        int b;
        boolean z3;
        boolean z4;
        if (c(context)) {
            android.net.Uri parse = android.net.Uri.parse("content://telephony/carriers/preferapn");
            java.lang.String str = null;
            boolean z5 = false;
            try {
                try {
                    cursor = context.getContentResolver().query(parse, null, null, null, null);
                } finally {
                }
            } catch (java.lang.SecurityException e) {
                e = e;
                cursor = null;
                str = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                cursor = null;
                str = null;
            }
            if (cursor != null) {
                try {
                } catch (java.lang.SecurityException e2) {
                    e = e2;
                    str = null;
                    r10 = -1;
                    com.loc.aw.b(e, "pu", "ghp");
                    l = com.loc.p.l(context);
                    if (l != null) {
                    }
                    if (cursor != null) {
                    }
                    i2 = i;
                    if (str != null) {
                    }
                    if (z5) {
                    }
                    return null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    str = null;
                    r10 = -1;
                    com.loc.aw.b(th, "pu", "gPx1");
                    th.printStackTrace();
                    i2 = r10;
                    if (cursor != null) {
                    }
                    if (str != null) {
                    }
                    if (z5) {
                    }
                    return null;
                }
                if (cursor.moveToFirst()) {
                    java.lang.String string = cursor.getString(cursor.getColumnIndex("apn"));
                    java.lang.String str2 = string;
                    r10 = parse;
                    if (string != null) {
                        java.util.Locale locale = java.util.Locale.US;
                        str2 = string.toLowerCase(locale);
                        r10 = locale;
                    }
                    try {
                        try {
                            if (str2 != null && str2.contains("ctwap")) {
                                java.lang.String a = a();
                                b = b();
                                if (android.text.TextUtils.isEmpty(a) || a.equals(com.igexin.push.core.b.m)) {
                                    str = null;
                                    z4 = false;
                                } else {
                                    str = a;
                                    z4 = true;
                                }
                                if (!z4) {
                                    str = a("QMTAuMC4wLjIwMA==");
                                }
                            } else if (str2 != null && str2.contains("wap")) {
                                java.lang.String a2 = a();
                                b = b();
                                if (android.text.TextUtils.isEmpty(a2) || a2.equals(com.igexin.push.core.b.m)) {
                                    str = null;
                                    z3 = false;
                                } else {
                                    str = a2;
                                    z3 = true;
                                }
                                if (!z3) {
                                    str = a("QMTAuMC4wLjE3Mg==");
                                }
                            }
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (java.lang.Throwable th4) {
                                    th = th4;
                                    com.loc.aw.b(th, "pu", "gPx2");
                                    i2 = i;
                                    if (str != null) {
                                    }
                                    if (z5) {
                                    }
                                    return null;
                                }
                            }
                        } catch (java.lang.SecurityException e3) {
                            e = e3;
                            str = null;
                            com.loc.aw.b(e, "pu", "ghp");
                            l = com.loc.p.l(context);
                            if (l != null) {
                                java.lang.String lowerCase = l.toLowerCase(java.util.Locale.US);
                                java.lang.String a3 = a();
                                int b2 = b();
                                if (lowerCase.indexOf("ctwap") != -1) {
                                    if (android.text.TextUtils.isEmpty(a3) || a3.equals(com.igexin.push.core.b.m)) {
                                        z2 = false;
                                    } else {
                                        str = a3;
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        str = a("QMTAuMC4wLjIwMA==");
                                    }
                                } else {
                                    if (lowerCase.indexOf("wap") != -1) {
                                        if (android.text.TextUtils.isEmpty(a3) || a3.equals(com.igexin.push.core.b.m)) {
                                            z = false;
                                        } else {
                                            str = a3;
                                            z = true;
                                        }
                                        if (!z) {
                                            str = a("QMTAuMC4wLjE3Mg==");
                                        }
                                        i = 80;
                                    }
                                    i = b2;
                                }
                            } else {
                                i = r10;
                            }
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (java.lang.Throwable th5) {
                                    th = th5;
                                    com.loc.aw.b(th, "pu", "gPx2");
                                    i2 = i;
                                    if (str != null) {
                                    }
                                    if (z5) {
                                    }
                                    return null;
                                }
                            }
                            i2 = i;
                            if (str != null) {
                            }
                            if (z5) {
                            }
                            return null;
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            str = null;
                            com.loc.aw.b(th, "pu", "gPx1");
                            th.printStackTrace();
                            i2 = r10;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                    i2 = r10;
                                } catch (java.lang.Throwable th7) {
                                    com.loc.aw.b(th7, "pu", "gPx2");
                                    i2 = r10;
                                }
                            }
                            if (str != null) {
                            }
                            if (z5) {
                            }
                            return null;
                        }
                    } catch (java.lang.SecurityException e4) {
                        e = e4;
                        com.loc.aw.b(e, "pu", "ghp");
                        l = com.loc.p.l(context);
                        if (l != null) {
                        }
                        if (cursor != null) {
                        }
                        i2 = i;
                        if (str != null) {
                        }
                        if (z5) {
                        }
                        return null;
                    } catch (java.lang.Throwable th8) {
                        th = th8;
                        com.loc.aw.b(th, "pu", "gPx1");
                        th.printStackTrace();
                        i2 = r10;
                        if (cursor != null) {
                        }
                        if (str != null) {
                        }
                        if (z5) {
                        }
                        return null;
                    }
                    i2 = i;
                    if (str != null) {
                        try {
                            if (str.length() > 0 && i2 != -1) {
                                z5 = true;
                            }
                        } catch (java.lang.Throwable th9) {
                            com.loc.at.a(th9, "pu", "gp2");
                            th9.printStackTrace();
                        }
                    }
                    if (z5) {
                        return new java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress.createUnresolved(str, i2));
                    }
                }
            }
            str = null;
            i = -1;
            if (cursor != null) {
            }
            i2 = i;
            if (str != null) {
            }
            if (z5) {
            }
        }
        return null;
    }

    private static boolean c(android.content.Context context) {
        return com.loc.p.j(context) == 0;
    }
}
