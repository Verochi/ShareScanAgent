package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class CollectionTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;

    public static final class Adapter<E> extends com.google.gson.TypeAdapter<java.util.Collection<E>> {
        private final com.google.gson.internal.ObjectConstructor<? extends java.util.Collection<E>> constructor;
        private final com.google.gson.TypeAdapter<E> elementTypeAdapter;

        public Adapter(com.google.gson.Gson gson, java.lang.reflect.Type type, com.google.gson.TypeAdapter<E> typeAdapter, com.google.gson.internal.ObjectConstructor<? extends java.util.Collection<E>> objectConstructor) {
            this.elementTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.util.Collection<E> read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.Collection<E> construct = this.constructor.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                construct.add(this.elementTypeAdapter.read2(jsonReader));
            }
            jsonReader.endArray();
            return construct;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Collection<E> collection) throws java.io.IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            java.util.Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.elementTypeAdapter.write(jsonWriter, it.next());
            }
            jsonWriter.endArray();
        }
    }

    public CollectionTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
        java.lang.reflect.Type type = typeToken.getType();
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        if (!java.util.Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        java.lang.reflect.Type collectionElementType = com.google.gson.internal.C$Gson$Types.getCollectionElementType(type, rawType);
        return new com.google.gson.internal.bind.CollectionTypeAdapterFactory.Adapter(gson, collectionElementType, gson.getAdapter(com.google.gson.reflect.TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken));
    }
}
