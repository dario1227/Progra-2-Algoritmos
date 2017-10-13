package view;

import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Labels {
	Image image=null;
	Image imageB=null;
	Label label=null;
	public Labels(Composite parent, int style,Image imagen,Comandos comando) {
		this.label=new Label(parent, SWT.CENTER);
		this.image=imagen;
	}
	public static void debuggerImage(Labels result) {
		Image imagenActual=result.label.getBackgroundImage();
		if(imagenActual==result.image) {
			result.label.setBackgroundImage(result.imageB);
		}
		
		else{
			result.label.setBackgroundImage(result.image);
		}		
	}

	public static Comandos toComando(Object object) {
		Comandos comando=null;
		if(object instanceof IfStatement ) {
			comando=Comandos.If;
		}
		if(object instanceof WhileStatement) {
			comando=Comandos.While;

		}
		if(object instanceof ForStatement || object instanceof EnhancedForStatement) {
			comando=Comandos.For;
		}
		if(object instanceof ExpressionStatement) {
			comando=Comandos.Accion;
		}
		return comando;
	}
}
