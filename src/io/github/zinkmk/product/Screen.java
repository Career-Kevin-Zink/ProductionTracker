package io.github.zinkmk.product;

public class Screen implements ScreenSpec { // cute it implements another interface

  private int refreshRate;
  private int responseTime;
  private String resolution;

  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  public String getResolution() {
    return resolution;
  } // it's implementing these  which is cool

  public int getRefreshRate() {
    return refreshRate;
  }

  public int getResponseTime() {
    return responseTime;
  }

  public String toString() {
    return "Screen: \nResolution: "
        + resolution
        + "\nRefresh rate: "
        + refreshRate
        + "\nResponse time: "
        + responseTime;
  }
}
