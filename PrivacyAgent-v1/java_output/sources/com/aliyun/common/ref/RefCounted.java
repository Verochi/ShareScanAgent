package com.aliyun.common.ref;

/* loaded from: classes.dex */
public abstract class RefCounted implements com.aliyun.common.ref.Releasable {
    private int _RefCount = 1;

    public abstract void onLastRef();

    public final void ref() {
        com.aliyun.common.utils.Assert.assertGreaterThan(this._RefCount, 0);
        this._RefCount++;
    }

    @Override // com.aliyun.common.ref.Releasable
    public final void release() {
        int i = this._RefCount - 1;
        this._RefCount = i;
        if (i == 0) {
            onLastRef();
        } else {
            com.aliyun.common.utils.Assert.assertGreaterThan(i, 0);
        }
    }

    public void reset() {
        com.aliyun.common.utils.Assert.assertEquals(0, this._RefCount);
        this._RefCount = 1;
    }
}
