package io.github.zinkmk.product;

/**
 * Test class so I can actually make objects. Should be reworked later so audioPlayer/MoviePlayer is
 * used instead extends Product.
 */
class Widget extends Product {
    public Widget(int ID, ItemType type, String manufacturer, String name) {

        super(name, manufacturer, type); // Widget class, used for testing Product

        super.setId(ID);
    }
}
