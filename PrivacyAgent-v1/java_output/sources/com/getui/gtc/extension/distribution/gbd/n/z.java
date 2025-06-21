package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class z<E> {
    private java.util.Comparator<E> a;
    private int b;

    public z(java.util.Comparator<E> comparator) {
        this.a = comparator;
    }

    private void a(java.util.Comparator<E> comparator) {
        this.a = comparator;
    }

    private boolean a(java.util.List<E> list, int i, int i2, E e) {
        boolean z;
        while (true) {
            if (i > i2) {
                z = false;
                break;
            }
            z = true;
            int i3 = (i + i2) >> 1;
            int compare = this.a.compare(list.get(i3), e);
            if (compare == 0) {
                i = i3;
                break;
            }
            if (compare < 0) {
                i = i3 + 1;
            } else {
                i2 = i3 - 1;
            }
        }
        this.b = i;
        return z;
    }

    public final java.util.List<E> a(java.util.List<E> list, java.util.List<E> list2) {
        if (this.a == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int size = list.size();
        int size2 = list2.size();
        int i = size - 1;
        int i2 = size2 - 1;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size && i4 < size2) {
            E e = list.get(i3);
            E e2 = list2.get(i4);
            int compare = this.a.compare(e, e2);
            if (compare == 0) {
                arrayList.add(e);
            } else if (compare >= 0) {
                if (a(list2, i4 + 1, i2, e)) {
                    arrayList.add(e);
                    i4 = this.b + 1;
                } else {
                    i4 = this.b;
                }
                i3++;
            } else if (a(list, i3 + 1, i, e2)) {
                arrayList.add(e2);
                i3 = this.b;
            } else {
                i3 = this.b;
                i4++;
            }
            i3++;
            i4++;
        }
        return arrayList;
    }
}
