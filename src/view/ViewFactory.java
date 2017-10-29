package view;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import view.Comandos;
public class ViewFactory {
	public static Display displayR;
	/*
	 * clas siempre es el mismo
	 * comando es el tipo del enum creado
	 * el canvas será el mismo siempre
	 * el name, es el texto del label
	 * y x y Y con las posiciones respectivas
	 * me retorna un label configurado, ya con posicion, texto, menu e imagen correspondiente
	 */
	public static Class<? extends EView> clase = null;
	public static Labels getGrafic(Class<? extends EView> clas,Comandos type,Canvas parent,String name) {
		Display display = Display.getCurrent();
		clase = clas;
		displayR=display;
		Labels result=new Labels(parent,null, type);
		Menu menu=new Menu(result.label);
		MenuItem step=new MenuItem(menu, SWT.PUSH);
		step.setText("Abrir...");
		 step.addListener(SWT.Selection, new Listener()
		    {
		        @Override
		        public void handleEvent(Event event)
		        {
		        	Labels.debuggerImage(result);
		        }
		        
		    });
		result.parent=parent;
		if(type==Comandos.For) {
			result.image=new Image(display, clas.getResourceAsStream("For.png"));
			result.imageB=new Image(display, clas.getResourceAsStream("ForB.png"));
		}
		else if(type==Comandos.Accion) {
			result.image=new Image(display, clas.getResourceAsStream("Imagen accion.png"));
			result.imageB=new Image(display, clas.getResourceAsStream("Imagen accionB.png"));
			result.label.setMenu(menu);
		}
		else if(type==Comandos.While) {
			result.image=new Image(display, clas.getResourceAsStream("While.png"));
			result.imageB=new Image(display, clas.getResourceAsStream("WhileB.png"));

		}
		else if(type==Comandos.If) {
			result.image=new Image(display, clas.getResourceAsStream("CondicionIf.png"));
			result.imageB=new Image(display, clas.getResourceAsStream("CondicionIfB.png"));
		}
		else if(type == Comandos.Return) {
			result.image=new Image(display, clas.getResourceAsStream("CondicionIf.png"));
			result.imageB=new Image(display, clas.getResourceAsStream("CondicionIfB.png"));
		}
		result.label.setText("\n"+name);
		result.label.setBackgroundImage(result.image);
		return result;
		
	}

}
