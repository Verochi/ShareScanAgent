package com.efs.sdk.base.core.util.a;

/* loaded from: classes22.dex */
public final class a implements com.efs.sdk.base.http.IHttpUtil {

    /* renamed from: com.efs.sdk.base.core.util.a.a$a, reason: collision with other inner class name */
    public static class C0284a {
        private static final com.efs.sdk.base.core.util.a.a a = new com.efs.sdk.base.core.util.a.a((byte) 0);
    }

    private a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static com.efs.sdk.base.core.util.a.a a() {
        return com.efs.sdk.base.core.util.a.a.C0284a.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @androidx.annotation.NonNull
    private static com.efs.sdk.base.http.HttpResponse a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable byte[] bArr) {
        java.io.FileInputStream fileInputStream;
        java.io.OutputStream outputStream;
        java.io.DataOutputStream dataOutputStream;
        java.io.FileInputStream fileInputStream2;
        java.io.FileInputStream fileInputStream3;
        java.io.FileInputStream fileInputStream4;
        com.efs.sdk.base.http.HttpResponse httpResponse = new com.efs.sdk.base.http.HttpResponse();
        java.net.HttpURLConnection httpURLConnection = null;
        r4 = null;
        r4 = null;
        r4 = null;
        ?? r4 = null;
        httpURLConnection = null;
        httpURLConnection = null;
        httpURLConnection = null;
        try {
            try {
                java.net.HttpURLConnection a = a(str, map);
                try {
                    a.setRequestMethod("POST");
                    a.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
                    a.setRequestProperty("Content-Type", "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb");
                    outputStream = a.getOutputStream();
                    try {
                        dataOutputStream = new java.io.DataOutputStream(outputStream);
                        try {
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                            if (bArr == 0) {
                                if (file != null && file.exists()) {
                                    dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    fileInputStream4 = new java.io.FileInputStream(file);
                                    try {
                                        byte[] bArr2 = new byte[4096];
                                        while (true) {
                                            int read = fileInputStream4.read(bArr2);
                                            if (read == -1) {
                                                break;
                                            }
                                            dataOutputStream.write(bArr2, 0, read);
                                        }
                                        r4 = fileInputStream4;
                                    } catch (java.net.SocketTimeoutException e) {
                                        e = e;
                                        httpURLConnection = a;
                                        fileInputStream3 = fileInputStream4;
                                        httpResponse.setHttpCode(-3);
                                        com.efs.sdk.base.core.util.Log.e("efs.util.http", "post file '" + str + "' error", e);
                                        bArr = fileInputStream3;
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    } catch (java.net.UnknownHostException e2) {
                                        e = e2;
                                        httpURLConnection = a;
                                        fileInputStream2 = fileInputStream4;
                                        httpResponse.setHttpCode(-2);
                                        com.efs.sdk.base.core.util.Log.e("efs.util.http", "post file '" + str + "' error， maybe network is disconnect", e);
                                        bArr = fileInputStream2;
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        httpURLConnection = a;
                                        fileInputStream = fileInputStream4;
                                        com.efs.sdk.base.core.util.Log.e("efs.util.http", "post file '" + str + "' error", th);
                                        bArr = fileInputStream;
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    }
                                }
                                b(a);
                                com.efs.sdk.base.core.util.FileUtil.safeClose(outputStream);
                                com.efs.sdk.base.core.util.FileUtil.safeClose(dataOutputStream);
                                com.efs.sdk.base.core.util.FileUtil.safeClose(null);
                                return httpResponse;
                            }
                            dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(bArr, 0, bArr.length);
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                            httpResponse = a(a);
                            b(a);
                            com.efs.sdk.base.core.util.FileUtil.safeClose(outputStream);
                            com.efs.sdk.base.core.util.FileUtil.safeClose(dataOutputStream);
                            com.efs.sdk.base.core.util.FileUtil.safeClose(r4);
                        } catch (java.net.SocketTimeoutException e3) {
                            e = e3;
                            fileInputStream4 = r4;
                        } catch (java.net.UnknownHostException e4) {
                            e = e4;
                            fileInputStream4 = r4;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            fileInputStream4 = r4;
                        }
                    } catch (java.net.SocketTimeoutException e5) {
                        e = e5;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (java.net.UnknownHostException e6) {
                        e = e6;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    }
                } catch (java.net.SocketTimeoutException e7) {
                    e = e7;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (java.net.UnknownHostException e8) {
                    e = e8;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                }
            } finally {
                b(httpURLConnection);
                com.efs.sdk.base.core.util.FileUtil.safeClose(outputStream);
                com.efs.sdk.base.core.util.FileUtil.safeClose(dataOutputStream);
                com.efs.sdk.base.core.util.FileUtil.safeClose(bArr);
            }
        } catch (java.net.SocketTimeoutException e9) {
            e = e9;
            fileInputStream3 = null;
            outputStream = null;
            dataOutputStream = null;
        } catch (java.net.UnknownHostException e10) {
            e = e10;
            fileInputStream2 = null;
            outputStream = null;
            dataOutputStream = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            fileInputStream = null;
            outputStream = null;
            dataOutputStream = null;
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    private static com.efs.sdk.base.http.HttpResponse a(java.net.HttpURLConnection httpURLConnection) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        com.efs.sdk.base.http.HttpResponse httpResponse = new com.efs.sdk.base.http.HttpResponse();
        if (httpURLConnection == null) {
            return httpResponse;
        }
        try {
            httpResponse.setHttpCode(httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new java.io.ByteArrayOutputStream(inputStream.available());
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            com.efs.sdk.base.core.util.Log.e("efs.util.http", "get response error", th);
                            return httpResponse;
                        } finally {
                            com.efs.sdk.base.core.util.FileUtil.safeClose(inputStream);
                            com.efs.sdk.base.core.util.FileUtil.safeClose(byteArrayOutputStream);
                        }
                    }
                }
                httpResponse.data = byteArrayOutputStream.toString();
            } catch (java.lang.Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
        return httpResponse;
    }

    private static java.net.HttpURLConnection a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (map == null) {
            map = java.util.Collections.emptyMap();
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    private static void b(java.net.HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                com.efs.sdk.base.core.util.FileUtil.safeClose(httpURLConnection.getInputStream());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse get(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.net.HttpURLConnection httpURLConnection;
        com.efs.sdk.base.http.HttpResponse httpResponse = new com.efs.sdk.base.http.HttpResponse();
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            httpURLConnection = null;
            try {
                try {
                    httpURLConnection = a(str, map);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
                    httpURLConnection.connect();
                    httpResponse = a(httpURLConnection);
                    b(httpURLConnection);
                    break;
                } finally {
                    try {
                        i++;
                        b(httpURLConnection);
                    } catch (java.lang.Throwable th) {
                        b(httpURLConnection);
                    }
                }
            } catch (java.net.SocketTimeoutException e) {
                httpResponse.setHttpCode(-3);
                com.efs.sdk.base.core.util.Log.e("efs.util.http", "post file '" + str + "' error", e);
            } catch (java.net.UnknownHostException e2) {
                httpResponse.setHttpCode(-2);
                com.efs.sdk.base.core.util.Log.e("efs.util.http", "get request '" + str + "' error， maybe network is disconnect", e2);
            }
            i++;
            b(httpURLConnection);
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse post(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, @androidx.annotation.NonNull java.io.File file) {
        return a(str, map, file, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.net.HttpURLConnection] */
    @Override // com.efs.sdk.base.http.IHttpUtil
    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse post(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, @androidx.annotation.NonNull byte[] bArr) {
        com.efs.sdk.base.http.HttpResponse httpResponse = new com.efs.sdk.base.http.HttpResponse();
        java.io.OutputStream outputStream = null;
        try {
            try {
                map = a(str, map);
                try {
                    map.setRequestMethod("POST");
                    map.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
                    outputStream = map.getOutputStream();
                    outputStream.write(bArr);
                    httpResponse = a(map);
                } catch (java.net.SocketTimeoutException e) {
                    e = e;
                    httpResponse.setHttpCode(-3);
                    com.efs.sdk.base.core.util.Log.e("efs.util.http", "post file '" + str + "' error", e);
                    map = map;
                    httpResponse.setReqUrl(str);
                    return httpResponse;
                } catch (java.net.UnknownHostException e2) {
                    e = e2;
                    httpResponse.setHttpCode(-2);
                    com.efs.sdk.base.core.util.Log.e("efs.util.http", "post data to '" + str + "' error， maybe network is disconnect", e);
                    map = map;
                    httpResponse.setReqUrl(str);
                    return httpResponse;
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.efs.sdk.base.core.util.Log.e("efs.util.http", "post data '" + str + "' error", th);
                    map = map;
                    httpResponse.setReqUrl(str);
                    return httpResponse;
                }
            } finally {
                com.efs.sdk.base.core.util.FileUtil.safeClose(outputStream);
                b(map);
            }
        } catch (java.net.SocketTimeoutException e3) {
            e = e3;
            map = 0;
        } catch (java.net.UnknownHostException e4) {
            e = e4;
            map = 0;
        } catch (java.lang.Throwable th2) {
            th = th2;
            map = 0;
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse postAsFile(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, byte[] bArr) {
        return a(str, map, null, bArr);
    }
}
