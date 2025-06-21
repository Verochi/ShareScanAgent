package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class ReflectiveTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    private final com.google.gson.internal.reflect.ReflectionAccessor accessor = com.google.gson.internal.reflect.ReflectionAccessor.getInstance();
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;
    private final com.google.gson.internal.Excluder excluder;
    private final com.google.gson.FieldNamingStrategy fieldNamingPolicy;
    private final com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField {
        final /* synthetic */ com.google.gson.Gson val$context;
        final /* synthetic */ java.lang.reflect.Field val$field;
        final /* synthetic */ com.google.gson.reflect.TypeToken val$fieldType;
        final /* synthetic */ boolean val$isPrimitive;
        final /* synthetic */ boolean val$jsonAdapterPresent;
        final /* synthetic */ com.google.gson.TypeAdapter val$typeAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, boolean z, boolean z2, java.lang.reflect.Field field, boolean z3, com.google.gson.TypeAdapter typeAdapter, com.google.gson.Gson gson, com.google.gson.reflect.TypeToken typeToken, boolean z4) {
            super(str, z, z2);
            this.val$field = field;
            this.val$jsonAdapterPresent = z3;
            this.val$typeAdapter = typeAdapter;
            this.val$context = gson;
            this.val$fieldType = typeToken;
            this.val$isPrimitive = z4;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public void read(com.google.gson.stream.JsonReader jsonReader, java.lang.Object obj) throws java.io.IOException, java.lang.IllegalAccessException {
            java.lang.Object read2 = this.val$typeAdapter.read2(jsonReader);
            if (read2 == null && this.val$isPrimitive) {
                return;
            }
            this.val$field.set(obj, read2);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.io.IOException, java.lang.IllegalAccessException {
            (this.val$jsonAdapterPresent ? this.val$typeAdapter : new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(this.val$context, this.val$typeAdapter, this.val$fieldType.getType())).write(jsonWriter, this.val$field.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public boolean writeField(java.lang.Object obj) throws java.io.IOException, java.lang.IllegalAccessException {
            return this.serialized && this.val$field.get(obj) != obj;
        }
    }

    public static final class Adapter<T> extends com.google.gson.TypeAdapter<T> {
        private final java.util.Map<java.lang.String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> boundFields;
        private final com.google.gson.internal.ObjectConstructor<T> constructor;

        public Adapter(com.google.gson.internal.ObjectConstructor<T> objectConstructor, java.util.Map<java.lang.String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null && boundField.deserialized) {
                        boundField.read(jsonReader, construct);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            } catch (java.lang.IllegalStateException e2) {
                throw new com.google.gson.JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public static abstract class BoundField {
        final boolean deserialized;
        final java.lang.String name;
        final boolean serialized;

        public BoundField(java.lang.String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }

        public abstract void read(com.google.gson.stream.JsonReader jsonReader, java.lang.Object obj) throws java.io.IOException, java.lang.IllegalAccessException;

        public abstract void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.io.IOException, java.lang.IllegalAccessException;

        public abstract boolean writeField(java.lang.Object obj) throws java.io.IOException, java.lang.IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor, com.google.gson.FieldNamingStrategy fieldNamingStrategy, com.google.gson.internal.Excluder excluder, com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField createBoundField(com.google.gson.Gson gson, java.lang.reflect.Field field, java.lang.String str, com.google.gson.reflect.TypeToken<?> typeToken, boolean z, boolean z2) {
        boolean isPrimitive = com.google.gson.internal.Primitives.isPrimitive(typeToken.getRawType());
        com.google.gson.annotations.JsonAdapter jsonAdapter = (com.google.gson.annotations.JsonAdapter) field.getAnnotation(com.google.gson.annotations.JsonAdapter.class);
        com.google.gson.TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.AnonymousClass1(str, z, z2, field, z3, typeAdapter, gson, typeToken, isPrimitive);
    }

    public static boolean excludeField(java.lang.reflect.Field field, boolean z, com.google.gson.internal.Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    private java.util.Map<java.lang.String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> getBoundFields(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<?> typeToken, java.lang.Class<?> cls) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        java.lang.reflect.Type type = typeToken.getType();
        com.google.gson.reflect.TypeToken<?> typeToken2 = typeToken;
        java.lang.Class<?> cls2 = cls;
        while (cls2 != java.lang.Object.class) {
            java.lang.reflect.Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                java.lang.reflect.Field field = declaredFields[i];
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, z);
                if (excludeField || excludeField2) {
                    this.accessor.makeAccessible(field);
                    java.lang.reflect.Type resolve = com.google.gson.internal.C$Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType());
                    java.util.List<java.lang.String> fieldNames = getFieldNames(field);
                    int size = fieldNames.size();
                    com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField = null;
                    int i2 = 0;
                    while (i2 < size) {
                        java.lang.String str = fieldNames.get(i2);
                        boolean z2 = i2 != 0 ? false : excludeField;
                        int i3 = i2;
                        com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField2 = boundField;
                        int i4 = size;
                        java.util.List<java.lang.String> list = fieldNames;
                        java.lang.reflect.Field field2 = field;
                        boundField = boundField2 == null ? (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, com.google.gson.reflect.TypeToken.get(resolve), z2, excludeField2)) : boundField2;
                        i2 = i3 + 1;
                        excludeField = z2;
                        fieldNames = list;
                        size = i4;
                        field = field2;
                    }
                    com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField3 = boundField;
                    if (boundField3 != null) {
                        throw new java.lang.IllegalArgumentException(type + " declares multiple JSON fields named " + boundField3.name);
                    }
                }
                i++;
                z = false;
            }
            typeToken2 = com.google.gson.reflect.TypeToken.get(com.google.gson.internal.C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    private java.util.List<java.lang.String> getFieldNames(java.lang.reflect.Field field) {
        com.google.gson.annotations.SerializedName serializedName = (com.google.gson.annotations.SerializedName) field.getAnnotation(com.google.gson.annotations.SerializedName.class);
        if (serializedName == null) {
            return java.util.Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        java.lang.String value = serializedName.value();
        java.lang.String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return java.util.Collections.singletonList(value);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (java.lang.String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        if (java.lang.Object.class.isAssignableFrom(rawType)) {
            return new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    public boolean excludeField(java.lang.reflect.Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }
}
