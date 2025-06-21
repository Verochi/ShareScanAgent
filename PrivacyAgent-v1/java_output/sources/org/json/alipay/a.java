package org.json.alipay;

/* loaded from: classes26.dex */
public class a {
    public java.util.ArrayList a;

    public a() {
        this.a = new java.util.ArrayList();
    }

    public a(java.lang.Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new org.json.alipay.JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = java.lang.reflect.Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.a.add(java.lang.reflect.Array.get(obj, i));
        }
    }

    public a(java.lang.String str) {
        this(new org.json.alipay.c(str));
    }

    public a(java.util.Collection collection) {
        this.a = collection == null ? new java.util.ArrayList() : new java.util.ArrayList(collection);
    }

    public a(org.json.alipay.c cVar) {
        this();
        char c;
        java.util.ArrayList arrayList;
        java.lang.Object d;
        char c2 = cVar.c();
        if (c2 == '[') {
            c = ']';
        } else {
            if (c2 != '(') {
                throw cVar.a("A JSONArray text must start with '['");
            }
            c = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c3 = cVar.c();
            cVar.a();
            if (c3 == ',') {
                arrayList = this.a;
                d = null;
            } else {
                arrayList = this.a;
                d = cVar.d();
            }
            arrayList.add(d);
            char c4 = cVar.c();
            if (c4 != ')') {
                if (c4 != ',' && c4 != ';') {
                    if (c4 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c == c4) {
                return;
            }
            throw cVar.a("Expected a '" + new java.lang.Character(c) + "'");
        } while (cVar.c() != ']');
    }

    private java.lang.String a(java.lang.String str) {
        int size = this.a.size();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(org.json.alipay.b.a(this.a.get(i)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.a.size();
    }

    public final java.lang.Object a(int i) {
        java.lang.Object obj = (i < 0 || i >= this.a.size()) ? null : this.a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new org.json.alipay.JSONException("JSONArray[" + i + "] not found.");
    }

    public java.lang.String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
