package com.huawei.hms.framework.network.grs.g;

/* loaded from: classes22.dex */
public class b {
    private final android.content.Context a;
    private final com.huawei.hms.framework.network.grs.GrsBaseInfo b;
    private final com.huawei.hms.framework.network.grs.e.a c;

    public b(android.content.Context context, com.huawei.hms.framework.network.grs.e.a aVar, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        this.a = context;
        this.b = grsBaseInfo;
        this.c = aVar;
    }

    public java.lang.String a(boolean z) {
        java.lang.String str;
        java.lang.String str2 = com.huawei.hms.framework.network.grs.a.a(this.c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        com.huawei.hms.framework.common.Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
        java.lang.String a = this.c.a().a("geoipCountryCodetime", "0");
        long j = 0;
        if (!android.text.TextUtils.isEmpty(a) && a.matches("\\d+")) {
            try {
                j = java.lang.Long.parseLong(a);
            } catch (java.lang.NumberFormatException e) {
                com.huawei.hms.framework.common.Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        if (android.text.TextUtils.isEmpty(str2) || com.huawei.hms.framework.network.grs.h.e.a(java.lang.Long.valueOf(j))) {
            com.huawei.hms.framework.network.grs.g.k.c cVar = new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c c = this.c.c();
            if (c != null) {
                try {
                    str = com.huawei.hms.framework.network.grs.g.i.a(c.a("services", ""), cVar.c());
                } catch (org.json.JSONException e2) {
                    com.huawei.hms.framework.common.Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e2.getMessage()));
                    str = null;
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    c.b("services", str);
                }
            }
            if (z) {
                com.huawei.hms.framework.network.grs.g.d a2 = this.c.b().a(cVar, "geoip.countrycode", c);
                if (a2 != null) {
                    str2 = com.huawei.hms.framework.network.grs.a.a(a2.j(), "geoip.countrycode").get("ROOT");
                }
                com.huawei.hms.framework.common.Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
            } else {
                com.huawei.hms.framework.common.Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.c.b().a(cVar, null, "geoip.countrycode", c);
            }
        }
        return str2;
    }
}
