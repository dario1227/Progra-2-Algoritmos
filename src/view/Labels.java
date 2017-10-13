package view;

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
}
