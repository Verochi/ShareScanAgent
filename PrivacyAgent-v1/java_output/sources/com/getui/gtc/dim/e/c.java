package com.getui.gtc.dim.e;

/* loaded from: classes22.dex */
public final class c {
    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.Object a(int i, java.lang.String str, android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null || i < 0) {
                return null;
            }
            return telephonyManager.getClass().getMethod(str, c(str)).invoke(telephonyManager, java.lang.Integer.valueOf(i));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    public static java.lang.Object a(byte[] bArr) throws java.lang.Exception {
        byte b = bArr[0];
        byte[] bArr2 = new byte[bArr.length - 1];
        java.lang.System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        if (b == 0) {
            return b(bArr2);
        }
        if (b != 1) {
            throw new java.lang.RuntimeException("bytesToObject failed, invalid type");
        }
        java.lang.Object c = c(bArr2);
        return c instanceof com.getui.gtc.dim.d.c ? ((com.getui.gtc.dim.d.c) c).getParcelables() : c;
    }

    public static java.lang.Process a(java.lang.String str) throws java.lang.Throwable {
        java.lang.Class<?> cls = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("amF2YS5sYW5nLlJ1bnRpbWU=", 0)));
        java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("Z2V0UnVudGltZQ==", 0)), new java.lang.Class[0]);
        declaredMethod.setAccessible(true);
        java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
        java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("ZXhlYw==", 0)), java.lang.String.class);
        declaredMethod2.setAccessible(true);
        return (java.lang.Process) declaredMethod2.invoke(invoke, str);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String[] split = str.split("#");
            int length = split.length;
            int i = 0;
            while (true) {
                java.lang.String str3 = "";
                if (i >= length) {
                    return "";
                }
                java.lang.String str4 = split[i];
                if (!str4.trim().isEmpty()) {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(a("getprop ".concat(str4)).getInputStream()));
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str3 = str3 + readLine;
                    }
                    bufferedReader.close();
                    if (!str3.trim().isEmpty()) {
                        return str3;
                    }
                }
                i++;
            }
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public static void a(android.content.Context context, java.lang.String str, boolean z) {
        try {
            z = context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        if (z) {
            return;
        }
        throw new java.lang.IllegalStateException("permission " + str + " not granted");
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static boolean a(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return true;
        }
    }

    public static boolean a(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof java.lang.CharSequence ? !android.text.TextUtils.isEmpty((java.lang.CharSequence) obj) : obj instanceof java.util.Collection ? ((java.util.Collection) obj).size() > 0 : !(obj instanceof java.util.Map) || ((java.util.Map) obj).size() > 0;
    }

    public static boolean a(byte[] bArr, java.io.File file) throws java.lang.Exception {
        if (bArr == null) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                byte[] bArr2 = new byte[521];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2);
                    if (read == -1) {
                        fileOutputStream2.flush();
                        com.getui.gtc.base.util.io.IOUtils.safeClose(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr2, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(android.os.Parcelable parcelable) {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        try {
            obtain.writeParcelable(parcelable, 0);
            byte[] marshall = obtain.marshall();
            byte[] bArr = new byte[marshall.length + 1];
            bArr[0] = 1;
            java.lang.System.arraycopy(marshall, 0, bArr, 1, marshall.length);
            return bArr;
        } finally {
            obtain.recycle();
        }
    }

    public static byte[] a(java.io.File file) throws java.lang.Exception {
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                byte[] bArr = new byte[521];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(java.io.Serializable serializable) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.ObjectOutputStream objectOutputStream = null;
        try {
            java.io.ObjectOutputStream objectOutputStream2 = new java.io.ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(serializable);
                objectOutputStream2.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bArr = new byte[byteArray.length + 1];
                bArr[0] = 0;
                java.lang.System.arraycopy(byteArray, 0, bArr, 1, byteArray.length);
                try {
                    objectOutputStream2.close();
                } catch (java.lang.Throwable unused) {
                }
                return bArr;
            } catch (java.lang.Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static java.lang.Object b(byte[] bArr) {
        java.io.ObjectInputStream objectInputStream;
        try {
            objectInputStream = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bArr));
            try {
                java.lang.Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (java.lang.Throwable unused) {
                }
                return readObject;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.getui.gtc.dim.e.b.a(th);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                    return null;
                } catch (java.lang.Throwable th2) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (java.lang.Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            objectInputStream = null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x00b5 -> B:17:0x00b8). Please report as a decompilation issue!!! */
    public static java.lang.String b(java.lang.String str) {
        java.lang.Process process;
        if (android.text.TextUtils.isEmpty(str) || "0.0.0.0".equalsIgnoreCase(str)) {
            return "";
        }
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                process = a(new java.lang.String(android.util.Base64.decode("aXAgbmVpZ2hib3Vy", 0)));
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                    int i = 0;
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                try {
                                    if (readLine.contains("192.168") || readLine.contains("wlan0")) {
                                        if (readLine.contains("FAILED")) {
                                            continue;
                                        } else {
                                            java.lang.String[] split = readLine.split(" +");
                                            if (split.length < 6) {
                                                continue;
                                            } else {
                                                int i2 = i + 1;
                                                if (i <= 256) {
                                                    try {
                                                        java.lang.String replaceAll = split[4].replaceAll(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
                                                        if (str.equalsIgnoreCase(split[0])) {
                                                            try {
                                                                bufferedReader2.close();
                                                            } catch (java.io.IOException e) {
                                                                com.getui.gtc.dim.e.b.a(e);
                                                            }
                                                            try {
                                                                process.destroy();
                                                            } catch (java.lang.Throwable th) {
                                                                com.getui.gtc.dim.e.b.a(th);
                                                            }
                                                            return replaceAll;
                                                        }
                                                        i = i2;
                                                    } catch (java.lang.Throwable th2) {
                                                        th = th2;
                                                        i = i2;
                                                        com.getui.gtc.dim.e.b.a(th);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                }
                            }
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e2) {
                                com.getui.gtc.dim.e.b.a(e2);
                            }
                            process.destroy();
                            break;
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            bufferedReader = bufferedReader2;
                            try {
                                com.getui.gtc.dim.e.b.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (java.io.IOException e3) {
                                        com.getui.gtc.dim.e.b.a(e3);
                                    }
                                }
                                if (process != null) {
                                    process.destroy();
                                }
                                return "";
                            } finally {
                            }
                        }
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                }
            } catch (java.lang.Throwable th6) {
                com.getui.gtc.dim.e.b.a(th6);
            }
        } catch (java.lang.Throwable th7) {
            th = th7;
            process = null;
        }
        return "";
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static boolean b(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return false;
        }
    }

    public static byte[] b(java.lang.Object obj) throws java.lang.Exception {
        if (obj instanceof android.os.Parcelable) {
            return a((android.os.Parcelable) obj);
        }
        if (obj instanceof java.util.List) {
            java.util.List list = (java.util.List) obj;
            if (list.get(0) instanceof android.os.Parcelable) {
                return a((android.os.Parcelable) new com.getui.gtc.dim.d.c((java.util.List<android.os.Parcelable>) list));
            }
        }
        if (obj instanceof java.io.Serializable) {
            return a((java.io.Serializable) obj);
        }
        throw new java.lang.IllegalArgumentException("objectToBytes failed, object type is not support: " + obj.getClass().getName());
    }

    private static java.lang.Object c(byte[] bArr) {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return obtain.readParcelable(com.getui.gtc.base.GtcProvider.context().getClassLoader());
        } finally {
            obtain.recycle();
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static boolean c(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return false;
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    private static java.lang.Class<?>[] c(java.lang.String str) {
        java.lang.Class<?>[] clsArr = null;
        try {
            for (java.lang.reflect.Method method : android.telephony.TelephonyManager.class.getDeclaredMethods()) {
                if (str.equals(method.getName())) {
                    clsArr = method.getParameterTypes();
                    if (clsArr.length > 0) {
                        break;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        return clsArr;
    }
}
