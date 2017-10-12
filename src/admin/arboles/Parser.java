package admin.arboles;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class Parser {
	public static void saca() throws JavaModelException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart activeEditor = page.getActiveEditor();
		ICompilationUnit root=null;
		if(activeEditor instanceof JavaEditor) {
		
		     root = (ICompilationUnit) EditorUtility.getEditorInputJavaElement(activeEditor, false);
		    
	}
		CompilationUnit compilado = parse(root);
		MethodVisitor visitante = new MethodVisitor();
		compilado.accept(visitante);}
	private static CompilationUnit parse(ICompilationUnit unit) {
	    ASTParser parser = ASTParser.newParser(AST.JLS3);
	    parser.setKind(ASTParser.K_COMPILATION_UNIT);
	    parser.setSource(unit);
	    parser.setResolveBindings(true);
	    return (CompilationUnit) parser.createAST(null); // parse
	}
}
