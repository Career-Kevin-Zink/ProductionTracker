package io.github.zinkmk.product;

/**
 * @author Kevin Zink interface built specifically for these functions This interface gets
 * implemented by @Product
 */
interface Item {
    int getId();

    void setName(String newName);

    String getName();

    void setManufacturer(String newManufacturer);

    String getManufacturer();
}
