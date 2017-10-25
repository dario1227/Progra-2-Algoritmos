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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import admin.arboles.ColocaImagenes;
import admin.arboles.LeeGrafosAST;
import debugger.ClaseDebug;
import javafx.scene.shape.Line;
import view.Labels;
import view.LineFactory;
public class Ejecutar extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			try {
			}
			catch(Exception e) {
			}
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView("DiagramaFlojo.view1");
			Labels.dispose();
			LeeGrafosAST.saca();
			ColocaImagenes.colocarPrincipal();
		} catch (PartInitException e1) {
			e1.printStackTrace();
		} catch (JavaModelException e) {
			e.printStackTrace();
		} 
		return null;
	}
}