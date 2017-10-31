package diagramaflojo;

/*
 * Metodo al darle click a ejecutar
 * (en las extensiones del plugin, hay varios, son como las clases del GUI 
 * que se mostrara en eclipse, como el toolbar o el view)
 */
import org.eclipse.core.commands.AbstractHandler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import Listeners.DebuggerListener;
import admin.arboles.ColocaImagenes;
import admin.arboles.LeeGrafosAST;
import debugger.ClaseDebug;
import javafx.scene.shape.Line;
import view.Labels;
import view.LineFactory;
public class Ejecutar extends AbstractHandler{
public static Thread ejecutando;
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(ejecutando!=null) {
			ejecutando.stop();
		}
		try {
			try {
			}
			catch(Exception e) {
			}
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView("DiagramaFlojo.view1");
			Labels.dispose();
			LeeGrafosAST.saca();
			ColocaImagenes.posY=0;
			DebuggerListener.running=true;
			ColocaImagenes.colocarPrincipal();
//		ConectedSearch.search(LeeGrafosAST.actuales, ClaseDebug.leerdebug()-1);
			ejecutando = new Thread(new Runnable() {
			      public void run() {
			         while (true) {
			            try { Thread.sleep(500); } catch (Exception e) { }
			            Display.getDefault().asyncExec(new Runnable() {
			               public void run() {
			            	   try {
								DebuggerListener.activado();
							} catch (DebugException | JavaModelException e) {
								e.printStackTrace();
							}
			               }
			            });
			         }
			      }
			   }); 
			ejecutando.start();
			}
		
			catch (PartInitException e1) {
			e1.printStackTrace();
		} catch (JavaModelException e) {
			e.printStackTrace();
//	} catch (DebugException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} 
		return null;
	}
}