package org.openhome.net.controlpoint.proxies;

import java.util.LinkedList;
import java.util.List;

import org.openhome.net.controlpoint.*;
import org.openhome.net.controlpoint.proxies.CpProxyLinnCoUkUpdate1.*;
import org.openhome.net.core.*;

    
interface ICpProxyLinnCoUkUpdate1 extends ICpProxy
{
    public void syncPushManifest(String aUri);
    public void beginPushManifest(String aUri, ICpProxyListener aCallback);
    public void endPushManifest(long aAsyncHandle);
    public void syncSetUpdateFeedParams(String aTopic, String aChannel);
    public void beginSetUpdateFeedParams(String aTopic, String aChannel, ICpProxyListener aCallback);
    public void endSetUpdateFeedParams(long aAsyncHandle);
    public GetUpdateFeedParams syncGetUpdateFeedParams();
    public void beginGetUpdateFeedParams(ICpProxyListener aCallback);
    public GetUpdateFeedParams endGetUpdateFeedParams(long aAsyncHandle);
    public String syncGetUpdateStatus();
    public void beginGetUpdateStatus(ICpProxyListener aCallback);
    public String endGetUpdateStatus(long aAsyncHandle);
    public void syncApply();
    public void beginApply(ICpProxyListener aCallback);
    public void endApply(long aAsyncHandle);
    public void syncRestore();
    public void beginRestore(ICpProxyListener aCallback);
    public void endRestore(long aAsyncHandle);
    public void setPropertyUpdateStatusChanged(IPropertyChangeListener aUpdateStatusChanged);
    public String getPropertyUpdateStatus();
    public void setPropertyUpdateTopicChanged(IPropertyChangeListener aUpdateTopicChanged);
    public String getPropertyUpdateTopic();
    public void setPropertyUpdateChannelChanged(IPropertyChangeListener aUpdateChannelChanged);
    public String getPropertyUpdateChannel();
}

class SyncPushManifestLinnCoUkUpdate1 extends SyncProxyAction
{
    private CpProxyLinnCoUkUpdate1 iService;

    public SyncPushManifestLinnCoUkUpdate1(CpProxyLinnCoUkUpdate1 aProxy)
    {
        iService = aProxy;
    }
    protected void completeRequest(long aAsyncHandle)
    {
        iService.endPushManifest(aAsyncHandle);
        
    }
}

class SyncSetUpdateFeedParamsLinnCoUkUpdate1 extends SyncProxyAction
{
    private CpProxyLinnCoUkUpdate1 iService;

    public SyncSetUpdateFeedParamsLinnCoUkUpdate1(CpProxyLinnCoUkUpdate1 aProxy)
    {
        iService = aProxy;
    }
    protected void completeRequest(long aAsyncHandle)
    {
        iService.endSetUpdateFeedParams(aAsyncHandle);
        
    }
}

class SyncGetUpdateFeedParamsLinnCoUkUpdate1 extends SyncProxyAction
{
    private CpProxyLinnCoUkUpdate1 iService;
    private String iTopic;
    private String iChannel;

    public SyncGetUpdateFeedParamsLinnCoUkUpdate1(CpProxyLinnCoUkUpdate1 aProxy)
    {
        iService = aProxy;
    }
    public String getTopic()
    {
        return iTopic;
    }
    public String getChannel()
    {
        return iChannel;
    }
    protected void completeRequest(long aAsyncHandle)
    {
        GetUpdateFeedParams result = iService.endGetUpdateFeedParams(aAsyncHandle);
        
        iTopic = result.getTopic();
        iChannel = result.getChannel();
    }
}

class SyncGetUpdateStatusLinnCoUkUpdate1 extends SyncProxyAction
{
    private CpProxyLinnCoUkUpdate1 iService;
    private String iUpdateStatus;

