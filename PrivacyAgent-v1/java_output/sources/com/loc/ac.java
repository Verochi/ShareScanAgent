package com.loc;

/* loaded from: classes23.dex */
public final class ac {
    public static java.lang.String a() {
        java.lang.String str;
        str = "";
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/sys/kernel/random/boot_id"));
            java.lang.String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            java.lang.String a = com.loc.z.a(context);
            try {
                if (!android.text.TextUtils.isEmpty(a)) {
                    return a;
                }
                a = java.util.UUID.randomUUID().toString();
                com.loc.z.a(context, a);
                return a;
            } catch (java.lang.Throwable unused) {
                return a;
            }
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    private static java.util.Date a(java.lang.String str) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ bArr2[i % bArr2.length]) ^ (i & 255));
            }
        }
        return bArr;
    }

    public static java.lang.String b() {
        java.lang.String str = "";
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("stat -c %z /data/app").getInputStream()));
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine != null) {
                java.lang.String[] split = readLine.split("\\.");
                java.util.Date a = a(split[0]);
                java.lang.String str2 = split[1];
                java.lang.String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (android.text.TextUtils.isEmpty(trim)) {
                    str = java.lang.String.valueOf(a.getTime() / 1000);
                } else {
                    str = (a.getTime() / 1000) + "." + c(trim);
                }
            }
            bufferedReader.close();
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    private static java.lang.String b(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(java.lang.Integer.toHexString(b & 255));
            }
            return stringBuffer.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static int c(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return 0;
            }
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public static java.lang.String c() {
        java.lang.String str = "";
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("stat -c %z /data/").getInputStream()));
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine != null) {
                java.lang.String[] split = readLine.split("\\.");
                java.util.Date a = a(split[0]);
                java.lang.String str2 = split[1];
                java.lang.String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (android.text.TextUtils.isEmpty(trim)) {
                    str = java.lang.String.valueOf(a.getTime() / 1000);
                } else {
                    str = (a.getTime() / 1000) + "." + c(trim);
                }
            }
            bufferedReader.close();
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    public static java.lang.String d() {
        java.lang.String str = "";
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("stat -c %x /data/data").getInputStream()));
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine != null) {
                java.lang.String[] split = readLine.split("\\.");
                java.util.Date a = a(split[0]);
                java.lang.String str2 = split[1];
                java.lang.String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (android.text.TextUtils.isEmpty(trim)) {
                    str = java.lang.String.valueOf(a.getTime() / 1000);
                } else {
                    str = (a.getTime() / 1000) + "." + c(trim);
                }
            }
            bufferedReader.close();
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    public static java.lang.String e() {
        java.lang.String str = "";
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("stat -c %x /data/app").getInputStream()));
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine != null) {
                java.lang.String[] split = readLine.split("\\.");
                java.util.Date a = a(split[0]);
                java.lang.String str2 = split[1];
                java.lang.String trim = str2 != null ? str2.split("\\+")[0].trim() : "";
                if (android.text.TextUtils.isEmpty(trim)) {
                    str = java.lang.String.valueOf(a.getTime() / 1000);
                } else {
                    str = (a.getTime() / 1000) + "." + c(trim);
                }
            }
            bufferedReader.close();
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    public static java.lang.String f() {
        java.lang.String str;
        str = "";
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("stat -c %i /data/data").getInputStream()));
            java.lang.String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    public static java.lang.String g() {
        java.lang.String str;
        str = "";
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("stat -c %i /data/app").getInputStream()));
            java.lang.String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    public static java.lang.String h() {
        try {
            java.lang.reflect.Method declaredMethod = android.os.Build.class.getDeclaredMethod("getString", java.lang.String.class);
            declaredMethod.setAccessible(true);
            java.lang.String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : b(obj);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
