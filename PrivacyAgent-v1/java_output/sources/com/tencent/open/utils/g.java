package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class g {
    private static java.util.Map<java.lang.String, com.tencent.open.utils.g> a = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private static java.lang.String b = null;
    private android.content.Context c;
    private java.lang.String d;
    private org.json.JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    /* renamed from: com.tencent.open.utils.g$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.os.Bundle a;

        public AnonymousClass1(android.os.Bundle bundle) {
            this.a = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.tencent.open.utils.g.this.a(com.tencent.open.utils.l.d(com.tencent.open.utils.HttpUtils.openUrl2(com.tencent.open.utils.g.this.c, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.a).a));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.tencent.open.utils.g.this.g = 0;
        }
    }

    private g(android.content.Context context, java.lang.String str) {
        this.c = null;
        this.d = null;
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    public static com.tencent.open.utils.g a(android.content.Context context, java.lang.String str) {
        com.tencent.open.utils.g gVar;
        synchronized (a) {
            com.tencent.open.log.SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null && (str = b) == null) {
                str = "0";
            }
            gVar = a.get(str);
            if (gVar == null) {
                gVar = new com.tencent.open.utils.g(context, str);
                a.put(str, gVar);
            }
            com.tencent.open.log.SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return gVar;
    }

    private void a() {
        try {
            this.e = new org.json.JSONObject(c("com.tencent.open.config.json"));
        } catch (org.json.JSONException unused) {
            this.e = new org.json.JSONObject();
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        try {
            if (this.d != null) {
                str = str + "." + this.d;
            }
            java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(this.c.openFileOutput(str, 0), java.nio.charset.Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(org.json.JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = android.os.SystemClock.elapsedRealtime();
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", android.os.Build.MODEL);
        bundle.putString("status_version", android.os.Build.VERSION.SDK);
        bundle.putString("sdkv", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new com.tencent.open.utils.g.AnonymousClass1(bundle).start();
    }

    private java.lang.String c(java.lang.String str) {
        java.io.InputStream open;
        java.lang.String str2;
        java.lang.String str3 = "";
        try {
            try {
                if (this.d != null) {
                    str2 = str + "." + this.d;
                } else {
                    str2 = str;
                }
                open = this.c.openFileInput(str2);
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return "";
            }
        } catch (java.io.FileNotFoundException unused) {
            open = this.c.getAssets().open(str);
        }
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(open, java.nio.charset.Charset.forName("UTF-8")));
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (true) {
            try {
                try {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                    open.close();
                    bufferedReader.close();
                }
            } catch (java.lang.Throwable th) {
                try {
                    open.close();
                    bufferedReader.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        str3 = stringBuffer.toString();
        open.close();
        bufferedReader.close();
        return str3;
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (android.os.SystemClock.elapsedRealtime() - this.f >= optInt * 3600000) {
            b();
        }
    }

    private void d(java.lang.String str) {
        if (this.h) {
            com.tencent.open.log.SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    public int a(java.lang.String str) {
        d("get " + str);
        c();
        return this.e.optInt(str);
    }

    public boolean b(java.lang.String str) {
        d("get " + str);
        c();
        java.lang.Object opt = this.e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof java.lang.Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) opt).booleanValue();
        }
        return false;
    }
}
