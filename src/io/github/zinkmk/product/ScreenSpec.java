package io.github.zinkmk.product;

/** @author Kevin Zink Interface for Screen.java */
interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
