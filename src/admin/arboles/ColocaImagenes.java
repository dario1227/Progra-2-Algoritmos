package admin.arboles;

import java.util.ArrayList;

import view.EView;

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
		x+=metodo.getProfundidad()*200;
		colocarMetodo(x,metodo.listaStatements,y);
	}
	EView.scroll.setMinSize(x+200,2000);
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