    public SyncGetUpdateStatusLinnCoUkUpdate1(CpProxyLinnCoUkUpdate1 aProxy)
    {
        iService = aProxy;
    }
    public String getUpdateStatus()
    {
        return iUpdateStatus;
    }
    protected void completeRequest(long aAsyncHandle)
    {
        String result = iService.endGetUpdateStatus(aAsyncHandle);
        
        iUpdateStatus = result;
    }
}

class SyncApplyLinnCoUkUpdate1 extends SyncProxyAction
{
    private CpProxyLinnCoUkUpdate1 iService;

    public SyncApplyLinnCoUkUpdate1(CpProxyLinnCoUkUpdate1 aProxy)
    {
        iService = aProxy;
    }
    protected void completeRequest(long aAsyncHandle)
    {
        iService.endApply(aAsyncHandle);
        
    }
}

class SyncRestoreLinnCoUkUpdate1 extends SyncProxyAction
{
    private CpProxyLinnCoUkUpdate1 iService;

    public SyncRestoreLinnCoUkUpdate1(CpProxyLinnCoUkUpdate1 aProxy)
    {
        iService = aProxy;
    }
    protected void completeRequest(long aAsyncHandle)
    {
        iService.endRestore(aAsyncHandle);
        
    }
}

/**
 * Proxy for the linn.co.uk:Update:1 UPnP service
 */
public class CpProxyLinnCoUkUpdate1 extends CpProxy implements ICpProxyLinnCoUkUpdate1
{

    public class GetUpdateFeedParams
    {
        private String iTopic;
        private String iChannel;

        public GetUpdateFeedParams(
            String aTopic,
            String aChannel
        )
        {
            iTopic = aTopic;
            iChannel = aChannel;
        }
        public String getTopic()
        {
            return iTopic;
        }
        public String getChannel()
        {
            return iChannel;
        }
    }

    private Action iActionPushManifest;
    private Action iActionSetUpdateFeedParams;
    private Action iActionGetUpdateFeedParams;
    private Action iActionGetUpdateStatus;
    private Action iActionApply;
    private Action iActionRestore;
    private PropertyString iUpdateStatus;
    private PropertyString iUpdateTopic;
    private PropertyString iUpdateChannel;
    private IPropertyChangeListener iUpdateStatusChanged;
    private IPropertyChangeListener iUpdateTopicChanged;
    private IPropertyChangeListener iUpdateChannelChanged;
    private Object iPropertyLock;

    /**
     * Constructor.
     * Use {@link #subscribe}/{@link #unsubscribe} to enable/disable querying of state variable and reporting of their changes.
     *
     * @param aDevice   the device to use.
     */

