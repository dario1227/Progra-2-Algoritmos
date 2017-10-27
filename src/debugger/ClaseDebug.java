package debugger;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IThread;

public class ClaseDebug {
public static int leerdebug() throws DebugException {
	try {
	DebugPlugin plugin = DebugPlugin.getDefault();
    ILaunchManager manager = plugin.getLaunchManager();
    IDebugTarget[] target = manager.getDebugTargets();
//    System.out.println(target[0].getThreads()[4].getStackFrames()[0].getLineNumber());
    return  target[0].getThreads()[4].getStackFrames()[0].getLineNumber();

//    int x = 0;
//    
//    for(IThread stack: target[0].getThreads() ) {
//    	System.out.println(x);
//    	try {
//    		 return  target[0].getThreads()[4].getStackFrames()[0].getLineNumber();
//    	}catch(Exception e)
//    	{
//    		return 0;
//    	}
//  
//
//    }
    }catch(Exception e ){
    	return 0;
    }
}
}
