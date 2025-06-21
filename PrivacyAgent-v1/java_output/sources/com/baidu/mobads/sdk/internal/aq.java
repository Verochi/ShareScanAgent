package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class aq implements java.util.Comparator<java.util.Map.Entry<java.lang.String, java.lang.Long>> {
    final /* synthetic */ com.baidu.mobads.sdk.internal.ap a;

    public aq(com.baidu.mobads.sdk.internal.ap apVar) {
        this.a = apVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(java.util.Map.Entry<java.lang.String, java.lang.Long> entry, java.util.Map.Entry<java.lang.String, java.lang.Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}
