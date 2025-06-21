package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class fk implements com.xiaomi.push.fo {
    java.lang.String a;
    java.lang.String b;
    private java.lang.String c;
    private java.lang.String[] d;
    private java.lang.String[] e;
    private java.util.List<com.xiaomi.push.fk> f;

    public fk(java.lang.String str) {
        this.f = null;
        this.a = str;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public fk(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String str3, java.util.List<com.xiaomi.push.fk> list) {
        this.a = str;
        this.c = str2;
        this.d = strArr;
        this.e = strArr2;
        this.b = str3;
        this.f = list;
    }

    public static com.xiaomi.push.fk a(android.os.Bundle bundle) {
        java.util.ArrayList arrayList;
        java.lang.String string = bundle.getString("ext_ele_name");
        java.lang.String string2 = bundle.getString("ext_ns");
        java.lang.String string3 = bundle.getString("ext_text");
        android.os.Bundle bundle2 = bundle.getBundle("attributes");
        java.util.Set<java.lang.String> keySet = bundle2.keySet();
        java.lang.String[] strArr = new java.lang.String[keySet.size()];
        java.lang.String[] strArr2 = new java.lang.String[keySet.size()];
        int i = 0;
        for (java.lang.String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            android.os.Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            java.util.ArrayList arrayList2 = new java.util.ArrayList(parcelableArray.length);
            for (android.os.Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((android.os.Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new com.xiaomi.push.fk(string, string2, strArr, strArr2, string3, arrayList);
    }

    private static android.os.Parcelable[] a(com.xiaomi.push.fk[] fkVarArr) {
        if (fkVarArr == null) {
            return null;
        }
        android.os.Parcelable[] parcelableArr = new android.os.Parcelable[fkVarArr.length];
        for (int i = 0; i < fkVarArr.length; i++) {
            parcelableArr[i] = fkVarArr[i].c();
        }
        return parcelableArr;
    }

    public final java.lang.String a() {
        return !android.text.TextUtils.isEmpty(this.b) ? com.xiaomi.push.fy.b(this.b) : this.b;
    }

    public final java.lang.String a(java.lang.String str) {
        if (this.d == null) {
            return null;
        }
        int i = 0;
        while (true) {
            java.lang.String[] strArr = this.d;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.e[i];
            }
            i++;
        }
    }

    @Override // com.xiaomi.push.fo
    public final java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<");
        sb.append(this.a);
        if (!android.text.TextUtils.isEmpty(this.c)) {
            sb.append(" xmlns=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        java.lang.String[] strArr = this.d;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.d.length; i++) {
                if (!android.text.TextUtils.isEmpty(this.e[i])) {
                    sb.append(" ");
                    sb.append(this.d[i]);
                    sb.append("=\"");
                    sb.append(com.xiaomi.push.fy.a(this.e[i]));
                    sb.append("\"");
                }
            }
        }
        if (android.text.TextUtils.isEmpty(this.b)) {
            java.util.List<com.xiaomi.push.fk> list = this.f;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(">");
            java.util.Iterator<com.xiaomi.push.fk> it = this.f.iterator();
            while (it.hasNext()) {
                sb.append(it.next().b());
            }
        } else {
            sb.append(">");
            sb.append(this.b);
        }
        sb.append("</");
        sb.append(this.a);
        sb.append(">");
        return sb.toString();
    }

    public final android.os.Bundle c() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.c);
        bundle.putString("ext_text", this.b);
        android.os.Bundle bundle2 = new android.os.Bundle();
        java.lang.String[] strArr = this.d;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                java.lang.String[] strArr2 = this.d;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.e[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        java.util.List<com.xiaomi.push.fk> list = this.f;
        if (list != null && list.size() > 0) {
            java.util.List<com.xiaomi.push.fk> list2 = this.f;
            bundle.putParcelableArray("children", a((com.xiaomi.push.fk[]) list2.toArray(new com.xiaomi.push.fk[list2.size()])));
        }
        return bundle;
    }

    public final java.lang.String toString() {
        return b();
    }
}
