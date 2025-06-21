package com.google.common.cache;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class RemovalCause {
    private static final /* synthetic */ com.google.common.cache.RemovalCause[] $VALUES;
    public static final com.google.common.cache.RemovalCause COLLECTED;
    public static final com.google.common.cache.RemovalCause EXPIRED;
    public static final com.google.common.cache.RemovalCause EXPLICIT;
    public static final com.google.common.cache.RemovalCause REPLACED;
    public static final com.google.common.cache.RemovalCause SIZE;

    /* renamed from: com.google.common.cache.RemovalCause$1, reason: invalid class name */
    public enum AnonymousClass1 extends com.google.common.cache.RemovalCause {
        public AnonymousClass1(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$2, reason: invalid class name */
    public enum AnonymousClass2 extends com.google.common.cache.RemovalCause {
        public AnonymousClass2(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$3, reason: invalid class name */
    public enum AnonymousClass3 extends com.google.common.cache.RemovalCause {
        public AnonymousClass3(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$4, reason: invalid class name */
    public enum AnonymousClass4 extends com.google.common.cache.RemovalCause {
        public AnonymousClass4(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$5, reason: invalid class name */
    public enum AnonymousClass5 extends com.google.common.cache.RemovalCause {
        public AnonymousClass5(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    }

    static {
        com.google.common.cache.RemovalCause.AnonymousClass1 anonymousClass1 = new com.google.common.cache.RemovalCause.AnonymousClass1("EXPLICIT", 0);
        EXPLICIT = anonymousClass1;
        com.google.common.cache.RemovalCause.AnonymousClass2 anonymousClass2 = new com.google.common.cache.RemovalCause.AnonymousClass2("REPLACED", 1);
        REPLACED = anonymousClass2;
        com.google.common.cache.RemovalCause.AnonymousClass3 anonymousClass3 = new com.google.common.cache.RemovalCause.AnonymousClass3("COLLECTED", 2);
        COLLECTED = anonymousClass3;
        com.google.common.cache.RemovalCause.AnonymousClass4 anonymousClass4 = new com.google.common.cache.RemovalCause.AnonymousClass4("EXPIRED", 3);
        EXPIRED = anonymousClass4;
        com.google.common.cache.RemovalCause.AnonymousClass5 anonymousClass5 = new com.google.common.cache.RemovalCause.AnonymousClass5("SIZE", 4);
        SIZE = anonymousClass5;
        $VALUES = new com.google.common.cache.RemovalCause[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5};
    }

    private RemovalCause(java.lang.String str, int i) {
    }

    public /* synthetic */ RemovalCause(java.lang.String str, int i, com.google.common.cache.RemovalCause.AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static com.google.common.cache.RemovalCause valueOf(java.lang.String str) {
        return (com.google.common.cache.RemovalCause) java.lang.Enum.valueOf(com.google.common.cache.RemovalCause.class, str);
    }

    public static com.google.common.cache.RemovalCause[] values() {
        return (com.google.common.cache.RemovalCause[]) $VALUES.clone();
    }

    public abstract boolean wasEvicted();
}
