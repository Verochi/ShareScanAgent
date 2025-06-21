package com.anythink.basead.d.b.a;

/* loaded from: classes12.dex */
public final class a {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a1: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x00a1 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.basead.c.d a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str) {
        java.net.HttpURLConnection httpURLConnection;
        java.net.HttpURLConnection httpURLConnection2;
        int responseCode;
        java.net.HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                } catch (java.lang.Exception e) {
                    e = e;
                    com.anythink.core.common.n.c.a(mVar, lVar, lVar.D(), str, "", e.getMessage());
                }
            } catch (java.lang.Throwable th) {
                th = th;
                httpURLConnection3 = httpURLConnection2;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            httpURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (httpURLConnection3 != null) {
            }
            throw th;
        }
        if (responseCode != 200) {
            com.anythink.core.common.n.c.a(mVar, lVar, lVar.D(), str, java.lang.String.valueOf(responseCode), "");
            httpURLConnection.disconnect();
            return null;
        }
        java.io.InputStream inputStream = httpURLConnection.getInputStream();
        java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(inputStream);
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
        }
        org.json.JSONObject optJSONObject = new org.json.JSONObject(sb.toString()).optJSONObject("data");
        com.anythink.basead.c.d dVar = new com.anythink.basead.c.d(optJSONObject.optString("dstlink"), "", optJSONObject.optString("clickid"));
        bufferedReader.close();
        inputStreamReader.close();
        if (inputStream != null) {
            inputStream.close();
        }
        httpURLConnection.disconnect();
        return dVar;
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            return android.net.Uri.parse(str).getQueryParameter("qz_gdt");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
