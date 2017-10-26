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
public void sacaMetodo() {
	try {
	for(StatementLabel estado :LeeGrafosAST.actuales ) {
		if(ConectedSearch.search(estado.listaStatements, ClaseDebug.leerdebug()-1).contains(true)) {
			if(!Metodo.equals(estado)) {
				ColocaImagenes.posY=0;
				Labels.dispose();
				ColocaImagenes.colocarMetodo(estado.getProfundidad()*200, estado.listaStatements, 0, estado);
			}
		}
	}
}catch(Exception e) {
	
}
}
//public StatementLabel SacaActual(){
//	try {
//	for(StatementLabel estado :LeeGrafosAST.actuales ) {
//		if(ConectedSearch.search(estado.listaStatements, ClaseDebug.leerdebug()-1).contains(true)) {
//			if(!Metodo.equals(estado)) {
//				
//			}
//		}
//	}
//}catch(Exception e) {
//	
//}
//	
//}
}
