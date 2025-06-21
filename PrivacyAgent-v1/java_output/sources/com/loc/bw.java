package com.loc;

/* loaded from: classes23.dex */
public class bw {
    static final /* synthetic */ boolean a = true;
    private static com.loc.bw b;
    private final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.util.List<java.lang.String>>> c = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> d = new java.util.HashMap();
    private final java.util.List<java.lang.String> e = new java.util.ArrayList();

    public static class a {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;

        public a(java.lang.String str, java.lang.String str2) {
            this.a = null;
            this.b = str;
            this.c = str2;
        }

        public a(java.net.URL url) {
            this.a = url.getProtocol();
            this.b = url.getHost();
            this.c = url.getPath();
        }
    }

    private static com.loc.bw.a a(com.loc.bw.a aVar) {
        if (aVar == null) {
            return null;
        }
        java.lang.String str = aVar.c;
        if (str == null || str.length() == 0) {
            return aVar;
        }
        while (true) {
            java.lang.String str2 = aVar.c;
            if (str2.charAt(str2.length() - 1) != '/') {
                break;
            }
            java.lang.String str3 = aVar.c;
            aVar.c = str3.substring(0, str3.length() - 1);
        }
        while (aVar.c.charAt(0) == '/') {
            aVar.c = aVar.c.substring(1);
        }
        return aVar;
    }

    public static synchronized com.loc.bw a() {
        com.loc.bw bwVar;
        synchronized (com.loc.bw.class) {
            if (b == null) {
                b = new com.loc.bw();
            }
            bwVar = b;
        }
        return bwVar;
    }

    private static boolean a(java.lang.String str, java.lang.String str2) {
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        java.lang.String[] split2 = str2.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (split2.length < split.length) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("*") && !split[i].equals(split2[i])) {
                return false;
            }
        }
        return true;
    }

    private static com.loc.bw.a b(java.lang.String str) {
        try {
            return new com.loc.bw.a(new java.net.URL(str));
        } catch (java.net.MalformedURLException unused) {
            java.lang.String str2 = null;
            if (str.contains("://")) {
                return null;
            }
            while (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str = str.substring(1);
            }
            java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            int i = 0;
            if (split[0].contains(".")) {
                str2 = split[0];
                i = 1;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (i < split.length) {
                if (sb.length() > 0) {
                    sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                }
                sb.append(split[i]);
                i++;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '/') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return new com.loc.bw.a(str2, sb.toString());
        }
    }

    private synchronized boolean b(com.loc.bw.a aVar) {
        if (aVar != null) {
            if (aVar.c.length() != 0) {
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = this.d;
                java.lang.String str = aVar.a;
                if (str != null && this.c.containsKey(str)) {
                    map = this.c.get(aVar.a);
                }
                java.util.List<java.lang.String> list = this.e;
                boolean z = a;
                if (!z && map == null) {
                    throw new java.lang.AssertionError();
                }
                java.lang.String str2 = aVar.b;
                if (str2 != null && map.containsKey(str2)) {
                    list = map.get(aVar.b);
                }
                if (!z && list == null) {
                    throw new java.lang.AssertionError();
                }
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    if (a(it.next(), aVar.c)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final boolean a(java.lang.String str) {
        com.loc.bw.a a2;
        if (str == null || str.length() == 0 || (a2 = a(b(str))) == null) {
            return false;
        }
        return b(a2);
    }
}
