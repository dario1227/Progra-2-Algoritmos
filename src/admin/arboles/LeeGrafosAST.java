package admin.arboles;
import java.util.ArrayList;
import java.util.List;

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
@SuppressWarnings({ "restriction" })
public class LeeGrafosAST {
	public static List<StatementLabel> actuales = new ArrayList<StatementLabel>();
/**
 * Esta clase lo que saca es el compilation Unit y los metodos de la clase actual en el workbench
 * @throws JavaModelException
 */
public static void saca() throws JavaModelException {
	try {
	actuales = new ArrayList<StatementLabel>();
	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	IEditorPart activeEditor = page.getActiveEditor();
	ICompilationUnit root=null;
	if(activeEditor instanceof JavaEditor) {
	
	     root = (ICompilationUnit) EditorUtility.getEditorInputJavaElement(activeEditor, false);
	    
}
	CompilationUnit compilado = parse(root);
	MethodVisitor visitante = new MethodVisitor();
	compilado.accept(visitante);
	revisaContenido(visitante.methods);
	}
	catch(Exception e) {}
}
/**
 * Llama funcion que descompone los metodos
 * @param methods
 */
private static void revisaContenido(List<MethodDeclaration> methods) {
	StatementLabel origen = new StatementLabel(null);
	actuales.add(origen);
	for(MethodDeclaration metodo:methods) {
		StatementLabel lista = new StatementLabel(null);
		origen.listaStatements.add(lista);
		descomponedor(metodo.getBody().statements(),lista.listaStatements);
	}
	
}
/**
 * Agarra una lista de statements, pero no hace nada si recibe algo vacio
 * @param statements
 * @param listaStatements 
 */
private static void descomponedor(List<?> statements, ArrayList<StatementLabel> listaStatements) {
	if(!statements.isEmpty()) {
		int indice = 0;

	while(indice<statements.size()) {
		StatementLabel estado =new StatementLabel((Statement) statements.get(indice));
		listaStatements.add(estado);
		System.out.println("__________________________________________________________________________________");
		System.out.println(statements.get(indice).getClass());
		System.out.println(statements.get(indice));
		System.out.println("__________________________________________________________________________________");

		try {
			
			descomponedorAux(statements.get(indice),estado.listaStatements);
			
		}catch(Exception e) {
			System.out.println("No body");
		}
		indice++;
	}
	
	}
	else {
		System.out.println("No body");
	}
	
}
/**
 * Este es el caso de que el Statement tiene hijos
 * @param object
 * @param listaStatements 
 */
private static void descomponedorAux(Object object, ArrayList<StatementLabel> listaStatements) {
	if(object instanceof IfStatement ) {
		descomponedor(((Block) ((IfStatement) object).getThenStatement()).statements(),listaStatements);}
	if(object instanceof WhileStatement) {
		descomponedor(((Block) ((WhileStatement) object).getBody()).statements(),listaStatements);
	}
	if(object instanceof ForStatement) {
		descomponedor(((Block) ((ForStatement) object).getBody()).statements(),listaStatements);
		
	}
	if(object instanceof EnhancedForStatement) {
		descomponedor(((Block) ((EnhancedForStatement) object).getBody()).statements(),listaStatements);
	}
}
/**
 * Me da el compilation Unit
 * @param unit
 * @return
 */
private static CompilationUnit parse(ICompilationUnit unit) {
    @SuppressWarnings("deprecation")
	ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(unit);
    parser.setResolveBindings(true);
    return (CompilationUnit) parser.createAST(null); // parse
}

}
