package io.github.zinkmk.product;

public class MoviePlayer extends Product implements MultimediaControl {
  private String screen;
  private String monitorType; // initializing variable's for moniterType and screen

  public MoviePlayer(String name, String manufacturer, String screen, String monitorType) {  // overloaded constructor,
    super(name, manufacturer, ItemType.VI);                                     // taking the supers name, man, IT
    this.screen = screen;                                                       // and screen/ MT from this class.
    this.monitorType = monitorType;
  }

  @Override
  public void play() {                        //overridden function for @MultimediaControl's "play" function
    System.out.println("play");
  }

  @Override
  public void stop() {                        //overridden function for @MultimediaControl's "stop" function
    System.out.println("stop");
  }

  @Override
  public void previous() {                    //overridden function for @MultimediaControl's "previous" function
    System.out.println("previous");
  }

  @Override
  public void next() {                        //overridden function for @MultimediaControl's "next" function
    System.out.println("next");
  }

  public String toString() {        //ToString to return screen type and monitor types
    return super.toString()
        + "\nSupported screen types: "
        + screen
        + "\nSupported monitor types: "
        + monitorType;
  }
}
