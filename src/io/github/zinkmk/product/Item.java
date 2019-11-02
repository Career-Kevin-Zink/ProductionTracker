package io.github.zinkmk.product;

public interface Item {     //big ol interface, specifically for these functions
  int getId();            //This interface gets implemented by @Product

  void setName(String newName);

  String getName();

  void setManufacturer(String newManufacturer);

  String getManufacturer();
}
