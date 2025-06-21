package com.sina.weibo.sdk.net;

/* loaded from: classes19.dex */
public final class b implements com.sina.weibo.sdk.net.a {
    private static void a(java.io.OutputStream outputStream, com.sina.weibo.sdk.net.d dVar) {
        android.os.Bundle h = dVar.h();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.lang.String str : h.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            java.lang.String valueOf = java.lang.String.valueOf(h.get(str));
            try {
                sb.append(java.net.URLEncoder.encode(str, "UTF-8"));
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(java.net.URLEncoder.encode(valueOf, "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes("UTF-8"));
            dataOutputStream.close();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, android.os.Bundle bundle) {
        for (java.lang.String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, java.lang.String.valueOf(bundle.get(str)));
        }
    }

    @Override // com.sina.weibo.sdk.net.a
    public final com.sina.weibo.sdk.net.f a(com.sina.weibo.sdk.net.d dVar) {
        java.lang.String url = dVar.getUrl();
        android.os.Bundle params = dVar.getParams();
        if (params != null && params.size() != 0 && !android.text.TextUtils.isEmpty(url)) {
            android.net.Uri parse = android.net.Uri.parse(url);
            if (!params.isEmpty()) {
                android.net.Uri.Builder buildUpon = parse.buildUpon();
                for (java.lang.String str : params.keySet()) {
                    buildUpon.appendQueryParameter(str, java.lang.String.valueOf(params.get(str)));
                }
                parse = buildUpon.build();
            }
            if (parse != null) {
                url = parse.toString();
            }
        }
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(url).openConnection();
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
                a(httpURLConnection, bundle);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(dVar.getReadTimeout());
                httpURLConnection.setConnectTimeout(dVar.getConnectTimeout());
                httpURLConnection.connect();
                a(httpURLConnection.getOutputStream(), dVar);
                int responseCode = httpURLConnection.getResponseCode();
                com.sina.weibo.sdk.net.g gVar = new com.sina.weibo.sdk.net.g(responseCode, responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
                httpURLConnection.disconnect();
                return gVar;
            } catch (java.lang.Exception e) {
                throw new java.lang.Throwable(e.getMessage());
            }
        } catch (java.lang.Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
