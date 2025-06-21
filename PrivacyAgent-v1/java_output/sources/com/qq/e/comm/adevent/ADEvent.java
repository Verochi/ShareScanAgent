package com.qq.e.comm.adevent;

/* loaded from: classes19.dex */
public class ADEvent {
    private final int a;
    private final java.lang.Object[] b;

    public ADEvent(int i, java.lang.Object... objArr) {
        this.a = i;
        this.b = objArr;
        if (i < 100) {
            a("EventId 错误" + i);
        }
    }

    private void a(java.lang.String str) {
        com.qq.e.comm.util.GDTLogger.e(str);
    }

    public <T> T getParam(int i, java.lang.Class<T> cls) {
        java.lang.Object[] objArr;
        if (cls == null || (objArr = this.b) == null || objArr.length <= i) {
            return null;
        }
        T t = (T) objArr[i];
        if (t == null) {
            com.qq.e.comm.util.GDTLogger.e("ADEvent 参数为空,type:" + this.a);
            return null;
        }
        if (cls.isInstance(t)) {
            return t;
        }
        com.qq.e.comm.util.GDTLogger.e("ADEvent" + this.a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName());
        return null;
    }

    public <T> T getParam(java.lang.Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.a;
    }
}
