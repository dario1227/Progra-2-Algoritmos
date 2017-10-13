package admin.arboles;
import java.util.List;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
@SuppressWarnings({ "unused", "restriction" })
public class LeeGrafosAST {

public static void saca() throws JavaModelException {
	try {
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
private static void revisaContenido(List<MethodDeclaration> methods) {
	for(MethodDeclaration metodo:methods) {
		descomponedor(metodo.getBody().statements());
	}
	
}
private static void descomponedor(List statements) {
	if(!statements.isEmpty()) {
		int indice = 0;
	while(indice<statements.size()) {
		System.out.println("__________________________________________________________________________________");
		System.out.println(statements.get(indice).getClass());
		System.out.println(statements.get(indice));
		System.out.println("__________________________________________________________________________________");

		try {
			
			descomponedorAux(statements.get(indice));
			
		}catch(Exception e) {
			System.out.println("error");
		}
		indice++;
	}
	
	}
	else {
		System.out.println("error");
	}
	
}
private static void descomponedorAux(Object object) {
	if(object instanceof IfStatement ) {
		descomponedor(((Block) ((IfStatement) object).getThenStatement()).statements());}
	if(object instanceof WhileStatement) {
		descomponedor(((Block) ((WhileStatement) object).getBody()).statements());
	}
	if(object instanceof ForStatement) {
		descomponedor(((Block) ((ForStatement) object).getBody()).statements());
		
	}
	if(object instanceof EnhancedForStatement) {
		descomponedor(((Block) ((EnhancedForStatement) object).getBody()).statements());
	}
	if(object instanceof ExpressionStatement) {
		System.out.println("LA expresione s de tipo");
System.out.println(((ExpressionStatement) object).getExpression());
//(ExpressionStatement) object).getExpression() da un methodInvocation

	}
}

private static CompilationUnit parse(ICompilationUnit unit) {
    ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(unit);
    parser.setResolveBindings(true);
    return (CompilationUnit) parser.createAST(null); // parse
}

}
