package io.github.zinkmk.product;

/**
 * @author Kevin Zink this is our enum, the goal here being streamlining the item types below
 */
public enum ItemType { // this is our enum, the goal here being streamlining the item types below
    AU("Audio"),
    VI("Visual"),
    AM("AudioMobile"),
    VM("VisualMobile");

    private final String type;

    ItemType(String myType) {
        type = myType;
    }

    public String getValue() {
        return type;
    }

    /**
     * toString method for our Enum's
     *
     * @return The text we want to send up the toString.
     */
    public String toString() {
        if (type.compareTo("Audio") == 0) return "Audio";
        else if (type.compareTo("Visual") == 0) return "Visual";
        else if (type.compareTo("AudioMobile") == 0) return "AudioMobile";
        else if (type.compareTo("VisualMobile") == 0) return "VisualMobile";
        return "SOMETHING IS BROKEN HELP CHECK: ItemType toString";
    }
}