    public CpProxyLinnCoUkUpdate1(CpDevice aDevice)
    {
        super("linn-co-uk", "Update", 1, aDevice);
        Parameter param;
        List<String> allowedValues = new LinkedList<String>();

        iActionPushManifest = new Action("PushManifest");
        param = new ParameterString("Uri", allowedValues);
        iActionPushManifest.addInputParameter(param);

        iActionSetUpdateFeedParams = new Action("SetUpdateFeedParams");
        param = new ParameterString("Topic", allowedValues);
        iActionSetUpdateFeedParams.addInputParameter(param);
        allowedValues.add("release");
        allowedValues.add("beta");
        allowedValues.add("development");
        allowedValues.add("nightly");
        param = new ParameterString("Channel", allowedValues);
        iActionSetUpdateFeedParams.addInputParameter(param);
        allowedValues.clear();

        iActionGetUpdateFeedParams = new Action("GetUpdateFeedParams");
        param = new ParameterString("Topic", allowedValues);
        iActionGetUpdateFeedParams.addOutputParameter(param);
        allowedValues.add("release");
        allowedValues.add("beta");
        allowedValues.add("development");
        allowedValues.add("nightly");
        param = new ParameterString("Channel", allowedValues);
        iActionGetUpdateFeedParams.addOutputParameter(param);
        allowedValues.clear();

        iActionGetUpdateStatus = new Action("GetUpdateStatus");
        param = new ParameterString("UpdateStatus", allowedValues);
        iActionGetUpdateStatus.addOutputParameter(param);

        iActionApply = new Action("Apply");

        iActionRestore = new Action("Restore");

        iUpdateStatusChanged = new PropertyChangeListener();
        iUpdateStatus = new PropertyString("UpdateStatus",
            new PropertyChangeListener() {
                public void notifyChange() {
                    updateStatusPropertyChanged();
                }
            }
        );
        addProperty(iUpdateStatus);
        iUpdateTopicChanged = new PropertyChangeListener();
        iUpdateTopic = new PropertyString("UpdateTopic",
            new PropertyChangeListener() {
                public void notifyChange() {
                    updateTopicPropertyChanged();
                }
            }
        );
        addProperty(iUpdateTopic);
        iUpdateChannelChanged = new PropertyChangeListener();
        iUpdateChannel = new PropertyString("UpdateChannel",
            new PropertyChangeListener() {
                public void notifyChange() {
                    updateChannelPropertyChanged();
                }
            }
        );
        addProperty(iUpdateChannel);
        iPropertyLock = new Object();
    }
    /**
     * Invoke the action synchronously.
     * Blocks until the action has been processed on the device and sets any
     * output arguments.
     */
    public void syncPushManifest(String aUri)
    {
        SyncPushManifestLinnCoUkUpdate1 sync = new SyncPushManifestLinnCoUkUpdate1(this);
        beginPushManifest(aUri, sync.getListener());
        sync.waitToComplete();
        sync.reportError();
    }
    
    /**
     * Invoke the action asynchronously.
     * Returns immediately and will run the client-specified callback when the
     * action later completes.  Any output arguments can then be retrieved by
     * calling {@link #endPushManifest}.
     * 
     * @param aUri
     * @param aCallback listener to call back when action completes.
     *                  This is guaranteed to be run but may indicate an error.
     */
    public void beginPushManifest(String aUri, ICpProxyListener aCallback)
    {
        Invocation invocation = iService.getInvocation(iActionPushManifest, aCallback);
        int inIndex = 0;
        invocation.addInput(new ArgumentString((ParameterString)iActionPushManifest.getInputParameter(inIndex++), aUri));
        iService.invokeAction(invocation);
    }

    /**
     * Retrieve the output arguments from an asynchronously invoked action.
     * This may only be called from the callback set in the
     * {@link #beginPushManifest} method.
     *
     * @param aAsyncHandle  argument passed to the delegate set in the
     *          {@link #beginPushManifest} method.
     */
    public void endPushManifest(long aAsyncHandle)
    {
        ProxyError errObj = Invocation.error(aAsyncHandle);
        if (errObj != null)
        {
            throw errObj;
        }
    }
        
    /**
     * Invoke the action synchronously.
     * Blocks until the action has been processed on the device and sets any
     * output arguments.
     */
    public void syncSetUpdateFeedParams(String aTopic, String aChannel)
    {
        SyncSetUpdateFeedParamsLinnCoUkUpdate1 sync = new SyncSetUpdateFeedParamsLinnCoUkUpdate1(this);
        beginSetUpdateFeedParams(aTopic, aChannel, sync.getListener());
        sync.waitToComplete();
        sync.reportError();
    }
    
    /**
     * Invoke the action asynchronously.
     * Returns immediately and will run the client-specified callback when the
     * action later completes.  Any output arguments can then be retrieved by
     * calling {@link #endSetUpdateFeedParams}.
     * 
     * @param aTopic
     * @param aChannel
     * @param aCallback listener to call back when action completes.
     *                  This is guaranteed to be run but may indicate an error.
     */
    public void beginSetUpdateFeedParams(String aTopic, String aChannel, ICpProxyListener aCallback)
    {
        Invocation invocation = iService.getInvocation(iActionSetUpdateFeedParams, aCallback);
        int inIndex = 0;
        invocation.addInput(new ArgumentString((ParameterString)iActionSetUpdateFeedParams.getInputParameter(inIndex++), aTopic));
        invocation.addInput(new ArgumentString((ParameterString)iActionSetUpdateFeedParams.getInputParameter(inIndex++), aChannel));
        iService.invokeAction(invocation);
    }

