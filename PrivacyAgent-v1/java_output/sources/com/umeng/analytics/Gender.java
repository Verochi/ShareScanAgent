package com.umeng.analytics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes19.dex */
public class Gender {
    public static final com.umeng.analytics.Gender Female;
    public static final com.umeng.analytics.Gender Male;
    public static final com.umeng.analytics.Gender Unknown;
    private static final /* synthetic */ com.umeng.analytics.Gender[] a;
    public int value;

    /* renamed from: com.umeng.analytics.Gender$1, reason: invalid class name */
    public enum AnonymousClass1 extends com.umeng.analytics.Gender {
        public AnonymousClass1(java.lang.String str, int i, int i2) {
            super(str, i, i2, null);
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return java.lang.String.format(java.util.Locale.US, "Male:%d", java.lang.Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$2, reason: invalid class name */
    public enum AnonymousClass2 extends com.umeng.analytics.Gender {
        public AnonymousClass2(java.lang.String str, int i, int i2) {
            super(str, i, i2, null);
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return java.lang.String.format(java.util.Locale.US, "Female:%d", java.lang.Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$3, reason: invalid class name */
    public enum AnonymousClass3 extends com.umeng.analytics.Gender {
        public AnonymousClass3(java.lang.String str, int i, int i2) {
            super(str, i, i2, null);
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return java.lang.String.format(java.util.Locale.US, "Unknown:%d", java.lang.Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.umeng.analytics.Gender.values().length];
            a = iArr;
            try {
                iArr[com.umeng.analytics.Gender.Male.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.umeng.analytics.Gender.Female.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.umeng.analytics.Gender.Unknown.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    static {
        com.umeng.analytics.Gender.AnonymousClass1 anonymousClass1 = new com.umeng.analytics.Gender.AnonymousClass1("Male", 0, 1);
        Male = anonymousClass1;
        com.umeng.analytics.Gender.AnonymousClass2 anonymousClass2 = new com.umeng.analytics.Gender.AnonymousClass2("Female", 1, 2);
        Female = anonymousClass2;
        com.umeng.analytics.Gender.AnonymousClass3 anonymousClass3 = new com.umeng.analytics.Gender.AnonymousClass3("Unknown", 2, 0);
        Unknown = anonymousClass3;
        a = new com.umeng.analytics.Gender[]{anonymousClass1, anonymousClass2, anonymousClass3};
    }

    private Gender(java.lang.String str, int i, int i2) {
        this.value = i2;
    }

    public /* synthetic */ Gender(java.lang.String str, int i, int i2, com.umeng.analytics.Gender.AnonymousClass1 anonymousClass1) {
        this(str, i, i2);
    }

    public static com.umeng.analytics.Gender getGender(int i) {
        return i != 1 ? i != 2 ? Unknown : Female : Male;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender transGender(com.umeng.analytics.Gender gender) {
        int i = com.umeng.analytics.Gender.AnonymousClass4.a[gender.ordinal()];
        return i != 1 ? i != 2 ? com.umeng.commonsdk.statistics.proto.Gender.UNKNOWN : com.umeng.commonsdk.statistics.proto.Gender.FEMALE : com.umeng.commonsdk.statistics.proto.Gender.MALE;
    }

    public static com.umeng.analytics.Gender valueOf(java.lang.String str) {
        return (com.umeng.analytics.Gender) java.lang.Enum.valueOf(com.umeng.analytics.Gender.class, str);
    }

    public static com.umeng.analytics.Gender[] values() {
        return (com.umeng.analytics.Gender[]) a.clone();
    }

    public int value() {
        return this.value;
    }
}
