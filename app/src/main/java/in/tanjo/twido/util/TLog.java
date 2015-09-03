package in.tanjo.twido.util;

import android.util.Log;

public class TLog {
  public static final String TAG = "TwiDo";

  // d

  public static void d(String msg) {
    Log.d(TAG, msg);
  }

  public static void d(int msg) {
    Log.d(TAG, String.valueOf(msg));
  }

  public static void d(long msg) {
    Log.d(TAG, String.valueOf(msg));
  }

  // i

  public static void i(String msg) {
    Log.i(TAG, msg);
  }

  public static void i(int msg) {
    Log.i(TAG, String.valueOf(msg));
  }

  public static void i(long msg) {
    Log.i(TAG, String.valueOf(msg));
  }

  // w

  public static void w(String msg) {
    Log.w(TAG, msg);
  }

  public static void w(int msg) {
    Log.w(TAG, String.valueOf(msg));
  }

  public static void w(long msg) {
    Log.w(TAG, String.valueOf(msg));
  }

  // e

  public static void e(String msg) {
    Log.e(TAG, msg);
  }

  public static void e(int msg) {
    Log.e(TAG, String.valueOf(msg));
  }

  public static void e(long msg) {
    Log.e(TAG, String.valueOf(msg));
  }
}
