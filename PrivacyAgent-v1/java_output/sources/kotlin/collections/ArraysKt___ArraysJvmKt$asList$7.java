package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "()I", "contains", "element", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Boolean;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ArraysKt___ArraysJvmKt$asList$7 extends kotlin.collections.AbstractList<java.lang.Boolean> implements java.util.RandomAccess {
    public final /* synthetic */ boolean[] n;

    public ArraysKt___ArraysJvmKt$asList$7(boolean[] zArr) {
        this.n = zArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj instanceof java.lang.Boolean) {
            return contains(((java.lang.Boolean) obj).booleanValue());
        }
        return false;
    }

    public boolean contains(boolean element) {
        return kotlin.collections.ArraysKt___ArraysKt.contains(this.n, element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @org.jetbrains.annotations.NotNull
    public java.lang.Boolean get(int index) {
        return java.lang.Boolean.valueOf(this.n[index]);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.n.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.Boolean) {
            return indexOf(((java.lang.Boolean) obj).booleanValue());
        }
        return -1;
    }

    public int indexOf(boolean element) {
        return kotlin.collections.ArraysKt___ArraysKt.indexOf(this.n, element);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.n.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.Boolean) {
            return lastIndexOf(((java.lang.Boolean) obj).booleanValue());
        }
        return -1;
    }

    public int lastIndexOf(boolean element) {
        return kotlin.collections.ArraysKt___ArraysKt.lastIndexOf(this.n, element);
    }
}
