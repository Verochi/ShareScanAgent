package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends com.google.gson.TypeAdapter<T> {
    private final com.google.gson.Gson context;
    private final com.google.gson.TypeAdapter<T> delegate;
    private final java.lang.reflect.Type type;

    public TypeAdapterRuntimeTypeWrapper(com.google.gson.Gson gson, com.google.gson.TypeAdapter<T> typeAdapter, java.lang.reflect.Type type) {
        this.context = gson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    private java.lang.reflect.Type getRuntimeTypeIfMoreSpecific(java.lang.reflect.Type type, java.lang.Object obj) {
        return obj != null ? (type == java.lang.Object.class || (type instanceof java.lang.reflect.TypeVariable) || (type instanceof java.lang.Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        return this.delegate.read2(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
        com.google.gson.TypeAdapter<T> typeAdapter = this.delegate;
        java.lang.reflect.Type runtimeTypeIfMoreSpecific = getRuntimeTypeIfMoreSpecific(this.type, t);
        if (runtimeTypeIfMoreSpecific != this.type) {
            typeAdapter = this.context.getAdapter(com.google.gson.reflect.TypeToken.get(runtimeTypeIfMoreSpecific));
            if (typeAdapter instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter) {
                com.google.gson.TypeAdapter<T> typeAdapter2 = this.delegate;
                if (!(typeAdapter2 instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(jsonWriter, t);
    }
}
