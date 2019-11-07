package io.github.zinkmk.product;

interface MultimediaControl { // an interface for multimedia control, saying that each class that
  // uses this interface will have functions for play stop previous and next.
  void play();

  void stop();

  void previous();

  void next();
}
