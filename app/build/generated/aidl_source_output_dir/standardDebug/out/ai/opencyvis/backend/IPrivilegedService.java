/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package ai.opencyvis.backend;
public interface IPrivilegedService extends android.os.IInterface
{
  /** Default implementation for IPrivilegedService. */
  public static class Default implements ai.opencyvis.backend.IPrivilegedService
  {
    @Override public int getServiceUid() throws android.os.RemoteException
    {
      return 0;
    }
    @Override public boolean injectMotionEvent(byte[] parceledEvent, int displayId, int mode) throws android.os.RemoteException
    {
      return false;
    }
    @Override public boolean injectKeyEvent(int action, int keyCode, int repeat, int metaState, int displayId, int mode) throws android.os.RemoteException
    {
      return false;
    }
    @Override public int createVirtualDisplay(java.lang.String name, int width, int height, int dpi, int flags) throws android.os.RemoteException
    {
      return 0;
    }
    @Override public void releaseVirtualDisplay() throws android.os.RemoteException
    {
    }
    @Override public void setVirtualDisplaySurface(android.view.Surface surface) throws android.os.RemoteException
    {
    }
    @Override public android.os.SharedMemory captureScreen(int displayId, int maxWidth, int quality) throws android.os.RemoteException
    {
      return null;
    }
    @Override public int getTopTaskIdOnDisplay(int displayId, java.lang.String callerPackage) throws android.os.RemoteException
    {
      return 0;
    }
    @Override public boolean moveTaskToDisplay(int taskId, int targetDisplayId) throws android.os.RemoteException
    {
      return false;
    }
    @Override public void setDisplayImePolicy(int displayId, int policy) throws android.os.RemoteException
    {
    }
    @Override public int probeCapabilities() throws android.os.RemoteException
    {
      return 0;
    }
    @Override public void destroy() throws android.os.RemoteException
    {
    }
    @Override public boolean startActivityOnDisplay(java.lang.String intentUri, int displayId) throws android.os.RemoteException
    {
      return false;
    }
    /** Launch home/launcher on a display to ensure something renders (recovery for empty VD). */
    @Override public void ensureVdHasContent(int displayId) throws android.os.RemoteException
    {
    }
    /**
     * Force-stop a package (shell uid). Used to dismiss split-screen by killing the
     * adjacent Settings pane after ADB pairing completes.
     */
    @Override public void forceStopPackage(java.lang.String packageName) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements ai.opencyvis.backend.IPrivilegedService
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an ai.opencyvis.backend.IPrivilegedService interface,
     * generating a proxy if needed.
     */
    public static ai.opencyvis.backend.IPrivilegedService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof ai.opencyvis.backend.IPrivilegedService))) {
        return ((ai.opencyvis.backend.IPrivilegedService)iin);
      }
      return new ai.opencyvis.backend.IPrivilegedService.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
        data.enforceInterface(descriptor);
      }
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
      }
      switch (code)
      {
        case TRANSACTION_getServiceUid:
        {
          int _result = this.getServiceUid();
          reply.writeNoException();
          reply.writeInt(_result);
          break;
        }
        case TRANSACTION_injectMotionEvent:
        {
          byte[] _arg0;
          _arg0 = data.createByteArray();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          boolean _result = this.injectMotionEvent(_arg0, _arg1, _arg2);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          break;
        }
        case TRANSACTION_injectKeyEvent:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          int _arg3;
          _arg3 = data.readInt();
          int _arg4;
          _arg4 = data.readInt();
          int _arg5;
          _arg5 = data.readInt();
          boolean _result = this.injectKeyEvent(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          break;
        }
        case TRANSACTION_createVirtualDisplay:
        {
          java.lang.String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          int _arg3;
          _arg3 = data.readInt();
          int _arg4;
          _arg4 = data.readInt();
          int _result = this.createVirtualDisplay(_arg0, _arg1, _arg2, _arg3, _arg4);
          reply.writeNoException();
          reply.writeInt(_result);
          break;
        }
        case TRANSACTION_releaseVirtualDisplay:
        {
          this.releaseVirtualDisplay();
          reply.writeNoException();
          break;
        }
        case TRANSACTION_setVirtualDisplaySurface:
        {
          android.view.Surface _arg0;
          _arg0 = _Parcel.readTypedObject(data, android.view.Surface.CREATOR);
          this.setVirtualDisplaySurface(_arg0);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_captureScreen:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          android.os.SharedMemory _result = this.captureScreen(_arg0, _arg1, _arg2);
          reply.writeNoException();
          _Parcel.writeTypedObject(reply, _result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          break;
        }
        case TRANSACTION_getTopTaskIdOnDisplay:
        {
          int _arg0;
          _arg0 = data.readInt();
          java.lang.String _arg1;
          _arg1 = data.readString();
          int _result = this.getTopTaskIdOnDisplay(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(_result);
          break;
        }
        case TRANSACTION_moveTaskToDisplay:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          boolean _result = this.moveTaskToDisplay(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          break;
        }
        case TRANSACTION_setDisplayImePolicy:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.setDisplayImePolicy(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_probeCapabilities:
        {
          int _result = this.probeCapabilities();
          reply.writeNoException();
          reply.writeInt(_result);
          break;
        }
        case TRANSACTION_destroy:
        {
          this.destroy();
          reply.writeNoException();
          break;
        }
        case TRANSACTION_startActivityOnDisplay:
        {
          java.lang.String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          boolean _result = this.startActivityOnDisplay(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          break;
        }
        case TRANSACTION_ensureVdHasContent:
        {
          int _arg0;
          _arg0 = data.readInt();
          this.ensureVdHasContent(_arg0);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_forceStopPackage:
        {
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.forceStopPackage(_arg0);
          reply.writeNoException();
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements ai.opencyvis.backend.IPrivilegedService
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public int getServiceUid() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getServiceUid, _data, _reply, 0);
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean injectMotionEvent(byte[] parceledEvent, int displayId, int mode) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeByteArray(parceledEvent);
          _data.writeInt(displayId);
          _data.writeInt(mode);
          boolean _status = mRemote.transact(Stub.TRANSACTION_injectMotionEvent, _data, _reply, 0);
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean injectKeyEvent(int action, int keyCode, int repeat, int metaState, int displayId, int mode) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(action);
          _data.writeInt(keyCode);
          _data.writeInt(repeat);
          _data.writeInt(metaState);
          _data.writeInt(displayId);
          _data.writeInt(mode);
          boolean _status = mRemote.transact(Stub.TRANSACTION_injectKeyEvent, _data, _reply, 0);
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public int createVirtualDisplay(java.lang.String name, int width, int height, int dpi, int flags) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(name);
          _data.writeInt(width);
          _data.writeInt(height);
          _data.writeInt(dpi);
          _data.writeInt(flags);
          boolean _status = mRemote.transact(Stub.TRANSACTION_createVirtualDisplay, _data, _reply, 0);
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void releaseVirtualDisplay() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_releaseVirtualDisplay, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void setVirtualDisplaySurface(android.view.Surface surface) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, surface, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_setVirtualDisplaySurface, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public android.os.SharedMemory captureScreen(int displayId, int maxWidth, int quality) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        android.os.SharedMemory _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(displayId);
          _data.writeInt(maxWidth);
          _data.writeInt(quality);
          boolean _status = mRemote.transact(Stub.TRANSACTION_captureScreen, _data, _reply, 0);
          _reply.readException();
          _result = _Parcel.readTypedObject(_reply, android.os.SharedMemory.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public int getTopTaskIdOnDisplay(int displayId, java.lang.String callerPackage) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(displayId);
          _data.writeString(callerPackage);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getTopTaskIdOnDisplay, _data, _reply, 0);
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean moveTaskToDisplay(int taskId, int targetDisplayId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(taskId);
          _data.writeInt(targetDisplayId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_moveTaskToDisplay, _data, _reply, 0);
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void setDisplayImePolicy(int displayId, int policy) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(displayId);
          _data.writeInt(policy);
          boolean _status = mRemote.transact(Stub.TRANSACTION_setDisplayImePolicy, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public int probeCapabilities() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_probeCapabilities, _data, _reply, 0);
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void destroy() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_destroy, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public boolean startActivityOnDisplay(java.lang.String intentUri, int displayId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(intentUri);
          _data.writeInt(displayId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_startActivityOnDisplay, _data, _reply, 0);
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /** Launch home/launcher on a display to ensure something renders (recovery for empty VD). */
      @Override public void ensureVdHasContent(int displayId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(displayId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_ensureVdHasContent, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /**
       * Force-stop a package (shell uid). Used to dismiss split-screen by killing the
       * adjacent Settings pane after ADB pairing completes.
       */
      @Override public void forceStopPackage(java.lang.String packageName) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(packageName);
          boolean _status = mRemote.transact(Stub.TRANSACTION_forceStopPackage, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_getServiceUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_injectMotionEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_injectKeyEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_createVirtualDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_releaseVirtualDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_setVirtualDisplaySurface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_captureScreen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_getTopTaskIdOnDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_moveTaskToDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    static final int TRANSACTION_setDisplayImePolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
    static final int TRANSACTION_probeCapabilities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
    static final int TRANSACTION_destroy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
    static final int TRANSACTION_startActivityOnDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
    static final int TRANSACTION_ensureVdHasContent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
    static final int TRANSACTION_forceStopPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
  }
  public static final java.lang.String DESCRIPTOR = "ai.opencyvis.backend.IPrivilegedService";
  public int getServiceUid() throws android.os.RemoteException;
  public boolean injectMotionEvent(byte[] parceledEvent, int displayId, int mode) throws android.os.RemoteException;
  public boolean injectKeyEvent(int action, int keyCode, int repeat, int metaState, int displayId, int mode) throws android.os.RemoteException;
  public int createVirtualDisplay(java.lang.String name, int width, int height, int dpi, int flags) throws android.os.RemoteException;
  public void releaseVirtualDisplay() throws android.os.RemoteException;
  public void setVirtualDisplaySurface(android.view.Surface surface) throws android.os.RemoteException;
  public android.os.SharedMemory captureScreen(int displayId, int maxWidth, int quality) throws android.os.RemoteException;
  public int getTopTaskIdOnDisplay(int displayId, java.lang.String callerPackage) throws android.os.RemoteException;
  public boolean moveTaskToDisplay(int taskId, int targetDisplayId) throws android.os.RemoteException;
  public void setDisplayImePolicy(int displayId, int policy) throws android.os.RemoteException;
  public int probeCapabilities() throws android.os.RemoteException;
  public void destroy() throws android.os.RemoteException;
  public boolean startActivityOnDisplay(java.lang.String intentUri, int displayId) throws android.os.RemoteException;
  /** Launch home/launcher on a display to ensure something renders (recovery for empty VD). */
  public void ensureVdHasContent(int displayId) throws android.os.RemoteException;
  /**
   * Force-stop a package (shell uid). Used to dismiss split-screen by killing the
   * adjacent Settings pane after ADB pairing completes.
   */
  public void forceStopPackage(java.lang.String packageName) throws android.os.RemoteException;
  /** @hide */
  static class _Parcel {
    static private <T> T readTypedObject(
        android.os.Parcel parcel,
        android.os.Parcelable.Creator<T> c) {
      if (parcel.readInt() != 0) {
          return c.createFromParcel(parcel);
      } else {
          return null;
      }
    }
    static private <T extends android.os.Parcelable> void writeTypedObject(
        android.os.Parcel parcel, T value, int parcelableFlags) {
      if (value != null) {
        parcel.writeInt(1);
        value.writeToParcel(parcel, parcelableFlags);
      } else {
        parcel.writeInt(0);
      }
    }
  }
}
