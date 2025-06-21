package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public class StreamLocalUriFetcher extends com.alimm.tanx.ui.image.glide.load.data.LocalUriFetcher<java.io.InputStream> {
    private static final int ID_CONTACT = 3;
    private static final int ID_DISPLAY_PHOTO = 4;
    private static final int ID_LOOKUP = 1;
    private static final int ID_THUMBNAIL = 2;
    private static final android.content.UriMatcher URI_MATCHER;

    static {
        android.content.UriMatcher uriMatcher = new android.content.UriMatcher(-1);
        URI_MATCHER = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public StreamLocalUriFetcher(android.content.Context context, android.net.Uri uri) {
        super(context, uri);
    }

    private java.io.InputStream loadResourceFromUri(android.net.Uri uri, android.content.ContentResolver contentResolver, int i) throws java.io.FileNotFoundException {
        if (i != 1 && i != 3) {
            return contentResolver.openInputStream(uri);
        }
        if (i == 1 && (uri = android.provider.ContactsContract.Contacts.lookupContact(contentResolver, uri)) == null) {
            throw new java.io.FileNotFoundException("Contact cannot be found");
        }
        return openContactPhotoInputStream(contentResolver, uri);
    }

    @android.annotation.TargetApi(14)
    private java.io.InputStream openContactPhotoInputStream(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.LocalUriFetcher
    public void close(java.io.InputStream inputStream) throws java.io.IOException {
        inputStream.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.LocalUriFetcher
    public java.io.InputStream loadResource(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException {
        return loadResourceFromUri(uri, contentResolver, URI_MATCHER.match(uri));
    }
}
