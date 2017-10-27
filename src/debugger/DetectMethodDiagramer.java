package debugger;

import org.eclipse.debug.core.DebugException;

import admin.arboles.ColocaImagenes;
import admin.arboles.LeeGrafosAST;
import admin.arboles.StatementLabel;
import diagramaflojo.ConectedSearch;
import view.EView;
import view.Labels;

public class DetectMethodDiagramer {
	public static StatementLabel Metodo = null;
public static void sacaMetodo() throws DebugException {

	for(StatementLabel estado :LeeGrafosAST.actuales ) {
		if(ConectedSearch.search(estado.listaStatements, ClaseDebug.leerdebug()-1).contains(true)) {
			if(Metodo == null) {
				Metodo = estado;
			//	ColocaImagenes.posY=0;
			//	System.out.println(estado);
			//	ColocaImagenes.colocarMetodo(estado.getProfundidad()*200, Metodo.listaStatements, 0, estado);
			}
			else if(!Metodo.equals(estado)) {
				Metodo = estado;
			//	ColocaImagenes.posY=0;
			//	ColocaImagenes.colocarMetodo(estado.getProfundidad()*200, estado.listaStatements, 0, estado);
			}
		}
		else {
			estado.hidePictures(estado.listaStatements);
		}
	}

}
public void DiagramaActual(){
	try {
	for(StatementLabel estado :LeeGrafosAST.actuales ) {
		if(ConectedSearch.search(estado.listaStatements, ClaseDebug.leerdebug()-1).contains(true)) {
			//ColocaImagenes.posY=0;
			
			//ColocaImagenes.colocarMetodo(estado.getProfundidad()*200, estado.listaStatements, 0, estado);
		}
	}
}catch(Exception e) {
	
}
	
}
}
