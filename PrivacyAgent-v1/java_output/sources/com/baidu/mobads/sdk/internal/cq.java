package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class cq {
    private static volatile com.baidu.mobads.sdk.internal.cq a;
    private boolean b;
    private boolean c;

    private cq() {
    }

    public static com.baidu.mobads.sdk.internal.cq a() {
        if (a == null) {
            synchronized (com.baidu.mobads.sdk.internal.cq.class) {
                if (a == null) {
                    a = new com.baidu.mobads.sdk.internal.cq();
                }
            }
        }
        return a;
    }

    private java.lang.Boolean a(java.lang.String str, java.lang.String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(java.util.Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return java.lang.Boolean.valueOf(z);
    }

    public java.lang.Boolean a(java.lang.String str) {
        return a(str, "http:");
    }

    public java.lang.String a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        if (hashMap == null || hashMap.isEmpty()) {
            return sb.toString();
        }
        sb.append("?");
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
            try {
                sb.append(entry.getKey());
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(entry.getValue());
                sb.append("&");
            } catch (java.lang.Exception e) {
                com.baidu.mobads.sdk.internal.bt.a().c(e);
            }
        }
        return sb.toString().substring(0, r3.length() - 1);
    }

    public java.net.HttpURLConnection a(java.net.URL url) {
        return url.getProtocol().toLowerCase().equals("https") ? (javax.net.ssl.HttpsURLConnection) url.openConnection() : (java.net.HttpURLConnection) url.openConnection();
    }

    public void a(java.net.HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (java.lang.Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (java.lang.Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Throwable unused3) {
            }
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public java.lang.Boolean b(java.lang.String str) {
        return a(str, "https:");
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.c;
    }

    public java.lang.String c(java.lang.String str) {
        return (this.b && a(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }

    public java.lang.Boolean d(java.lang.String str) {
        return java.lang.Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    public java.lang.String e(java.lang.String str) {
        try {
            java.lang.String path = new java.net.URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (java.net.URISyntaxException unused) {
            return "";
        }
    }

    public boolean f(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) || !str.contains("/thefatherofsalmon.com");
    }

    public java.lang.String g(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public java.lang.String h(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String[] split = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public void i(java.lang.String str) {
        new com.baidu.mobads.sdk.internal.am(str).b();
    }
}
