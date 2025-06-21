package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes22.dex */
public abstract class LongSerializationPolicy {
    private static final /* synthetic */ com.google.gson.LongSerializationPolicy[] $VALUES;
    public static final com.google.gson.LongSerializationPolicy DEFAULT;
    public static final com.google.gson.LongSerializationPolicy STRING;

    /* renamed from: com.google.gson.LongSerializationPolicy$1, reason: invalid class name */
    public enum AnonymousClass1 extends com.google.gson.LongSerializationPolicy {
        public AnonymousClass1(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.LongSerializationPolicy
        public com.google.gson.JsonElement serialize(java.lang.Long l) {
            return new com.google.gson.JsonPrimitive(l);
        }
    }

    /* renamed from: com.google.gson.LongSerializationPolicy$2, reason: invalid class name */
    public enum AnonymousClass2 extends com.google.gson.LongSerializationPolicy {
        public AnonymousClass2(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.LongSerializationPolicy
        public com.google.gson.JsonElement serialize(java.lang.Long l) {
            return new com.google.gson.JsonPrimitive(java.lang.String.valueOf(l));
        }
    }

    static {
        com.google.gson.LongSerializationPolicy.AnonymousClass1 anonymousClass1 = new com.google.gson.LongSerializationPolicy.AnonymousClass1("DEFAULT", 0);
        DEFAULT = anonymousClass1;
        com.google.gson.LongSerializationPolicy.AnonymousClass2 anonymousClass2 = new com.google.gson.LongSerializationPolicy.AnonymousClass2("STRING", 1);
        STRING = anonymousClass2;
        $VALUES = new com.google.gson.LongSerializationPolicy[]{anonymousClass1, anonymousClass2};
    }

    private LongSerializationPolicy(java.lang.String str, int i) {
    }

    public /* synthetic */ LongSerializationPolicy(java.lang.String str, int i, com.google.gson.LongSerializationPolicy.AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static com.google.gson.LongSerializationPolicy valueOf(java.lang.String str) {
        return (com.google.gson.LongSerializationPolicy) java.lang.Enum.valueOf(com.google.gson.LongSerializationPolicy.class, str);
    }

    public static com.google.gson.LongSerializationPolicy[] values() {
        return (com.google.gson.LongSerializationPolicy[]) $VALUES.clone();
    }

    public abstract com.google.gson.JsonElement serialize(java.lang.Long l);
}
