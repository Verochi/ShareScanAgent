package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class TreeTypeAdapter<T> extends com.google.gson.TypeAdapter<T> {
    private final com.google.gson.internal.bind.TreeTypeAdapter<T>.GsonContextImpl context = new com.google.gson.internal.bind.TreeTypeAdapter.GsonContextImpl(this, null);
    private com.google.gson.TypeAdapter<T> delegate;
    private final com.google.gson.JsonDeserializer<T> deserializer;
    final com.google.gson.Gson gson;
    private final com.google.gson.JsonSerializer<T> serializer;
    private final com.google.gson.TypeAdapterFactory skipPast;
    private final com.google.gson.reflect.TypeToken<T> typeToken;

    public final class GsonContextImpl implements com.google.gson.JsonSerializationContext, com.google.gson.JsonDeserializationContext {
        private GsonContextImpl() {
        }

        public /* synthetic */ GsonContextImpl(com.google.gson.internal.bind.TreeTypeAdapter treeTypeAdapter, com.google.gson.internal.bind.TreeTypeAdapter.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws com.google.gson.JsonParseException {
            return (R) com.google.gson.internal.bind.TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public com.google.gson.JsonElement serialize(java.lang.Object obj) {
            return com.google.gson.internal.bind.TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public com.google.gson.JsonElement serialize(java.lang.Object obj, java.lang.reflect.Type type) {
            return com.google.gson.internal.bind.TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }
    }

    public static final class SingleTypeFactory implements com.google.gson.TypeAdapterFactory {
        private final com.google.gson.JsonDeserializer<?> deserializer;
        private final com.google.gson.reflect.TypeToken<?> exactType;
        private final java.lang.Class<?> hierarchyType;
        private final boolean matchRawType;
        private final com.google.gson.JsonSerializer<?> serializer;

        public SingleTypeFactory(java.lang.Object obj, com.google.gson.reflect.TypeToken<?> typeToken, boolean z, java.lang.Class<?> cls) {
            com.google.gson.JsonSerializer<?> jsonSerializer = obj instanceof com.google.gson.JsonSerializer ? (com.google.gson.JsonSerializer) obj : null;
            this.serializer = jsonSerializer;
            com.google.gson.JsonDeserializer<?> jsonDeserializer = obj instanceof com.google.gson.JsonDeserializer ? (com.google.gson.JsonDeserializer) obj : null;
            this.deserializer = jsonDeserializer;
            com.google.gson.internal.C$Gson$Preconditions.checkArgument((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.exactType = typeToken;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            com.google.gson.reflect.TypeToken<?> typeToken2 = this.exactType;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType()) : this.hierarchyType.isAssignableFrom(typeToken.getRawType())) {
                return new com.google.gson.internal.bind.TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(com.google.gson.JsonSerializer<T> jsonSerializer, com.google.gson.JsonDeserializer<T> jsonDeserializer, com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken, com.google.gson.TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    private com.google.gson.TypeAdapter<T> delegate() {
        com.google.gson.TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        com.google.gson.TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static com.google.gson.TypeAdapterFactory newFactory(com.google.gson.reflect.TypeToken<?> typeToken, java.lang.Object obj) {
        return new com.google.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory(obj, typeToken, false, null);
    }

    public static com.google.gson.TypeAdapterFactory newFactoryWithMatchRawType(com.google.gson.reflect.TypeToken<?> typeToken, java.lang.Object obj) {
        return new com.google.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static com.google.gson.TypeAdapterFactory newTypeHierarchyFactory(java.lang.Class<?> cls, java.lang.Object obj) {
        return new com.google.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory(obj, null, false, cls);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (this.deserializer == null) {
            return delegate().read2(jsonReader);
        }
        com.google.gson.JsonElement parse = com.google.gson.internal.Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
        com.google.gson.JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            com.google.gson.internal.Streams.write(jsonSerializer.serialize(t, this.typeToken.getType(), this.context), jsonWriter);
        }
    }
}
