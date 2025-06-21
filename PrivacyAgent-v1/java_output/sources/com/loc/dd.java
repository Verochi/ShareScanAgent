package com.loc;

/* loaded from: classes23.dex */
public final class dd {
    private com.loc.eh b;
    private java.util.List<com.loc.ei> a = new java.util.ArrayList();
    private java.util.ArrayList<com.loc.ei> c = new java.util.ArrayList<>();

    /* renamed from: com.loc.dd$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.loc.ei> {
        public AnonymousClass1() {
        }

        private static int a(com.loc.ei eiVar, com.loc.ei eiVar2) {
            return eiVar2.c - eiVar.c;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.loc.ei eiVar, com.loc.ei eiVar2) {
            return a(eiVar, eiVar2);
        }
    }

    private static java.util.List<com.loc.ei> a(java.util.List<com.loc.ei> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < list.size(); i++) {
            com.loc.ei eiVar = list.get(i);
            hashMap.put(java.lang.Integer.valueOf(eiVar.c), eiVar);
        }
        arrayList.addAll(hashMap.values());
        return arrayList;
    }

    private boolean a(com.loc.eh ehVar) {
        float f = ehVar.g;
        float f2 = 10.0f;
        if (f > 10.0f) {
            f2 = 200.0f;
        } else if (f > 2.0f) {
            f2 = 50.0f;
        }
        return ehVar.a(this.b) > ((double) f2);
    }

    private static boolean a(com.loc.eh ehVar, long j, long j2) {
        return j > 0 && j2 - j < ((long) ((ehVar.g > 10.0f ? 1 : (ehVar.g == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    private static boolean a(java.util.List<com.loc.ei> list, java.util.List<com.loc.ei> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            int i = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            java.util.HashMap hashMap = new java.util.HashMap(list.size());
            java.util.Iterator<com.loc.ei> it = list.iterator();
            while (it.hasNext()) {
                hashMap.put(java.lang.Long.valueOf(it.next().a), 1);
            }
            java.util.Iterator<com.loc.ei> it2 = list2.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (((java.lang.Integer) hashMap.get(java.lang.Long.valueOf(it2.next().a))) != null) {
                    i2++;
                }
            }
            if (i2 * 2.0d >= i * 0.5d) {
                return true;
            }
        }
        return false;
    }

    private java.util.List<com.loc.ei> b(java.util.List<com.loc.ei> list) {
        java.util.Collections.sort(list, new com.loc.dd.AnonymousClass1());
        return list;
    }

    private void b(java.util.List<com.loc.ei> list, java.util.List<com.loc.ei> list2) {
        list.clear();
        if (list2 != null) {
            java.util.List<com.loc.ei> b = b(a(list2));
            int size = b.size();
            if (size > 40) {
                size = 40;
            }
            for (int i = 0; i < size; i++) {
                list.add(b.get(i));
            }
        }
    }

    private boolean b(com.loc.eh ehVar, java.util.List<com.loc.ei> list, boolean z, long j, long j2) {
        if (!z || !a(ehVar, j, j2) || list == null || list.size() <= 0) {
            return false;
        }
        if (this.b == null) {
            return true;
        }
        boolean a = a(ehVar);
        return !a ? true ^ a(list, this.a) : a;
    }

    public final java.util.List<com.loc.ei> a(com.loc.eh ehVar, java.util.List<com.loc.ei> list, boolean z, long j, long j2) {
        if (!b(ehVar, list, z, j, j2)) {
            return null;
        }
        b(this.c, list);
        this.a.clear();
        this.a.addAll(list);
        this.b = ehVar;
        return this.c;
    }
}
