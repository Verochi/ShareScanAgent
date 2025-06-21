package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class JsonValue implements java.lang.Iterable<com.badlogic.gdx.utils.JsonValue> {
    public com.badlogic.gdx.utils.JsonValue child;
    public com.badlogic.gdx.utils.JsonValue.ValueType n;
    public java.lang.String name;
    public com.badlogic.gdx.utils.JsonValue next;
    public com.badlogic.gdx.utils.JsonValue parent;
    public com.badlogic.gdx.utils.JsonValue prev;
    public int size;
    public java.lang.String t;
    public double u;
    public long v;

    /* renamed from: com.badlogic.gdx.utils.JsonValue$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.badlogic.gdx.utils.JsonValue.ValueType.values().length];
            a = iArr;
            try {
                iArr[com.badlogic.gdx.utils.JsonValue.ValueType.stringValue.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.badlogic.gdx.utils.JsonValue.ValueType.doubleValue.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.badlogic.gdx.utils.JsonValue.ValueType.longValue.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.badlogic.gdx.utils.JsonValue.ValueType.booleanValue.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.badlogic.gdx.utils.JsonValue.ValueType.nullValue.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public class JsonIterator implements java.util.Iterator<com.badlogic.gdx.utils.JsonValue>, java.lang.Iterable<com.badlogic.gdx.utils.JsonValue> {
        public com.badlogic.gdx.utils.JsonValue n;
        public com.badlogic.gdx.utils.JsonValue t;

        public JsonIterator() {
            this.n = com.badlogic.gdx.utils.JsonValue.this.child;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n != null;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<com.badlogic.gdx.utils.JsonValue> iterator() {
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public com.badlogic.gdx.utils.JsonValue next() {
            com.badlogic.gdx.utils.JsonValue jsonValue = this.n;
            this.t = jsonValue;
            if (jsonValue == null) {
                throw new java.util.NoSuchElementException();
            }
            this.n = jsonValue.next;
            return jsonValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.badlogic.gdx.utils.JsonValue jsonValue = this.t;
            com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.prev;
            if (jsonValue2 == null) {
                com.badlogic.gdx.utils.JsonValue jsonValue3 = com.badlogic.gdx.utils.JsonValue.this;
                com.badlogic.gdx.utils.JsonValue jsonValue4 = jsonValue.next;
                jsonValue3.child = jsonValue4;
                if (jsonValue4 != null) {
                    jsonValue4.prev = null;
                }
            } else {
                jsonValue2.next = jsonValue.next;
                com.badlogic.gdx.utils.JsonValue jsonValue5 = jsonValue.next;
                if (jsonValue5 != null) {
                    jsonValue5.prev = jsonValue2;
                }
            }
            com.badlogic.gdx.utils.JsonValue jsonValue6 = com.badlogic.gdx.utils.JsonValue.this;
            jsonValue6.size--;
        }
    }

    public static class PrettyPrintSettings {
        public com.badlogic.gdx.utils.JsonWriter.OutputType outputType;
        public int singleLineColumns;
        public boolean wrapNumericArrays;
    }

    public enum ValueType {
        object,
        array,
        stringValue,
        doubleValue,
        longValue,
        booleanValue,
        nullValue
    }

    public JsonValue(double d) {
        set(d, (java.lang.String) null);
    }

    public JsonValue(double d, java.lang.String str) {
        set(d, str);
    }

    public JsonValue(long j) {
        set(j, (java.lang.String) null);
    }

    public JsonValue(long j, java.lang.String str) {
        set(j, str);
    }

    public JsonValue(com.badlogic.gdx.utils.JsonValue.ValueType valueType) {
        this.n = valueType;
    }

    public JsonValue(java.lang.String str) {
        set(str);
    }

    public JsonValue(boolean z) {
        set(z);
    }

    public static void a(int i, com.badlogic.gdx.utils.StringBuilder stringBuilder) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append('\t');
        }
    }

    public static boolean b(com.badlogic.gdx.utils.JsonValue jsonValue) {
        for (com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
            if (jsonValue2.isObject() || jsonValue2.isArray()) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(com.badlogic.gdx.utils.JsonValue jsonValue) {
        for (com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
            if (!jsonValue2.isNumber()) {
                return false;
            }
        }
        return true;
    }

    public void addChild(com.badlogic.gdx.utils.JsonValue jsonValue) {
        jsonValue.parent = this;
        com.badlogic.gdx.utils.JsonValue jsonValue2 = this.child;
        if (jsonValue2 == null) {
            this.child = jsonValue;
            return;
        }
        while (true) {
            com.badlogic.gdx.utils.JsonValue jsonValue3 = jsonValue2.next;
            if (jsonValue3 == null) {
                jsonValue2.next = jsonValue;
                return;
            }
            jsonValue2 = jsonValue3;
        }
    }

    public void addChild(java.lang.String str, com.badlogic.gdx.utils.JsonValue jsonValue) {
        jsonValue.name = str;
        addChild(jsonValue);
    }

    public boolean asBoolean() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return this.t.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
        if (i == 2) {
            return this.u != 0.0d;
        }
        if (i == 3) {
            return this.v != 0;
        }
        if (i == 4) {
            return this.v != 0;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to boolean: " + this.n);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r1.v != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if (r1.v == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        if (r1.u == 0.0d) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean[] asBooleanArray() {
        boolean parseBoolean;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        boolean[] zArr = new boolean[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i = 0;
        while (jsonValue != null) {
            int i2 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i2 == 1) {
                parseBoolean = java.lang.Boolean.parseBoolean(jsonValue.t);
            } else if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new java.lang.IllegalStateException("Value cannot be converted to boolean: " + jsonValue.n);
                    }
                }
            }
            zArr[i] = parseBoolean;
            jsonValue = jsonValue.next;
            i++;
        }
        return zArr;
    }

    public byte asByte() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return java.lang.Byte.parseByte(this.t);
        }
        if (i == 2) {
            return (byte) this.u;
        }
        if (i == 3) {
            return (byte) this.v;
        }
        if (i == 4) {
            return this.v != 0 ? (byte) 1 : (byte) 0;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to byte: " + this.n);
    }

    public byte[] asByteArray() {
        byte parseByte;
        int i;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        byte[] bArr = new byte[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i2 = 0;
        while (jsonValue != null) {
            int i3 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    i = (int) jsonValue.u;
                } else if (i3 == 3) {
                    i = (int) jsonValue.v;
                } else {
                    if (i3 != 4) {
                        throw new java.lang.IllegalStateException("Value cannot be converted to byte: " + jsonValue.n);
                    }
                    parseByte = jsonValue.v != 0 ? (byte) 1 : (byte) 0;
                }
                parseByte = (byte) i;
            } else {
                parseByte = java.lang.Byte.parseByte(jsonValue.t);
            }
            bArr[i2] = parseByte;
            jsonValue = jsonValue.next;
            i2++;
        }
        return bArr;
    }

    public char asChar() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            if (this.t.length() == 0) {
                return (char) 0;
            }
            return this.t.charAt(0);
        }
        if (i == 2) {
            return (char) this.u;
        }
        if (i == 3) {
            return (char) this.v;
        }
        if (i == 4) {
            return this.v != 0 ? (char) 1 : (char) 0;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to char: " + this.n);
    }

    public char[] asCharArray() {
        char charAt;
        int i;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        char[] cArr = new char[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i2 = 0;
        while (jsonValue != null) {
            int i3 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    i = (int) jsonValue.u;
                } else if (i3 == 3) {
                    i = (int) jsonValue.v;
                } else {
                    if (i3 != 4) {
                        throw new java.lang.IllegalStateException("Value cannot be converted to char: " + jsonValue.n);
                    }
                    if (jsonValue.v != 0) {
                        charAt = 1;
                    }
                    charAt = 0;
                }
                charAt = (char) i;
            } else {
                if (jsonValue.t.length() != 0) {
                    charAt = jsonValue.t.charAt(0);
                }
                charAt = 0;
            }
            cArr[i2] = charAt;
            jsonValue = jsonValue.next;
            i2++;
        }
        return cArr;
    }

    public double asDouble() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return java.lang.Double.parseDouble(this.t);
        }
        if (i == 2) {
            return this.u;
        }
        if (i == 3) {
            return this.v;
        }
        if (i == 4) {
            return this.v != 0 ? 1.0d : 0.0d;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to double: " + this.n);
    }

    public double[] asDoubleArray() {
        double parseDouble;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        double[] dArr = new double[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i = 0;
        while (jsonValue != null) {
            int i2 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i2 == 1) {
                parseDouble = java.lang.Double.parseDouble(jsonValue.t);
            } else if (i2 == 2) {
                parseDouble = jsonValue.u;
            } else if (i2 == 3) {
                parseDouble = jsonValue.v;
            } else {
                if (i2 != 4) {
                    throw new java.lang.IllegalStateException("Value cannot be converted to double: " + jsonValue.n);
                }
                parseDouble = jsonValue.v != 0 ? 1.0d : 0.0d;
            }
            dArr[i] = parseDouble;
            jsonValue = jsonValue.next;
            i++;
        }
        return dArr;
    }

    public float asFloat() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return java.lang.Float.parseFloat(this.t);
        }
        if (i == 2) {
            return (float) this.u;
        }
        if (i == 3) {
            return this.v;
        }
        if (i == 4) {
            return this.v != 0 ? 1.0f : 0.0f;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to float: " + this.n);
    }

    public float[] asFloatArray() {
        float parseFloat;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        float[] fArr = new float[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i = 0;
        while (jsonValue != null) {
            int i2 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i2 == 1) {
                parseFloat = java.lang.Float.parseFloat(jsonValue.t);
            } else if (i2 == 2) {
                parseFloat = (float) jsonValue.u;
            } else if (i2 == 3) {
                parseFloat = jsonValue.v;
            } else {
                if (i2 != 4) {
                    throw new java.lang.IllegalStateException("Value cannot be converted to float: " + jsonValue.n);
                }
                parseFloat = jsonValue.v != 0 ? 1.0f : 0.0f;
            }
            fArr[i] = parseFloat;
            jsonValue = jsonValue.next;
            i++;
        }
        return fArr;
    }

    public int asInt() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return java.lang.Integer.parseInt(this.t);
        }
        if (i == 2) {
            return (int) this.u;
        }
        if (i == 3) {
            return (int) this.v;
        }
        if (i == 4) {
            return this.v != 0 ? 1 : 0;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to int: " + this.n);
    }

    public int[] asIntArray() {
        int parseInt;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        int[] iArr = new int[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i = 0;
        while (jsonValue != null) {
            int i2 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i2 == 1) {
                parseInt = java.lang.Integer.parseInt(jsonValue.t);
            } else if (i2 == 2) {
                parseInt = (int) jsonValue.u;
            } else if (i2 == 3) {
                parseInt = (int) jsonValue.v;
            } else {
                if (i2 != 4) {
                    throw new java.lang.IllegalStateException("Value cannot be converted to int: " + jsonValue.n);
                }
                parseInt = jsonValue.v != 0 ? 1 : 0;
            }
            iArr[i] = parseInt;
            jsonValue = jsonValue.next;
            i++;
        }
        return iArr;
    }

    public long asLong() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return java.lang.Long.parseLong(this.t);
        }
        if (i == 2) {
            return (long) this.u;
        }
        if (i == 3) {
            return this.v;
        }
        if (i == 4) {
            return this.v != 0 ? 1L : 0L;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to long: " + this.n);
    }

    public long[] asLongArray() {
        long parseLong;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        long[] jArr = new long[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i = 0;
        while (jsonValue != null) {
            int i2 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i2 == 1) {
                parseLong = java.lang.Long.parseLong(jsonValue.t);
            } else if (i2 == 2) {
                parseLong = (long) jsonValue.u;
            } else if (i2 == 3) {
                parseLong = jsonValue.v;
            } else {
                if (i2 != 4) {
                    throw new java.lang.IllegalStateException("Value cannot be converted to long: " + jsonValue.n);
                }
                parseLong = 0;
                if (jsonValue.v != 0) {
                    parseLong = 1;
                }
            }
            jArr[i] = parseLong;
            jsonValue = jsonValue.next;
            i++;
        }
        return jArr;
    }

    public short asShort() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return java.lang.Short.parseShort(this.t);
        }
        if (i == 2) {
            return (short) this.u;
        }
        if (i == 3) {
            return (short) this.v;
        }
        if (i == 4) {
            return this.v != 0 ? (short) 1 : (short) 0;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to short: " + this.n);
    }

    public short[] asShortArray() {
        short parseShort;
        int i;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        short[] sArr = new short[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i2 = 0;
        while (jsonValue != null) {
            int i3 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    i = (int) jsonValue.u;
                } else if (i3 == 3) {
                    i = (int) jsonValue.v;
                } else {
                    if (i3 != 4) {
                        throw new java.lang.IllegalStateException("Value cannot be converted to short: " + jsonValue.n);
                    }
                    parseShort = jsonValue.v != 0 ? (short) 1 : (short) 0;
                }
                parseShort = (short) i;
            } else {
                parseShort = java.lang.Short.parseShort(jsonValue.t);
            }
            sArr[i2] = parseShort;
            jsonValue = jsonValue.next;
            i2++;
        }
        return sArr;
    }

    public java.lang.String asString() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return this.t;
        }
        if (i == 2) {
            java.lang.String str = this.t;
            return str != null ? str : java.lang.Double.toString(this.u);
        }
        if (i == 3) {
            java.lang.String str2 = this.t;
            return str2 != null ? str2 : java.lang.Long.toString(this.v);
        }
        if (i == 4) {
            return this.v != 0 ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
        }
        if (i == 5) {
            return null;
        }
        throw new java.lang.IllegalStateException("Value cannot be converted to string: " + this.n);
    }

    public java.lang.String[] asStringArray() {
        java.lang.String str;
        if (this.n != com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            throw new java.lang.IllegalStateException("Value is not an array: " + this.n);
        }
        java.lang.String[] strArr = new java.lang.String[this.size];
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        int i = 0;
        while (jsonValue != null) {
            int i2 = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[jsonValue.n.ordinal()];
            if (i2 == 1) {
                str = jsonValue.t;
            } else if (i2 == 2) {
                str = this.t;
                if (str == null) {
                    str = java.lang.Double.toString(jsonValue.u);
                }
            } else if (i2 == 3) {
                str = this.t;
                if (str == null) {
                    str = java.lang.Long.toString(jsonValue.v);
                }
            } else if (i2 == 4) {
                str = jsonValue.v != 0 ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
            } else {
                if (i2 != 5) {
                    throw new java.lang.IllegalStateException("Value cannot be converted to string: " + jsonValue.n);
                }
                str = null;
            }
            strArr[i] = str;
            jsonValue = jsonValue.next;
            i++;
        }
        return strArr;
    }

    public com.badlogic.gdx.utils.JsonValue child() {
        return this.child;
    }

    public final void d(com.badlogic.gdx.utils.JsonValue jsonValue, com.badlogic.gdx.utils.StringBuilder stringBuilder, com.badlogic.gdx.utils.JsonWriter.OutputType outputType) {
        if (jsonValue.isObject()) {
            if (jsonValue.child == null) {
                stringBuilder.append("{}");
                return;
            }
            stringBuilder.length();
            stringBuilder.append('{');
            for (com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
                stringBuilder.append(outputType.quoteName(jsonValue2.name));
                stringBuilder.append(':');
                d(jsonValue2, stringBuilder, outputType);
                if (jsonValue2.next != null) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append('}');
            return;
        }
        if (jsonValue.isArray()) {
            if (jsonValue.child == null) {
                stringBuilder.append("[]");
                return;
            }
            stringBuilder.length();
            stringBuilder.append('[');
            for (com.badlogic.gdx.utils.JsonValue jsonValue3 = jsonValue.child; jsonValue3 != null; jsonValue3 = jsonValue3.next) {
                d(jsonValue3, stringBuilder, outputType);
                if (jsonValue3.next != null) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(']');
            return;
        }
        if (jsonValue.isString()) {
            stringBuilder.append(outputType.quoteValue(jsonValue.asString()));
            return;
        }
        if (jsonValue.isDouble()) {
            double asDouble = jsonValue.asDouble();
            double asLong = jsonValue.asLong();
            if (asDouble == asLong) {
                asDouble = asLong;
            }
            stringBuilder.append(asDouble);
            return;
        }
        if (jsonValue.isLong()) {
            stringBuilder.append(jsonValue.asLong());
            return;
        }
        if (!jsonValue.isBoolean()) {
            if (jsonValue.isNull()) {
                stringBuilder.append(com.igexin.push.core.b.m);
                return;
            }
            throw new com.badlogic.gdx.utils.SerializationException("Unknown object type: " + jsonValue);
        }
        stringBuilder.append(jsonValue.asBoolean());
    }

    public final void e(com.badlogic.gdx.utils.JsonValue jsonValue, com.badlogic.gdx.utils.StringBuilder stringBuilder, int i, com.badlogic.gdx.utils.JsonValue.PrettyPrintSettings prettyPrintSettings) {
        com.badlogic.gdx.utils.JsonWriter.OutputType outputType = prettyPrintSettings.outputType;
        if (jsonValue.isObject()) {
            if (jsonValue.child == null) {
                stringBuilder.append("{}");
                return;
            }
            boolean z = !b(jsonValue);
            int length = stringBuilder.length();
            loop0: while (true) {
                stringBuilder.append(z ? "{\n" : "{ ");
                for (com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
                    if (z) {
                        a(i, stringBuilder);
                    }
                    stringBuilder.append(outputType.quoteName(jsonValue2.name));
                    stringBuilder.append(": ");
                    e(jsonValue2, stringBuilder, i + 1, prettyPrintSettings);
                    if ((!z || outputType != com.badlogic.gdx.utils.JsonWriter.OutputType.minimal) && jsonValue2.next != null) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append(z ? '\n' : ' ');
                    if (z || stringBuilder.length() - length <= prettyPrintSettings.singleLineColumns) {
                    }
                }
                stringBuilder.setLength(length);
                z = true;
            }
            if (z) {
                a(i - 1, stringBuilder);
            }
            stringBuilder.append('}');
            return;
        }
        if (!jsonValue.isArray()) {
            if (jsonValue.isString()) {
                stringBuilder.append(outputType.quoteValue(jsonValue.asString()));
                return;
            }
            if (jsonValue.isDouble()) {
                double asDouble = jsonValue.asDouble();
                double asLong = jsonValue.asLong();
                if (asDouble == asLong) {
                    asDouble = asLong;
                }
                stringBuilder.append(asDouble);
                return;
            }
            if (jsonValue.isLong()) {
                stringBuilder.append(jsonValue.asLong());
                return;
            }
            if (jsonValue.isBoolean()) {
                stringBuilder.append(jsonValue.asBoolean());
                return;
            } else {
                if (jsonValue.isNull()) {
                    stringBuilder.append(com.igexin.push.core.b.m);
                    return;
                }
                throw new com.badlogic.gdx.utils.SerializationException("Unknown object type: " + jsonValue);
            }
        }
        if (jsonValue.child == null) {
            stringBuilder.append("[]");
            return;
        }
        boolean z2 = !b(jsonValue);
        boolean z3 = prettyPrintSettings.wrapNumericArrays || !c(jsonValue);
        int length2 = stringBuilder.length();
        loop2: while (true) {
            stringBuilder.append(z2 ? "[\n" : "[ ");
            for (com.badlogic.gdx.utils.JsonValue jsonValue3 = jsonValue.child; jsonValue3 != null; jsonValue3 = jsonValue3.next) {
                if (z2) {
                    a(i, stringBuilder);
                }
                e(jsonValue3, stringBuilder, i + 1, prettyPrintSettings);
                if ((!z2 || outputType != com.badlogic.gdx.utils.JsonWriter.OutputType.minimal) && jsonValue3.next != null) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(z2 ? '\n' : ' ');
                if (!z3 || z2 || stringBuilder.length() - length2 <= prettyPrintSettings.singleLineColumns) {
                }
            }
            stringBuilder.setLength(length2);
            z2 = true;
        }
        if (z2) {
            a(i - 1, stringBuilder);
        }
        stringBuilder.append(']');
    }

    public com.badlogic.gdx.utils.JsonValue get(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        while (jsonValue != null && i > 0) {
            i--;
            jsonValue = jsonValue.next;
        }
        return jsonValue;
    }

    public com.badlogic.gdx.utils.JsonValue get(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        while (jsonValue != null && !jsonValue.name.equalsIgnoreCase(str)) {
            jsonValue = jsonValue.next;
        }
        return jsonValue;
    }

    public boolean getBoolean(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asBoolean();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public boolean getBoolean(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asBoolean();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public boolean getBoolean(java.lang.String str, boolean z) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? z : jsonValue.asBoolean();
    }

    public byte getByte(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asByte();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public byte getByte(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asByte();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public byte getByte(java.lang.String str, byte b) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? b : jsonValue.asByte();
    }

    public char getChar(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asChar();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public char getChar(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asChar();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public char getChar(java.lang.String str, char c) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? c : jsonValue.asChar();
    }

    public com.badlogic.gdx.utils.JsonValue getChild(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue == null) {
            return null;
        }
        return jsonValue.child;
    }

    public double getDouble(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asDouble();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public double getDouble(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asDouble();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public double getDouble(java.lang.String str, double d) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? d : jsonValue.asDouble();
    }

    public float getFloat(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asFloat();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public float getFloat(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asFloat();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public float getFloat(java.lang.String str, float f) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? f : jsonValue.asFloat();
    }

    public int getInt(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asInt();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public int getInt(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asInt();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public int getInt(java.lang.String str, int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? i : jsonValue.asInt();
    }

    public long getLong(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asLong();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public long getLong(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asLong();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public long getLong(java.lang.String str, long j) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? j : jsonValue.asLong();
    }

    public short getShort(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asShort();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public short getShort(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asShort();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public short getShort(java.lang.String str, short s2) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue()) ? s2 : jsonValue.asShort();
    }

    public java.lang.String getString(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue != null) {
            return jsonValue.asString();
        }
        throw new java.lang.IllegalArgumentException("Indexed value not found: " + this.name);
    }

    public java.lang.String getString(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asString();
        }
        throw new java.lang.IllegalArgumentException("Named value not found: " + str);
    }

    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue() || jsonValue.isNull()) ? str2 : jsonValue.asString();
    }

    public boolean has(java.lang.String str) {
        return get(str) != null;
    }

    public boolean hasChild(java.lang.String str) {
        return getChild(str) != null;
    }

    public boolean isArray() {
        return this.n == com.badlogic.gdx.utils.JsonValue.ValueType.array;
    }

    public boolean isBoolean() {
        return this.n == com.badlogic.gdx.utils.JsonValue.ValueType.booleanValue;
    }

    public boolean isDouble() {
        return this.n == com.badlogic.gdx.utils.JsonValue.ValueType.doubleValue;
    }

    public boolean isLong() {
        return this.n == com.badlogic.gdx.utils.JsonValue.ValueType.longValue;
    }

    public boolean isNull() {
        return this.n == com.badlogic.gdx.utils.JsonValue.ValueType.nullValue;
    }

    public boolean isNumber() {
        com.badlogic.gdx.utils.JsonValue.ValueType valueType = this.n;
        return valueType == com.badlogic.gdx.utils.JsonValue.ValueType.doubleValue || valueType == com.badlogic.gdx.utils.JsonValue.ValueType.longValue;
    }

    public boolean isObject() {
        return this.n == com.badlogic.gdx.utils.JsonValue.ValueType.object;
    }

    public boolean isString() {
        return this.n == com.badlogic.gdx.utils.JsonValue.ValueType.stringValue;
    }

    public boolean isValue() {
        int i = com.badlogic.gdx.utils.JsonValue.AnonymousClass1.a[this.n.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public java.util.Iterator<com.badlogic.gdx.utils.JsonValue> iterator2() {
        return new com.badlogic.gdx.utils.JsonValue.JsonIterator();
    }

    public java.lang.String name() {
        return this.name;
    }

    public com.badlogic.gdx.utils.JsonValue next() {
        return this.next;
    }

    public com.badlogic.gdx.utils.JsonValue parent() {
        return this.parent;
    }

    public java.lang.String prettyPrint(com.badlogic.gdx.utils.JsonValue.PrettyPrintSettings prettyPrintSettings) {
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(512);
        e(this, stringBuilder, 0, prettyPrintSettings);
        return stringBuilder.toString();
    }

    public java.lang.String prettyPrint(com.badlogic.gdx.utils.JsonWriter.OutputType outputType, int i) {
        com.badlogic.gdx.utils.JsonValue.PrettyPrintSettings prettyPrintSettings = new com.badlogic.gdx.utils.JsonValue.PrettyPrintSettings();
        prettyPrintSettings.outputType = outputType;
        prettyPrintSettings.singleLineColumns = i;
        return prettyPrint(prettyPrintSettings);
    }

    public com.badlogic.gdx.utils.JsonValue prev() {
        return this.prev;
    }

    public com.badlogic.gdx.utils.JsonValue remove(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(i);
        if (jsonValue == null) {
            return null;
        }
        com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.prev;
        if (jsonValue2 == null) {
            com.badlogic.gdx.utils.JsonValue jsonValue3 = jsonValue.next;
            this.child = jsonValue3;
            if (jsonValue3 != null) {
                jsonValue3.prev = null;
            }
        } else {
            jsonValue2.next = jsonValue.next;
            com.badlogic.gdx.utils.JsonValue jsonValue4 = jsonValue.next;
            if (jsonValue4 != null) {
                jsonValue4.prev = jsonValue2;
            }
        }
        this.size--;
        return jsonValue;
    }

    public com.badlogic.gdx.utils.JsonValue remove(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = get(str);
        if (jsonValue == null) {
            return null;
        }
        com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.prev;
        if (jsonValue2 == null) {
            com.badlogic.gdx.utils.JsonValue jsonValue3 = jsonValue.next;
            this.child = jsonValue3;
            if (jsonValue3 != null) {
                jsonValue3.prev = null;
            }
        } else {
            jsonValue2.next = jsonValue.next;
            com.badlogic.gdx.utils.JsonValue jsonValue4 = jsonValue.next;
            if (jsonValue4 != null) {
                jsonValue4.prev = jsonValue2;
            }
        }
        this.size--;
        return jsonValue;
    }

    public com.badlogic.gdx.utils.JsonValue require(int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        while (jsonValue != null && i > 0) {
            i--;
            jsonValue = jsonValue.next;
        }
        if (jsonValue != null) {
            return jsonValue;
        }
        throw new java.lang.IllegalArgumentException("Child not found with index: " + i);
    }

    public com.badlogic.gdx.utils.JsonValue require(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = this.child;
        while (jsonValue != null && !jsonValue.name.equalsIgnoreCase(str)) {
            jsonValue = jsonValue.next;
        }
        if (jsonValue != null) {
            return jsonValue;
        }
        throw new java.lang.IllegalArgumentException("Child not found with name: " + str);
    }

    public void set(double d, java.lang.String str) {
        this.u = d;
        this.v = (long) d;
        this.t = str;
        this.n = com.badlogic.gdx.utils.JsonValue.ValueType.doubleValue;
    }

    public void set(long j, java.lang.String str) {
        this.v = j;
        this.u = j;
        this.t = str;
        this.n = com.badlogic.gdx.utils.JsonValue.ValueType.longValue;
    }

    public void set(java.lang.String str) {
        this.t = str;
        this.n = str == null ? com.badlogic.gdx.utils.JsonValue.ValueType.nullValue : com.badlogic.gdx.utils.JsonValue.ValueType.stringValue;
    }

    public void set(boolean z) {
        this.v = z ? 1L : 0L;
        this.n = com.badlogic.gdx.utils.JsonValue.ValueType.booleanValue;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setNext(com.badlogic.gdx.utils.JsonValue jsonValue) {
        this.next = jsonValue;
    }

    public void setPrev(com.badlogic.gdx.utils.JsonValue jsonValue) {
        this.prev = jsonValue;
    }

    public void setType(com.badlogic.gdx.utils.JsonValue.ValueType valueType) {
        if (valueType == null) {
            throw new java.lang.IllegalArgumentException("type cannot be null.");
        }
        this.n = valueType;
    }

    @java.lang.Deprecated
    public int size() {
        return this.size;
    }

    public java.lang.String toJson(com.badlogic.gdx.utils.JsonWriter.OutputType outputType) {
        if (isValue()) {
            return asString();
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(512);
        d(this, stringBuilder, outputType);
        return stringBuilder.toString();
    }

    public java.lang.String toString() {
        java.lang.String str;
        if (isValue()) {
            if (this.name == null) {
                return asString();
            }
            return this.name + ": " + asString();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.name == null) {
            str = "";
        } else {
            str = this.name + ": ";
        }
        sb.append(str);
        sb.append(prettyPrint(com.badlogic.gdx.utils.JsonWriter.OutputType.minimal, 0));
        return sb.toString();
    }

    public java.lang.String trace() {
        com.badlogic.gdx.utils.JsonValue jsonValue = this.parent;
        java.lang.String str = "[]";
        if (jsonValue == null) {
            com.badlogic.gdx.utils.JsonValue.ValueType valueType = this.n;
            return valueType == com.badlogic.gdx.utils.JsonValue.ValueType.array ? "[]" : valueType == com.badlogic.gdx.utils.JsonValue.ValueType.object ? "{}" : "";
        }
        if (jsonValue.n == com.badlogic.gdx.utils.JsonValue.ValueType.array) {
            com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child;
            int i = 0;
            while (true) {
                if (jsonValue2 == null) {
                    break;
                }
                if (jsonValue2 == this) {
                    str = "[" + i + "]";
                    break;
                }
                jsonValue2 = jsonValue2.next;
                i++;
            }
        } else if (this.name.indexOf(46) != -1) {
            str = ".\"" + this.name.replace("\"", "\\\"") + "\"";
        } else {
            str = '.' + this.name;
        }
        return this.parent.trace() + str;
    }

    public com.badlogic.gdx.utils.JsonValue.ValueType type() {
        return this.n;
    }
}
