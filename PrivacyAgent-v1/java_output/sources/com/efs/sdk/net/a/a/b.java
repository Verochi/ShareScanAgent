package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public final class b {
    java.util.Map<java.lang.String, java.lang.Long> a = new java.util.HashMap();

    public static long a(com.efs.sdk.net.a.a.f.b bVar) {
        try {
            if (bVar.d() != null) {
                return r2.length;
            }
            return 0L;
        } catch (java.io.IOException | java.lang.OutOfMemoryError e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private static java.io.ByteArrayOutputStream a(java.io.InputStream inputStream, com.efs.sdk.net.a.c cVar, java.lang.String str) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (java.io.IOException e) {
                com.efs.sdk.base.core.util.Log.e("NetTrace-Interceptor", "parse and save body, e is ".concat(java.lang.String.valueOf(e)));
            }
        }
        byteArrayOutputStream.flush();
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        java.io.BufferedReader bufferedReader = "gzip".equals(str) ? new java.io.BufferedReader(new java.io.InputStreamReader(new java.util.zip.GZIPInputStream(byteArrayInputStream))) : new java.io.BufferedReader(new java.io.InputStreamReader(byteArrayInputStream));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine + '\n');
        }
        java.lang.String sb2 = sb.toString();
        try {
            if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetResponseBodyCollectState() && sb2.getBytes().length < 10240 && (cVar.j.contains(com.baidu.mobads.sdk.internal.am.d) || cVar.j.contains(com.anythink.expressad.foundation.g.f.g.b.e) || cVar.j.contains(com.baidu.mobads.sdk.internal.am.e))) {
                cVar.k = sb2;
            }
        } catch (java.lang.Throwable unused) {
        }
        cVar.m = sb2.getBytes().length;
        return byteArrayOutputStream;
    }

    public static java.io.InputStream a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.io.InputStream inputStream) {
        com.efs.sdk.base.core.util.Log.i("NetTrace-Interceptor", "save interpret response stream");
        com.efs.sdk.net.a.c a = com.efs.sdk.net.a.a.a().a(str);
        a.j = str2;
        if (str2 != null) {
            if (str2.contains("text") || str2.contains(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON)) {
                java.io.ByteArrayOutputStream a2 = a(inputStream, a, str3);
                java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(a2.toByteArray());
                try {
                    a2.close();
                } catch (java.io.IOException e) {
                    com.efs.sdk.base.core.util.Log.e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(java.lang.String.valueOf(e)));
                }
                return byteArrayInputStream;
            }
        }
        a.m = 0L;
        return inputStream;
    }
}
