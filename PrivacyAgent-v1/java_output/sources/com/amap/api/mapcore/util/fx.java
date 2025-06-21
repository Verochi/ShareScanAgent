package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fx {
    public static java.lang.String a = "9aj&#k81";
    public static java.lang.String b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";
    static byte[] c = null;
    public static boolean d = false;
    public static boolean e = false;
    private static java.lang.String k = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKASEDawAJA3QADQOBABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PUNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlJWVdsa1BRPT1NZkhObGNtbGhiRDA9UVlXNWtjbTlwWkY5cFpBPT0=";
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> l = new java.util.concurrent.ConcurrentHashMap<>(8);
    public static final java.lang.Integer f = 1;
    public static final java.lang.Integer g = 2;
    public static final java.lang.Integer h = 3;
    public static final java.lang.Integer i = 4;
    public static final java.lang.Integer j = 5;

    public static java.lang.String a(java.lang.String str) {
        java.lang.String str2 = "";
        try {
            synchronized (l) {
                if (l != null && l.containsKey(str)) {
                    str2 = l.get(str);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return str2;
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                synchronized (l) {
                    if (l == null) {
                        l = new java.util.concurrent.ConcurrentHashMap<>(8);
                    }
                    if (!l.containsKey(str)) {
                        l.put(str, str2);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static byte[] a(int i2) {
        if (c == null) {
            c = com.amap.api.mapcore.util.fa.b(k);
        }
        byte[] bArr = new byte[4];
        java.lang.System.arraycopy(c, i2 * 4, bArr, 0, 4);
        int i3 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i4 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i4];
        java.lang.System.arraycopy(c, i3, bArr2, 0, i4);
        return bArr2;
    }
}
