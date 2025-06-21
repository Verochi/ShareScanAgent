package androidx.core.provider;

/* loaded from: classes.dex */
class FontProvider {
    private static final java.util.Comparator<byte[]> sByteArrayComparator = new androidx.core.provider.FontProvider.AnonymousClass1();

    /* renamed from: androidx.core.provider.FontProvider$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<byte[]> {
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                byte b2 = bArr2[i];
                if (b != b2) {
                    return b - b2;
                }
            }
            return 0;
        }
    }

    private FontProvider() {
    }

    private static java.util.List<byte[]> convertToByteArrayList(android.content.pm.Signature[] signatureArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.content.pm.Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(java.util.List<byte[]> list, java.util.List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!java.util.Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static java.util.List<java.util.List<byte[]>> getCertificates(androidx.core.provider.FontRequest fontRequest, android.content.res.Resources resources) {
        return fontRequest.getCertificates() != null ? fontRequest.getCertificates() : androidx.core.content.res.FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    @androidx.annotation.NonNull
    public static androidx.core.provider.FontsContractCompat.FontFamilyResult getFontFamilyResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        return provider == null ? androidx.core.provider.FontsContractCompat.FontFamilyResult.create(1, null) : androidx.core.provider.FontsContractCompat.FontFamilyResult.create(0, query(context, fontRequest, provider.authority, cancellationSignal));
    }

    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    public static android.content.pm.ProviderInfo getProvider(@androidx.annotation.NonNull android.content.pm.PackageManager packageManager, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, @androidx.annotation.Nullable android.content.res.Resources resources) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String providerAuthority = fontRequest.getProviderAuthority();
        android.content.pm.ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new android.content.pm.PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            throw new android.content.pm.PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
        java.util.List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        java.util.Collections.sort(convertToByteArrayList, sByteArrayComparator);
        java.util.List<java.util.List<byte[]>> certificates = getCertificates(fontRequest, resources);
        for (int i = 0; i < certificates.size(); i++) {
            java.util.ArrayList arrayList = new java.util.ArrayList(certificates.get(i));
            java.util.Collections.sort(arrayList, sByteArrayComparator);
            if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                return resolveContentProvider;
            }
        }
        return null;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.VisibleForTesting
    public static androidx.core.provider.FontsContractCompat.FontInfo[] query(android.content.Context context, androidx.core.provider.FontRequest fontRequest, java.lang.String str, android.os.CancellationSignal cancellationSignal) {
        int i;
        android.net.Uri withAppendedId;
        int i2;
        boolean z;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.net.Uri build = new android.net.Uri.Builder().scheme("content").authority(str).build();
        android.net.Uri build2 = new android.net.Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        android.database.Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(build, new java.lang.String[]{"_id", androidx.core.provider.FontsContractCompat.Columns.FILE_ID, androidx.core.provider.FontsContractCompat.Columns.TTC_INDEX, androidx.core.provider.FontsContractCompat.Columns.VARIATION_SETTINGS, androidx.core.provider.FontsContractCompat.Columns.WEIGHT, androidx.core.provider.FontsContractCompat.Columns.ITALIC, androidx.core.provider.FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new java.lang.String[]{fontRequest.getQuery()}, null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.RESULT_CODE);
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.FILE_ID);
                int columnIndex4 = cursor.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.TTC_INDEX);
                int columnIndex5 = cursor.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.WEIGHT);
                int columnIndex6 = cursor.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.ITALIC);
                while (cursor.moveToNext()) {
                    int i3 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i4 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        i = i3;
                        withAppendedId = android.content.ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i = i3;
                        withAppendedId = android.content.ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    int i5 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        i2 = i;
                        z = false;
                    } else {
                        i2 = i;
                        z = true;
                    }
                    arrayList2.add(androidx.core.provider.FontsContractCompat.FontInfo.create(withAppendedId, i4, i5, z, i2));
                }
                arrayList = arrayList2;
            }
            return (androidx.core.provider.FontsContractCompat.FontInfo[]) arrayList.toArray(new androidx.core.provider.FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
