package org.apache.tools.ant.launch;

/* loaded from: classes25.dex */
public final class Locator {
    public static final java.lang.String ERROR_NOT_FILE_URI = "Can only handle valid file: URIs, not ";
    public static final java.lang.String URI_ENCODING = "UTF-8";
    public static boolean[] a = new boolean[128];
    public static char[] b = new char[128];
    public static char[] c = new char[128];
    public static char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: org.apache.tools.ant.launch.Locator$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FilenameFilter {
        public final /* synthetic */ java.lang.String[] a;

        public AnonymousClass1(java.lang.String[] strArr) {
            this.a = strArr;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
            int i = 0;
            while (true) {
                java.lang.String[] strArr = this.a;
                if (i >= strArr.length) {
                    return false;
                }
                if (lowerCase.endsWith(strArr[i])) {
                    return true;
                }
                i++;
            }
        }
    }

    static {
        for (int i = 0; i < 32; i++) {
            a[i] = true;
            char[] cArr = b;
            char[] cArr2 = d;
            cArr[i] = cArr2[i >> 4];
            c[i] = cArr2[i & 15];
        }
        a[127] = true;
        b[127] = '7';
        c[127] = 'F';
        char[] cArr3 = {' ', kotlin.text.Typography.less, kotlin.text.Typography.greater, '#', '%', kotlin.text.Typography.quote, '{', '}', '|', '\\', '^', '~', '[', ']', '`'};
        for (int i2 = 0; i2 < 15; i2++) {
            char c2 = cArr3[i2];
            a[c2] = true;
            char[] cArr4 = b;
            char[] cArr5 = d;
            cArr4[c2] = cArr5[c2 >> 4];
            c[c2] = cArr5[c2 & 15];
        }
    }

    public static java.lang.String a(java.lang.String str) {
        java.net.URL url;
        try {
            url = new java.net.URL(str);
        } catch (java.net.MalformedURLException unused) {
            url = null;
        }
        if (url == null || !"file".equals(url.getProtocol())) {
            throw new java.lang.IllegalArgumentException(ERROR_NOT_FILE_URI + str);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(url.getHost());
        if (stringBuffer.length() > 0) {
            stringBuffer.insert(0, java.io.File.separatorChar).insert(0, java.io.File.separatorChar);
        }
        java.lang.String file = url.getFile();
        int indexOf = file.indexOf(63);
        if (indexOf >= 0) {
            file = file.substring(0, indexOf);
        }
        stringBuffer.append(file);
        java.lang.String replace = stringBuffer.toString().replace('/', java.io.File.separatorChar);
        if (java.io.File.pathSeparatorChar == ';' && replace.startsWith("\\") && replace.length() > 2 && java.lang.Character.isLetter(replace.charAt(1)) && replace.lastIndexOf(58) > -1) {
            replace = replace.substring(1);
        }
        try {
            java.lang.String decodeUri = decodeUri(replace);
            java.lang.String property = java.lang.System.getProperty("user.dir");
            int indexOf2 = property.indexOf(58);
            java.lang.String str2 = java.io.File.separator;
            boolean startsWith = decodeUri.startsWith(str2);
            boolean startsWith2 = decodeUri.startsWith("" + str2 + str2);
            if (indexOf2 <= 0 || !startsWith || startsWith2) {
                return decodeUri;
            }
            return property.substring(0, indexOf2 + 1) + decodeUri;
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalStateException("Could not convert URI " + replace + " to path: " + e.getMessage());
        }
    }

    public static java.lang.String decodeUri(java.lang.String str) throws java.io.UnsupportedEncodingException {
        if (str.indexOf(37) == -1) {
            return str;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(str.length());
        java.text.StringCharacterIterator stringCharacterIterator = new java.text.StringCharacterIterator(str);
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '%') {
                char next = stringCharacterIterator.next();
                if (next != 65535) {
                    int digit = java.lang.Character.digit(next, 16);
                    char next2 = stringCharacterIterator.next();
                    if (next2 != 65535) {
                        byteArrayOutputStream.write((char) ((digit << 4) + java.lang.Character.digit(next2, 16)));
                    }
                }
            } else if (first < 0 || first >= 128) {
                byte[] bytes = java.lang.String.valueOf(first).getBytes("UTF-8");
                byteArrayOutputStream.write(bytes, 0, bytes.length);
            } else {
                byteArrayOutputStream.write(first);
            }
        }
        return byteArrayOutputStream.toString("UTF-8");
    }

