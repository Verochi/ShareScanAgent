package com.tencent.open.web.security;

/* loaded from: classes19.dex */
public class b extends com.tencent.open.a {
    @Override // com.tencent.open.a
    public void a(java.lang.String str, java.lang.String str2, java.util.List<java.lang.String> list, com.tencent.open.a.C0500a c0500a) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, java.net.URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        com.tencent.open.a.b bVar = this.a.get(str);
        if (bVar != null) {
            com.tencent.open.log.SLog.d("openSDK_LOG.SecureJsBridge", "-->handler != null");
            bVar.call(str2, list, c0500a);
            return;
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + str);
        if (c0500a != null) {
            c0500a.a();
        }
    }

    @Override // com.tencent.open.a
    public boolean a(android.webkit.WebView webView, java.lang.String str) {
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !android.net.Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList((str + "/#").split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)));
        if (arrayList.size() < 7) {
            return false;
        }
        java.lang.String str2 = (java.lang.String) arrayList.get(2);
        java.lang.String str3 = (java.lang.String) arrayList.get(3);
        java.lang.String str4 = (java.lang.String) arrayList.get(4);
        java.lang.String str5 = (java.lang.String) arrayList.get(5);
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
        if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str3) && !android.text.TextUtils.isEmpty(str4)) {
            try {
                a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new com.tencent.open.web.security.c(webView, java.lang.Long.parseLong(str4), str, str5));
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }
}
