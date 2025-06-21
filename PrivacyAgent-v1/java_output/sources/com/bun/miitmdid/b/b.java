package com.bun.miitmdid.b;

/* loaded from: classes.dex */
public class b {
    private static boolean h;
    private java.lang.String a = null;
    private com.bun.miitmdid.b.b.InterfaceC0256b b = null;
    private java.lang.Object c = null;
    private java.util.Map<java.lang.String, java.lang.String> d = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> e = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();
    private java.lang.String g = "GET";

    public class a extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.bun.miitmdid.b.b.c> {
        com.bun.miitmdid.b.b a;

        public a() {
            this.a = com.bun.miitmdid.b.b.this;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bun.miitmdid.b.b.c doInBackground(java.lang.Void... voidArr) {
            return this.a.g.equalsIgnoreCase("GET") ? com.bun.miitmdid.b.b.this.b() : com.bun.miitmdid.b.b.this.c();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(com.bun.miitmdid.b.b.c cVar) {
            com.bun.miitmdid.b.b.InterfaceC0256b interfaceC0256b;
            super.onPostExecute(cVar);
            if (com.bun.miitmdid.b.b.this.b != null) {
                if (cVar == null) {
                    com.bun.miitmdid.b.b.this.b.a(new java.lang.Exception("Unknown Error"), -1, null);
                    return;
                }
                if (cVar.c != null) {
                    interfaceC0256b = com.bun.miitmdid.b.b.this.b;
                    e = cVar.c;
                } else {
                    try {
                        com.bun.miitmdid.b.b.this.b.a(null, cVar.b, cVar.a);
                        return;
                    } catch (java.lang.Exception e) {
                        e = e;
                        interfaceC0256b = com.bun.miitmdid.b.b.this.b;
                    }
                }
                interfaceC0256b.a(e, -1, null);
            }
        }
    }

    /* renamed from: com.bun.miitmdid.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0256b {
        void a(java.lang.Exception exc, int i, java.lang.String str);
    }

    public class c {
        private java.lang.String a;
        private int b;
        private java.lang.Exception c;

        public c(com.bun.miitmdid.b.b bVar, java.lang.String str, java.lang.Exception exc, int i) {
            this.a = str;
            this.c = exc;
            this.b = i;
        }
    }

    private b(android.content.Context context) {
    }

    public static com.bun.miitmdid.b.b a(@androidx.annotation.NonNull android.content.Context context) {
        return new com.bun.miitmdid.b.b(context);
    }

    private void a(java.net.HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bun.miitmdid.b.b.c b() {
        try {
            java.lang.String d = d();
            if (h) {
                b("Making Get url call to " + d);
            }
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(d).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (java.lang.String str : this.d.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.d.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            java.lang.System.out.println("\nSending 'GET' request to URL : " + this.a);
            java.lang.System.out.println("Response Code : " + responseCode);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new com.bun.miitmdid.b.b.c(this, sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (java.lang.Exception e) {
            if (h) {
                e.printStackTrace();
            }
            return new com.bun.miitmdid.b.b.c(this, null, e, -1);
        }
    }

    private static void b(@androidx.annotation.NonNull java.lang.String str) {
        com.bun.lib.a.b(com.bun.miitmdid.b.b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bun.miitmdid.b.b.c c() {
        java.lang.String obj;
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(d()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("");
            if (this.e.isEmpty()) {
                java.lang.Object obj2 = this.c;
                if (obj2 != null) {
                    if (!(obj2 instanceof org.json.JSONObject) && !(obj2 instanceof org.json.JSONArray)) {
                        if (obj2 instanceof java.lang.String) {
                            obj = (java.lang.String) obj2;
                            sb.append(obj);
                        }
                    }
                    obj = obj2.toString();
                    sb.append(obj);
                }
            } else {
                for (java.lang.String str : this.e.keySet()) {
                    sb.append(str);
                    sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(java.net.URLEncoder.encode(this.e.get(str), "UTF-8"));
                    sb.append("&");
                }
            }
            for (java.lang.String str2 : this.d.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.d.get(str2));
                }
            }
            java.lang.String sb2 = sb.toString();
            httpURLConnection.setDoOutput(true);
            java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(sb2);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (h) {
                b("\nSending 'POST' request to URL : " + this.a);
                b("Post parameters : " + sb2);
                b("Response Code : " + responseCode);
            }
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream()));
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    java.lang.String sb4 = sb3.toString();
                    b("\nPOST RESPONSE : " + sb4);
                    return new com.bun.miitmdid.b.b.c(this, sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (java.lang.Exception e) {
            if (h) {
                e.printStackTrace();
            }
            return new com.bun.miitmdid.b.b.c(this, null, e, -1);
        }
    }

    private java.lang.String d() {
        if (this.a == null) {
            throw new java.lang.NullPointerException("URL IS NULL");
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        try {
            if (this.a.trim().endsWith("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            for (java.lang.String str : this.f.keySet()) {
                if (!str.isEmpty()) {
                    sb.append(str.trim());
                    sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(java.net.URLEncoder.encode(this.f.get(str), "UTF-8"));
                    sb.append("&");
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return this.a + (sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString());
    }

    public com.bun.miitmdid.b.b a() {
        new com.bun.miitmdid.b.b.a().executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
        return this;
    }

    public com.bun.miitmdid.b.b a(com.bun.miitmdid.b.b.InterfaceC0256b interfaceC0256b) {
        this.b = interfaceC0256b;
        return this;
    }

    public com.bun.miitmdid.b.b a(java.lang.Object obj) {
        this.c = obj;
        return this;
    }

    public com.bun.miitmdid.b.b a(@androidx.annotation.NonNull java.lang.String str) {
        this.a = str;
        this.g = "POST";
        return this;
    }

    public com.bun.miitmdid.b.b a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        this.f.put(str, str2);
        return this;
    }

    public com.bun.miitmdid.b.b a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null && !map.isEmpty()) {
            this.f.putAll(map);
        }
        return this;
    }
}
