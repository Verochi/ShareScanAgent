package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_fs extends java.util.AbstractList<com.jd.ad.sdk.jad_hk.jad_cp> implements java.util.RandomAccess {
    public final com.jd.ad.sdk.jad_hk.jad_cp[] jad_an;
    public final int[] jad_bo;

    public jad_fs(com.jd.ad.sdk.jad_hk.jad_cp[] jad_cpVarArr, int[] iArr) {
        this.jad_an = jad_cpVarArr;
        this.jad_bo = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c3, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.jd.ad.sdk.jad_hk.jad_fs jad_an(com.jd.ad.sdk.jad_hk.jad_cp... jad_cpVarArr) {
        int i;
        if (jad_cpVarArr.length == 0) {
            return new com.jd.ad.sdk.jad_hk.jad_fs(new com.jd.ad.sdk.jad_hk.jad_cp[0], new int[]{0, -1});
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(jad_cpVarArr));
        java.util.Collections.sort(arrayList);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(-1);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(java.util.Collections.binarySearch(arrayList, jad_cpVarArr[i3]), java.lang.Integer.valueOf(i3));
        }
        if (((com.jd.ad.sdk.jad_hk.jad_cp) arrayList.get(0)).jad_cp() == 0) {
            throw new java.lang.IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i4 = 0;
        while (i4 < arrayList.size()) {
            com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_hk.jad_cp) arrayList.get(i4);
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 < arrayList.size()) {
                com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_hk.jad_cp) arrayList.get(i6);
                jad_cpVar2.getClass();
                if (!jad_cpVar2.jad_an(0, jad_cpVar, 0, jad_cpVar.jad_cp())) {
                    break;
                }
                if (jad_cpVar2.jad_cp() == jad_cpVar.jad_cp()) {
                    throw new java.lang.IllegalArgumentException("duplicate option: " + jad_cpVar2);
                }
                if (((java.lang.Integer) arrayList2.get(i6)).intValue() > ((java.lang.Integer) arrayList2.get(i4)).intValue()) {
                    arrayList.remove(i6);
                    arrayList2.remove(i6);
                } else {
                    i6++;
                }
            }
            i4 = i5;
        }
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = new com.jd.ad.sdk.jad_hk.jad_an();
        jad_an(0L, jad_anVar, 0, arrayList, 0, arrayList.size(), arrayList2);
        int i7 = (int) (jad_anVar.jad_bo / 4);
        int[] iArr = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            long j = jad_anVar.jad_bo;
            if (j < 4) {
                java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("size < 4: ");
                jad_an.append(jad_anVar.jad_bo);
                throw new java.lang.IllegalStateException(jad_an.toString());
            }
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = jad_anVar.jad_an;
            int i9 = jad_jwVar.jad_bo;
            int i10 = jad_jwVar.jad_cp;
            if (i10 - i9 < 4) {
                i = ((jad_anVar.jad_bo() & 255) << 24) | ((jad_anVar.jad_bo() & 255) << 16) | ((jad_anVar.jad_bo() & 255) << 8) | (jad_anVar.jad_bo() & 255);
            } else {
                byte[] bArr = jad_jwVar.jad_an;
                int i11 = i9 + 1;
                int i12 = i11 + 1;
                int i13 = ((bArr[i9] & 255) << 24) | ((bArr[i11] & 255) << 16);
                int i14 = i12 + 1;
                int i15 = i13 | ((bArr[i12] & 255) << 8);
                int i16 = i14 + 1;
                int i17 = i15 | (bArr[i14] & 255);
                jad_anVar.jad_bo = j - 4;
                if (i16 == i10) {
                    jad_anVar.jad_an = jad_jwVar.jad_an();
                    com.jd.ad.sdk.jad_hk.jad_kx.jad_an(jad_jwVar);
                } else {
                    jad_jwVar.jad_bo = i16;
                }
                i = i17;
            }
            iArr[i8] = i;
        }
        if (jad_anVar.jad_bo == 0) {
            return new com.jd.ad.sdk.jad_hk.jad_fs((com.jd.ad.sdk.jad_hk.jad_cp[]) jad_cpVarArr.clone(), iArr);
        }
        throw new java.lang.AssertionError();
    }

    public static void jad_an(long j, com.jd.ad.sdk.jad_hk.jad_an jad_anVar, int i, java.util.List<com.jd.ad.sdk.jad_hk.jad_cp> list, int i2, int i3, java.util.List<java.lang.Integer> list2) {
        int i4;
        int i5;
        int i6;
        long j2;
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar2;
        int i7;
        int i8;
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar3;
        if (i2 >= i3) {
            throw new java.lang.AssertionError();
        }
        for (int i9 = i2; i9 < i3; i9++) {
            if (list.get(i9).jad_cp() < i) {
                throw new java.lang.AssertionError();
            }
        }
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar = list.get(i2);
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar2 = list.get(i3 - 1);
        if (i == jad_cpVar.jad_cp()) {
            int i10 = i2 + 1;
            i5 = i10;
            i4 = list2.get(i2).intValue();
            jad_cpVar = list.get(i10);
        } else {
            i4 = -1;
            i5 = i2;
        }
        long j3 = 4;
        if (jad_cpVar.jad_an(i) != jad_cpVar2.jad_an(i)) {
            int i11 = 1;
            for (int i12 = i5 + 1; i12 < i3; i12++) {
                if (list.get(i12 - 1).jad_an(i) != list.get(i12).jad_an(i)) {
                    i11++;
                }
            }
            long j4 = j + ((int) (jad_anVar.jad_bo / 4)) + 2 + (i11 * 2);
            jad_anVar.jad_cp(i11);
            jad_anVar.jad_cp(i4);
            for (int i13 = i5; i13 < i3; i13++) {
                byte jad_an = list.get(i13).jad_an(i);
                if (i13 == i5 || jad_an != list.get(i13 - 1).jad_an(i)) {
                    jad_anVar.jad_cp(jad_an & 255);
                }
            }
            jad_anVar2 = new com.jd.ad.sdk.jad_hk.jad_an();
            int i14 = i5;
            while (i14 < i3) {
                byte jad_an2 = list.get(i14).jad_an(i);
                int i15 = i14 + 1;
                int i16 = i15;
                while (true) {
                    if (i16 >= i3) {
                        i7 = i3;
                        break;
                    } else {
                        if (jad_an2 != list.get(i16).jad_an(i)) {
                            i7 = i16;
                            break;
                        }
                        i16++;
                    }
                }
                if (i15 == i7 && i + 1 == list.get(i14).jad_cp()) {
                    jad_anVar.jad_cp(list2.get(i14).intValue());
                    i8 = i7;
                    jad_anVar3 = jad_anVar2;
                } else {
                    jad_anVar.jad_cp((int) ((((int) (jad_anVar2.jad_bo / j3)) + j4) * (-1)));
                    i8 = i7;
                    jad_anVar3 = jad_anVar2;
                    jad_an(j4, jad_anVar2, i + 1, list, i14, i7, list2);
                }
                jad_anVar2 = jad_anVar3;
                i14 = i8;
                j3 = 4;
            }
            j2 = jad_anVar2.jad_bo;
        } else {
            int min = java.lang.Math.min(jad_cpVar.jad_cp(), jad_cpVar2.jad_cp());
            int i17 = 0;
            for (int i18 = i; i18 < min && jad_cpVar.jad_an(i18) == jad_cpVar2.jad_an(i18); i18++) {
                i17++;
            }
            long j5 = 1 + j + ((int) (jad_anVar.jad_bo / 4)) + 2 + i17;
            jad_anVar.jad_cp(-i17);
            jad_anVar.jad_cp(i4);
            int i19 = i;
            while (true) {
                i6 = i + i17;
                if (i19 >= i6) {
                    break;
                }
                jad_anVar.jad_cp(jad_cpVar.jad_an(i19) & 255);
                i19++;
            }
            if (i5 + 1 == i3) {
                if (i6 != list.get(i5).jad_cp()) {
                    throw new java.lang.AssertionError();
                }
                jad_anVar.jad_cp(list2.get(i5).intValue());
                return;
            } else {
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar4 = new com.jd.ad.sdk.jad_hk.jad_an();
                jad_anVar.jad_cp((int) ((((int) (jad_anVar4.jad_bo / 4)) + j5) * (-1)));
                jad_an(j5, jad_anVar4, i6, list, i5, i3, list2);
                j2 = jad_anVar4.jad_bo;
                jad_anVar2 = jad_anVar4;
            }
        }
        jad_anVar.jad_bo(jad_anVar2, j2);
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.Object get(int i) {
        return this.jad_an[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.jad_an.length;
    }
}
