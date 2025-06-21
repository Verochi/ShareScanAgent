package com.anythink.expressad.atsignalcommon.mraid;

/* loaded from: classes12.dex */
public class MraidUriUtil {
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> a = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.ArrayList<java.lang.String> b = new java.util.ArrayList<>();

    private static java.util.Set<java.lang.String> a(android.net.Uri uri) {
        java.lang.String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return java.util.Collections.emptySet();
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(android.net.Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return java.util.Collections.unmodifiableSet(linkedHashSet);
    }

    private static void a() {
        for (java.lang.reflect.Method method : com.anythink.expressad.atsignalcommon.mraid.IMraidSignalCommunication.class.getDeclaredMethods()) {
            b.add(method.getName());
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (!a.containsKey(str)) {
            a.put(str, str2);
            return;
        }
        java.lang.String str3 = a.get(str);
        if (android.text.TextUtils.isEmpty(str2) || str3.contains(str2)) {
            return;
        }
        if (str3.length() > 0) {
            str3 = str3.concat(",");
        }
        a.put(str, str3.concat(str2));
    }

    public static void clearUnSupportMraidMethodMap() {
        if (a.size() > 0) {
            a.clear();
        }
    }

    public static void clearUnSupportMraidMethodMap(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a.remove(str);
    }

    public static com.anythink.expressad.atsignalcommon.windvane.a getMraidMethodContext(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str) {
        java.util.Set<java.lang.String> unmodifiableSet;
        android.net.Uri parse = android.net.Uri.parse(str);
        java.lang.String scheme = parse.getScheme();
        if (android.text.TextUtils.isEmpty(scheme) || !scheme.contains(com.anythink.expressad.foundation.d.c.m)) {
            return null;
        }
        com.anythink.expressad.atsignalcommon.windvane.a aVar = new com.anythink.expressad.atsignalcommon.windvane.a();
        aVar.d = com.anythink.expressad.foundation.h.j.b("n+ztLkxpVTzBLkxgHN==");
        aVar.e = parse.getHost();
        int i = 0;
        if (b.size() == 0) {
            for (java.lang.reflect.Method method : com.anythink.expressad.atsignalcommon.mraid.IMraidSignalCommunication.class.getDeclaredMethods()) {
                b.add(method.getName());
            }
        }
        if (!b.contains(aVar.e) && windVaneWebView != null) {
            java.lang.String campaignId = windVaneWebView.getCampaignId();
            java.lang.String str2 = aVar.e;
            if (!android.text.TextUtils.isEmpty(campaignId)) {
                if (a.containsKey(campaignId)) {
                    java.lang.String str3 = a.get(campaignId);
                    if (!android.text.TextUtils.isEmpty(str2) && !str3.contains(str2)) {
                        if (str3.length() > 0) {
                            str3 = str3.concat(",");
                        }
                        a.put(campaignId, str3.concat(str2));
                    }
                } else {
                    a.put(campaignId, str2);
                }
            }
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireNativeMethodCompleteEvent(windVaneWebView, aVar.e);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireErrorEvent(windVaneWebView, aVar.e, "Specified command is not implemented");
            return null;
        }
        java.lang.String encodedQuery = parse.getEncodedQuery();
        if (encodedQuery == null) {
            unmodifiableSet = java.util.Collections.emptySet();
        } else {
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            do {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(android.net.Uri.decode(encodedQuery.substring(i, indexOf2)));
                i = indexOf + 1;
            } while (i < encodedQuery.length());
            unmodifiableSet = java.util.Collections.unmodifiableSet(linkedHashSet);
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            for (java.lang.String str4 : unmodifiableSet) {
                jSONObject.put(str4, parse.getQueryParameter(str4));
            }
            aVar.f = jSONObject.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }

    public static java.lang.String getUnSupportMraidMethodString(java.lang.String str) {
        if (a.containsKey(str)) {
            return a.get(str);
        }
        return null;
    }
}
