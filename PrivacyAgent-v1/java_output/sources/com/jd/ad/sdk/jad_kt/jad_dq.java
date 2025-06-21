package com.jd.ad.sdk.jad_kt;

/* loaded from: classes23.dex */
public class jad_dq implements com.jd.ad.sdk.jad_kt.jad_fs {
    public final java.lang.ThreadLocal<java.lang.String> jad_an = new java.lang.ThreadLocal<>();
    public final java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.jad_kt.jad_bo> jad_bo = new java.util.concurrent.CopyOnWriteArrayList<>();

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public com.jd.ad.sdk.jad_kt.jad_fs jad_an(java.lang.String str) {
        if (str != null) {
            this.jad_an.set(str);
        }
        return this;
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an() {
        this.jad_bo.clear();
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public synchronized void jad_an(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        if (th != null && str2 != null) {
            str2 = str2 + " : " + com.jd.ad.sdk.jad_kt.jad_jt.jad_an(th);
        }
        if (th != null && str2 == null) {
            str2 = com.jd.ad.sdk.jad_kt.jad_jt.jad_an(th);
        }
        if (com.jd.ad.sdk.jad_kt.jad_jt.jad_an((java.lang.CharSequence) str2)) {
            str2 = "Empty/NULL log message";
        }
        java.util.Iterator<com.jd.ad.sdk.jad_kt.jad_bo> it = this.jad_bo.iterator();
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_kt.jad_bo next = it.next();
            if (next != null && next.isLoggable(i, str)) {
                next.log(i, str, str2);
            }
        }
    }

    public final synchronized void jad_an(int i, @androidx.annotation.Nullable java.lang.Throwable th, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        str.getClass();
        java.lang.String str2 = this.jad_an.get();
        if (str2 != null) {
            this.jad_an.remove();
        } else {
            str2 = null;
        }
        if (objArr != null && objArr.length != 0) {
            str = java.lang.String.format(str, objArr);
        }
        jad_an(i, str2, str, th);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_kt.jad_bo jad_boVar) {
        this.jad_bo.add(jad_boVar);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(@androidx.annotation.Nullable java.lang.Object obj) {
        jad_an(3, (java.lang.Throwable) null, obj == null ? com.igexin.push.core.b.m : !obj.getClass().isArray() ? obj.toString() : obj instanceof boolean[] ? java.util.Arrays.toString((boolean[]) obj) : obj instanceof byte[] ? java.util.Arrays.toString((byte[]) obj) : obj instanceof char[] ? java.util.Arrays.toString((char[]) obj) : obj instanceof short[] ? java.util.Arrays.toString((short[]) obj) : obj instanceof int[] ? java.util.Arrays.toString((int[]) obj) : obj instanceof long[] ? java.util.Arrays.toString((long[]) obj) : obj instanceof float[] ? java.util.Arrays.toString((float[]) obj) : obj instanceof double[] ? java.util.Arrays.toString((double[]) obj) : obj instanceof java.lang.Object[] ? java.util.Arrays.deepToString((java.lang.Object[]) obj) : "Couldn't find a correct type for the object", new java.lang.Object[0]);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        jad_an(7, (java.lang.Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(@androidx.annotation.Nullable java.lang.Throwable th, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        jad_an(6, th, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_bo(@androidx.annotation.Nullable java.lang.String str) {
        if (com.jd.ad.sdk.jad_kt.jad_jt.jad_an((java.lang.CharSequence) str)) {
            jad_an("Empty/Null json content");
            return;
        }
        try {
            java.lang.String trim = str.trim();
            if (trim.startsWith("{")) {
                jad_an((java.lang.Object) new org.json.JSONObject(trim).toString(2));
            } else if (trim.startsWith("[")) {
                jad_an((java.lang.Object) new org.json.JSONArray(trim).toString(2));
            } else {
                jad_an(6, (java.lang.Throwable) null, "Invalid Json", new java.lang.Object[0]);
            }
        } catch (org.json.JSONException unused) {
            jad_an(6, (java.lang.Throwable) null, "Invalid Json", new java.lang.Object[0]);
        }
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_bo(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        jad_an(4, (java.lang.Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_cp(@androidx.annotation.Nullable java.lang.String str) {
        if (com.jd.ad.sdk.jad_kt.jad_jt.jad_an((java.lang.CharSequence) str)) {
            jad_an("Empty/Null xml content");
            return;
        }
        try {
            javax.xml.transform.stream.StreamSource streamSource = new javax.xml.transform.stream.StreamSource(new java.io.StringReader(str));
            javax.xml.transform.stream.StreamResult streamResult = new javax.xml.transform.stream.StreamResult(new java.io.StringWriter());
            javax.xml.transform.Transformer newTransformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.transform(streamSource, streamResult);
            jad_an((java.lang.Object) streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (javax.xml.transform.TransformerException unused) {
            jad_an(6, (java.lang.Throwable) null, "Invalid xml", new java.lang.Object[0]);
        }
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_cp(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        jad_an(2, (java.lang.Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_dq(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        jad_an(5, (java.lang.Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_er(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        jad_an(3, (java.lang.Throwable) null, str, objArr);
    }
}
