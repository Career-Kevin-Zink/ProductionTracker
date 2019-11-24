package io.github.zinkmk.product;

/**
 * @author Kevin Zink This class will let me overload the functions in it. Mainly it's here to help
 *     me get AU (the enum) It extends Product because it is one. It implements MultimediaControl
 *     for future use really.
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private final String supportedAudioFormats;

  private final String supportedPlaylistFormats;

  /**
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
