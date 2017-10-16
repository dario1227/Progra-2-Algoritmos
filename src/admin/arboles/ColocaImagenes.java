package admin.arboles;

import java.util.ArrayList;

public class ColocaImagenes {
public static void colocarPrincipal() {
	StatementLabel actual =LeeGrafosAST.actuales.get(0);
	colocarPrincipaAux(actual);
}

private static void colocarPrincipaAux(StatementLabel actual) {
	int x=0;
	int y = 0;
	for(StatementLabel metodo:actual.listaStatements) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(metodo.getProfundidad());
		x+=metodo.getProfundidad()*100;
		colocarMetodo(x,metodo.listaStatements,y);
		x+=x+=metodo.getProfundidad()*100;
	}
	
}

private static int colocarMetodo(int x, ArrayList<StatementLabel> listaStatements, int y) {
	
	if(listaStatements.isEmpty()) {
		return y;
	}
	for(StatementLabel label : listaStatements) {
		label.labelsactual.setPos(x, y);
		if(label.listaStatements.isEmpty()) {
			y+=150;
		}
		else {
			y= colocarMetodo(x-200,label.listaStatements,y);
		}
	}
	return y;
}
}