    /**
     * Retrieve the output arguments from an asynchronously invoked action.
     * This may only be called from the callback set in the
     * {@link #beginSetUpdateFeedParams} method.
     *
     * @param aAsyncHandle  argument passed to the delegate set in the
     *          {@link #beginSetUpdateFeedParams} method.
     */
    public void endSetUpdateFeedParams(long aAsyncHandle)
    {
        ProxyError errObj = Invocation.error(aAsyncHandle);
        if (errObj != null)
        {
            throw errObj;
        }
    }
        
    /**
     * Invoke the action synchronously.
     * Blocks until the action has been processed on the device and sets any
     * output arguments.
     *
     * @return the result of the invoked action.
     */
    public GetUpdateFeedParams syncGetUpdateFeedParams()
    {
        SyncGetUpdateFeedParamsLinnCoUkUpdate1 sync = new SyncGetUpdateFeedParamsLinnCoUkUpdate1(this);
        beginGetUpdateFeedParams(sync.getListener());
        sync.waitToComplete();
        sync.reportError();

        return new GetUpdateFeedParams(
            sync.getTopic(),
            sync.getChannel()
        );
    }
    
    /**
     * Invoke the action asynchronously.
     * Returns immediately and will run the client-specified callback when the
     * action later completes.  Any output arguments can then be retrieved by
     * calling {@link #endGetUpdateFeedParams}.
     * 
     * @param aCallback listener to call back when action completes.
     *                  This is guaranteed to be run but may indicate an error.
     */
    public void beginGetUpdateFeedParams(ICpProxyListener aCallback)
    {
        Invocation invocation = iService.getInvocation(iActionGetUpdateFeedParams, aCallback);
        int outIndex = 0;
        invocation.addOutput(new ArgumentString((ParameterString)iActionGetUpdateFeedParams.getOutputParameter(outIndex++)));
        invocation.addOutput(new ArgumentString((ParameterString)iActionGetUpdateFeedParams.getOutputParameter(outIndex++)));
        iService.invokeAction(invocation);
    }

    /**
     * Retrieve the output arguments from an asynchronously invoked action.
     * This may only be called from the callback set in the
     * {@link #beginGetUpdateFeedParams} method.
     *
     * @param aAsyncHandle  argument passed to the delegate set in the
     *          {@link #beginGetUpdateFeedParams} method.
     * @return the result of the previously invoked action.
     */
    public GetUpdateFeedParams endGetUpdateFeedParams(long aAsyncHandle)
    {
        ProxyError errObj = Invocation.error(aAsyncHandle);
        if (errObj != null)
        {
            throw errObj;
        }
        int index = 0;
        String topic = Invocation.getOutputString(aAsyncHandle, index++);
        String channel = Invocation.getOutputString(aAsyncHandle, index++);
        return new GetUpdateFeedParams(
            topic,
            channel
        );
    }
        
    /**
     * Invoke the action synchronously.
     * Blocks until the action has been processed on the device and sets any
     * output arguments.
     *
     * @return the result of the invoked action.
     */
    public String syncGetUpdateStatus()
    {
        SyncGetUpdateStatusLinnCoUkUpdate1 sync = new SyncGetUpdateStatusLinnCoUkUpdate1(this);
        beginGetUpdateStatus(sync.getListener());
        sync.waitToComplete();
        sync.reportError();

        return sync.getUpdateStatus();
    }
    
    /**
     * Invoke the action asynchronously.
     * Returns immediately and will run the client-specified callback when the
     * action later completes.  Any output arguments can then be retrieved by
     * calling {@link #endGetUpdateStatus}.
     * 
     * @param aCallback listener to call back when action completes.
     *                  This is guaranteed to be run but may indicate an error.
     */
    public void beginGetUpdateStatus(ICpProxyListener aCallback)
    {
        Invocation invocation = iService.getInvocation(iActionGetUpdateStatus, aCallback);
        int outIndex = 0;
        invocation.addOutput(new ArgumentString((ParameterString)iActionGetUpdateStatus.getOutputParameter(outIndex++)));
        iService.invokeAction(invocation);
    }

