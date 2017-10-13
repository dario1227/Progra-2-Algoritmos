package admin.arboles;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
public class ObtieneBody {
	/**
	 * Optiene el block de un metodo externo al hacer un step in 
	 * @param node
	 * @return
	 */
public static Block optieneExterno(MethodInvocation node) {
	IMethodBinding binding = (IMethodBinding) node.getName().resolveBinding();
	ICompilationUnit unit = (ICompilationUnit) binding.getJavaElement().getAncestor( IJavaElement.COMPILATION_UNIT );
	if ( unit == null ) {
	   // not available, external declaration
	}
	@SuppressWarnings("deprecation")
	ASTParser parser = ASTParser.newParser( AST.JLS8 );
	parser.setKind( ASTParser.K_COMPILATION_UNIT );
	parser.setSource( unit );
	parser.setResolveBindings( true );
	CompilationUnit cu = (CompilationUnit) parser.createAST( null );
	MethodDeclaration decl = (MethodDeclaration)cu.findDeclaringNode( binding.getKey() );
	return decl.getBody();
}
}
