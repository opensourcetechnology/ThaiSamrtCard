package com.hostos.lib.thaismartcard.exception;

import org.openide.util.Lookup;

public abstract interface CardMonitor extends Lookup.Provider, Runnable
{
  public abstract void start();

  public abstract void stop();

  public abstract boolean isRunning();
}

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.CardMonitor
 * JD-Core Version:    0.6.2
 */