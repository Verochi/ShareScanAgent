package com.tencent.mm.opensdk.channel.a;

/* loaded from: classes19.dex */
public class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0497a {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public long d;
        public android.os.Bundle e;
    }

    public static java.lang.Object a(int i, java.lang.String str) {
        try {
            switch (i) {
                case 1:
                    return java.lang.Integer.valueOf(str);
                case 2:
                    return java.lang.Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return java.lang.Boolean.valueOf(str);
                case 5:
                    return java.lang.Float.valueOf(str);
                case 6:
                    return java.lang.Double.valueOf(str);
                default:
                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
            return null;
        }
    }

    public static java.lang.String a(android.os.Bundle bundle, java.lang.String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(android.content.Context context, com.tencent.mm.opensdk.channel.a.a.C0497a c0497a) {
        java.lang.String str;
        java.lang.String str2;
        if (context == null || c0497a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!com.tencent.mm.opensdk.utils.b.b(c0497a.b)) {
                if (com.tencent.mm.opensdk.utils.b.b(c0497a.a)) {
                    str2 = null;
                } else {
                    str2 = c0497a.a + ".permission.MM_MESSAGE";
                }
                android.content.Intent intent = new android.content.Intent(c0497a.b);
                android.os.Bundle bundle = c0497a.e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                java.lang.String packageName = context.getPackageName();
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.SDK_VERSION, com.tencent.mm.opensdk.constants.Build.SDK_INT);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CONTENT, c0497a.c);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0497a.d);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CHECK_SUM, a(c0497a.c, com.tencent.mm.opensdk.constants.Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x015b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:171:0x015b */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(java.lang.String str, int i) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        ?? r8;
        java.io.ByteArrayOutputStream byteArrayOutputStream3;
        java.lang.String str2;
        ?? r3;
        java.lang.Object obj;
        java.io.InputStream inputStream;
        java.lang.Exception e;
        java.net.HttpURLConnection httpURLConnection;
        java.io.InputStream inputStream2;
        java.io.IOException e2;
        java.net.HttpURLConnection httpURLConnection2;
        java.io.InputStream inputStream3;
        java.net.MalformedURLException e3;
        java.net.HttpURLConnection httpURLConnection3;
        java.io.InputStream inputStream4;
        java.io.ByteArrayOutputStream byteArrayOutputStream4;
        java.io.ByteArrayOutputStream byteArrayOutputStream5;
        java.io.ByteArrayOutputStream byteArrayOutputStream6;
        java.net.HttpURLConnection httpURLConnection4;
        java.net.HttpURLConnection httpURLConnection5;
        java.net.HttpURLConnection httpURLConnection6;
        java.io.ByteArrayOutputStream byteArrayOutputStream7;
        java.io.InputStream inputStream5 = null;
        if (str != null) {
            int length = str.length();
            try {
                if (length != 0) {
                    try {
                        ?? r82 = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                        try {
                            if (r82 == 0) {
                                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                                if (r82 != 0) {
                                    try {
                                        r82.disconnect();
                                    } catch (java.lang.Throwable unused) {
                                    }
                                }
                                return null;
                            }
                            try {
                                r82.setRequestMethod("GET");
                                r82.setConnectTimeout(i);
                                r82.setReadTimeout(i);
                                if (r82.getResponseCode() >= 300) {
                                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                                    try {
                                        r82.disconnect();
                                    } catch (java.lang.Throwable unused2) {
                                    }
                                    return null;
                                }
                                java.io.InputStream inputStream6 = r82.getInputStream();
                                try {
                                    byteArrayOutputStream7 = new java.io.ByteArrayOutputStream();
                                } catch (java.net.MalformedURLException e4) {
                                    inputStream4 = inputStream6;
                                    e3 = e4;
                                    httpURLConnection3 = r82;
                                    byteArrayOutputStream6 = null;
                                    httpURLConnection6 = httpURLConnection3;
                                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                                    if (httpURLConnection6 != null) {
                                        try {
                                            httpURLConnection6.disconnect();
                                        } catch (java.lang.Throwable unused3) {
                                        }
                                    }
                                    if (inputStream4 != null) {
                                        try {
                                            inputStream4.close();
                                        } catch (java.lang.Throwable unused4) {
                                        }
                                    }
                                    if (byteArrayOutputStream6 != null) {
                                        try {
                                            byteArrayOutputStream6.close();
                                        } catch (java.lang.Throwable unused5) {
                                        }
                                    }
                                    return null;
                                } catch (java.io.IOException e5) {
                                    inputStream3 = inputStream6;
                                    e2 = e5;
                                    httpURLConnection2 = r82;
                                    byteArrayOutputStream5 = null;
                                    httpURLConnection5 = httpURLConnection2;
                                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                                    if (httpURLConnection5 != null) {
                                        try {
                                            httpURLConnection5.disconnect();
                                        } catch (java.lang.Throwable unused6) {
                                        }
                                    }
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (java.lang.Throwable unused7) {
                                        }
                                    }
                                    if (byteArrayOutputStream5 != null) {
                                        try {
                                            byteArrayOutputStream5.close();
                                        } catch (java.lang.Throwable unused8) {
                                        }
                                    }
                                    return null;
                                } catch (java.lang.Exception e6) {
                                    inputStream2 = inputStream6;
                                    e = e6;
                                    httpURLConnection = r82;
                                    byteArrayOutputStream4 = null;
                                    httpURLConnection4 = httpURLConnection;
                                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                    if (httpURLConnection4 != null) {
                                        try {
                                            httpURLConnection4.disconnect();
                                        } catch (java.lang.Throwable unused9) {
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (java.lang.Throwable unused10) {
                                        }
                                    }
                                    if (byteArrayOutputStream4 != null) {
                                        try {
                                            byteArrayOutputStream4.close();
                                        } catch (java.lang.Throwable unused11) {
                                        }
                                    }
                                    return null;
                                } catch (java.lang.Throwable th) {
                                    inputStream = inputStream6;
                                    th = th;
                                    obj = r82;
                                    inputStream5 = inputStream;
                                    byteArrayOutputStream3 = null;
                                    r8 = obj;
                                    if (r8 != 0) {
                                        try {
                                            r8.disconnect();
                                        } catch (java.lang.Throwable unused12) {
                                        }
                                    }
                                    if (inputStream5 != null) {
                                        try {
                                            inputStream5.close();
                                        } catch (java.lang.Throwable unused13) {
                                        }
                                    }
                                    if (byteArrayOutputStream3 == null) {
                                        throw th;
                                    }
                                    try {
                                        byteArrayOutputStream3.close();
                                        throw th;
                                    } catch (java.lang.Throwable unused14) {
                                        throw th;
                                    }
                                }
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream6.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream7.write(bArr, 0, read);
                                    }
                                    byte[] byteArray = byteArrayOutputStream7.toByteArray();
                                    com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                                    try {
                                        r82.disconnect();
                                    } catch (java.lang.Throwable unused15) {
                                    }
                                    try {
                                        inputStream6.close();
                                    } catch (java.lang.Throwable unused16) {
                                    }
                                    try {
                                        byteArrayOutputStream7.close();
                                    } catch (java.lang.Throwable unused17) {
                                    }
                                    return byteArray;
                                } catch (java.net.MalformedURLException e7) {
                                    inputStream4 = inputStream6;
                                    e3 = e7;
                                    byteArrayOutputStream6 = byteArrayOutputStream7;
                                    httpURLConnection6 = r82;
                                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                                    if (httpURLConnection6 != null) {
                                    }
                                    if (inputStream4 != null) {
                                    }
                                    if (byteArrayOutputStream6 != null) {
                                    }
                                    return null;
                                } catch (java.io.IOException e8) {
                                    inputStream3 = inputStream6;
                                    e2 = e8;
                                    byteArrayOutputStream5 = byteArrayOutputStream7;
                                    httpURLConnection5 = r82;
                                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                                    if (httpURLConnection5 != null) {
                                    }
                                    if (inputStream3 != null) {
                                    }
                                    if (byteArrayOutputStream5 != null) {
                                    }
                                    return null;
                                } catch (java.lang.Exception e9) {
                                    inputStream2 = inputStream6;
                                    e = e9;
                                    byteArrayOutputStream4 = byteArrayOutputStream7;
                                    httpURLConnection4 = r82;
                                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                    if (httpURLConnection4 != null) {
                                    }
                                    if (inputStream2 != null) {
                                    }
                                    if (byteArrayOutputStream4 != null) {
                                    }
                                    return null;
                                } catch (java.lang.Throwable th2) {
                                    byteArrayOutputStream2 = byteArrayOutputStream7;
                                    r3 = inputStream6;
                                    th = th2;
                                    str2 = r82;
                                    byteArrayOutputStream3 = byteArrayOutputStream2;
                                    inputStream5 = r3;
                                    r8 = str2;
                                    if (r8 != 0) {
                                    }
                                    if (inputStream5 != null) {
                                    }
                                    if (byteArrayOutputStream3 == null) {
                                    }
                                }
                            } catch (java.net.MalformedURLException e10) {
                                e3 = e10;
                                inputStream4 = null;
                                httpURLConnection3 = r82;
                            } catch (java.io.IOException e11) {
                                e2 = e11;
                                inputStream3 = null;
                                httpURLConnection2 = r82;
                            } catch (java.lang.Exception e12) {
                                e = e12;
                                inputStream2 = null;
                                httpURLConnection = r82;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                inputStream = null;
                                obj = r82;
                            }
                        } catch (java.net.MalformedURLException e13) {
                            e3 = e13;
                            inputStream4 = null;
                            byteArrayOutputStream6 = null;
                            httpURLConnection6 = r82;
                        } catch (java.io.IOException e14) {
                            e2 = e14;
                            inputStream3 = null;
                            byteArrayOutputStream5 = null;
                            httpURLConnection5 = r82;
                        } catch (java.lang.Exception e15) {
                            e = e15;
                            inputStream2 = null;
                            byteArrayOutputStream4 = null;
                            httpURLConnection4 = r82;
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            byteArrayOutputStream3 = null;
                            r8 = r82;
                            if (r8 != 0) {
                            }
                            if (inputStream5 != null) {
                            }
                            if (byteArrayOutputStream3 == null) {
                            }
                        }
                    } catch (java.net.MalformedURLException e16) {
                        e3 = e16;
                        httpURLConnection3 = null;
                        inputStream4 = null;
                    } catch (java.io.IOException e17) {
                        e2 = e17;
                        httpURLConnection2 = null;
                        inputStream3 = null;
                    } catch (java.lang.Exception e18) {
                        e = e18;
                        httpURLConnection = null;
                        inputStream2 = null;
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        obj = null;
                        inputStream = null;
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                byteArrayOutputStream2 = byteArrayOutputStream;
                r3 = length;
                str2 = str;
            }
        }
        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        return null;
    }

    public static byte[] a(java.lang.String str, int i, java.lang.String str2) {
        java.lang.String str3;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i2 = 0;
            for (byte b : digest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            str3 = new java.lang.String(cArr2);
        } catch (java.lang.Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
