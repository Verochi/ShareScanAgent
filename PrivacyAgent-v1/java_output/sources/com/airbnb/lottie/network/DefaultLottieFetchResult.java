package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public class DefaultLottieFetchResult implements com.airbnb.lottie.network.LottieFetchResult {

    @androidx.annotation.NonNull
    public final java.net.HttpURLConnection n;

    public DefaultLottieFetchResult(@androidx.annotation.NonNull java.net.HttpURLConnection httpURLConnection) {
        this.n = httpURLConnection;
    }

    public final java.lang.String a(java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getErrorStream()));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            try {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (java.lang.Exception unused) {
                        }
                    }
                } catch (java.lang.Exception e) {
                    throw e;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (java.lang.Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @androidx.annotation.NonNull
    public java.io.InputStream bodyByteStream() throws java.io.IOException {
        return this.n.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.n.disconnect();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @androidx.annotation.Nullable
    public java.lang.String contentType() {
        return this.n.getContentType();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @androidx.annotation.Nullable
    public java.lang.String error() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.n.getURL() + ". Failed with " + this.n.getResponseCode() + "\n" + a(this.n);
        } catch (java.io.IOException e) {
            com.airbnb.lottie.utils.Logger.warning("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() {
        try {
            return this.n.getResponseCode() / 100 == 2;
        } catch (java.io.IOException unused) {
            return false;
        }
    }
}
