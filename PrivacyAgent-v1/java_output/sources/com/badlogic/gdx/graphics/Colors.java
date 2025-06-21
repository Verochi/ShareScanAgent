package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public final class Colors {
    public static final com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.graphics.Color> a = new com.badlogic.gdx.utils.ObjectMap<>();

    static {
        reset();
    }

    public static com.badlogic.gdx.graphics.Color get(java.lang.String str) {
        return a.get(str);
    }

    public static com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.graphics.Color> getColors() {
        return a;
    }

    public static com.badlogic.gdx.graphics.Color put(java.lang.String str, com.badlogic.gdx.graphics.Color color) {
        return a.put(str, color);
    }

    public static void reset() {
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.graphics.Color> objectMap = a;
        objectMap.clear();
        objectMap.put("CLEAR", com.badlogic.gdx.graphics.Color.CLEAR);
        objectMap.put("BLACK", com.badlogic.gdx.graphics.Color.BLACK);
        objectMap.put("WHITE", com.badlogic.gdx.graphics.Color.WHITE);
        objectMap.put("LIGHT_GRAY", com.badlogic.gdx.graphics.Color.LIGHT_GRAY);
        objectMap.put("GRAY", com.badlogic.gdx.graphics.Color.GRAY);
        objectMap.put("DARK_GRAY", com.badlogic.gdx.graphics.Color.DARK_GRAY);
        objectMap.put("BLUE", com.badlogic.gdx.graphics.Color.BLUE);
        objectMap.put("NAVY", com.badlogic.gdx.graphics.Color.NAVY);
        objectMap.put("ROYAL", com.badlogic.gdx.graphics.Color.ROYAL);
        objectMap.put("SLATE", com.badlogic.gdx.graphics.Color.SLATE);
        objectMap.put("SKY", com.badlogic.gdx.graphics.Color.SKY);
        objectMap.put("CYAN", com.badlogic.gdx.graphics.Color.CYAN);
        objectMap.put("TEAL", com.badlogic.gdx.graphics.Color.TEAL);
        objectMap.put("GREEN", com.badlogic.gdx.graphics.Color.GREEN);
        objectMap.put("CHARTREUSE", com.badlogic.gdx.graphics.Color.CHARTREUSE);
        objectMap.put("LIME", com.badlogic.gdx.graphics.Color.LIME);
        objectMap.put("FOREST", com.badlogic.gdx.graphics.Color.FOREST);
        objectMap.put("OLIVE", com.badlogic.gdx.graphics.Color.OLIVE);
        objectMap.put("YELLOW", com.badlogic.gdx.graphics.Color.YELLOW);
        objectMap.put("GOLD", com.badlogic.gdx.graphics.Color.GOLD);
        objectMap.put("GOLDENROD", com.badlogic.gdx.graphics.Color.GOLDENROD);
        objectMap.put("ORANGE", com.badlogic.gdx.graphics.Color.ORANGE);
        objectMap.put("BROWN", com.badlogic.gdx.graphics.Color.BROWN);
        objectMap.put("TAN", com.badlogic.gdx.graphics.Color.TAN);
        objectMap.put("FIREBRICK", com.badlogic.gdx.graphics.Color.FIREBRICK);
        objectMap.put("RED", com.badlogic.gdx.graphics.Color.RED);
        objectMap.put("SCARLET", com.badlogic.gdx.graphics.Color.SCARLET);
        objectMap.put("CORAL", com.badlogic.gdx.graphics.Color.CORAL);
        objectMap.put("SALMON", com.badlogic.gdx.graphics.Color.SALMON);
        objectMap.put("PINK", com.badlogic.gdx.graphics.Color.PINK);
        objectMap.put("MAGENTA", com.badlogic.gdx.graphics.Color.MAGENTA);
        objectMap.put("PURPLE", com.badlogic.gdx.graphics.Color.PURPLE);
        objectMap.put("VIOLET", com.badlogic.gdx.graphics.Color.VIOLET);
        objectMap.put("MAROON", com.badlogic.gdx.graphics.Color.MAROON);
    }
}
