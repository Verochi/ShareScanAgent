package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public class jad_ob extends com.jd.ad.sdk.jad_kv.jad_ly<java.io.InputStream> {
    public static final android.content.UriMatcher jad_dq;

    static {
        android.content.UriMatcher uriMatcher = new android.content.UriMatcher(-1);
        jad_dq = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public jad_ob(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> jad_an() {
        return java.io.InputStream.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.io.InputStream jad_an(android.net.Uri uri, android.content.ContentResolver contentResolver) {
        java.io.InputStream openContactPhotoInputStream;
        int match = jad_dq.match(uri);
        if (match != 1) {
            if (match == 3) {
                openContactPhotoInputStream = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
            } else if (match != 5) {
                openContactPhotoInputStream = contentResolver.openInputStream(uri);
            }
            if (openContactPhotoInputStream == null) {
                return openContactPhotoInputStream;
            }
            throw new java.io.FileNotFoundException("InputStream is null for " + uri);
        }
        android.net.Uri lookupContact = android.provider.ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact == null) {
            throw new java.io.FileNotFoundException("Contact cannot be found");
        }
        openContactPhotoInputStream = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
        if (openContactPhotoInputStream == null) {
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public void jad_an(java.io.InputStream inputStream) {
        inputStream.close();
    }
}
