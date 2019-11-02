package io.github.zinkmk.product;

public interface MultimediaControl {    // an interface for multimedia control, saying that each class that
  //uses this interface will have functions for play stop previous and next.
  public void play();

  public void stop();

  public void previous();

  public void next();
}
