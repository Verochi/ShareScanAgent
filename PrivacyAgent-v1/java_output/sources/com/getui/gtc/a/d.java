package com.getui.gtc.a;

/* loaded from: classes22.dex */
public final class d implements com.getui.gtc.a.b {
    private java.lang.String a;
    private boolean b = true;
    private long c = 10000;

    @Override // java.lang.Runnable
    public final void run() {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        com.getui.gtc.e.c cVar3;
        com.getui.gtc.e.c cVar4;
        com.getui.gtc.e.c cVar5;
        com.getui.gtc.e.c cVar6;
        com.getui.gtc.e.c cVar7;
        com.getui.gtc.h.d.b unused;
        java.util.Map<java.lang.String, java.lang.String> a = com.getui.gtc.f.c.a(null);
        if (a != null && a.size() > 0) {
            try {
                if (a.containsKey("sdk.gtc.type301.enable")) {
                    this.b = java.lang.Boolean.parseBoolean(a.get("sdk.gtc.type301.enable"));
                }
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.b(e);
            }
            try {
                if (a.containsKey("sdk.gtc.type301.interval")) {
                    this.c = java.lang.Long.parseLong(a.get("sdk.gtc.type301.interval")) * 1000;
                }
            } catch (java.lang.Exception e2) {
                com.getui.gtc.h.c.a.b(e2);
            }
        }
        if (!this.b) {
            com.getui.gtc.h.c.a.b("type 301 is not enabled");
            return;
        }
        cVar = com.getui.gtc.e.c.a.a;
        java.lang.String str = cVar.a.a;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                java.lang.String[] split = str.split("\n");
                if (java.lang.System.currentTimeMillis() - new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA).parse(split[0].split("\\|")[0]).getTime() > 604800000 || split.length > 300) {
                    cVar2 = com.getui.gtc.e.c.a.a;
                    cVar2.a.d("");
                    com.getui.gtc.h.c.a.a("type 301 clean stored samples");
                }
            } catch (java.lang.Exception e3) {
                com.getui.gtc.h.c.a.b("type 301 clean samples error: " + e3.toString());
            }
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.getui.gtc.a.a.a(simpleDateFormat.format(new java.util.Date())));
        sb.append("|");
        sb.append(com.getui.gtc.a.a.a(com.getui.gtc.c.b.d));
        sb.append("|");
        sb.append(com.getui.gtc.a.a.a(com.getui.gtc.c.b.a));
        sb.append("|android|");
        unused = com.getui.gtc.h.d.b.C0330b.a;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        double d = (calendar.get(15) + calendar.get(16)) / 3600000.0d;
        java.text.NumberFormat numberInstance = java.text.NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        sb.append(com.getui.gtc.a.a.a(numberInstance.format(d)));
        java.lang.String sb2 = sb.toString();
        cVar3 = com.getui.gtc.e.c.a.a;
        com.getui.gtc.e.d dVar = cVar3.a;
        if (!android.text.TextUtils.isEmpty(sb2)) {
            if (!android.text.TextUtils.isEmpty(dVar.a)) {
                sb2 = dVar.a + "\n" + sb2;
            }
            if (dVar.a(7, sb2)) {
                dVar.a = sb2;
            }
        }
        cVar4 = com.getui.gtc.e.c.a.a;
        this.a = cVar4.a.a;
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            cVar5 = com.getui.gtc.e.c.a.a;
            if (currentTimeMillis - cVar5.a.c < this.c) {
                return;
            }
            com.getui.gtc.g.a.a(this.a, 301);
            cVar6 = com.getui.gtc.e.c.a.a;
            com.getui.gtc.e.d dVar2 = cVar6.a;
            if (dVar2.a(6, currentTimeMillis)) {
                dVar2.c = currentTimeMillis;
            }
            cVar7 = com.getui.gtc.e.c.a.a;
            cVar7.a.d("");
        } catch (java.lang.Exception e4) {
            com.getui.gtc.h.c.a.c("type 301 report error: " + e4.toString());
        }
    }
}
