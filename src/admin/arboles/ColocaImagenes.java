package admin.arboles;

import java.util.ArrayList;

import view.EView;
import view.LineFactory;

public class ColocaImagenes {
	private static int posY=0;
private static void  setY(int y) {
	if(posY<y) {
		posY=y;
	}
}
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
		colocarMetodo(x-130,metodo.listaStatements,y);
		x+=50;
	}
	EView.scroll.setMinSize(x+200,posY);
}

private static int colocarMetodo(int x, ArrayList<StatementLabel> listaStatements, int y) {
	
	if(listaStatements.isEmpty()) {
		return y;
	}
	for(StatementLabel label : listaStatements) {
		
		label.labelsactual.setPos(x, y);
		if(label.listaStatements.isEmpty()) {
			if(listaStatements.get(listaStatements.size()-1).equals(label)) {}
			else {
			label.lineas.add(LineFactory.crearLabel("botton", x+75, y+80, 10, 150));}
			y+=150;
			//LOL
			//lololol
		}
		else {
			label.lineas.add(LineFactory.crearLabel("left", x-200, y+40, 200, 5));
			int aux = y;
			y= colocarMetodo(x-200,label.listaStatements,y);
			if(listaStatements.get(listaStatements.size()-1).equals(label)) {}
			else {
			label.lineas.add(LineFactory.crearLabel("botton", x+90, aux, 10, y-aux));}
			//Ho;a
		}
		setY(y);
	}
	
	return y;
}
private static void MetodoAux(StatementLabel metodo) {
	int x=metodo.getProfundidad();
	int y = 0;
	colocarMetodo(x-130,metodo.listaStatements,y);
}
}
