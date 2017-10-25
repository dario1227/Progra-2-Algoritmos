package debugger;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IThread;

public class ClaseDebug {
public static void leerdebug() throws DebugException {
	DebugPlugin plugin = DebugPlugin.getDefault();
    ILaunchManager manager = plugin.getLaunchManager();
    IDebugTarget[] target = manager.getDebugTargets();
    System.out.println(target[0].getThreads()[0]);
    int x = 0;
    System.out.println("EL NUMERO FUE"+ target[0].getThreads()[4].getStackFrames()[0]);
    for(IThread stack: target[0].getThreads() ) {
    	try {
    		if(stack.getStackFrames()[0].getLineNumber()==5) {
    			System.out.println(x);
    		}
    		System.out.println(stack.getStackFrames()[0].getLineNumber());
    	}catch(Exception e)
    	{}
    	x++;
    }
}
}
