package com.google.protobuf;

/* loaded from: classes22.dex */
public abstract class GeneratedMessageLite extends com.google.protobuf.AbstractMessageLite implements java.io.Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[com.google.protobuf.WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr;
            try {
                iArr[com.google.protobuf.WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[com.google.protobuf.WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class Builder<MessageType extends com.google.protobuf.GeneratedMessageLite, BuilderType extends com.google.protobuf.GeneratedMessageLite.Builder> extends com.google.protobuf.AbstractMessageLite.Builder<BuilderType> {
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType clear() {
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BuilderType mo49clone() {
            throw new java.lang.UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i) throws java.io.IOException {
            return codedInputStream.skipField(i);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends com.google.protobuf.GeneratedMessageLite.ExtendableMessage<MessageType>, BuilderType extends com.google.protobuf.GeneratedMessageLite.ExtendableBuilder<MessageType, BuilderType>> extends com.google.protobuf.GeneratedMessageLite.Builder<MessageType, BuilderType> implements com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType> {
        private com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor> extensions = com.google.protobuf.FieldSet.emptySet();
        private boolean extensionsIsMutable;

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensionsIsMutable) {
                return;
            }
            this.extensions = this.extensions.m50clone();
            this.extensionsIsMutable = true;
        }

        private void verifyExtensionContainingType(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new java.lang.IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType addExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor, type);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType clear() {
            this.extensions.clear();
            this.extensionsIsMutable = false;
            return (BuilderType) super.clear();
        }

        public final <Type> BuilderType clearExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, ?> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo49clone() {
            throw new java.lang.UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type type = (Type) this.extensions.getField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor);
            return type == null ? (Type) ((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).defaultValue : type;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) this.extensions.getRepeatedField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor, i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor);
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(((com.google.protobuf.GeneratedMessageLite.ExtendableMessage) messagetype).extensions);
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0055  */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean parseUnknownField(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, int i) throws java.io.IOException {
            boolean z;
            java.lang.Object build;
            com.google.protobuf.MessageLite messageLite;
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i);
            com.google.protobuf.GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(getDefaultInstanceForType(), com.google.protobuf.WireFormat.getTagFieldNumber(i));
            boolean z2 = false;
            if (findLiteExtensionByNumber != null) {
                if (tagWireType == com.google.protobuf.FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), false)) {
                    z = false;
                } else if (findLiteExtensionByNumber.descriptor.isRepeated && findLiteExtensionByNumber.descriptor.type.isPackable() && tagWireType == com.google.protobuf.FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), true)) {
                    z = true;
                }
                if (!z2) {
                    return codedInputStream.skipField(i);
                }
                if (z) {
                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                    if (findLiteExtensionByNumber.descriptor.getLiteType() == com.google.protobuf.WireFormat.FieldType.ENUM) {
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            java.lang.Object findValueByNumber = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                            if (findValueByNumber == null) {
                                return true;
                            }
                            ensureExtensionsIsMutable();
                            this.extensions.addRepeatedField(findLiteExtensionByNumber.descriptor, findValueByNumber);
                        }
                    } else {
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            java.lang.Object readPrimitiveField = com.google.protobuf.FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType());
                            ensureExtensionsIsMutable();
                            this.extensions.addRepeatedField(findLiteExtensionByNumber.descriptor, readPrimitiveField);
                        }
                    }
                    codedInputStream.popLimit(pushLimit);
                } else {
                    int i2 = com.google.protobuf.GeneratedMessageLite.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[findLiteExtensionByNumber.descriptor.getLiteJavaType().ordinal()];
                    if (i2 == 1) {
                        com.google.protobuf.MessageLite.Builder builder = (findLiteExtensionByNumber.descriptor.isRepeated() || (messageLite = (com.google.protobuf.MessageLite) this.extensions.getField(findLiteExtensionByNumber.descriptor)) == null) ? null : messageLite.toBuilder();
                        if (builder == null) {
                            builder = findLiteExtensionByNumber.messageDefaultInstance.newBuilderForType();
                        }
                        if (findLiteExtensionByNumber.descriptor.getLiteType() == com.google.protobuf.WireFormat.FieldType.GROUP) {
                            codedInputStream.readGroup(findLiteExtensionByNumber.getNumber(), builder, extensionRegistryLite);
                        } else {
                            codedInputStream.readMessage(builder, extensionRegistryLite);
                        }
                        build = builder.build();
                    } else if (i2 != 2) {
                        build = com.google.protobuf.FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType());
                    } else {
                        build = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (build == null) {
                            return true;
                        }
                    }
                    if (findLiteExtensionByNumber.descriptor.isRepeated()) {
                        ensureExtensionsIsMutable();
                        this.extensions.addRepeatedField(findLiteExtensionByNumber.descriptor, build);
                    } else {
                        ensureExtensionsIsMutable();
                        this.extensions.setField(findLiteExtensionByNumber.descriptor, build);
                    }
                }
                return true;
            }
            z = false;
            z2 = true;
            if (!z2) {
            }
        }

        public final <Type> BuilderType setExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor, i, type);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType setExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, Type> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor, type);
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends com.google.protobuf.GeneratedMessageLite.ExtendableMessage<MessageType>> extends com.google.protobuf.GeneratedMessageLite implements com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType> {
        private final com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            private final java.util.Iterator<java.util.Map.Entry<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor, java.lang.Object>> iter;
            private final boolean messageSetWireFormat;
            private java.util.Map.Entry<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor, java.lang.Object> next;

            private ExtensionWriter(boolean z) {
                java.util.Iterator<java.util.Map.Entry<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor, java.lang.Object>> it = com.google.protobuf.GeneratedMessageLite.ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = z;
            }

            public /* synthetic */ ExtensionWriter(com.google.protobuf.GeneratedMessageLite.ExtendableMessage extendableMessage, boolean z, com.google.protobuf.GeneratedMessageLite.AnonymousClass1 anonymousClass1) {
                this(z);
            }

            public void writeUntil(int i, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
                while (true) {
                    java.util.Map.Entry<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor, java.lang.Object> entry = this.next;
                    if (entry == null || entry.getKey().getNumber() >= i) {
                        return;
                    }
                    com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor key = this.next.getKey();
                    if (this.messageSetWireFormat && key.getLiteJavaType() == com.google.protobuf.WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (com.google.protobuf.MessageLite) this.next.getValue());
                    } else {
                        com.google.protobuf.FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        public ExtendableMessage() {
            this.extensions = com.google.protobuf.FieldSet.newFieldSet();
        }

        public ExtendableMessage(com.google.protobuf.GeneratedMessageLite.ExtendableBuilder<MessageType, ?> extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new java.lang.IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type type = (Type) this.extensions.getField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor);
            return type == null ? (Type) ((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).defaultValue : type;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) this.extensions.getRepeatedField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor, i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(((com.google.protobuf.GeneratedMessageLite.GeneratedExtension) generatedExtension).descriptor);
        }

        public com.google.protobuf.GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new com.google.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter(this, false, null);
        }

        public com.google.protobuf.GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new com.google.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter(this, true, null);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends com.google.protobuf.GeneratedMessageLite.ExtendableMessage> extends com.google.protobuf.MessageLiteOrBuilder {
        <Type> Type getExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension, int i);

        <Type> int getExtensionCount(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, java.util.List<Type>> generatedExtension);

        <Type> boolean hasExtension(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<MessageType, Type> generatedExtension);
    }

    public static final class ExtensionDescriptor implements com.google.protobuf.FieldSet.FieldDescriptorLite<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor> {
        private final com.google.protobuf.Internal.EnumLiteMap<?> enumTypeMap;
        private final boolean isPacked;
        private final boolean isRepeated;
        private final int number;
        private final com.google.protobuf.WireFormat.FieldType type;

        private ExtensionDescriptor(com.google.protobuf.Internal.EnumLiteMap<?> enumLiteMap, int i, com.google.protobuf.WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.enumTypeMap = enumLiteMap;
            this.number = i;
            this.type = fieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        public /* synthetic */ ExtensionDescriptor(com.google.protobuf.Internal.EnumLiteMap enumLiteMap, int i, com.google.protobuf.WireFormat.FieldType fieldType, boolean z, boolean z2, com.google.protobuf.GeneratedMessageLite.AnonymousClass1 anonymousClass1) {
            this(enumLiteMap, i, fieldType, z, z2);
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public com.google.protobuf.Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public com.google.protobuf.WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public com.google.protobuf.WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public com.google.protobuf.MessageLite.Builder internalMergeFrom(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.MessageLite messageLite) {
            return ((com.google.protobuf.GeneratedMessageLite.Builder) builder).mergeFrom((com.google.protobuf.GeneratedMessageLite.Builder) messageLite);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }
    }

    public static final class GeneratedExtension<ContainingType extends com.google.protobuf.MessageLite, Type> {
        private final ContainingType containingTypeDefaultInstance;
        private final Type defaultValue;
        private final com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor descriptor;
        private final com.google.protobuf.MessageLite messageDefaultInstance;

        private GeneratedExtension(ContainingType containingtype, Type type, com.google.protobuf.MessageLite messageLite, com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor extensionDescriptor) {
            if (containingtype == null) {
                throw new java.lang.IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (extensionDescriptor.getLiteType() == com.google.protobuf.WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new java.lang.IllegalArgumentException("Null messageDefaultInstance");
            }
            this.containingTypeDefaultInstance = containingtype;
            this.defaultValue = type;
            this.messageDefaultInstance = messageLite;
            this.descriptor = extensionDescriptor;
        }

        public /* synthetic */ GeneratedExtension(com.google.protobuf.MessageLite messageLite, java.lang.Object obj, com.google.protobuf.MessageLite messageLite2, com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor extensionDescriptor, com.google.protobuf.GeneratedMessageLite.AnonymousClass1 anonymousClass1) {
            this(messageLite, obj, messageLite2, extensionDescriptor);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public com.google.protobuf.MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }
    }

    public static final class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private byte[] asBytes;
        private java.lang.String messageClassName;

        public SerializedForm(com.google.protobuf.MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        public java.lang.Object readResolve() throws java.io.ObjectStreamException {
            try {
                com.google.protobuf.MessageLite.Builder builder = (com.google.protobuf.MessageLite.Builder) java.lang.Class.forName(this.messageClassName).getMethod("newBuilder", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
                builder.mergeFrom(this.asBytes);
                return builder.buildPartial();
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw new java.lang.RuntimeException("Unable to understand proto buffer", e);
            } catch (java.lang.ClassNotFoundException e2) {
                throw new java.lang.RuntimeException("Unable to find proto buffer class", e2);
            } catch (java.lang.IllegalAccessException e3) {
                throw new java.lang.RuntimeException("Unable to call newBuilder method", e3);
            } catch (java.lang.NoSuchMethodException e4) {
                throw new java.lang.RuntimeException("Unable to find newBuilder method", e4);
            } catch (java.lang.reflect.InvocationTargetException e5) {
                throw new java.lang.RuntimeException("Error calling newBuilder", e5.getCause());
            }
        }
    }

    public GeneratedMessageLite() {
    }

    public GeneratedMessageLite(com.google.protobuf.GeneratedMessageLite.Builder builder) {
    }

    public static <ContainingType extends com.google.protobuf.MessageLite, Type> com.google.protobuf.GeneratedMessageLite.GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Internal.EnumLiteMap<?> enumLiteMap, int i, com.google.protobuf.WireFormat.FieldType fieldType, boolean z) {
        return new com.google.protobuf.GeneratedMessageLite.GeneratedExtension<>(containingtype, java.util.Collections.emptyList(), messageLite, new com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor(enumLiteMap, i, fieldType, true, z, null), null);
    }

    public static <ContainingType extends com.google.protobuf.MessageLite, Type> com.google.protobuf.GeneratedMessageLite.GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Internal.EnumLiteMap<?> enumLiteMap, int i, com.google.protobuf.WireFormat.FieldType fieldType) {
        return new com.google.protobuf.GeneratedMessageLite.GeneratedExtension<>(containingtype, type, messageLite, new com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor(enumLiteMap, i, fieldType, false, false, null), null);
    }

    public java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new com.google.protobuf.GeneratedMessageLite.SerializedForm(this);
    }
}
