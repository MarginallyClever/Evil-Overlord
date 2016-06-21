package com.marginallyclever.robotOverlord.communications;

import jssc.SerialPortList;

/**
 * Lists available serial connections and opens a connection of that type
 *
 * @author Dan
 * @since v7.1.0.0
 */
public class SerialConnectionManager implements AbstractConnectionManager {
  private String[] portsDetected;
  private String recentPort;


  /**
   * find all available serial ports
   *
   * @return a list of port names
   */
  @Override
  public String[] listConnections() {
    String OS = System.getProperty("os.name").toLowerCase();

    if (OS.indexOf("mac") >= 0 || OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
      portsDetected = SerialPortList.getPortNames("/dev/");
      //System.out.println("OS X");
    } else if (OS.indexOf("win") >= 0) {
      portsDetected = SerialPortList.getPortNames("COM");
      //System.out.println("Windows");
    } else {
      System.out.println("OS ERROR");
      System.out.println("OS NAME=" + System.getProperty("os.name"));
    }
    return portsDetected;
  }

  /**
   * @return <code>serialConnection</code> if connection successful.  <code>null</code> on failure.
   */
  public AbstractConnection openConnection(String connectionName) {
    //if(connectionName.equals(recentPort)) return null;

    SerialConnection serialConnection = new SerialConnection();

    try {
      serialConnection.open(connectionName);
    } catch (Exception e) {
      return null;
    }

    return serialConnection;
  }


  /**
   * @return the most recent port used by this serial connection.
   */
  @Override
  public String getRecentConnection() {
    return recentPort;
  }
}
