package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class MapTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;

    public final class Adapter<K, V> extends com.google.gson.TypeAdapter<java.util.Map<K, V>> {
        private final com.google.gson.internal.ObjectConstructor<? extends java.util.Map<K, V>> constructor;
        private final com.google.gson.TypeAdapter<K> keyTypeAdapter;
        private final com.google.gson.TypeAdapter<V> valueTypeAdapter;

        public Adapter(com.google.gson.Gson gson, java.lang.reflect.Type type, com.google.gson.TypeAdapter<K> typeAdapter, java.lang.reflect.Type type2, com.google.gson.TypeAdapter<V> typeAdapter2, com.google.gson.internal.ObjectConstructor<? extends java.util.Map<K, V>> objectConstructor) {
            this.keyTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.valueTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        private java.lang.String keyToString(com.google.gson.JsonElement jsonElement) {
            if (!jsonElement.isJsonPrimitive()) {
                if (jsonElement.isJsonNull()) {
                    return com.igexin.push.core.b.m;
                }
                throw new java.lang.AssertionError();
            }
            com.google.gson.JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return java.lang.String.valueOf(asJsonPrimitive.getAsNumber());
            }
            if (asJsonPrimitive.isBoolean()) {
                return java.lang.Boolean.toString(asJsonPrimitive.getAsBoolean());
            }
            if (asJsonPrimitive.isString()) {
                return asJsonPrimitive.getAsString();
            }
            throw new java.lang.AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.util.Map<K, V> read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.stream.JsonToken peek = jsonReader.peek();
            if (peek == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.Map<K, V> construct = this.constructor.construct();
            if (peek == com.google.gson.stream.JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K read2 = this.keyTypeAdapter.read2(jsonReader);
                    if (construct.put(read2, this.valueTypeAdapter.read2(jsonReader)) != null) {
                        throw new com.google.gson.JsonSyntaxException("duplicate key: " + read2);
                    }
                    jsonReader.endArray();
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    com.google.gson.internal.JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    K read22 = this.keyTypeAdapter.read2(jsonReader);
                    if (construct.put(read22, this.valueTypeAdapter.read2(jsonReader)) != null) {
                        throw new com.google.gson.JsonSyntaxException("duplicate key: " + read22);
                    }
                }
                jsonReader.endObject();
            }
            return construct;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Map<K, V> map) throws java.io.IOException {
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!com.google.gson.internal.bind.MapTypeAdapterFactory.this.complexMapKeySerialization) {
                jsonWriter.beginObject();
                for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.name(java.lang.String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
            java.util.ArrayList arrayList2 = new java.util.ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (java.util.Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.JsonElement jsonTree = this.keyTypeAdapter.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (!z) {
                jsonWriter.beginObject();
                int size = arrayList.size();
                while (i < size) {
                    jsonWriter.name(keyToString((com.google.gson.JsonElement) arrayList.get(i)));
                    this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.endObject();
                return;
            }
            jsonWriter.beginArray();
            int size2 = arrayList.size();
            while (i < size2) {
                jsonWriter.beginArray();
                com.google.gson.internal.Streams.write((com.google.gson.JsonElement) arrayList.get(i), jsonWriter);
                this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                jsonWriter.endArray();
                i++;
            }
            jsonWriter.endArray();
        }
    }

    public MapTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor, boolean z) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = z;
    }

    private com.google.gson.TypeAdapter<?> getKeyAdapter(com.google.gson.Gson gson, java.lang.reflect.Type type) {
        return (type == java.lang.Boolean.TYPE || type == java.lang.Boolean.class) ? com.google.gson.internal.bind.TypeAdapters.BOOLEAN_AS_STRING : gson.getAdapter(com.google.gson.reflect.TypeToken.get(type));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
        java.lang.reflect.Type type = typeToken.getType();
        if (!java.util.Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        java.lang.reflect.Type[] mapKeyAndValueTypes = com.google.gson.internal.C$Gson$Types.getMapKeyAndValueTypes(type, com.google.gson.internal.C$Gson$Types.getRawType(type));
        return new com.google.gson.internal.bind.MapTypeAdapterFactory.Adapter(gson, mapKeyAndValueTypes[0], getKeyAdapter(gson, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], gson.getAdapter(com.google.gson.reflect.TypeToken.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(typeToken));
    }
}
