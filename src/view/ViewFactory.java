package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import view.Comandos;
public class ViewFactory {
	/*
	 * clas siempre es el mismo
	 * comando es el tipo del enum creado
	 * el canvas será el mismo siempre
	 * el name, es el texto del label
	 * y x y Y con las posiciones respectivas
	 * me retorna un label configurado, ya con posicion, texto, menu e imagen correspondiente
	 */
	public static Label getGrafic(Class<? extends EView> clas,Comandos type,Canvas parent,String name,int x, int y) {
		Display display = Display.getCurrent();
		Label result=new Label(parent, SWT.CENTER);
		result.setText("\n"+"\n"+name);
		result.setBounds(x,y,150,80);
		Menu menu=new Menu(result);
		MenuItem step=new MenuItem(menu, SWT.PUSH);
		step.setText("Step In");
		Image imagen=null;
		
		 step.addListener(SWT.Selection, new Listener()
		    {
		        @Override
		        public void handleEvent(Event event)
		        {
		        	Control[] hijos=parent.getChildren();
		        	int size=hijos.length;
		        	for(int i=0;i<size;i++) {
		        		hijos[i].dispose();
		        	}
		        }
		    });
		if(type==Comandos.For) {
			imagen=new Image(display, clas.getResourceAsStream("For.png"));
		}
		else if(type==Comandos.Accion) {
			imagen=new Image(display, clas.getResourceAsStream("Imagen accion.png"));
		}
		else if(type==Comandos.While) {
			imagen=new Image(display, clas.getResourceAsStream("While.png"));
		}
		else if(type==Comandos.If) {
			imagen=new Image(display, clas.getResourceAsStream("CondicionIf.png"));
		}
		result.setBackgroundImage(imagen);
		result.setMenu(menu);
		return result;
		
	}

}
