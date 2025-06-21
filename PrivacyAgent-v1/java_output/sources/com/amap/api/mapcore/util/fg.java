package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fg {
    private static java.lang.String a() {
        java.lang.String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "pu", "gdh");
            str = null;
        }
        return str == null ? com.igexin.push.core.b.m : str;
    }

    private static java.lang.String a(java.lang.String str) {
        return com.amap.api.mapcore.util.fi.c(str);
    }

    public static java.net.Proxy a(android.content.Context context) {
        try {
            return a(context, new java.net.URI("http://restsdk.amap.com"));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "pu", "gp");
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
                com.amap.api.mapcore.util.gd.c(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0074, code lost:
    
        if (r10 == (-1)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0076, code lost:
    
        r18 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0079, code lost:
    
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ab, code lost:
    
        if (r10 == (-1)) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0159 A[Catch: all -> 0x0155, TRY_LEAVE, TryCatch #9 {all -> 0x0155, blocks: (B:20:0x014a, B:12:0x0159), top: B:19:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ef A[Catch: all -> 0x016e, TryCatch #2 {all -> 0x016e, blocks: (B:100:0x00ca, B:66:0x00e4, B:68:0x00ef, B:70:0x0103, B:72:0x0109, B:76:0x0115, B:88:0x011c, B:90:0x0122, B:92:0x0128, B:96:0x0134), top: B:4:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013b  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
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
        java.lang.String o;
        int i;
        int i2;
        boolean z;
        boolean z2;
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
            } catch (java.lang.Throwable th) {
                th = th;
                cursor = null;
                str = null;
            }
            if (cursor != null) {
                try {
                } catch (java.lang.SecurityException e2) {
                    e = e2;
                    str = null;
                    r10 = -1;
                    com.amap.api.mapcore.util.gd.c(e, "pu", "ghp");
                    o = com.amap.api.mapcore.util.ez.o(context);
                    if (o != null) {
                    }
                    if (cursor != null) {
                    }
                    i2 = i;
                    if (str != null) {
                    }
                    if (z5) {
                    }
                    return null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    str = null;
                    r10 = -1;
                    com.amap.api.mapcore.util.gd.c(th, "pu", "gPx1");
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
                                } catch (java.lang.Throwable th3) {
                                    com.amap.api.mapcore.util.gd.c(th3, "pu", "gPx2");
                                }
                            }
                            i2 = r18;
                        } catch (java.lang.SecurityException e3) {
                            e = e3;
                            com.amap.api.mapcore.util.gd.c(e, "pu", "ghp");
                            o = com.amap.api.mapcore.util.ez.o(context);
                            if (o != null) {
                                java.lang.String lowerCase = o.toLowerCase(java.util.Locale.US);
                                java.lang.String a3 = a();
                                i = b();
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
                                    if (i == -1) {
                                        i = 80;
                                    }
                                } else if (lowerCase.indexOf("wap") != -1) {
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
                            } else {
                                i = r10;
                            }
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (java.lang.Throwable th4) {
                                    com.amap.api.mapcore.util.gd.c(th4, "pu", "gPx2");
                                }
                            }
                            i2 = i;
                            if (str != null) {
                            }
                            if (z5) {
                            }
                            return null;
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            com.amap.api.mapcore.util.gd.c(th, "pu", "gPx1");
                            th.printStackTrace();
                            i2 = r10;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                    i2 = r10;
                                } catch (java.lang.Throwable th6) {
                                    com.amap.api.mapcore.util.gd.c(th6, "pu", "gPx2");
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
                        str = null;
                        com.amap.api.mapcore.util.gd.c(e, "pu", "ghp");
                        o = com.amap.api.mapcore.util.ez.o(context);
                        if (o != null) {
                        }
                        if (cursor != null) {
                        }
                        i2 = i;
                        if (str != null) {
                        }
                        if (z5) {
                        }
                        return null;
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        str = null;
                        com.amap.api.mapcore.util.gd.c(th, "pu", "gPx1");
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
                    if (str != null) {
                        try {
                            if (str.length() > 0 && i2 != -1) {
                                z5 = true;
                            }
                        } catch (java.lang.Throwable th8) {
                            com.amap.api.mapcore.util.ga.a(th8, "pu", "gp2");
                            th8.printStackTrace();
                        }
                    }
                    if (z5) {
                        return new java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress.createUnresolved(str, i2));
                    }
                }
            }
            str = null;
            int i3 = -1;
            if (cursor != null) {
            }
            i2 = i3;
            if (str != null) {
            }
            if (z5) {
            }
        }
        return null;
    }

    private static boolean c(android.content.Context context) {
        return com.amap.api.mapcore.util.ez.n(context) == 0;
    }
}
