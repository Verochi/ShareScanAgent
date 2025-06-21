package com.google.protobuf;

/* loaded from: classes22.dex */
public class ExtensionRegistryLite {
    private static final com.google.protobuf.ExtensionRegistryLite EMPTY = new com.google.protobuf.ExtensionRegistryLite(true);
    private final java.util.Map<com.google.protobuf.ExtensionRegistryLite.ObjectIntPair, com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static final class ObjectIntPair {
        private final int number;
        private final java.lang.Object object;

        public ObjectIntPair(java.lang.Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.google.protobuf.ExtensionRegistryLite.ObjectIntPair)) {
                return false;
            }
            com.google.protobuf.ExtensionRegistryLite.ObjectIntPair objectIntPair = (com.google.protobuf.ExtensionRegistryLite.ObjectIntPair) obj;
            return this.object == objectIntPair.object && this.number == objectIntPair.number;
        }

        public int hashCode() {
            return (java.lang.System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new java.util.HashMap();
    }

    public ExtensionRegistryLite(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == EMPTY) {
            this.extensionsByNumber = java.util.Collections.emptyMap();
        } else {
            this.extensionsByNumber = java.util.Collections.unmodifiableMap(extensionRegistryLite.extensionsByNumber);
        }
    }

    private ExtensionRegistryLite(boolean z) {
        this.extensionsByNumber = java.util.Collections.emptyMap();
    }

    public static com.google.protobuf.ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    public static com.google.protobuf.ExtensionRegistryLite newInstance() {
        return new com.google.protobuf.ExtensionRegistryLite();
    }

    public final void add(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.extensionsByNumber.put(new com.google.protobuf.ExtensionRegistryLite.ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public <ContainingType extends com.google.protobuf.MessageLite> com.google.protobuf.GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new com.google.protobuf.ExtensionRegistryLite.ObjectIntPair(containingtype, i));
    }

    public com.google.protobuf.ExtensionRegistryLite getUnmodifiable() {
        return new com.google.protobuf.ExtensionRegistryLite(this);
    }
}
