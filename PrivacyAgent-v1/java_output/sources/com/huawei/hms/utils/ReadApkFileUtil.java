package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class ReadApkFileUtil {
    public static final java.lang.String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final java.lang.String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final java.lang.String KEY_SIGNATURE = "Signature:";
    public static final java.lang.String KEY_SIGNATURE2 = "Signature2:";
    public static final java.lang.String KEY_SIGNATURE3 = "Signature3:";
    public static final java.lang.String a = "ReadApkFileUtil";
    public static java.lang.String b;
    public static java.lang.String c;
    public static java.lang.String d;
    public static java.lang.String e;
    public static java.lang.String f;

    public static java.lang.String a(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        int read;
        if (bufferedReader == null || (read = bufferedReader.read()) == -1) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(10);
        while (read != -1) {
            char c2 = (char) read;
            if (c2 == '\n') {
                break;
            }
            if (sb.length() >= 4096) {
                throw new java.io.IOException("cert line is too long!");
            }
            sb.append(c2);
            read = bufferedReader.read();
        }
        java.lang.String sb2 = sb.toString();
        return (sb2.isEmpty() || !sb2.endsWith("\r")) ? sb2 : sb2.substring(0, sb2.length() - 1);
    }

    public static java.lang.String a(java.lang.String str) {
        return str != null ? java.util.regex.Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    @android.annotation.TargetApi(19)
    public static java.util.ArrayList<java.lang.String> a(byte[] bArr) {
        if (bArr == null) {
            com.huawei.hms.support.log.HMSLog.e(a, "manifest is null！");
            return null;
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        try {
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            try {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(byteArrayInputStream, java.nio.charset.StandardCharsets.UTF_8));
                try {
                    if (a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (java.io.IOException unused) {
            com.huawei.hms.support.log.HMSLog.e(a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    public static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f, "SHA-256"), b(b), "SHA256withRSA")) {
                com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (java.lang.Exception e2) {
            com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV1 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    public static boolean a(java.io.BufferedReader bufferedReader, java.util.ArrayList<java.lang.String> arrayList) throws java.io.IOException {
        java.lang.String a2 = a(bufferedReader);
        boolean z = false;
        while (a2 != null) {
            if (a2.equals("Name: META-INF/HUAWEI.CER")) {
                java.lang.String a3 = a(bufferedReader);
                while (true) {
                    if (a3 == null) {
                        break;
                    }
                    if (a3.startsWith("Name:")) {
                        a2 = a3;
                        break;
                    }
                    a3 = a(bufferedReader);
                }
                z = true;
            }
            if (a2.length() != 0) {
                arrayList.add(a2);
            }
            a2 = a(bufferedReader);
        }
        return z;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, java.lang.String str) throws java.lang.Exception {
        java.security.Signature signature = java.security.Signature.getInstance(str);
        signature.initVerify(java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    @android.annotation.TargetApi(19)
    public static byte[] a(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(java.nio.charset.StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    @android.annotation.TargetApi(19)
    public static byte[] a(java.util.ArrayList<java.lang.String> arrayList) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(byteArrayOutputStream, java.nio.charset.StandardCharsets.UTF_8));
        try {
            try {
                java.util.Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    java.lang.String str = arrayList.get(i);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write("\r\n", 0, 2);
                }
                bufferedWriter.flush();
            } catch (java.lang.Exception e2) {
                com.huawei.hms.support.log.HMSLog.i(a, "getManifestBytesbySorted Exception!" + e2.getMessage());
            }
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Throwable th) {
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Writer) bufferedWriter);
            throw th;
        }
    }

    public static byte[] a(java.util.zip.ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0099: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:56:0x0098 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.InputStream] */
    public static byte[] a(java.util.zip.ZipFile zipFile, java.lang.String str) {
        java.lang.Throwable th;
        java.io.OutputStream outputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th2;
        java.lang.Exception e2;
        java.lang.Object obj;
        ?? r4;
        ?? entry = zipFile.getEntry(str);
        java.io.OutputStream outputStream2 = null;
        try {
            if (entry == 0) {
                return null;
            }
            try {
                zipFile = zipFile.getInputStream(entry);
                if (zipFile == 0) {
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) zipFile);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) null);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) null);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) null);
                    return null;
                }
                try {
                    entry = new java.io.BufferedInputStream(zipFile);
                } catch (java.lang.Exception e3) {
                    e2 = e3;
                    obj = zipFile;
                    entry = 0;
                    byteArrayOutputStream = null;
                    zipFile = obj;
                    r4 = byteArrayOutputStream;
                    com.huawei.hms.support.log.HMSLog.i(a, "getManifestBytes Exception!" + e2.getMessage());
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) zipFile);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) entry);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r4);
                    return null;
                } catch (java.lang.Throwable th3) {
                    th2 = th3;
                    th = th2;
                    entry = 0;
                    byteArrayOutputStream = null;
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) zipFile);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) entry);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
                    com.huawei.hms.utils.IOUtils.closeQuietly(outputStream2);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    try {
                        r4 = new java.io.BufferedOutputStream(byteArrayOutputStream);
                        try {
                            for (int read = entry.read(bArr, 0, 4096); read > 0; read = entry.read(bArr, 0, 4096)) {
                                r4.write(bArr, 0, read);
                            }
                            r4.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) zipFile);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) entry);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r4);
                            return byteArray;
                        } catch (java.lang.Exception e4) {
                            e2 = e4;
                            com.huawei.hms.support.log.HMSLog.i(a, "getManifestBytes Exception!" + e2.getMessage());
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) zipFile);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) entry);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
                            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r4);
                            return null;
                        }
                    } catch (java.lang.Exception e5) {
                        e2 = e5;
                        r4 = 0;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) zipFile);
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) entry);
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
                        com.huawei.hms.utils.IOUtils.closeQuietly(outputStream2);
                        throw th;
                    }
                } catch (java.lang.Exception e6) {
                    e2 = e6;
                    byteArrayOutputStream = null;
                    zipFile = zipFile;
                    entry = entry;
                    r4 = byteArrayOutputStream;
                    com.huawei.hms.support.log.HMSLog.i(a, "getManifestBytes Exception!" + e2.getMessage());
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) zipFile);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) entry);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) byteArrayOutputStream);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.OutputStream) r4);
                    return null;
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Exception e7) {
                e2 = e7;
                obj = null;
            } catch (java.lang.Throwable th6) {
                th2 = th6;
                zipFile = 0;
            }
        } catch (java.lang.Throwable th7) {
            th = th7;
            outputStream2 = outputStream;
        }
    }

    @android.annotation.TargetApi(19)
    public static void b(byte[] bArr) {
        java.lang.Throwable th;
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.BufferedReader bufferedReader;
        if (bArr == null) {
            com.huawei.hms.support.log.HMSLog.e(a, "manifest is null！");
            return;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.io.BufferedReader bufferedReader2 = null;
        b = null;
        c = null;
        d = null;
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(byteArrayInputStream, java.nio.charset.StandardCharsets.UTF_8));
                try {
                    java.lang.String a2 = a(bufferedReader);
                    while (a2 != null) {
                        if (a2.length() != 0) {
                            if (a2.startsWith("ApkHash:")) {
                                e = a(a2.substring(a2.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1));
                            }
                            if (a2.startsWith(KEY_SIGNATURE)) {
                                b = a(a2.substring(a2.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1));
                                a2 = a(bufferedReader);
                            } else if (a2.startsWith(KEY_SIGNATURE2)) {
                                c = a(a2.substring(a2.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1));
                                a2 = a(bufferedReader);
                            } else if (a2.startsWith(KEY_SIGNATURE3)) {
                                d = a(a2.substring(a2.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1));
                                a2 = a(bufferedReader);
                            } else {
                                stringBuffer.append(a2);
                                stringBuffer.append("\r\n");
                            }
                        }
                        a2 = a(bufferedReader);
                    }
                    f = stringBuffer.toString();
                } catch (java.lang.Exception unused) {
                    bufferedReader2 = bufferedReader;
                    try {
                        com.huawei.hms.support.log.HMSLog.e(a, "loadApkCert Exception!");
                        bufferedReader = bufferedReader2;
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) byteArrayInputStream);
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) byteArrayInputStream);
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader2);
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) byteArrayInputStream);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader2);
                    throw th;
                }
            } catch (java.lang.Exception unused2) {
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        } catch (java.lang.Exception unused3) {
            byteArrayInputStream = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
        }
        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) byteArrayInputStream);
        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Reader) bufferedReader);
    }

    public static boolean b() {
        try {
        } catch (java.lang.Exception e2) {
            com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV2 MDM verify Exception!:" + e2.getMessage());
        }
        if (a(android.util.Base64.decode(EMUI10_PK, 0), a(f, "SHA-256"), b(c), "SHA256withRSA")) {
            com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV2 verify successful!");
            return true;
        }
        com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV2 verify failure!");
        return false;
    }

    public static byte[] b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        byte[] bArr = new byte[length % 2 == 0 ? length / 2 : (length / 2) + 1];
        for (int i = 0; i < length; i += 2) {
            int i2 = i + 1;
            if (i2 < length) {
                bArr[i / 2] = (byte) ((java.lang.Character.digit(str.charAt(i), 16) << 4) + java.lang.Character.digit(str.charAt(i2), 16));
            } else {
                bArr[i / 2] = (byte) (java.lang.Character.digit(str.charAt(i), 16) << 4);
            }
        }
        return bArr;
    }

    public static java.lang.String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return java.lang.String.valueOf(cArr2);
    }

    public static boolean c() {
        try {
        } catch (java.lang.Exception e2) {
            com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV3 MDM verify Exception!:" + e2.getMessage());
        }
        if (a(android.util.Base64.decode(EMUI11_PK, 0), a(f, "SHA-384"), b(d), "SHA384withRSA")) {
            com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV3 verify successful!");
            return true;
        }
        com.huawei.hms.support.log.HMSLog.i(a, "verifyMDMSignatureV3 verify failure!");
        return false;
    }

    public static boolean checkSignature() {
        if (d != null) {
            return c();
        }
        if (c != null) {
            return b();
        }
        if (b != null) {
            return a();
        }
        return false;
    }

    public static java.lang.String getHmsPath(android.content.Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.e(a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @android.annotation.TargetApi(19)
    public static boolean isCertFound(java.lang.String str) {
        java.util.zip.ZipFile zipFile;
        boolean z = false;
        java.util.zip.ZipFile zipFile2 = null;
        java.util.zip.ZipFile zipFile3 = null;
        java.util.zip.ZipFile zipFile4 = null;
        try {
            try {
                zipFile = new java.util.zip.ZipFile(str);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        try {
            boolean z2 = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
            if (z2) {
                b(a(zipFile, "META-INF/HUAWEI.CER"));
            }
            try {
                zipFile.close();
            } catch (java.io.IOException e3) {
                java.lang.String str2 = a;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("zipFile.close Exception!");
                sb.append(e3.getMessage());
                com.huawei.hms.support.log.HMSLog.e(str2, sb.toString());
                zipFile3 = sb;
            }
            z = z2;
            zipFile2 = zipFile3;
        } catch (java.lang.Exception e4) {
            e = e4;
            zipFile4 = zipFile;
            com.huawei.hms.support.log.HMSLog.e(a, "isCertFound Exception!" + e.getMessage());
            zipFile2 = zipFile4;
            if (zipFile4 != null) {
                try {
                    zipFile4.close();
                    zipFile2 = zipFile4;
                } catch (java.io.IOException e5) {
                    java.lang.String str3 = a;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("zipFile.close Exception!");
                    sb2.append(e5.getMessage());
                    com.huawei.hms.support.log.HMSLog.e(str3, sb2.toString());
                    zipFile2 = sb2;
                }
            }
            return z;
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (java.io.IOException e6) {
                    com.huawei.hms.support.log.HMSLog.e(a, "zipFile.close Exception!" + e6.getMessage());
                }
            }
            throw th;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static boolean verifyApkHash(java.lang.String str) {
        java.util.zip.ZipFile zipFile;
        ?? r1 = 0;
        java.util.zip.ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new java.util.zip.ZipFile(str);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        try {
            byte[] a2 = a(zipFile);
            java.util.ArrayList<java.lang.String> a3 = a(a2);
            if (a3 != null) {
                a2 = a(a3);
            }
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            messageDigest.update(a2);
            java.lang.String bytesToString = bytesToString(messageDigest.digest());
            java.lang.String str2 = e;
            if (str2 != null) {
                if (str2.equals(bytesToString)) {
                    try {
                        zipFile.close();
                        return true;
                    } catch (java.lang.Exception e3) {
                        com.huawei.hms.support.log.HMSLog.i(a, "close stream Exception!" + e3.getMessage());
                        return true;
                    }
                }
            }
            try {
                zipFile.close();
                return false;
            } catch (java.lang.Exception e4) {
                com.huawei.hms.support.log.HMSLog.i(a, "close stream Exception!" + e4.getMessage());
                return false;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            zipFile2 = zipFile;
            com.huawei.hms.support.log.HMSLog.i(a, "verifyApkHash Exception!" + e.getMessage());
            if (zipFile2 == null) {
                return false;
            }
            try {
                zipFile2.close();
                return false;
            } catch (java.lang.Exception e6) {
                r1 = a;
                com.huawei.hms.support.log.HMSLog.i(r1, "close stream Exception!" + e6.getMessage());
                return false;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            r1 = zipFile;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (java.lang.Exception e7) {
                    com.huawei.hms.support.log.HMSLog.i(a, "close stream Exception!" + e7.getMessage());
                }
            }
            throw th;
        }
    }
}
