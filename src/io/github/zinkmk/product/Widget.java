package io.github.zinkmk.product;

public class Widget extends Product {
  public Widget(int ID, ItemType type, String manufacturer, String name) {

    super(name, manufacturer, type); // Widget class, used for testing Product

    super.setId(ID);
  }
}
