package debugger;

import java.util.ArrayList;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jdt.core.JavaModelException;

import admin.arboles.ColocaImagenes;
import admin.arboles.LeeGrafosAST;
import admin.arboles.StatementLabel;
import diagramaflojo.ConectedSearch;
import view.Labels;

public class MetodoActualConseguir {
	public static StatementLabel actual=null;
public static void diagramar() throws DebugException, JavaModelException {
	LeeGrafosAST.saca();
	 ArrayList<StatementLabel> lista = LeeGrafosAST.actuales.get(0).listaStatements;
	for(StatementLabel state : lista) {
		if(ConectedSearch.search2(state.listaStatements, ClaseDebug.leerdebug()-1).contains(true)) {
			if(state.equals(actual)) {
				
			}
			else {
				actual=state;
				ColocaImagenes.colocarMetodo(state.getProfundidad()*200, state.listaStatements, 0, null);
			}
		}
		else {
			
		}
	}
}
private static void ocultatodo(StatementLabel actual2, ArrayList<StatementLabel> lista) {
	
}
}
