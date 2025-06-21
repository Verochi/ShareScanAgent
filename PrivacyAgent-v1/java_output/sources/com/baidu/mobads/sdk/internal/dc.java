package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class dc {
    public static final java.lang.String a = "error_message";
    public static final java.lang.String b = "error_code";
    private static volatile com.baidu.mobads.sdk.internal.dc d;
    protected final com.baidu.mobads.sdk.internal.bt c = com.baidu.mobads.sdk.internal.bt.a();

    private dc() {
    }

    public static com.baidu.mobads.sdk.internal.dc a() {
        if (d == null) {
            synchronized (com.baidu.mobads.sdk.internal.dc.class) {
                if (d == null) {
                    d = new com.baidu.mobads.sdk.internal.dc();
                }
            }
        }
        return d;
    }

    public java.lang.String a(com.baidu.mobads.sdk.internal.bp bpVar, java.lang.String str) {
        if (bpVar == null) {
            return "";
        }
        return a(bpVar.b() + "", bpVar.c(), str);
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:9:0x0026
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L27
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L19
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L26
            com.baidu.mobads.sdk.internal.bp r5 = (com.baidu.mobads.sdk.internal.bp) r5     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L26
            goto L28
        L19:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L27
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L26
            goto L28
        L26:
        L27:
            r5 = r2
        L28:
            if (r5 != 0) goto L2b
            goto L2c
        L2b:
            r2 = r5
        L2c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dc.a(java.util.Map):java.lang.String");
    }
}
