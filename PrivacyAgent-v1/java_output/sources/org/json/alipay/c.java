package org.json.alipay;

/* loaded from: classes26.dex */
public final class c {
    public int a;
    public java.io.Reader b;
    public char c;
    public boolean d;

    public c(java.io.Reader reader) {
        this.b = reader.markSupported() ? reader : new java.io.BufferedReader(reader);
        this.d = false;
        this.a = 0;
    }

    public c(java.lang.String str) {
        this(new java.io.StringReader(str));
    }

    private java.lang.String a(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.d) {
            this.d = false;
            cArr[0] = this.c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (java.io.IOException e) {
                throw new org.json.alipay.JSONException(e);
            }
        }
        this.a += i2;
        if (i2 < i) {
            throw a("Substring bounds error");
        }
        this.c = cArr[i - 1];
        return new java.lang.String(cArr);
    }

    public final org.json.alipay.JSONException a(java.lang.String str) {
        return new org.json.alipay.JSONException(str + toString());
    }

    public final void a() {
        int i;
        if (this.d || (i = this.a) <= 0) {
            throw new org.json.alipay.JSONException("Stepping back two steps is not supported");
        }
        this.a = i - 1;
        this.d = true;
    }

    public final char b() {
        if (this.d) {
            this.d = false;
            char c = this.c;
            if (c != 0) {
                this.a++;
            }
            return c;
        }
        try {
            int read = this.b.read();
            if (read <= 0) {
                this.c = (char) 0;
                return (char) 0;
            }
            this.a++;
            char c2 = (char) read;
            this.c = c2;
            return c2;
        } catch (java.io.IOException e) {
            throw new org.json.alipay.JSONException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0053, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final char c() {
        char b;
        char b2;
        while (true) {
            char b3 = b();
            if (b3 == '/') {
                char b4 = b();
                if (b4 == '*') {
                    while (true) {
                        char b5 = b();
                        if (b5 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (b5 == '*') {
                            if (b() != '/') {
                                a();
                            }
                        }
                    }
                } else {
                    if (b4 != '/') {
                        a();
                        return '/';
                    }
                    do {
                        b = b();
                        if (b != '\n' && b != '\r') {
                        }
                    } while (b != 0);
                }
            } else if (b3 == '#') {
                do {
                    b2 = b();
                    if (b2 != '\n' && b2 != '\r') {
                    }
                } while (b2 != 0);
            } else if (b3 == 0 || b3 > ' ') {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0146, code lost:
    
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object d() {
        java.lang.String a;
        char c = c();
        if (c != '\"') {
            if (c != '[') {
                if (c == '{') {
                    a();
                    return new org.json.alipay.b(this);
                }
                if (c != '\'') {
                    if (c != '(') {
                        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                        char c2 = c;
                        while (c2 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c2) < 0) {
                            stringBuffer.append(c2);
                            c2 = b();
                        }
                        a();
                        java.lang.String trim = stringBuffer.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        }
                        if (trim.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
                            return java.lang.Boolean.TRUE;
                        }
                        if (trim.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                            return java.lang.Boolean.FALSE;
                        }
                        if (trim.equalsIgnoreCase(com.igexin.push.core.b.m)) {
                            return org.json.alipay.b.a;
                        }
                        if ((c < '0' || c > '9') && c != '.' && c != '-' && c != '+') {
                            return trim;
                        }
                        if (c == '0') {
                            try {
                                return (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) ? new java.lang.Integer(java.lang.Integer.parseInt(trim, 8)) : new java.lang.Integer(java.lang.Integer.parseInt(trim.substring(2), 16));
                            } catch (java.lang.Exception unused) {
                            }
                        }
                        try {
                            try {
                                try {
                                    return new java.lang.Integer(trim);
                                } catch (java.lang.Exception unused2) {
                                    return new java.lang.Double(trim);
                                }
                            } catch (java.lang.Exception unused3) {
                                return new java.lang.Long(trim);
                            }
                        } catch (java.lang.Exception unused4) {
                            return trim;
                        }
                    }
                }
            }
            a();
            return new org.json.alipay.a(this);
        }
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        while (true) {
            char b = b();
            if (b == 0 || b == '\n' || b == '\r') {
                break;
            }
            if (b == '\\') {
                b = b();
                if (b == 'b') {
                    stringBuffer2.append('\b');
                } else if (b == 'f') {
                    b = '\f';
                } else if (b == 'n') {
                    stringBuffer2.append('\n');
                } else if (b != 'r') {
                    if (b == 'x') {
                        a = a(2);
                    } else if (b == 't') {
                        b = '\t';
                    } else if (b == 'u') {
                        a = a(4);
                    }
                    b = (char) java.lang.Integer.parseInt(a, 16);
                } else {
                    stringBuffer2.append('\r');
                }
            } else if (b == c) {
                return stringBuffer2.toString();
            }
            stringBuffer2.append(b);
        }
    }

    public final java.lang.String toString() {
        return " at character " + this.a;
    }
}
