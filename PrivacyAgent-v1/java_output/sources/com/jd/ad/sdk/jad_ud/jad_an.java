package com.jd.ad.sdk.jad_ud;

/* loaded from: classes23.dex */
public class jad_an implements java.io.Closeable {

    @androidx.annotation.NonNull
    public final java.net.HttpURLConnection jad_an;

    public jad_an(@androidx.annotation.NonNull java.net.HttpURLConnection httpURLConnection) {
        this.jad_an = httpURLConnection;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.disconnect();
    }

    @androidx.annotation.Nullable
    public java.lang.String jad_bo() {
        try {
            if (jad_cp()) {
                return null;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unable to fetch ");
            sb.append(this.jad_an.getURL());
            sb.append(". Failed with ");
            sb.append(this.jad_an.getResponseCode());
            sb.append("\n");
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(this.jad_an.getErrorStream()));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb2.append(readLine);
                        sb2.append('\n');
                    } else {
                        try {
                            break;
                        } catch (java.lang.Exception unused) {
                        }
                    }
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Exception unused2) {
                    }
                }
            }
            sb.append(sb2.toString());
            return sb.toString();
        } catch (java.io.IOException e) {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("get error failed ", e);
            return e.getMessage();
        }
    }

    public boolean jad_cp() {
        try {
            return this.jad_an.getResponseCode() / 100 == 2;
        } catch (java.io.IOException unused) {
            return false;
        }
    }
}
