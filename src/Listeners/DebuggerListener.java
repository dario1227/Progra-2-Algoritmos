package Listeners;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.widgets.Display;

import admin.arboles.ColocaImagenes;
import admin.arboles.LeeGrafosAST;
import debugger.ClaseDebug;
import debugger.CompilationListener;
import debugger.DetectMethodDiagramer;
import debugger.MetodoActualConseguir;
import diagramaflojo.ConectedSearch;
import view.EView;
import view.Labels;

public class DebuggerListener implements Runnable {
	public static boolean running = false;
	@Override
	public void run() {
		try {
			if (running == true) {
		boolean first = false;
		while(true) {
			this.activado();
			Thread.sleep(1000);
		}
			}
			}catch(Exception e) {
				e.printStackTrace();
				Display.getDefault().syncExec(new DebuggerListener());
				
	}
	
	}
	public static void activado() throws DebugException, JavaModelException {
	
		int x = ClaseDebug.leerdebug();
		System.out.println(x);
		int w = x;
		System.out.println(x);
		if(w > 0) {
			
			System.out.println("LOOOOOOOOOOOOOOOL");
			
			if(CompilationListener.compruebaCompilated()==false) {
//				Labels.dispose();
//				LeeGrafosAST.saca();
//				ColocaImagenes.colocarPrincipal();
//				System.out.println("ESTOY EN EL  THREAD MAE QUE THREAD NUEVOOOOOOOO");
			
				MetodoActualConseguir.diagramar();
				EView.scroll.setMinSize(MetodoActualConseguir.actual.getProfundidad()*200+200+200,ColocaImagenes.posY);
				ConectedSearch.search(MetodoActualConseguir.actual.listaStatements, ClaseDebug.leerdebug()-1).contains(true);
				}
			
			else {
				try {
			if(MetodoActualConseguir.actual!=null) {
			if(ConectedSearch.search(MetodoActualConseguir.actual.listaStatements, ClaseDebug.leerdebug()-1).contains(true)) {
			
			}
			else {
				MetodoActualConseguir.diagramar();
				EView.scroll.setMinSize(MetodoActualConseguir.actual.getProfundidad()*200+200,ColocaImagenes.posY);
				ConectedSearch.search(LeeGrafosAST.actuales, ClaseDebug.leerdebug()-1).contains(true);

			}
			}
				else {
					MetodoActualConseguir.diagramar();
					EView.scroll.setMinSize(MetodoActualConseguir.actual.getProfundidad()*200+200,ColocaImagenes.posY);
					ConectedSearch.search(LeeGrafosAST.actuales, ClaseDebug.leerdebug()-1).contains(true);
				}
				}catch(Exception e) {
					MetodoActualConseguir.diagramar();
				}
			}
			}
	
	}
}
