package kotlin.collections.unsigned;

@kotlin.Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "()I", "contains", "", "element", "contains-VKZWuLQ", "(J)Z", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "index", "get-s-VKNKU", "(I)J", "indexOf", "indexOf-VKZWuLQ", "(J)I", "isEmpty", "lastIndexOf", "lastIndexOf-VKZWuLQ", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class UArraysKt___UArraysJvmKt$asList$2 extends kotlin.collections.AbstractList<kotlin.ULong> implements java.util.RandomAccess {
    public final /* synthetic */ long[] n;

    public UArraysKt___UArraysJvmKt$asList$2(long[] jArr) {
        this.n = jArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj instanceof kotlin.ULong) {
            return m322containsVKZWuLQ(((kotlin.ULong) obj).getData());
        }
        return false;
    }

    /* renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m322containsVKZWuLQ(long element) {
        return kotlin.ULongArray.m224containsVKZWuLQ(this.n, element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ java.lang.Object get(int i) {
        return kotlin.ULong.m214boximpl(m323getsVKNKU(i));
    }

    /* renamed from: get-s-VKNKU, reason: not valid java name */
    public long m323getsVKNKU(int index) {
        return kotlin.ULongArray.m228getsVKNKU(this.n, index);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int getCom.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE java.lang.String() {
        return kotlin.ULongArray.m229getSizeimpl(this.n);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(java.lang.Object obj) {
        if (obj instanceof kotlin.ULong) {
            return m324indexOfVKZWuLQ(((kotlin.ULong) obj).getData());
        }
        return -1;
    }

    /* renamed from: indexOf-VKZWuLQ, reason: not valid java name */
    public int m324indexOfVKZWuLQ(long element) {
        return kotlin.collections.ArraysKt___ArraysKt.indexOf(this.n, element);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return kotlin.ULongArray.m231isEmptyimpl(this.n);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(java.lang.Object obj) {
        if (obj instanceof kotlin.ULong) {
            return m325lastIndexOfVKZWuLQ(((kotlin.ULong) obj).getData());
        }
        return -1;
    }

    /* renamed from: lastIndexOf-VKZWuLQ, reason: not valid java name */
    public int m325lastIndexOfVKZWuLQ(long element) {
        int lastIndexOf;
        lastIndexOf = kotlin.collections.ArraysKt___ArraysKt.lastIndexOf(this.n, element);
        return lastIndexOf;
    }
}
