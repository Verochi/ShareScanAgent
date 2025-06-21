package com.huawei.hms.framework.network.grs.f;

/* loaded from: classes22.dex */
public class e {
    private static final java.lang.String a = "e";
    public static final java.util.Set<java.lang.String> b = java.util.Collections.unmodifiableSet(new com.huawei.hms.framework.network.grs.f.e.a(16));

    public static class a extends java.util.HashSet<java.lang.String> {
        public a(int i) {
            super(i);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    private static java.lang.String a(android.content.Context context, com.huawei.hms.framework.network.grs.e.a aVar, java.lang.String str, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, boolean z) {
        java.lang.String str2;
        java.lang.StringBuilder sb;
        java.lang.String str3;
        java.lang.String serCountry = grsBaseInfo.getSerCountry();
        java.lang.String regCountry = grsBaseInfo.getRegCountry();
        java.lang.String issueCountry = grsBaseInfo.getIssueCountry();
        for (java.lang.String str4 : str.split(">")) {
            if (b.contains(str4.trim())) {
                if (!"ser_country".equals(str4.trim()) || android.text.TextUtils.isEmpty(serCountry) || com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(serCountry)) {
                    if ("reg_country".equals(str4.trim()) && !android.text.TextUtils.isEmpty(regCountry) && !com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(regCountry)) {
                        com.huawei.hms.framework.common.Logger.i(a, "current route_by is regCountry and routerCountry is:" + regCountry);
                        return regCountry;
                    }
                    if ("issue_country".equals(str4.trim()) && !android.text.TextUtils.isEmpty(issueCountry) && !com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(issueCountry)) {
                        com.huawei.hms.framework.common.Logger.i(a, "current route_by is issueCountry and routerCountry is:" + issueCountry);
                        return issueCountry;
                    }
                    if ("geo_ip".equals(str4.trim())) {
                        serCountry = new com.huawei.hms.framework.network.grs.g.b(context, aVar, grsBaseInfo).a(z);
                        str2 = a;
                        sb = new java.lang.StringBuilder();
                        str3 = "current route_by is geo_ip and routerCountry is: ";
                    }
                } else {
                    str2 = a;
                    sb = new java.lang.StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is:";
                }
                sb.append(str3);
                sb.append(serCountry);
                com.huawei.hms.framework.common.Logger.i(str2, sb.toString());
                return serCountry;
            }
        }
        return "";
    }

    public static java.lang.String b(android.content.Context context, com.huawei.hms.framework.network.grs.e.a aVar, java.lang.String str, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.hms.framework.common.Logger.w(a, "routeBy must be not empty string or null.");
            return null;
        }
        if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return a(context, aVar, str, grsBaseInfo, z);
        }
        com.huawei.hms.framework.common.Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }
}
