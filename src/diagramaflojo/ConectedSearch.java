package diagramaflojo;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.IfStatement;

import admin.arboles.LeeGrafosAST;
import admin.arboles.StatementLabel;
import view.Labels;

public class ConectedSearch {

public static ArrayList<Boolean> search(List<StatementLabel> actuales, int numero){
	if(numero == 0 || actuales == null) {
		return new ArrayList<Boolean>();
	}
	ArrayList<Boolean> boleans = new ArrayList<Boolean>();
	for(StatementLabel estado:actuales) {
		if(estado.statement!=null) {
			if(estado.statement instanceof IfStatement) {
				if(estado.listaElse != null && !estado.listaElse.isEmpty()) {
					searchAux(estado.listaElse,  boleans, numero);
				}
					
			}
			if(estado.labelsactual.active==true) {
				estado.labelsactual.active=false;
				Labels.debuggerImage(estado.labelsactual);
			}
		if(LeeGrafosAST.unit.getLineNumber(estado.statement.getStartPosition()) - 1==numero) {
			
			if(estado.labelsactual.active==false) {
				boleans.add(true);
				estado.labelsactual.active = true;
				Labels.debuggerImage(estado.labelsactual);
			}
			
		}
		
		}
//		if(estado.statement instanceof IfStatement) {
//			if(estado.listaElse !=null) {
//				if(!estado.listaElse.isEmpty()) {
//					searchAux(estado.listaElse,boleans,numero);
//				}
//			}
//		}
		searchAux(estado.listaStatements,boleans,numero);
		}
	return boleans;
}

private static void searchAux(ArrayList<StatementLabel> listaStatements, ArrayList<Boolean> boleans, int numero) {
	for(StatementLabel estado:listaStatements) {
		if(estado.statement!=null) {
			if(estado.statement instanceof IfStatement) {
				if(estado.listaElse != null && !estado.listaElse.isEmpty()) {
					searchAux(estado.listaElse,  boleans, numero);
				}
					
			}
			if(estado.labelsactual.active==true) {
				estado.labelsactual.active=false;
				try {
				Labels.debuggerImage(estado.labelsactual);}catch(Exception e) {
					
				}
			}
		if(LeeGrafosAST.unit.getLineNumber(estado.statement.getStartPosition()) - 1==numero) {
			
			if(estado.labelsactual.active==false) {
				estado.labelsactual.active = true;
				boleans.add(true);
				Labels.debuggerImage(estado.labelsactual);
			}
			
		}
		
		}		
//		if(estado.statement instanceof IfStatement) {
//			if(estado.listaElse !=null) {
//				if(!estado.listaElse.isEmpty()) {
//					searchAux(estado.listaElse,boleans,numero);
//				}
//			}
//		}
		searchAux(estado.listaStatements,boleans,numero);
		}
	return ;
}
public static ArrayList<Boolean> search2(List<StatementLabel> actuales, int numero){
	if(numero == 0 || actuales == null) {
		return new ArrayList<Boolean>();
	}
	ArrayList<Boolean> boleans = new ArrayList<Boolean>();
	for(StatementLabel estado:actuales) {

		
		if(estado.statement!=null) {
			if(estado.statement instanceof IfStatement) {
				if(estado.listaElse != null && !estado.listaElse.isEmpty()) {
					searchAux2(estado.listaElse,  boleans, numero);
				}
					
			}
			if(estado.labelsactual.active==true) {
	

			}
		if(LeeGrafosAST.unit.getLineNumber(estado.statement.getStartPosition()) - 1==numero) {
			
			if(estado.labelsactual.active==false) {
				boleans.add(true);
	
			}
			
		}
		
		if(estado.statement instanceof IfStatement) {
			if(estado.listaElse !=null) {
				if(!estado.listaElse.isEmpty()) {
					searchAux2(estado.listaElse,boleans,numero);
				}
			}
		}
		}
		searchAux2(estado.listaStatements,boleans,numero);
		}
	return boleans;
}
private static void searchAux2(ArrayList<StatementLabel> listaStatements, ArrayList<Boolean> boleans, int numero) {
	for(StatementLabel estado:listaStatements) {
		if(estado.statement!=null) {
			if(estado.statement instanceof IfStatement) {
				if(estado.listaElse != null && !estado.listaElse.isEmpty()) {
					searchAux2(estado.listaElse,  boleans, numero);
				}
					
			}
			if(estado.labelsactual.active==true) {
			}
		if(LeeGrafosAST.unit.getLineNumber(estado.statement.getStartPosition()) - 1==numero) {
			
			if(estado.labelsactual.active==false) {
				boleans.add(true);
			}
			
		}
		
		}
//		if(estado.statement instanceof IfStatement) {
//			if(estado.listaElse !=null) {
//				if(!estado.listaElse.isEmpty()) {
//					searchAux2(estado.listaElse,boleans,numero);
//				}
//			}
//		}
		searchAux2(estado.listaStatements,boleans,numero);
		}
	return ;
}
}
