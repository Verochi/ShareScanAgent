package com.google.common.base;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class CaseFormat {
    private static final /* synthetic */ com.google.common.base.CaseFormat[] $VALUES;
    public static final com.google.common.base.CaseFormat LOWER_CAMEL;
    public static final com.google.common.base.CaseFormat LOWER_HYPHEN;
    public static final com.google.common.base.CaseFormat LOWER_UNDERSCORE;
    public static final com.google.common.base.CaseFormat UPPER_CAMEL;
    public static final com.google.common.base.CaseFormat UPPER_UNDERSCORE;
    private final com.google.common.base.CharMatcher wordBoundary;
    private final java.lang.String wordSeparator;

    /* renamed from: com.google.common.base.CaseFormat$1, reason: invalid class name */
    public enum AnonymousClass1 extends com.google.common.base.CaseFormat {
        public AnonymousClass1(java.lang.String str, int i, com.google.common.base.CharMatcher charMatcher, java.lang.String str2) {
            super(str, i, charMatcher, str2, null);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String convert(com.google.common.base.CaseFormat caseFormat, java.lang.String str) {
            return caseFormat == com.google.common.base.CaseFormat.LOWER_UNDERSCORE ? str.replace('-', '_') : caseFormat == com.google.common.base.CaseFormat.UPPER_UNDERSCORE ? com.google.common.base.Ascii.toUpperCase(str.replace('-', '_')) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String normalizeWord(java.lang.String str) {
            return com.google.common.base.Ascii.toLowerCase(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$2, reason: invalid class name */
    public enum AnonymousClass2 extends com.google.common.base.CaseFormat {
        public AnonymousClass2(java.lang.String str, int i, com.google.common.base.CharMatcher charMatcher, java.lang.String str2) {
            super(str, i, charMatcher, str2, null);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String convert(com.google.common.base.CaseFormat caseFormat, java.lang.String str) {
            return caseFormat == com.google.common.base.CaseFormat.LOWER_HYPHEN ? str.replace('_', '-') : caseFormat == com.google.common.base.CaseFormat.UPPER_UNDERSCORE ? com.google.common.base.Ascii.toUpperCase(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String normalizeWord(java.lang.String str) {
            return com.google.common.base.Ascii.toLowerCase(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$3, reason: invalid class name */
    public enum AnonymousClass3 extends com.google.common.base.CaseFormat {
        public AnonymousClass3(java.lang.String str, int i, com.google.common.base.CharMatcher charMatcher, java.lang.String str2) {
            super(str, i, charMatcher, str2, null);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String normalizeWord(java.lang.String str) {
            return com.google.common.base.CaseFormat.firstCharOnlyToUpper(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$4, reason: invalid class name */
    public enum AnonymousClass4 extends com.google.common.base.CaseFormat {
        public AnonymousClass4(java.lang.String str, int i, com.google.common.base.CharMatcher charMatcher, java.lang.String str2) {
            super(str, i, charMatcher, str2, null);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String normalizeWord(java.lang.String str) {
            return com.google.common.base.CaseFormat.firstCharOnlyToUpper(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$5, reason: invalid class name */
    public enum AnonymousClass5 extends com.google.common.base.CaseFormat {
        public AnonymousClass5(java.lang.String str, int i, com.google.common.base.CharMatcher charMatcher, java.lang.String str2) {
            super(str, i, charMatcher, str2, null);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String convert(com.google.common.base.CaseFormat caseFormat, java.lang.String str) {
            return caseFormat == com.google.common.base.CaseFormat.LOWER_HYPHEN ? com.google.common.base.Ascii.toLowerCase(str.replace('_', '-')) : caseFormat == com.google.common.base.CaseFormat.LOWER_UNDERSCORE ? com.google.common.base.Ascii.toLowerCase(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public java.lang.String normalizeWord(java.lang.String str) {
            return com.google.common.base.Ascii.toUpperCase(str);
        }
    }

    public static final class StringConverter extends com.google.common.base.Converter<java.lang.String, java.lang.String> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.CaseFormat sourceFormat;
        private final com.google.common.base.CaseFormat targetFormat;

        public StringConverter(com.google.common.base.CaseFormat caseFormat, com.google.common.base.CaseFormat caseFormat2) {
            this.sourceFormat = (com.google.common.base.CaseFormat) com.google.common.base.Preconditions.checkNotNull(caseFormat);
            this.targetFormat = (com.google.common.base.CaseFormat) com.google.common.base.Preconditions.checkNotNull(caseFormat2);
        }

        @Override // com.google.common.base.Converter
        public java.lang.String doBackward(java.lang.String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        @Override // com.google.common.base.Converter
        public java.lang.String doForward(java.lang.String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.CaseFormat.StringConverter)) {
                return false;
            }
            com.google.common.base.CaseFormat.StringConverter stringConverter = (com.google.common.base.CaseFormat.StringConverter) obj;
            return this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat);
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public java.lang.String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }
    }

    static {
        com.google.common.base.CaseFormat.AnonymousClass1 anonymousClass1 = new com.google.common.base.CaseFormat.AnonymousClass1("LOWER_HYPHEN", 0, com.google.common.base.CharMatcher.is('-'), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        LOWER_HYPHEN = anonymousClass1;
        com.google.common.base.CaseFormat.AnonymousClass2 anonymousClass2 = new com.google.common.base.CaseFormat.AnonymousClass2("LOWER_UNDERSCORE", 1, com.google.common.base.CharMatcher.is('_'), "_");
        LOWER_UNDERSCORE = anonymousClass2;
        com.google.common.base.CaseFormat.AnonymousClass3 anonymousClass3 = new com.google.common.base.CaseFormat.AnonymousClass3("LOWER_CAMEL", 2, com.google.common.base.CharMatcher.inRange('A', 'Z'), "");
        LOWER_CAMEL = anonymousClass3;
        com.google.common.base.CaseFormat.AnonymousClass4 anonymousClass4 = new com.google.common.base.CaseFormat.AnonymousClass4("UPPER_CAMEL", 3, com.google.common.base.CharMatcher.inRange('A', 'Z'), "");
        UPPER_CAMEL = anonymousClass4;
        com.google.common.base.CaseFormat.AnonymousClass5 anonymousClass5 = new com.google.common.base.CaseFormat.AnonymousClass5("UPPER_UNDERSCORE", 4, com.google.common.base.CharMatcher.is('_'), "_");
        UPPER_UNDERSCORE = anonymousClass5;
        $VALUES = new com.google.common.base.CaseFormat[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5};
    }

    private CaseFormat(java.lang.String str, int i, com.google.common.base.CharMatcher charMatcher, java.lang.String str2) {
        this.wordBoundary = charMatcher;
        this.wordSeparator = str2;
    }

    public /* synthetic */ CaseFormat(java.lang.String str, int i, com.google.common.base.CharMatcher charMatcher, java.lang.String str2, com.google.common.base.CaseFormat.AnonymousClass1 anonymousClass1) {
        this(str, i, charMatcher, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String firstCharOnlyToUpper(java.lang.String str) {
        if (str.isEmpty()) {
            return str;
        }
        return com.google.common.base.Ascii.toUpperCase(str.charAt(0)) + com.google.common.base.Ascii.toLowerCase(str.substring(1));
    }

    private java.lang.String normalizeFirstWord(java.lang.String str) {
        return this == LOWER_CAMEL ? com.google.common.base.Ascii.toLowerCase(str) : normalizeWord(str);
    }

    public static com.google.common.base.CaseFormat valueOf(java.lang.String str) {
        return (com.google.common.base.CaseFormat) java.lang.Enum.valueOf(com.google.common.base.CaseFormat.class, str);
    }

    public static com.google.common.base.CaseFormat[] values() {
        return (com.google.common.base.CaseFormat[]) $VALUES.clone();
    }

    public java.lang.String convert(com.google.common.base.CaseFormat caseFormat, java.lang.String str) {
        java.lang.StringBuilder sb = null;
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.wordBoundary.indexIn(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new java.lang.StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                sb.append(caseFormat.normalizeFirstWord(str.substring(i, i2)));
            } else {
                sb.append(caseFormat.normalizeWord(str.substring(i, i2)));
            }
            sb.append(caseFormat.wordSeparator);
            i = this.wordSeparator.length() + i2;
        }
        if (i == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        sb.append(caseFormat.normalizeWord(str.substring(i)));
        return sb.toString();
    }

    public com.google.common.base.Converter<java.lang.String, java.lang.String> converterTo(com.google.common.base.CaseFormat caseFormat) {
        return new com.google.common.base.CaseFormat.StringConverter(this, caseFormat);
    }

    public abstract java.lang.String normalizeWord(java.lang.String str);

    public final java.lang.String to(com.google.common.base.CaseFormat caseFormat, java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(caseFormat);
        com.google.common.base.Preconditions.checkNotNull(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }
}
