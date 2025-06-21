package com.google.gson;

/* loaded from: classes22.dex */
public abstract class TypeAdapter<T> {

    /* renamed from: com.google.gson.TypeAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.gson.TypeAdapter<T> {
        public AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return (T) com.google.gson.TypeAdapter.this.read2(jsonReader);
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            if (t == null) {
                jsonWriter.nullValue();
            } else {
                com.google.gson.TypeAdapter.this.write(jsonWriter, t);
            }
        }
    }

    public final T fromJson(java.io.Reader reader) throws java.io.IOException {
        return read2(new com.google.gson.stream.JsonReader(reader));
    }

    public final T fromJson(java.lang.String str) throws java.io.IOException {
        return fromJson(new java.io.StringReader(str));
    }

    public final T fromJsonTree(com.google.gson.JsonElement jsonElement) {
        try {
            return read2(new com.google.gson.internal.bind.JsonTreeReader(jsonElement));
        } catch (java.io.IOException e) {
            throw new com.google.gson.JsonIOException(e);
        }
    }

    public final com.google.gson.TypeAdapter<T> nullSafe() {
        return new com.google.gson.TypeAdapter.AnonymousClass1();
    }

    /* renamed from: read */
    public abstract T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException;

    public final java.lang.String toJson(T t) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public final void toJson(java.io.Writer writer, T t) throws java.io.IOException {
        write(new com.google.gson.stream.JsonWriter(writer), t);
    }

    public final com.google.gson.JsonElement toJsonTree(T t) {
        try {
            com.google.gson.internal.bind.JsonTreeWriter jsonTreeWriter = new com.google.gson.internal.bind.JsonTreeWriter();
            write(jsonTreeWriter, t);
            return jsonTreeWriter.get();
        } catch (java.io.IOException e) {
            throw new com.google.gson.JsonIOException(e);
        }
    }

    public abstract void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException;
}
