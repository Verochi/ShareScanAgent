package com.aliyun.common.resource;

/* loaded from: classes.dex */
public class ResourceParser {
    private static final java.lang.String TAG = "ResourceParser";
    private final com.aliyun.common.jasonparse.JSONSupport _JSON;

    public ResourceParser(com.aliyun.common.jasonparse.JSONSupport jSONSupport) {
        this._JSON = jSONSupport;
    }

    private <T> T readObject(java.io.File file, java.lang.Class<? extends T> cls) {
        try {
            return (T) this._JSON.readValue(file, cls);
        } catch (java.lang.Throwable unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("failed to read ");
            sb.append(file);
            sb.append(" as ");
            sb.append(cls);
            return null;
        }
    }

    private <T> T readObject(java.io.InputStream inputStream, java.lang.Class<? extends T> cls) {
        try {
            try {
                return (T) this._JSON.readValue(inputStream, cls);
            } catch (java.lang.Throwable unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("failed to read stream as ");
                sb.append(cls);
                try {
                    inputStream.close();
                    return null;
                } catch (java.io.IOException unused2) {
                    return null;
                }
            }
        } finally {
            try {
                inputStream.close();
            } catch (java.io.IOException unused3) {
            }
        }
    }

    public <T> T readObject(java.lang.String str, java.lang.Class<? extends T> cls) {
        java.io.InputStream resolveURI = resolveURI(str);
        if (resolveURI == null) {
            return null;
        }
        return (T) readObject(resolveURI, cls);
    }

    public <T extends com.aliyun.common.resource.Resource> T readResource(java.lang.String str, java.lang.Class<? extends T> cls) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith("/config.json")) {
            str = str + "/config.json";
        }
        T t = (T) readObject(str, cls);
        if (t == null || !t.validate()) {
            return null;
        }
        return t;
    }

    public java.io.InputStream resolveURI(java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String str2;
        android.net.Uri parse = android.net.Uri.parse(str);
        if (parse == null) {
            sb = new java.lang.StringBuilder();
            str2 = "failed to parse uri: ";
        } else {
            java.lang.String path = parse.getPath();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("scheme : ");
            sb2.append(parse.getScheme());
            sb2.append(" host : ");
            sb2.append(parse.getHost());
            sb2.append(" path : ");
            sb2.append(parse.getPath());
            try {
                return new java.io.FileInputStream(path);
            } catch (java.lang.Throwable unused) {
                sb = new java.lang.StringBuilder();
                str2 = "failed to open assets: ";
            }
        }
        sb.append(str2);
        sb.append(str);
        return null;
    }
}
