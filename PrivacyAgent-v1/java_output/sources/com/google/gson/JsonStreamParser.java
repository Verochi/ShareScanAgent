package com.google.gson;

/* loaded from: classes22.dex */
public final class JsonStreamParser implements java.util.Iterator<com.google.gson.JsonElement> {
    private final java.lang.Object lock;
    private final com.google.gson.stream.JsonReader parser;

    public JsonStreamParser(java.io.Reader reader) {
        com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new java.lang.Object();
    }

    public JsonStreamParser(java.lang.String str) {
        this(new java.io.StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z = this.parser.peek() != com.google.gson.stream.JsonToken.END_DOCUMENT;
                    } catch (java.io.IOException e) {
                        throw new com.google.gson.JsonIOException(e);
                    }
                } catch (com.google.gson.stream.MalformedJsonException e2) {
                    throw new com.google.gson.JsonSyntaxException(e2);
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public com.google.gson.JsonElement next() throws com.google.gson.JsonParseException {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        try {
            return com.google.gson.internal.Streams.parse(this.parser);
        } catch (com.google.gson.JsonParseException e) {
            if (e.getCause() instanceof java.io.EOFException) {
                throw new java.util.NoSuchElementException();
            }
            throw e;
        } catch (java.lang.OutOfMemoryError e2) {
            throw new com.google.gson.JsonParseException("Failed parsing JSON source to Json", e2);
        } catch (java.lang.StackOverflowError e3) {
            throw new com.google.gson.JsonParseException("Failed parsing JSON source to Json", e3);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException();
    }
}
