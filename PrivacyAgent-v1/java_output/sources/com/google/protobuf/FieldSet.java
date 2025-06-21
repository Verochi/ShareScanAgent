package com.google.protobuf;

/* loaded from: classes22.dex */
final class FieldSet<FieldDescriptorType extends com.google.protobuf.FieldSet.FieldDescriptorLite<FieldDescriptorType>> {
    private static final com.google.protobuf.FieldSet DEFAULT_INSTANCE = new com.google.protobuf.FieldSet(true);
    private final com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object> fields = com.google.protobuf.SmallSortedMap.newFieldMap(16);
    private boolean isImmutable;

    /* renamed from: com.google.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[com.google.protobuf.WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[com.google.protobuf.WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.STRING.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.BYTES.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SFIXED32.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SFIXED64.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SINT32.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SINT64.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.GROUP.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.MESSAGE.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[com.google.protobuf.WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr2;
            try {
                iArr2[com.google.protobuf.WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused27) {
            }
        }
    }

    public interface FieldDescriptorLite<T extends com.google.protobuf.FieldSet.FieldDescriptorLite<T>> extends java.lang.Comparable<T> {
        com.google.protobuf.Internal.EnumLiteMap<?> getEnumType();

        com.google.protobuf.WireFormat.JavaType getLiteJavaType();

        com.google.protobuf.WireFormat.FieldType getLiteType();

        int getNumber();

        com.google.protobuf.MessageLite.Builder internalMergeFrom(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
    }

    private FieldSet(boolean z) {
        makeImmutable();
    }

    private static int computeElementSize(com.google.protobuf.WireFormat.FieldType fieldType, int i, java.lang.Object obj) {
        int computeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(i);
        if (fieldType == com.google.protobuf.WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    private static int computeElementSizeNoTag(com.google.protobuf.WireFormat.FieldType fieldType, java.lang.Object obj) {
        switch (com.google.protobuf.FieldSet.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return com.google.protobuf.CodedOutputStream.computeDoubleSizeNoTag(((java.lang.Double) obj).doubleValue());
            case 2:
                return com.google.protobuf.CodedOutputStream.computeFloatSizeNoTag(((java.lang.Float) obj).floatValue());
            case 3:
                return com.google.protobuf.CodedOutputStream.computeInt64SizeNoTag(((java.lang.Long) obj).longValue());
            case 4:
                return com.google.protobuf.CodedOutputStream.computeUInt64SizeNoTag(((java.lang.Long) obj).longValue());
            case 5:
                return com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(((java.lang.Integer) obj).intValue());
            case 6:
                return com.google.protobuf.CodedOutputStream.computeFixed64SizeNoTag(((java.lang.Long) obj).longValue());
            case 7:
                return com.google.protobuf.CodedOutputStream.computeFixed32SizeNoTag(((java.lang.Integer) obj).intValue());
            case 8:
                return com.google.protobuf.CodedOutputStream.computeBoolSizeNoTag(((java.lang.Boolean) obj).booleanValue());
            case 9:
                return com.google.protobuf.CodedOutputStream.computeStringSizeNoTag((java.lang.String) obj);
            case 10:
                return com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag((com.google.protobuf.ByteString) obj);
            case 11:
                return com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(((java.lang.Integer) obj).intValue());
            case 12:
                return com.google.protobuf.CodedOutputStream.computeSFixed32SizeNoTag(((java.lang.Integer) obj).intValue());
            case 13:
                return com.google.protobuf.CodedOutputStream.computeSFixed64SizeNoTag(((java.lang.Long) obj).longValue());
            case 14:
                return com.google.protobuf.CodedOutputStream.computeSInt32SizeNoTag(((java.lang.Integer) obj).intValue());
            case 15:
                return com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(((java.lang.Long) obj).longValue());
            case 16:
                return com.google.protobuf.CodedOutputStream.computeGroupSizeNoTag((com.google.protobuf.MessageLite) obj);
            case 17:
                return com.google.protobuf.CodedOutputStream.computeMessageSizeNoTag((com.google.protobuf.MessageLite) obj);
            case 18:
                return com.google.protobuf.CodedOutputStream.computeEnumSizeNoTag(((com.google.protobuf.Internal.EnumLite) obj).getNumber());
            default:
                throw new java.lang.RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(com.google.protobuf.FieldSet.FieldDescriptorLite<?> fieldDescriptorLite, java.lang.Object obj) {
        com.google.protobuf.WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        int i = 0;
        if (fieldDescriptorLite.isPacked()) {
            java.util.Iterator it = ((java.util.List) obj).iterator();
            while (it.hasNext()) {
                i += computeElementSizeNoTag(liteType, it.next());
            }
            return com.google.protobuf.CodedOutputStream.computeTagSize(number) + i + com.google.protobuf.CodedOutputStream.computeRawVarint32Size(i);
        }
        java.util.Iterator it2 = ((java.util.List) obj).iterator();
        while (it2.hasNext()) {
            i += computeElementSize(liteType, number, it2.next());
        }
        return i;
    }

    public static <T extends com.google.protobuf.FieldSet.FieldDescriptorLite<T>> com.google.protobuf.FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry) {
        FieldDescriptorType key = entry.getKey();
        return (key.getLiteJavaType() != com.google.protobuf.WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) ? computeFieldSize(key, entry.getValue()) : com.google.protobuf.CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (com.google.protobuf.MessageLite) entry.getValue());
    }

    public static int getWireFormatForFieldType(com.google.protobuf.WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private boolean isInitialized(java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() != com.google.protobuf.WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (!key.isRepeated()) {
            return ((com.google.protobuf.MessageLite) entry.getValue()).isInitialized();
        }
        java.util.Iterator it = ((java.util.List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((com.google.protobuf.MessageLite) it.next()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    private void mergeFromField(java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry) {
        FieldDescriptorType key = entry.getKey();
        java.lang.Object value = entry.getValue();
        if (key.isRepeated()) {
            java.lang.Object obj = this.fields.get(key);
            if (obj == null) {
                this.fields.put((com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>) key, (FieldDescriptorType) new java.util.ArrayList((java.util.List) value));
                return;
            } else {
                ((java.util.List) obj).addAll((java.util.List) value);
                return;
            }
        }
        if (key.getLiteJavaType() != com.google.protobuf.WireFormat.JavaType.MESSAGE) {
            this.fields.put((com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>) key, (FieldDescriptorType) value);
            return;
        }
        java.lang.Object obj2 = this.fields.get(key);
        if (obj2 == null) {
            this.fields.put((com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>) key, (FieldDescriptorType) value);
        } else {
            this.fields.put((com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>) key, (FieldDescriptorType) key.internalMergeFrom(((com.google.protobuf.MessageLite) obj2).toBuilder(), (com.google.protobuf.MessageLite) value).build());
        }
    }

    public static <T extends com.google.protobuf.FieldSet.FieldDescriptorLite<T>> com.google.protobuf.FieldSet<T> newFieldSet() {
        return new com.google.protobuf.FieldSet<>();
    }

    public static java.lang.Object readPrimitiveField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.WireFormat.FieldType fieldType) throws java.io.IOException {
        switch (com.google.protobuf.FieldSet.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return java.lang.Double.valueOf(codedInputStream.readDouble());
            case 2:
                return java.lang.Float.valueOf(codedInputStream.readFloat());
            case 3:
                return java.lang.Long.valueOf(codedInputStream.readInt64());
            case 4:
                return java.lang.Long.valueOf(codedInputStream.readUInt64());
            case 5:
                return java.lang.Integer.valueOf(codedInputStream.readInt32());
            case 6:
                return java.lang.Long.valueOf(codedInputStream.readFixed64());
            case 7:
                return java.lang.Integer.valueOf(codedInputStream.readFixed32());
            case 8:
                return java.lang.Boolean.valueOf(codedInputStream.readBool());
            case 9:
                return codedInputStream.readString();
            case 10:
                return codedInputStream.readBytes();
            case 11:
                return java.lang.Integer.valueOf(codedInputStream.readUInt32());
            case 12:
                return java.lang.Integer.valueOf(codedInputStream.readSFixed32());
            case 13:
                return java.lang.Long.valueOf(codedInputStream.readSFixed64());
            case 14:
                return java.lang.Integer.valueOf(codedInputStream.readSInt32());
            case 15:
                return java.lang.Long.valueOf(codedInputStream.readSInt64());
            case 16:
                throw new java.lang.IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new java.lang.IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new java.lang.IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new java.lang.RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void verifyType(com.google.protobuf.WireFormat.FieldType fieldType, java.lang.Object obj) {
        boolean z;
        obj.getClass();
        switch (com.google.protobuf.FieldSet.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[fieldType.getJavaType().ordinal()]) {
            case 1:
                z = obj instanceof java.lang.Integer;
                break;
            case 2:
                z = obj instanceof java.lang.Long;
                break;
            case 3:
                z = obj instanceof java.lang.Float;
                break;
            case 4:
                z = obj instanceof java.lang.Double;
                break;
            case 5:
                z = obj instanceof java.lang.Boolean;
                break;
            case 6:
                z = obj instanceof java.lang.String;
                break;
            case 7:
                z = obj instanceof com.google.protobuf.ByteString;
                break;
            case 8:
                z = obj instanceof com.google.protobuf.Internal.EnumLite;
                break;
            case 9:
                z = obj instanceof com.google.protobuf.MessageLite;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new java.lang.IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static void writeElement(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.WireFormat.FieldType fieldType, int i, java.lang.Object obj) throws java.io.IOException {
        if (fieldType == com.google.protobuf.WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i, (com.google.protobuf.MessageLite) obj);
        } else {
            codedOutputStream.writeTag(i, getWireFormatForFieldType(fieldType, false));
            writeElementNoTag(codedOutputStream, fieldType, obj);
        }
    }

    private static void writeElementNoTag(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.WireFormat.FieldType fieldType, java.lang.Object obj) throws java.io.IOException {
        switch (com.google.protobuf.FieldSet.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((java.lang.Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.writeFloatNoTag(((java.lang.Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.writeInt64NoTag(((java.lang.Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeUInt64NoTag(((java.lang.Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.writeInt32NoTag(((java.lang.Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.writeFixed64NoTag(((java.lang.Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.writeFixed32NoTag(((java.lang.Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.writeBoolNoTag(((java.lang.Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.writeStringNoTag((java.lang.String) obj);
                break;
            case 10:
                codedOutputStream.writeBytesNoTag((com.google.protobuf.ByteString) obj);
                break;
            case 11:
                codedOutputStream.writeUInt32NoTag(((java.lang.Integer) obj).intValue());
                break;
            case 12:
                codedOutputStream.writeSFixed32NoTag(((java.lang.Integer) obj).intValue());
                break;
            case 13:
                codedOutputStream.writeSFixed64NoTag(((java.lang.Long) obj).longValue());
                break;
            case 14:
                codedOutputStream.writeSInt32NoTag(((java.lang.Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSInt64NoTag(((java.lang.Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeGroupNoTag((com.google.protobuf.MessageLite) obj);
                break;
            case 17:
                codedOutputStream.writeMessageNoTag((com.google.protobuf.MessageLite) obj);
                break;
            case 18:
                codedOutputStream.writeEnumNoTag(((com.google.protobuf.Internal.EnumLite) obj).getNumber());
                break;
        }
    }

    public static void writeField(com.google.protobuf.FieldSet.FieldDescriptorLite<?> fieldDescriptorLite, java.lang.Object obj, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        com.google.protobuf.WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            writeElement(codedOutputStream, liteType, number, obj);
            return;
        }
        java.util.List list = (java.util.List) obj;
        if (!fieldDescriptorLite.isPacked()) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                writeElement(codedOutputStream, liteType, number, it.next());
            }
            return;
        }
        codedOutputStream.writeTag(number, 2);
        java.util.Iterator it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += computeElementSizeNoTag(liteType, it2.next());
        }
        codedOutputStream.writeRawVarint32(i);
        java.util.Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            writeElementNoTag(codedOutputStream, liteType, it3.next());
        }
    }

    private void writeMessageSetTo(java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() != com.google.protobuf.WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) {
            writeField(key, entry.getValue(), codedOutputStream);
        } else {
            codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (com.google.protobuf.MessageLite) entry.getValue());
        }
    }

    public void addRepeatedField(FieldDescriptorType fielddescriptortype, java.lang.Object obj) {
        java.util.List list;
        if (!fielddescriptortype.isRepeated()) {
            throw new java.lang.IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(fielddescriptortype.getLiteType(), obj);
        java.lang.Object obj2 = this.fields.get(fielddescriptortype);
        if (obj2 == null) {
            list = new java.util.ArrayList();
            this.fields.put((com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>) fielddescriptortype, (FieldDescriptorType) list);
        } else {
            list = (java.util.List) obj2;
        }
        list.add(obj);
    }

    public void clear() {
        this.fields.clear();
    }

    public void clearField(FieldDescriptorType fielddescriptortype) {
        this.fields.remove(fielddescriptortype);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.google.protobuf.FieldSet<FieldDescriptorType> m50clone() {
        com.google.protobuf.FieldSet<FieldDescriptorType> newFieldSet = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            java.util.Map.Entry<FieldDescriptorType, java.lang.Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            newFieldSet.setField(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry : this.fields.getOverflowEntries()) {
            newFieldSet.setField(entry.getKey(), entry.getValue());
        }
        return newFieldSet;
    }

    public java.util.Map<FieldDescriptorType, java.lang.Object> getAllFields() {
        return this.fields.isImmutable() ? this.fields : java.util.Collections.unmodifiableMap(this.fields);
    }

    public java.lang.Object getField(FieldDescriptorType fielddescriptortype) {
        return this.fields.get(fielddescriptortype);
    }

    public int getMessageSetSerializedSize() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            i += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i2));
        }
        java.util.Iterator<java.util.Map.Entry<FieldDescriptorType, java.lang.Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            i += getMessageSetSerializedSize(it.next());
        }
        return i;
    }

    public java.lang.Object getRepeatedField(FieldDescriptorType fielddescriptortype, int i) {
        if (!fielddescriptortype.isRepeated()) {
            throw new java.lang.IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        java.lang.Object obj = this.fields.get(fielddescriptortype);
        if (obj != null) {
            return ((java.util.List) obj).get(i);
        }
        throw new java.lang.IndexOutOfBoundsException();
    }

    public int getRepeatedFieldCount(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            throw new java.lang.IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        java.lang.Object obj = this.fields.get(fielddescriptortype);
        if (obj == null) {
            return 0;
        }
        return ((java.util.List) obj).size();
    }

    public int getSerializedSize() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            java.util.Map.Entry<FieldDescriptorType, java.lang.Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            i += computeFieldSize(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry : this.fields.getOverflowEntries()) {
            i += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return i;
    }

    public boolean hasField(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            throw new java.lang.IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(fielddescriptortype) != null;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        java.util.Iterator<java.util.Map.Entry<FieldDescriptorType, java.lang.Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!isInitialized(it.next())) {
                return false;
            }
        }
        return true;
    }

    public java.util.Iterator<java.util.Map.Entry<FieldDescriptorType, java.lang.Object>> iterator() {
        return this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public void mergeFrom(com.google.protobuf.FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.fields.getNumArrayEntries(); i++) {
            mergeFromField(fieldSet.fields.getArrayEntryAt(i));
        }
        java.util.Iterator<java.util.Map.Entry<FieldDescriptorType, java.lang.Object>> it = fieldSet.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            mergeFromField(it.next());
        }
    }

    public void setField(FieldDescriptorType fielddescriptortype, java.lang.Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            verifyType(fielddescriptortype.getLiteType(), obj);
        } else {
            if (!(obj instanceof java.util.List)) {
                throw new java.lang.IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll((java.util.List) obj);
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                verifyType(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        this.fields.put((com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    public void setRepeatedField(FieldDescriptorType fielddescriptortype, int i, java.lang.Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            throw new java.lang.IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        java.lang.Object obj2 = this.fields.get(fielddescriptortype);
        if (obj2 == null) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        verifyType(fielddescriptortype.getLiteType(), obj);
        ((java.util.List) obj2).set(i, obj);
    }

    public void writeMessageSetTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i), codedOutputStream);
        }
        java.util.Iterator<java.util.Map.Entry<FieldDescriptorType, java.lang.Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            writeMessageSetTo(it.next(), codedOutputStream);
        }
    }

    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            java.util.Map.Entry<FieldDescriptorType, java.lang.Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            writeField(arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
        }
        for (java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry : this.fields.getOverflowEntries()) {
            writeField(entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }
}
