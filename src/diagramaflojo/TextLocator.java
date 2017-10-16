package diagramaflojo;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IPersistableSourceLocator;
import org.eclipse.debug.core.model.IStackFrame;

import debugger.TextStackFrame;

public class TextLocator implements IPersistableSourceLocator {

	@Override
	public Object getSourceElement(IStackFrame stackFrame) {
		  if (stackFrame instanceof TextStackFrame)
			try {
				return ((TextStackFrame) stackFrame).getSourceFile();
			} catch (DebugException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public String getMemento() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeFromMemento(String memento) throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeDefaults(ILaunchConfiguration configuration) throws CoreException {
		// TODO Auto-generated method stub

	}

}
