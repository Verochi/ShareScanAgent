package kotlin.collections.builders;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "()V", "map", "", "(Ljava/util/Map;)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
final class SerializedMap implements java.io.Externalizable {
    private static final long serialVersionUID = 0;

    @org.jetbrains.annotations.NotNull
    private java.util.Map<?, ?> map;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SerializedMap() {
        this(r0);
        java.util.Map emptyMap;
        emptyMap = kotlin.collections.MapsKt__MapsKt.emptyMap();
    }

    public SerializedMap(@org.jetbrains.annotations.NotNull java.util.Map<?, ?> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    private final java.lang.Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(@org.jetbrains.annotations.NotNull java.io.ObjectInput input) {
        java.util.Map createMapBuilder;
        java.util.Map<?, ?> build;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        byte readByte = input.readByte();
        if (readByte != 0) {
            throw new java.io.InvalidObjectException("Unsupported flags value: " + ((int) readByte));
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            throw new java.io.InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        createMapBuilder = kotlin.collections.MapsKt__MapsJVMKt.createMapBuilder(readInt);
        for (int i = 0; i < readInt; i++) {
            createMapBuilder.put(input.readObject(), input.readObject());
        }
        build = kotlin.collections.MapsKt__MapsJVMKt.build(createMapBuilder);
        this.map = build;
    }

    @Override // java.io.Externalizable
    public void writeExternal(@org.jetbrains.annotations.NotNull java.io.ObjectOutput output) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (java.util.Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }
}
