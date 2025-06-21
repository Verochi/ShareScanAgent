package com.google.protobuf;

/* loaded from: classes22.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;
    static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT64' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class FieldType {
        private static final /* synthetic */ com.google.protobuf.WireFormat.FieldType[] $VALUES;
        public static final com.google.protobuf.WireFormat.FieldType BOOL;
        public static final com.google.protobuf.WireFormat.FieldType BYTES;
        public static final com.google.protobuf.WireFormat.FieldType DOUBLE;
        public static final com.google.protobuf.WireFormat.FieldType ENUM;
        public static final com.google.protobuf.WireFormat.FieldType FIXED32;
        public static final com.google.protobuf.WireFormat.FieldType FIXED64;
        public static final com.google.protobuf.WireFormat.FieldType FLOAT;
        public static final com.google.protobuf.WireFormat.FieldType GROUP;
        public static final com.google.protobuf.WireFormat.FieldType INT32;
        public static final com.google.protobuf.WireFormat.FieldType INT64;
        public static final com.google.protobuf.WireFormat.FieldType MESSAGE;
        public static final com.google.protobuf.WireFormat.FieldType SFIXED32;
        public static final com.google.protobuf.WireFormat.FieldType SFIXED64;
        public static final com.google.protobuf.WireFormat.FieldType SINT32;
        public static final com.google.protobuf.WireFormat.FieldType SINT64;
        public static final com.google.protobuf.WireFormat.FieldType STRING;
        public static final com.google.protobuf.WireFormat.FieldType UINT32;
        public static final com.google.protobuf.WireFormat.FieldType UINT64;
        private final com.google.protobuf.WireFormat.JavaType javaType;
        private final int wireType;

        /* renamed from: com.google.protobuf.WireFormat$FieldType$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.protobuf.WireFormat.FieldType {
            public AnonymousClass1(java.lang.String str, int i, com.google.protobuf.WireFormat.JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$FieldType$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.protobuf.WireFormat.FieldType {
            public AnonymousClass2(java.lang.String str, int i, com.google.protobuf.WireFormat.JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$FieldType$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.protobuf.WireFormat.FieldType {
            public AnonymousClass3(java.lang.String str, int i, com.google.protobuf.WireFormat.JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.WireFormat$FieldType$4, reason: invalid class name */
        public enum AnonymousClass4 extends com.google.protobuf.WireFormat.FieldType {
            public AnonymousClass4(java.lang.String str, int i, com.google.protobuf.WireFormat.JavaType javaType, int i2) {
                super(str, i, javaType, i2, null);
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        }

        static {
            com.google.protobuf.WireFormat.FieldType fieldType = new com.google.protobuf.WireFormat.FieldType("DOUBLE", 0, com.google.protobuf.WireFormat.JavaType.DOUBLE, 1);
            DOUBLE = fieldType;
            com.google.protobuf.WireFormat.FieldType fieldType2 = new com.google.protobuf.WireFormat.FieldType("FLOAT", 1, com.google.protobuf.WireFormat.JavaType.FLOAT, 5);
            FLOAT = fieldType2;
            com.google.protobuf.WireFormat.JavaType javaType = com.google.protobuf.WireFormat.JavaType.LONG;
            com.google.protobuf.WireFormat.FieldType fieldType3 = new com.google.protobuf.WireFormat.FieldType("INT64", 2, javaType, 0);
            INT64 = fieldType3;
            com.google.protobuf.WireFormat.FieldType fieldType4 = new com.google.protobuf.WireFormat.FieldType("UINT64", 3, javaType, 0);
            UINT64 = fieldType4;
            com.google.protobuf.WireFormat.JavaType javaType2 = com.google.protobuf.WireFormat.JavaType.INT;
            com.google.protobuf.WireFormat.FieldType fieldType5 = new com.google.protobuf.WireFormat.FieldType("INT32", 4, javaType2, 0);
            INT32 = fieldType5;
            com.google.protobuf.WireFormat.FieldType fieldType6 = new com.google.protobuf.WireFormat.FieldType("FIXED64", 5, javaType, 1);
            FIXED64 = fieldType6;
            com.google.protobuf.WireFormat.FieldType fieldType7 = new com.google.protobuf.WireFormat.FieldType("FIXED32", 6, javaType2, 5);
            FIXED32 = fieldType7;
            com.google.protobuf.WireFormat.FieldType fieldType8 = new com.google.protobuf.WireFormat.FieldType("BOOL", 7, com.google.protobuf.WireFormat.JavaType.BOOLEAN, 0);
            BOOL = fieldType8;
            com.google.protobuf.WireFormat.FieldType.AnonymousClass1 anonymousClass1 = new com.google.protobuf.WireFormat.FieldType.AnonymousClass1("STRING", 8, com.google.protobuf.WireFormat.JavaType.STRING, 2);
            STRING = anonymousClass1;
            com.google.protobuf.WireFormat.JavaType javaType3 = com.google.protobuf.WireFormat.JavaType.MESSAGE;
            com.google.protobuf.WireFormat.FieldType.AnonymousClass2 anonymousClass2 = new com.google.protobuf.WireFormat.FieldType.AnonymousClass2("GROUP", 9, javaType3, 3);
            GROUP = anonymousClass2;
            com.google.protobuf.WireFormat.FieldType.AnonymousClass3 anonymousClass3 = new com.google.protobuf.WireFormat.FieldType.AnonymousClass3("MESSAGE", 10, javaType3, 2);
            MESSAGE = anonymousClass3;
            com.google.protobuf.WireFormat.FieldType.AnonymousClass4 anonymousClass4 = new com.google.protobuf.WireFormat.FieldType.AnonymousClass4("BYTES", 11, com.google.protobuf.WireFormat.JavaType.BYTE_STRING, 2);
            BYTES = anonymousClass4;
            com.google.protobuf.WireFormat.FieldType fieldType9 = new com.google.protobuf.WireFormat.FieldType("UINT32", 12, javaType2, 0);
            UINT32 = fieldType9;
            com.google.protobuf.WireFormat.FieldType fieldType10 = new com.google.protobuf.WireFormat.FieldType("ENUM", 13, com.google.protobuf.WireFormat.JavaType.ENUM, 0);
            ENUM = fieldType10;
            com.google.protobuf.WireFormat.FieldType fieldType11 = new com.google.protobuf.WireFormat.FieldType("SFIXED32", 14, javaType2, 5);
            SFIXED32 = fieldType11;
            com.google.protobuf.WireFormat.FieldType fieldType12 = new com.google.protobuf.WireFormat.FieldType("SFIXED64", 15, javaType, 1);
            SFIXED64 = fieldType12;
            com.google.protobuf.WireFormat.FieldType fieldType13 = new com.google.protobuf.WireFormat.FieldType("SINT32", 16, javaType2, 0);
            SINT32 = fieldType13;
            com.google.protobuf.WireFormat.FieldType fieldType14 = new com.google.protobuf.WireFormat.FieldType("SINT64", 17, javaType, 0);
            SINT64 = fieldType14;
            $VALUES = new com.google.protobuf.WireFormat.FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14};
        }

        private FieldType(java.lang.String str, int i, com.google.protobuf.WireFormat.JavaType javaType, int i2) {
            this.javaType = javaType;
            this.wireType = i2;
        }

        public /* synthetic */ FieldType(java.lang.String str, int i, com.google.protobuf.WireFormat.JavaType javaType, int i2, com.google.protobuf.WireFormat.AnonymousClass1 anonymousClass1) {
            this(str, i, javaType, i2);
        }

        public static com.google.protobuf.WireFormat.FieldType valueOf(java.lang.String str) {
            return (com.google.protobuf.WireFormat.FieldType) java.lang.Enum.valueOf(com.google.protobuf.WireFormat.FieldType.class, str);
        }

        public static com.google.protobuf.WireFormat.FieldType[] values() {
            return (com.google.protobuf.WireFormat.FieldType[]) $VALUES.clone();
        }

        public com.google.protobuf.WireFormat.JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(java.lang.Float.valueOf(0.0f)),
        DOUBLE(java.lang.Double.valueOf(0.0d)),
        BOOLEAN(java.lang.Boolean.FALSE),
        STRING(""),
        BYTE_STRING(com.google.protobuf.ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);

        private final java.lang.Object defaultDefault;

        JavaType(java.lang.Object obj) {
            this.defaultDefault = obj;
        }

        public java.lang.Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    private WireFormat() {
    }

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    public static int getTagWireType(int i) {
        return i & 7;
    }

    public static int makeTag(int i, int i2) {
        return (i << 3) | i2;
    }
}