    /**
     * Retrieve the output arguments from an asynchronously invoked action.
     * This may only be called from the callback set in the
     * {@link #beginGetUpdateStatus} method.
     *
     * @param aAsyncHandle  argument passed to the delegate set in the
     *          {@link #beginGetUpdateStatus} method.
     * @return the result of the previously invoked action.
     */
    public String endGetUpdateStatus(long aAsyncHandle)
    {
        ProxyError errObj = Invocation.error(aAsyncHandle);
        if (errObj != null)
        {
            throw errObj;
        }
        int index = 0;
        String updateStatus = Invocation.getOutputString(aAsyncHandle, index++);
        return updateStatus;
    }
        
    /**
     * Invoke the action synchronously.
     * Blocks until the action has been processed on the device and sets any
     * output arguments.
     */
    public void syncApply()
    {
        SyncApplyLinnCoUkUpdate1 sync = new SyncApplyLinnCoUkUpdate1(this);
        beginApply(sync.getListener());
        sync.waitToComplete();
        sync.reportError();
    }
    
    /**
     * Invoke the action asynchronously.
     * Returns immediately and will run the client-specified callback when the
     * action later completes.  Any output arguments can then be retrieved by
     * calling {@link #endApply}.
     * 
     * @param aCallback listener to call back when action completes.
     *                  This is guaranteed to be run but may indicate an error.
     */
    public void beginApply(ICpProxyListener aCallback)
    {
        Invocation invocation = iService.getInvocation(iActionApply, aCallback);
        iService.invokeAction(invocation);
    }

    /**
     * Retrieve the output arguments from an asynchronously invoked action.
     * This may only be called from the callback set in the
     * {@link #beginApply} method.
     *
     * @param aAsyncHandle  argument passed to the delegate set in the
     *          {@link #beginApply} method.
     */
    public void endApply(long aAsyncHandle)
    {
        ProxyError errObj = Invocation.error(aAsyncHandle);
        if (errObj != null)
        {
            throw errObj;
        }
    }
        
    /**
     * Invoke the action synchronously.
     * Blocks until the action has been processed on the device and sets any
     * output arguments.
     */
    public void syncRestore()
    {
        SyncRestoreLinnCoUkUpdate1 sync = new SyncRestoreLinnCoUkUpdate1(this);
        beginRestore(sync.getListener());
        sync.waitToComplete();
        sync.reportError();
    }
    
    /**
     * Invoke the action asynchronously.
     * Returns immediately and will run the client-specified callback when the
     * action later completes.  Any output arguments can then be retrieved by
     * calling {@link #endRestore}.
     * 
     * @param aCallback listener to call back when action completes.
     *                  This is guaranteed to be run but may indicate an error.
     */
    public void beginRestore(ICpProxyListener aCallback)
    {
        Invocation invocation = iService.getInvocation(iActionRestore, aCallback);
        iService.invokeAction(invocation);
    }

    /**
     * Retrieve the output arguments from an asynchronously invoked action.
     * This may only be called from the callback set in the
     * {@link #beginRestore} method.
     *
     * @param aAsyncHandle  argument passed to the delegate set in the
     *          {@link #beginRestore} method.
     */
    public void endRestore(long aAsyncHandle)
    {
        ProxyError errObj = Invocation.error(aAsyncHandle);
        if (errObj != null)
        {
            throw errObj;
        }
    }
        
