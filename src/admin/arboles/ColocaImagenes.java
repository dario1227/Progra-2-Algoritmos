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
	public static int posY=0;
private static void  setY(int y) {
	if(posY<y) {
		posY=y;
	}
}
public static void colocarPrincipal() {

	StatementLabel actual =LeeGrafosAST.actuales.get(0);
	colocarPrincipaAux(actual);
}
/**
 * Coloca el diagrama principal
 * @param actual
 */
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
/**
 * Coloca un metodo en especifico
 * @param x
 * @param listaStatements
 * @param y
 * @param padre
 * @return
 */
public static int colocarMetodo(int x, ArrayList<StatementLabel> listaStatements, int y,StatementLabel padre) {
	
	if(listaStatements.isEmpty()) {
		System.out.println("LOL NO HABIA NADA");
		return y;
	}
	for(StatementLabel label : listaStatements) {
		
		label.labelsactual.setPos(x, y);
		LineHelper(x,y,padre,listaStatements,label);
		if(label.listaStatements.isEmpty()) {
			
			if(listaStatements.get(listaStatements.size()-1).equals(label)) {}
			else {
			label.lineas.add(LineFactory.crearLabel("botton", x+73, y+80, 10, 150));}
			y+=150;
			if(label.statement instanceof IfStatement && !label.listaElse.isEmpty()) {
				y+=colocarElse(label.listaElse,x,y,label.listaStatements.isEmpty(),label.equals(listaStatements.get(listaStatements.size()-1)))-y;
				setY(y);
				//LOL
			}
			
			//lololol
		}
		else {
			label.lineas.add(LineFactory.crearLabel("left", x-200, y+40, 200, 5));
			int aux = y;
			y= colocarMetodo(x-200,label.listaStatements,y,label);
			if(label.statement instanceof IfStatement ) {
				int auxiliar2 = y;
				if(label.listaElse != null) {
				if(!label.listaElse.isEmpty()) {
					System.out.println("ENCONTRE EL IF LPM");
					int auxiliar = y;
					colocarElse(label.listaElse,x,aux+150,label.listaStatements.isEmpty(),label.equals(listaStatements.get(listaStatements.size()-1)));
					if(y-aux <label.listaElse.size()*150 ) {
						
						y = aux+label.listaElse.size()*150 + 150;
						setY(y);
						label.lineas.add(LineFactory.crearLabel("botton", x-127, auxiliar-150, 10, y-auxiliar+90));
						label.lineas.add(LineFactory.crearLabel("left", x-127, y-60, 200, 5));
						label.lineas.add(LineFactory.crearLabel("botton", x+73, y-150+80, 10, 15));
					}
					else if(y-aux !=label.listaElse.size()*150){
						System.out.println("SOY MAYOR");
						setY(y);
						label.lineas.add(LineFactory.crearLabel("botton", x+73, label.listaElse.get(label.listaElse.size()-1).labelsactual.y+80 , 10, y-(label.listaElse.get(label.listaElse.size()-1).labelsactual.y +150 )));
						
						label.lineas.add(LineFactory.crearLabel("botton", x-127, label.labelsactual.y+80, 10, y-label.labelsactual.y-140));
						label.lineas.add(LineFactory.crearLabel("left", x-127, y-60, 200, 5));
						label.lineas.add(LineFactory.crearLabel("botton", x+73, y-150+80, 10, 15));
					}
					else {
						setY(y);
						label.lineas.add(LineFactory.crearLabel("botton", x+73, label.listaElse.get(label.listaElse.size()-1).labelsactual.y+80 , 10, y-(label.listaElse.get(label.listaElse.size()-1).labelsactual.y +150 )));
						label.lineas.add(LineFactory.crearLabel("botton", x-127, auxiliar-150, 10, y-auxiliar+90+150));
						label.lineas.add(LineFactory.crearLabel("left", x-127, y-60+150, 200, 5));
						label.lineas.add(LineFactory.crearLabel("botton", x+73, y+80, 10, 15));
						y+=150;
					}
				}
				else {
					label.lineas.add(LineFactory.crearLabel("botton", x-127, y-150, 10, 90));
					label.lineas.add(LineFactory.crearLabel("left", x-127, y-60, 200, 5));
					label.lineas.add(LineFactory.crearLabel("botton", x+73, aux-150+95, 10, y-aux));
					}
				}
				else {
				label.lineas.add(LineFactory.crearLabel("botton", x-127, y-150, 10, 90));
				label.lineas.add(LineFactory.crearLabel("left", x-127, y-60, 200, 5));
				label.lineas.add(LineFactory.crearLabel("botton", x+73, aux+80, 10, y-aux-135));
				}
			}
			if(listaStatements.get(listaStatements.size()-1).equals(label)) {}
			else {
			label.lineas.add(LineFactory.crearLabel("botton", x+73, aux, 10, y-aux));}
		//adad	//Ho;a
		}
		//Marca para el if statement aqui pondre que se compruebe si es y que retorne otro if en caso de que lo sea :D
		setY(y+150);
	}
	
	return y;
}
private static int colocarElse(ArrayList<StatementLabel> listaElse, int x, int y, boolean tienehijos, boolean ultima) {
	int aux = y;
	int j = 0;
	for(StatementLabel estado : listaElse) {
		if(!ultima) {
			estado.labelsactual.setPos(x, y);
			estado.lineas.add(LineFactory.crearLabel("botton", x+73, y-80, 10, 150));
			y+=150;
			estado.lineas.add(LineFactory.crearLabel("botton", x+73, y-80, 10, 150));
		}
		
		if(ultima) {
			if(j==0) {
				estado.lineas.add(LineFactory.crearLabel("botton", x+73, y-80, 10, 150));
				j++;
			}
			if(!estado.equals(listaElse.get(listaElse.size()-1))) {
			estado.lineas.add(LineFactory.crearLabel("botton", x+73, y+80, 10, 150));
			}
			estado.labelsactual.setPos(x, y);
			y+=150;
		}
//		estado.labelsactual.setPos(x, y);
//		y+=150;
	}
 return y;
}
/**
 * ayuda a colocar las lineas en caso de un if
 * @param x
 * @param y
 * @param padre
 * @param listaStatements
 * @param label
 */
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
