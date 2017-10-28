package view;

import org.eclipse.jdt.core.dom.EnhancedForStatement;

import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class Labels {
	Image image=null;
	Image imageB=null;
	public Label label=null;
	Canvas parent=null;
	public int x;
	public int y;
	public boolean active = false;
	static Composite parent2 = null;
	public Labels(Composite parent,Image imagen,Comandos comando) {
		parent2=parent;
		this.label=new Label(parent, SWT.CENTER);
		this.image=imagen;
		this.parent=null;
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
			return comando;
		}
		else if(object instanceof WhileStatement) {
			comando=Comandos.While;
			return comando;

		}
		else if(object instanceof ForStatement || object instanceof EnhancedForStatement) {
			comando=Comandos.For;
			return comando;
		}
		else if(object instanceof ExpressionStatement) {
			comando=Comandos.Accion;
			return comando;
		}
		else {
			comando = Comandos.Accion;
		}
		return comando;
	}
	public static void clear() {
		Canvas varuable = EView.canvas;
		Control[] hijos=varuable.getChildren();
		for(int i=0;i<hijos.length;i++) {
			hijos[i].setVisible(false);
		}}
	public static void show() {
		Canvas varuable = EView.canvas;
		Control[] hijos=varuable.getChildren();
		for(int i=0;i<hijos.length;i++) {
			hijos[i].setVisible(true);
		}}
	public static void dispose() {
			Canvas varuable = EView.canvas;
			Control[] hijos=varuable.getChildren();
			for(int i=0;i<hijos.length;i++) {
				hijos[i].dispose();
		}
	}
	public void setPos(int x, int y) {
		this.x=x;
		this.y=y;
		this.label.setBounds(x, y, 150, 80);
	}
//	public  void setPos(Label label, int x, int y) {
//		this.x=x;
//		this.y=y;
//		label.setBounds(x, y,150, 80);
//	}
	public void hide() {
		this.label.setVisible(false);
		
	}
}
