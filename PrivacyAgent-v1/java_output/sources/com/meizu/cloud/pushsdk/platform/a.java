package com.meizu.cloud.pushsdk.platform;

/* loaded from: classes23.dex */
public class a {
    private static java.util.Map<java.lang.String, java.lang.String> a = a();
    private static final java.util.List<java.lang.String> b = new java.util.ArrayList(a.keySet());

    public static java.lang.String a(java.lang.String str) {
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() <= 3) {
                return str;
            }
            java.lang.String substring = str.substring(0, 3);
            if (!a.containsKey(substring)) {
                return str;
            }
            java.lang.String str3 = a.get(substring);
            str2 = str.substring(3);
            try {
                char[] cArr = new char[str2.length() / 2];
                int i = 0;
                int i2 = 0;
                while (i < str2.length() / 2) {
                    if (i2 == str3.length()) {
                        i2 = 0;
                    }
                    int i3 = i * 2;
                    cArr[i] = (char) (((char) java.lang.Integer.valueOf(str2.substring(i3, i3 + 2), 16).intValue()) ^ str3.charAt(i2));
                    i++;
                    i2++;
                }
                return new java.lang.String(java.lang.String.valueOf(cArr).getBytes("iso-8859-1"), "UTF-8");
            } catch (java.lang.Exception unused) {
                com.meizu.cloud.pushinternal.DebugLogger.e("PushIdEncryptUtils", "invalid pushId encryption " + str2);
                return str;
            }
        } catch (java.lang.Exception unused2) {
            str2 = str;
        }
    }

    private static java.util.Map<java.lang.String, java.lang.String> a() {
        if (a(a)) {
            synchronized (com.meizu.cloud.pushsdk.platform.a.class) {
                if (a(a)) {
                    java.util.TreeMap treeMap = new java.util.TreeMap();
                    a = treeMap;
                    treeMap.put("UCI", "v9tC0Myz1MGwXRFy");
                    a.put("G3G", "XAsFqhhaf4gKpmAi");
                    a.put("V5R", "cOqH18NXwBtZVkvz");
                    a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    a.put("EIM", "K11Rs9HAKRXeNwq8");
                    a.put("SO7", "T8LquL1DvwVcogiU");
                    a.put("DDI", "d02F6ttOtV05MYCQ");
                    a.put("ULY", "ToZZIhAywnUfHShN");
                    a.put("0EV", "r5D5RRwQhfV0AYLb");
                    a.put("N6A", "QAtSBFcXnQoUgHO2");
                    a.put("S5Q", "sDWLrZINnum227am");
                    a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    a.put("J04", "N5hViUTdLCpN59H0");
                    a.put("B68", "EY3sH1KKtalg5ZaT");
                    a.put("9IW", "q1u0MiuFyim4pCYY");
                    a.put("UU3", "syLnkkd8AqNykVV7");
                    a.put("Z49", "V00FiWu124yE91sH");
                    a.put("BNA", "rPP7AK1VWpKEry3p");
                    a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return a;
    }

    public static <K, V> boolean a(java.util.Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
