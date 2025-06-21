package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class JsonTreeReader extends com.google.gson.stream.JsonReader {
    private int[] pathIndices;
    private java.lang.String[] pathNames;
    private java.lang.Object[] stack;
    private int stackSize;
    private static final java.io.Reader UNREADABLE_READER = new com.google.gson.internal.bind.JsonTreeReader.AnonymousClass1();
    private static final java.lang.Object SENTINEL_CLOSED = new java.lang.Object();

    /* renamed from: com.google.gson.internal.bind.JsonTreeReader$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            throw new java.lang.AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            throw new java.lang.AssertionError();
        }
    }

    public JsonTreeReader(com.google.gson.JsonElement jsonElement) {
        super(UNREADABLE_READER);
        this.stack = new java.lang.Object[32];
        this.stackSize = 0;
        this.pathNames = new java.lang.String[32];
        this.pathIndices = new int[32];
        push(jsonElement);
    }

    private void expect(com.google.gson.stream.JsonToken jsonToken) throws java.io.IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new java.lang.IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    private java.lang.String locationString() {
        return " at path " + getPath();
    }

    private java.lang.Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private java.lang.Object popStack() {
        java.lang.Object[] objArr = this.stack;
        int i = this.stackSize - 1;
        this.stackSize = i;
        java.lang.Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private void push(java.lang.Object obj) {
        int i = this.stackSize;
        java.lang.Object[] objArr = this.stack;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.stack = java.util.Arrays.copyOf(objArr, i2);
            this.pathIndices = java.util.Arrays.copyOf(this.pathIndices, i2);
            this.pathNames = (java.lang.String[]) java.util.Arrays.copyOf(this.pathNames, i2);
        }
        java.lang.Object[] objArr2 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.stack = new java.lang.Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.END_ARRAY);
        popStack();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.END_OBJECT);
        popStack();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public java.lang.String getPath() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(kotlin.text.Typography.dollar);
        int i = 0;
        while (i < this.stackSize) {
            java.lang.Object[] objArr = this.stack;
            java.lang.Object obj = objArr[i];
            if (obj instanceof com.google.gson.JsonArray) {
                i++;
                if (objArr[i] instanceof java.util.Iterator) {
                    sb.append('[');
                    sb.append(this.pathIndices[i]);
                    sb.append(']');
                }
            } else if (obj instanceof com.google.gson.JsonObject) {
                i++;
                if (objArr[i] instanceof java.util.Iterator) {
                    sb.append('.');
                    java.lang.String str = this.pathNames[i];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws java.io.IOException {
        com.google.gson.stream.JsonToken peek = peek();
        return (peek == com.google.gson.stream.JsonToken.END_OBJECT || peek == com.google.gson.stream.JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.JsonPrimitive) popStack()).getAsBoolean();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws java.io.IOException {
        com.google.gson.stream.JsonToken peek = peek();
        com.google.gson.stream.JsonToken jsonToken = com.google.gson.stream.JsonToken.NUMBER;
        if (peek != jsonToken && peek != com.google.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        double asDouble = ((com.google.gson.JsonPrimitive) peekStack()).getAsDouble();
        if (!isLenient() && (java.lang.Double.isNaN(asDouble) || java.lang.Double.isInfinite(asDouble))) {
            throw new java.lang.NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws java.io.IOException {
        com.google.gson.stream.JsonToken peek = peek();
        com.google.gson.stream.JsonToken jsonToken = com.google.gson.stream.JsonToken.NUMBER;
        if (peek != jsonToken && peek != com.google.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        int asInt = ((com.google.gson.JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws java.io.IOException {
        com.google.gson.stream.JsonToken peek = peek();
        com.google.gson.stream.JsonToken jsonToken = com.google.gson.stream.JsonToken.NUMBER;
        if (peek != jsonToken && peek != com.google.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        long asLong = ((com.google.gson.JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public java.lang.String nextName() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry) ((java.util.Iterator) peekStack()).next();
        java.lang.String str = (java.lang.String) entry.getKey();
        this.pathNames[this.stackSize - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.NULL);
        popStack();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public java.lang.String nextString() throws java.io.IOException {
        com.google.gson.stream.JsonToken peek = peek();
        com.google.gson.stream.JsonToken jsonToken = com.google.gson.stream.JsonToken.STRING;
        if (peek == jsonToken || peek == com.google.gson.stream.JsonToken.NUMBER) {
            java.lang.String asString = ((com.google.gson.JsonPrimitive) popStack()).getAsString();
            int i = this.stackSize;
            if (i > 0) {
                int[] iArr = this.pathIndices;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return asString;
        }
        throw new java.lang.IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public com.google.gson.stream.JsonToken peek() throws java.io.IOException {
        if (this.stackSize == 0) {
            return com.google.gson.stream.JsonToken.END_DOCUMENT;
        }
        java.lang.Object peekStack = peekStack();
        if (peekStack instanceof java.util.Iterator) {
            boolean z = this.stack[this.stackSize - 2] instanceof com.google.gson.JsonObject;
            java.util.Iterator it = (java.util.Iterator) peekStack;
            if (!it.hasNext()) {
                return z ? com.google.gson.stream.JsonToken.END_OBJECT : com.google.gson.stream.JsonToken.END_ARRAY;
            }
            if (z) {
                return com.google.gson.stream.JsonToken.NAME;
            }
            push(it.next());
            return peek();
        }
        if (peekStack instanceof com.google.gson.JsonObject) {
            return com.google.gson.stream.JsonToken.BEGIN_OBJECT;
        }
        if (peekStack instanceof com.google.gson.JsonArray) {
            return com.google.gson.stream.JsonToken.BEGIN_ARRAY;
        }
        if (!(peekStack instanceof com.google.gson.JsonPrimitive)) {
            if (peekStack instanceof com.google.gson.JsonNull) {
                return com.google.gson.stream.JsonToken.NULL;
            }
            if (peekStack == SENTINEL_CLOSED) {
                throw new java.lang.IllegalStateException("JsonReader is closed");
            }
            throw new java.lang.AssertionError();
        }
        com.google.gson.JsonPrimitive jsonPrimitive = (com.google.gson.JsonPrimitive) peekStack;
        if (jsonPrimitive.isString()) {
            return com.google.gson.stream.JsonToken.STRING;
        }
        if (jsonPrimitive.isBoolean()) {
            return com.google.gson.stream.JsonToken.BOOLEAN;
        }
        if (jsonPrimitive.isNumber()) {
            return com.google.gson.stream.JsonToken.NUMBER;
        }
        throw new java.lang.AssertionError();
    }

    public void promoteNameToValue() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry) ((java.util.Iterator) peekStack()).next();
        push(entry.getValue());
        push(new com.google.gson.JsonPrimitive((java.lang.String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws java.io.IOException {
        if (peek() == com.google.gson.stream.JsonToken.NAME) {
            nextName();
            this.pathNames[this.stackSize - 2] = com.igexin.push.core.b.m;
        } else {
            popStack();
            int i = this.stackSize;
            if (i > 0) {
                this.pathNames[i - 1] = com.igexin.push.core.b.m;
            }
        }
        int i2 = this.stackSize;
        if (i2 > 0) {
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public java.lang.String toString() {
        return com.google.gson.internal.bind.JsonTreeReader.class.getSimpleName();
    }
}
