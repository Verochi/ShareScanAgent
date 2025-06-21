package com.google.gson.internal;

/* loaded from: classes22.dex */
public final class Excluder implements com.google.gson.TypeAdapterFactory, java.lang.Cloneable {
    public static final com.google.gson.internal.Excluder DEFAULT = new com.google.gson.internal.Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = -1.0d;
    private int modifiers = com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME;
    private boolean serializeInnerClasses = true;
    private java.util.List<com.google.gson.ExclusionStrategy> serializationStrategies = java.util.Collections.emptyList();
    private java.util.List<com.google.gson.ExclusionStrategy> deserializationStrategies = java.util.Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.Excluder$1, reason: invalid class name */
    public class AnonymousClass1<T> extends com.google.gson.TypeAdapter<T> {
        private com.google.gson.TypeAdapter<T> delegate;
        final /* synthetic */ com.google.gson.Gson val$gson;
        final /* synthetic */ boolean val$skipDeserialize;
        final /* synthetic */ boolean val$skipSerialize;
        final /* synthetic */ com.google.gson.reflect.TypeToken val$type;

        public AnonymousClass1(boolean z, boolean z2, com.google.gson.Gson gson, com.google.gson.reflect.TypeToken typeToken) {
            this.val$skipDeserialize = z;
            this.val$skipSerialize = z2;
            this.val$gson = gson;
            this.val$type = typeToken;
        }

        private com.google.gson.TypeAdapter<T> delegate() {
            com.google.gson.TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            com.google.gson.TypeAdapter<T> delegateAdapter = this.val$gson.getDelegateAdapter(com.google.gson.internal.Excluder.this, this.val$type);
            this.delegate = delegateAdapter;
            return delegateAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (!this.val$skipDeserialize) {
                return delegate().read2(jsonReader);
            }
            jsonReader.skipValue();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            if (this.val$skipSerialize) {
                jsonWriter.nullValue();
            } else {
                delegate().write(jsonWriter, t);
            }
        }
    }

    private boolean excludeClassChecks(java.lang.Class<?> cls) {
        if (this.version == -1.0d || isValidVersion((com.google.gson.annotations.Since) cls.getAnnotation(com.google.gson.annotations.Since.class), (com.google.gson.annotations.Until) cls.getAnnotation(com.google.gson.annotations.Until.class))) {
            return (!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls);
        }
        return true;
    }

    private boolean excludeClassInStrategy(java.lang.Class<?> cls, boolean z) {
        java.util.Iterator<com.google.gson.ExclusionStrategy> it = (z ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(java.lang.Class<?> cls) {
        return !java.lang.Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean isInnerClass(java.lang.Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(java.lang.Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidSince(com.google.gson.annotations.Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(com.google.gson.annotations.Until until) {
        return until == null || until.value() > this.version;
    }

    private boolean isValidVersion(com.google.gson.annotations.Since since, com.google.gson.annotations.Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.google.gson.internal.Excluder m48clone() {
        try {
            return (com.google.gson.internal.Excluder) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        boolean z = excludeClassChecks || excludeClassInStrategy(rawType, true);
        boolean z2 = excludeClassChecks || excludeClassInStrategy(rawType, false);
        if (z || z2) {
            return new com.google.gson.internal.Excluder.AnonymousClass1(z2, z, gson, typeToken);
        }
        return null;
    }

    public com.google.gson.internal.Excluder disableInnerClassSerialization() {
        com.google.gson.internal.Excluder m48clone = m48clone();
        m48clone.serializeInnerClasses = false;
        return m48clone;
    }

    public boolean excludeClass(java.lang.Class<?> cls, boolean z) {
        return excludeClassChecks(cls) || excludeClassInStrategy(cls, z);
    }

    public boolean excludeField(java.lang.reflect.Field field, boolean z) {
        com.google.gson.annotations.Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != -1.0d && !isValidVersion((com.google.gson.annotations.Since) field.getAnnotation(com.google.gson.annotations.Since.class), (com.google.gson.annotations.Until) field.getAnnotation(com.google.gson.annotations.Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (com.google.gson.annotations.Expose) field.getAnnotation(com.google.gson.annotations.Expose.class)) == null || (!z ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        java.util.List<com.google.gson.ExclusionStrategy> list = z ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.FieldAttributes fieldAttributes = new com.google.gson.FieldAttributes(field);
        java.util.Iterator<com.google.gson.ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public com.google.gson.internal.Excluder excludeFieldsWithoutExposeAnnotation() {
        com.google.gson.internal.Excluder m48clone = m48clone();
        m48clone.requireExpose = true;
        return m48clone;
    }

    public com.google.gson.internal.Excluder withExclusionStrategy(com.google.gson.ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        com.google.gson.internal.Excluder m48clone = m48clone();
        if (z) {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.serializationStrategies);
            m48clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList(this.deserializationStrategies);
            m48clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return m48clone;
    }

    public com.google.gson.internal.Excluder withModifiers(int... iArr) {
        com.google.gson.internal.Excluder m48clone = m48clone();
        m48clone.modifiers = 0;
        for (int i : iArr) {
            m48clone.modifiers = i | m48clone.modifiers;
        }
        return m48clone;
    }

    public com.google.gson.internal.Excluder withVersion(double d) {
        com.google.gson.internal.Excluder m48clone = m48clone();
        m48clone.version = d;
        return m48clone;
    }
}
