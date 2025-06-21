package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class bc {
    private static java.util.concurrent.atomic.AtomicLong a = new java.util.concurrent.atomic.AtomicLong(0);
    private static java.text.SimpleDateFormat b;
    private static java.lang.String c;

    static {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd");
        b = simpleDateFormat;
        c = simpleDateFormat.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
    }

    private static com.xiaomi.push.hk a(java.lang.String str, java.lang.String str2, com.xiaomi.push.gn gnVar) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk("-1", false);
        hkVar.i = str;
        hkVar.d = str2;
        com.xiaomi.push.hk a2 = hkVar.a(com.xiaomi.push.c.a(com.xiaomi.push.hv.a(gnVar)));
        a2.e = com.xiaomi.push.gu.UploadTinyData.ah;
        return a2;
    }

    public static synchronized java.lang.String a() {
        java.lang.String str;
        synchronized (com.xiaomi.push.service.bc.class) {
            java.lang.String format = b.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            if (!android.text.TextUtils.equals(c, format)) {
                a.set(0L);
                c = format;
            }
            str = format + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.ArrayList<com.xiaomi.push.hk> a(java.util.List<com.xiaomi.push.go> list, java.lang.String str, java.lang.String str2, int i) {
        int i2;
        java.lang.String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else {
            if (list.size() != 0) {
                java.util.ArrayList<com.xiaomi.push.hk> arrayList = new java.util.ArrayList<>();
                com.xiaomi.push.gn gnVar = new com.xiaomi.push.gn();
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    com.xiaomi.push.go goVar = list.get(i4);
                    if (goVar != null) {
                        java.util.Map<java.lang.String, java.lang.String> map = goVar.j;
                        if (map == null || !map.containsKey("item_size")) {
                            i2 = 0;
                        } else {
                            java.lang.String str4 = goVar.j.get("item_size");
                            if (!android.text.TextUtils.isEmpty(str4)) {
                                try {
                                    i2 = java.lang.Integer.parseInt(str4);
                                } catch (java.lang.Exception unused) {
                                }
                                if (goVar.j.size() != 1) {
                                    goVar.j = null;
                                } else {
                                    goVar.j.remove("item_size");
                                }
                            }
                            i2 = 0;
                            if (goVar.j.size() != 1) {
                            }
                        }
                        if (i2 <= 0) {
                            i2 = com.xiaomi.push.hv.a(goVar).length;
                        }
                        if (i2 > i) {
                            com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + goVar.i);
                        } else {
                            if (i3 + i2 > i) {
                                arrayList.add(a(str, str2, gnVar));
                                gnVar = new com.xiaomi.push.gn();
                                i3 = 0;
                            }
                            if (gnVar.a == null) {
                                gnVar.a = new java.util.ArrayList();
                            }
                            gnVar.a.add(goVar);
                            i3 += i2;
                        }
                    }
                }
                java.util.List<com.xiaomi.push.go> list2 = gnVar.a;
                if ((list2 != null ? list2.size() : 0) != 0) {
                    arrayList.add(a(str, str2, gnVar));
                }
                return arrayList;
            }
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str3);
        return null;
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, long j, java.lang.String str3) {
        com.xiaomi.push.go goVar = new com.xiaomi.push.go();
        goVar.g = str;
        goVar.c = str2;
        goVar.a(j);
        goVar.b = str3;
        goVar.a = "push_sdk_channel";
        goVar.k = context.getPackageName();
        goVar.h = context.getPackageName();
        goVar.a(true);
        goVar.b(java.lang.System.currentTimeMillis());
        goVar.i = a();
        com.xiaomi.push.service.be.a(context, goVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, com.xiaomi.push.service.s sVar) {
        if (sVar == null) {
            return;
        }
        com.xiaomi.push.go goVar = new com.xiaomi.push.go();
        goVar.g = str;
        goVar.c = str2;
        goVar.k = str3;
        goVar.h = str3;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("chid", java.lang.String.valueOf(sVar.a));
        hashMap.put(com.umeng.ccg.a.f, java.lang.String.valueOf(sVar.c));
        hashMap.put(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI, java.lang.String.valueOf(sVar.d));
        hashMap.put("rx_msg", java.lang.String.valueOf(sVar.e));
        hashMap.put("enqueue", java.lang.String.valueOf(sVar.f));
        hashMap.put("num", java.lang.String.valueOf(sVar.b));
        hashMap.put("run", java.lang.String.valueOf(sVar.g));
        hashMap.put("send", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        goVar.j = hashMap;
        com.xiaomi.push.service.be.a(goVar);
    }

    public static boolean a(com.xiaomi.push.go goVar, boolean z) {
        java.lang.String str;
        if (goVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && android.text.TextUtils.isEmpty(goVar.a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (android.text.TextUtils.isEmpty(goVar.g)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (android.text.TextUtils.isEmpty(goVar.c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!com.xiaomi.push.ao.d(goVar.g)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (com.xiaomi.push.ao.d(goVar.c)) {
            java.lang.String str2 = goVar.b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + goVar.b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        } else {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
        return true;
    }

    public static boolean a(java.lang.String str) {
        return !com.xiaomi.push.jc.d() || com.xiaomi.mipush.sdk.Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
