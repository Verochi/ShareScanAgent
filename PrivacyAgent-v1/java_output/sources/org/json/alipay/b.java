package org.json.alipay;

/* loaded from: classes26.dex */
public class b {
    public static final java.lang.Object a = new org.json.alipay.b.a((byte) 0);
    public java.util.Map b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final java.lang.Object clone() {
            return this;
        }

        public final boolean equals(java.lang.Object obj) {
            return obj == null || obj == this;
        }

        public final java.lang.String toString() {
            return com.igexin.push.core.b.m;
        }
    }

    public b() {
        this.b = new java.util.HashMap();
    }

    public b(java.lang.String str) {
        this(new org.json.alipay.c(str));
    }

    public b(java.util.Map map) {
        this.b = map == null ? new java.util.HashMap() : map;
    }

    public b(org.json.alipay.c cVar) {
        this();
        if (cVar.c() != '{') {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c = cVar.c();
            if (c == 0) {
                throw cVar.a("A JSONObject text must end with '}'");
            }
            if (c == '}') {
                return;
            }
            cVar.a();
            java.lang.String obj = cVar.d().toString();
            char c2 = cVar.c();
            if (c2 == '=') {
                if (cVar.b() != '>') {
                    cVar.a();
                }
            } else if (c2 != ':') {
                throw cVar.a("Expected a ':' after a key");
            }
            java.lang.Object d = cVar.d();
            if (obj == null) {
                throw new org.json.alipay.JSONException("Null key.");
            }
            if (d != null) {
                b(d);
                this.b.put(obj, d);
            } else {
                this.b.remove(obj);
            }
            char c3 = cVar.c();
            if (c3 != ',' && c3 != ';') {
                if (c3 != '}') {
                    throw cVar.a("Expected a ',' or '}'");
                }
                return;
            } else if (cVar.c() == '}') {
                return;
            } else {
                cVar.a();
            }
        }
    }

    public static java.lang.String a(java.lang.Object obj) {
        if (obj == null || obj.equals(null)) {
            return com.igexin.push.core.b.m;
        }
        if (!(obj instanceof java.lang.Number)) {
            return ((obj instanceof java.lang.Boolean) || (obj instanceof org.json.alipay.b) || (obj instanceof org.json.alipay.a)) ? obj.toString() : obj instanceof java.util.Map ? new org.json.alipay.b((java.util.Map) obj).toString() : obj instanceof java.util.Collection ? new org.json.alipay.a((java.util.Collection) obj).toString() : obj.getClass().isArray() ? new org.json.alipay.a(obj).toString() : c(obj.toString());
        }
        java.lang.Number number = (java.lang.Number) obj;
        b(number);
        java.lang.String obj2 = number.toString();
        if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
            return obj2;
        }
        while (obj2.endsWith("0")) {
            obj2 = obj2.substring(0, obj2.length() - 1);
        }
        return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
    }

    public static void b(java.lang.Object obj) {
        if (obj != null) {
            if (obj instanceof java.lang.Double) {
                java.lang.Double d = (java.lang.Double) obj;
                if (d.isInfinite() || d.isNaN()) {
                    throw new org.json.alipay.JSONException("JSON does not allow non-finite numbers.");
                }
                return;
            }
            if (obj instanceof java.lang.Float) {
                java.lang.Float f = (java.lang.Float) obj;
                if (f.isInfinite() || f.isNaN()) {
                    throw new org.json.alipay.JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        if (r4 == '<') goto L35;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0034. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String c(java.lang.String str) {
        java.lang.String str2;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(length + 4);
        stringBuffer.append(kotlin.text.Typography.quote);
        int i = 0;
        char c = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                str2 = "\\f";
            } else if (charAt != '\r') {
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            switch (charAt) {
                                case '\b':
                                    str2 = "\\b";
                                    break;
                                case '\t':
                                    str2 = "\\t";
                                    break;
                                case '\n':
                                    str2 = "\\n";
                                    break;
                                default:
                                    if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                                        str2 = "\\u" + ("000" + java.lang.Integer.toHexString(charAt)).substring(r4.length() - 4);
                                        break;
                                    }
                                    stringBuffer.append(charAt);
                                    break;
                            }
                            i++;
                            c = charAt;
                        }
                    }
                }
                stringBuffer.append('\\');
                stringBuffer.append(charAt);
                i++;
                c = charAt;
            } else {
                str2 = "\\r";
            }
            stringBuffer.append(str2);
            i++;
            c = charAt;
        }
        stringBuffer.append(kotlin.text.Typography.quote);
        return stringBuffer.toString();
    }

    public final java.lang.Object a(java.lang.String str) {
        java.lang.Object obj = str == null ? null : this.b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new org.json.alipay.JSONException("JSONObject[" + c(str) + "] not found.");
    }

    public final java.util.Iterator a() {
        return this.b.keySet().iterator();
    }

    public final boolean b(java.lang.String str) {
        return this.b.containsKey(str);
    }

    public java.lang.String toString() {
        try {
            java.util.Iterator a2 = a();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("{");
            while (a2.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                java.lang.Object next = a2.next();
                stringBuffer.append(c(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(a(this.b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
