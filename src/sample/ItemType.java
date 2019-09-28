package sample;

public enum ItemType {
  AU("Audio"),
  VI("Visual"),
  AM("AudioMobile"),
  VM("VisualMobile");

  private String type;

  ItemType(String myType) {
    type = myType;
  }

    public String getType() {
        return type;
    }
}
