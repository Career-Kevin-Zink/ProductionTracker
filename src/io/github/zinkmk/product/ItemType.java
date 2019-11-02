package io.github.zinkmk.product;

import java.util.stream.Stream;

public enum ItemType { // this is our enum, the goal here being streamlining the item types below
  AU("Audio"),
  VI("Visual"),
  AM("AudioMobile"),
  VM("VisualMobile");

  private String type;

  private ItemType(String myType) {
    type = myType;
  }

  public String getValue() {
    return type;
  }

  public String toString() {
    if (type.compareTo("Audio") == 0) return "Audio";
    else if (type.compareTo("Visual") == 0) return "Visual";
    else if (type.compareTo("AudioMobile") == 0) return "AudioMobile";
    else if (type.compareTo("VisualMobile") == 0) return "VisualMobile";
    return "SOMETHING IS BROKEN HALP CHECK: ItemType toString";
  }
}
