package io.github.zinkmk.product;

/**
 * @author Kevin Zink This is the interface for the media controls that aren't currently in use.
 */
interface MultimediaControl { // an interface for multimedia control, saying that each class that
    // uses this interface will have functions for play stop previous and next.
    void play();

    void stop();

    void previous();

    void next();
}
