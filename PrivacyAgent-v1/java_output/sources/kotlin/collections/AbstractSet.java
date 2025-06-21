package kotlin.collections;

@kotlin.SinceKotlin(version = "1.1")
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u0000 \u000b*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lkotlin/collections/AbstractSet;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "()V", "equals", "", "other", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public abstract class AbstractSet<E> extends kotlin.collections.AbstractCollection<E> implements java.util.Set<E> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.AbstractSet.Companion INSTANCE = new kotlin.collections.AbstractSet.Companion(null);

    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\bJ\u0019\u0010\t\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0000¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractSet$Companion;", "", "()V", "setEquals", "", "c", "", "other", "setEquals$kotlin_stdlib", "unorderedHashCode", "", "", "unorderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean setEquals$kotlin_stdlib(@org.jetbrains.annotations.NotNull java.util.Set<?> c, @org.jetbrains.annotations.NotNull java.util.Set<?> other) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
            if (c.size() != other.size()) {
                return false;
            }
            return c.containsAll(other);
        }

        public final int unorderedHashCode$kotlin_stdlib(@org.jetbrains.annotations.NotNull java.util.Collection<?> c) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
            java.util.Iterator<?> it = c.iterator();
            int i = 0;
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                i += next != null ? next.hashCode() : 0;
            }
            return i;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof java.util.Set) {
            return INSTANCE.setEquals$kotlin_stdlib(this, (java.util.Set) other);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return INSTANCE.unorderedHashCode$kotlin_stdlib(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
