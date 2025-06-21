package com.getui.gtc.extension.distribution.gbd.m.h;

/* loaded from: classes22.dex */
public final class a {
    public static final java.lang.String a = "Up_ut";

    public static java.lang.String a(org.w3c.dom.Node node) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        org.w3c.dom.NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            org.w3c.dom.Node item = childNodes.item(i);
            if (item.getNodeType() == 3) {
                stringBuffer.append(item.getNodeValue());
            }
        }
        return stringBuffer.toString();
    }

    public static void a(java.lang.String str, byte[] bArr) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(bArr)));
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
            java.lang.String str2 = "";
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (android.text.TextUtils.isEmpty(readLine)) {
                    break;
                }
                java.lang.String[] split = readLine.split(": ");
                if (split != null && split.length == 2) {
                    concurrentHashMap.put(split[0].toLowerCase(), split[1]);
                    if ("ST".equalsIgnoreCase(split[0])) {
                        str2 = split[1];
                    }
                }
            }
            if (!com.getui.gtc.extension.distribution.gbd.d.h.z.containsKey(str)) {
                com.getui.gtc.extension.distribution.gbd.d.h.z.put(str, concurrentHashMap);
            } else if (str2.contains("rootdevice")) {
                com.getui.gtc.extension.distribution.gbd.d.h.z.put(str, concurrentHashMap);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public static void a(java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>> concurrentHashMap) {
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        for (java.lang.String str : concurrentHashMap.keySet()) {
            if (!android.text.TextUtils.isEmpty(str)) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> concurrentHashMap2 = concurrentHashMap.get(str);
                if (concurrentHashMap2.containsKey(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION)) {
                    java.lang.String str2 = concurrentHashMap2.get(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "i d: " + str + ", descriptionUrl: " + str2);
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.m.g.a(str, str2));
                    }
                }
            }
        }
    }
}
