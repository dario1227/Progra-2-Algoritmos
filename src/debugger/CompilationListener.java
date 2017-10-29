package debugger;

import java.util.ArrayList;

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

import admin.arboles.LeeGrafosAST;
import admin.arboles.MethodVisitor;
import admin.arboles.StatementLabel;
public class CompilationListener {
@SuppressWarnings("restriction")
public static boolean compruebaCompilated() throws JavaModelException {
	try {
	CompilationUnit compilado = saca();
	System.out.println(compilado.getClass().getName());
	System.out.println(LeeGrafosAST.unit.getClass().getName());
	return compilado.getJavaElement().getElementName().equals(LeeGrafosAST.unit.getJavaElement().getElementName());
	}catch(Exception e) {
		return false;
	}
}
public static CompilationUnit saca() throws JavaModelException {
	try {
	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	IEditorPart activeEditor = page.getActiveEditor();
	ICompilationUnit root=null;
	if(activeEditor instanceof JavaEditor) {
	
	     root = (ICompilationUnit) EditorUtility.getEditorInputJavaElement(activeEditor, false);
	    
}
	CompilationUnit compilado = parse(root);
	return compilado;
	}
	catch(Exception e) {
		System.out.println("MAE ME CAGOOOOOOOOOOOOOOOOOOOOOOOOO 2");
	}
	return null;
}
public static CompilationUnit parse(ICompilationUnit unit) {
    @SuppressWarnings("deprecation")
	ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(unit);
    parser.setResolveBindings(true);
    return (CompilationUnit) parser.createAST(null); // parse
}
}
