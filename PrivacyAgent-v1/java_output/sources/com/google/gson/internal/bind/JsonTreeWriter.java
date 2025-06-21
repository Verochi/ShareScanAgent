package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class JsonTreeWriter extends com.google.gson.stream.JsonWriter {
    private java.lang.String pendingName;
    private com.google.gson.JsonElement product;
    private final java.util.List<com.google.gson.JsonElement> stack;
    private static final java.io.Writer UNWRITABLE_WRITER = new com.google.gson.internal.bind.JsonTreeWriter.AnonymousClass1();
    private static final com.google.gson.JsonPrimitive SENTINEL_CLOSED = new com.google.gson.JsonPrimitive("closed");

    /* renamed from: com.google.gson.internal.bind.JsonTreeWriter$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            throw new java.lang.AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws java.io.IOException {
            throw new java.lang.AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new java.lang.AssertionError();
        }
    }

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        this.stack = new java.util.ArrayList();
        this.product = com.google.gson.JsonNull.INSTANCE;
    }

    private com.google.gson.JsonElement peek() {
        return this.stack.get(r0.size() - 1);
    }

    private void put(com.google.gson.JsonElement jsonElement) {
        if (this.pendingName != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((com.google.gson.JsonObject) peek()).add(this.pendingName, jsonElement);
            }
            this.pendingName = null;
            return;
        }
        if (this.stack.isEmpty()) {
            this.product = jsonElement;
            return;
        }
        com.google.gson.JsonElement peek = peek();
        if (!(peek instanceof com.google.gson.JsonArray)) {
            throw new java.lang.IllegalStateException();
        }
        ((com.google.gson.JsonArray) peek).add(jsonElement);
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter beginArray() throws java.io.IOException {
        com.google.gson.JsonArray jsonArray = new com.google.gson.JsonArray();
        put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter beginObject() throws java.io.IOException {
        com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
        put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (!this.stack.isEmpty()) {
            throw new java.io.IOException("Incomplete document");
        }
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter endArray() throws java.io.IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new java.lang.IllegalStateException();
        }
        if (!(peek() instanceof com.google.gson.JsonArray)) {
            throw new java.lang.IllegalStateException();
        }
        this.stack.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter endObject() throws java.io.IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new java.lang.IllegalStateException();
        }
        if (!(peek() instanceof com.google.gson.JsonObject)) {
            throw new java.lang.IllegalStateException();
        }
        this.stack.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws java.io.IOException {
    }

    public com.google.gson.JsonElement get() {
        if (this.stack.isEmpty()) {
            return this.product;
        }
        throw new java.lang.IllegalStateException("Expected one JSON element but was " + this.stack);
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter name(java.lang.String str) throws java.io.IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new java.lang.IllegalStateException();
        }
        if (!(peek() instanceof com.google.gson.JsonObject)) {
            throw new java.lang.IllegalStateException();
        }
        this.pendingName = str;
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter nullValue() throws java.io.IOException {
        put(com.google.gson.JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter value(double d) throws java.io.IOException {
        if (isLenient() || !(java.lang.Double.isNaN(d) || java.lang.Double.isInfinite(d))) {
            put(new com.google.gson.JsonPrimitive(java.lang.Double.valueOf(d)));
            return this;
        }
        throw new java.lang.IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter value(long j) throws java.io.IOException {
        put(new com.google.gson.JsonPrimitive(java.lang.Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter value(java.lang.Boolean bool) throws java.io.IOException {
        if (bool == null) {
            return nullValue();
        }
        put(new com.google.gson.JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter value(java.lang.Number number) throws java.io.IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (java.lang.Double.isNaN(doubleValue) || java.lang.Double.isInfinite(doubleValue)) {
                throw new java.lang.IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        put(new com.google.gson.JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter value(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            return nullValue();
        }
        put(new com.google.gson.JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public com.google.gson.stream.JsonWriter value(boolean z) throws java.io.IOException {
        put(new com.google.gson.JsonPrimitive(java.lang.Boolean.valueOf(z)));
        return this;
    }
}
