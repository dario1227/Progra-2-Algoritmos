package debugger;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

	public class TextStackFrame extends DebugElement  implements IStackFrame {

	 private final IThread mThread;
	 private int mLineNumber = 1;

	 public TextStackFrame(IDebugTarget target, IThread thread) {
	  super(target);
	  mThread = thread;
	 }

	 @Override
	 public IThread getThread() {
	  return mThread;
	 }

	 @Override
	 public IVariable[] getVariables() {
	  return new IVariable[0];
	 }

	 @Override
	 public boolean hasVariables() {
	  return getVariables().length > 0;
	 }

	 @Override
	 public int getLineNumber() {
	  return mLineNumber;
	 }

	 @Override
	 public int getCharStart() {
	  return -1;
	 }

	 @Override
	 public int getCharEnd() {
	  return -1;
	 }

	 @Override
	 public String getName() throws DebugException {
	  return getSourceFile() + ", line " + getLineNumber();
	 }

	 @Override
	 public IRegisterGroup[] getRegisterGroups() {
	  return new IRegisterGroup[0];
	 }

	 @Override
	 public boolean hasRegisterGroups() {
	  return getRegisterGroups().length > 0;
	 }

	 public void setLineNumber(int lineNumber) {
	  mLineNumber = lineNumber;
	 }

	 public String getSourceFile() throws DebugException {
	  return getDebugTarget().getName();
	 }

	@Override
	public String getModelIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDebugTarget getDebugTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILaunch getLaunch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canStepInto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canStepOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canStepReturn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStepping() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stepInto() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepOver() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepReturn() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canResume() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSuspend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSuspended() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resume() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suspend() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canTerminate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void terminate() throws DebugException {
		// TODO Auto-generated method stub
		
	}	
}

