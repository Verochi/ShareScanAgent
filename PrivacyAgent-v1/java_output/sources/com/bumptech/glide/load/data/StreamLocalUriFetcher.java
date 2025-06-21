package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public class StreamLocalUriFetcher extends com.bumptech.glide.load.data.LocalUriFetcher<java.io.InputStream> {
    private static final int ID_CONTACTS_CONTACT = 3;
    private static final int ID_CONTACTS_LOOKUP = 1;
    private static final int ID_CONTACTS_PHOTO = 4;
    private static final int ID_CONTACTS_THUMBNAIL = 2;
    private static final int ID_LOOKUP_BY_PHONE = 5;
    private static final android.content.UriMatcher URI_MATCHER;

    static {
        android.content.UriMatcher uriMatcher = new android.content.UriMatcher(-1);
        URI_MATCHER = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        super(contentResolver, uri);
    }

    private java.io.InputStream loadResourceFromUri(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException {
        int match = URI_MATCHER.match(uri);
        if (match != 1) {
            if (match == 3) {
                return openContactPhotoInputStream(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        android.net.Uri lookupContact = android.provider.ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return openContactPhotoInputStream(contentResolver, lookupContact);
        }
        throw new java.io.FileNotFoundException("Contact cannot be found");
    }

    private java.io.InputStream openContactPhotoInputStream(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(java.io.InputStream inputStream) throws java.io.IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> getDataClass() {
        return java.io.InputStream.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public java.io.InputStream loadResource(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException {
        java.io.InputStream loadResourceFromUri = loadResourceFromUri(uri, contentResolver);
        if (loadResourceFromUri != null) {
            return loadResourceFromUri;
        }
        throw new java.io.FileNotFoundException("InputStream is null for " + uri);
    }
}
