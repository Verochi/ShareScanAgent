package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class SpreadBuilder {
    public final java.util.ArrayList<java.lang.Object> a;

    public SpreadBuilder(int i) {
        this.a = new java.util.ArrayList<>(i);
    }

    public void add(java.lang.Object obj) {
        this.a.add(obj);
    }

    public void addSpread(java.lang.Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof java.lang.Object[]) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            if (objArr.length > 0) {
                java.util.ArrayList<java.lang.Object> arrayList = this.a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                java.util.Collections.addAll(this.a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof java.util.Collection) {
            this.a.addAll((java.util.Collection) obj);
            return;
        }
        if (obj instanceof java.lang.Iterable) {
            java.util.Iterator it = ((java.lang.Iterable) obj).iterator();
            while (it.hasNext()) {
                this.a.add(it.next());
            }
            return;
        }
        if (obj instanceof java.util.Iterator) {
            java.util.Iterator it2 = (java.util.Iterator) obj;
            while (it2.hasNext()) {
                this.a.add(it2.next());
            }
        } else {
            throw new java.lang.UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int size() {
        return this.a.size();
    }

    public java.lang.Object[] toArray(java.lang.Object[] objArr) {
        return this.a.toArray(objArr);
    }
}
