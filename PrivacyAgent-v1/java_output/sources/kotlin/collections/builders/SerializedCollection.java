package kotlin.collections.builders;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", "", "tag", "", "(Ljava/util/Collection;I)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SerializedCollection implements java.io.Externalizable {
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    @org.jetbrains.annotations.NotNull
    private java.util.Collection<?> collection;
    private final int tag;

    public SerializedCollection() {
        this(kotlin.collections.CollectionsKt__CollectionsKt.emptyList(), 0);
    }

    public SerializedCollection(@org.jetbrains.annotations.NotNull java.util.Collection<?> collection, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.tag = i;
    }

    private final java.lang.Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@org.jetbrains.annotations.NotNull java.io.ObjectInput input) {
        java.util.List createListBuilder;
        java.util.List build;
        java.util.List list;
        java.util.Set createSetBuilder;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        byte readByte = input.readByte();
        int i = readByte & 1;
        if ((readByte & (-2)) != 0) {
            throw new java.io.InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            throw new java.io.InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        int i2 = 0;
        if (i == 0) {
            createListBuilder = kotlin.collections.CollectionsKt__CollectionsJVMKt.createListBuilder(readInt);
            while (i2 < readInt) {
                createListBuilder.add(input.readObject());
                i2++;
            }
            build = kotlin.collections.CollectionsKt__CollectionsJVMKt.build(createListBuilder);
            list = build;
        } else {
            if (i != 1) {
                throw new java.io.InvalidObjectException("Unsupported collection type tag: " + i + '.');
            }
            createSetBuilder = kotlin.collections.SetsKt__SetsJVMKt.createSetBuilder(readInt);
            while (i2 < readInt) {
                createSetBuilder.add(input.readObject());
                i2++;
            }
            list = kotlin.collections.SetsKt__SetsJVMKt.build(createSetBuilder);
        }
        this.collection = list;
    }

    @Override // java.io.Externalizable
    public void writeExternal(@org.jetbrains.annotations.NotNull java.io.ObjectOutput output) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        java.util.Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }
}