    public static java.lang.String encodeURI(java.lang.String str) throws java.io.UnsupportedEncodingException {
        char charAt;
        int length = str.length();
        java.lang.StringBuffer stringBuffer = null;
        int i = 0;
        while (i < length && (charAt = str.charAt(i)) < 128) {
            if (a[charAt]) {
                if (stringBuffer == null) {
                    stringBuffer = new java.lang.StringBuffer(str.substring(0, i));
                }
                stringBuffer.append('%');
                stringBuffer.append(b[charAt]);
                stringBuffer.append(c[charAt]);
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
            i++;
        }
        if (i < length) {
            if (stringBuffer == null) {
                stringBuffer = new java.lang.StringBuffer(str.substring(0, i));
            }
            for (byte b2 : str.substring(i).getBytes("UTF-8")) {
                if (b2 < 0) {
                    int i2 = b2 + 256;
                    stringBuffer.append('%');
                    stringBuffer.append(d[i2 >> 4]);
                    stringBuffer.append(d[i2 & 15]);
                } else if (a[b2]) {
                    stringBuffer.append('%');
                    stringBuffer.append(b[b2]);
                    stringBuffer.append(c[b2]);
                } else {
                    stringBuffer.append((char) b2);
                }
            }
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    @java.lang.Deprecated
    public static java.net.URL fileToURL(java.io.File file) throws java.net.MalformedURLException {
        return new java.net.URL(file.toURI().toASCIIString());
    }

    public static java.lang.String fromJarURI(java.lang.String str) {
        return fromURI(str.substring(4, str.indexOf("!/")));
    }

    public static java.lang.String fromURI(java.lang.String str) {
        return a(str);
    }

    public static java.io.File getClassSource(java.lang.Class<?> cls) {
        return getResourceSource(cls.getClassLoader(), cls.getName().replace('.', '/') + ".class");
    }

    public static java.net.URL[] getLocationURLs(java.io.File file) throws java.net.MalformedURLException {
        return getLocationURLs(file, new java.lang.String[]{".jar"});
    }

    public static java.net.URL[] getLocationURLs(java.io.File file, java.lang.String[] strArr) throws java.net.MalformedURLException {
        java.net.URL[] urlArr = new java.net.URL[0];
        if (!file.exists()) {
            return urlArr;
        }
        if (file.isDirectory()) {
            java.io.File[] listFiles = file.listFiles(new org.apache.tools.ant.launch.Locator.AnonymousClass1(strArr));
            java.net.URL[] urlArr2 = new java.net.URL[listFiles.length];
            for (int i = 0; i < listFiles.length; i++) {
                urlArr2[i] = fileToURL(listFiles[i]);
            }
            return urlArr2;
        }
        java.net.URL[] urlArr3 = new java.net.URL[1];
        java.lang.String lowerCase = file.getPath().toLowerCase(java.util.Locale.ENGLISH);
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (lowerCase.endsWith(strArr[i2])) {
                urlArr3[0] = fileToURL(file);
                break;
            }
            i2++;
        }
        return urlArr3;
    }

    public static java.io.File getResourceSource(java.lang.ClassLoader classLoader, java.lang.String str) {
        if (classLoader == null) {
            classLoader = org.apache.tools.ant.launch.Locator.class.getClassLoader();
        }
        java.net.URL systemResource = classLoader == null ? java.lang.ClassLoader.getSystemResource(str) : classLoader.getResource(str);
        if (systemResource != null) {
            java.lang.String url = systemResource.toString();
            try {
                if (url.startsWith("jar:file:")) {
                    return new java.io.File(fromJarURI(url));
                }
                if (url.startsWith("file:")) {
                    return new java.io.File(fromURI(url.substring(0, url.indexOf(str))));
                }
            } catch (java.lang.IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static java.io.File getToolsJar() {
        boolean z = true;
        try {
            try {
                java.lang.Class.forName("com.sun.tools.javac.Main");
            } catch (java.lang.Exception unused) {
                z = false;
            }
        } catch (java.lang.Exception unused2) {
            java.lang.Class.forName("sun.tools.javac.Main");
        }
        if (z) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append("lib");
        sb.append(str);
        sb.append("tools.jar");
        java.lang.String sb2 = sb.toString();
        java.lang.String property = java.lang.System.getProperty("java.home");
        java.io.File file = new java.io.File(property + sb2);
        if (file.exists()) {
            return file;
        }
        if (property.toLowerCase(java.util.Locale.ENGLISH).endsWith(str + "jre")) {
            file = new java.io.File(property.substring(0, property.length() - 4) + sb2);
        }
        if (file.exists()) {
            return file;
        }
        java.lang.System.out.println("Unable to locate tools.jar. Expected to find it in " + file.getPath());
        return null;
    }
}
