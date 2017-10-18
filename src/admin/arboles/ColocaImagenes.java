package admin.arboles;

import java.util.ArrayList;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
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
		colocarMetodo(x-130,metodo.listaStatements,y,null);
		x+=50;
	}
	EView.scroll.setMinSize(x+200,posY);
}

private static int colocarMetodo(int x, ArrayList<StatementLabel> listaStatements, int y,StatementLabel padre) {
	
	if(listaStatements.isEmpty()) {
		return y;
	}
	for(StatementLabel label : listaStatements) {
		
		label.labelsactual.setPos(x, y);
		LineHelper(x,y,padre,listaStatements,label);
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
			y= colocarMetodo(x-200,label.listaStatements,y,label);
			if(listaStatements.get(listaStatements.size()-1).equals(label)) {}
			else {
			label.lineas.add(LineFactory.crearLabel("botton", x+90, aux, 10, y-aux));}
		//adad	//Ho;a
		}
		setY(y);
	}
	
	return y;
}

private static void LineHelper(int x, int y, StatementLabel padre, ArrayList<StatementLabel> listaStatements, StatementLabel label) {
	if(padre==null) {
		return;
	}
	if(padre.statement instanceof ForStatement || padre.statement instanceof WhileStatement ||padre.statement instanceof EnhancedForStatement  ) {
		if(padre.listaStatements.get(padre.listaStatements.size()-1).equals(label)) {
			label.lineas.add(LineFactory.crearLabel("left",x,y+40,200,5));
			label.lineas.add(LineFactory.crearLabel("botton",x+200,padre.labelsactual.y,10,y-padre.labelsactual.y+45));
		}
	}
	
}
@SuppressWarnings("unused")
private static void MetodoAux(StatementLabel metodo) {
	int x=metodo.getProfundidad();
	int y = 0;
	colocarMetodo(x-130,metodo.listaStatements,y,null);
}
}
