package debugger;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import admin.arboles.LeeGrafosAST;
public class CompilationListener {
public static boolean compruebaCompilated() {
	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	IEditorPart activeEditor = page.getActiveEditor();
	ICompilationUnit root=null;
	if(activeEditor instanceof JavaEditor) {
	
	     root = (ICompilationUnit) EditorUtility.getEditorInputJavaElement(activeEditor, false);
	    
}
	CompilationUnit compilado = LeeGrafosAST.parse(root);
	return compilado.equals(LeeGrafosAST.unit);
}
}
