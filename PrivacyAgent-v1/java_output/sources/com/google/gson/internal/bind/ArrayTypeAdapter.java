package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class ArrayTypeAdapter<E> extends com.google.gson.TypeAdapter<java.lang.Object> {
    public static final com.google.gson.TypeAdapterFactory FACTORY = new com.google.gson.internal.bind.ArrayTypeAdapter.AnonymousClass1();
    private final java.lang.Class<E> componentType;
    private final com.google.gson.TypeAdapter<E> componentTypeAdapter;

    /* renamed from: com.google.gson.internal.bind.ArrayTypeAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.gson.TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            java.lang.reflect.Type type = typeToken.getType();
            if (!(type instanceof java.lang.reflect.GenericArrayType) && (!(type instanceof java.lang.Class) || !((java.lang.Class) type).isArray())) {
                return null;
            }
            java.lang.reflect.Type arrayComponentType = com.google.gson.internal.C$Gson$Types.getArrayComponentType(type);
            return new com.google.gson.internal.bind.ArrayTypeAdapter(gson, gson.getAdapter(com.google.gson.reflect.TypeToken.get(arrayComponentType)), com.google.gson.internal.C$Gson$Types.getRawType(arrayComponentType));
        }
    }

    public ArrayTypeAdapter(com.google.gson.Gson gson, com.google.gson.TypeAdapter<E> typeAdapter, java.lang.Class<E> cls) {
        this.componentTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public java.lang.Object read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read2(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        java.lang.Object newInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) this.componentType, size);
        for (int i = 0; i < size; i++) {
            java.lang.reflect.Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.io.IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = java.lang.reflect.Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(jsonWriter, java.lang.reflect.Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}
