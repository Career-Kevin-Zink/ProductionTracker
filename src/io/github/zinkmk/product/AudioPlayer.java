package io.github.zinkmk.product;

public class AudioPlayer extends Product implements MultimediaControl {

  private final String supportedAudioFormats;
  private final String supportedPlaylistFormats;

  /**
   *
   * TODO idk actually use this?
   * Audio player not currently in use..
   * @param manufacturer taken from product
   * @param name taken from product
   * @param supportedAudioFormats generated here
   * @param supportedPlaylistFormats generated here
   */
  public AudioPlayer(
      String manufacturer,
      String name,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AU);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public void play() { // overridden function for @MultimediaControl's "play" function
    System.out.println("play");
  }

  @Override
  public void stop() { // overridden function for @MultimediaControl's "stop" function
    System.out.println("stop");
  }

  @Override
  public void previous() { // overridden function for @MultimediaControl's "previous" function
    System.out.println("previous");
  }

  @Override
  public void next() { // overridden function for @MultimediaControl's "next" function
    System.out.println("next");
  }

  public String toString() { // toString , should return to MMC to-string
    return super.toString()
        + "\nSupported Audio Formats: "
        + supportedAudioFormats
        + "\nSupported Playlist Formats: "
        + supportedPlaylistFormats;
  }
}
