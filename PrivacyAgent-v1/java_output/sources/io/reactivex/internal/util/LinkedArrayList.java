package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public class LinkedArrayList {
    public final int a;
    public java.lang.Object[] b;
    public java.lang.Object[] c;
    public volatile int d;
    public int e;

    public LinkedArrayList(int i) {
        this.a = i;
    }

    public void add(java.lang.Object obj) {
        if (this.d == 0) {
            java.lang.Object[] objArr = new java.lang.Object[this.a + 1];
            this.b = objArr;
            this.c = objArr;
            objArr[0] = obj;
            this.e = 1;
            this.d = 1;
            return;
        }
        int i = this.e;
        int i2 = this.a;
        if (i != i2) {
            this.c[i] = obj;
            this.e = i + 1;
            this.d++;
        } else {
            java.lang.Object[] objArr2 = new java.lang.Object[i2 + 1];
            objArr2[0] = obj;
            this.c[i2] = objArr2;
            this.c = objArr2;
            this.e = 1;
            this.d++;
        }
    }

    public java.lang.Object[] head() {
        return this.b;
    }

    public int size() {
        return this.d;
    }

    public java.lang.String toString() {
        int i = this.a;
        int i2 = this.d;
        java.util.ArrayList arrayList = new java.util.ArrayList(i2 + 1);
        java.lang.Object[] head = head();
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(head[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    break;
                }
            }
            return arrayList.toString();
            head = head[i];
        }
    }
}
