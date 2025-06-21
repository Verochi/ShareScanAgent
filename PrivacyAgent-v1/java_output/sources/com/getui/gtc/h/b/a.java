package com.getui.gtc.h.b;

/* loaded from: classes22.dex */
public final class a {

    /* renamed from: com.getui.gtc.h.b.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FileFilter {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return file.isDirectory() || file.getName().startsWith(this.a);
        }
    }

    public static java.lang.String a(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        try {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                if (messageDigest == null) {
                    return "0";
                }
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    if (read < 10240) {
                        byte[] bArr2 = new byte[read];
                        java.lang.System.arraycopy(bArr, 0, bArr2, 0, read);
                        messageDigest.update(bArr2);
                    } else {
                        messageDigest.update(bArr);
                    }
                }
                byte[] digest = messageDigest.digest();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (byte b : digest) {
                    sb.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(b)));
                }
                java.lang.String sb2 = sb.toString();
                fileInputStream.close();
                return sb2;
            } catch (java.security.NoSuchAlgorithmException e) {
                com.getui.gtc.h.c.a.d(e);
                return "0";
            }
        } catch (java.lang.Exception e2) {
            com.getui.gtc.h.c.a.d(e2);
            return "0";
        }
    }

    public static void a(java.io.File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return;
            }
            if (file.isDirectory()) {
                java.io.File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (java.io.File file2 : listFiles) {
                        a(file2);
                    }
                    file.delete();
                    return;
                }
                file.delete();
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        java.io.File[] listFiles;
        java.io.File file = new java.io.File(str);
        if (file.isDirectory() && (listFiles = file.listFiles(new com.getui.gtc.h.b.a.AnonymousClass1(str2))) != null && listFiles.length > 0) {
            for (java.io.File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2.getAbsolutePath(), str2);
                } else {
                    file2.delete();
                }
            }
        }
    }
}
