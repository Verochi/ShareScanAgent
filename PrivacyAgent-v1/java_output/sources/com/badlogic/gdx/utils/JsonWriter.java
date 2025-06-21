package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class JsonWriter extends java.io.Writer {
    public final java.io.Writer n;
    public com.badlogic.gdx.utils.JsonWriter.JsonObject u;
    public boolean v;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonWriter.JsonObject> t = new com.badlogic.gdx.utils.Array<>();
    public com.badlogic.gdx.utils.JsonWriter.OutputType w = com.badlogic.gdx.utils.JsonWriter.OutputType.json;
    public boolean x = false;

    /* renamed from: com.badlogic.gdx.utils.JsonWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.badlogic.gdx.utils.JsonWriter.OutputType.values().length];
            a = iArr;
            try {
                iArr[com.badlogic.gdx.utils.JsonWriter.OutputType.minimal.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.badlogic.gdx.utils.JsonWriter.OutputType.javascript.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public class JsonObject {
        public final boolean a;
        public boolean b;

        public JsonObject(boolean z) throws java.io.IOException {
            this.a = z;
            com.badlogic.gdx.utils.JsonWriter.this.n.write(z ? 91 : 123);
        }

        public void a() throws java.io.IOException {
            com.badlogic.gdx.utils.JsonWriter.this.n.write(this.a ? 93 : 125);
        }
    }

    public enum OutputType {
        json,
        javascript,
        minimal;

        private static java.util.regex.Pattern javascriptPattern = java.util.regex.Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
        private static java.util.regex.Pattern minimalNamePattern = java.util.regex.Pattern.compile("^[^\":,}/ ][^:]*$");
        private static java.util.regex.Pattern minimalValuePattern = java.util.regex.Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0030, code lost:
        
            if (r1 != 2) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.String quoteName(java.lang.String str) {
            com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(str);
            stringBuilder.replace('\\', "\\\\").replace('\r', "\\r").replace('\n', "\\n").replace('\t', "\\t");
            int i = com.badlogic.gdx.utils.JsonWriter.AnonymousClass1.a[ordinal()];
            if (i == 1) {
                if (!str.contains("//") && !str.contains("/*") && minimalNamePattern.matcher(stringBuilder).matches()) {
                    return stringBuilder.toString();
                }
            }
            if (javascriptPattern.matcher(stringBuilder).matches()) {
                return stringBuilder.toString();
            }
            return kotlin.text.Typography.quote + stringBuilder.replace(kotlin.text.Typography.quote, "\\\"").toString() + kotlin.text.Typography.quote;
        }

        public java.lang.String quoteValue(java.lang.Object obj) {
            int length;
            if (obj == null) {
                return com.igexin.push.core.b.m;
            }
            java.lang.String obj2 = obj.toString();
            if ((obj instanceof java.lang.Number) || (obj instanceof java.lang.Boolean)) {
                return obj2;
            }
            com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(obj2);
            stringBuilder.replace('\\', "\\\\").replace('\r', "\\r").replace('\n', "\\n").replace('\t', "\\t");
            if (this == minimal && !obj2.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE) && !obj2.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE) && !obj2.equals(com.igexin.push.core.b.m) && !obj2.contains("//") && !obj2.contains("/*") && (length = stringBuilder.length()) > 0 && stringBuilder.charAt(length - 1) != ' ' && minimalValuePattern.matcher(stringBuilder).matches()) {
                return stringBuilder.toString();
            }
            return kotlin.text.Typography.quote + stringBuilder.replace(kotlin.text.Typography.quote, "\\\"").toString() + kotlin.text.Typography.quote;
        }
    }

    public JsonWriter(java.io.Writer writer) {
        this.n = writer;
    }

    public final void a() throws java.io.IOException {
        com.badlogic.gdx.utils.JsonWriter.JsonObject jsonObject = this.u;
        if (jsonObject == null) {
            return;
        }
        if (!jsonObject.a) {
            if (!this.v) {
                throw new java.lang.IllegalStateException("Name must be set.");
            }
            this.v = false;
        } else if (jsonObject.b) {
            this.n.write(44);
        } else {
            jsonObject.b = true;
        }
    }

    public com.badlogic.gdx.utils.JsonWriter array() throws java.io.IOException {
        a();
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonWriter.JsonObject> array = this.t;
        com.badlogic.gdx.utils.JsonWriter.JsonObject jsonObject = new com.badlogic.gdx.utils.JsonWriter.JsonObject(true);
        this.u = jsonObject;
        array.add(jsonObject);
        return this;
    }

    public com.badlogic.gdx.utils.JsonWriter array(java.lang.String str) throws java.io.IOException {
        return name(str).array();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        while (this.t.size > 0) {
            pop();
        }
        this.n.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.n.flush();
    }

    public java.io.Writer getWriter() {
        return this.n;
    }

    public com.badlogic.gdx.utils.JsonWriter json(java.lang.String str) throws java.io.IOException {
        a();
        this.n.write(str);
        return this;
    }

    public com.badlogic.gdx.utils.JsonWriter json(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        return name(str).json(str2);
    }

    public com.badlogic.gdx.utils.JsonWriter name(java.lang.String str) throws java.io.IOException {
        com.badlogic.gdx.utils.JsonWriter.JsonObject jsonObject = this.u;
        if (jsonObject == null || jsonObject.a) {
            throw new java.lang.IllegalStateException("Current item must be an object.");
        }
        if (jsonObject.b) {
            this.n.write(44);
        } else {
            jsonObject.b = true;
        }
        this.n.write(this.w.quoteName(str));
        this.n.write(58);
        this.v = true;
        return this;
    }

    public com.badlogic.gdx.utils.JsonWriter object() throws java.io.IOException {
        a();
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonWriter.JsonObject> array = this.t;
        com.badlogic.gdx.utils.JsonWriter.JsonObject jsonObject = new com.badlogic.gdx.utils.JsonWriter.JsonObject(false);
        this.u = jsonObject;
        array.add(jsonObject);
        return this;
    }

    public com.badlogic.gdx.utils.JsonWriter object(java.lang.String str) throws java.io.IOException {
        return name(str).object();
    }

    public com.badlogic.gdx.utils.JsonWriter pop() throws java.io.IOException {
        if (this.v) {
            throw new java.lang.IllegalStateException("Expected an object, array, or value since a name was set.");
        }
        this.t.pop().a();
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonWriter.JsonObject> array = this.t;
        this.u = array.size == 0 ? null : array.peek();
        return this;
    }

    public com.badlogic.gdx.utils.JsonWriter set(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        return name(str).value(obj);
    }

    public void setOutputType(com.badlogic.gdx.utils.JsonWriter.OutputType outputType) {
        this.w = outputType;
    }

    public void setQuoteLongValues(boolean z) {
        this.x = z;
    }

    public com.badlogic.gdx.utils.JsonWriter value(java.lang.Object obj) throws java.io.IOException {
        if (this.x && ((obj instanceof java.lang.Long) || (obj instanceof java.lang.Double) || (obj instanceof java.math.BigDecimal) || (obj instanceof java.math.BigInteger))) {
            obj = obj.toString();
        } else if (obj instanceof java.lang.Number) {
            java.lang.Number number = (java.lang.Number) obj;
            long longValue = number.longValue();
            if (number.doubleValue() == longValue) {
                obj = java.lang.Long.valueOf(longValue);
            }
        }
        a();
        this.n.write(this.w.quoteValue(obj));
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws java.io.IOException {
        this.n.write(cArr, i, i2);
    }
}
