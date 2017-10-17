package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

public class LineFactory {
public static Label crearLabel(String lugar,int x, int y,int largo, int alto) {
	if(lugar.equals("right")) {
		//return crearRightLabel(x,y,largo,alto);
	}
	if(lugar.equals("botton")) {
		System.out.println("SI ENTRE AQUI QOOOOOOOOOOOOOOOOOOOOOOO");
		return crearBottonLabel(x,y,largo,alto);
		}
	if(lugar.equals("left")) {
		//return crearLeftLabel(x,y,largo,alto);
	}
	return null;
}

//private Label crearLeftLabel(int x, int y, int largo, int alto) {
//	Label label = new Label(EView.canvas, SWT.CENTER);
//}

private static Label crearBottonLabel(int x, int y, int largo, int alto) {
	//parent
	System.out.println("SI ENTRE AQUI FFFFFFFFFFFFFFFFFAKFNQOOOOOOOOOOOOOOOOOOOOOOO");
	Label label = new Label(EView.canvas, SWT.CENTER);
	label.setBounds(x, y, largo, alto);
	label.setText("HHHHOOLAasasasasasas");
	return label;
}

//private Label crearRightLabel(int x, int y, int largo, int alto) {
//	
//}
}
