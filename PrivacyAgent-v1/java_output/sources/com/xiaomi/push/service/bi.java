package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class bi {
    public static com.xiaomi.push.hw a(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.hw hwVar = null;
        if (hhVar.b) {
            return null;
        }
        byte[] a = hhVar.a();
        com.xiaomi.push.gk gkVar = hhVar.a;
        boolean z = hhVar.c;
        switch (com.xiaomi.push.service.bj.a[gkVar.ordinal()]) {
            case 1:
                hwVar = new com.xiaomi.push.hm();
                break;
            case 2:
                hwVar = new com.xiaomi.push.hs();
                break;
            case 3:
                hwVar = new com.xiaomi.push.hq();
                break;
            case 4:
                hwVar = new com.xiaomi.push.hu();
                break;
            case 5:
                hwVar = new com.xiaomi.push.ho();
                break;
            case 6:
                hwVar = new com.xiaomi.push.ha();
                break;
            case 7:
                hwVar = new com.xiaomi.push.hg();
                break;
            case 8:
                hwVar = new com.xiaomi.push.hn();
                break;
            case 9:
                if (!z) {
                    com.xiaomi.push.hc hcVar = new com.xiaomi.push.hc();
                    hcVar.b();
                    hwVar = hcVar;
                    break;
                } else {
                    hwVar = new com.xiaomi.push.hk();
                    break;
                }
            case 10:
                hwVar = new com.xiaomi.push.hg();
                break;
        }
        if (hwVar != null) {
            com.xiaomi.push.hv.a(hwVar, a);
        }
        return hwVar;
    }
}
