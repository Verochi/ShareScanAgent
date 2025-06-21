package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public abstract class a {
    private static final java.lang.String a = "http.loader";
    protected com.anythink.core.common.h.k m;
    protected boolean n;
    protected java.lang.String o;

    /* renamed from: com.anythink.core.common.h.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.common.o.b.d {
        final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0351 A[Catch: all -> 0x04c0, TryCatch #30 {all -> 0x04c0, blocks: (B:72:0x0129, B:314:0x027b, B:316:0x0288, B:317:0x028c, B:157:0x02bd, B:159:0x02cd, B:160:0x02d1, B:132:0x0302, B:134:0x030f, B:135:0x0313, B:107:0x0344, B:109:0x0351, B:110:0x0355, B:292:0x0385, B:226:0x03ac, B:204:0x03df, B:270:0x0412, B:182:0x0445, B:248:0x0485), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:115:0x037d  */
        /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0376 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x036f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x0368 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:134:0x030f A[Catch: all -> 0x04c0, TryCatch #30 {all -> 0x04c0, blocks: (B:72:0x0129, B:314:0x027b, B:316:0x0288, B:317:0x028c, B:157:0x02bd, B:159:0x02cd, B:160:0x02d1, B:132:0x0302, B:134:0x030f, B:135:0x0313, B:107:0x0344, B:109:0x0351, B:110:0x0355, B:292:0x0385, B:226:0x03ac, B:204:0x03df, B:270:0x0412, B:182:0x0445, B:248:0x0485), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:140:0x033b  */
        /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:143:0x0334 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x032d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:151:0x0326 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:159:0x02cd A[Catch: all -> 0x04c0, TryCatch #30 {all -> 0x04c0, blocks: (B:72:0x0129, B:314:0x027b, B:316:0x0288, B:317:0x028c, B:157:0x02bd, B:159:0x02cd, B:160:0x02d1, B:132:0x0302, B:134:0x030f, B:135:0x0313, B:107:0x0344, B:109:0x0351, B:110:0x0355, B:292:0x0385, B:226:0x03ac, B:204:0x03df, B:270:0x0412, B:182:0x0445, B:248:0x0485), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:165:0x02f9  */
        /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:168:0x02f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:172:0x02eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:176:0x02e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:187:0x047c  */
        /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:190:0x0475 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:194:0x046e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:198:0x0467 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:209:0x0409  */
        /* JADX WARN: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0402 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:216:0x03fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:220:0x03f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:231:0x03d6  */
        /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:234:0x03cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:238:0x03c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:242:0x03c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:253:0x04bc  */
        /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:256:0x04b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:260:0x04ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:264:0x04a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:275:0x043c  */
        /* JADX WARN: Removed duplicated region for block: B:277:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:278:0x0435 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:282:0x042e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:286:0x0427 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:297:0x03a3  */
        /* JADX WARN: Removed duplicated region for block: B:299:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:300:0x039c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:304:0x0395 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:308:0x038e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:316:0x0288 A[Catch: all -> 0x04c0, TryCatch #30 {all -> 0x04c0, blocks: (B:72:0x0129, B:314:0x027b, B:316:0x0288, B:317:0x028c, B:157:0x02bd, B:159:0x02cd, B:160:0x02d1, B:132:0x0302, B:134:0x030f, B:135:0x0313, B:107:0x0344, B:109:0x0351, B:110:0x0355, B:292:0x0385, B:226:0x03ac, B:204:0x03df, B:270:0x0412, B:182:0x0445, B:248:0x0485), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:322:0x02b4  */
        /* JADX WARN: Removed duplicated region for block: B:324:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:325:0x02ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:329:0x02a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:333:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:343:0x04d8  */
        /* JADX WARN: Removed duplicated region for block: B:345:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:346:0x04d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:350:0x04ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:354:0x04c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v10 */
        /* JADX WARN: Type inference failed for: r11v11 */
        /* JADX WARN: Type inference failed for: r11v12 */
        /* JADX WARN: Type inference failed for: r11v13 */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v16 */
        /* JADX WARN: Type inference failed for: r11v17 */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* JADX WARN: Type inference failed for: r11v19 */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v20 */
        /* JADX WARN: Type inference failed for: r11v21 */
        /* JADX WARN: Type inference failed for: r11v22 */
        /* JADX WARN: Type inference failed for: r11v23, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v24, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v25, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v26, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v27, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v28, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v29, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v3 */
        /* JADX WARN: Type inference failed for: r11v30, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v31, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v32, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v33, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r11v35, types: [java.net.HttpURLConnection, java.net.URLConnection] */
        /* JADX WARN: Type inference failed for: r11v36 */
        /* JADX WARN: Type inference failed for: r11v37 */
        /* JADX WARN: Type inference failed for: r11v38 */
        /* JADX WARN: Type inference failed for: r11v39 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v40 */
        /* JADX WARN: Type inference failed for: r11v41 */
        /* JADX WARN: Type inference failed for: r11v42 */
        /* JADX WARN: Type inference failed for: r11v43 */
        /* JADX WARN: Type inference failed for: r11v44 */
        /* JADX WARN: Type inference failed for: r11v45 */
        /* JADX WARN: Type inference failed for: r11v46 */
        /* JADX WARN: Type inference failed for: r11v5 */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v20, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v21, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v22, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v23, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v24, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v25, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v26, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v27, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v28, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v29, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v30, types: [java.io.InputStreamReader] */
        /* JADX WARN: Type inference failed for: r3v31 */
        /* JADX WARN: Type inference failed for: r3v32 */
        /* JADX WARN: Type inference failed for: r3v33 */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v35 */
        /* JADX WARN: Type inference failed for: r3v36 */
        /* JADX WARN: Type inference failed for: r3v37 */
        /* JADX WARN: Type inference failed for: r3v38 */
        /* JADX WARN: Type inference failed for: r3v39 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v50 */
        /* JADX WARN: Type inference failed for: r3v52 */
        /* JADX WARN: Type inference failed for: r3v53 */
        /* JADX WARN: Type inference failed for: r3v55 */
        /* JADX WARN: Type inference failed for: r3v57 */
        /* JADX WARN: Type inference failed for: r3v59 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v61 */
        /* JADX WARN: Type inference failed for: r3v63 */
        /* JADX WARN: Type inference failed for: r3v65 */
        /* JADX WARN: Type inference failed for: r3v67 */
        /* JADX WARN: Type inference failed for: r3v69 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v70, types: [java.io.InputStreamReader, java.io.Reader] */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v82 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void b(java.lang.String str) {
            java.io.InputStream inputStream;
            ?? r3;
            ?? r32;
            java.lang.Exception e;
            javax.net.ssl.SSLException e2;
            java.net.UnknownHostException e3;
            java.net.SocketTimeoutException e4;
            java.net.SocketException e5;
            java.net.ConnectException e6;
            java.lang.Error e7;
            java.lang.StackOverflowError e8;
            java.lang.OutOfMemoryError e9;
            java.io.BufferedReader bufferedReader;
            byte[] d;
            java.io.BufferedReader bufferedReader2 = null;
            try {
                try {
                    com.anythink.core.common.h.a.this.o = str;
                    str = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    int a = com.anythink.core.common.h.a.this.a();
                    if (a != 1 && a != 2) {
                        a = 2;
                    }
                    if (a == 1) {
                        str.setDoInput(true);
                        str.setDoOutput(true);
                        str.setRequestMethod("POST");
                        str.setUseCaches(false);
                    }
                    if (a == 2) {
                        str.setInstanceFollowRedirects(false);
                    }
                    java.util.Map<java.lang.String, java.lang.String> c = com.anythink.core.common.h.a.this.c();
                    if (c != null && c.size() > 0) {
                        for (java.lang.String str2 : c.keySet()) {
                            str.addRequestProperty(str2, c.get(str2));
                        }
                    }
                    com.anythink.core.common.h.a aVar = com.anythink.core.common.h.a.this;
                    if (aVar.n) {
                        aVar.c(this.a);
                        if (str != 0) {
                            str.disconnect();
                            return;
                        }
                        return;
                    }
                    if (com.anythink.core.common.b.o.a().c("ua")) {
                        str.addRequestProperty("User-Agent", com.anythink.core.common.o.h.a());
                    }
                    str.setConnectTimeout(60000);
                    str.setReadTimeout(60000);
                    str.connect();
                    if (a == 1 && (d = com.anythink.core.common.h.a.this.d()) != null) {
                        java.io.OutputStream outputStream = str.getOutputStream();
                        outputStream.write(d);
                        outputStream.flush();
                        outputStream.close();
                    }
                    int responseCode = str.getResponseCode();
                    if (!com.anythink.core.common.h.a.this.a(responseCode) && responseCode != 200) {
                        if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                            com.anythink.core.common.h.a.this.a(this.a, responseCode, "Http respond status code is ".concat(java.lang.String.valueOf(responseCode)), com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.httpStatuException, java.lang.String.valueOf(responseCode), str.getResponseMessage()));
                            str.disconnect();
                            return;
                        }
                        com.anythink.core.common.h.a aVar2 = com.anythink.core.common.h.a.this;
                        if (aVar2.n) {
                            aVar2.c(this.a);
                        } else {
                            java.lang.String headerField = str.getHeaderField("Location");
                            if (headerField != null && headerField.toLowerCase().startsWith(com.alipay.sdk.m.l.a.q)) {
                                b(headerField);
                            }
                        }
                        str.disconnect();
                        return;
                    }
                    com.anythink.core.common.h.a aVar3 = com.anythink.core.common.h.a.this;
                    if (aVar3.n) {
                        aVar3.c(this.a);
                        str.disconnect();
                        return;
                    }
                    inputStream = com.anythink.core.common.h.a.a((java.net.HttpURLConnection) str);
                    try {
                        r3 = new java.io.InputStreamReader(inputStream);
                        try {
                            bufferedReader = new java.io.BufferedReader(r3);
                        } catch (java.lang.OutOfMemoryError e10) {
                            e9 = e10;
                        } catch (java.lang.StackOverflowError e11) {
                            e8 = e11;
                        } catch (java.lang.Error e12) {
                            e7 = e12;
                        } catch (java.net.ConnectException e13) {
                            e6 = e13;
                        } catch (java.net.SocketException e14) {
                            e5 = e14;
                        } catch (java.net.SocketTimeoutException e15) {
                            e4 = e15;
                        } catch (java.net.UnknownHostException e16) {
                            e3 = e16;
                        } catch (javax.net.ssl.SSLException e17) {
                            e2 = e17;
                        } catch (org.apache.http.conn.ConnectTimeoutException e18) {
                            e = e18;
                        } catch (java.lang.Exception e19) {
                            e = e19;
                        }
                        try {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            while (true) {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else {
                                    sb.append(readLine);
                                }
                            }
                            if (com.anythink.core.common.h.a.this.n()) {
                                java.lang.String trim = sb.toString().trim();
                                org.json.JSONObject jSONObject = new org.json.JSONObject(trim);
                                int optInt = jSONObject.optInt("code");
                                if (optInt == 0) {
                                    org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.anythink.core.common.b.h.d.e);
                                    if (optJSONObject == null) {
                                        optJSONObject = new org.json.JSONObject();
                                    }
                                    com.anythink.core.common.h.a aVar4 = com.anythink.core.common.h.a.this;
                                    str.getHeaderFields();
                                    com.anythink.core.common.h.a.this.a(this.a, aVar4.a(optJSONObject));
                                } else {
                                    com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.k, trim, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.statuError, java.lang.String.valueOf(optInt), trim));
                                }
                            } else {
                                com.anythink.core.common.h.a aVar5 = com.anythink.core.common.h.a.this;
                                str.getHeaderFields();
                                com.anythink.core.common.h.a.this.a(this.a, aVar5.a(sb.toString().trim()));
                            }
                            try {
                                bufferedReader.close();
                            } catch (java.lang.Throwable unused) {
                            }
                            try {
                                r3.close();
                            } catch (java.lang.Throwable unused2) {
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            str.disconnect();
                        } catch (java.lang.OutOfMemoryError e20) {
                            e9 = e20;
                            bufferedReader2 = bufferedReader;
                            java.lang.System.gc();
                            java.lang.String message = e9.getMessage();
                            if (e9.getMessage() != null) {
                            }
                            com.anythink.core.common.h.a.this.a(this.a, -1004, message, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e9.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.lang.StackOverflowError e21) {
                            e8 = e21;
                            bufferedReader2 = bufferedReader;
                            java.lang.System.gc();
                            java.lang.String message2 = e8.getMessage();
                            if (e8.getMessage() != null) {
                            }
                            com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.f, message2, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e8.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.lang.Error e22) {
                            e7 = e22;
                            bufferedReader2 = bufferedReader;
                            e7.getMessage();
                            java.lang.System.gc();
                            java.lang.String message3 = e7.getMessage();
                            if (e7.getMessage() != null) {
                            }
                            com.anythink.core.common.h.a.this.a(this.a, -9999, message3, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e7.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.net.ConnectException e23) {
                            e6 = e23;
                            bufferedReader2 = bufferedReader;
                            com.anythink.core.common.h.a.this.a(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e6.getMessage()));
                            com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.b, "Connect error.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e6.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.net.SocketException e24) {
                            e5 = e24;
                            bufferedReader2 = bufferedReader;
                            com.anythink.core.common.h.a.this.a(this.a, -1007, "connect socket failed.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e5.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.net.SocketTimeoutException e25) {
                            e4 = e25;
                            bufferedReader2 = bufferedReader;
                            com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.c, "Connect timeout.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e4.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.net.UnknownHostException e26) {
                            e3 = e26;
                            bufferedReader2 = bufferedReader;
                            com.anythink.core.common.h.a.this.a(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e3.getMessage()));
                            com.anythink.core.common.h.a.this.a(this.a, -1000, "UnknownHostException", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e3.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (javax.net.ssl.SSLException e27) {
                            e2 = e27;
                            bufferedReader2 = bufferedReader;
                            com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.g, "connect ssl failed.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e2.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (org.apache.http.conn.ConnectTimeoutException e28) {
                            e = e28;
                            bufferedReader2 = bufferedReader;
                            com.anythink.core.common.h.a.this.a(this.a, e);
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.lang.Exception e29) {
                            e = e29;
                            bufferedReader2 = bufferedReader;
                            e.getMessage();
                            java.lang.String message4 = e.getMessage();
                            if (e.getMessage() != null) {
                            }
                            com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.i, message4, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e.getMessage()));
                            if (bufferedReader2 != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str == 0) {
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            r32 = r3;
                            if (bufferedReader2 != null) {
                            }
                            if (r32 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (str != 0) {
                            }
                        }
                    } catch (java.lang.OutOfMemoryError e30) {
                        e9 = e30;
                        r3 = 0;
                    } catch (java.lang.StackOverflowError e31) {
                        e8 = e31;
                        r3 = 0;
                    } catch (java.lang.Error e32) {
                        e7 = e32;
                        r3 = 0;
                    } catch (java.net.ConnectException e33) {
                        e6 = e33;
                        r3 = 0;
                    } catch (java.net.SocketException e34) {
                        e5 = e34;
                        r3 = 0;
                    } catch (java.net.SocketTimeoutException e35) {
                        e4 = e35;
                        r3 = 0;
                    } catch (java.net.UnknownHostException e36) {
                        e3 = e36;
                        r3 = 0;
                    } catch (javax.net.ssl.SSLException e37) {
                        e2 = e37;
                        r3 = 0;
                    } catch (org.apache.http.conn.ConnectTimeoutException e38) {
                        e = e38;
                        r3 = 0;
                    } catch (java.lang.Exception e39) {
                        e = e39;
                        r3 = 0;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        r32 = 0;
                    }
                } catch (java.lang.OutOfMemoryError e40) {
                    e = e40;
                    r3 = 0;
                    str = str;
                    e9 = e;
                    inputStream = r3;
                    java.lang.System.gc();
                    java.lang.String message5 = e9.getMessage();
                    if (e9.getMessage() != null) {
                        message5 = e9.getMessage();
                    }
                    com.anythink.core.common.h.a.this.a(this.a, -1004, message5, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e9.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused4) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused5) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused6) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.lang.StackOverflowError e41) {
                    e = e41;
                    r3 = 0;
                    str = str;
                    e8 = e;
                    inputStream = r3;
                    java.lang.System.gc();
                    java.lang.String message22 = e8.getMessage();
                    if (e8.getMessage() != null) {
                        message22 = e8.getMessage();
                    }
                    com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.f, message22, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e8.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused7) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused8) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused9) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.lang.Error e42) {
                    e = e42;
                    r3 = 0;
                    str = str;
                    e7 = e;
                    inputStream = r3;
                    e7.getMessage();
                    java.lang.System.gc();
                    java.lang.String message32 = e7.getMessage();
                    if (e7.getMessage() != null) {
                        message32 = e7.getMessage();
                    }
                    com.anythink.core.common.h.a.this.a(this.a, -9999, message32, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e7.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused10) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused11) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused12) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.net.ConnectException e43) {
                    e = e43;
                    r3 = 0;
                    str = str;
                    e6 = e;
                    inputStream = r3;
                    com.anythink.core.common.h.a.this.a(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e6.getMessage()));
                    com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.b, "Connect error.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e6.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused13) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused14) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused15) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.net.SocketException e44) {
                    e = e44;
                    r3 = 0;
                    str = str;
                    e5 = e;
                    inputStream = r3;
                    com.anythink.core.common.h.a.this.a(this.a, -1007, "connect socket failed.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e5.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused16) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused17) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused18) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.net.SocketTimeoutException e45) {
                    e = e45;
                    r3 = 0;
                    str = str;
                    e4 = e;
                    inputStream = r3;
                    com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.c, "Connect timeout.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e4.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused19) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused20) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused21) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.net.UnknownHostException e46) {
                    e = e46;
                    r3 = 0;
                    str = str;
                    e3 = e;
                    inputStream = r3;
                    com.anythink.core.common.h.a.this.a(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e3.getMessage()));
                    com.anythink.core.common.h.a.this.a(this.a, -1000, "UnknownHostException", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e3.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused22) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused23) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused24) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (javax.net.ssl.SSLException e47) {
                    e = e47;
                    r3 = 0;
                    str = str;
                    e2 = e;
                    inputStream = r3;
                    com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.g, "connect ssl failed.", com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e2.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused25) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused26) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused27) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (org.apache.http.conn.ConnectTimeoutException e48) {
                    e = e48;
                    inputStream = null;
                    str = str;
                    r3 = inputStream;
                    com.anythink.core.common.h.a.this.a(this.a, e);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused28) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused29) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused30) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.lang.Exception e49) {
                    e = e49;
                    r3 = 0;
                    str = str;
                    e = e;
                    inputStream = r3;
                    e.getMessage();
                    java.lang.String message42 = e.getMessage();
                    if (e.getMessage() != null) {
                        message42 = e.getMessage();
                    }
                    com.anythink.core.common.h.a.this.a(this.a, com.anythink.core.common.h.i.i, message42, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e.getMessage()));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused31) {
                        }
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.lang.Throwable unused32) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused33) {
                        }
                    }
                    if (str == 0) {
                        str.disconnect();
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    inputStream = null;
                    str = str;
                    r32 = inputStream;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused34) {
                        }
                    }
                    if (r32 != 0) {
                        try {
                            r32.close();
                        } catch (java.lang.Throwable unused35) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable unused36) {
                        }
                    }
                    if (str != 0) {
                        throw th;
                    }
                    str.disconnect();
                    throw th;
                }
            } catch (java.lang.OutOfMemoryError e50) {
                e = e50;
                str = 0;
                r3 = 0;
            } catch (java.lang.StackOverflowError e51) {
                e = e51;
                str = 0;
                r3 = 0;
            } catch (java.lang.Error e52) {
                e = e52;
                str = 0;
                r3 = 0;
            } catch (java.net.ConnectException e53) {
                e = e53;
                str = 0;
                r3 = 0;
            } catch (java.net.SocketException e54) {
                e = e54;
                str = 0;
                r3 = 0;
            } catch (java.net.SocketTimeoutException e55) {
                e = e55;
                str = 0;
                r3 = 0;
            } catch (java.net.UnknownHostException e56) {
                e = e56;
                str = 0;
                r3 = 0;
            } catch (javax.net.ssl.SSLException e57) {
                e = e57;
                str = 0;
                r3 = 0;
            } catch (org.apache.http.conn.ConnectTimeoutException e58) {
                e = e58;
                str = 0;
                inputStream = null;
            } catch (java.lang.Exception e59) {
                e = e59;
                str = 0;
                r3 = 0;
            } catch (java.lang.Throwable th5) {
                th = th5;
                str = 0;
                inputStream = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // com.anythink.core.common.o.b.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            com.anythink.core.common.h.k kVar;
            try {
                com.anythink.core.common.h.k kVar2 = com.anythink.core.common.h.a.this.m;
                if (kVar2 != null) {
                    kVar2.onLoadStart(this.a);
                }
                b(com.anythink.core.common.h.a.this.b());
            } catch (java.lang.Exception e) {
                java.lang.String message = e.getMessage();
                if (e.getMessage() != null) {
                    message = e.getMessage();
                }
                com.anythink.core.common.h.k kVar3 = com.anythink.core.common.h.a.this.m;
                if (kVar3 != null) {
                    kVar3.onLoadError(this.a, message, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e.getMessage()));
                }
            } catch (java.lang.OutOfMemoryError e2) {
                e = e2;
                java.lang.System.gc();
                java.lang.String message2 = e.getMessage();
                if (e.getMessage() != null) {
                    message2 = e.getMessage();
                }
                kVar = com.anythink.core.common.h.a.this.m;
                if (kVar == null) {
                    kVar.onLoadError(this.a, message2, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, e.getMessage()));
                }
            } catch (java.lang.StackOverflowError e3) {
                e = e3;
                java.lang.System.gc();
                java.lang.String message22 = e.getMessage();
                if (e.getMessage() != null) {
                }
                kVar = com.anythink.core.common.h.a.this.m;
                if (kVar == null) {
                }
            }
        }
    }

    public static java.io.InputStream a(java.net.HttpURLConnection httpURLConnection) {
        java.io.InputStream inputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (java.lang.Exception unused) {
        }
        if (!"gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return inputStream;
        }
        try {
            byte[] bArr = new byte[2];
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream);
            bufferedInputStream.mark(2);
            int read = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            return (read == -1 || (((bArr[1] & 255) << 8) | (bArr[0] & 255)) != 35615) ? bufferedInputStream : new java.util.zip.GZIPInputStream(bufferedInputStream);
        } catch (java.lang.Exception unused2) {
            return inputStream;
        }
    }

    public static byte[] b(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void d(int i) {
        com.anythink.core.common.h.a.AnonymousClass1 anonymousClass1 = new com.anythink.core.common.h.a.AnonymousClass1(i);
        if (o()) {
            com.anythink.core.common.o.b.b.a().a((com.anythink.core.common.o.b.d) anonymousClass1, 1);
        } else {
            com.anythink.core.common.o.b.b.a().a((com.anythink.core.common.o.b.d) anonymousClass1, 10);
        }
    }

    private void p() {
        this.n = true;
    }

    private static void q() {
    }

    private static /* synthetic */ void r() {
    }

    public abstract int a();

    public abstract java.lang.Object a(java.lang.Object obj);

    public final void a(int i, int i2, java.lang.String str, com.anythink.core.api.AdError adError) {
        com.anythink.core.common.h.k kVar = this.m;
        if (kVar != null) {
            kVar.onLoadError(i, str, adError);
        }
        b(adError);
        b(i2);
    }

    public void a(int i, com.anythink.core.common.h.k kVar) {
        this.n = false;
        this.m = kVar;
        com.anythink.core.common.h.a.AnonymousClass1 anonymousClass1 = new com.anythink.core.common.h.a.AnonymousClass1(i);
        if (o()) {
            com.anythink.core.common.o.b.b.a().a((com.anythink.core.common.o.b.d) anonymousClass1, 1);
        } else {
            com.anythink.core.common.o.b.b.a().a((com.anythink.core.common.o.b.d) anonymousClass1, 10);
        }
    }

    public void a(int i, java.lang.Object obj) {
        com.anythink.core.common.h.k kVar = this.m;
        if (kVar != null) {
            kVar.onLoadFinish(i, obj);
        }
    }

    public final void a(int i, org.apache.http.conn.ConnectTimeoutException connectTimeoutException) {
        com.anythink.core.api.AdError errorCode = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, com.anythink.core.api.ErrorCode.exception, connectTimeoutException.getMessage());
        com.anythink.core.common.h.k kVar = this.m;
        if (kVar != null) {
            kVar.onLoadError(i, "Connect timeout.", errorCode);
        }
        b(errorCode);
        b(com.anythink.core.common.h.i.b);
    }

    public abstract void a(com.anythink.core.api.AdError adError);

    public abstract boolean a(int i);

    public abstract java.lang.String b();

    public void b(int i) {
    }

    public abstract void b(com.anythink.core.api.AdError adError);

    public abstract java.util.Map<java.lang.String, java.lang.String> c();

    public final void c(int i) {
        com.anythink.core.common.h.k kVar = this.m;
        if (kVar != null) {
            kVar.onLoadCanceled(i);
        }
    }

    public abstract byte[] d();

    public org.json.JSONObject e() {
        return com.anythink.core.common.h.c.a(l());
    }

    public org.json.JSONObject f() {
        return com.anythink.core.common.h.c.b(l());
    }

    public java.lang.String g() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String a2 = com.anythink.core.common.o.d.a(e().toString());
        java.lang.String a3 = com.anythink.core.common.o.d.a(f().toString());
        hashMap.put(com.anythink.core.common.h.c.O, m());
        hashMap.put("p", a2);
        hashMap.put(com.anythink.core.common.h.c.X, a3);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList(hashMap.size());
        arrayList.addAll(hashMap.keySet());
        java.util.Collections.sort(arrayList);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : arrayList) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(hashMap.get(str));
        }
        hashMap.put("sign", com.anythink.core.common.o.g.c(j() + sb.toString()));
        if (k() != null) {
            hashMap.putAll(k());
        }
        java.util.Set<java.lang.String> keySet = hashMap.keySet();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            for (java.lang.String str2 : keySet) {
                jSONObject.put(str2, java.lang.String.valueOf(hashMap.get(str2)));
            }
            return jSONObject.toString();
        } catch (java.lang.Exception unused) {
            return null;
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.System.gc();
            return null;
        }
    }

    public abstract java.lang.String h();

    public abstract android.content.Context i();

    public abstract java.lang.String j();

    public abstract java.util.Map<java.lang.String, java.lang.Object> k();

    public int l() {
        return 0;
    }

    public java.lang.String m() {
        return "1.0";
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }
}
