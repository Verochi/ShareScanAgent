package androidx.core.app;

/* loaded from: classes.dex */
public class Person {
    private static final java.lang.String ICON_KEY = "icon";
    private static final java.lang.String IS_BOT_KEY = "isBot";
    private static final java.lang.String IS_IMPORTANT_KEY = "isImportant";
    private static final java.lang.String KEY_KEY = "key";
    private static final java.lang.String NAME_KEY = "name";
    private static final java.lang.String URI_KEY = "uri";

    @androidx.annotation.Nullable
    androidx.core.graphics.drawable.IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;

    @androidx.annotation.Nullable
    java.lang.String mKey;

    @androidx.annotation.Nullable
    java.lang.CharSequence mName;

    @androidx.annotation.Nullable
    java.lang.String mUri;

    public static class Builder {

        @androidx.annotation.Nullable
        androidx.core.graphics.drawable.IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;

        @androidx.annotation.Nullable
        java.lang.String mKey;

        @androidx.annotation.Nullable
        java.lang.CharSequence mName;

        @androidx.annotation.Nullable
        java.lang.String mUri;

        public Builder() {
        }

        public Builder(androidx.core.app.Person person) {
            this.mName = person.mName;
            this.mIcon = person.mIcon;
            this.mUri = person.mUri;
            this.mKey = person.mKey;
            this.mIsBot = person.mIsBot;
            this.mIsImportant = person.mIsImportant;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person build() {
            return new androidx.core.app.Person(this);
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person.Builder setBot(boolean z) {
            this.mIsBot = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person.Builder setIcon(@androidx.annotation.Nullable androidx.core.graphics.drawable.IconCompat iconCompat) {
            this.mIcon = iconCompat;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person.Builder setImportant(boolean z) {
            this.mIsImportant = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person.Builder setKey(@androidx.annotation.Nullable java.lang.String str) {
            this.mKey = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person.Builder setName(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mName = charSequence;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person.Builder setUri(@androidx.annotation.Nullable java.lang.String str) {
            this.mUri = str;
            return this;
        }
    }

    public Person(androidx.core.app.Person.Builder builder) {
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(28)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.app.Person fromAndroidPerson(@androidx.annotation.NonNull android.app.Person person) {
        java.lang.CharSequence name;
        android.graphics.drawable.Icon icon;
        androidx.core.graphics.drawable.IconCompat iconCompat;
        java.lang.String uri;
        java.lang.String key;
        boolean isBot;
        boolean isImportant;
        android.graphics.drawable.Icon icon2;
        androidx.core.app.Person.Builder builder = new androidx.core.app.Person.Builder();
        name = person.getName();
        androidx.core.app.Person.Builder name2 = builder.setName(name);
        icon = person.getIcon();
        if (icon != null) {
            icon2 = person.getIcon();
            iconCompat = androidx.core.graphics.drawable.IconCompat.createFromIcon(icon2);
        } else {
            iconCompat = null;
        }
        androidx.core.app.Person.Builder icon3 = name2.setIcon(iconCompat);
        uri = person.getUri();
        androidx.core.app.Person.Builder uri2 = icon3.setUri(uri);
        key = person.getKey();
        androidx.core.app.Person.Builder key2 = uri2.setKey(key);
        isBot = person.isBot();
        androidx.core.app.Person.Builder bot = key2.setBot(isBot);
        isImportant = person.isImportant();
        return bot.setImportant(isImportant).build();
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.Person fromBundle(@androidx.annotation.NonNull android.os.Bundle bundle) {
        android.os.Bundle bundle2 = bundle.getBundle("icon");
        return new androidx.core.app.Person.Builder().setName(bundle.getCharSequence("name")).setIcon(bundle2 != null ? androidx.core.graphics.drawable.IconCompat.createFromBundle(bundle2) : null).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean(IS_BOT_KEY)).setImportant(bundle.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(22)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.app.Person fromPersistableBundle(@androidx.annotation.NonNull android.os.PersistableBundle persistableBundle) {
        boolean z;
        boolean z2;
        androidx.core.app.Person.Builder key = new androidx.core.app.Person.Builder().setName(persistableBundle.getString("name")).setUri(persistableBundle.getString("uri")).setKey(persistableBundle.getString("key"));
        z = persistableBundle.getBoolean(IS_BOT_KEY);
        androidx.core.app.Person.Builder bot = key.setBot(z);
        z2 = persistableBundle.getBoolean(IS_IMPORTANT_KEY);
        return bot.setImportant(z2).build();
    }

    @androidx.annotation.Nullable
    public androidx.core.graphics.drawable.IconCompat getIcon() {
        return this.mIcon;
    }

    @androidx.annotation.Nullable
    public java.lang.String getKey() {
        return this.mKey;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getName() {
        return this.mName;
    }

    @androidx.annotation.Nullable
    public java.lang.String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public java.lang.String resolveToLegacyUri() {
        java.lang.String str = this.mUri;
        if (str != null) {
            return str;
        }
        if (this.mName == null) {
            return "";
        }
        return "name:" + ((java.lang.Object) this.mName);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(28)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        android.app.Person.Builder name;
        android.app.Person.Builder icon;
        android.app.Person.Builder uri;
        android.app.Person.Builder key;
        android.app.Person.Builder bot;
        android.app.Person.Builder important;
        android.app.Person build;
        name = new android.app.Person.Builder().setName(getName());
        icon = name.setIcon(getIcon() != null ? getIcon().toIcon() : null);
        uri = icon.setUri(getUri());
        key = uri.setKey(getKey());
        bot = key.setBot(isBot());
        important = bot.setImportant(isImportant());
        build = important.build();
        return build;
    }

    @androidx.annotation.NonNull
    public androidx.core.app.Person.Builder toBuilder() {
        return new androidx.core.app.Person.Builder(this);
    }

    @androidx.annotation.NonNull
    public android.os.Bundle toBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putCharSequence("name", this.mName);
        androidx.core.graphics.drawable.IconCompat iconCompat = this.mIcon;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.toBundle() : null);
        bundle.putString("uri", this.mUri);
        bundle.putString("key", this.mKey);
        bundle.putBoolean(IS_BOT_KEY, this.mIsBot);
        bundle.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return bundle;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(22)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.os.PersistableBundle toPersistableBundle() {
        android.os.PersistableBundle persistableBundle = new android.os.PersistableBundle();
        java.lang.CharSequence charSequence = this.mName;
        persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
        persistableBundle.putString("uri", this.mUri);
        persistableBundle.putString("key", this.mKey);
        persistableBundle.putBoolean(IS_BOT_KEY, this.mIsBot);
        persistableBundle.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return persistableBundle;
    }
}
