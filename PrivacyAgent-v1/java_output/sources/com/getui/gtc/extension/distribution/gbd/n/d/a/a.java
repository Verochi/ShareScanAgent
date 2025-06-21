package com.getui.gtc.extension.distribution.gbd.n.d.a;

/* loaded from: classes22.dex */
public final class a {
    static final java.lang.String a = "UTF-8";
    private static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("(?i)\\bcharset=\\s*\"?([^\\s;\"]*)");
    private static final int c = 131072;

    private a() {
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.io.File file, java.lang.String str, java.lang.String str2) {
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                com.getui.gtc.extension.distribution.gbd.n.d.b.e a2 = a(a(fileInputStream2), str, str2, com.getui.gtc.extension.distribution.gbd.n.d.c.f.a());
                fileInputStream2.close();
                return a2;
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.io.InputStream inputStream, java.lang.String str, java.lang.String str2) {
        return a(a(inputStream), str, str2, com.getui.gtc.extension.distribution.gbd.n.d.c.f.a());
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.io.InputStream inputStream, java.lang.String str, java.lang.String str2, com.getui.gtc.extension.distribution.gbd.n.d.c.f fVar) {
        return a(a(inputStream), str, str2, fVar);
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.nio.ByteBuffer byteBuffer, java.lang.String str, java.lang.String str2, com.getui.gtc.extension.distribution.gbd.n.d.c.f fVar) {
        java.lang.String charBuffer;
        com.getui.gtc.extension.distribution.gbd.n.d.b.e eVar = null;
        if (str == null) {
            charBuffer = java.nio.charset.Charset.forName("UTF-8").decode(byteBuffer).toString();
            com.getui.gtc.extension.distribution.gbd.n.d.b.e a2 = fVar.a(charBuffer, str2);
            com.getui.gtc.extension.distribution.gbd.n.d.b.g a3 = com.getui.gtc.extension.distribution.gbd.n.d.e.h.a("meta[http-equiv=content-type], meta[charset]", a2).a();
            if (a3 != null) {
                java.lang.String a4 = a3.q("http-equiv") ? a(a3.p("content")) : a3.p("charset");
                if (a4 != null && a4.length() != 0 && !a4.equals("UTF-8")) {
                    byteBuffer.rewind();
                    charBuffer = java.nio.charset.Charset.forName(a4).decode(byteBuffer).toString();
                    str = a4;
                }
            }
            eVar = a2;
        } else {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            charBuffer = java.nio.charset.Charset.forName(str).decode(byteBuffer).toString();
        }
        if (eVar != null) {
            return eVar;
        }
        if (charBuffer.charAt(0) == 65279) {
            charBuffer = charBuffer.substring(1);
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.e a5 = fVar.a(charBuffer, str2);
        a5.a.a(str);
        return a5;
    }

    public static java.lang.String a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.regex.Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).trim().toUpperCase();
        }
        return null;
    }

    public static java.nio.ByteBuffer a(java.io.InputStream inputStream) {
        byte[] bArr = new byte[131072];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(131072);
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return java.nio.ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
