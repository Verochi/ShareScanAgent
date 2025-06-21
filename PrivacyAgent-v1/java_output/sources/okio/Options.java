package okio;

/* loaded from: classes24.dex */
public final class Options extends java.util.AbstractList<okio.ByteString> implements java.util.RandomAccess {
    final okio.ByteString[] byteStrings;
    final int[] trie;

    private Options(okio.ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j, okio.Buffer buffer, int i, java.util.List<okio.ByteString> list, int i2, int i3, java.util.List<java.lang.Integer> list2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        okio.Buffer buffer2;
        if (i2 >= i3) {
            throw new java.lang.AssertionError();
        }
        for (int i9 = i2; i9 < i3; i9++) {
            if (list.get(i9).size() < i) {
                throw new java.lang.AssertionError();
            }
        }
        okio.ByteString byteString = list.get(i2);
        okio.ByteString byteString2 = list.get(i3 - 1);
        if (i == byteString.size()) {
            int i10 = i2 + 1;
            i5 = i10;
            i4 = list2.get(i2).intValue();
            byteString = list.get(i10);
        } else {
            i4 = -1;
            i5 = i2;
        }
        if (byteString.getByte(i) == byteString2.getByte(i)) {
            int min = java.lang.Math.min(byteString.size(), byteString2.size());
            int i11 = 0;
            for (int i12 = i; i12 < min && byteString.getByte(i12) == byteString2.getByte(i12); i12++) {
                i11++;
            }
            long intCount = 1 + j + intCount(buffer) + 2 + i11;
            buffer.writeInt(-i11);
            buffer.writeInt(i4);
            int i13 = i;
            while (true) {
                i6 = i + i11;
                if (i13 >= i6) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i13) & 255);
                i13++;
            }
            if (i5 + 1 == i3) {
                if (i6 != list.get(i5).size()) {
                    throw new java.lang.AssertionError();
                }
                buffer.writeInt(list2.get(i5).intValue());
                return;
            } else {
                okio.Buffer buffer3 = new okio.Buffer();
                buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                buildTrieRecursive(intCount, buffer3, i6, list, i5, i3, list2);
                buffer.write(buffer3, buffer3.size());
                return;
            }
        }
        int i14 = 1;
        for (int i15 = i5 + 1; i15 < i3; i15++) {
            if (list.get(i15 - 1).getByte(i) != list.get(i15).getByte(i)) {
                i14++;
            }
        }
        long intCount2 = j + intCount(buffer) + 2 + (i14 * 2);
        buffer.writeInt(i14);
        buffer.writeInt(i4);
        for (int i16 = i5; i16 < i3; i16++) {
            byte b = list.get(i16).getByte(i);
            if (i16 == i5 || b != list.get(i16 - 1).getByte(i)) {
                buffer.writeInt(b & 255);
            }
        }
        okio.Buffer buffer4 = new okio.Buffer();
        int i17 = i5;
        while (i17 < i3) {
            byte b2 = list.get(i17).getByte(i);
            int i18 = i17 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i3) {
                    i7 = i3;
                    break;
                } else {
                    if (b2 != list.get(i19).getByte(i)) {
                        i7 = i19;
                        break;
                    }
                    i19++;
                }
            }
            if (i18 == i7 && i + 1 == list.get(i17).size()) {
                buffer.writeInt(list2.get(i17).intValue());
                i8 = i7;
                buffer2 = buffer4;
            } else {
                buffer.writeInt((int) ((intCount(buffer4) + intCount2) * (-1)));
                i8 = i7;
                buffer2 = buffer4;
                buildTrieRecursive(intCount2, buffer4, i + 1, list, i17, i7, list2);
            }
            buffer4 = buffer2;
            i17 = i8;
        }
        okio.Buffer buffer5 = buffer4;
        buffer.write(buffer5, buffer5.size());
    }

    private static int intCount(okio.Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bc, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static okio.Options of(okio.ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new okio.Options(new okio.ByteString[0], new int[]{0, -1});
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(byteStringArr));
        java.util.Collections.sort(arrayList);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(java.util.Collections.binarySearch(arrayList, byteStringArr[i2]), java.lang.Integer.valueOf(i2));
        }
        if (((okio.ByteString) arrayList.get(0)).size() == 0) {
            throw new java.lang.IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            okio.ByteString byteString = (okio.ByteString) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                okio.ByteString byteString2 = (okio.ByteString) arrayList.get(i5);
                if (!byteString2.startsWith(byteString)) {
                    break;
                }
                if (byteString2.size() == byteString.size()) {
                    throw new java.lang.IllegalArgumentException("duplicate option: " + byteString2);
                }
                if (((java.lang.Integer) arrayList2.get(i5)).intValue() > ((java.lang.Integer) arrayList2.get(i3)).intValue()) {
                    arrayList.remove(i5);
                    arrayList2.remove(i5);
                } else {
                    i5++;
                }
            }
            i3 = i4;
        }
        okio.Buffer buffer = new okio.Buffer();
        buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int intCount = intCount(buffer);
        int[] iArr = new int[intCount];
        for (int i6 = 0; i6 < intCount; i6++) {
            iArr[i6] = buffer.readInt();
        }
        if (buffer.exhausted()) {
            return new okio.Options((okio.ByteString[]) byteStringArr.clone(), iArr);
        }
        throw new java.lang.AssertionError();
    }

    @Override // java.util.AbstractList, java.util.List
    public okio.ByteString get(int i) {
        return this.byteStrings[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }
}