    /**
     * Set a delegate to be run when the UpdateStatus state variable changes.
     * Callbacks may be run in different threads but callbacks for a
     * CpProxyLinnCoUkUpdate1 instance will not overlap.
     *
     * @param aUpdateStatusChanged   the listener to call back when the state
     *          variable changes.
     */
    public void setPropertyUpdateStatusChanged(IPropertyChangeListener aUpdateStatusChanged)
    {
        synchronized (iPropertyLock)
        {
            iUpdateStatusChanged = aUpdateStatusChanged;
        }
    }

    private void updateStatusPropertyChanged()
    {
        synchronized (iPropertyLock)
        {
            reportEvent(iUpdateStatusChanged);
        }
    }
    /**
     * Set a delegate to be run when the UpdateTopic state variable changes.
     * Callbacks may be run in different threads but callbacks for a
     * CpProxyLinnCoUkUpdate1 instance will not overlap.
     *
     * @param aUpdateTopicChanged   the listener to call back when the state
     *          variable changes.
     */
    public void setPropertyUpdateTopicChanged(IPropertyChangeListener aUpdateTopicChanged)
    {
        synchronized (iPropertyLock)
        {
            iUpdateTopicChanged = aUpdateTopicChanged;
        }
    }

    private void updateTopicPropertyChanged()
    {
        synchronized (iPropertyLock)
        {
            reportEvent(iUpdateTopicChanged);
        }
    }
    /**
     * Set a delegate to be run when the UpdateChannel state variable changes.
     * Callbacks may be run in different threads but callbacks for a
     * CpProxyLinnCoUkUpdate1 instance will not overlap.
     *
     * @param aUpdateChannelChanged   the listener to call back when the state
     *          variable changes.
     */
    public void setPropertyUpdateChannelChanged(IPropertyChangeListener aUpdateChannelChanged)
    {
        synchronized (iPropertyLock)
        {
            iUpdateChannelChanged = aUpdateChannelChanged;
        }
    }

    private void updateChannelPropertyChanged()
    {
        synchronized (iPropertyLock)
        {
            reportEvent(iUpdateChannelChanged);
        }
    }

    /**
     * Query the value of the UpdateStatus property.
     * This function is thread-safe and can only be called if {@link 
     * #subscribe} has been called and a first eventing callback received
     * more recently than any call to {@link #unsubscribe}.
     *
     * @return  value of the UpdateStatus property.
     */
    public String getPropertyUpdateStatus()
    {
        propertyReadLock();
        String val = iUpdateStatus.getValue();
        propertyReadUnlock();
        return val;
    }
    
    /**
     * Query the value of the UpdateTopic property.
     * This function is thread-safe and can only be called if {@link 
     * #subscribe} has been called and a first eventing callback received
     * more recently than any call to {@link #unsubscribe}.
     *
     * @return  value of the UpdateTopic property.
     */
    public String getPropertyUpdateTopic()
    {
        propertyReadLock();
        String val = iUpdateTopic.getValue();
        propertyReadUnlock();
        return val;
    }
    
    /**
     * Query the value of the UpdateChannel property.
     * This function is thread-safe and can only be called if {@link 
     * #subscribe} has been called and a first eventing callback received
     * more recently than any call to {@link #unsubscribe}.
     *
     * @return  value of the UpdateChannel property.
     */
    public String getPropertyUpdateChannel()
    {
        propertyReadLock();
        String val = iUpdateChannel.getValue();
        propertyReadUnlock();
        return val;
    }
    
    /**
     * Dispose of this control point proxy.
     * Must be called for each class instance.
     * Must be called before <tt>Library.close()</tt>.
     */
    public void dispose()
    {
        synchronized (this)
        {
            if (iHandle == 0)
            {
                return;
            }
            disposeProxy();
            iHandle = 0;
            iActionPushManifest.destroy();
            iActionSetUpdateFeedParams.destroy();
            iActionGetUpdateFeedParams.destroy();
            iActionGetUpdateStatus.destroy();
            iActionApply.destroy();
            iActionRestore.destroy();
            iUpdateStatus.destroy();
            iUpdateTopic.destroy();
            iUpdateChannel.destroy();
        }
    }
}

