package com.google.gson;

/* loaded from: classes22.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final java.lang.String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final com.google.gson.reflect.TypeToken<?> NULL_KEY_SURROGATE = com.google.gson.reflect.TypeToken.get(java.lang.Object.class);
    final java.util.List<com.google.gson.TypeAdapterFactory> builderFactories;
    final java.util.List<com.google.gson.TypeAdapterFactory> builderHierarchyFactories;
    private final java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson.FutureTypeAdapter<?>>> calls;
    final boolean complexMapKeySerialization;
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;
    final java.lang.String datePattern;
    final int dateStyle;
    final com.google.gson.internal.Excluder excluder;
    final java.util.List<com.google.gson.TypeAdapterFactory> factories;
    final com.google.gson.FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> instanceCreators;
    private final com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final com.google.gson.LongSerializationPolicy longSerializationPolicy;
    final boolean prettyPrinting;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final int timeStyle;
    private final java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>> typeTokenCache;

    /* renamed from: com.google.gson.Gson$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.gson.TypeAdapter<java.lang.Number> {
        public AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: merged with bridge method [inline-methods] */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.lang.Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                com.google.gson.Gson.checkValidFloatingPoint(number.doubleValue());
                jsonWriter.value(number);
            }
        }
    }

    /* renamed from: com.google.gson.Gson$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.gson.TypeAdapter<java.lang.Number> {
        public AnonymousClass2() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.lang.Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                com.google.gson.Gson.checkValidFloatingPoint(number.floatValue());
                jsonWriter.value(number);
            }
        }
    }

    /* renamed from: com.google.gson.Gson$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.lang.Long.valueOf(jsonReader.nextLong());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    /* renamed from: com.google.gson.Gson$4, reason: invalid class name */
    public class AnonymousClass4 extends com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLong> {
        final /* synthetic */ com.google.gson.TypeAdapter val$longAdapter;

        public AnonymousClass4(com.google.gson.TypeAdapter typeAdapter) {
            this.val$longAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.concurrent.atomic.AtomicLong read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            return new java.util.concurrent.atomic.AtomicLong(((java.lang.Number) this.val$longAdapter.read2(jsonReader)).longValue());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicLong atomicLong) throws java.io.IOException {
            this.val$longAdapter.write(jsonWriter, java.lang.Long.valueOf(atomicLong.get()));
        }
    }

    /* renamed from: com.google.gson.Gson$5, reason: invalid class name */
    public class AnonymousClass5 extends com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLongArray> {
        final /* synthetic */ com.google.gson.TypeAdapter val$longAdapter;

        public AnonymousClass5(com.google.gson.TypeAdapter typeAdapter) {
            this.val$longAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.concurrent.atomic.AtomicLongArray read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(java.lang.Long.valueOf(((java.lang.Number) this.val$longAdapter.read2(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            java.util.concurrent.atomic.AtomicLongArray atomicLongArray = new java.util.concurrent.atomic.AtomicLongArray(size);
            for (int i = 0; i < size; i++) {
                atomicLongArray.set(i, ((java.lang.Long) arrayList.get(i)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicLongArray atomicLongArray) throws java.io.IOException {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i = 0; i < length; i++) {
                this.val$longAdapter.write(jsonWriter, java.lang.Long.valueOf(atomicLongArray.get(i)));
            }
            jsonWriter.endArray();
        }
    }

    public static class FutureTypeAdapter<T> extends com.google.gson.TypeAdapter<T> {
        private com.google.gson.TypeAdapter<T> delegate;

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read2(jsonReader);
            }
            throw new java.lang.IllegalStateException();
        }

        public void setDelegate(com.google.gson.TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new java.lang.AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            com.google.gson.TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new java.lang.IllegalStateException();
            }
            typeAdapter.write(jsonWriter, t);
        }
    }

    public Gson() {
        this(com.google.gson.internal.Excluder.DEFAULT, com.google.gson.FieldNamingPolicy.IDENTITY, java.util.Collections.emptyMap(), false, false, false, true, false, false, false, com.google.gson.LongSerializationPolicy.DEFAULT, null, 2, 2, java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList());
    }

    public Gson(com.google.gson.internal.Excluder excluder, com.google.gson.FieldNamingStrategy fieldNamingStrategy, java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, com.google.gson.LongSerializationPolicy longSerializationPolicy, java.lang.String str, int i, int i2, java.util.List<com.google.gson.TypeAdapterFactory> list, java.util.List<com.google.gson.TypeAdapterFactory> list2, java.util.List<com.google.gson.TypeAdapterFactory> list3) {
        this.calls = new java.lang.ThreadLocal<>();
        this.typeTokenCache = new java.util.concurrent.ConcurrentHashMap();
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.instanceCreators = map;
        com.google.gson.internal.ConstructorConstructor constructorConstructor = new com.google.gson.internal.ConstructorConstructor(map);
        this.constructorConstructor = constructorConstructor;
        this.serializeNulls = z;
        this.complexMapKeySerialization = z2;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        this.lenient = z6;
        this.serializeSpecialFloatingPointValues = z7;
        this.longSerializationPolicy = longSerializationPolicy;
        this.datePattern = str;
        this.dateStyle = i;
        this.timeStyle = i2;
        this.builderFactories = list;
        this.builderHierarchyFactories = list2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(com.google.gson.internal.bind.ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.STRING_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.INTEGER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.BYTE_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.SHORT_FACTORY);
        com.google.gson.TypeAdapter<java.lang.Number> longAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.lang.Long.TYPE, java.lang.Long.class, longAdapter));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.lang.Double.TYPE, java.lang.Double.class, doubleAdapter(z7)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.lang.Float.TYPE, java.lang.Float.class, floatAdapter(z7)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.NUMBER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.util.concurrent.atomic.AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.util.concurrent.atomic.AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.math.BigDecimal.class, com.google.gson.internal.bind.TypeAdapters.BIG_DECIMAL));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.math.BigInteger.class, com.google.gson.internal.bind.TypeAdapters.BIG_INTEGER));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.URL_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.URI_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.UUID_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.LOCALE_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(com.google.gson.internal.bind.DateTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CALENDAR_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TimeTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.SqlDateTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.TIMESTAMP_FACTORY);
        arrayList.add(com.google.gson.internal.bind.ArrayTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CLASS_FACTORY);
        arrayList.add(new com.google.gson.internal.bind.CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new com.google.gson.internal.bind.MapTypeAdapterFactory(constructorConstructor, z2));
        com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ENUM_FACTORY);
        arrayList.add(new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.factories = java.util.Collections.unmodifiableList(arrayList);
    }

    private static void assertFullConsumption(java.lang.Object obj, com.google.gson.stream.JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == com.google.gson.stream.JsonToken.END_DOCUMENT) {
                } else {
                    throw new com.google.gson.JsonIOException("JSON document was not fully consumed.");
                }
            } catch (com.google.gson.stream.MalformedJsonException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            } catch (java.io.IOException e2) {
                throw new com.google.gson.JsonIOException(e2);
            }
        }
    }

    private static com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLong> atomicLongAdapter(com.google.gson.TypeAdapter<java.lang.Number> typeAdapter) {
        return new com.google.gson.Gson.AnonymousClass4(typeAdapter).nullSafe();
    }

    private static com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLongArray> atomicLongArrayAdapter(com.google.gson.TypeAdapter<java.lang.Number> typeAdapter) {
        return new com.google.gson.Gson.AnonymousClass5(typeAdapter).nullSafe();
    }

    public static void checkValidFloatingPoint(double d) {
        if (java.lang.Double.isNaN(d) || java.lang.Double.isInfinite(d)) {
            throw new java.lang.IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private com.google.gson.TypeAdapter<java.lang.Number> doubleAdapter(boolean z) {
        return z ? com.google.gson.internal.bind.TypeAdapters.DOUBLE : new com.google.gson.Gson.AnonymousClass1();
    }

    private com.google.gson.TypeAdapter<java.lang.Number> floatAdapter(boolean z) {
        return z ? com.google.gson.internal.bind.TypeAdapters.FLOAT : new com.google.gson.Gson.AnonymousClass2();
    }

    private static com.google.gson.TypeAdapter<java.lang.Number> longAdapter(com.google.gson.LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == com.google.gson.LongSerializationPolicy.DEFAULT ? com.google.gson.internal.bind.TypeAdapters.LONG : new com.google.gson.Gson.AnonymousClass3();
    }

    public com.google.gson.internal.Excluder excluder() {
        return this.excluder;
    }

    public com.google.gson.FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(com.google.gson.JsonElement jsonElement, java.lang.Class<T> cls) throws com.google.gson.JsonSyntaxException {
        return (T) com.google.gson.internal.Primitives.wrap(cls).cast(fromJson(jsonElement, (java.lang.reflect.Type) cls));
    }

    public <T> T fromJson(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws com.google.gson.JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new com.google.gson.internal.bind.JsonTreeReader(jsonElement), type);
    }

    public <T> T fromJson(com.google.gson.stream.JsonReader jsonReader, java.lang.reflect.Type type) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        boolean z = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z = false;
                    return getAdapter(com.google.gson.reflect.TypeToken.get(type)).read2(jsonReader);
                } catch (java.lang.AssertionError e) {
                    java.lang.AssertionError assertionError = new java.lang.AssertionError("AssertionError (GSON 2.8.6): " + e.getMessage());
                    assertionError.initCause(e);
                    throw assertionError;
                } catch (java.lang.IllegalStateException e2) {
                    throw new com.google.gson.JsonSyntaxException(e2);
                }
            } catch (java.io.EOFException e3) {
                if (!z) {
                    throw new com.google.gson.JsonSyntaxException(e3);
                }
                jsonReader.setLenient(isLenient);
                return null;
            } catch (java.io.IOException e4) {
                throw new com.google.gson.JsonSyntaxException(e4);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public <T> T fromJson(java.io.Reader reader, java.lang.Class<T> cls) throws com.google.gson.JsonSyntaxException, com.google.gson.JsonIOException {
        com.google.gson.stream.JsonReader newJsonReader = newJsonReader(reader);
        java.lang.Object fromJson = fromJson(newJsonReader, cls);
        assertFullConsumption(fromJson, newJsonReader);
        return (T) com.google.gson.internal.Primitives.wrap(cls).cast(fromJson);
    }

    public <T> T fromJson(java.io.Reader reader, java.lang.reflect.Type type) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        com.google.gson.stream.JsonReader newJsonReader = newJsonReader(reader);
        T t = (T) fromJson(newJsonReader, type);
        assertFullConsumption(t, newJsonReader);
        return t;
    }

    public <T> T fromJson(java.lang.String str, java.lang.Class<T> cls) throws com.google.gson.JsonSyntaxException {
        return (T) com.google.gson.internal.Primitives.wrap(cls).cast(fromJson(str, (java.lang.reflect.Type) cls));
    }

    public <T> T fromJson(java.lang.String str, java.lang.reflect.Type type) throws com.google.gson.JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new java.io.StringReader(str), type);
    }

    public <T> com.google.gson.TypeAdapter<T> getAdapter(com.google.gson.reflect.TypeToken<T> typeToken) {
        boolean z;
        com.google.gson.TypeAdapter<T> typeAdapter = (com.google.gson.TypeAdapter) this.typeTokenCache.get(typeToken == null ? NULL_KEY_SURROGATE : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson.FutureTypeAdapter<?>> map = this.calls.get();
        if (map == null) {
            map = new java.util.HashMap<>();
            this.calls.set(map);
            z = true;
        } else {
            z = false;
        }
        com.google.gson.Gson.FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            com.google.gson.Gson.FutureTypeAdapter<?> futureTypeAdapter2 = new com.google.gson.Gson.FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            java.util.Iterator<com.google.gson.TypeAdapterFactory> it = this.factories.iterator();
            while (it.hasNext()) {
                com.google.gson.TypeAdapter<T> create = it.next().create(this, typeToken);
                if (create != null) {
                    futureTypeAdapter2.setDelegate(create);
                    this.typeTokenCache.put(typeToken, create);
                    return create;
                }
            }
            throw new java.lang.IllegalArgumentException("GSON (2.8.6) cannot handle " + typeToken);
        } finally {
            map.remove(typeToken);
            if (z) {
                this.calls.remove();
            }
        }
    }

    public <T> com.google.gson.TypeAdapter<T> getAdapter(java.lang.Class<T> cls) {
        return getAdapter(com.google.gson.reflect.TypeToken.get((java.lang.Class) cls));
    }

    public <T> com.google.gson.TypeAdapter<T> getDelegateAdapter(com.google.gson.TypeAdapterFactory typeAdapterFactory, com.google.gson.reflect.TypeToken<T> typeToken) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (com.google.gson.TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z) {
                com.google.gson.TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        throw new java.lang.IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public com.google.gson.GsonBuilder newBuilder() {
        return new com.google.gson.GsonBuilder(this);
    }

    public com.google.gson.stream.JsonReader newJsonReader(java.io.Reader reader) {
        com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public com.google.gson.stream.JsonWriter newJsonWriter(java.io.Writer writer) throws java.io.IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        com.google.gson.stream.JsonWriter jsonWriter = new com.google.gson.stream.JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public java.lang.String toJson(com.google.gson.JsonElement jsonElement) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        toJson(jsonElement, (java.lang.Appendable) stringWriter);
        return stringWriter.toString();
    }

    public java.lang.String toJson(java.lang.Object obj) {
        return obj == null ? toJson((com.google.gson.JsonElement) com.google.gson.JsonNull.INSTANCE) : toJson(obj, obj.getClass());
    }

    public java.lang.String toJson(java.lang.Object obj, java.lang.reflect.Type type) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(com.google.gson.JsonElement jsonElement, com.google.gson.stream.JsonWriter jsonWriter) throws com.google.gson.JsonIOException {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                com.google.gson.internal.Streams.write(jsonElement, jsonWriter);
            } catch (java.io.IOException e) {
                throw new com.google.gson.JsonIOException(e);
            } catch (java.lang.AssertionError e2) {
                java.lang.AssertionError assertionError = new java.lang.AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void toJson(com.google.gson.JsonElement jsonElement, java.lang.Appendable appendable) throws com.google.gson.JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(com.google.gson.internal.Streams.writerForAppendable(appendable)));
        } catch (java.io.IOException e) {
            throw new com.google.gson.JsonIOException(e);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.Appendable appendable) throws com.google.gson.JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((com.google.gson.JsonElement) com.google.gson.JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.reflect.Type type, com.google.gson.stream.JsonWriter jsonWriter) throws com.google.gson.JsonIOException {
        com.google.gson.TypeAdapter adapter = getAdapter(com.google.gson.reflect.TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                adapter.write(jsonWriter, obj);
            } catch (java.io.IOException e) {
                throw new com.google.gson.JsonIOException(e);
            } catch (java.lang.AssertionError e2) {
                java.lang.AssertionError assertionError = new java.lang.AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.reflect.Type type, java.lang.Appendable appendable) throws com.google.gson.JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(com.google.gson.internal.Streams.writerForAppendable(appendable)));
        } catch (java.io.IOException e) {
            throw new com.google.gson.JsonIOException(e);
        }
    }

    public com.google.gson.JsonElement toJsonTree(java.lang.Object obj) {
        return obj == null ? com.google.gson.JsonNull.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public com.google.gson.JsonElement toJsonTree(java.lang.Object obj, java.lang.reflect.Type type) {
        com.google.gson.internal.bind.JsonTreeWriter jsonTreeWriter = new com.google.gson.internal.bind.JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public java.lang.String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + com.alipay.sdk.m.u.i.d;
    }
}
