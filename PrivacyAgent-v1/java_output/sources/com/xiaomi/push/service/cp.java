package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class cp {
    static com.xiaomi.push.service.co a;
    static com.xiaomi.push.service.cp.a b;

    public interface a {
        void a();
    }

    public static synchronized com.xiaomi.push.service.co a(android.content.Context context) {
        synchronized (com.xiaomi.push.service.cp.class) {
            com.xiaomi.push.service.co coVar = a;
            if (coVar != null) {
                return coVar;
            }
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            java.lang.String string = sharedPreferences.getString("uuid", null);
            java.lang.String string2 = sharedPreferences.getString("token", null);
            java.lang.String string3 = sharedPreferences.getString("security", null);
            java.lang.String string4 = sharedPreferences.getString("app_id", null);
            java.lang.String string5 = sharedPreferences.getString("app_token", null);
            java.lang.String string6 = sharedPreferences.getString("package_name", null);
            java.lang.String string7 = sharedPreferences.getString("device_id", null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!android.text.TextUtils.isEmpty(string7) && com.xiaomi.push.ib.a(string7)) {
                string7 = com.xiaomi.push.ib.g(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (android.text.TextUtils.isEmpty(string) || android.text.TextUtils.isEmpty(string2) || android.text.TextUtils.isEmpty(string3)) {
                return null;
            }
            java.lang.String g = com.xiaomi.push.ib.g(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !android.text.TextUtils.isEmpty(g) && !android.text.TextUtils.isEmpty(string7) && !string7.equals(g)) {
                com.xiaomi.channel.commonutils.logger.b.a("read_phone_state permission changes.");
            }
            com.xiaomi.push.service.co coVar2 = new com.xiaomi.push.service.co(string, string2, string3, string4, string5, string6, i);
            a = coVar2;
            return coVar2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:3|4|(2:8|(37:10|11|(1:13)|14|(1:16)(1:134)|17|(1:19)(1:133)|20|(1:22)(1:132)|23|24|25|26|(1:28)(1:128)|29|(6:31|(1:33)|34|(1:38)|39|(1:41))|42|(1:44)|45|(6:48|49|50|52|53|46)|57|58|(14:63|64|(1:66)(1:126)|67|(1:69)(2:107|(1:109)(2:110|(1:112)(2:113|(1:115)(2:116|(1:118)(2:119|(1:121)(2:122|(1:124)(1:125)))))))|70|(1:72)|73|74|(2:78|(3:80|81|(5:83|(1:85)|86|87|88)(1:90)))|(1:99)|100|101|102)|127|64|(0)(0)|67|(0)(0)|70|(0)|73|74|(3:76|78|(0))|(2:97|99)|100|101|102))|135|11|(0)|14|(0)(0)|17|(0)(0)|20|(0)(0)|23|24|25|26|(0)(0)|29|(0)|42|(0)|45|(1:46)|57|58|(15:60|63|64|(0)(0)|67|(0)(0)|70|(0)|73|74|(0)|(0)|100|101|102)|127|64|(0)(0)|67|(0)(0)|70|(0)|73|74|(0)|(0)|100|101|102) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02ab, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d("device registration request failed. ".concat(java.lang.String.valueOf(r0)));
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0092, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0093, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0221 A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cc A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013d A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e A[Catch: all -> 0x03d2, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0211 A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02bb A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03bd A[Catch: all -> 0x03d2, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x0021, B:10:0x0037, B:11:0x0043, B:13:0x0054, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:23:0x007d, B:25:0x0087, B:28:0x009b, B:29:0x00a4, B:31:0x00cc, B:33:0x00d8, B:34:0x00eb, B:36:0x00f5, B:38:0x00fb, B:39:0x010f, B:41:0x0115, B:42:0x011a, B:44:0x013d, B:45:0x0146, B:46:0x0178, B:48:0x017e, B:50:0x0185, B:55:0x0194, B:58:0x01c2, B:60:0x01e3, B:63:0x01ea, B:64:0x01fc, B:67:0x020b, B:69:0x0211, B:70:0x0297, B:74:0x02a4, B:76:0x02bb, B:78:0x02c1, B:95:0x03a1, B:93:0x03ab, B:92:0x03b0, B:97:0x03bd, B:99:0x03c3, B:100:0x03cb, B:106:0x02ab, B:107:0x0221, B:109:0x022d, B:110:0x0235, B:112:0x0241, B:113:0x0249, B:115:0x0255, B:116:0x025d, B:118:0x0269, B:119:0x0271, B:121:0x027d, B:122:0x0285, B:131:0x0093, B:81:0x02c9, B:83:0x02d6, B:85:0x02f4, B:86:0x0307, B:90:0x0383), top: B:3:0x0005, inners: #1, #2, #5, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized com.xiaomi.push.service.co a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        java.lang.String b2;
        int a2;
        java.lang.String a3;
        boolean z;
        java.lang.StringBuilder sb;
        java.lang.String str5;
        com.xiaomi.push.ag agVar;
        java.lang.String str6;
        java.lang.String concat;
        synchronized (com.xiaomi.push.service.cp.class) {
            java.util.TreeMap treeMap = new java.util.TreeMap();
            treeMap.put(com.anythink.expressad.foundation.d.r.aC, com.xiaomi.push.ib.a(context));
            com.xiaomi.push.service.co coVar = a;
            if (coVar != null && !android.text.TextUtils.isEmpty(coVar.a)) {
                treeMap.put("uuid", a.a);
                int lastIndexOf = a.a.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                if (lastIndexOf != -1) {
                    str4 = a.a.substring(lastIndexOf + 1);
                    com.xiaomi.push.aa.a(context).a(treeMap);
                    b2 = com.xiaomi.push.ib.b(context);
                    if (!android.text.TextUtils.isEmpty(b2)) {
                        treeMap.put("gaid", b2);
                    }
                    java.lang.String str7 = !b(context) ? "1000271" : str2;
                    java.lang.String str8 = !b(context) ? "420100086271" : str3;
                    java.lang.String str9 = !b(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str7);
                    treeMap.put("apptoken", str8);
                    android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str9, 16384);
                    treeMap.put("appversion", packageInfo == null ? java.lang.String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", java.lang.Integer.toString(40090));
                    treeMap.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, str9);
                    treeMap.put("model", android.os.Build.MODEL);
                    treeMap.put("board", android.os.Build.BOARD);
                    if (!com.xiaomi.push.iu.f()) {
                        java.lang.String c = com.xiaomi.push.ib.c(context);
                        java.lang.String str10 = android.text.TextUtils.isEmpty(c) ? "" : "" + com.xiaomi.push.ao.a(c);
                        java.lang.String e = com.xiaomi.push.ib.e(context);
                        if (!android.text.TextUtils.isEmpty(str10) && !android.text.TextUtils.isEmpty(e)) {
                            str10 = str10 + "," + e;
                        }
                        if (!android.text.TextUtils.isEmpty(str10)) {
                            treeMap.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_IMEI_MD5, str10);
                        }
                    }
                    treeMap.put("os", android.os.Build.VERSION.RELEASE + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + android.os.Build.VERSION.INCREMENTAL);
                    a2 = com.xiaomi.push.ib.a();
                    if (a2 >= 0) {
                        treeMap.put("space_id", java.lang.Integer.toString(a2));
                    }
                    treeMap.put("brand", android.os.Build.BRAND);
                    treeMap.put("ram", com.xiaomi.push.ib.b());
                    treeMap.put("rom", com.xiaomi.push.ib.c());
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    for (java.util.Map.Entry entry : treeMap.entrySet()) {
                        try {
                            jSONObject.put((java.lang.String) entry.getKey(), entry.getValue());
                        } catch (org.json.JSONException e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("failed to add data in json format: k=" + ((java.lang.String) entry.getKey()) + ",v=" + ((java.lang.String) entry.getValue()) + ". " + e2);
                        }
                    }
                    a3 = com.xiaomi.push.service.av.a(jSONObject.toString());
                    java.util.TreeMap treeMap2 = new java.util.TreeMap();
                    treeMap2.put("requestData", a3);
                    treeMap2.put("keyPairVer", "1");
                    if (c(context) < 2 && !android.text.TextUtils.isEmpty(a3)) {
                        com.xiaomi.channel.commonutils.logger.b.a("r.data = ".concat(java.lang.String.valueOf(a3)));
                        z = true;
                        java.lang.String a4 = com.xiaomi.push.service.d.a(context).a();
                        java.lang.String str11 = !z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
                        if (!com.xiaomi.push.f.b()) {
                            sb = new java.lang.StringBuilder("http://");
                            sb.append(com.xiaomi.push.ew.b);
                            str5 = ":9085";
                        } else if (com.xiaomi.push.iy.China.name().equals(a4)) {
                            sb = new java.lang.StringBuilder();
                            str5 = "https://cn.register.xmpush.xiaomi.com";
                        } else if (com.xiaomi.push.iy.Global.name().equals(a4)) {
                            sb = new java.lang.StringBuilder();
                            str5 = "https://register.xmpush.global.xiaomi.com";
                        } else if (com.xiaomi.push.iy.Europe.name().equals(a4)) {
                            sb = new java.lang.StringBuilder();
                            str5 = "https://fr.register.xmpush.global.xiaomi.com";
                        } else if (com.xiaomi.push.iy.Russia.name().equals(a4)) {
                            sb = new java.lang.StringBuilder();
                            str5 = "https://ru.register.xmpush.global.xiaomi.com";
                        } else if (com.xiaomi.push.iy.India.name().equals(a4)) {
                            sb = new java.lang.StringBuilder();
                            str5 = "https://idmb.register.xmpush.global.xiaomi.com";
                        } else {
                            sb = new java.lang.StringBuilder("https://");
                            str5 = com.xiaomi.push.f.a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
                        }
                        sb.append(str5);
                        sb.append(str11);
                        java.lang.String sb2 = sb.toString();
                        if (z) {
                            treeMap = treeMap2;
                        }
                        agVar = com.xiaomi.push.ai.a(context, sb2, treeMap);
                        if (agVar != null && agVar.a == 200) {
                            str6 = agVar.c;
                            if (!android.text.TextUtils.isEmpty(str6)) {
                                try {
                                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(str6);
                                    if (jSONObject2.getInt("code") == 0) {
                                        org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                        java.lang.String string = jSONObject3.getString("ssecurity");
                                        java.lang.String string2 = jSONObject3.getString("token");
                                        java.lang.String string3 = jSONObject3.getString("userId");
                                        if (android.text.TextUtils.isEmpty(str4)) {
                                            str4 = com.alipay.sdk.m.s.a.u + com.xiaomi.push.ao.a(6);
                                        }
                                        com.xiaomi.push.service.co coVar2 = new com.xiaomi.push.service.co(string3 + "@xiaomi.com/" + str4, string2, string, str7, str8, str9, com.xiaomi.push.f.c());
                                        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
                                        edit.putString("uuid", coVar2.a);
                                        edit.putString("security", coVar2.c);
                                        edit.putString("token", coVar2.b);
                                        edit.putString("app_id", coVar2.d);
                                        edit.putString("package_name", coVar2.f);
                                        edit.putString("app_token", coVar2.e);
                                        edit.putString("device_id", com.xiaomi.push.ib.g(context));
                                        edit.putInt("env_type", coVar2.g);
                                        edit.commit();
                                        a();
                                        a = coVar2;
                                        a(context, 0);
                                        com.xiaomi.channel.commonutils.logger.b.a("device registration is successful. ".concat(java.lang.String.valueOf(string3)));
                                        return coVar2;
                                    }
                                    com.xiaomi.push.service.cs.a(context, jSONObject2.getInt("code"), jSONObject2.optString("description"));
                                    com.xiaomi.channel.commonutils.logger.b.a("device registration resp: ".concat(java.lang.String.valueOf(str6)));
                                } catch (org.json.JSONException e3) {
                                    concat = "failed to parse respone json data. ".concat(java.lang.String.valueOf(e3));
                                    com.xiaomi.channel.commonutils.logger.b.d(concat);
                                    if (z) {
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.a("fail to register push account. meet error.");
                                    return null;
                                } catch (java.lang.Throwable th) {
                                    concat = "unknow throwable. ".concat(java.lang.String.valueOf(th));
                                    com.xiaomi.channel.commonutils.logger.b.d(concat);
                                    if (z) {
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.a("fail to register push account. meet error.");
                                    return null;
                                }
                            }
                        }
                        if (z && com.xiaomi.push.ai.b(context)) {
                            a(context, c(context) + 1);
                        }
                        com.xiaomi.channel.commonutils.logger.b.a("fail to register push account. meet error.");
                        return null;
                    }
                    z = false;
                    java.lang.String a42 = com.xiaomi.push.service.d.a(context).a();
                    if (!z) {
                    }
                    if (!com.xiaomi.push.f.b()) {
                    }
                    sb.append(str5);
                    sb.append(str11);
                    java.lang.String sb22 = sb.toString();
                    if (z) {
                    }
                    agVar = com.xiaomi.push.ai.a(context, sb22, treeMap);
                    if (agVar != null) {
                        str6 = agVar.c;
                        if (!android.text.TextUtils.isEmpty(str6)) {
                        }
                    }
                    if (z) {
                        a(context, c(context) + 1);
                    }
                    com.xiaomi.channel.commonutils.logger.b.a("fail to register push account. meet error.");
                    return null;
                }
            }
            str4 = null;
            com.xiaomi.push.aa.a(context).a(treeMap);
            b2 = com.xiaomi.push.ib.b(context);
            if (!android.text.TextUtils.isEmpty(b2)) {
            }
            if (!b(context)) {
            }
            if (!b(context)) {
            }
            if (!b(context)) {
            }
            treeMap.put("appid", str7);
            treeMap.put("apptoken", str8);
            android.content.pm.PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str9, 16384);
            treeMap.put("appversion", packageInfo2 == null ? java.lang.String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", java.lang.Integer.toString(40090));
            treeMap.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, str9);
            treeMap.put("model", android.os.Build.MODEL);
            treeMap.put("board", android.os.Build.BOARD);
            if (!com.xiaomi.push.iu.f()) {
            }
            treeMap.put("os", android.os.Build.VERSION.RELEASE + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + android.os.Build.VERSION.INCREMENTAL);
            a2 = com.xiaomi.push.ib.a();
            if (a2 >= 0) {
            }
            treeMap.put("brand", android.os.Build.BRAND);
            treeMap.put("ram", com.xiaomi.push.ib.b());
            treeMap.put("rom", com.xiaomi.push.ib.c());
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            while (r8.hasNext()) {
            }
            a3 = com.xiaomi.push.service.av.a(jSONObject4.toString());
            java.util.TreeMap treeMap22 = new java.util.TreeMap();
            treeMap22.put("requestData", a3);
            treeMap22.put("keyPairVer", "1");
            if (c(context) < 2) {
                com.xiaomi.channel.commonutils.logger.b.a("r.data = ".concat(java.lang.String.valueOf(a3)));
                z = true;
                java.lang.String a422 = com.xiaomi.push.service.d.a(context).a();
                if (!z) {
                }
                if (!com.xiaomi.push.f.b()) {
                }
                sb.append(str5);
                sb.append(str11);
                java.lang.String sb222 = sb.toString();
                if (z) {
                }
                agVar = com.xiaomi.push.ai.a(context, sb222, treeMap);
                if (agVar != null) {
                }
                if (z) {
                }
                com.xiaomi.channel.commonutils.logger.b.a("fail to register push account. meet error.");
                return null;
            }
            z = false;
            java.lang.String a4222 = com.xiaomi.push.service.d.a(context).a();
            if (!z) {
            }
            if (!com.xiaomi.push.f.b()) {
            }
            sb.append(str5);
            sb.append(str11);
            java.lang.String sb2222 = sb.toString();
            if (z) {
            }
            agVar = com.xiaomi.push.ai.a(context, sb2222, treeMap);
            if (agVar != null) {
            }
            if (z) {
            }
            com.xiaomi.channel.commonutils.logger.b.a("fail to register push account. meet error.");
            return null;
        }
    }

    public static void a() {
        com.xiaomi.push.service.cp.a aVar = b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private static void a(android.content.Context context, int i) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    private static boolean b(android.content.Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static int c(android.content.Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }
}
