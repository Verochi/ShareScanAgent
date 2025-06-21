package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class ExtraFieldUtils {
    public static final java.util.Map<org.apache.tools.zip.ZipShort, java.lang.Class<?>> a = new java.util.concurrent.ConcurrentHashMap();

    public static final class UnparseableExtraField {
        public static final int READ_KEY = 2;
        public static final int SKIP_KEY = 1;
        public static final int THROW_KEY = 0;
        public final int a;
        public static final org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField THROW = new org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField(0);
        public static final org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField SKIP = new org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField(1);
        public static final org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField READ = new org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField(2);

        public UnparseableExtraField(int i) {
            this.a = i;
        }

        public int getKey() {
            return this.a;
        }
    }

    static {
        register(org.apache.tools.zip.AsiExtraField.class);
        register(org.apache.tools.zip.JarMarker.class);
        register(org.apache.tools.zip.UnicodePathExtraField.class);
        register(org.apache.tools.zip.UnicodeCommentExtraField.class);
        register(org.apache.tools.zip.Zip64ExtendedInformationExtraField.class);
    }

    public static org.apache.tools.zip.ZipExtraField createExtraField(org.apache.tools.zip.ZipShort zipShort) throws java.lang.InstantiationException, java.lang.IllegalAccessException {
        java.lang.Class<?> cls = a.get(zipShort);
        if (cls != null) {
            return (org.apache.tools.zip.ZipExtraField) cls.newInstance();
        }
        org.apache.tools.zip.UnrecognizedExtraField unrecognizedExtraField = new org.apache.tools.zip.UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static byte[] mergeCentralDirectoryData(org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) {
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof org.apache.tools.zip.UnparseableExtraFieldData);
        int length = zipExtraFieldArr.length;
        if (z) {
            length--;
        }
        int i = length * 4;
        for (org.apache.tools.zip.ZipExtraField zipExtraField : zipExtraFieldArr) {
            i += zipExtraField.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            java.lang.System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            java.lang.System.arraycopy(zipExtraFieldArr[i3].getCentralDirectoryLength().getBytes(), 0, bArr, i2 + 2, 2);
            byte[] centralDirectoryData = zipExtraFieldArr[i3].getCentralDirectoryData();
            java.lang.System.arraycopy(centralDirectoryData, 0, bArr, i2 + 4, centralDirectoryData.length);
            i2 += centralDirectoryData.length + 4;
        }
        if (z) {
            byte[] centralDirectoryData2 = zipExtraFieldArr[zipExtraFieldArr.length - 1].getCentralDirectoryData();
            java.lang.System.arraycopy(centralDirectoryData2, 0, bArr, i2, centralDirectoryData2.length);
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) {
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof org.apache.tools.zip.UnparseableExtraFieldData);
        int length = zipExtraFieldArr.length;
        if (z) {
            length--;
        }
        int i = length * 4;
        for (org.apache.tools.zip.ZipExtraField zipExtraField : zipExtraFieldArr) {
            i += zipExtraField.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            java.lang.System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            java.lang.System.arraycopy(zipExtraFieldArr[i3].getLocalFileDataLength().getBytes(), 0, bArr, i2 + 2, 2);
            byte[] localFileDataData = zipExtraFieldArr[i3].getLocalFileDataData();
            java.lang.System.arraycopy(localFileDataData, 0, bArr, i2 + 4, localFileDataData.length);
            i2 += localFileDataData.length + 4;
        }
        if (z) {
            byte[] localFileDataData2 = zipExtraFieldArr[zipExtraFieldArr.length - 1].getLocalFileDataData();
            java.lang.System.arraycopy(localFileDataData2, 0, bArr, i2, localFileDataData2.length);
        }
        return bArr;
    }

    public static org.apache.tools.zip.ZipExtraField[] parse(byte[] bArr) throws java.util.zip.ZipException {
        return parse(bArr, true, org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField.THROW);
    }

    public static org.apache.tools.zip.ZipExtraField[] parse(byte[] bArr, boolean z) throws java.util.zip.ZipException {
        return parse(bArr, z, org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField.THROW);
    }

    public static org.apache.tools.zip.ZipExtraField[] parse(byte[] bArr, boolean z, org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField unparseableExtraField) throws java.util.zip.ZipException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (true) {
            if (i > bArr.length - 4) {
                break;
            }
            org.apache.tools.zip.ZipShort zipShort = new org.apache.tools.zip.ZipShort(bArr, i);
            int value = new org.apache.tools.zip.ZipShort(bArr, i + 2).getValue();
            int i2 = i + 4;
            if (i2 + value > bArr.length) {
                int key = unparseableExtraField.getKey();
                if (key == 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("bad extra field starting at ");
                    sb.append(i);
                    sb.append(".  Block length of ");
                    sb.append(value);
                    sb.append(" bytes exceeds remaining data of ");
                    sb.append((bArr.length - i) - 4);
                    sb.append(" bytes.");
                    throw new java.util.zip.ZipException(sb.toString());
                }
                if (key != 1) {
                    if (key != 2) {
                        throw new java.util.zip.ZipException("unknown UnparseableExtraField key: " + unparseableExtraField.getKey());
                    }
                    org.apache.tools.zip.UnparseableExtraFieldData unparseableExtraFieldData = new org.apache.tools.zip.UnparseableExtraFieldData();
                    if (z) {
                        unparseableExtraFieldData.parseFromLocalFileData(bArr, i, bArr.length - i);
                    } else {
                        unparseableExtraFieldData.parseFromCentralDirectoryData(bArr, i, bArr.length - i);
                    }
                    arrayList.add(unparseableExtraFieldData);
                }
            } else {
                try {
                    org.apache.tools.zip.ZipExtraField createExtraField = createExtraField(zipShort);
                    if (!z && (createExtraField instanceof org.apache.tools.zip.CentralDirectoryParsingZipExtraField)) {
                        ((org.apache.tools.zip.CentralDirectoryParsingZipExtraField) createExtraField).parseFromCentralDirectoryData(bArr, i2, value);
                        arrayList.add(createExtraField);
                        i += value + 4;
                    }
                    createExtraField.parseFromLocalFileData(bArr, i2, value);
                    arrayList.add(createExtraField);
                    i += value + 4;
                } catch (java.lang.IllegalAccessException e) {
                    throw new java.util.zip.ZipException(e.getMessage());
                } catch (java.lang.InstantiationException e2) {
                    throw new java.util.zip.ZipException(e2.getMessage());
                }
            }
        }
        return (org.apache.tools.zip.ZipExtraField[]) arrayList.toArray(new org.apache.tools.zip.ZipExtraField[arrayList.size()]);
    }

    public static void register(java.lang.Class<?> cls) {
        try {
            a.put(((org.apache.tools.zip.ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (java.lang.ClassCastException unused) {
            throw new java.lang.RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (java.lang.IllegalAccessException unused2) {
            throw new java.lang.RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (java.lang.InstantiationException unused3) {
            throw new java.lang.RuntimeException(cls + " is not a concrete class");
        }
    }
}
