package com.getui.gtc.f;

/* loaded from: classes22.dex */
public final class b {
    private static final com.getui.gtc.f.b c = new com.getui.gtc.f.b();
    public final java.util.List<com.getui.gtc.api.OnDycEnableChangedListener> a = new java.util.ArrayList();
    public final java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);

    private b() {
    }

    public static com.getui.gtc.f.b a() {
        return c;
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.Boolean> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] strArr = {com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.K, com.getui.gtc.extension.distribution.gbd.f.e.b.L};
        for (int i = 0; i < 4; i++) {
            java.lang.Boolean bool = map.get(strArr[i]);
            sb.append((bool == null || !bool.booleanValue()) ? "0" : "1");
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static java.util.Map<java.lang.String, java.lang.Boolean> b(java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.HashMap hashMap;
        java.lang.String str;
        java.lang.String[] strArr;
        int i;
        int i2;
        java.util.HashMap hashMap2;
        java.lang.String str2 = com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
        java.util.HashMap hashMap3 = new java.util.HashMap();
        try {
            java.lang.String str3 = map.get("sdk.gtc.dim.sys.call.enable");
            if (!android.text.TextUtils.isEmpty(str3)) {
                java.lang.String[] split = str3.split(",");
                int length = split.length;
                char c2 = 0;
                int i3 = 0;
                while (i3 < length) {
                    java.lang.String str4 = split[i3];
                    if (str4.contains(str2)) {
                        java.lang.String[] split2 = str4.split(str2);
                        java.lang.String str5 = split2[c2];
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        char c3 = 2;
                        java.lang.String encodeToString = android.util.Base64.encodeToString(str5.getBytes(), 2);
                        switch (encodeToString.hashCode()) {
                            case -2095750756:
                                if (encodeToString.equals("Y2VsbF9pbmZvX25ldw==")) {
                                    c3 = '(';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -2048226647:
                                if (encodeToString.equals("bmV0d29yaw==")) {
                                    c3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1779042063:
                                if (encodeToString.equals("b2FpZF9ob25vcg==")) {
                                    c3 = 17;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1767879989:
                                if (encodeToString.equals("bWFudWZhY3R1cmVy")) {
                                    c3 = 23;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1762514687:
                                if (encodeToString.equals("b2FpZA==")) {
                                    c3 = 16;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1659575288:
                                if (encodeToString.equals("d2lmaV9pbmZvX2d0")) {
                                    c3 = '%';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1559644363:
                                if (encodeToString.equals("Z2V0dWlfZGV2aWNlX2lk")) {
                                    c3 = '.';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1464199328:
                                if (encodeToString.equals("aWNjaWRfbWFpbg==")) {
                                    c3 = '\t';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1400038172:
                                if (encodeToString.equals("bWFjX3dsYW4w")) {
                                    c3 = '\r';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1337142239:
                                if (encodeToString.equals("aW1laQ==")) {
                                    c3 = 0;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1337139108:
                                if (encodeToString.equals("aW1laTE=")) {
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1337138984:
                                if (encodeToString.equals("aW1laTI=")) {
                                    c3 = 3;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1324212945:
                                if (encodeToString.equals("aW1zaQ==")) {
                                    c3 = 4;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1324209814:
                                if (encodeToString.equals("aW1zaTE=")) {
                                    c3 = 6;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1324209690:
                                if (encodeToString.equals("aW1zaTI=")) {
                                    c3 = 7;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1218674678:
                                if (encodeToString.equals("YWR2ZXJ0aXNpbmdfaWQ=")) {
                                    c3 = 19;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1217318981:
                                if (encodeToString.equals("d2lmaV9zY2FuX2xpc3Q=")) {
                                    c3 = '#';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1033769178:
                                if (encodeToString.equals("c2VyaWFsX251bWJlcg==")) {
                                    c3 = 15;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -997367387:
                                if (encodeToString.equals("bG9jYXRpb25fZ3Bz")) {
                                    c3 = 30;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -814408606:
                                if (encodeToString.equals("d2lmaV9pbmZv")) {
                                    c3 = kotlin.text.Typography.quote;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -811004243:
                                if (encodeToString.equals("d2lmaV9tYWM=")) {
                                    c3 = kotlin.text.Typography.dollar;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -508737516:
                                if (encodeToString.equals("aWNjaWQ=")) {
                                    c3 = '\b';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -508737457:
                                if (encodeToString.equals("aWNjaWQx")) {
                                    c3 = '\n';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -508737456:
                                if (encodeToString.equals("aWNjaWQy")) {
                                    c3 = 11;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -367876355:
                                if (encodeToString.equals("bG9jYXRpb25fbmV0d29yaw==")) {
                                    c3 = 31;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -17088614:
                                if (encodeToString.equals("aXB2NA==")) {
                                    c3 = 28;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -17052096:
                                if (encodeToString.equals("aXB2Ng==")) {
                                    c3 = 29;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 2976371:
                                if (encodeToString.equals("aXA=")) {
                                    c3 = 27;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 3001790:
                                if (encodeToString.equals("c3lz")) {
                                    c3 = 24;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 3005401:
                                if (encodeToString.equals("bWFj")) {
                                    c3 = '\f';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 3055941:
                                if (encodeToString.equals("cm9t")) {
                                    c3 = 22;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 79802473:
                                if (encodeToString.equals("YXBwX2xpc3RfYnlfbG9jYWxfZGlycw==")) {
                                    c3 = '+';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 142694456:
                                if (encodeToString.equals("YXBwX2xpc3RfYnlfY29tcGxleF9wb2xpY3k=")) {
                                    c3 = '-';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 193136789:
                                if (encodeToString.equals("Y2VsbA==")) {
                                    c3 = kotlin.text.Typography.amp;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 261839736:
                                if (encodeToString.equals("Y2VsbF9pbmZv")) {
                                    c3 = '\'';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 308427546:
                                if (encodeToString.equals("Y2Fycmllcg==")) {
                                    c3 = 25;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 372428747:
                                if (encodeToString.equals("bG9jYXRpb25fZ3BzX2d0")) {
                                    c3 = '!';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 633576810:
                                if (encodeToString.equals("bW9kZWw=")) {
                                    c3 = 21;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1148798111:
                                if (encodeToString.equals("bWFjX2FsbA==")) {
                                    c3 = 14;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1196833449:
                                if (encodeToString.equals("bG9jYXRpb25fbmV0d29ya19ndA==")) {
                                    c3 = ' ';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1321129970:
                                if (encodeToString.equals("YXBwX2xpc3RfYnlfcXVlcnlfaW50ZW50")) {
                                    c3 = ')';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1396586978:
                                if (encodeToString.equals("YXBwX2xpc3RfYnlfcG1fbGlzdA==")) {
                                    c3 = ',';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1444607276:
                                if (encodeToString.equals("YXBwX2xpc3RfYnlfaW5zdGFsbGVkX3BhY2thZ2U=")) {
                                    c3 = '*';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1550084458:
                                if (encodeToString.equals("YnJhbmQ=")) {
                                    c3 = 20;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1550874440:
                                if (encodeToString.equals("aW1laV9tYWlu")) {
                                    c3 = 1;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1846142911:
                                if (encodeToString.equals("YW5kcm9pZF9pZA==")) {
                                    c3 = 18;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 2016315734:
                                if (encodeToString.equals("aW1zaV9tYWlu")) {
                                    c3 = 5;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            default:
                                c3 = 65535;
                                break;
                        }
                        str = str2;
                        java.lang.String str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.m;
                        strArr = split;
                        i = length;
                        i2 = i3;
                        java.util.HashMap hashMap4 = hashMap3;
                        switch (c3) {
                            case 0:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.b);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.c);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.d);
                                break;
                            case 1:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.b);
                                break;
                            case 2:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.c;
                                arrayList.add(str6);
                                break;
                            case 3:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.d);
                                break;
                            case 4:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.e);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.f);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.g);
                                break;
                            case 5:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.e);
                                break;
                            case 6:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.f);
                                break;
                            case 7:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.g);
                                break;
                            case '\b':
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.m);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.n);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.o);
                                break;
                            case '\t':
                                arrayList.add(str6);
                                break;
                            case '\n':
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.n);
                                break;
                            case 11:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.o);
                                break;
                            case '\f':
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.h);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.i);
                                break;
                            case '\r':
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.h);
                                break;
                            case 14:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.i);
                                break;
                            case 15:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.j;
                                arrayList.add(str6);
                                break;
                            case 16:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.k;
                                arrayList.add(str6);
                                break;
                            case 17:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.l;
                                arrayList.add(str6);
                                break;
                            case 18:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.p;
                                arrayList.add(str6);
                                break;
                            case 19:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.q;
                                arrayList.add(str6);
                                break;
                            case 20:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.r;
                                arrayList.add(str6);
                                break;
                            case 21:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.f330s;
                                arrayList.add(str6);
                                break;
                            case 22:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.t;
                                arrayList.add(str6);
                                break;
                            case 23:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.u;
                                arrayList.add(str6);
                                break;
                            case 24:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.v;
                                arrayList.add(str6);
                                break;
                            case 25:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.w;
                                arrayList.add(str6);
                                break;
                            case 26:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.x;
                                arrayList.add(str6);
                                break;
                            case 27:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.y);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.z);
                                break;
                            case 28:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.y);
                                break;
                            case 29:
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.z);
                                break;
                            case 30:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.A;
                                arrayList.add(str6);
                                break;
                            case 31:
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.B;
                                arrayList.add(str6);
                                break;
                            case ' ':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.D;
                                arrayList.add(str6);
                                break;
                            case '!':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.C;
                                arrayList.add(str6);
                                break;
                            case '\"':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.E;
                                arrayList.add(str6);
                                break;
                            case '#':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.F;
                                arrayList.add(str6);
                                break;
                            case '$':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.G;
                                arrayList.add(str6);
                                break;
                            case '%':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.H;
                                arrayList.add(str6);
                                break;
                            case '&':
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.I);
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.J);
                                break;
                            case '\'':
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.I);
                                break;
                            case '(':
                                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.J);
                                break;
                            case ')':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.K;
                                arrayList.add(str6);
                                break;
                            case '*':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.L;
                                arrayList.add(str6);
                                break;
                            case '+':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.M;
                                arrayList.add(str6);
                                break;
                            case ',':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.O;
                                arrayList.add(str6);
                                break;
                            case '-':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.N;
                                arrayList.add(str6);
                                break;
                            case '.':
                                str6 = com.getui.gtc.extension.distribution.gbd.f.e.b.P;
                                arrayList.add(str6);
                                break;
                        }
                        try {
                            int parseInt = java.lang.Integer.parseInt(split2[1]);
                            java.util.Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                hashMap = hashMap4;
                                try {
                                    hashMap.put((java.lang.String) it.next(), java.lang.Boolean.valueOf(parseInt != 0));
                                    hashMap4 = hashMap;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    com.getui.gtc.h.c.a.b(th);
                                    return hashMap;
                                }
                            }
                            hashMap2 = hashMap4;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            hashMap = hashMap4;
                        }
                    } else {
                        str = str2;
                        strArr = split;
                        i = length;
                        i2 = i3;
                        hashMap2 = hashMap3;
                        hashMap2.put("dim-2-2-0-1", java.lang.Boolean.valueOf(java.lang.Integer.parseInt(str4) != 0));
                    }
                    hashMap3 = hashMap2;
                    split = strArr;
                    length = i;
                    c2 = 0;
                    i3 = i2 + 1;
                    str2 = str;
                }
            }
            return hashMap3;
        } catch (java.lang.Throwable th3) {
            th = th3;
            hashMap = hashMap3;
        }
    }

    public final void a(com.getui.gtc.api.OnDycEnableChangedListener onDycEnableChangedListener) {
        if (this.b.get() || onDycEnableChangedListener == null) {
            return;
        }
        synchronized (this.a) {
            this.a.add(onDycEnableChangedListener);
        }
    }
}
