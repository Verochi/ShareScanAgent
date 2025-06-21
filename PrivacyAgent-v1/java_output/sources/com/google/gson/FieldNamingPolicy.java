package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes22.dex */
public abstract class FieldNamingPolicy implements com.google.gson.FieldNamingStrategy {
    private static final /* synthetic */ com.google.gson.FieldNamingPolicy[] $VALUES;
    public static final com.google.gson.FieldNamingPolicy IDENTITY;
    public static final com.google.gson.FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final com.google.gson.FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final com.google.gson.FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final com.google.gson.FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final com.google.gson.FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    /* renamed from: com.google.gson.FieldNamingPolicy$1, reason: invalid class name */
    public enum AnonymousClass1 extends com.google.gson.FieldNamingPolicy {
        public AnonymousClass1(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return field.getName();
        }
    }

    /* renamed from: com.google.gson.FieldNamingPolicy$2, reason: invalid class name */
    public enum AnonymousClass2 extends com.google.gson.FieldNamingPolicy {
        public AnonymousClass2(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return com.google.gson.FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    }

    /* renamed from: com.google.gson.FieldNamingPolicy$3, reason: invalid class name */
    public enum AnonymousClass3 extends com.google.gson.FieldNamingPolicy {
        public AnonymousClass3(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return com.google.gson.FieldNamingPolicy.upperCaseFirstLetter(com.google.gson.FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    }

    /* renamed from: com.google.gson.FieldNamingPolicy$4, reason: invalid class name */
    public enum AnonymousClass4 extends com.google.gson.FieldNamingPolicy {
        public AnonymousClass4(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return com.google.gson.FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(java.util.Locale.ENGLISH);
        }
    }

    /* renamed from: com.google.gson.FieldNamingPolicy$5, reason: invalid class name */
    public enum AnonymousClass5 extends com.google.gson.FieldNamingPolicy {
        public AnonymousClass5(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return com.google.gson.FieldNamingPolicy.separateCamelCase(field.getName(), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase(java.util.Locale.ENGLISH);
        }
    }

    /* renamed from: com.google.gson.FieldNamingPolicy$6, reason: invalid class name */
    public enum AnonymousClass6 extends com.google.gson.FieldNamingPolicy {
        public AnonymousClass6(java.lang.String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return com.google.gson.FieldNamingPolicy.separateCamelCase(field.getName(), ".").toLowerCase(java.util.Locale.ENGLISH);
        }
    }

    static {
        com.google.gson.FieldNamingPolicy.AnonymousClass1 anonymousClass1 = new com.google.gson.FieldNamingPolicy.AnonymousClass1("IDENTITY", 0);
        IDENTITY = anonymousClass1;
        com.google.gson.FieldNamingPolicy.AnonymousClass2 anonymousClass2 = new com.google.gson.FieldNamingPolicy.AnonymousClass2("UPPER_CAMEL_CASE", 1);
        UPPER_CAMEL_CASE = anonymousClass2;
        com.google.gson.FieldNamingPolicy.AnonymousClass3 anonymousClass3 = new com.google.gson.FieldNamingPolicy.AnonymousClass3("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        UPPER_CAMEL_CASE_WITH_SPACES = anonymousClass3;
        com.google.gson.FieldNamingPolicy.AnonymousClass4 anonymousClass4 = new com.google.gson.FieldNamingPolicy.AnonymousClass4("LOWER_CASE_WITH_UNDERSCORES", 3);
        LOWER_CASE_WITH_UNDERSCORES = anonymousClass4;
        com.google.gson.FieldNamingPolicy.AnonymousClass5 anonymousClass5 = new com.google.gson.FieldNamingPolicy.AnonymousClass5("LOWER_CASE_WITH_DASHES", 4);
        LOWER_CASE_WITH_DASHES = anonymousClass5;
        com.google.gson.FieldNamingPolicy.AnonymousClass6 anonymousClass6 = new com.google.gson.FieldNamingPolicy.AnonymousClass6("LOWER_CASE_WITH_DOTS", 5);
        LOWER_CASE_WITH_DOTS = anonymousClass6;
        $VALUES = new com.google.gson.FieldNamingPolicy[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6};
    }

    private FieldNamingPolicy(java.lang.String str, int i) {
    }

    public /* synthetic */ FieldNamingPolicy(java.lang.String str, int i, com.google.gson.FieldNamingPolicy.AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static java.lang.String separateCamelCase(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (java.lang.Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static java.lang.String upperCaseFirstLetter(java.lang.String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!java.lang.Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char charAt = str.charAt(i);
        if (java.lang.Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = java.lang.Character.toUpperCase(charAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static com.google.gson.FieldNamingPolicy valueOf(java.lang.String str) {
        return (com.google.gson.FieldNamingPolicy) java.lang.Enum.valueOf(com.google.gson.FieldNamingPolicy.class, str);
    }

    public static com.google.gson.FieldNamingPolicy[] values() {
        return (com.google.gson.FieldNamingPolicy[]) $VALUES.clone();
    }
}
