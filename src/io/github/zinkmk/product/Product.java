package io.github.zinkmk.product;

public abstract class Product implements Item {        // this class is abstract, so it'll make all the constructors getters and setters
                                                      // (Seen below) and have them for the classes that use this one.
  private int id;                                       //This class implements item.
  private ItemType type;              // that being said, all getters and setters for id man and name are overridden
  private String manufacturer;
  private String name;

  public Product(String name, String manufacturer, ItemType type) {
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setName(String newName) {}

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setManufacturer(String newManufacturer) {}

  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  public ItemType getType() {
    return type;
  }

  public void setType(ItemType newType) {
    type = newType;
  }

  public String toString() {
    return "ID: " + id + "\nName: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }
}
